package com.rz.framework.helper;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by as on 2018/2/4.
 */
public final class DatabaseHelper {

    private static final ThreadLocal<Connection> CONNECTION_HOLDER;
    private static final DruidDataSource DATASOURCE;

    static {
        CONNECTION_HOLDER = new ThreadLocal<>();
        DATASOURCE = new DruidDataSource();
        DATASOURCE.setUrl(ConfigHelper.getJDBCURL());
        DATASOURCE.setDriverClassName(ConfigHelper.getJDBCDriver());
        DATASOURCE.setUsername(ConfigHelper.getJDBCUsername());
        DATASOURCE.setPassword(ConfigHelper.getJDBCPassword());
    }

    /**
     * 开启事务
     */
    public static void beginTransaction() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(connection);
            }
        }

    }

    public static void commitTransaction() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.commit();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }
    public static void rollbackTransaction() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }

    public static Connection getConnection() {
        Connection connection = CONNECTION_HOLDER.get();
        if (connection == null) {
            try {
                connection = DATASOURCE.getConnection();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(connection);
            }
        }

        return connection;
    }

}
