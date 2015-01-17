import hubcat._
import dispatch._
import org.json4s._

// List the repositories with the most stars.

val numberOfReposToFetch = 900
val numberOfTopReposToShow = 10

// retrieve access token from local file

val homeDir = System.getProperty("user.home")
val accessToken = scala.io.Source.fromFile(homeDir + "/.githubAccessToken").getLines.next()
val client = Client(accessToken)

val repos = client.repositories.all

// FIXME seems limited to 100 repos

val userRepoPairs = (for {
  JObject(rFields) <- repos(as.json4s.Json)()
  ("name", JString(repo)) <- rFields
  ("owner", JObject(oFields)) <- rFields
  ("login", JString(owner)) <- oFields
} yield (owner, repo)).take(numberOfReposToFetch)

userRepoPairs.length

val topRepos = (for {
  (owner, repo) <- userRepoPairs
  JObject(rFields) = client.repo(owner, repo)(as.json4s.Json)() // avoid Json4s deep traversal
  ("stargazers_count", JInt(count)) <- rFields
} yield (owner, repo, count)).sortBy(_._3).reverse.take(numberOfTopReposToShow)

topRepos.foreach(println(_))
