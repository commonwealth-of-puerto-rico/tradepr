
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    development {
        dataSource {
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
            dbCreate = "update"
            //On AppFog
            url = System.env['JDBC_CONNECTION_STRING'];        }
    }
    test {
        dataSource {
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
            dbCreate = "update"
            //On AppFog
            url = System.env['JDBC_CONNECTION_STRING'];        }
    }
    production {
        dataSource {
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
            dbCreate = "update"
            //On AppFog
            url = System.env['JDBC_CONNECTION_STRING'];
        }
    }
}
