import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Bill {

	private int billNo;
	private LocalDate billDate;
	private LocalTime billTime;
	private String doctorName;
	private String patientName;
	private int noOfItems;
	private String reviewer;
	private double totalCost;
	private double discountPercentage;
	private double discountAmount;

	private boolean isRegularCustomer;
	private List<BillItem> billItems = new ArrayList<>();

	public Bill() {
		this.billNo = BillGenerator.billNo++;
		this.doctorName = "DR. SOMESH VANCHILINGAM MD";
		this.billDate = LocalDate.now();
		this.billTime = LocalTime.now();
		this.totalCost = 0.0;
	}

	public Bill(String patientName, String reviewer, boolean isRegularCustomer, List<BillItem> billItems) {
		this();
		this.patientName = patientName;
		this.reviewer = reviewer;
		this.isRegularCustomer = isRegularCustomer;
		this.billItems = billItems;

		this.setDiscountPercentage();
		this.setNoOfItems(billItems.size());
		this.setTotalCost();
		this.setDiscountAmount();
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public LocalTime getBillTime() {
		return billTime;
	}

	public void setBillTime(LocalTime billTime) {
		this.billTime = billTime;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost() {

		for (BillItem item : billItems) {
			this.totalCost += item.getTotalAmount();
		}
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage() {
		this.discountPercentage = (this.isRegularCustomer) ? 10.0 : 0.0;
	}

	public boolean isRegularCustomer() {
		return isRegularCustomer;
	}

	public void setRegularCustomer(boolean isRegularCustomer) {
		this.isRegularCustomer = isRegularCustomer;
	}

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public void setBillItems(List<BillItem> billItems) {
		this.billItems = billItems;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount() {
		this.discountAmount = (totalCost / discountPercentage);
	}

}
