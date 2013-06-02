package org.wai

import groovy.transform.ToString

@ToString(includes='name')
class Owner {

    String name
    static hasMany = [ owns: Restaurant ]


    static constraints = {
    }
}
