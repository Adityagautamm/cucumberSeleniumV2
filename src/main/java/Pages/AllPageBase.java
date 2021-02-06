package Pages;

import java.util.HashMap;

import TestBase.TestBase;


public class AllPageBase extends TestBase {
	
	public static AllPageBase theObject;

	
	public static HashMap<String, AllPageBase> pageStorage;
	 
	 public static void LoadAllPages() {
		 pageStorage =  new HashMap<>();
		 pageStorage.put("Home Page", new HomePage());
		 pageStorage.put("Mens Tennis Shoe", new MensTennisShoePage());
		 pageStorage.put("Shoe1", new Shoe1Page());
   }
}
