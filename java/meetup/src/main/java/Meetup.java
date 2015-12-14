import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.joda.time.DateTime;

public class Meetup {

	private static final int FIRST_DAY_OF_MONTH = 1;
	private static final int START_OF_WEEK = 6;
	
	private static final Integer[] FIRST_WEEK_DAYS = {1, 2, 3, 4, 5, 6, 7};
	private static final Integer[] SECOND_WEEK_DAYS = {8, 9, 10, 11, 12, 13, 14};
	private static final Integer[] THIRD_WEEK_DAYS = {15, 16, 17, 18, 19, 20, 21};
	private static final Integer[] FOURTH_WEEK_DAYS = {22, 23, 24, 25, 26, 27, 28};
	private static final Integer[] TEENTH_WEEK_DAYS = {13, 14, 15, 16, 17, 18, 19};
	
	private final int month;
	private final int year;
	private final int numberOfDaysInMonth;
	private final Map<MeetupSchedule, Set<Integer>> monthSchedule;

	public Meetup(final int month, final int year) {
		this.month = month;
		this.year = year;
		numberOfDaysInMonth = new DateTime(year, month, 1, 0, 0).dayOfMonth().getMaximumValue();
		monthSchedule = buildMonth(numberOfDaysInMonth);
	}

	public DateTime day(int day, MeetupSchedule schedule) {
		return IntStream
				.range(FIRST_DAY_OF_MONTH, numberOfDaysInMonth)
				.mapToObj(i -> {
					DateTime dateOfDayInWeek = new DateTime(year, month, i, 0, 0).withDayOfWeek(day);
					if (dateOfDayInWeek.getMonthOfYear() == month)
						return dateOfDayInWeek;
					return null;
				})
				.filter(d -> d != null)
				.filter(d -> monthSchedule.get(schedule).contains(d.getDayOfMonth()))
				.findFirst()
				.get();
	}
	
	private Map<MeetupSchedule, Set<Integer>> buildMonth(int numberOfDays) {
		Map<MeetupSchedule, Set<Integer>> month = new HashMap<>();
		month.put(MeetupSchedule.FIRST, buildWeek(FIRST_WEEK_DAYS));
		month.put(MeetupSchedule.SECOND, buildWeek(SECOND_WEEK_DAYS));
		month.put(MeetupSchedule.THIRD, buildWeek(THIRD_WEEK_DAYS));
		month.put(MeetupSchedule.FOURTH, buildWeek(FOURTH_WEEK_DAYS));
		month.put(MeetupSchedule.TEENTH, buildWeek(TEENTH_WEEK_DAYS));
		month.put(MeetupSchedule.LAST, calculateLastWeekOfMonth(numberOfDays));
		return month;
	}

	private Set<Integer> buildWeek(Integer[] values) {
		return Stream.of(values).collect(Collectors.toSet());
	}
	
	private Set<Integer> calculateLastWeekOfMonth(final int numberOfDays) {
		return IntStream.range(numberOfDays - START_OF_WEEK, numberOfDays + 1).boxed().collect(Collectors.toSet());
	}
}