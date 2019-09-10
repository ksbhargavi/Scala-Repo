
import akka.actor.{ActorRef, ActorSystem}
import akka.http.scaladsl.Http

import akka.stream.ActorMaterializer


import scala.concurrent.duration._
import com.typesafe.config.ConfigFactory
import akka.pattern.ask
import akka.util.Timeout
import akka.http.scaladsl.server.Directives._


import scala.concurrent.{Await, ExecutionContext}
import scala.util.{Failure, Success}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport



object AkkaHttpHelloWorld extends SprayJsonSupport{
  implicit val actorSystem = ActorSystem("system")
  implicit val actorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContext = actorSystem.dispatcher
  implicit val timeout = Timeout(5 seconds)
  def main(args: Array[String]) {

    val userActor: ActorRef = actorSystem.actorOf(GitUserActor.props, "GitUserActor")

    val config = ConfigFactory.load()

    val route =
      pathSingleSlash {
        get {

            val obj=(userActor ?Api )

          val result=  Await.result(obj, 1 second)
          complete(s"${result}")
        }

      }

    val serverBinding =  Http().bindAndHandle(route,config.getString("http.interface"), config.getInt("http.port"))


    serverBinding.onComplete {
      case Success(bound) =>
        println(s"Server online at http://${bound.localAddress.getHostString}:${bound.localAddress.getPort}/")
      case Failure(e) =>
        Console.err.println(s"Server could not start!")
        e.printStackTrace()
        actorSystem.terminate()
    }
    println("server started at 9000")


  }
}