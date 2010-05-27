

/**
 * Request Map domain class.
 */
class Permissao {

	String url
	String configAttribute

	static constraints = {
		url(blank: false, unique: true)
		configAttribute(blank: false)
	}
}
