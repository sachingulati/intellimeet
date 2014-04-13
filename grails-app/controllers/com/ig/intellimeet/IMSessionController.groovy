package com.ig.intellimeet



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class IMSessionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond IMSession.list(params), model:[IMSessionInstanceCount: IMSession.count()]
    }

    def show(IMSession IMSessionInstance) {
        respond IMSessionInstance
    }

    def create() {
        respond new IMSession(params)
    }

    @Transactional
    def save(IMSession IMSessionInstance) {
        if (IMSessionInstance == null) {
            notFound()
            return
        }

        if (IMSessionInstance.hasErrors()) {
            respond IMSessionInstance.errors, view:'create'
            return
        }

        IMSessionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'IMSessionInstance.label', default: 'IMSession'), IMSessionInstance.id])
                redirect IMSessionInstance
            }
            '*' { respond IMSessionInstance, [status: CREATED] }
        }
    }

    def edit(IMSession IMSessionInstance) {
        respond IMSessionInstance
    }

    @Transactional
    def update(IMSession IMSessionInstance) {
        if (IMSessionInstance == null) {
            notFound()
            return
        }

        if (IMSessionInstance.hasErrors()) {
            respond IMSessionInstance.errors, view:'edit'
            return
        }

        IMSessionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'IMSession.label', default: 'IMSession'), IMSessionInstance.id])
                redirect IMSessionInstance
            }
            '*'{ respond IMSessionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(IMSession IMSessionInstance) {

        if (IMSessionInstance == null) {
            notFound()
            return
        }

        IMSessionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'IMSession.label', default: 'IMSession'), IMSessionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'IMSessionInstance.label', default: 'IMSession'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
