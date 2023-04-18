package com.dhoang.endpoints

import com.dhoang.model.Model._
import sttp.model.StatusCode

object FirstEndpoint {

  object FirstEndpoint {

    // why do we need to import all of these imports into the individual objects, if this is so then can we not simply de-compartmentalize

    import io.circe.generic.auto._
    import sttp.tapir._
    import sttp.tapir.json.circe._
    import sttp.tapir.Codec.PlainCodec

    // what is being done in the below val?
    implicit val yearCodec: PlainCodec[Year] = implicitly[PlainCodec[Int]].map(new Year(_))(_.year)

    // there are some issues with the code reconciliation below i.e. ErrorInfo and StatusCode
    val getBooks: Endpoint[(Option[Year], Option[Int]), (StatusCode, ErrorInfo), List[Book], Nothing] = endpoint.get
      .in("api" / "v1.0" / "books")
      .in(query[Option[Year]]("year"))
      .in(query[Option[Int]]("limit"))
      .errorOut(statusCode)
      .errorOut(jsonBody[ErrorInfo])
      .out(jsonBody[List[Book]])
  }

}
