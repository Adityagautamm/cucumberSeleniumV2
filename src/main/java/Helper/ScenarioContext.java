package Helper;

import java.util.HashMap;

public class ScenarioContext {
	
	 private static HashMap<String, Object> scenarioContext;
	 
     public ScenarioContext(){
         scenarioContext = new HashMap<>();
     }
 
     public void setContext(String key, Object value) {
         scenarioContext.put(key, value);
     }
 
     public String getContextinString(String key){
         return (String) scenarioContext.get(key);
     }
 
     public Boolean isContains(String key){
         return scenarioContext.containsKey(key.toString());
     }
     
     public void resetContext() {
         scenarioContext.clear();
     }
 

}
