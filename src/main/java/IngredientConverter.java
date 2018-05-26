public class IngredientConverter{

  private float breadFlourDensity = 0.58f;
  private float sugarDensity = 0.85f;
  private float cupVolume = 236;

  public int convert(float numberOfCups){
    return Math.round(numberOfCups * this.cupVolume * this.breadFlourDensity);
  }

  public int convert(String ingredient, float numberOfCups){
    if ("flour".compareToIgnoreCase(ingredient) == 0){
      return Math.round(numberOfCups * this.cupVolume * this.breadFlourDensity);
    }
    else if ("sugar".compareToIgnoreCase(ingredient) == 0){
      return Math.round(numberOfCups * this.cupVolume * this.sugarDensity);
    }
    return 0;
  }
}
