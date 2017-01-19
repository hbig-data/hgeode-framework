package com.ryan.geode.test.region;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionAttributes;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2017/1/19 11:55.
 */
public class RegionTestCase {
    public static final Logger LOG = LoggerFactory.getLogger(RegionTestCase.class);


    private String host = "localhost";
    private String port = "10334";

    private ClientCache cache = null;

    @Before
    public void setUp() throws Exception {

        ClientCacheFactory cacheFactory = new ClientCacheFactory();
//        cacheFactory.addPoolLocator("localhost", 10334);
        cacheFactory.addPoolServer("localhost", 10334);
        cache = cacheFactory.create();

    }

    @After
    public void tearDown() throws Exception {
        if(null != cache){
            cache.close(true);
        }
    }

    @Test
    public void testCreateRegion() throws Exception {

        Region<String, String> region = cache.<String, String>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY).create("region");

        RegionAttributes<String, String> attributes = region.getAttributes();


        String diskStoreName = attributes.getDiskStoreName();


    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testPutData() throws Exception {
        Region<String, String> region = cache.<String, String>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY).create("region");

        region.put("1", "Hello");
        region.put("2", "World");

        for (Map.Entry<String, String> entry : region.entrySet()) {
            System.out.format("key = %s, value = %s\n", entry.getKey(), entry.getValue());
        }

    }
}
