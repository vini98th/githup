package pomproject;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
public class BaseClass {
vivi
	


	                       public static WebDriver driver;

	                         // 1.Launch Browser
	                             public static void browserLaunch () {
	                               driver = new ChromeDriver();                            
	                               }
	                             public static void firebrowserLaunch() {
	                               driver = new FirefoxDriver();                          
	                               }

	                        // 2. Get entered url
	                             public static void enterApplnUrl(String url) {                  
	                               driver.get(url);                                            
	                               }

	                       // 3. To maximize the window
	                            public static void maximizeWindow() {
	                              driver.manage().window().maximize() ;                    
	                             }

	                      // 4.1 To insert values in text box
	                            public void elementSendKeys(WebElement element, String data) {
	                              element.sendKeys( data);                                                        
	                              }

	                       // 4.2 Insert text and press Enter in text box
	                            public void elementSendKeysEnter(WebElement element, String data) {               
	                              visibilityOf(element);                                                         
	                              if (isDisplayed(element) && isEnabled(element) && data != null) {             
	                              element.sendKeys(data,Keys.ENTER);                                           
	                              }
	                            }

	                       // 5.To click any buttons/check box.
	                            public void elementClick(WebElement element) {
	                              visibilityOf(element);                                                     
	                              if (isDisplayed(element) && isEnabled(element)) {                           
	                              element.click();                                                                
	                              }
	                            }

	                       // 6.To get Webpage title
	                           public String getApplnTitle() {
	                             String title = driver.getTitle();                                                                               
	                             return title;                                                              
	                            }

	                      // 7.To find Locator by Id
	                           public WebElement LocatorById(String attributeValue) {                                   
	                             WebElement element = null;                                                                      
	                             if (attributeValue != null) {                                                
	                             element = driver.findElement(By.id(attributeValue));                          
	                            }                                                                                 
	                             return element;                                                               
	                            }                                                                                  

	                     // 8.To find Locator by name
	                          public WebElement LocatorByName(String attributeValue) {
	                            WebElement element = null;
	                            if (attributeValue != null) {
	                            element = driver.findElement(By.name(attributeValue));
	                           }
	                           return element;
	                          }

	                     // 9.To find Locator by className
	                          public WebElement LocatorByClassName(String attributeValue) {
	                            WebElement element = null;
	                            if (attributeValue != null) {
	                            element = driver.findElement(By.className(attributeValue));
	                            }
	                           return element;
	                           }

	                     // 10.To find Locator by Xpath
	                            public WebElement LocatorByXpath(String attributeValue) {
	                              WebElement element = null;
	                              if (attributeValue != null) {
	                              element = driver.findElement(By.xpath(attributeValue));
	                              }
	                             return element;
	                             }

	                     // 11.To get the text present
	                           public String getText(WebElement element) {                  
	                             String text = null;                                       
	                             visibilityOf(element);                                     
	                             if (isDisplayed(element)) {                               
	                             text = element.getText();                                     
	                             }
	                            return text;                                              
	                            }

	                     // 12.To get the entered url of a page
	                           public String getApplnCurrentUrl() {                            
	                           String currentUrl = driver.getCurrentUrl();                
	                           return currentUrl;                                         
	                           }
	    
	                     // 13.To accept a Alert
	                            public Alert okAlert() {                                  
	                            Alert alert = driver.switchTo().alert();                 
	                            alert.accept();                                           
	                            return alert;                                             
	                           }

	                     // 14.To dismiss a Alert
	                            public Alert cancelAlert() {                              
	                            Alert alert = driver.switchTo().alert();                  
	                            alert.dismiss();                                          
	                            return alert;                                             
	                           }

	                     // 15.To insert a value in the particular textbox
	                            public Alert alertSendkeys(String value) {
	                            Alert alert = null;
	                            if (value != null) {
	                            alert = driver.switchTo().alert();
	                            alert.sendKeys(value);
	                           }
	                           return alert;
	                           }

	                       // 16.Get the entered value from textbox(For 99% of fixed attribute
	                       // value)--->getAttribute()
	                           public String elementGetAttribute(WebElement element) {
	                           String attribute = null;
	                           visibilityOf(element);
	                           if (isDisplayed(element)) {
	                           attribute = element.getAttribute("value");
	                           }
	                           return attribute;
	                          }

	                       // 17.Get the entered value from textbox(For 1% of dynamic attribute
	                       // value)--->getAttribute()
	                            public String elementGetAttribute(WebElement element, String attributeName) {
	                            String attribute = null;
	                            visibilityOf(element);
	                            if (isDisplayed(element) && attributeName != null) {
	                            attribute = element.getAttribute(attributeName);
	                            }
	                           return attribute;
	                           }

