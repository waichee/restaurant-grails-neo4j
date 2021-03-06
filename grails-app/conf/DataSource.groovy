grails {
    neo4j {
        // define a Neo4j datasource
        // type is either "embedded", "rest", "ha", or any custom class implementing GraphDatabaseService

        // 1) embedded
        // when using embedded, Neo4j runs inside the same JVM like the Grails application
        // options:
        // location: the path where Neo4j is stored, defaults to "data/neo4j"
        // params: optional map passed to EmbeddedGraphDatabase
        type = "embedded"
        // location = "data/neo4j"
        params = [ enable_remote_shell : true]

        // 2) rest
        // when using a Neo4j server via rest REST uncomment the following line
        // type = "rest"
        // options:
        // location: URL of rest server, defaults to http://localhost:7474/db/data/
        // NB: if heroku is used just omit location, the plugin tries to use env.NEO4J_URL in this case
        // NB: params are not allowed when using REST

        // type="rest
        // location = "http://localhost:7474/db/data/"

        // 3) HA embedded
        // use a in-JVM Neo4j instance being part of a HA cluster
        // options:
        // location: directory where Neo4j stores the db
        // options: parameters for HA setup, see http://docs.neo4j.org/chunked/stable/ha-configuration.html#_installation_notes
        // type = "ha"
        // location = "data/neo4j"
        // params = [
        //    ha.server_id = 1
        //    ha.coordinators = " localhost:2181,localhost:2182,localhost:2183"
        // ]

    }

    hibernate {
        cache.use_second_level_cache = true
        cache.use_query_cache = false
        cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
    }

    dataSource {
        pooled = true
        driverClassName = "org.h2.Driver"
        username = "sa"
        password = ""
    }
    // environment specific settings
    environments {
        development {
            dataSource {
                dbCreate = "create" // one of 'create', 'create-drop','update'
                url = "jdbc:h2:mem:devDB"
            }
        }
        test {
            dataSource {
                dbCreate = "update"
                url = "jdbc:h2:mem:testDb"
            }
        }
        production {
            dataSource {
                dbCreate = "update"
                url = "jdbc:h2:file:~/.h2" //or any other path
            }
        }
    }
}