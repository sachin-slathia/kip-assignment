package dto

case class MeetingRoom(
  teamId: Option[Int],
  teamName: String,
  available: Boolean,
  membersSize: Int
)
