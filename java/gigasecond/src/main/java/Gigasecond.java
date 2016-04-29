import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Gigasecond {

    private static final long GIGA_SECOND = 1000000000;

    private final LocalDateTime date;

    public Gigasecond(final LocalDate date) {
        this.date = LocalDateTime.of(date, LocalTime.MIDNIGHT);
    }

    public Gigasecond(final LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date.plusSeconds(GIGA_SECOND);
    }
}
