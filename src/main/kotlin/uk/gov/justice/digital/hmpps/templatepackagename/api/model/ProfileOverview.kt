package uk.gov.justice.digital.hmpps.templatepackagename.api.model

import jdk.jfr.Timespan
import org.hibernate.validator.constraints.CreditCardNumber
import org.springframework.cglib.core.Local
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class ProfileSummary(
  val personId: UUID,
  val imageUrl: String,
  val fullName: String,
  val crn: String,
  val arrivalDate: LocalDate,
  val departureDate: LocalDate,
  val tier: String,
  val keyWorkerName: String,
  val status: String,
)

data class ProfileOverview(
  val personId: UUID,
  val curfewStartTime: LocalDateTime,
  val curfewEndTime: LocalDateTime,
  val nextWelfareCheck: LocalDateTime,
  val signInTimes: List<LocalDateTime>,
  val welfareStatus: String,
  val dailySchedule: List<ScheduleItem>,
  val outOfHoursPlan: OutOfHoursPlan
  )

data class ScheduleItem(
  val time: LocalDateTime,
  val description: String,
)

data class OutOfHoursPlan(
  val submittedBy: UUID,
  val submittedOn: LocalDateTime,
  val actions: Map<OutOfHoursPlanActionType, Map<OutOfHoursPlanStage, List<String>>>,
)

enum class OutOfHoursPlanActionType {
  NOT_RETURNED_BY_CURFEW,
  NOT_RETURNED_FOR_SIGN_IN,
}

enum class OutOfHoursPlanStage {
  FIRST,
  SECOND,
}
