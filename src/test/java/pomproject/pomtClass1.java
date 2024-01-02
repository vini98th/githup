package pomproject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomtClass1 extends BaseClass  {
 public pomtClass1() {
	 PageFactory.initElements(driver, this);
 }

@FindBy(id="pass")
 private WebElement txtpass;
 @FindBy(xpath="//button[@type=\"submit\"][1]")
 private WebElement textlogin;
 
 
 
 @FindBy(id="email")
 private WebElement txtemail;
 public WebElement getTxtemail() {
	return txtemail;
}
public void setTxtemail(WebElement txtemail) {
	this.txtemail = txtemail;
}
public WebElement getTxtpass() {
	return txtpass;
}
public void setTxtpass(WebElement txtpass) {
	this.txtpass = txtpass;
}
public WebElement getTextlogin() {
	return textlogin;
}
public void setTextlogin(WebElement textlogin) {
	this.textlogin = textlogin;
}

 
 
  public void login(String email, String pass) {
	  elementSendKeys(getTxtemail(), email);
	  elementSendKeys(getTxtpass(), pass);
	  elementClick(textlogin);
  }
 
  
	     

}
 
 
 
 
 

