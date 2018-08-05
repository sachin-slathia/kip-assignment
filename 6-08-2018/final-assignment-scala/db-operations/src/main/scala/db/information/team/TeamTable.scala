package db.information.team

import db.information.database.Db
import dto.Team
import slick.lifted.ProvenShape


/**
  * Slick
  */
trait TeamTable { this: Db =>

  import config.profile.api._

  class TeamOperation(tag: Tag) extends Table[Team](tag, "Team") {
    def id: Rep[Int] = column[Int]("Team ID", O.PrimaryKey,  O.AutoInc)
    def name: Rep[String] = column[String]("NAME")
    def members: Rep[String] = column[String]("Team Members")
    def projectName: Rep[String] = column[String]("project they are working on")
    def * : ProvenShape[Team] = (id.?, name, members, projectName) <> (Team.tupled, Team.unapply)
  }

  val team = TableQuery[TeamOperation]

}
