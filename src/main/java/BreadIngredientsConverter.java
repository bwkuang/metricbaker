public class BreadIngredientsConverter{

  public static void main(String[] args){

    IngredientConverter converter = new IngredientConverter();
    int result = converter.convert(Integer.parseInt(args[1]));

    System.out.print(result);

  }

}
