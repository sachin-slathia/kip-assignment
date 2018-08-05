package db.meeting.team

import db.information.conference.ConferenceRepository
import db.information.database.DbConfiguration
import db.information.team.TeamRepository
import org.scalatest.{BeforeAndAfterEach, FunSuite}


class TeamRepositoryTest extends FunSuite with DbConfiguration  with BeforeAndAfterEach {

  val team = new TeamRepository(config)

  override def beforeEach(){
    team .init()
  }

  override def afterEach() {
    team .drop()
  }

  test("Get all Teams"){
    assert(team.findAll === Nil)
  }


}
