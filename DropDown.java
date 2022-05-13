package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
public static void main(String[] args) {

	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	driver.get("http://www.leafground.com/pages/Dropdown.html");
	WebElement dropDownElement = driver.findElement(By.id("dropdown1"));
	Select dropDown1=new Select(dropDownElement);
	dropDown1.selectByIndex(1);
	WebElement DropDownElement2 = driver.findElement(By.name("dropdown2"));
	Select dropdown2 = new Select(DropDownElement2);
	dropdown2.selectByVisibleText("Selenium");
	WebElement DropDownElement3 = driver.findElement(By.name("dropdown3"));
	Select dropdown3=new Select(DropDownElement3);
	dropdown3.selectByValue("2");
	WebElement DropDownElement4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
	Select dropdown4 = new Select(DropDownElement4);
	List<WebElement> Dropdown4options = dropdown4.getOptions();
	System.out.println("The number options dropdown --->" +Dropdown4options.size());
	for (WebElement options : Dropdown4options) {
		System.out.println(options.getText());
	}
System.out.println("----------------------------");
	driver.findElement(By.xpath("(//select)[5]")).sendKeys("Appium");
	
	WebElement  DropDownElement5= driver.findElement(By.xpath("(//select)[6]"));
	Select dropdown5 = new Select(DropDownElement5);
	dropdown5.selectByIndex(1);
	dropdown5.selectByIndex(3);

	List<WebElement> selectedOptions = dropdown5.getAllSelectedOptions();
	for (WebElement selectedvalues : selectedOptions) {
		System.out.println(selectedvalues.getText());
	}
	
}}