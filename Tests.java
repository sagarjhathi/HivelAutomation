package Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {

   
    // Test case 1
    @Test
    public void loginAndCompareDataCockpitToProcess() throws InterruptedException {
        // Initialize WebDriver inside the test method
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get("https://app.insightlyanalytics.ai/");

        // Your test steps go here (e.g., login, compare data)
        driver.findElement(By.xpath("//input[@class='Login_emailInput__jCrfI rs-input']")).click();

        String emailInput = "sagar+demo@hivel.ai";
        String passInput = "rK2Gx_75L";

        driver.findElement(By.xpath("//input[@class='Login_emailInput__jCrfI rs-input']")).sendKeys(emailInput);
        driver.findElement(By.xpath("//button[@class='Login_continueButton__4IpBO rs-btn rs-btn-default rs-btn-lg']")).click();

        driver.findElement(By.xpath("//div[@class='Login_emailInput__jCrfI rs-input-group rs-input-group-inside']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(passInput);
        driver.findElement(By.xpath("//button[@class='Login_continueButton__4IpBO rs-btn rs-btn-default rs-btn-lg']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='rs-btn rs-btn-default rs-btn-md']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@class='filters_filtersSimpleToggle__i6p4Z rs-btn rs-btn-default'])[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='filters_rangeLabel__s95rp' and text()='Last 30 days']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='material-icons-round' and text()='groups']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='rs-checkbox-wrapper'])[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='rs-checkbox-wrapper'])[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='rs-btn rs-btn-primary']")).click();
        Thread.sleep(2000);

        String cycleTimeCockpit = driver.findElement(By.xpath("//div[@data-testid='cycle-time-value']")).getText();
        String reviewTimeCockpit = driver.findElement(By.xpath("//div[@data-testid='review-time-value']")).getText();
        System.out.println(cycleTimeCockpit + "    " + reviewTimeCockpit + " Cockpit numbers");

        cycleTimeCockpit = cycleTimeCockpit.trim();
        reviewTimeCockpit = reviewTimeCockpit.trim();
        
        Thread.sleep(3000);
		         
        
        driver.findElement(By.xpath("(//a[@class='rs-dropdown-toggle rs-sidenav-item'])[2]")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='nav-menu-item rs-dropdown-item' and text()='Process']")).click();

        driver.findElement(By.xpath("(//button[@class='filters_filtersSimpleToggle__i6p4Z rs-btn rs-btn-default'])[1]")).click();
        driver.findElement(By.xpath("//span[@data-testid='last-30-days']")).click();

        Thread.sleep(7000);

        String cycleTimeProcess = driver.findElement(By.xpath("(//span[@class='Process_processMetricValue__8LgiT'])[5]")).getText();
        String reviewTimeProcess = driver.findElement(By.xpath("(//span[@class='Process_processMetricValue__8LgiT'])[3]")).getText();
        
        
        
        StringBuilder sb=new StringBuilder();
        StringBuilder sbReview=new StringBuilder();
        
        for(int i=0;i<cycleTimeProcess.length();i++) {
        	if(cycleTimeProcess.charAt(i)=='d') {
        		sb.append(cycleTimeProcess.charAt(i));
        		sb.append(" ");	
        		sbReview.append(reviewTimeProcess.charAt(i));
        		sbReview.append(" ");
        	}else {
        		sb.append(cycleTimeProcess.charAt(i));
        		sbReview.append(reviewTimeProcess.charAt(i));
        	}
        }
        
        cycleTimeProcess=sb.toString();
        reviewTimeProcess=sbReview.toString();
      
        		
        		System.out.println(cycleTimeProcess + "    " + reviewTimeProcess + " Process numbers");

        cycleTimeProcess = cycleTimeProcess.trim();
        reviewTimeProcess = reviewTimeProcess.trim();

        Assert.assertEquals(cycleTimeProcess, cycleTimeCockpit, "Assertion failed: The cycle time value is incorrect in process.");
        Assert.assertEquals(reviewTimeProcess, reviewTimeCockpit, "Assertion failed: The review time value is incorrect in process.");

        // Clean up WebDriver after the test
        driver.quit();
    }

    
    
    // Test case 2
    @Test
    public void loginAndCompareDataFromCockpitToPullRequest() throws InterruptedException {
        // Initialize WebDriver inside the test method
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get("https://app.insightlyanalytics.ai/");

        // Your test steps go here (e.g., login, compare data)
        driver.findElement(By.xpath("//input[@class='Login_emailInput__jCrfI rs-input']")).click();

        String emailInput = "sagar+demo2@hivel.ai";
        String passInput = "rK2Gx_75L";

        driver.findElement(By.xpath("//input[@class='Login_emailInput__jCrfI rs-input']")).sendKeys(emailInput);
        driver.findElement(By.xpath("//button[@class='Login_continueButton__4IpBO rs-btn rs-btn-default rs-btn-lg']")).click();

        driver.findElement(By.xpath("//div[@class='Login_emailInput__jCrfI rs-input-group rs-input-group-inside']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(passInput);
        driver.findElement(By.xpath("//button[@class='Login_continueButton__4IpBO rs-btn rs-btn-default rs-btn-lg']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='rs-btn rs-btn-default rs-btn-md']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@class='filters_filtersSimpleToggle__i6p4Z rs-btn rs-btn-default'])[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='filters_rangeLabel__s95rp' and text()='Last 30 days']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='material-icons-round' and text()='groups']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='rs-checkbox-wrapper'])[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='rs-checkbox-wrapper'])[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='rs-btn rs-btn-primary']")).click();
        Thread.sleep(2000);
        
        
        Thread.sleep(3000);
		 
        driver.findElement(By.xpath("//button[@tour-selector='cto-2']")).click();
       
        Thread.sleep(3000);
        String cfr=  driver.findElement(By.xpath("//div[@data-testid='change-failure-rate-value']")).getText();
        cfr=cfr.trim();
     
       JavascriptExecutor js=(JavascriptExecutor)driver;
    
        WebElement mttrLocation=driver.findElement(By.xpath("//div[@data-testid='mttr-duration-value']"));
    
     
       js.executeScript("arguments[0].scrollIntoView(true)", mttrLocation);
       String mttrExtactFromQuality=driver.findElement(By.xpath("//div[@data-testid='mttr-duration-value']")).getText();
       mttrExtactFromQuality=mttrExtactFromQuality.trim();
       System.out.println(cfr+"   "+mttrExtactFromQuality);
    
       
       Thread.sleep(3000);
       driver.findElement(By.xpath("(//a[@class='rs-dropdown-toggle rs-sidenav-item'])[2]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//span[@data-testid='side-nav-item-Pull Request']")).click();
       Thread.sleep(2000);
       
       driver.findElement(By.xpath("(//span[@class='filters_toggleText__gnWeg'])[1]")).click();
       
       driver.findElement(By.xpath("//span[@data-testid='last-30-days']")).click();
       
       String cfrPullRequest=driver.findElement(By.xpath("(//span[@class='metric-value pr-1'])[1]")).getText();
       cfrPullRequest=cfrPullRequest.trim();
       
       String mttrPullRequest=driver.findElement(By.xpath("(//span[@class='metric-value pr-1'])[2]")).getText();
       mttrPullRequest=mttrPullRequest.trim();
       
       Assert.assertEquals(cfrPullRequest, cfr);
       Assert.assertEquals(mttrPullRequest, mttrExtactFromQuality);
        

        driver.quit();
    }
}