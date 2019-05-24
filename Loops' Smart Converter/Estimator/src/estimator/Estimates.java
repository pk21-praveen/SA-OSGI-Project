package estimator;

/**
 * @author Shriram
 *
 */

public class Estimates {
	
	private String areaIn;
	private Double areaSize;
	private String currencyIn;
	private Double unitPrice;
	private String areaOut;
	private String currencyOut;
	

	public Estimates() {
		this.areaIn = null;
		this.areaSize = null;
		this.currencyIn = null;
		this.unitPrice = null;
		this.areaOut = null;
		this.currencyOut = null;
	}
	
	public Estimates(String areaIn, Double areaSize, String currencyIn, Double unitPrice, String areaOut,String currencyOut) {
		this.areaIn = areaIn;
		this.areaSize = areaSize;
		this.currencyIn = currencyIn;
		this.unitPrice = unitPrice;
		this.areaOut = areaOut;
		this.currencyOut = currencyOut;
	}

	public void setAreaIn(String areaIn) {
		this.areaIn = areaIn;
	}

	public void setAreaSize(Double areaSize) {
		this.areaSize = areaSize;
	}

	public void setCurrencyIn(String currencyIn) {
		this.currencyIn = currencyIn;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setAreaOut(String areaOut) {
		this.areaOut = areaOut;
	}

	public void setCurrencyOut(String currencyOut) {
		this.currencyOut = currencyOut;
	}

	public String getAreaIn() {
		return areaIn;
	}

	public Double getAreaSize() {
		return areaSize;
	}

	public String getCurrencyIn() {
		return currencyIn;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public String getAreaOut() {
		return areaOut;
	}

	public String getCurrencyOut() {
		return currencyOut;
	}
	
		
}
