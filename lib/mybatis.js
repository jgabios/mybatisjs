/**
 * @fileOverview mybatis.
 */

addToClasspath(module.resolve('../jars/postgresql.jar'));
addToClasspath(module.resolve('../jars/mybatis-3.1.0.jar'));
addToClasspath(module.resolve('../jars/mybatishelper.jar'));

var MyBatisSQLSessionFactory = Packages.ro.jlin.mybatis.MyBatisSQLSessionFactory;
exports.SqlSessionFactory = MyBatisSQLSessionFactory.getSqlSessionFactory();
