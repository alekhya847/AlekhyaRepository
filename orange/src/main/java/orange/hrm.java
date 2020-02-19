package orange;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class hrm {
	
    @Test
	public static void HRM() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\alekhya\\chromedriver.exe");
		ChromeDriver x=new ChromeDriver();
		x.manage().window().maximize();
		
		x.get("http://apps.qaplanet.in/hrm/login.php");
		Thread.sleep(2000);
		if(x.getTitle().equals("OrangeHRM - New Level of HR Management"));
		{
			System.out.println("Home page displayed");
		}

x.findElement(By.name("txtUserName")).sendKeys("qaplanet2");
x.findElement(By.name("txtPassword")).sendKeys("lab2");
x.findElement(By.name("Submit")).click();
Thread.sleep(2000);
if(x.getTitle().equals("OrangeHRM"))
{
	System.out.println("OrangeHRM displayed");
}

String sWelText=x.findElement(By.tagName("li")).getText();
if(sWelText.equals("welcome"+"qaplanet2"))
{
	System.out.println("welcome"+"qaplanet2"+"displayed");
}
x.findElement(By.linkText("Logout")).click();
Thread.sleep(2000);
if(x.getTitle().equals("OrangeHRM - New Level of HR Management"))
{
	System.out.println("signoff successful and homepage displayed");
}
x.close();
x.quit();
}
}