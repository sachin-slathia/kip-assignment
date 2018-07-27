package com.knoldus


import twitter4j.{Twitter, TwitterException, TwitterFactory}
import twitter4j.conf.ConfigurationBuilder


class twitterAnalysis {


  @throws[TwitterException]
  def createTweet(tweet: String): String = {
    val twitter = getTwitterinstance
    val status = twitter.updateStatus("creating baeldung API")
    status.getText
  }

  def getTwitterinstance: Twitter = {

    val cb = new ConfigurationBuilder
    cb.setDebugEnabled(true).setOAuthConsumerKey("U4vRNr1ZCY7jCnDCsEzaOqKgH")
      .setOAuthConsumerSecret("mE0pCdTUcsnATZrResDAb5by79X4tvrZXGJmJbCS48ILSKwsBR")
      .setOAuthAccessToken("723372793270665217-cD2bicHmEKovD0uYk80z3IOEh8TAeOQ")
      .setOAuthAccessTokenSecret("zn8toS7lkOBXDlbIHX3RwdCkZNR1E5EGqvzkEStL8bSW7")

        val tf = new TwitterFactory(cb.build)
        val twitter = tf.getInstance()
        twitter

  }

  @throws[TwitterException]
  def sendDirectMessage(recipientName: String, msg: String): String = {
    val twitter = getTwitterinstance
    val message = twitter.sendDirectMessage(recipientName, msg)
    message.getText
  }
  def searchQuery(): Unit =
  {
    val config=getTwitterinstance()
    val tf = new TwitterFactory(config.build)
    val twitter = tf.getInstance
    val statuses: util.List[Status] = twitter.search(new Query("#apple")).getTweets

    println("Tweetes Found :" + statuses.size)

    for(status:Status <- statuses) println(status.getText+"\n\n")


  }
}

/*
import java.util
import collection.JavaConversions._
import twitter4j.conf.ConfigurationBuilder
import twitter4j.TwitterFactory
import twitter4j.Query
import twitter4j.Status

object Twitter extends App {

val config = new ConfigurationBuilder
config.setDebugEnabled(true)
.setOAuthConsumerKey("U4vRNr1ZCY7jCnDCsEzaOqKgH")
.setOAuthConsumerSecret("mE0pCdTUcsnATZrResDAb5by79X4tvrZXGJmJbCS48ILSKwsBR")
.setOAuthAccessToken("723372793270665217-cD2bicHmEKovD0uYk80z3IOEh8TAeOQ")
.setOAuthAccessTokenSecret("zn8toS7lkOBXDlbIHX3RwdCkZNR1E5EGqvzkEStL8bSW7")

val tf = new TwitterFactory(config.build)
val twitter = tf.getInstance
val statuses: util.List[Status] = twitter.search(new Query("#oneplus")).getTweets

println("Tweetes Found :" + statuses.size)

for(status:Status <- statuses) println(status.getText+"\n\n")

}



*/




