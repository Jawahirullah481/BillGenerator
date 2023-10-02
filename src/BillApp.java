import java.util.Scanner;

public class BillApp {
		
	public static void main(String[] args) {
		
		Scanner get = new Scanner(System.in);
		BillGenerator billGenerator = new BillGenerator();
		do {
			
			Bill bill = billGenerator.PrepareBill();
			BillPrinter.printBill(bill);
			
		}while(get.next().equals("Yes"));
		
		get.close();

	}
}
