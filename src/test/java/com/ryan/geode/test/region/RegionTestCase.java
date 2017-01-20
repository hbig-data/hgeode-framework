package com.ryan.geode.test.region;

import org.apache.geode.cache.*;
import org.apache.geode.cache.query.Query;
import org.apache.geode.cache.query.SelectResults;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/1/20 16:49.
 */
public class RegionTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(RegionTestCase.class);

    private Cache cache = null;

    @Before
    public void setUp() throws Exception {
        Properties properties = new Properties();


        cache = new CacheFactory().create();
    }

    @After
    public void tearDown() throws Exception {
        if (!cache.isClosed()) {
            cache.close();
        }
    }

    /**
     * Create a region using any of the following methods
     *
     * @throws Exception
     */
    @Test
    public void testCreateRegion() throws Exception {

        PartitionAttributes pa = new PartitionAttributesFactory()
                .setRedundantCopies(1)
                .setLocalMaxMemory(1240)
                .create();

        RegionFactory rf = cache.createRegionFactory(RegionShortcut.PARTITION_PROXY_REDUNDANT).setPartitionAttributes(pa);
        Region region = rf.create("region1");



    }
}
