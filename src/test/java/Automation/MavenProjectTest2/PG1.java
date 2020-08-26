package Automation.MavenProjectTest2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class PG1 {


    public static void main(String[] args) {
        
       PG1 pg = new PG1();
       pg.getCurrentDir();
       pg.getDriver();
    }
    
    public String getCurrentDir() 
    {
    	String DriverPath=null;
    	
    	try {
    	
    	
    		
    	//absolute path
    	String current = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Current dir:"+current);
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" +currentDir);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        //Relative Path
        Path currentRelativePath = Paths.get("");
        DriverPath = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + DriverPath);
    	}
    	catch(IOException IO)
    	{
    		System.out.println("Exception: " + IO.getLocalizedMessage());
    		
    	}
    	catch(Exception E)
    	{
    		System.out.println("Exception: " + E.getLocalizedMessage());
    		
    	}
    	
    	
    	return DriverPath;
    }
    
    
    public  void getDriver()
    
    {
    	// declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\chromedriver.exe");
		
    	//code to fetch driver from maven
    	WebDriverManager.chromedriver().setup();
    
    	//code to resolve Error Loading Extension Could not load extension from 'C:\..\Local\Temp\scoped_dir6312_32763\internal'. Loading of unpacked extensions is disabled
    	ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("useAutomationExtension", false);
    	
		WebDriver driver = new ChromeDriver(options);
		
	   
    	
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed! ---- " + actualTitle.toString());
        } else {
            System.out.println("Test Failed ---- " + actualTitle.toString());
        }
       
        //close Fire fox
        driver.close();
        
        //return driver;
    }

}