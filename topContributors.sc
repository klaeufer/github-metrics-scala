import hubcat._
import dispatch._
import org.json4s._

// List the contributors to a specific repository in order of contributions
//(example from hubcat readme).

// specify project

val owner = "LoyolaChicagoCS"
val repo = "coursedescriptions"

// retrieve access token from local file

val homeDir = System.getProperty("user.home")
val accessToken = scala.io.Source.fromFile(homeDir + "/.githubAccessToken").getLines.next()
val client = Client(accessToken)

// compute top contributors

val contribs = client.repo(owner, repo).contributors

val topContributors = (for {
  JObject(cFields)               <- contribs(as.json4s.Json)() // each individual contributor
  ("login", JString(login))      <- cFields// extract login
  ("contributions", JInt(count)) <- cFields // extract contribution count
} yield (login, count)).sortBy(_._2).reverse

// print results

for (c <- topContributors)
  println(c)
