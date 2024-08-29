package chapter6;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        RecurringSchedule schedule = new RecurringSchedule("회의",
                DayOfWeek.WEDNESDAY,
                LocalTime.of(10, 30),
                Duration.ofMinutes(30));
        Event meeting = new Event("회의",
                LocalDateTime.of(2019, 5, 8, 10, 30),
                Duration.ofMinutes(30));
        // 명령과 쿼리를 엄격히 분류하면 부수효과를 제어하기 수월해짐
        if (!meeting.isSatisfied(schedule)) {
            meeting.reschedule(schedule);
        }
    }
}
