package cucumberframeworkpkg;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class PizzaSteps {
	
	
	 WebDriver driver;
	Float checkoutprice;
	@Before
	public void launch_browser()
	{
		System.setProperty("webdriver.gecko.driver","C://Users//hp/geckodriver.exe");
	//System.setProperty("webdriver.chrome.driver","C://Users//hp//Downloads//chromedriver-win32/chromedriver.exe");
	 	
	 	 driver = new FirefoxDriver();
	 	 	 
	}

	 @After
		public void teardown()
		{
			driver.close();
			
			
		}
		
	
	@Given("^launch Pizzahut application with(.*)$")
	 public void launch_pizzahut_application_with_URL(String URL) {
		System.out.println("user is on homepage");
             
	 	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 	driver.navigate().to(URL);
	 }
	@When("User wait for auto location black pop up screen")
	public void user_wait_for_auto_location_black_pop_up_screen() {
	   
	    
	}
	@Then("User close the pop up screen")
	public void user_close_the_pop_up_screen() {
	    
	    
	}
	@Then("User see pop up for delivery asking for enter location")
	public void user_see_pop_up_for_delivery_asking_for_enter_location() {
	    
	   
	}
	@Then("^User type address as (.*)$")
	 public void user_type_address_as_location(String Location) {
		WebElement a= driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
				a.sendKeys(Location );
				//a.sendKeys(Keys.ENTER);
		
		 
		 System.out.println("user enters the location");
	 }

	@Then("User select first auto populate drop down option")
	 public void user_select_first_auto_populate_drop_down_option() {
		 
	   /*List<WebElement> el=  driver.findElements(By.cssSelector("#geo-location>button"));
	   for(WebElement e:el )
	   {
		   if(e.getText().equals("LuLu Mall Hyderabad "))
		   {
			   e.click();
			   break;
		   }
	   }*/
	     //Select select= new Select (el);
	   //WebElement e= select.getFirstSelectedOption();
		driver.findElement(By.xpath("//button[2]")).click();
				
	 }

	 @When("User navigate to deals page")
	 public void user_navigate_to_deals_page() {
		
	 
	 }

	 @Then("User validate vegetarian radio button flag is off")
	 public void user_validate_vegetarian_radio_button_flag_is_off() {
	     WebElement radiobtn=driver.findElement(By.xpath("//div[contains(@class,'hidden 2xl:flex w-full')]//span[contains(@class,'py-4 px-5 border rounded-full flex items-center cursor-pointer bg-grey-light border-grey-light justify-start')]"));
            System.out.println(radiobtn.isSelected());	
	 }

	 @Then("User clicks on Pizzas menu bar option")
	 public void user_clicks_on_pizzas_menu_bar_option() {
	     WebElement pizzabar=driver.findElement(By.xpath("//a[contains(@data-synth,'link--pizzas--side')]"));
	     pizzabar.click();
	 }

	 @When("User select add button of any pizza from Recommended")
	 public void user_select_add_button_of_any_pizza_from_recommended() {
		WebElement addbtn=driver.findElement(By.xpath("//button[@data-synth='button--mazedar-makhni-paneer-recommended-pan-personal--one-tap']"));
                    addbtn.click();
                    System.out.println("item added to cart");
	 }

	 @Then("User see that the pizza is getting added under Your Basket")
	 public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
		 
		 WebElement s=driver.findElement(By.xpath("//div[@class='leading-tight typography-4 basket-item-product-title leading-tight mb-5 flex-1 mr-5 font-bold text-black']"));
		 String el=s.getText();
		 System.out.println(el);
		 WebElement s1=driver.findElement(By.xpath("//div[@class='basket-placeholder']//div[1]//a[2]//div[2]"));
		 String el1=s1.getText();
		 System.out.println(el1);
	  WebElement addcart=driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));
	 String s3=addcart.getText();
	//int i=Integer.parseInt(s3);
	 System.out.println(s3);
	  
	 }

	 @Then("User validate pizza price plus Tax is checkout price")
	 public void user_validate_pizza_price_plus_tax_is_checkout_price() {
		 //For pizzaprice
	     WebElement pizzaprice = driver.findElement(By.xpath("//span[@class='subtotal']"));
	     String s=pizzaprice.getText();
	     String s0=s.replace('₹', ' ');
	     Float i=Float.parseFloat(s0.trim());
	     System.out.println(i);
	     //For HandlingCharges
	     WebElement handlingcharges = driver.findElement(By.xpath("//div[@class='display-supplement-value']"));
	     String s5=handlingcharges.getText();
	       String s6=s5.replace('₹', ' ');
	     Float k=Float.parseFloat(s6.trim());
	     System.out.println(k);
		 //For tax
	     WebElement tax = driver.findElement(By.xpath("//span[contains(text(),'₹19.70')]"));
	     String s2=tax.getText();
	     String s4=s2.replace('₹', ' ');
	     Float j=Float.parseFloat(s4.trim());
	     System.out.println(j);
	     checkoutprice=i+j+k;
	     System.out.println(checkoutprice);
	     
	     //for checkout price
	  WebElement checkout= driver.findElement(By.xpath("//span[@data-synth='basket-value'][contains(text(),'₹413.70')]"));
	   String check=checkout.getText();
        String s7=check.replace('₹', ' ');
        Float m=Float.parseFloat(s7.trim());
        System.out.println(m);
        if(checkoutprice==m)
        {
        	System.out.println("matched");
        }
        else {
        	System.out.println(" not matched");
        }
	 }

	 @Then("User validate checkout button contains Item count")
	 public void user_validate_checkout_button_contains_item_count() {
	     WebElement count=driver.findElement(By.xpath("//span[contains(@class,'bg-green-dark pl-5 pr-5 rounded')]"));
	    String z= count.getText();
	    String repl=z.replace("item" , "" );
	    int l=Integer.parseInt(repl.trim());
	  System.out.println(l+" "+"item is present");
	 }

	 @Then("User validate checkout button contains total price count")
	 public void user_validate_checkout_button_contains_total_price_count() {
		 WebElement count=driver.findElement(By.xpath("//span[@data-synth='basket-value'][contains(text(),'₹413.70')]"));
		 String text=count.getText();
		 String r=text.replace('₹', ' ');
		 Float f=Float.parseFloat(r.trim());
		 System.out.println(f+" "+"is total price count");
		 
	 }

	 @Then("User clicks on Drinks option")
	 public void user_clicks_on_drinks_option() {
	   WebElement drinks=driver.findElement(By.xpath("//a[contains(@data-synth,'link--drinks--side')]"));
	   drinks.click();
	   System.out.println("user navigates to drinks page");
	 }

	 @Then("User select Pepsi option to add into the Basket")
	 public void user_select_pepsi_option_to_add_into_the_basket() {
		 WebElement selectopt=driver.findElement(By.xpath("//button[@data-synth='button--pepsi-600ml--one-tap']"));
		 selectopt.click();
	 }

	 @Then("User see {int} items are showing under checkout button")
	 public void user_see_items_are_showing_under_checkout_button(Integer int1) {
	    WebElement btn= driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));
	   String text1= btn.getText();
	   String repl1=text1.replace("items","");
	    int a=Integer.parseInt(repl1.trim());
	     if(a==int1)
	     {
	    	 System.out.println(a+" "+"items are present");
	     }
	     else {
	    	 System.out.println(a+" "+"items are not present");
	     }
	    
	 }

	 @Then("User see total price is now more than before")
	 public void user_see_total_price_is_now_more_than_before() {
	    WebElement price=driver.findElement(By.xpath("//span[@data-synth='basket-value'][contains(text(),'₹473.56')]"));
	    String pricetext=price.getText();
	    String repl2=pricetext.replace('₹',' ');
	    Float f1=Float.parseFloat(repl2.trim());
	    if(f1>checkoutprice) {
	    	System.out.println("price is more than before");
	    }
	    else {
	    	System.out.println("price is not more than before");
	    }
	 }

	 @Then("User remove the Pizza item from Basket")
	 public void user_remove_the_pizza_item_from_basket() {
		 WebElement remove=driver.findElement(By.xpath("//button[contains(@data-synth,'basket-item-remove--mazedar-makhni-paneer-recommended-pan-personal')]"));
		 remove.click();
	 }

	 @Then("see Price tag got removed from the checkout button")
	 public void see_price_tag_got_removed_from_the_checkout_button() {
	     boolean stringline=driver.findElement(By.xpath("//div[@class='hidden md:flex md:bg-white md:text-black md:font-semibold justify-center sm:pb-5 typography-6']//span[contains(text(),'Minimum cart value for delivery is ₹200')]")).isDisplayed();
	     if(stringline==true)
	     {
	    	 System.out.println("pricetag is removed");
	     }
	     else{
	    	 System.out.println("pricetag is still there");
	     }
	 }

	 @Then("User see {int} item showing in checkout button")
	 public void user_see_item_showing_in_checkout_button(Integer int1) {
		 WebElement btn1= driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));
		   String text2= btn1.getText();
		   String repl2=text2.replace("item","");
		    int c=Integer.parseInt(repl2.trim());
		     if(c==int1)
		     {
		    	 System.out.println(c+" "+"item is present");
		     }
		     else {
		    	 System.out.println(c+" "+"item is not present");
		     }
		    
	    
	 }

	 @Then("User Clicks on Checkout button")
	 public void user_clicks_on_checkout_button() {
		 WebElement btn2= driver.findElement(By.xpath("//button[contains(@class,'justify-between')]//span[contains(@class,'absolute inset-0 flex-center')]"));
	        btn2.click();
	 }
	

	 @Then("User see minimum order required pop up is getting displayed")
	 public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
		 WebElement popup= driver.findElement(By.xpath("//div[@class='pt-20 bg-white p-20 m-20 rounded text-center shadow relative']"));
		 boolean b2=popup.isDisplayed();
		 System.out.println(b2);
	 }
	}


