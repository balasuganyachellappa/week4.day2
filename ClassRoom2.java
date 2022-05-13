package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom2 {
public static void main(String[] args) {

	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/Window.html");
	
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	driver.findElement(By.id("home")).click();
	String windowHandle=driver.getWindowHandle();
	
	Set<String> windowHandles = driver.getWindowHandles();
	//System.out.println(windowHandles);
	
	List<String> newWindows =new ArrayList<String>(windowHandles);
	//System.out.println(newWindows);
	String newWindows1 = newWindows.get(1);
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	driver.switchTo().window(newWindows1);
     //String newWindows2=newWindows1.get();
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	driver.switchTo().window(windowHandle );
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	
	
	driver.close();
	
	
	
	

}
}
