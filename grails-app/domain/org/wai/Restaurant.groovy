package org.wai

import groovy.transform.ToString

@ToString(includes='name')
class Restaurant {

    static mapWith = "neo4j"

    static belongsTo = Owner

    String name

    static constraints = {
    }
}
