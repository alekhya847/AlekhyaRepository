package orange;

import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Tc2addemployee {
	
	@Test
	public static void HRM()throws Exception {
		
			System.setProperty("webdriver.chrome.driver","C:\\alekhya\\chromedriver.exe");
			ChromeDriver x=new ChromeDriver();
			x.manage().window().maximize();	
			WebDriverWait wait=new WebDriverWait(x,60);
			Actions Act=new Actions(x);
			x.get("http://apps.qaplanet.in/hrm/");
            //wait for homepage
			wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
			//verify homepage displayed or not
			if(x.getTitle().equals("OrangeHRM - New Level of HR Management"))
			{
				System.out.println("homepage displayed");
			}
			//create web elements for un,pwd,login,clear
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName"))).sendKeys("qaplanet2");
			x.findElement(By.name("txtPassword")).sendKeys("lab2");
			WebElement objlogin=x.findElement(By.name("Submit"));
			objlogin.click();
			//get welcome text
			String sWelText=x.findElement(By.tagName("li")).getText();
			//verify welcome text
			if(sWelText.equals("welcome"+"qaplanet2"))
			{
				System.out.println("welcome"+"qaplanet2"+"displayed");
			}
			//verify only username
			String[]Arr=sWelText.split(" ");
			if(Arr[1].equals("qaplanet2"))
			{
				System.out.println("qaplanet2"+"displayed");
			}
			//create web element for change password and logout
			WebElement objCP=x.findElement(By.linkText("Change Password"));
			WebElement objlogout=x.findElement(By.linkText("Logout"));
			//verify change password and logout
			if(objCP.isDisplayed()&&objlogout.isDisplayed())
			{
				System.out.println("change password and logout are dispalyed");
			}
			//create webelements for Pim
			WebElement objPIM=x.findElement(By.linkText("PIM"));
			//mouse over on pim
			Act.moveToElement(objPIM).perform();
			//click on add employee
			x.findElement(By.linkText("Add Employee")).click();
			//wait 2sec
			Thread.sleep(2000);
			//Switch to frame
			x.switchTo().frame("rightMenu");
			//verify pim:add employee
			if(x.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee"))
			{
				System.out.println("PIM : Add Employee displayed");
			}
			String sFN="penchala";
			String sLN="alekhya";
			//get employee code
			String sEmpCode=x.findElement(By.id("txtEmployeeId")).getAttribute("value");
			//create webelement
			WebElement objsave=x.findElement(By.id("btnEdit"));
			//click on save
			objsave.click();
			//wait for alert
			Alert A;
			A=wait.until(ExpectedConditions.alertIsPresent());
			//verify alert message
			if(A.getText().equals("Last Name Empty!"))
			{
				System.out.println("Last Name Empty! displayed");
				A.accept();
			}
			//enter last name
			x.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
			//click on save
			objsave.click();
			//wait for alert
			A=wait.until(ExpectedConditions.alertIsPresent());
			//verify alert message
			if(A.getText().equals("First Name Empty!"))
			{
				System.out.println("First Name Empty! dispalyed");
			A.accept();
			}
			//enter first name
			x.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
			Thread.sleep(2000);
			
			Act.click(x.findElement(By.id("photofile"))).perform();
			//create object for robot class
			Robot rt=new Robot();
			//load image path/any file data
			StringSelection ss=new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
			Thread.sleep(2000);
			//set image path to default window
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
			//wait
			rt.keyPress(KeyEvent.VK_CONTROL);
			rt.keyPress(KeyEvent.VK_V);
			
			rt.keyRelease(KeyEvent.VK_CONTROL);
			rt.keyRelease(KeyEvent.VK_V);
			rt.delay(1000);
			rt.keyPress(KeyEvent.VK_ENTER);
			rt.delay(1000);
			rt.keyRelease(KeyEvent.VK_ENTER);
			rt.delay(1000);
		    //click on save
			objsave.click();
			//wait and verify personal details
			if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"),"Personal Details" )))
			{
				System.out.println("personal details displayed");
			}
			//switch to parent frame
			x.switchTo().parentFrame();
			//mouse over on pim
			Act.moveToElement(objPIM).perform();
			//click on employee list
			x.findElement(By.linkText("Employee List")).click();
			//wait 2sec
			Thread.sleep(2000);
			//switch to frame
			x.switchTo().frame("rightMenu");
			//verify employee information
			if(x.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
			{	
				System.out.println("employee information displayed");
			}
			Thread.sleep(2000);
			WebElement searchby=x.findElement(By.id("loc_code"));
		    x.findElement(By.id("loc_code"));
		    searchby.click();
		    Select sel=new Select(searchby);
		    sel.selectByVisibleText("Emp. ID");
		    Thread.sleep(2000);
		    WebElement searchfor=x.findElement(By.id("loc_name"));
		    x.findElement(By.id("loc_name")).sendKeys(sEmpCode);
		    
		    
		    Thread.sleep(2000);
		    WebElement search=x.findElement(By.className("plainbtn"));
		    x.findElement(By.className("plainbtn"));
		    search.click();
		    Thread.sleep(2000);
		    
		x.switchTo().defaultContent();
			objlogout.click();
			x.switchTo().defaultContent();
			Thread.sleep(2000);
			
	}
}

