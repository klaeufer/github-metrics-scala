package edu.luc.etl.cs313.scala.clickcounter.service.http

import org.specs2.matcher.JsonMatchers
import org.specs2.mutable._
import dispatch._, Defaults._

class HttpSpec extends Specification with JsonMatchers {

  val serviceRoot = host("private-14b8e-clickcounter.apiary-mock.com")

  "The click counter service, with respect to its collection of counters," should {

    "return the newly created counter" in {
      todo
    }

    "retrieve an existing counter" in {
      val request = serviceRoot / "counters" / "123"
      val response = Http(request OK as.String)
      val counter = response()
      counter must / ("id" -> haveClass[String])
      counter must / ("value" -> (be_>=(0.0) ^^ ((_: String).toDouble)))
      counter must / ("state" -> beOneOf("empty", "counting", "full"))
    }

    "delete an existing counter" in {
      todo
    }
  }

  "The click counter service, with respect to a specific counter," should {

    "increment the counter" in {
      todo
    }

    "refuse to decrement the counter" in {
      val request = serviceRoot / "counters" / "123" / "decrement"
      val response = Http(request.POST)
      val status = response().getStatusCode
      status must beOneOf(200, 409)
    }

    "reset the counter" in {
      todo
    }

    "return the counter value" in {
      val request = serviceRoot / "counters" / "123" / "value"
      val response = Http(request OK as.String)
      response().toInt === 3
    }

    "retrieve a counter value stream" in {
      todo
    }

  }
}
