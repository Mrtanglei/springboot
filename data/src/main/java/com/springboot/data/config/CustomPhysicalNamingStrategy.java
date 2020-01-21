package com.springboot.data.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

/**
 * @author tanglei
 * @date 2020/1/20
 */
public class CustomPhysicalNamingStrategy extends SpringPhysicalNamingStrategy {

    private static final String TABLE_PREFIX = "jpa_";

    /**
     * 自定义数据库表与实体注解中的表名规范，此处为注解中的表名前增加jpa_前缀
     *
     * @param name
     * @param jdbcEnvironment
     * @return
     */
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return super.toPhysicalTableName(new Identifier(TABLE_PREFIX + name.getText(), name.isQuoted()),
                jdbcEnvironment);
    }
}