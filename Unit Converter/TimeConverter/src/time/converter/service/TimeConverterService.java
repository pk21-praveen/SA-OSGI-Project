package time.converter.service;

public interface TimeConverterService {

	//Seconds to Minutes,Hours,Days
	public double SecondsToSeconds(double sec);
	public double SecondsToMinutes(double sec);
	public double SecondsToHours(double sec);
	public double SecondsToDays(double sec);
	
	//Minutes to Seconds,Hours,Days
	public double MinutesToMinutes(double mins);
	public double MinutesToSeconds(double mins);
	public double MinutesToHours(double mins);
	public double MinutesToDays(double mins);
	
	//Hours to Seconds,Minutes,Days
	public double HoursToHours(double hrs);
	public double HoursToSeconds(double hrs);
	public double HoursToMinutes(double hrs);
	public double HoursToDays(double hrs);
	
	//Days to Minutes,Hours,Hours
	public double DaysToDays(double days);
	public double DaysToSeconds(double days);
	public double DaysToMinutes(double days);
	public double DaysToHours(double days);
}
