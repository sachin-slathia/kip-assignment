import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}
import ttt.entites.{Game, Play, PlayStep, Player}
import ttt.playstation.TicTacToe.{game, playerOne}

class TicTacToeSpec() extends TestKit(ActorSystem("MySpec")) with ImplicitSender
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }
  val system1 = ActorSystem("tic-tac-toe")

  val playerOne = system1.actorOf(Props[Player])
  val playerTwo = system1.actorOf(Props[Player])
  val game = system1.actorOf(Props[Game])


  "An Game actor" should {

    "be able to change and return the state of tic tac toe game" in {
      playerOne ! Play(PlayStep(1,1), game)


    }

    "be able to send Tic Tac Toe Map and a GameOver when a condition is met" in {
    }

    "be able to send PlaceAlreadyFilled Message when a PlayStep is sent on a non empty step" in {
    }
  }
}
