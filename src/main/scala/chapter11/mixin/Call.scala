import java.time.Duration
import java.time.LocalDateTime


case class Call(val from: LocalDateTime, val to: LocalDateTime) {
  def duration: Duration = Duration.between(from, to)
}

