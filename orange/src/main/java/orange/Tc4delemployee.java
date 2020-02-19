package orange;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Tc4delemployee {

	@Test
	public static void HRM() throws Exception {
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
			else
			{
				System.out.println("home page not displayed");
				return;
			}
			//create web elements for un,pwd,login,clear
			WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
			WebElement objPWD=x.findElement(By.name("txtPassword"));
			WebElement objlogin=x.findElement(By.name("Submit"));
			WebElement objclear=x.findElement(By.name("clear"));
			//verify UN
			if(objUN.isDisplayed())
			{
				System.out.println("username is displayed");
			}
			if(objPWD.isDisplayed())
			{
				System.out.println("password is displayed");
			}
			if(objlogin.isDisplayed() && objclear.isDisplayed())
			{
				System.out.println("login and clear are displayed");
			}
			String sUN="qaplanet2";
			String sPWD="lab2";
			//login to hrm
			objUN.clear();
			objUN.sendKeys(sUN);
			objPWD.clear();
			objPWD.sendKeys(sPWD);
			objlogin.click();
			//wait and verify orange hrm
			if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
			{
				System.out.println("orange hrm displayed");
			}
			else
			{
				System.out.println("failed to login");
			return;
			}
			//get welcome text
			String sWelText=x.findElement(By.tagName("li")).getText();
			//verify welcome text
			if(sWelText.equals("welcome"+sUN))
			{
				System.out.println("welcome"+sUN+"displayed");
			}
			//verify only username
			String[]Arr=sWelText.split(" ");
			if(Arr[1].equals(sUN))
			{
				System.out.println(sUN+"displayed");
			}
			//create web element for change password and logout
			WebElement objCP=x.findElement(By.linkText("Change Password"));
			WebElement objlogout=x.findElement(By.linkText("Logout"));
			//verify change password and logout
			if(objCP.isDisplayed()&&objlogout.isDisplayed())
			{
				System.out.println("change password and logout are dispalyed");
			}
			Thread.sleep(2000);
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
			String sFN="koushik";
			String sLN="varikoti";
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
			//click on save
			objsave.click();
			Thread.sleep(2000);
			 WebElement back=x.findElement(By.className("backbutton"));
			    x.findElement(By.className("backbutton"));
			    back.click();
			    Thread.sleep(2000);
			  WebElement searchby=x.findElement(By.id("loc_code"));
			    x.findElement(By.id("loc_code"));
			    searchby.click();
			    Select sel=new Select(searchby);
			    sel.selectByVisibleText("Emp. ID");
			    Thread.sleep(2000);
			    WebElement searchfor=x.findElement(By.id("loc_name"));
			    x.findElement(By.id("loc_name"));
			    searchfor.sendKeys(sEmpCode);
			    Thread.sleep(2000);
			    WebElement search=x.findElement(By.className("plainbtn"));
			    x.findElement(By.className("plainbtn"));
			    search.click();
			    Thread.sleep(2000);
			    WebElement checkbox=x.findElement(By.className("checkbox"));
			    checkbox.click();
			    WebElement delete=x.findElement(By.xpath("//*[@id='standardView']/div[3]/div[1]/input[2]"));
			    delete.click();
			   }
     }
