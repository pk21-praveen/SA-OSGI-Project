package speed.converter.service;

/**
 * @author PraveenKumar
 *
 */
public interface SpeedConverterService {
	// meter to foot,km,mile & knot conversion
	public double MeterPerSecondToMeterPerSecond(double speed);
	public double MeterPerSecondToFootPerSecond(double speed);
	public double MeterPerSecondToKmPerHour(double speed);
	public double MeterPerSecondToMilesPerHour(double speed);
	public double MeterPerSecondToKnot(double speed);

	// foot to m,km,mile & knot conversion
	public double FootPerSecondToFootPerSecond(double speed);
	public double FootPerSecondToMeterPerSecond(double speed);
	public double FootPerSecondToKmPerHour(double speed);
	public double FootPerSecondToMilesPerHour(double speed);
	public double FootPerSecondToKnot(double speed);

	// kilometer to m,foot,mile & knot conversion
	public double KmPerHourToKmPerHour(double speed);
	public double KmPerHourToMeterPerSecond(double speed);
	public double KmPerHourToFootPerSecond(double speed);
	public double KmPerHourToMilesPerHour(double speed);
	public double KmPerHourToKnot(double speed);

	// mile to m,foot,km & knot conversion
	public double MilesPerHourToMilesPerHour(double speed);
	public double MilesPerHourToMeterPerSecond(double speed);
	public double MilesPerHourToFootPerSecond(double speed);
	public double MilesPerHourToKmPerHour(double speed);
	public double MilesPerHourToKnot(double speed);

	// knot to m,foot,km & mile conversion
	public double KnotToKnot(double speed);
	public double KnotToMeterPerSecond(double speed);
	public double KnotToFootPerSecond(double speed);
	public double KnotToKmPerHour(double speed);
	public double KnotToMilesPerHour(double speed);
}
