package com.sacgru.page

class PageController {

    def xwikiRenderer

    def index() {
        println "Printlns work"
        /*if(!params.title){
            redirect(controller: 'page', action: 'create', params: params)
        }*/
        Page page = Page.findByTitle(params.title)
        if ( !page ){
            render(view: 'create', model: [page: new Page(title: params.title)])
            //redirect(controller: 'page', action: 'create', params: params)
        } else {
            render xwikiRenderer.render(page.content, "xwiki/2.1", "xhtml/1.0")
        }
    }
    
    
    def save(){
        println "In save, params: ${params}"
        
        Page page = new Page(params)
                
        if(!page.save()){
            render(view: 'create', model:[page:page])
        }else {
            redirect(uri: "/page/${page.title}")
        }
    }

    def edit() {
        [page: Page.findByTitle(params.title)]
    }
    
    def update(){
        Page page = Page.findByTitle(params.title)
        page.content = params.content
        if ( !page.save() ){
            render(view: 'edit', model: [page:page])
        } else {
            redirect(uri: "/page/${page.title}")
            //render xwikiRenderer.render(page.content, "mediawiki/1.0", "xhtml/1.0")
        }
    }

        
}
