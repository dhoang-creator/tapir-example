package com.dhoang.database


import com.dhoang.model.Model._

import java.nio.file.Path
import java.util.UUID

object Database {
  // the below is the necessary case class to set the definition of the individual rows but note that this is manually inputted, what if we were to take it from a URI?
  var books: List[Book] = List(
    Book(
      UUID.randomUUID(),
      "The Sorrows of Young Werther",
      new Year(1774),
      Author("Johann Wolfgang von Goethe", Country("Germany"))
    ),
    Book(UUID.randomUUID(), "Iliad", new Year(-8000), Author("Homer", Country("Greece"))),
    Book(UUID.randomUUID(), "Nad Niemnem", new Year(1888), Author("Eliza Orzeszkowa", Country("Poland"))),
    Book(UUID.randomUUID(), "The Colour of Magic", new Year(1983), Author("Terry Pratchett", Country("United Kingdom"))),
    Book(UUID.randomUUID(), "The Art of Computer Programming", new Year(1986), Author("Donald Knuth", Country("USA"))),
    Book(UUID.randomUUID(), "Pharaoh", new Year(1897), Author("Boleslaw Prus"), Country("Poland"))
  )

  // why do we import a java file path as opposed to a Scala DSL one?
  var bookCovers: Map[UUID, Path] = Map.empty
}
