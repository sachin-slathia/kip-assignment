package dto

case class ConferenceRoom (
  teamId: Option[Int],
  teamName: String,
  available: Boolean,
  membersSize: Int
)
