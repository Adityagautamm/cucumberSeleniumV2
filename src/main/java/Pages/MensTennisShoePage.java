package Pages;

import org.openqa.selenium.By;

public class MensTennisShoePage extends AllPageBase  {
	// page URL
    public String url = "https://www.adidas.com.au/men-tennis-shoes";

    public By Shoe1 = By.xpath("//img[@title='Adizero Ubersonic 4 Tennis Shoes']");

    public By Shoe1Price = By.xpath("//span[@title= 'Adizero Ubersonic 4 Tennis Shoes']/parent::div/div/div[contains(@class, 'gl-price-item')]");


}
