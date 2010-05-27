class BuscaTwitter {
	
	String palavra
	String idioma
	Integer quantidade
	Long ultimoTweet
	
	static constraints = {
		ultimoTweet(nullable:true, blank:true)
	}
}