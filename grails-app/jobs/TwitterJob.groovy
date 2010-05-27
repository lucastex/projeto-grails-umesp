import twitter4j.*

class TwitterJob {
	
	def timeout = 5000l
	def concurrent = false
	
	def execute() {
		
		println "iniciando captura dos tweets..."
		
		def buscas = BuscaTwitter.findAll()
		buscas.each { busca ->
			
			println "buscando por ${busca.palavra}/${busca.idioma}/${busca.quantidade} desde ${busca.ultimoTweet}"
			
			def newSinceId
			def twitter = new TwitterFactory().getInstance()
	    	def query = new Query(busca.palavra).rpp(busca.quantidade)
			if (busca.idioma)
				query = query.lang(busca.idioma)
				
			if (busca.ultimoTweet) {
				query.sinceId = busca.ultimoTweet
			}
			def result = twitter.search(query)
			println "encontrou ${result.tweets.size()}"
	    	result.tweets.each { tweet -> 
		
				println "-> ${tweet.createdAt} - ${tweet.fromUser} - ${tweet.text}"
				
				def tw = new UmespTweet()
				tw.data = tweet.createdAt
				tw.usuario = tweet.fromUser
				tw.avatarUsuario = tweet.profileImageUrl
				tw.texto = tweet.text
				tw.save()
				
				if (!newSinceId) 
					newSinceId = tweet.id
			}
			
			if (newSinceId) {
				busca.ultimoTweet = newSinceId
				busca.save()
			}
			println "-"
		}
	}
}