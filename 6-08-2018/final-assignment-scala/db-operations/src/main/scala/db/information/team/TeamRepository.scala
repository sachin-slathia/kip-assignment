package db.information.team

import db.information.database.Db
import dto.Team
import slick.basic.DatabaseConfig
import slick.dbio.DBIOAction
import slick.jdbc.H2Profile

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class TeamRepository (val config: DatabaseConfig[H2Profile]) extends Db with TeamTable {

  import config.profile.api._

  import scala.concurrent.ExecutionContext.Implicits.global

  def init(): Unit =
    Await.result(
      db.run(DBIOAction.seq(team.schema.create)),
      Duration.Inf
    )

  def drop(): Unit =
    Await.result(
      db.run(DBIOAction.seq(team.schema.drop)),
      Duration.Inf
    )
  def insert(team1:Team): Team =
    Await.result(
      db.run(team returning team.map(_.id) += team1).map(id => team1.copy(id = Some(id))),
      Duration.Inf
    )
  def find(id: Int): Option[Team] =
    Await.result(
      db.run((for (team1 <- team if team1.id === id) yield team1).result.headOption),
      Duration.Inf
    )

  def findAll: List[Team] = Await.result(
    db.run((for (team1 <- team ) yield team1).result),
    Duration.Inf
  ).toList


  def delete(id: Int): Boolean =
    Await.result(
      db.run(team.filter(_.id === id).delete) map { _ > 0 },
      Duration.Inf
    )
}
