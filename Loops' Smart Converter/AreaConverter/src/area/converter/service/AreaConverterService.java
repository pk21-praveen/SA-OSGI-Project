package area.converter.service;

public interface AreaConverterService {

	//Square Feet to Square Meters,Acres,Hectares,Square kilometers,Square Miles
	public double SquareFeetsToSquareFeets(double sf);
	public double SquareFeetsToSquareMeters(double sf);
	public double SquareFeetsToAcres(double sf);
	public double SquareFeetsToHectares(double sf);
	public double SquareFeetsToSquareKilometers(double sf);
	public double SquareFeetsToSquareMiles(double sf);
	
	//Square Meters to Square Feet,Acres,Hectares,Square kilometers,Square Miles
	public double SquareMetersToSquareMeters(double sm);
	public double SquareMetersToSquareFeets(double sm);
	public double SquareMetersToAcres(double sm);
	public double SquareMetersToHectares(double sm);
	public double SquareMetersToSquareKilometers(double sm);
	public double SquareMetersToSquareMiles(double sm);
	
	//Acres to Square Feet,Square Meters,Hectares,Square kilometers,Square Miles
	public double AcresToAcres(double ars);
	public double AcresToSquareFeets(double ars);
	public double AcresToSquareMeters(double ars);
	public double AcresToHectares(double ars);
	public double AcresToSquareKilometers(double ars);
	public double AcresToSquareMiles(double ars);
	
	//Hectares to Square Feet,Square Meters,Acres,Square kilometers,Square Miles
	public double HectaresToHectares(double hts);
	public double HectaresToSquareFeets(double hts);
	public double HectaresToSquareMeters(double hts);
	public double HectaresToAcres(double hts);
	public double HectaresToSquareKilometers(double hts);
	public double HectaresToSquareMiles(double hts);
	
	//Square kilometers to Square Feet,Square Meters,Acres,Hectares,Square Miles
	public double SquareKilometersToSquareKilometers(double sk);
	public double SquareKilometersToSquareFeets(double sk);
	public double SquareKilometersToSquareMeters(double sk);
	public double SquareKilometersToAcres(double sk);
	public double SquareKilometersToHectares(double sk);
	public double SquareKilometersToSquareMiles(double sk);
	
	//Square Miles to Square Feet,Square Meters,Acres,Hectares,Square kilometers
	public double SquareMilesToSquareMiles(double sm);
	public double SquareMilesToSquareFeets(double sm);
	public double SquareMilesToSquareMeters(double sm);
	public double SquareMilesToAcres(double sm);
	public double SquareMilesToHectares(double sm);
	public double SquareMilesToSquareKilometers(double sm);
	
	
}
