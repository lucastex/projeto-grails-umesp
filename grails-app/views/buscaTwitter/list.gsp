

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'buscaTwitter.label', default: 'BuscaTwitter')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'buscaTwitter.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="ultimoTweet" title="${message(code: 'buscaTwitter.ultimoTweet.label', default: 'Ultimo Tweet')}" />
                        
                            <g:sortableColumn property="quantidade" title="${message(code: 'buscaTwitter.quantidade.label', default: 'Quantidade')}" />
                        
                            <g:sortableColumn property="palavra" title="${message(code: 'buscaTwitter.palavra.label', default: 'Palavra')}" />
                        
                            <g:sortableColumn property="idioma" title="${message(code: 'buscaTwitter.idioma.label', default: 'Idioma')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${buscaTwitterInstanceList}" status="i" var="buscaTwitterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${buscaTwitterInstance.id}">${fieldValue(bean: buscaTwitterInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: buscaTwitterInstance, field: "ultimoTweet")}</td>
                        
                            <td>${fieldValue(bean: buscaTwitterInstance, field: "quantidade")}</td>
                        
                            <td>${fieldValue(bean: buscaTwitterInstance, field: "palavra")}</td>
                        
                            <td>${fieldValue(bean: buscaTwitterInstance, field: "idioma")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${buscaTwitterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
