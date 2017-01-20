package com.ryan.geode.test.region;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.query.Query;
import org.apache.geode.cache.query.QueryService;
import org.apache.geode.cache.query.SelectResults;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2017/1/19 11:55.
 */
public class DataRegionTestCase {
    public static final Logger LOG = LoggerFactory.getLogger(DataRegionTestCase.class);


    private String host = "localhost";
    private int port1 = 40405;
    private int port2 = 40404;
    private int port3 = 40413;

    private ClientCache cache = null;

    @Before
    public void setUp() throws Exception {
        ClientCacheFactory cacheFactory = new ClientCacheFactory();
        cacheFactory.addPoolServer(host, port1);
        cacheFactory.addPoolServer(host, port2);

        cache = cacheFactory.create();
    }


    @After
    public void tearDown() throws Exception {
        if (null != cache) {
            cache.close(true);
        }
    }




    /**
     * 往分区中存入数据
     *
     * @throws Exception
     */
    @Test
    public void testPutData() throws Exception {
        Region<String, String> region = cache.<String, String>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY_HEAP_LRU).create("regionA");

        UUID uuid = UUID.randomUUID();
        for (int i = 0; i < 100000; i++) {
            region.put(i + "", uuid.randomUUID().toString().replaceAll("-", ""));
        }

        for (Map.Entry<String, String> entry : region.entrySet()) {
            System.out.format("key = %s, value = %s\n", entry.getKey(), entry.getValue());
        }

        region.writeToDisk();
    }

    /**
     * 查询数据
     *
     * @throws Exception
     */
    @Test
    public void testQueryData() throws Exception {

        QueryService queryService = cache.getQueryService();
        Query query = queryService.newQuery("select * from /regionA");
        SelectResults execute = (SelectResults) query.execute();

        List list = execute.asList();
        for (Object o : list) {
            System.err.println(o);
        }


    }

    /**
     * 删除数据
     *
     * @throws Exception
     */
    @Test
    public void testRemoveData() throws Exception {
        Region<String, String> region = cache.<String, String>createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY_HEAP_LRU).create("regionA");

        for (int i = 0; i < 100000; i++) {

            region.remove(i + "");
        }
    }
}
