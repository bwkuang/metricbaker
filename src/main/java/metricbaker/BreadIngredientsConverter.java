package metricbaker;

public class BreadIngredientsConverter{

  public static void main(String[] args){

    IngredientConverter converter = new IngredientConverter();

    String ingredient = args[0];
    float amount = Float.parseFloat(args[1]);
    String unit = args[2];

    int result = converter.convert(ingredient, amount, unit);

    System.out.print(result);

  }

}
