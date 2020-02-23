package com.wzh.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory factory;

    // 静态初始代码块，书写只需要执行一次的操作， 静态代码块中的代码只在类加载的时候执行一次
    static {
        InputStream in = null;
        try {
            // 读取核心配置文件 mybatis-config.xml
            in = Resources.getResourceAsStream("mybatis-config.xml");
            // 创建SqlSessionFactory
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException("初始化工厂失败！~");
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    // 创建一个线程绑定对象
    private static ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();

    // 返回一个SqlSession
    public static SqlSession openSession() {
        // 先到当前线程取一下
        SqlSession sqlSession = tol.get();
        if (sqlSession == null) {
            // 创建SqlSession
            sqlSession = factory.openSession();
            // 绑定到当前线程
            tol.set(sqlSession);
        }
        return sqlSession;
    }

    public static <T> T getMapper(Class<T> paramClass) {
        SqlSession sqlSession = tol.get();
        if (sqlSession == null) {
            // 创建SqlSession
            sqlSession = factory.openSession();
            // 绑定到当前线程
            tol.set(sqlSession);
        }
        T mapper = sqlSession.getMapper(paramClass);
        return mapper;
    }

    // 释放资源
    public static void close() {
        SqlSession sqlSession = tol.get();
        if (sqlSession != null) {
            sqlSession.close();
            tol.remove();// 从当前线程移除
        }
    }

    // 提交事务
    public static void commit() {
        SqlSession sqlSession = tol.get();
        if (sqlSession != null) {
            sqlSession.commit();
        }
    }

    // 回滚事务
    public static void rollback() {
        SqlSession sqlSession = tol.get();
        if (sqlSession != null) {
            sqlSession.rollback();
        }
    }
}
