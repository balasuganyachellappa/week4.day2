package week4.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert =driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.sendKeys("Bala");
		alert.accept();
		String text2=driver.findElement(By.id("demo")).getText();
		if(text2.contains("Bala"))
		{
			System.out.println("the text bala is present");
		}
		
		
	}
	

}
