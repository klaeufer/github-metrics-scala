clickcounter-spray-scala
========================

This is intended to become a restful click counter service.

It includes initial explorations of
[Apiary](http://docs.clickcounter.apiary.io).  In particular, there is
a working but non-exhaustive test of the server mock that Apiary
provides. Specifically, this is a remote, HTTP-based test of the
running server mock. 

The test uses these libraries:

- [Dispatch](http://dispatch.databinder.net)
  as an HTTP client for interacting with the server mock.
- [specs2](http://etorreborre.github.io/specs2)
  for its nice matchers (especially JSON).

Once we flesh out the service implementation, we will add
out-of-container tests of the service logic.
