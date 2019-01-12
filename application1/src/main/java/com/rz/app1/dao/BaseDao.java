package com.rz.app1.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.rz.framework.helper.DatabaseHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by as on 2018/2/14.
 */
public class BaseDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);
    public static final QueryRunner QUERY_RUNNER = new QueryRunner();

    public static Connection getConnection() {
        return DatabaseHelper.getConnection();
    }

    /**
     * 单表的查询，映射为list集合
     *
     * @param entityClass 实体的类型
     * @param sql         查询语句
     * @param params      参数
     * @param <T>
     * @return
     */
    public <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {

        List<T> entityList = null;
        try {
            entityList = QUERY_RUNNER.query(getConnection(), sql, new BeanListHandler<T>(entityClass), params);

        } catch (SQLException e) {
            LOGGER.error("query entity list failure", e);
            throw new RuntimeException(e);
        }
        return entityList;
    }

    /**
     * 单表的个体查询
     *
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
        T entity = null;
        try {
            entity = QUERY_RUNNER.query(getConnection(), sql, new BeanHandler<T>(entityClass), params);
        } catch (SQLException e) {
            LOGGER.error("query entity failure", e);
            throw new RuntimeException(e);
        }
        return entity;
    }

    public List<Map<String, Object>> executeQuery(String sql, Object... params) {
        List<Map<String, Object>> result = null;
        try {
            result = QUERY_RUNNER.query(getConnection(), sql, new MapListHandler(), params);
        } catch (SQLException e) {
            LOGGER.error("query entity failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }
}
