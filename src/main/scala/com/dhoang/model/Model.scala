package com.dhoang.model

import java.nio.file.Path
import java.util.UUID

object Model {

  // model
  class Year(val year: Int) extends AnyVal

  case class Country(name: String)

  case class Author(name: String, country: Country)

  case class Book(id: UUID, title: String, year: Year, author: Author)

  case class NewBook(title: String, cover: Option[Path], year: Year, authorName: String, authorCountry: String)

  case class BooksQuery(year: Option[Year], limit: Option[Int])

  type AuthToken = String

  case class ErrorInfo(error: String)

}
