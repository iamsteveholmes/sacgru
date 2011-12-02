package com.sacgru.page

import grails.plugin.spock.UnitSpec

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
//@TestFor(Page)
class PageSpec extends UnitSpec{

    def "Both values should contain Strings"(){
        mockDomain(Page)
        
        expect:
            
            new Page(content:content,title: title ).save()
            result == !page.hasErrors()
        
        where:

            content |   title   |   result

            "Hello" |   "Blah"  |   true
            null    |   "Blah"  |   false
            "Hello" |   null    |   false
    }
}
