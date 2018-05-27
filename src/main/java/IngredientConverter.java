public class IngredientConverter{

  private float breadFlourDensity = 0.58f;
  private float sugarDensity = 0.85f;
  private float saltDensity = 1.25f;
  private float cupVolume = 236;
  private float teaSpoonVolume = 5;

  public int convert(float numberOfCups){
    return Math.round(numberOfCups * this.cupVolume * this.breadFlourDensity);
  }

  public int convert(String ingredient, float amount, String unit){

    float volume = getVolumeByUnit(unit);

    if ("flour".compareToIgnoreCase(ingredient) == 0){
      return Math.round(amount * volume * this.breadFlourDensity);
    }
    else if ("sugar".compareToIgnoreCase(ingredient) == 0){
      return Math.round(amount * volume * this.sugarDensity);
    }
    else if ("salt".compareToIgnoreCase(ingredient) == 0){
      return Math.round(amount * volume * this.saltDensity);
    }

    return 0;
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

}
