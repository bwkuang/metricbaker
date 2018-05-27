public class IngredientConverter{

  private float breadFlourDensity = 0.58f;
  private float sugarDensity = 0.85f;
  private float saltDensity = 1.25f;

  private float cupVolume = 236;
  private float teaSpoonVolume = 5;

  private float poundMass = 453.592f;

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

    if ("flour".compareToIgnoreCase(ingredient) == 0){
      density = this.breadFlourDensity;
    }
    else if ("sugar".compareToIgnoreCase(ingredient) == 0){
      density = this.sugarDensity;
    }
    else if ("salt".compareToIgnoreCase(ingredient) == 0){
      density = this.saltDensity;
    }

    return density;
  }




}
