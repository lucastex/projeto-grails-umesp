<html>
    <head>
        <title>UMESP Grails</title>
		<meta name="layout" content="main" />
		<meta http-equiv="refresh" content="2" />
		<style>
			.tweet {
				margin-bottom:15px;
				background-color: #DDDDDD;
				border: 1px solid #990000;
			}
			
			.barra {
				text-align:center;
				list-style-type: none;		
				text-transform: uppercase;
				margin-bottom: 30px;
				color: red;	
			}
		</style>
    </head>
    <body>
	
		<ul class="barra">
			<li>
				<g:link controller="tweet" action="index">recarregar</g:link> - 
				<g:link controller="tweet" action="delete">limpar</g:link>
			</li>
			<li>total (${total})</li>
		</ul>

		<g:each in="${tweets}" var="tweet">
			<div class="tweet">
				<g:formatDate date="${tweet.data}" format="dd/MM/yyyy HH:mm:ss" /> - <b>${tweet.usuario}</b> - ${tweet.texto}
			</div>
		</g:each>
		
    </body>
</html>