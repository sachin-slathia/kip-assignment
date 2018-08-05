package db.information.meeting

import db.information.database.Db
import dto.MeetingRoom
import slick.lifted.ProvenShape


trait MeetingTable {
  this: Db =>

  import config.profile.api._



  class MeetingOperation(tag: Tag) extends Table[MeetingRoom](tag, "Meeting Room") {

    def teamId: Rep[Int] = column[Int]("TEAM ID", O.PrimaryKey, O.AutoInc)

    def teamName: Rep[String] = column[String]("TEAM NAME")

    def available: Rep[Boolean] = column[Boolean]("IS AVAILABLE")

    def memberSize: Rep[Int] = column[Int]("Members present in Meeting room")
    def * : ProvenShape[MeetingRoom] = (teamId.?, teamName, available, memberSize) <> (MeetingRoom.tupled, MeetingRoom.unapply)

  }
  val meeting = TableQuery[MeetingOperation]
}
