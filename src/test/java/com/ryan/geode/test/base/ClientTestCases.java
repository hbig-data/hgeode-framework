package com.ryan.geode.test.base;

import org.apache.geode.cache.query.Query;
import org.apache.geode.cache.query.QueryService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/9/26 10:43.
 */
public class ClientTestCases extends BaseTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(ClientTestCases.class);


    /**
     * 数据查询
     *
     * @throws Exception
     */
    @Test
    public void testQueryData() throws Exception {
        QueryService localQueryService = userCache.getLocalQueryService();

        Query query = localQueryService.newQuery("select * from /region1");
        Object execute = query.execute();

        LOG.info("{}", execute);

    }
}
