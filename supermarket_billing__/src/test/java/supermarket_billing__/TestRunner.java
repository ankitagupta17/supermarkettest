package supermarket_billing__;

public class TestRunner {

	
		   public static void main(String[] args) {
		      Result result = JUnitCore.runClasses(TestJunit.class);
		      for (Failure failure : result.getFailures()) {
		         System.out.println(failure.toString());
		      }
		      System.out.println("Result=="+result.wasSuccessful());
		   }
		
}
