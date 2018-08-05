package edu.knoldus


import db.information.conference.ConferenceRepository
import db.information.database.DbConfiguration
import db.information.meeting.MeetingRepository
import db.information.team.TeamRepository
import dto.{ConferenceRoom, MeetingRoom, Team}


//noinspection ScalaStyle
object Operation extends App with DbConfiguration{



  val conferenceRepository = new ConferenceRepository(config)
  val meetingRepository = new MeetingRepository(config)
  val teamRepository = new TeamRepository(config)



  conferenceRepository.init()
  conferenceRepository.insert(ConferenceRoom(Some(1), "PLACE WHERE REAL MAGIC HAPPENS", true, 15))
  println(conferenceRepository.findAll)

  meetingRepository.init()
  meetingRepository.insert(MeetingRoom(Some(1), "Room 1", false, 7))
  meetingRepository.insert(MeetingRoom(Some(2), "Room 2", false, 6))
  meetingRepository.insert(MeetingRoom(Some(3), "Room 3", false, 8))
  meetingRepository.insert(MeetingRoom(Some(4), "Room 4", false, 10))
  println(meetingRepository.findAll)

  teamRepository.init()
  teamRepository.insert(Team(Some(1), "Scala Masters", "Prabhat , Harmeet, Siddharth , Sachin", "API Development In Scala"))
  teamRepository.insert(Team(Some(2), "Java Experts", "Deepak , Kunal, Pankhori, Anshul, Divya", "Upgrading Java 7 Projects to Java 8 Projects"))
  println(teamRepository.findAll)


}

