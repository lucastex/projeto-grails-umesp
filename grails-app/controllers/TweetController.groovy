class TweetController {
	
	def index = {
		
		def tweets = UmespTweet.findAll([max:50, offset:0, sort:'data', order:'desc'])
		def total = UmespTweet.count()
		
		[tweets:tweets, total:total]
	}
	
	def delete = {
		
		def tweets = UmespTweet.findAll()
		def size = tweets.size()
		
		tweets.each { tw ->
			tw.delete()
		}
		
		render "${size} deletados"
	}
}