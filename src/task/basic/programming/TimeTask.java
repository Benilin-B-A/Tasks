package task.basic.programming;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.Month;
import java.time.ZoneId;

public class TimeTask {
	
	public Instant getInstance(long timeMillis) {
		return Instant.ofEpochMilli(timeMillis);
	}	
	
	public ZonedDateTime getTime(String country) {
		return ZonedDateTime.now(ZoneId.of(country));
	}
	
	public long getTimeMillis() {
		return System.currentTimeMillis();
	}
	
	public DayOfWeek getDayOfWeek() {
		return getDayOfWeek(getTimeMillis());
	}
	public DayOfWeek getDayOfWeek(long timeMillis) {
		Instant inst=getInstance(timeMillis);
		return inst.atZone(ZoneId.systemDefault()).getDayOfWeek();
	}

	public Month getMonth() {
		return getMonth(getTimeMillis());
	}

	public Month getMonth(long timeMillis) {
		Instant inst=getInstance(timeMillis);
		return inst.atZone(ZoneId.systemDefault()).getMonth();
	}
	
	public int getYear() {
		return getYear(getTimeMillis());
	}
	public int getYear(long timeMillis) {
		Instant inst=getInstance(timeMillis);
		return inst.atZone(ZoneId.systemDefault()).getYear();
	}
}
