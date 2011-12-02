package com.sacgru.page

class PageController {

    def xwikiRenderer

    def index() {
        if(!params.title){
            redirect(controller: 'page', action: 'create', params: params)
        }
        Page page = Page.findByTitle(params.title)
        if ( !page ){
            redirect(controller: 'page', action: 'create', params: params)
        } else {
            render xwikiRenderer.render(page.content, "mediawiki/1.0", "xhtml/1.0")
        }
    }

    def create() {

        [page: new Page(title: params.title), ]
    }
    
    def edit() {
        [page: Page.get(params.id)]
    }
    
    def save(){
        log.error "In save, params: $params"
        
        Page page = new Page(params)
                
        if(!page.save()){
            render(action: 'create', model:[page:page])
        }else {
            redirect(action:index(), params: params)    
        }
    }

        
}
