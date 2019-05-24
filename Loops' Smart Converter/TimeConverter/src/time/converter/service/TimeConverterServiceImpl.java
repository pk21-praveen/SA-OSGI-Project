package time.converter.service;

public class TimeConverterServiceImpl implements TimeConverterService{

	@Override
	public double SecondsToSeconds(double sec) {
		return sec;
	}

	@Override
	public double SecondsToMinutes(double sec) {
		return sec/60.0;
	}

	@Override
	public double SecondsToHours(double sec) {
		return sec/3600.0;
	}

	@Override
	public double SecondsToDays(double sec) {
		return sec/86400.0;
	}

	@Override
	public double MinutesToMinutes(double mins) {
		return mins;
	}

	@Override
	public double MinutesToSeconds(double mins) {
		return mins*60.0;
	}

	@Override
	public double MinutesToHours(double mins) {
		return mins/60.0;
	}

	@Override
	public double MinutesToDays(double mins) {
		return mins/1440.0;
	}

	@Override
	public double HoursToHours(double hrs) {
		return hrs;
	}

	@Override
	public double HoursToSeconds(double hrs) {
		return hrs*3600.0;
	}

	@Override
	public double HoursToMinutes(double hrs) {
		return hrs*60.0;
	}

	@Override
	public double HoursToDays(double hrs) {
		return hrs/24.0;
	}

	@Override
	public double DaysToDays(double days) {
		return days;
	}

	@Override
	public double DaysToSeconds(double days) {
		return days*86400.0;
	}

	@Override
	public double DaysToMinutes(double days) {
		return days*1440.0;
	}

	@Override
	public double DaysToHours(double days) {
		return days*24.0;
	}

}
