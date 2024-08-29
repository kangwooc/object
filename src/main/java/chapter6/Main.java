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

        // 두번 호출하면 이슈가 발생을 함
        assert meeting.isSatisfied(schedule) == false;
        assert meeting.isSatisfied(schedule) == true;
    }
}
