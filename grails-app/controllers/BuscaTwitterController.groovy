class BuscaTwitterController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [buscaTwitterInstanceList: BuscaTwitter.list(params), buscaTwitterInstanceTotal: BuscaTwitter.count()]
    }

    def create = {
        def buscaTwitterInstance = new BuscaTwitter()
        buscaTwitterInstance.properties = params
        return [buscaTwitterInstance: buscaTwitterInstance]
    }

    def save = {
        def buscaTwitterInstance = new BuscaTwitter(params)
        if (buscaTwitterInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'buscaTwitter.label', default: 'BuscaTwitter'), buscaTwitterInstance.id])}"
            redirect(action: "show", id: buscaTwitterInstance.id)
        }
        else {
            render(view: "create", model: [buscaTwitterInstance: buscaTwitterInstance])
        }
    }

    def show = {
        def buscaTwitterInstance = BuscaTwitter.get(params.id)
        if (!buscaTwitterInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'buscaTwitter.label', default: 'BuscaTwitter'), params.id])}"
            redirect(action: "list")
        }
        else {
            [buscaTwitterInstance: buscaTwitterInstance]
        }
    }

    def edit = {
        def buscaTwitterInstance = BuscaTwitter.get(params.id)
        if (!buscaTwitterInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'buscaTwitter.label', default: 'BuscaTwitter'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [buscaTwitterInstance: buscaTwitterInstance]
        }
    }

    def update = {
        def buscaTwitterInstance = BuscaTwitter.get(params.id)
        if (buscaTwitterInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (buscaTwitterInstance.version > version) {
                    
                    buscaTwitterInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'buscaTwitter.label', default: 'BuscaTwitter')] as Object[], "Another user has updated this BuscaTwitter while you were editing")
                    render(view: "edit", model: [buscaTwitterInstance: buscaTwitterInstance])
                    return
                }
            }
            buscaTwitterInstance.properties = params
            if (!buscaTwitterInstance.hasErrors() && buscaTwitterInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'buscaTwitter.label', default: 'BuscaTwitter'), buscaTwitterInstance.id])}"
                redirect(action: "show", id: buscaTwitterInstance.id)
            }
            else {
                render(view: "edit", model: [buscaTwitterInstance: buscaTwitterInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'buscaTwitter.label', default: 'BuscaTwitter'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def buscaTwitterInstance = BuscaTwitter.get(params.id)
        if (buscaTwitterInstance) {
            try {
                buscaTwitterInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'buscaTwitter.label', default: 'BuscaTwitter'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'buscaTwitter.label', default: 'BuscaTwitter'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'buscaTwitter.label', default: 'BuscaTwitter'), params.id])}"
            redirect(action: "list")
        }
    }
}
