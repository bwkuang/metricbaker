public enum IngredientDensity{

  allPurposeFlour("all purpose flour", 0.53f),
  breadFlour("bread flour", 0.58f),
  sugar("sugar", 0.85f),
  salt("salt", 1.25f),
  water("water", 1f),
  milk("milk", 1.03f),
  creme35("35% cream", 1.01f),
  powderedMilk("powdered milk", 0.449f),
  instantYeast("instant yeast",0.6f);

  private String ingredientName = "";
  private float density = 0f;

  private IngredientDensity(String ingredientName, float density){
    this.ingredientName = ingredientName;
    this.density = density;
  }

  public String getIngredientName(){
    return ingredientName;
  }
  public float getDensity(){
    return density;
  }

}