	                       // 18.DropDown--->selectByIndex()
	                              public void selectOptionByIndex(WebElement element, int index) {
	                              visibilityOf(element);
	                              if (isDisplayed(element)) {
	                              Select select = new Select(element);
	                              select.selectByIndex(index);
	                              }
	                              }

	                        // 19.DropDown--->selectByValue()
	                               public void selectOptionByValue(WebElement element, String value) {
	                               visibilityOf(element);
	                               if (value != null && isDisplayed(element)) {
	                               Select select = new Select(element);
	                               select.selectByValue(value);
	                              }
	                              }

	                         // 20.DropDown--->selectByVisibleText()
	                                 public void selectOptionByVisibleText(WebElement element, String text) {
	                                 visibilityOf(element);
	                                 if (text != null && isDisplayed(element)) {
	                                 Select select = new Select(element);
	                                 select.selectByVisibleText(text);
	                                    }
	                                  }

	// 21.DropDown--->getOptions()(get all the options in DD)
	public List<WebElement> getOptionsInDd(WebElement element) {
	List<WebElement> options = null;
	visibilityOf(element);
	if (isDisplayed(element)) {
	Select select = new Select(element);
	options = select.getOptions();
	}
	return options;
	}

	// 22.DropDown--->getAllSelectedOptions()(get all the options in DD)
	public List<WebElement> getAllSelectedOptionsInDd(WebElement element) {
	List<WebElement> options = null;
	visibilityOf(element);
	if (isDisplayed(element)) {
	Select select = new Select(element);
	options = select.getOptions();
	}
	return options;
	}

	// 23.DropDown--->getFirstSelectedOption()
	public WebElement getFirstSelectedOptionsInDd(WebElement element) {
	WebElement element1 = null;
	visibilityOf(element);
	if (isDisplayed(element)) {
	Select select = new Select(element);
	element1 = select.getFirstSelectedOption();
	}
	return element1;
	}

	// 24.verify in DropDown in multi select option?
	public boolean ddnMultiValueSelection(WebElement element) {
	visibilityOf(element);
	Select select = new Select(element);
	boolean multiple = select.isMultiple();
	System.out.println(multiple);
	return multiple;
	}

	// 25.DropDown--->deselectByIndex()
	public void deSelectOptionByIndex(WebElement element, int index) {
	visibilityOf(element);
	if (isDisplayed(element)) {
	Select select = new Select(element);
	select.deselectByIndex(index);
	}
	}

	// 26.DropDown--->deselectByValue()
	public void deSelectOptionByValue(WebElement element, String value) {
	visibilityOf(element);
	if (isDisplayed(element) && value != null) {
	Select select = new Select(element);
	select.deselectByValue(value);
	}
	}

	// 27.DropDown--->deselectByVisibleText()
	public void deSelectOptionByVisibleText(WebElement element, String text) {
	visibilityOf(element);
	if (isDisplayed(element) && text != null) {
	Select select = new Select(element);
	select.deselectByVisibleText(text);
	}
	}

	// 28.DropDown--->deselectAll()
	public void deSelectOptionsAll(WebElement element) {
	visibilityOf(element);
	if (isDisplayed(element)) {
	Select select = new Select(element);
	select.deselectAll();
	}
	}

