public class IngredientConverter{


  // Countable Ingredients
  private float largeEggMass = 60f;

  public int convert(String ingredient, float amount, String unit){
    float massInGramsForOneUnit = getGramsByMassUnit(unit);

    if(massInGramsForOneUnit == 0){
      massInGramsForOneUnit = getVolumeByUnit(unit) * getDensityByIngredient(ingredient);
    }

    return Math.round(amount * massInGramsForOneUnit);
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

}
