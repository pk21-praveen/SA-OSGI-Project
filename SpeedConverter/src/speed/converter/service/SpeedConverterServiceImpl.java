package speed.converter.service;

/**
 * @author PraveenKumar
 *
 */
public class SpeedConverterServiceImpl implements SpeedConverterService{

	// meter to foot,km,mile & knot conversion
	@Override
	public double MeterPerSecondToMeterPerSecond(double speed) {
		return speed;
	}
	
	@Override
	public double MeterPerSecondToFootPerSecond(double speed) {
		return speed * 3.281;
	}

	@Override
	public double MeterPerSecondToKmPerHour(double speed) {
		return speed * 3.6;
	}

	@Override
	public double MeterPerSecondToMilesPerHour(double speed) {
		return speed * 2.237;
	}

	@Override
	public double MeterPerSecondToKnot(double speed) {
		return speed * 1.944;
	}

	// foot to m,km,mile & knot conversion
	@Override
	public double FootPerSecondToFootPerSecond(double speed) {
		return speed;
	}
	
	@Override
	public double FootPerSecondToMeterPerSecond(double speed) {
		return speed / 3.281;
	}

	@Override
	public double FootPerSecondToKmPerHour(double speed) {
		return speed * 1.097;
	}
	
	@Override
	public double FootPerSecondToMilesPerHour(double speed) {
		return speed / 1.467;
	}

	@Override
	public double FootPerSecondToKnot(double speed) {
		return speed / 1.688;
	}

	// kilometer to m,foot,mile & knot conversion
	@Override
	public double KmPerHourToKmPerHour(double speed) {
		return speed;
	}
	
	@Override
	public double KmPerHourToMeterPerSecond(double speed) {
		return speed / 3.6;
	}
	
	@Override
	public double KmPerHourToFootPerSecond(double speed) {
		return speed / 1.097;
	}
	
	@Override
	public double KmPerHourToMilesPerHour(double speed) {
		return speed / 1.609;
	}
	
	@Override
	public double KmPerHourToKnot(double speed) {
		return speed / 1.852;
	}

	// mile to m,foot,km & knot conversion
	@Override
	public double MilesPerHourToMilesPerHour(double speed) {
		return speed;
	}
	
	@Override
	public double MilesPerHourToMeterPerSecond(double speed) {
		return speed / 2.237;
	}
	
	@Override
	public double MilesPerHourToFootPerSecond(double speed) {
		return speed * 1.467;
	}
	
	@Override
	public double MilesPerHourToKmPerHour(double speed) {
		return speed * 1.609;
	}
	
	@Override
	public double MilesPerHourToKnot(double speed) {
		return speed / 1.151;
	}
	
	// knot to m,foot,km & mile conversion
	@Override
	public double KnotToKnot(double speed) {
		return speed;
	}
	
	@Override
	public double KnotToMeterPerSecond(double speed) {
		return speed / 1.944;
	}
	
	@Override
	public double KnotToFootPerSecond(double speed) {
		return speed * 1.688;
	}
	
	@Override
	public double KnotToKmPerHour(double speed) {
		return speed * 1.852;
	}
	
	@Override
	public double KnotToMilesPerHour(double speed) {
		return speed * 1.151;
	}

}
