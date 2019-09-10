import akka.actor.{Actor, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.stream.scaladsl.{Sink, Source}
import AkkaHttpHelloWorld.actorMaterializer
import AkkaHttpHelloWorld.actorSystem
import AkkaHttpHelloWorld.executionContext
import akka.util.Timeout

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

case class UserDetails(login:String , id:String,node_id:String,avatar_url:String,
                       gravatar_id:String,url:String,html_url:String,
                       followers_url:String,following_url:String,gists_url:String,
                       starred_url:String,subscriptions_url:String,organizations_url:String,
                       repos_url:String,events_url:String,received_events_url:String,site_admin:String,score:String
                      )
case class UsersInfo(total_count:String ,incomplete_results:String ,items :Seq[UserDetails])


case class Api(obj:String){
 def getString : String = obj
}

 class ExecuteGitAPI() {


   def execute():String ={

    val connectionFlow =Http().outgoingConnectionHttps("api.github.com")
    val akkaToolkitRequest = HttpRequest(uri = "/search/users?q=language:java+language:scala+location:Pittsburgh&sort=stars&order=desc")
    println(akkaToolkitRequest)
    val responseFuture = Source.single(akkaToolkitRequest).via(connectionFlow).runWith(Sink.head)


    val obj =responseFuture.flatMap(_.entity.toStrict(300.milli).map(_.data.utf8String))
      obj.onComplete{
      case Success(x) =>
      case Failure(e) => e.printStackTrace
    }
      val result=  Await.result(obj, 1 second)
     println(result)

     result
  }}



object GitUserActor{

  def props: Props = Props[GitUserActor]
}

class GitUserActor extends Actor{
  implicit val timeout = Timeout(5 seconds)
val excuteapi= new ExecuteGitAPI()



  def receive: Receive = {

    case Api =>
      sender()!  Api (excuteapi.execute()).getString
  }
}




