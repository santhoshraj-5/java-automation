package list_for_sale;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Buy_Flow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				WebDriverManager.chromiumdriver().setup();
				//System.setProperty("webdriver.http.factory", "jdk-http-client");

				WebDriver driver = new ChromeDriver();
				driver.get("https://next-tcbduahkvr.guardiannft.org/");	
				//maximizing windows
                driver.manage().window().maximize();
                //this will help our code to wait untill the element is found without throwing error
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                //sign-in buttonclick
                driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/nav[1]/div[1]/div[1]/a[6]")).click();
                //entering mail id
                driver.findElement(By.name("email")).sendKeys("santhoshraj.v@guardianlink.io");
                //clicking send otp button
                driver.findElement(By.xpath("//button[normalize-space()='Request OTP']")).click();
                //entering otp
                driver.findElement(By.xpath("//input[@aria-label='Please enter verification code. Digit 1']")).sendKeys("110022");
                //clicking continue
                driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
                //clicking my profile dropdown
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/nav/div/div[1]/div[3]")).click();
                //clicking myNft
                driver.findElement(By.xpath("(//button[normalize-space()='My NFTs'])[1]")).click();
                //applying filter
                driver.findElement(By.xpath("(//div[@class='dropdown'])[5]")).click();
                driver.findElement(By.cssSelector("div[class='d-flex gap-2 p-2'] button:nth-child(1)")).click();
                //getting windows current tab
                String currenthandle =driver.getWindowHandle();
                //selecting NFT //*[@id="root"]/div[2]/section/div/div[4]/div/div/div/div/div[2]/div/div[3]/div[2]/div[1]/div/div[1]
               // driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/section[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/img[1]")).click();
               //for first nft we can use above xpath but for after filter search we need to change xpath
                driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/section/div/div[4]/div/div/div/div/div[2]/div/div[3]/div[2]/div[1]/div/div[1]")).click();
                //shifting windows
                Set<String> handle = driver.getWindowHandles();
                //for each loop
                for(String actual:handle) {
        			if(!actual.equalsIgnoreCase(currenthandle)) {
        				driver.switchTo().window(actual);
        			}
        		}
                JavascriptExecutor js=(JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,50)", "");
                //list for sale button
                driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/div[1]/div/div/div[2]/div[4]/div[2]/div[2]/button")).click();
                //buy price 
                //driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[3]/div[2]/div[2]/div[1]/div/input")).sendKeys("1");
                //list for sale button
                //driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[4]/div[2]/div[2]/button")).click();
                //bid toggle button on
                driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]")).click();
                //buy toggle button off
                driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
                //bid amount
                driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[3]/div[2]/div[2]/div[2]/div/input")).sendKeys("1");
                //list for sale button
                //driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[4]/div[2]/div[2]/button")).click();
			}

	}
