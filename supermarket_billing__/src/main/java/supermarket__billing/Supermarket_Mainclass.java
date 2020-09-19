package supermarket__billing;

import java.io.IOException;
import java.util.List;

import supermarket__billing.model.Cart;
import supermarket__billing.model.Invoice;
import supermarket__billing.service.FileCartService;
import supermarket__billing.service.FileReaderService;
import supermarket__billing.service.InvoicePrint;

public class Supermarket_Mainclass {
	
	
	public static void main(String[] args) {
//		System.out.println(args[0]);
		try {
			init();
			String filename = null;
//			if (0 < args.length) {
//				filename = args[0];
//			}
			readCustomerCarts(filename); 
			
			generateInvoices();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public static double generateInvoices() {
//			Data.getCarts().forEach(cart -> {
			Invoice invoice = new Invoice(Data.getCarts().get(0));
			System.out.println("klk"+Data.getCarts().get(0));
			invoice.billCartItemsAfterDiscounts();
			Data.setInvoices(invoice);
			InvoicePrint bps = new InvoicePrint();
			double a=bps.printBills(Data.getInvoices());
			System.out.println("ankita"+a);
			return a;
//		});
			
	}


	public static void readCustomerCarts(String inputfile) throws Exception {
		
		FileCartService file_cart = new FileCartService();
		List<Cart> list_cart=file_cart.readBillFromInput(inputfile);
		
		Data.setCarts(list_cart);
	}

	
	public static void init() {
		FileReaderService rs = new FileReaderService();
		Data.init(rs);
	}


}
