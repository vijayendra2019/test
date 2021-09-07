import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Registeration_Page {
	
	//welcome to java
	//hello world
	public Properties properties;
	public final String propertyFilePath= "config//applications.properties";
	
	
	public Registeration_Page(){
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				//System.out.println("properties.load(reader)");
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	@Test
	public void getURL() throws InterruptedException
	{
		Registeration_Page Registeration_Page =new Registeration_Page();
		String URL=  Registeration_Page.getApplicationUrl();
		
		System.setProperty("webdriver.gecko.driver",  Registeration_Page.getDriverPath());
		WebDriver driver  = new FirefoxDriver();
		
		System.out.println(URL);
		//driver.navigate().to("https://demoqa.com/automation-practice-form");
		
		driver.navigate().to("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[1]/input")).sendKeys("James");
		driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[1]/div[2]/input")).sendKeys("Anderson");
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[2]/div/textarea")).sendKeys("Plot no 122");
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[3]/div[1]/input")).sendKeys("test@test.com");
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[4]/div/input")).sendKeys("9703444444");
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[5]/div/label[1]/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
		Thread.sleep(5);
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id='checkbox1']")).click();
		
		driver.findElement(By.xpath("//*[@id='Skills']/option[3]")).click();
		driver.findElement(By.xpath("//*[@id='countries']/option[10]")).click();
		
		
		
		/*driver.findElement(By.id("/html/body/section/div/div/div[2]/form/div[10]/div/span/span[1]/span")).click();
		Thread.sleep(5);
		driver.findElement(By.className("/html/body/span/span/span[1]/input")).sendKeys("India");*/
		
		
		driver.findElement(By.xpath("//*[@id=\'yearbox\']/option[40]")).click();
		
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[11]/div[2]/select/option[4]")).click();
		
		driver.findElement(By.xpath("//*[@id=\'daybox\']/option[10]")).click();
		
		driver.findElement(By.xpath("//*[@id=\'firstpassword\']")).sendKeys("appPassword");
	 
		driver.findElement(By.xpath("//*[@id=\'secondpassword\']")).sendKeys("appPassword");
		
		driver.close();
		
	}
	
		}


