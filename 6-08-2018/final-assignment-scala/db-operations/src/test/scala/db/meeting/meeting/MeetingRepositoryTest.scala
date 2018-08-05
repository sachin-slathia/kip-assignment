package db.meeting.meeting

import db.information.database.DbConfiguration
import db.information.meeting.MeetingRepository
import org.scalatest.{BeforeAndAfterEach, FunSuite}


class MeetingRepositoryTest extends FunSuite with DbConfiguration  with BeforeAndAfterEach {

  val meeting = new MeetingRepository(config)

  override def beforeEach(){
    meeting.init()
  }

  override def afterEach() {
    meeting.drop()
  }

  test("Get all Meeting Rooms"){
    assert(meeting.findAll === Nil)
  }


}
