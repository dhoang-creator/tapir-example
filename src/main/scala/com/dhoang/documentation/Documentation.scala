package com.dhoang.documentation

import com.dhoang.endpoints.Endpoints._
import com.dhoang.endpoints._

object Documentation {

  import sttp.tapir.openapi._
  import sttp.tapir.openapi.circe.yaml._
  import sttp.tapir.openai.OpenAI

  val openApi: OpenAPI = List(getBooks, getBookCover, addBook).toOpenAPI("The tapir library", "0.29.192-beta-RC1")
  val tml: String = openApi.toYaml

  def startServer(): Unit = {

    import com.dhoang.akka.AkkaRoutes._
    import scala.concurrent.Await
    import scala.concurrent.duration._
    import akka.http.scaladsl.server.Directive._
    import akka.http.scaladsl.server.Route
    import akka.http.scaladsl.Http
    import akka.actor.ActorSystem
    import akka.stream.ActorMaterializer

    val routes: Route = getBooksRoute ~ getBookCoverRoute ~ addBookRoute ~ new SwaggerUI(Documentation.yml).routes
    implicit val actorSystem: ActorSystem = ActorSystem()
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    Await.result(Http().bindAndHandle(routes, "localhost", 8080), 1.minute)
    println("Server started, visit http://localhost:8080/docs for the API docs")
  }

  startServer()
}

/*
  We need to find the OpenAPI and SwaggerUI documentation since this is very confusing and very ugly
 */
class SwaggerUI(yml: String) {

  import akka.http.scaladsl.model.StatusCode
  import akka.http.scaladsl.server.Directive._
  import akka.http.scaladsl.server.Route
  import java.util.Properties

  val DocsYml = "docs.yml"

  private val redirectToIndex: Route =
    redirect(s"/docs/index.html?url=/docs/$DocsYml", StatusCode.PermanentRedirect)
}
