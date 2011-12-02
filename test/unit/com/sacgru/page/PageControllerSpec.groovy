package com.sacgru.page

import grails.plugin.spock.ControllerSpec

//@TestFor(PageController)
//@Mock(Page)
class PageControllerSpec extends ControllerSpec {

    def "create method"() {
        mockDomain(Page)

        when:
        
            controller.create()

        then:
            
            mock == '/page/create'
    }

    def "index method page doesn't exist"() {
        mockDomain(Page)

        when:

            controller.index()

        then:

            mockResponse.redirectedUrl == '/page/create'
    }
    
    def "index method page exists"() {
        mockDomain(Page)
        
        given:
            String title = "pagey"
            new Page(title:title, content: "blah").save()
            mockParams.title = "pagey"

        when:

            controller.index()

        then:

            mockResponse.redirectedUrl == '/page/$title'
    }
}
