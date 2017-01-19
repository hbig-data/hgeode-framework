package com.ryan.geode.test.base;

import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.junit.After;
import org.junit.Before;

import java.util.Properties;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/9/26 11:41.
 */
public class BaseTestCase {

    protected ClientCache userCache = null;

    @Before
    public void setUp() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("log-level", "warning");
        properties.setProperty("name", "testMember2");

        userCache = new ClientCacheFactory(properties).create();

    }

    @After
    public void tearDown() throws Exception {
        if(null != userCache) {
            userCache.close(true);
            userCache.getDefaultPool().destroy();
        }

    }
}
