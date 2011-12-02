package com.sacgru.page

class Page {
    
    String content
    String title

    static constraints = {
        content maxSize: 1024 * 1024, nullable: false
        title nullable: false
    }
}
