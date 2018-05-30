public class IngredientConverter{


  private float allPurposeFlour = 0.53f;
  private float breadFlourDensity = 0.58f;
  private float sugarDensity = 0.85f;
  private float saltDensity = 1.25f;
  private float waterDensity = 1f;
  private float milkDensity = 1.03f;
  private float cremeDensity = 1.01f;
  private float powderMilk = 0.449f;
  private float instantYeast = 0.6f;

  private float cupVolume = 236f;
  private float teaSpoonVolume = 5f;
  private float tablespoonVolume = 15f;
  private float fluidOzVolume = 30f;
 	private float literVolume = 1000f;
  private float mlVolume = 1f;


  private float poundMass = 453.592f;
  private float kiloMass = 1000f;
  private float ozMass= 28.3495f;
  private float gramMass = 1f;

  // Countable Ingredients
  private float largeEggMass = 60f;

  public int convert(float numberOfCups){
    return Math.round(numberOfCups * this.cupVolume * this.breadFlourDensity);
  }

  public int convert(String ingredient, float amount, String unit){
    float massInGramsForOneUnit = getGramsByMassUnit(unit);

    if(massInGramsForOneUnit == 0){
      massInGramsForOneUnit = getVolumeByUnit(unit) * getDensityByIngredient(ingredient);
    }

    return Math.round(amount * massInGramsForOneUnit);
  }

  private float getGramsByMassUnit(String unit){
    float mass = 0f;

    if("pound".compareToIgnoreCase(unit) == 0){
      mass = this.poundMass;
    }
    else if ("kilo".compareToIgnoreCase(unit) == 0 || "kilogramme".compareToIgnoreCase(unit) == 0 || "kg".compareToIgnoreCase(unit) == 0){
      mass = this.kiloMass;
    }
    return mass;
  }

  private float getVolumeByUnit(String unit){
    float volume = 0f;

    if ("teaspoon".compareToIgnoreCase(unit) == 0){
      volume = this.teaSpoonVolume;
    }
    else if ("cup".compareToIgnoreCase(unit) == 0){
      volume = this.cupVolume;
    }
    return volume;
  }



  private float getDensityByIngredient(String ingredient){
    float density = 0f;

    for(IngredientDensity d : IngredientDensity.values()){
      if(d.getName().compareToIgnoreCase(ingredient) == 0){
        density = d.getDensity();
      }
    }

    return density;
  }



}
