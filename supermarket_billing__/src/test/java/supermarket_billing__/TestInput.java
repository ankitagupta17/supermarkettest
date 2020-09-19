package supermarket_billing__;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import supermarket__billing.Supermarket_Mainclass;
import supermarket__billing.exception.QuantityZeroException;
import supermarket__billing.model.Cart;
import supermarket__billing.service.FileCartService;

public class TestInput {
	
	@Rule
    public final ExpectedException exception = ExpectedException.none();
	

	@Test
	public void Testcase2() {
		Supermarket_Mainclass.init();
		try {
			Supermarket_Mainclass.readCustomerCarts("src\\test\\resources\\input2.txt");
			exception.expect(QuantityZeroException.class);
			exception.expectMessage("There exists an item with quantity zero, Please enter correct value./");
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		FileCartService fs=new FileCartService();
//		fs.readBillFromInput("input.txt");
//		exception.expect(QuantityZeroException.class);
//		exception.expectMessage("There exists an item with quantity zero, Please enter correct value./");
	}
	
	@Test
	public void Testcase1() {
		try {
			Supermarket_Mainclass.init();
			Supermarket_Mainclass.readCustomerCarts("src\\test\\resources\\input.txt");
			double a=Supermarket_Mainclass.generateInvoices();
			assertEquals(a, 1860.00);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
