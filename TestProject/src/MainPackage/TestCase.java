package MainPackage;



import java.lang.System.Logger;
import java.time.Duration;
import java.util.logging.LogManager;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase {
	//--Static Variables--
	//Chrome Driver
	static ChromeDriver driver = null; 
	static WebDriverWait wait;
	
	//BASE URL
	static String baseURL = "https://www.kitapyurdu.com/";

		
	
	
	@BeforeClass
	public static void setUpBeforClass() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tayla\\eclipse\\java-2022-06\\eclipse\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Before
	public void setUp() throws Exception {
		driver.get(baseURL);	
		
	}
	
	
	@Test
	public void Test() throws InterruptedException {
		//Setting the property
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tayla\\eclipse\\java-2022-06\\eclipse\\chromedriver_win32\\chromedriver.exe");
		//Chrome Driver
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		WebElement searchBox = driver.findElement(By.id("search-input"));	
		
		searchBox.sendKeys("roman");
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//Csv file reading
		searchBox.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().getPageLoadTimeout();
		
		//Clicking "Sepete Ekle!" button
		driver.findElement(By.xpath("//*[@id=\"product-306815\"]/div[2]/div[3]/a[2]/i")).click();
		//Waiting Visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart\"]/div[1]")));	
		//Clicking Sepetim
		driver.findElement(By.className("heading")).click();
		
		Thread.sleep(1000);
		
		//Get "Sepetim" text
		String text =driver.findElement(By.className("heading")).getText();
	
		System.out.println(text.charAt(0));
		
			
		wait = new WebDriverWait(driver , Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"js-cart\"]")));
		
		//Clicking to the "Sepete Git" button
		driver.findElement(By.xpath("//*[@id=\"js-cart\"]")).click();
		//Clearing cart value
		driver.findElement(By.xpath("//*[@id=\"cart_module\"]/div[2]/table/tbody/tr/td[4]/form/input[1]")).clear();
	
		
		//Changing value with 2
		driver.findElement(By.xpath("//*[@id=\"cart_module\"]/div[2]/table/tbody/tr/td[4]/form/input[1]")).sendKeys("2");
		
		Thread.sleep(2000);
		//Clicking the updating button
		driver.findElement(By.xpath("//*[@id=\"cart_module\"]/div[2]/table/tbody/tr/td[4]/form/i")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"cart_module\"]/div[2]/table/tbody/tr/td[8]/a/i")).click();
		text = driver.findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText();
		
		//Controllig the text
		if(text.matches("Sepetiniz güncelleniyor!") == true) {
			System.out.println(text);
		}
		
		//Sleeping the thread just one seconds to be able to see what's going on
		Thread.sleep(1000);
		
		//Getting text string "Sepetinizden çıkarılıyor!" 
		
		text = driver.findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText();
		if(text.matches("Sepetinizden çıkarılıyor!") == true) {
			System.out.println(text);
		}
		
	}
	
}
