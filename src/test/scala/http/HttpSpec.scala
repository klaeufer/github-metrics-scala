package edu.luc.etl.cs313.scala.clickcounter.service.http

import org.specs2.mutable._
import dispatch._, Defaults._

class HttpSpec extends Specification {

  val serviceRoot = "http://private-14b8e-clickcounter.apiary-mock.com/"

  "The click counter service, with respect to its collection of counters," should {

    "return the newly created counter" in {
      todo
    }

    "retrieve an existing counter" in {
      todo
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
      todo
    }

    "reset the counter" in {
      todo
    }

    "return the counter value" in {
      val response = Http(url(serviceRoot + "counters/123/value") OK as.String)
      response().toInt === 3
    }

    "retrieve a counter value stream" in {
      todo
    }

  }
}
