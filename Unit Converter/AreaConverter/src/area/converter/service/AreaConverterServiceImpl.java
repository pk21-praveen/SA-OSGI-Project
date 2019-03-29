package area.converter.service;

public class AreaConverterServiceImpl implements AreaConverterService{

	@Override
	public double SquareFeetsToSquareFeets(double sf) {
		return sf;
	}

	@Override
	public double SquareFeetsToSquareMeters(double sf) {
		return sf/10.7639;
	}

	@Override
	public double SquareFeetsToAcres(double sf) {
		return sf/43560.0;
	}

	@Override
	public double SquareFeetsToHectares(double sf) {
		return sf/107639.0;
	}

	@Override
	public double SquareFeetsToSquareKilometers(double sf) {
		return sf/10763910.41671;
	}

	@Override
	public double SquareFeetsToSquareMiles(double sf) {
		return sf/27878400.0;
	}

	@Override
	public double SquareMetersToSquareMeters(double sm) {
		return sm;
	}

	@Override
	public double SquareMetersToSquareFeets(double sm) {
		return sm*10.7639;
	}

	@Override
	public double SquareMetersToAcres(double sm) {
		return sm/4046.8564224;
	}

	@Override
	public double SquareMetersToHectares(double sm) {
		return sm/10000.0;
	}

	@Override
	public double SquareMetersToSquareKilometers(double sm) {
		return sm/1000000.0;
	}

	@Override
	public double SquareMetersToSquareMiles(double sm) {
		return sm/2589988.110336;
	}

	@Override
	public double AcresToAcres(double ars) {
		return ars;
	}

	@Override
	public double AcresToSquareFeets(double ars) {
		return ars*43560.0;
	}

	@Override
	public double AcresToSquareMeters(double ars) {
		return ars*4046.8564224;
	}

	@Override
	public double AcresToHectares(double ars) {
		return ars/2.4710538146717;
	}

	@Override
	public double AcresToSquareKilometers(double ars) {
		return ars/247.10538146717;	
	}

	@Override
	public double AcresToSquareMiles(double ars) {
		return ars/640.0;
	}

	@Override
	public double HectaresToHectares(double hts) {
		return hts;
	}

	@Override
	public double HectaresToSquareFeets(double hts) {
		return hts*107639.0;
	}

	@Override
	public double HectaresToSquareMeters(double hts) {
		return hts*10000.0;
	}

	@Override
	public double HectaresToAcres(double hts) {
		return hts*2.4710538146717;
	}

	@Override
	public double HectaresToSquareKilometers(double hts) {
		return hts/100.0;
	}

	@Override
	public double HectaresToSquareMiles(double hts) {
		return hts/258.9988110336;
	}

	@Override
	public double SquareKilometersToSquareKilometers(double sk) {
		return sk;
	}

	@Override
	public double SquareKilometersToSquareFeets(double sk) {
		return sk*10763910.41671;
	}

	@Override
	public double SquareKilometersToSquareMeters(double sk) {
		return sk*1000000.0;
	}

	@Override
	public double SquareKilometersToAcres(double sk) {
		return sk*247.10538146717;
	}

	@Override
	public double SquareKilometersToHectares(double sk) {
		return sk*100.0;
	}

	@Override
	public double SquareKilometersToSquareMiles(double sk) {
		return sk/2.589988110336;
	}

	@Override
	public double SquareMilesToSquareMiles(double sm) {
		return sm;
	}

	@Override
	public double SquareMilesToSquareFeets(double sm) {
		return sm*27878400.0;
	}

	@Override
	public double SquareMilesToSquareMeters(double sm) {
		return sm*2589988.110336;
	}

	@Override
	public double SquareMilesToAcres(double sm) {
		return sm*640.0;
	}

	@Override
	public double SquareMilesToHectares(double sm) {
		return sm*258.9988110336;
	}

	@Override
	public double SquareMilesToSquareKilometers(double sm) {
		return sm*2.589988110336;
	}

}
