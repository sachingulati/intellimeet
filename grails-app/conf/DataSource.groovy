dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = "igdefault"
}
grails {
    mongo {
        host = "localhost"
        port = 27017
        username = ""
        password = ""
        databaseName = "intellimeet"
    }
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/intellimeet"
        }
    }
    qa {
        dataSource {
            dbCreate = "create-drop"
            url = "jdbc:mysql://localhost:3306/intellimeet"
        }
    }
    production {
        String mongoURL = System.getenv("MONGOLAB_URI")
        if (mongoURL) {
            URI mongoDBURI = new URI(mongoURL);
            String mongoUsername = mongoDBURI.userInfo.split(":")[0]
            String mongoPassword = mongoDBURI.userInfo.split(":")[1]
            String dbPath = mongoDBURI.path
            dbPath = dbPath.substring(1, dbPath.size())
            grails {
                mongo {
                    host = mongoDBURI.host
                    port = mongoDBURI.port
                    username = mongoUsername
                    password = mongoPassword
                    databaseName = dbPath
                }
            }
        }

        dataSource {
//            logSql = Utils.getenv("hibernate_log_sql", "false").toBoolean()
            dbCreate = "update" // one of 'create', 'create-drop','update'
            String mysqlUrl = System.getenv("CLEARDB_DATABASE_URL")
            if (mysqlUrl) {
                URI dbUri = new URI(mysqlUrl);
                username = dbUri.userInfo.split(":")[0]
                password = dbUri.userInfo.split(":")[1]
                String databaseUrl = "jdbc:${dbUri.scheme}://${dbUri.host}${dbUri.path}"
                if (dbUri.port > 0) {
                    databaseUrl += ":${dbUri.port}"
                }
                String query = dbUri.query ?: "reconnect=true"
                query += "&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8"
                databaseUrl += "?${query}"
                url = databaseUrl
            }


            properties {
                // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
                jmxEnabled = true
                initialSize = 5
                maxActive = 10
                minIdle = 5
                maxIdle = 10
                maxWait = 10000
                maxAge = 10 * 60000
                timeBetweenEvictionRunsMillis = 5000
                minEvictableIdleTimeMillis = 60000
                validationQuery = "SELECT 1"
                validationQueryTimeout = 3
                validationInterval = 15000
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                jdbcInterceptors = "ConnectionState"
                defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
}
