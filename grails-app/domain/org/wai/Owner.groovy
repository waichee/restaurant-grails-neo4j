package org.wai

import groovy.transform.ToString

@ToString(includes='name')
class Owner {

    static mapWith = "neo4j"

    String name
    static hasMany = [ owns: Restaurant ]


    static constraints = {
    }
}
