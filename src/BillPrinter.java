import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BillPrinter {

	public static void printBill(Bill bill) {
		// Adding Pharmacy information

		String billInfo = printInCenter(PharmacyAddress.NAME, " ") + "\n"
				+ printInCenter(PharmacyAddress.ADDRESS, " ") + "\n"
				+ printInCenter(PharmacyAddress.GSTINVOICENUMBER, " ") + "\n"
				+ printInCenter(PharmacyAddress.DLNO, " ") + "\n"
				+ printInCenter(PharmacyAddress.PHONE, " ") + "\n";

		// Adding Bill Information

		billInfo += printInLast(getBillTimeInFormat(bill.getBillTime())) + "\n"
				+ printLine()
				+ "Dr  : " + bill.getDoctorName() + "\n"
				+ "Pt. : " + bill.getPatientName() + "\n"
				+ printLine()
				+ "BILL NO. :  " + String.format("%06d", bill.getBillNo())
				+ "                   GST BILL              "
				+ "Date: " + getBillDateInFormat(bill.getBillDate()) + "\n"
				+ printLine();

		// Adding headings
		billInfo += String.format("%-3s %-20s %-4s%-4s %-5s %-5s %-5s   %6s  %4s   %6s%n", "QTY", "Description", "HSN",
				"Code", "Mfr", "Locn", "Batch", "Expiry", "GST%", "Amount");

		// Adding Bill items
		List<BillItem> billItems = bill.getBillItems();
		for (BillItem item : billItems) {
			Medicine medicine = item.getMedicine();
			billInfo += String.format("%-3d %-20s %-4d%-4d %-5s %-5s %-5s   %6s  %.1f   %6.2f%n", item.getQuantity(), medicine.getName(), medicine.getHsn(), medicine.getCode(), medicine.getManufacturer(), medicine.getLocn(), medicine.getBatch(), getBillItemDateInFormat(medicine.getExpireDate()), medicine.getGstPercentage(), item.getTotalAmount());
		}

		// Adding Total Information
		billInfo += printLine()
				  + String.format("Item(s): %5d Check.by:    |     %-17s|        Total:%9.2f%n", billItems.size(), bill.getReviewer(), bill.getTotalCost())
				  + printLine();

		// Adding Offer
		String discountPercent = String.format("%.2f", (bill.getDiscountPercentage())/100);
		billInfo += printInCenter(("R.Off:   " + discountPercent ), "-") + "\n";

		// Adding discount rate
		if(bill.isRegularCustomer())
		{
			String discountAmount = String.format("LESS 10.00%s DISCOUNT = %9.2f","%", bill.getDiscountAmount());
			billInfo += printInLast(discountAmount) + "\n";
			billInfo += printLine();
		}

		// Adding total amount with discount
		double amount = bill.getTotalCost() - bill.getDiscountAmount();
		String str = String.format("%.2f", amount);
		billInfo += printInLast(str);

		System.out.println(billInfo);

	}

	public static String getBillDateInFormat(LocalDate billDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = billDate.format(formatter);
		return formattedDate;
	}

	public static String getBillItemDateInFormat(LocalDate billItemDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
		String formattedDate = billItemDate.format(formatter);
		return formattedDate;
	}

	public static String getBillTimeInFormat(LocalTime billTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String formattedDate = billTime.format(formatter);
		return formattedDate;
	}

	public static String printLine() {
		return "---------------------------------------------------------------------------" + "\n";
	}

	public static String printInCenter(String text, String delim) {
		String str = "";

		int strlen = text.length();
		int lineLength = 75;
		int delimLength = lineLength - strlen;

		for (int i = 1; i <= delimLength / 2; i++) {
			str += delim;
		}

		str += text;

		for (int i = 1; i <= delimLength / 2; i++) {
			str += delim;
		}

		return str;
	}

	public static String printInLast(String text) {
		String str = "";

		int strlen = text.length();
		int lineLength = 75;
		int spaceLength = lineLength - strlen;

		for(int i = 1; i <= spaceLength; i++) {
			str += " ";
		}

		str += text;

		return str;
	}
}
