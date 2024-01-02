package pomproject;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public  class ExcutiontestNG extends BaseClass{
	
	@BeforeClass
	public static void bfrclass() {
		browserLaunch();
		enterApplnUrl("https://www.omrbranch.com/");
		maximizeWindow();
		implicitWait();
	}
	
//    @AfterClass
//     public static void afterclas () {
////    	quitWindows();
//}
    @Test
    public void tc1() {
    	pomtClass1 class1=new pomtClass1();
    	class1.login("vinith2416@gmail.com", "v@N1th0055");
    	
    }
     @Test
     public void tc2() throws InterruptedException {

		pomClass2 class2=new pomClass2();
		class2.pomClas("Andhra Pradesh","Tirupati","Standard", "2023-12-14","2023-12-16","1","2","2");
    	 Assert.assertEquals("verify",class2.srting(),"Welcome Vinith");

	}
     
}
