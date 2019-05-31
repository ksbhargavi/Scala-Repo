

import org.mongodb.scala.{Completed, Document, MongoClient, MongoCollection, MongoDatabase, Observable, Observer, bson}




object Example1 {


  case class MyDocument(city: String, language: String) {
    def toDocument: Document = {
      Document("city" -> city, "language" -> language)
    }
  }


  def main(args:Array[String]) {

    try {
      val dbClient: MongoClient = MongoClient()
      val database :MongoDatabase = dbClient.getDatabase("USER")
      val collection : MongoCollection[Document] = database.getCollection("USER")
      // Approach-1: Providing the Document Object
      //val testDoc: Document = Document("city" -> "Chennai", "language" -> "Groovy")

      // Approach-2: Using Case Class referring the Document Object
      val testDoc= MyDocument("UK","ABC").toDocument
      val insertObservable: Observable[Completed]= collection.insertOne(testDoc)
     insertObservable.subscribe(new Observer[Completed] {
        override def onNext(result: Completed): Unit = println(s"onNext: $result")
        override def onError(e: Throwable): Unit = println(s"onError: $e")
        override def onComplete(): Unit = println("onComplete")
      })
   collection.find().subscribe((doc: Document) =>  println(  "CITY : " + doc.getString("city") +"    Language : " +doc.getString("language")))

        Thread.sleep(10000)
    } catch {
      case e: Exception => println(s"Error: ${e.getMessage}")
    }
  }
}