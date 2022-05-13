package week4.day2;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://www.leafground.com/pages/Window.html");
	driver.findElement(By.id("home")).click();
	String parentWindow = driver.getWindowHandle();
	Set<String> totalNumberOfWindows = driver.getWindowHandles();
	List<String> totalWindows=new ArrayList<String>(totalNumberOfWindows);
	String childWindow=totalWindows.get(1);
	driver.switchTo().window(childWindow);
	System.out.println("Child window page title is  " +  driver.getTitle());
	driver.close();
	driver.switchTo().window(parentWindow);
	System.out.println("Parent window page title is  " +  driver.getTitle());
	driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> windowsList=new ArrayList<String>(windowHandles);
	System.out.println("Total windows opened--->"+windowsList.size());
	driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
	List<String> windowlist=new ArrayList<String>(driver.getWindowHandles());
	for(int i=driver.getWindowHandles().size()-1;i>=1;i--) {
		driver.switchTo().window(windowlist.get(i)).close();
	}
	driver.switchTo().window(windowlist.get(0));
	System.out.println(driver.getTitle());
	driver.findElement(By.id("color")).click();
	Thread.sleep(5000);
	List<String> windowsOpened =new ArrayList<String>(driver.getWindowHandles());
	System.out.println("Number of windows opened " + windowsOpened.size());

	driver.quit();

	
}
}
