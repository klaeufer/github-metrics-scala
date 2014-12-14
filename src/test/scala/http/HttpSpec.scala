package edu.luc.etl.cs313.scala.clickcounter.service.http

import org.specs2.mutable._
import dispatch._, Defaults._

class HttpSpec extends Specification {

  val serviceRoot = "http://private-14b8e-clickcounter.apiary-mock.com/"

  "The click counter service" should {
    "return the correct value" in {
      val response = Http(url(serviceRoot + "counters/123/value") OK as.String)
      response().toInt === 3
    }
  }

  //def get(resource: String) = {}

  // create a counter


  // retrieve a counter


  // delete a counter


  // increment a counter



  // decrement a counter



  // reset a counter



  // retrieve a counter value


  // retrieve a counter value stream



}
