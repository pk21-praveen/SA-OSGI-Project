package datastorage.converter.service;

import java.math.*;

public class DataStorageConverterServiceImpl implements DataStorageConverterService{

	
	//methods from bit to ..................
	@Override
	public double bit_bit(double val) {
		
		return val * 1.0;
	}

	@Override
	public double bit_byte(double val) {
		
		return val / 8.0;
	}

	@Override
	public double bit_kilobyte(double val) {
		
		return val / (8 * 1024);
	}

	@Override
	public double bit_megabyte(double val) {
		
		return val / (8 * 1024 * 1024) ;
	}

	@Override
	public double bit_gigabyte(double val) {
		
		return val / (8 * 1024 * 1024 * 1024);
	}

	@Override
	public double bit_terabyte(double val) {
		
		return val / (8 * 1024 * 1024 * 1024 * 1024);
	}

	@Override
	public double bit_petabyte(double val) {
		
		return val / (8 * 1024 * 1024 * 1024 * 1024 * 1024);
	}
	
	
	//methods from byte to ...........
	@Override
	public double byte_bit(double val) {
		
		return val * 8.0;
	}

	@Override
	public double byte_byte(double val) {
		
		return val * 1.0;
	}

	@Override
	public double byte_kilobyte(double val) {
		
		return val / 1024;
	}

	@Override
	public double byte_megabyte(double val) {
		
		return val / 1048576.0;
	}

	@Override
	public double byte_gigabyte(double val) {
		
		return val / 1073741824.0;
	}

	@Override
	public double byte_terabyte(double val) {
		
		return val * 1099511627776.0;
	}

	@Override
	public double byte_petabyte(double val) {
		
		return val * 1125899906842624.0;
	}

	
	//methods from kilobyte to ..............
	@Override
	public double kilobyte_bit(double val) {
		
		return val * 8 * 1024;
	}

	@Override
	public double kilobyte_byte(double val) {
		
		return val * 1024;
	}

	@Override
	public double kilobyte_kilobyte(double val) {
		
		return val;
	}

	@Override
	public double kilobyte_megabyte(double val) {
		
		return val / 1024;
	}

	@Override
	public double kilobyte_gigabyte(double val) {
		
		return val / (1024 * 1024);
	}

	@Override
	public double kilobyte_terabyte(double val) {
		
		return val / (1024 * 1024 * 1024);
	}

	@Override
	public double kilobyte_petabyte(double val) {
		
		return val / (1024 * 1024 * 1024 * 1024);
	}

	
	// methods from megabyte to .............
	@Override
	public double megabyte_bit(double val) {
		
		return val * 1024 * 1024 * 8;
	}

	@Override
	public double megabyte_byte(double val) {
		
		return val * 1024 * 1024;
	}

	@Override
	public double megabyte_kilobyte(double val) {
		
		return val * 1024;
	}

	@Override
	public double megabyte_megabyte(double val) {
		
		return val;
	}

	@Override
	public double megabyte_gigabyte(double val) {
		
		return val / 1024.0;
	}

	@Override
	public double megabyte_terabyte(double val) {
		
		return val / (1024 * 1024.0);
	}

	@Override
	public double megabyte_petabyte(double val) {
		
		return val / (1024 * 1024 * 1024);
	}

	
	//methods from gigabyte to ...........
	@Override
	public double gigabyte_bit(double val) {
		
		return val * (1024 * 1024 * 1024 * 8);
	}

	@Override
	public double gigabyte_byte(double val) {
		
		return val * (1024 * 1024 * 1024);
	}

	@Override
	public double gigabyte_kilobyte(double val) {
		
		return val * (1024 * 1024);
	}

	@Override
	public double gigabyte_megabyte(double val) {
		
		return val * 1024;
	}

	@Override
	public double gigabyte_gigabyte(double val) {
		
		return val;
	}

	@Override
	public double gigabyte_terabyte(double val) {
		
		return val / 1024;
	}

	@Override
	public double gigabyte_petabyte(double val) {
		
		return val / (1024 * 1024);
	}

	
	// methods from terabyte to ...............
	@Override
	public double terabyte_bit(double val) {
		
		return val * (1024 * 1024 * 1024 * 1024 * 8);
	}

	@Override
	public double terabyte_byte(double val) {
		
		return val * (1024 * 1024 * 1024 * 1024);
	}

	@Override
	public double terabyte_kilobyte(double val) {
		
		return val * (1024 * 1024 * 1024);
	}

	@Override
	public double terabyte_megabyte(double val) {
		
		return val * (1024 * 1024);
	}

	@Override
	public double terabyte_gigabyte(double val) {
		
		return val * 1024;
	}

	@Override
	public double terabyte_terabyte(double val) {
		
		return val ;
	}

	@Override
	public double terabyte_petabyte(double val) {
		
		return val / 1024;
	}

	
	// methods from petabyte to ............
	@Override
	public double petabyte_bit(double val) {
		
		return val * (1024 * 1024 * 1024 * 1024 * 1024 * 8);
	}

	@Override
	public double petabyte_byte(double val) {
		
		return val * (1024 * 1024 * 1024 * 1024 * 1024);
	}

	@Override
	public double petabyte_kilobyte(double val) {
		
		return val * (1024 * 1024 * 1024 * 1024);
	}

	@Override
	public double petabyte_megabyte(double val) {
		
		return val * (1024 * 1024 * 1024);
	}

	@Override
	public double petabyte_gigabyte(double val) {
		
		return val * (1024 * 1024);
	}

	@Override
	public double petabyte_terabyte(double val) {
		
		return val * 1024;
	}

	@Override
	public double petabyte_petabyte(double val) {
		
		return val;
	}

	
	
	

}
