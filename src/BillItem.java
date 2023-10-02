public class BillItem {

	private Medicine medicine;
	private int quantity;
	private double totalAmount;
	
	public BillItem() {
		
	}
	
	public BillItem(Medicine medicine, int quantity)
	{
		this.medicine = medicine;
		this.quantity = quantity;
		this.setTotalAmount();
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void setTotalAmount()
	{
		double totalAmount =  this.medicine.getPrice() * this.quantity;
		this.setTotalAmount(totalAmount);
	}


}
