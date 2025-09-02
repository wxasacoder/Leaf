package com.sankuai.inf.leaf.segment;

import com.sankuai.inf.leaf.IDGen;
import com.sankuai.inf.leaf.common.PropertyFactory;
import com.sankuai.inf.leaf.common.IdResult;
import com.sankuai.inf.leaf.segment.dao.IDAllocDao;
import com.sankuai.inf.leaf.segment.dao.impl.IDAllocDaoImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

public class IDGenServiceTest {
    IDGen idGen;
    HikariDataSource dataSource;
    @Before
    public void before() {
        // Load Db Config
        Properties properties = PropertyFactory.getProperties();

        // Config dataSource
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(properties.getProperty("jdbc.url"));
        hikariConfig.setUsername(properties.getProperty("jdbc.username"));
        hikariConfig.setPassword(properties.getProperty("jdbc.password"));
        dataSource = new HikariDataSource();

        // Config Dao
        IDAllocDao dao = new IDAllocDaoImpl(dataSource);

        // Config ID Gen
        idGen = new SegmentIDGenImpl();
        ((SegmentIDGenImpl) idGen).setDao(dao);
        idGen.init();
    }
    @Test
    public void testGetId() {
        for (int i = 0; i < 100; ++i) {
            IdResult r = idGen.get("leaf-segment-test");
            System.out.println(r);
        }
    }
    @After
    public void after() {
       dataSource.close();
    }

}
