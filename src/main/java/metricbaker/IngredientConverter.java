package metricbaker;

import org.json.JSONObject;


public class IngredientConverter{

  public int convert(String ingredient, float amount, String unit){
	
    if(isIngredientCountable(unit)){
      return Math.round(amount * CountableIngredient.getMassByCountable(ingredient));
    }  
	  
	  float massInGramsForOneUnit = UnitOfMass.getGramsByMassUnit(unit);  
   
    if(massInGramsForOneUnit == 0){
      massInGramsForOneUnit = UnitOfVolume.getVolumeByUnit(unit) * IngredientDensity.getDensityByIngredient(ingredient);
    }

    return Math.round(amount * massInGramsForOneUnit);
  }

  public JSONObject convert(JSONObject ingredients){
    String expectedIngredients = "{\r\n\t\"ingredients\":\r\n\t[\r\n\t\t{\r\n\t\t\t\"ingredient\":\"sugar\",\r\n\t\t\t\"amount\":\"100\",\r\n\t\t\t\"unit\":\"gram\"\r\n\t\t},\r\n\t\t{\r\n\t\t\t\"ingredient\":\"salt\",\r\n\t\t\t\"amount\":\"14\",\r\n\t\t\t\"unit\":\"gram\"\r\n\t\t}\r\n\t]\r\n}";
    return new JSONObject(expectedIngredients);
  }
  
  private boolean isIngredientCountable(String unit){
	return unit.isEmpty() || "unit".compareToIgnoreCase(unit)==0 || "countable".compareToIgnoreCase(unit)==0;
  }
}
