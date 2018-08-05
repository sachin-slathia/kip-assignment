package db.information.meeting



import db.information.database.Db
import dto. MeetingRoom
import slick.basic.DatabaseConfig
import slick.dbio.DBIOAction
import slick.jdbc.H2Profile

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class MeetingRepository (val config: DatabaseConfig[H2Profile]) extends Db with MeetingTable {

  import config.profile.api._

  import scala.concurrent.ExecutionContext.Implicits.global

  def init(): Unit =
    Await.result(
      db.run(DBIOAction.seq(meeting.schema.create)),
      Duration.Inf
    )

  def drop(): Unit =
    Await.result(
      db.run(DBIOAction.seq(meeting.schema.drop)),
      Duration.Inf
    )
  def insert(meeting1:MeetingRoom): MeetingRoom =
    Await.result(
      db.run(meeting returning meeting.map(_.teamId) += meeting1).map(id => meeting1.copy(teamId = Some(id))),
      Duration.Inf
    )
  def find(id: Int): Option[MeetingRoom] =
    Await.result(
      db.run((for (meeting1 <- meeting if meeting1.teamId === id) yield meeting1).result.headOption),
      Duration.Inf
    )

  def findAll: List[MeetingRoom] = Await.result(
    db.run((for (meeting1 <- meeting) yield meeting1 ).result),
    Duration.Inf
  ).toList


  def delete(id: Int): Boolean =
    Await.result(
      db.run(meeting.filter(_.teamId === id).delete) map { _ > 0 },
      Duration.Inf
    )
  def requestForMeetingRoom(id: Int): Boolean =
    Await.result(
      db.run(meeting.filter(_.teamId === id).delete) map { _ > 0 },
      Duration.Inf
    )
}
