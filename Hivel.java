package Demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hivel {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
			//Creating a driver
		    WebDriver driver=new ChromeDriver();
		
		    driver.get("https://www.hivel.ai/");
		    //Applying implicit wait and maximizing the screen 
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.manage().window().maximize();
		
		
		//Creating actions class object for further operations
		  Actions act=new Actions(driver);
		
		  //Locating the elements wanted to be hoverd
		  WebElement hoverOnPlatform=driver.findElement(By.xpath("//div[@class='text-block-29']"));
		  WebElement hoverOnCompany=driver.findElement(By.xpath("//div[@class='text-block-30']"));
		  WebElement hoverOnResources=driver.findElement(By.xpath("//div[@class='text-block-31']"));
		
		
		//Explicitly using thread.sleep in order to see the operations visually at each hover operation
		Thread.sleep(2000);
		   act.moveToElement(hoverOnPlatform).perform();
		Thread.sleep(2000);
		   act.moveToElement(hoverOnCompany).perform();
		Thread.sleep(2000);
		   act.moveToElement(hoverOnResources).perform();
		
		
		//Locating and Closing the cookie pop-up using click
		WebElement closeCookiePopip=driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler "
				+ "onetrust-close-btn-ui banner-close-button ot-close-icon']"));
	    closeCookiePopip.click();
		   
		   
	    		//Adding thread.sleep here as well to see the operations visually
		      Thread.sleep(2000);
		      
		      //Locating the elements for specific scroll locations based on the web elements to be scrolled until
		      WebElement firstScroll=driver.findElement(By.xpath("//div[@class='home-logos_component']"));
		      WebElement secondScroll=driver.findElement(By.xpath("//div[@class='iconbox four']"));
		      WebElement thirdScroll=driver.findElement(By.xpath("//a[@class='blue-button w-button' and text()='Take it for a spin']"));
		      WebElement fourthScroll=driver.findElement(By.xpath("//div[@class='testimonial8_component w-slider']"));
		      
		      
		      //Creating an ArrayList in order to store the scroll values hence it can be iterated and following scroll 
		     // actions can be performed
		      
		      ArrayList<WebElement> scrollValues=new ArrayList<>();
		      scrollValues.add(firstScroll);
		      scrollValues.add(secondScroll);
		      scrollValues.add(thirdScroll);
		      scrollValues.add(fourthScroll);
		      
		      
		      //Creating javascript executor for scroll operations
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		
		 
		 //Iterating through the arraylist having element locations one by one and scrolling to those elements
		// with thread.sleep to check the scroll operatioins.
		 for (WebElement element : scrollValues) {
	            // Scroll to the element
	            js.executeScript("arguments[0].scrollIntoView(true);", element);
	            Thread.sleep(2000);
	        }
		 
		 
		 
		 driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		 
		 List<WebElement> testimonialsList=fourthScroll.findElements(By.xpath("//div[@class='testimonial8_slide w-slide']"));
		 System.out.println(testimonialsList.size());
		 
		 
		 
		 WebElement clickNextInTestimonials=driver.findElement(By.xpath("//div[@class='testimonial8_arrow"
		 		+ " hide-mobile-landscape w-slider-arrow-right']"));
		 for(int i=0;i<testimonialsList.size();i++) {
			 clickNextInTestimonials.click();
			 Thread.sleep(2000);
		 }
		 
		 
		 
		 WebElement scrollUntilBlog=driver.findElement(By.xpath("//a[@id='w-node-_3298c7ca-3c5c-d26c-d540-2c7e66c43fa9-66c43f97']"));
		 
		 js.executeScript("arguments[0].scrollIntoView(true)", scrollUntilBlog);
		 scrollUntilBlog.click();	
		 
		 
		 WebElement locateBlogPageHeaderText=driver.findElement(By.xpath("//h1[@class='blog-hero-heading']"));
		 
		 String extractBlogPageHeaderText=locateBlogPageHeaderText.getText();
		 String expectedBlogPageHeaderText="The latest in data-driven engineering";
		 
		 
		 Assert.assertEquals(extractBlogPageHeaderText, expectedBlogPageHeaderText);
		 
		 
		 WebElement startFreeTrailBlogPage=driver.findElement(By.xpath("//a[@class='blue-button w-button']"));
		 
		 //Direct Scroll
		// js.executeScript("arguments[0].scrollIntoView(true);", startFreeTrailBlogPage);
		 
		 //Smooth scroll
	      js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", startFreeTrailBlogPage);

		 	
	}	
}