	// 29.To insert a value using JS
	public void insertValueJs(WebElement element, String data) {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	// 30.To click using JS
	public void clickJs(WebElement element) {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click()", element);
	}
	// 31.To scroll the page
	public void scrollPageJs(WebElement element, String data) {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].scrollIntoView()", element);
	}
	// 32.switch to frame By index-->
	public WebDriver switchFrameByIndex(int index) {
	WebDriver frame = driver.switchTo().frame(index);
	return frame;
	}
	// 33.switch to frame By id-->
	public WebDriver switchFrameById(String id) {
	WebDriver frame = null;
	if (id != null) {
	frame = driver.switchTo().frame(id);
	}
	return frame;
	}
	// 34.switch to frame By name-->
	public WebDriver switchFrameByName(String name) {
	WebDriver frame = null;
	if (name != null) {
	frame = driver.switchTo().frame(name);
	}
	return frame;
	}
	// 35.switch to frame By iframe Tag(WebElement)-->
	public WebDriver switchFrameByWebElement(WebElement element) {
	WebDriver frame = null;
	visibilityOf(element);
	if (isDisplayed(element)) {
	frame = driver.switchTo().frame(element);
	}
	return frame;
	}
	// 36.Return to parent frame
	public WebDriver switchToParentFrame() {
	WebDriver frame = driver.switchTo().parentFrame();
	return frame;
	}
	// 37.Return to window from frame
	public WebDriver switchFrameToWindow() {
	WebDriver frame = driver.switchTo().defaultContent();
	return frame;
	}
	// 38.To print number of rows in the table
	public void numberOfRowsInTable(WebElement element) {
	visibilityOf(element);
	if (isDisplayed(element)) {
	List<WebElement> tableRow = element.findElements(By.tagName("tr"));
	System.out.println(tableRow.size());
	}
	}
	// 39.To print number of columns in the table
	public void numberOfColumnInTable(WebElement element) {
	visibilityOf(element);
	if (isDisplayed(element)) {
	List<WebElement> tableColumn = element.findElements(By.tagName("th"));
	System.out.println(tableColumn.size());
	}
	}
	// 40.To print number of data in the table
	public void numberOfDataInTable(WebElement element) {
	visibilityOf(element);
	if (isDisplayed(element)) {
	List<WebElement> tableData = element.findElements(By.tagName("td"));
	System.out.println(tableData.size());
	}
	}
	// 41.switch to window by windowId
	public WebDriver switchByWindowId(String id) {
	WebDriver window = null;
	if (id != null) {
	window = driver.switchTo().window(id);
	}
	return window;
	}
	// 42.switch to window by windowUrl
	public WebDriver switchByWindowUrl(String url) {
	WebDriver window = null;
	if (url != null) {
	window = driver.switchTo().window(url);
	}
	return window;
	}
	// 43.switch to window by windowTitle
	public WebDriver switchByWindowTitle(String title) {
	WebDriver window = null;
	if (title != null) {
	window = driver.switchTo().window(title);
	}
	return window;
	}
	// 44.To Get child window
	public String getChildWindow() {
	String windowHandle = driver.getWindowHandle();
	return windowHandle;
	}
	// 45.To Get all windows
	public Set<String> getAllWindows() {
	Set<String> windowHandles = driver.getWindowHandles();
	return windowHandles;
	}
	// 46.Implicit wait
	public void implicitWait(int seconds) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	// 47.Implicit wait default
	public static void implicitWait() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	// 48.Explicit wait--->visibilityOfElementLocated
	public WebElement visibilityOf(int seconds, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	WebElement until = wait.until(ExpectedConditions.visibilityOf(element));
	return until;
	}
	// 49.Explicit wait--->visibilityOfElementLocated
	public WebElement visibilityOf(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	WebElement until = wait.until(ExpectedConditions.visibilityOf(element));
	return until;
	}
	// 50.Explicit wait--->elementToBeClickable
	public WebElement explicitWaitByClick(int seconds, String xpathExpression) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
	return until;
	}
	// 51.clear textbox
	public void clearTextbox(WebElement element) {
	visibilityOf(element);
	if (isDisplayed(element)) {
	element.clear();
	}
	}
	// 52.TakesScreenShot for a page
	public void takesScreenshotPage(String name) throws IOException {
	if (name != null) {
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File s = screenshot.getScreenshotAs(OutputType.FILE);
	File d = new File("C:\\Users\\niresh\\eclipse-workspace\\sample\\screenshot" + name + ".png");
	Files.copy(s, d);
	}
	}
	// 53.TakesScreenshot for a element
	public void takesScreenshotElement(WebElement element, String name) throws IOException {
	if (isDisplayed(element) && name != null) {
	File s = element.getScreenshotAs(OutputType.FILE);
	File d = new File("C:\\Users\\niresh\\eclipse-workspace\\sample\\screenshot" + name + ".png");
	Files.copy(s, d);
	}
	}
	// 54.MouseOverAction for single option
	public void mouseOverActions(WebElement element) {
	visibilityOf(element);
	if (isDisplayed(element)) {
	Actions actions = new Actions(driver);
	actions.contextClick(element).perform();
	}
	}
	// 55.DragAndDrop
	public void mouseDragAndDrop(WebElement element1, WebElement element2) {
	visibilityOf(element1);
	visibilityOf(element2);
	if (isDisplayed(element1) && isDisplayed(element2)) {
	Actions actions = new Actions(driver);
	actions.dragAndDrop(element1, element2).perform();
	}
	}
	// 56.RightClick
	public void mouseRightClick(WebElement element) {
	visibilityOf(element);
	if (isDisplayed(element)) {
	Actions actions = new Actions(driver);
	actions.contextClick(element).perform();
	}
	}
	// 57.DoubleClick
	public void mouseDoubleClick(WebElement element) {
	visibilityOf(element);
	if (isDisplayed(element)) {
	Actions actions = new Actions(driver);
	actions.doubleClick(element).perform();
	}
	}
	// 58.Insert value in Textbox and enter
	public void insertAndEnterParallely(WebElement element, String value) {
	visibilityOf(element);
	if (isDisplayed(element) && value != null) {
	element.sendKeys(value, Keys.ENTER);
	}
	}
	// 59.Refresh page
	public void refreshPage() {
	driver.navigate().refresh();
	}
	// 60.To forward a page
	public void forwardpage() {
	driver.navigate().forward();
	}
	// 61.To back a page
	public void backPage() {
	driver.navigate().back();
	}
	// 62.navigate to()
	public void navigateTo(String url) {
	if (url != null) {
	driver.navigate().to(url);
	}
	}
	// 63.verify isSelected(rdo btn/check Box)
	public boolean isSelected(WebElement element) {
	boolean b = element.isSelected();
	System.out.println(b);
	return b;
	}
	// 64.verify isEnabled(text/button-->edit/click-->yes/no
	public boolean isEnabled(WebElement element) {
	boolean b = element.isEnabled();
	return b;
	}
	// 65.verify isDisplayed
	public boolean isDisplayed(WebElement element) {
	boolean b = element.isDisplayed();
	return b;
	}
	// 66.close all windows
	public static void quitWindows() {
	driver.quit();
	}
	// 67.close current window
	public void closeWindows() {
	driver.close();
	}
	// 68.Read the cell value
	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
	@SuppressWarnings("unused")
	String res = null;
	File file = new File("C:\\Users\\niresh\\eclipse-workspace\\sample\\excel\\Book1.xlsx");
	FileInputStream fileInputStream = new FileInputStream(file);
	@SuppressWarnings("resource")
	Workbook workbook = new XSSFWorkbook(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	CellType type = cell.getCellType();
	switch (type) {
	case STRING:
	res = cell.getStringCellValue();
	break;
	case NUMERIC:
	if (DateUtil.isCellDateFormatted(cell)) {
	Date dateCellValue = cell.getDateCellValue();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
	res = dateFormat.format(dateCellValue);
	} else {
	double numericCellValue = cell.getNumericCellValue();
	long round = Math.round(numericCellValue);
	if (numericCellValue == round) {
	res = String.valueOf(round);
	} else {
	res = String.valueOf(numericCellValue);
	}
	}
	break;
	default:
	break;
	}
	return res;
	}
	// 69. update the data
	public void updateCelldata(String sheetName, int rownum, int cellnum, String oldData, String newData)
	throws IOException {
	File file = new File("C:\\Users\\niresh\\eclipse-workspace\\sample\\excel\\Book1.xlsx");
	FileInputStream fileInputStream = new FileInputStream(file);
	@SuppressWarnings("resource")
	Workbook workbook = new XSSFWorkbook(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	String value = cell.getStringCellValue();
	if (value.equals(oldData)) {
	cell.setCellValue(newData);
	}
	FileOutputStream fileOutputStream = new FileOutputStream(file);
	workbook.write(fileOutputStream);
	}
	// 70. To write the cell data
	public void writeCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {
	File file = new File("C:\\Users\\niresh\\eclipse-workspace\\sample\\excel\\Book1.xlsx");
	FileInputStream fileInputStream = new FileInputStream(file);
	@SuppressWarnings("resource")
	Workbook workbook = new XSSFWorkbook(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	cell.setCellValue(data);
	FileOutputStream fileOutputStream = new FileOutputStream(file);
	workbook.write(fileOutputStream);
	}
	// 71. To write the cell data
	public void createCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {
	File file = new File("C:\\Users\\niresh\\eclipse-workspace\\sample\\excel\\Book1.xlsx");
	FileInputStream fileInputStream = new FileInputStream(file);
	@SuppressWarnings("resource")
	Workbook workbook = new XSSFWorkbook(fileInputStream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
	Cell cell = row.createCell(cellnum);
	cell.setCellValue(data);
	FileOutputStream fileOutputStream = new FileOutputStream(file);
	workbook.write(fileOutputStream);
	}
	//72. Press Tab and Enter
	public void keyTabEnter() throws AWTException {
	Robot rbt = new Robot();
	rbt.keyPress(KeyEvent.VK_TAB);
	rbt.keyRelease(KeyEvent.VK_TAB);
	rbt.keyPress(KeyEvent.VK_ENTER);
	rbt.keyRelease(KeyEvent.VK_ENTER);
	}
	}



