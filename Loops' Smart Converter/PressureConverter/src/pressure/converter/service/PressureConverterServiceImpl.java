package pressure.converter.service;

import java.math.*;

public class PressureConverterServiceImpl implements PressureConverterService {

	@Override
	public double pascal_pascal(double val) {

		return val * 1.0;
	}

	@Override
	public double pascal_kiloPascal(double val) {

		return val / 1000.0;
	}

	@Override
	public double pascal_bar(double val) {

		return val / 100000.0;
	}

	@Override
	public double pascal_ATM(double val) {

		return val / 101325.0;
	}

	@Override
	public double pascal_megapascal(double val) {

		return val / 1000000.0;
	}

	@Override
	public double pascal_centipascal(double val) {

		return val * 100.0;
	}

	@Override
	public double pascal_millipascal(double val) {

		return val / 1000.0;
	}

	@Override
	public double kilopascal_pascal(double val) {

		return val * 1000.0;
	}

	@Override
	public double kilopascal_kiloPascal(double val) {

		return val;
	}

	@Override
	public double kilopascal_bar(double val) {

		return val / 100.0;
	}

	@Override
	public double kilopascal_ATM(double val) {

		return val / 101.325;
	}

	@Override
	public double kilopascal_megapascal(double val) {

		return val / 1000.0;
	}

	@Override
	public double kilopascal_centipascal(double val) {

		return val * 100000.0;
	}

	@Override
	public double kilopascal_millipascal(double val) {

		return val * 1000000.0;
	}

	@Override
	public double bar_pascal(double val) {

		return val * 100000.0;
	}

	@Override
	public double bar_kiloPascal(double val) {

		return val * 100.0;
	}

	@Override
	public double bar_bar(double val) {

		return val;
	}

	@Override
	public double bar_ATM(double val) {

		return val / 1.01325;
	}

	@Override
	public double bar_megapascal(double val) {

		return val / 10.0;
	}

	@Override
	public double bar_centipascal(double val) {

		return val * 10000000.0;
	}

	@Override
	public double bar_millipascal(double val) {

		return val * 100000000.0;
	}

	@Override
	public double ATM_pascal(double val) {

		return val * 101325;
	}

	@Override
	public double ATM_kiloPascal(double val) {

		return val * 101.325;
	}

	@Override
	public double ATM_bar(double val) {

		return val * 1.01325;
	}

	@Override
	public double ATM_ATM(double val) {

		return val;
	}

	@Override
	public double ATM_megapascal(double val) {

		return val * 0.101325;
	}

	@Override
	public double ATM_centipascal(double val) {

		return val * 10132500.0;
	}

	@Override
	public double ATM_millipascal(double val) {

		return val * 101325000.0;
	}

	@Override
	public double megapascal_pascal(double val) {

		return val * 1000000.0;
	}

	@Override
	public double megapascal_kiloPascal(double val) {

		return val * 1000.0;
	}

	@Override
	public double megapascal_bar(double val) {

		return val * 10;
	}

	@Override
	public double megapascal_ATM(double val) {

		return val * 9.8692326672;
	}

	@Override
	public double megapascal_megapascal(double val) {

		return val;
	}

	@Override
	public double megapascal_centipascal(double val) {

		return val * 100000000.0;
	}

	@Override
	public double megapascal_millipascal(double val) {

		return val * 1000000000.0;
	}

	@Override
	public double centipascal_pascal(double val) {

		return val * 0.01;
	}

	@Override
	public double centipascal_kiloPascal(double val) {

		return val * 0.00001;
	}

	@Override
	public double centipascal_bar(double val) {

		return val / 10000000.0;
	}

	@Override
	public double centipascal_ATM(double val) {

		return val / 10132500;
	}

	@Override
	public double centipascal_megapascal(double val) {

		return val / 100000000.0;
	}

	@Override
	public double centipascal_centipascal(double val) {

		return val;
	}

	@Override
	public double centipascal_millipascal(double val) {

		return val * 10.0;
	}

	@Override
	public double millipascal_pascal(double val) {

		return val / 1000.0;
	}

	@Override
	public double millipascal_kiloPascal(double val) {

		return val / 1000000.0;
	}

	@Override
	public double millipascal_bar(double val) {

		return val * 100000000.0;
	}

	@Override
	public double millipascal_ATM(double val) {

		return val / 101325000.0;
	}

	@Override
	public double millipascal_megapascal(double val) {

		return val / 1000000000.0;
	}

	@Override
	public double millipascal_centipascal(double val) {

		return val / 10.0;
	}

	@Override
	public double millipascal_millipascal(double val) {

		return val;
	}

}
