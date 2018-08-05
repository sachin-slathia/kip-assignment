package db.meeting.conference

import db.information.conference.ConferenceRepository
import db.information.database.DbConfiguration
import org.scalatest.{BeforeAndAfterEach, FunSuite}


class ConferenceRepositoryTest extends FunSuite with DbConfiguration  with BeforeAndAfterEach {

  val conference = new ConferenceRepository(config)

  override def beforeEach(){
    conference .init()
  }

  override def afterEach() {
    conference .drop()
  }

  test("Get all Conference Rooms"){
    assert(conference .findAll === Nil)
  }


}
