package db.information.conference


import db.information.database.Db
import dto.ConferenceRoom
import slick.basic.DatabaseConfig
import slick.dbio.DBIOAction
import slick.jdbc.H2Profile

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class ConferenceRepository (val config: DatabaseConfig[H2Profile]) extends Db with ConferenceTable {

  import config.profile.api._

  import scala.concurrent.ExecutionContext.Implicits.global

  def init(): Unit =
    Await.result(
      db.run(DBIOAction.seq(conference.schema.create)),
      Duration.Inf
    )

  def drop(): Unit =
    Await.result(
      db.run(DBIOAction.seq(conference.schema.drop)),
      Duration.Inf
    )
  def insert(conference1:ConferenceRoom): ConferenceRoom =
    Await.result(
      db.run(conference returning conference.map(_.teamId) += conference1).map(id => conference1.copy(teamId = Some(id))),
      Duration.Inf
    )
  def find(id: Int): Option[ConferenceRoom] =
    Await.result(
      db.run((for (conference1 <- conference if conference1.teamId === id) yield conference1).result.headOption),
      Duration.Inf
    )

  def findAll: List[ConferenceRoom] = Await.result(
    db.run((for (conference1 <- conference) yield conference1 ).result),
    Duration.Inf
  ).toList


  def delete(id: Int): Boolean =
    Await.result(
      db.run(conference.filter(_.teamId === id).delete) map { _ > 0 },
      Duration.Inf
    )
}
