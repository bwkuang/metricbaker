public class IngredientConverter{

  public int convert(String ingredient, float amount, String unit){
	
	if(isIngredientCountable(unit)){
		return Math.round(amount * getMassByCountable(ingredient));
	}  
	  
	float massInGramsForOneUnit = getGramsByMassUnit(unit);  
   
    if(massInGramsForOneUnit == 0){
      massInGramsForOneUnit = getVolumeByUnit(unit) * getDensityByIngredient(ingredient);
    }

    return Math.round(amount * massInGramsForOneUnit);
  }
  
  private boolean isIngredientCountable(String unit){
	return unit.isEmpty() || "unit".compareToIgnoreCase(unit)==0 || "countable".compareToIgnoreCase(unit)==0;
  }
  
  private float getGramsByMassUnit(String unit){
    float mass = 0f;
	
	for(UnitOfMass u : UnitOfMass.values()){
      if(u.getUnitName().compareToIgnoreCase(unit) == 0){
        mass = u.getMassInGrams();
      }
    }	
    return mass;
  }

  private float getVolumeByUnit(String unit){
    float volume = 0f;

    for(UnitOfVolume u : UnitOfVolume.values()){
      if(u.getUnitName().compareToIgnoreCase(unit) == 0){
        volume = u.getVolume();
      }
    }

    return volume;
  }

  private float getDensityByIngredient(String ingredient){
    float density = 0f;

    for(IngredientDensity d : IngredientDensity.values()){
      if(d.getIngredientName().compareToIgnoreCase(ingredient) == 0){
        density = d.getDensity();
      }
    }

    return density;
  }
  
  private float getMassByCountable(String ingredient){
	float mass = 0f;
	
	for(CountableIngredient c : CountableIngredient.values()){
      if(c.getCountableIngredientName().compareToIgnoreCase(ingredient) == 0){
        mass = c.getMass();
      }
    }	
    return mass;
  }

}
