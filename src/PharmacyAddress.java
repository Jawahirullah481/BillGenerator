import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PharmacyAddress {

	public static final String NAME;
	public static final String ADDRESS;
	public static final String GSTINVOICENUMBER;
	public static final String DLNO;
	public static final String PHONE;
	
	static {
		
		InputStream is = PharmacyAddress.class.getResourceAsStream("resources/pharmacy.properties");
		Properties informations = new Properties();
		
		try {
			informations.load(is);
		} catch (IOException e) {
			System.out.println("Error while fetching data from properties file");
			e.printStackTrace();
		}
		
		NAME = informations.getProperty("NAME");
		ADDRESS = informations.getProperty("ADDRESS");
		GSTINVOICENUMBER = informations.getProperty("GSTIN");
		DLNO = informations.getProperty("DLNO");
		PHONE = informations.getProperty("PHONE");
		
	}
	
}
