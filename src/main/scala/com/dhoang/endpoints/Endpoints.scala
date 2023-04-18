package com.dhoang.endpoints

import com.dhoang.database.Database
import com.dhoang.model.Model._

import java.util.UUID

object Endpoints {

  // why do we include the imports within the individual objects rather than the project itself?
  import io.circe.generic.auto._
  import sttp.tapir._
  import sttp.tapir.json.circe._
  import sttp.tapir.Codec.PlainCodec
  import akka.stream.scaladsl.Source
  import akka.util.ByteString
  import sttp.model.StatusCode

  implicit val yearCodec: PlainCodec[Year] = implicitly[PlainCodec[Int]].map(new Year(_))(_.year)

  val baseEndpoint: Endpoint[Unit, (StatusCode, ErrorInfo), Unit, Nothing] = endpoint
    .in("api" / "v1.0")
    .errorOut(statusCode.and(jsonBody[ErrorInfo]))

  val booksQueryInput: EndpointInput[BooksQuery] = query[Option[Year]]("year").and(query[Option[Int]]("limit")).mapTo(BooksQuery)

  val getBooks: Endpoint[BooksQuery, (StatusCode, ErrorInfo), List[Book], Nothing] = baseEndpoint.get
    .in("book")
    .in(booksQueryInput)
    .out(jsonBody[List[Book]].example(List(Database.books.head)))

  val getBookCover: Endpoint[UUID, (StatusCode, ErrorInfo), Source[ByteString, Any], Source[ByteString, Any]] = baseEndpoint.get
    .in("book" / path[UUID]("bookId") / "cover")
    .out(streamBody[Source[ByteString, Any]](schemaFor[Array[Byte]], MediaType.OctectStream()))

  val addBook: Endpoint[(AuthToken, NewBook), (StatusCode, ErrorInfo), Unit, Nothing] = baseEndpoint.get
    .in(auth.bearer)
    .in("book")
    .in(multipartBody[NewBook])



}
