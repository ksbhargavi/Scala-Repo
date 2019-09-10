import AkkaHttpHelloWorld.actorMaterializer
import AkkaHttpHelloWorld.executionContext
import akka.actor.{Actor, ActorLogging, ActorSystem}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse, StatusCodes}
import akka.util.ByteString
import akka.pattern.pipe

class GitApiConsumerActor extends Actor
  with ActorLogging {



  val http = Http(context.system)

  override def preStart() = {
    println("i am entered in pre start")
    http.singleRequest(HttpRequest(uri = "api.github.com/search/users?q=language:java+language:scala+location:Pittsburgh&sort=stars&order=desc"))
      .pipeTo(self)
    println("i am exit from pre start")
  }

  def receive:Receive = {
    case HttpResponse(StatusCodes.OK, headers, entity, _) =>
      entity.dataBytes.runFold(ByteString(""))(_ ++ _).foreach { body =>
      println("Got response, body: " + body.utf8String)
      }

    case resp @ HttpResponse(code, _, _, _) =>
     println("Request failed, response code: " + code)
      resp.discardEntityBytes()

    case _ => println(" default case")
  }

}