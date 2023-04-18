package com.dhoang.akka

import akka.http.scaladsl.model.StatusCodes
import com.dhoang.database.Database._
import com.dhoang.model.Model._
import com.dhoang.endpoints._
import com.dhoang.model.Model.ErrorInfo

/**
 * At first glance:
 *  - it looks like the below is the business logic of the application;
 *  - and where the data from the endpoints is altered;
 *  - but remember that the use of Akka and Futures is not the server implementation but rather the Effect Type
 *
 *  The below is rather the routing of the pre-defined Endpoints we have made mention to
  */

object AkkaRoutes {

  import akka.http.scaladsl.server.Route
  import sttp.tapir.server.akkahttp._
  import akka.stream.scaladsl.FileIO
  import scala.concurrent.Future

  val getBooksRoute: Route = Endpoints.getBooks.toRoute { booksQuery =>
    if (booksQuery.limit.getOrElse(0) < 0) {
      Future.successful((Left(StatusCodes.BadRequest, ErrorInfo("Limit must be positive"))))
    } else {
      val filteredByYear = booksQuery.year.map(year => books.filter(_.year == year)).getOrElse(books)


    }
  }

}
