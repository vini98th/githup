package pomproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomClass2 extends BaseClass{
	public  pomClass2() {
		PageFactory.initElements(driver,this);
		
	}
     
     public WebElement getText() {
		return text;
	}
	public void setText(WebElement text) {
		this.text = text;
	}
	public WebElement getTamilnadu() {
		return tamilnadu;
	}
	public void setTamilnadu(WebElement tamilnadu) {
		this.tamilnadu = tamilnadu;
	}
	public WebElement getChennai() {
		return chennai;
	}
	public void setChennai(WebElement chennai) {
		this.chennai = chennai;
	}
	public WebElement getRoomvilla() {
		return roomvilla;
	}
	public void setRoomvilla(WebElement roomvilla) {
		this.roomvilla = roomvilla;
	}
	public WebElement getDay() {
		return day;
	}
	public void setDay(WebElement day) {
		this.day = day;
	}
	public WebElement getDays() {
		return days;
	}
	public void setDays(WebElement days) {
		this.days = days;
	}
	public WebElement getNoroom() {
		return noroom;
	}
	public void setNoroom(WebElement noroom) {
		this.noroom = noroom;
	}
	public WebElement getOne() {
		return one;
	}
	public void setOne(WebElement one) {
		this.one = one;
	}
	public WebElement getTwo() {
		return two;
	}
	public void setTwo(WebElement two) {
		this.two = two;
	}

	@FindBy(xpath="(//li[@class='dropdown'])[1]")
     private WebElement text;
	 @FindBy(id="state")
     private WebElement tamilnadu;
     @FindBy(id="city")
     private WebElement chennai;
     @FindBy(id="room_type")
     private WebElement roomvilla;
     @FindBy(name ="check_in")
     private WebElement day;
     @FindBy(name ="check_out")
     private WebElement days;
     @FindBy(id="no_rooms")
     private WebElement noroom;
     @FindBy(id="no_adults")
     private WebElement one;
     @FindBy(id="no_child")
     private WebElement two;
	

     
     public void pomClas(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8) throws InterruptedException {
		
    	 
         selectOptionByValue(getTamilnadu(), value1);
         Thread.sleep(3000);
         selectOptionByVisibleText(chennai, value2);
         selectOptionByValue(getRoomvilla(), value3);
         elementSendKeysEnter(getDay(), value4);
         elementSendKeysEnter(getDays(), value5);
         selectOptionByValue(getNoroom(), value6);
         selectOptionByValue(getOne(), value7);
         elementSendKeys(getTwo(), value8);
         
         
	}
    	 
     

     public String srting() {
		
          String text2 = getText(getText());
          System.out.println(text2);
          return text2;
	}
     
	
	}
    
     
     
     
     
     
     
     
     

