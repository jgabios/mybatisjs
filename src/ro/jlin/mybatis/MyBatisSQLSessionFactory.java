package ro.jlin.mybatis;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * example how to start a ringojs webapp with SQL_MAP_RESOURCE_PATH property
 * ringo -m ./ -b boot.js -D SQL_MAP_RESOURCE_PATH=mybatis-main.xml main.js
 */
public class MyBatisSQLSessionFactory {

    protected static final SqlSessionFactory FACTORY;

    static {
        try {
            Reader reader = Resources.getResourceAsReader(System.getProperty("SQL_MAP_RESOURCE_PATH"));
            FACTORY = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e){
            throw new RuntimeException("Fatal Error.  Cause: " + e, e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return FACTORY;
    }
}
