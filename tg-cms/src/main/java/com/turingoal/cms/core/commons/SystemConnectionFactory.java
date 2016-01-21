package com.turingoal.cms.core.commons;

import java.sql.SQLException;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.turingoal.common.util.io.PropsUtil;

/**
 * 获取连接池
 */
public final class SystemConnectionFactory {
    private final DataSource dataSource;
    private static String propFileName = "application.properties";
    private static final Integer INITIAL_SIZE = 5;
    private static final Integer MIN_IDLE = 5;

    /**
     * 实例化，单例模式
     */
    private interface Singleton {
        SystemConnectionFactory INSTANCE = new SystemConnectionFactory();
    }

    private SystemConnectionFactory() {
        DruidDataSource ds = new DruidDataSource();
        ds = new DruidDataSource();
        ds.setDriverClassName(PropsUtil.getValue("db.driver", propFileName)); // 驱动
        ds.setUsername(PropsUtil.getValue("db.username", propFileName)); // 数据库连接用户名
        ds.setPassword(PropsUtil.getValue("db.password", propFileName)); // 数据库连接密码
        ds.setUrl(PropsUtil.getValue("db.url", propFileName)); // 数据库连接url
        ds.setValidationQuery(PropsUtil.getValue("db.validationQuery", propFileName)); // 数据库validationQuery
        ds.setInitialSize(INITIAL_SIZE); // 初始化大小
        ds.setMinIdle(MIN_IDLE);
        try {
            ds.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.dataSource = ds;
    }

    /**
     * 获取数据库连接
     */
    public static DataSource getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource;
    }
}
