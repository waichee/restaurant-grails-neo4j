package org.wai

import groovy.transform.ToString

@ToString(includes='name')
class Restaurant {

    static belongsTo = Owner

    String name

    static constraints = {
    }
}
