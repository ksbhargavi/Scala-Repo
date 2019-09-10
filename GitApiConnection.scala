import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}
import spray.json.JsonParser
import scala.concurrent.duration._
import scala.util.Success

object GitApiConnection{
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  val connectionFlow =Http().outgoingConnectionHttps("api.github.com")
  val akkaToolkitRequest = HttpRequest(uri = "/search/users?q=language:java+language:scala+location:Pittsburgh&sort=stars&order=desc")
  println(akkaToolkitRequest)
  val responseFuture =
    Source.single(akkaToolkitRequest).via(connectionFlow).runWith(Sink.head)

  println("obj")
  val obj=responseFuture.andThen {
    case Success(response) =>
      response.entity.toStrict(5 seconds).map( _.data.decodeString("UTF-8")).andThen {
        case Success(json) =>
          println(json)
          val jsonObject= JsonParser(json)
          println(jsonObject)

          materializer.shutdown()
          system.terminate()
      }

    case _ => println("request failed")

  }
}