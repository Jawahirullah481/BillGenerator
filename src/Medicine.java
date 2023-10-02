import java.time.LocalDate;

public class Medicine{

	private String name;
	private int hsn;
	private Integer code;
	private String manufacturer;
	private String locn;
	private String batch;
	private LocalDate expireDate;
	private double gstPercentage;
	private double price;
	
	
	public Medicine() {
		
	}
	
	public Medicine(String name, int hsn, Integer code, String manufacturer, String locn, String batch, String expireDate, double gstPercentage, double price) {
		this.name = name;
		this.hsn = hsn;
		this.code = code;
		this.manufacturer = manufacturer;
		this.locn = locn;
		this.batch = batch;
		this.setExpireDate(expireDate);
		this.gstPercentage = gstPercentage;
		this.price = price;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHsn() {
		return hsn;
	}

	public void setHsn(int hsn) {
		this.hsn = hsn;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLocn() {
		return locn;
	}

	public void setLocn(String locn) {
		this.locn = locn;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}


	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	
	public void setExpireDate(String expireDateString)
	{
		String[] expireStrings = expireDateString.split("/");
		LocalDate expireDate = LocalDate.of(Integer.parseInt(expireStrings[1]), Integer.parseInt(expireStrings[0]), 01);
		this.setExpireDate(expireDate);
	}

	public double getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(double gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
