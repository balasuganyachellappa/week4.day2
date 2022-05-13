package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("We are in frame one");		
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		if(driver.findElement(By.id("a")).isSelected()) {
			System.out.println("Check box in frame 3 is selected");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		String text=driver.findElement(By.xpath("//b[text()='Animals :']")).getText();
		driver.findElement(By.id("animals")).sendKeys("Baby Cat");
		System.out.println(text);
		driver.close();

	}

}
