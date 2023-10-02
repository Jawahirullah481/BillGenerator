import java.util.List;

public class BillGenerator {

	public static int billNo = 1;
	
	public Bill PrepareBill()
	{
						
			Medicine med1 = new Medicine("Teltsan", 3306, 9099, "Sanre", null, "3002", "12/24", 12.0, 9.8);
			Medicine med2 = new Medicine("Sangaba-at", 3306, 9099, "Sanre", null, "710E", "06/25", 12.0, 15.26);
			Medicine med3 = new Medicine("Rosurey cv", 3306, 9099, "Sanre", null, "213C", "11/24", 12.0, 14.46);
			Medicine med4 = new Medicine("Duloxsan", 3306, 9099, "Sanre", null, "4393", "04/25", 12.0, 8.0);
			Medicine med5 = new Medicine("Duloxsan", 3306, 9099, "Sanre", null, "4393", "04/25", 12.0, 4.0);
			
			BillItem item1 = new BillItem(med1, 30);
			BillItem item2 = new BillItem(med2, 15);
			BillItem item3 = new BillItem(med3, 15);
			BillItem item4 = new BillItem(med4, 15);
			BillItem item5 = new BillItem(med5, 15);
			
			List<BillItem> billItems = List.of(item1, item2, item3, item4, item5);
			
			Bill bill = new Bill("Mrs. XYZ", "K. ABC", true, billItems);
			
		return bill;
	}
	
}
