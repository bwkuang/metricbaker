public class IngredientConverter{

  private float breadFlourDensity = 0.58f;
  private float cupVolume = 236;

  public int convert(float numberOfCups){
    return Math.round(numberOfCups * this.cupVolume * this.breadFlourDensity);
  }

}
