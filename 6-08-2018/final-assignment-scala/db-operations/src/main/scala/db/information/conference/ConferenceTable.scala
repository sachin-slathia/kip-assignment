package db.information.conference

import db.information.database.Db
import dto. ConferenceRoom
import slick.lifted.ProvenShape

trait ConferenceTable { this: Db =>

  import config.profile.api._

  class ConferenceOperation(tag: Tag) extends Table[ConferenceRoom](tag, "Conference Room") {
    def teamId: Rep[Int] = column[Int]("TEAM ID", O.PrimaryKey, O.AutoInc)

    def teamName: Rep[String] = column[String]("TEAM NAME")

    def available: Rep[Boolean] = column[Boolean]("IS AVAILABLE")

    def memberSize: Rep[Int] = column[Int]("Members present in our conference room")
    def * : ProvenShape[ConferenceRoom] = (teamId.?, teamName, available, memberSize) <> (ConferenceRoom.tupled, ConferenceRoom.unapply)
  }

  val conference = TableQuery[ConferenceOperation]

}
