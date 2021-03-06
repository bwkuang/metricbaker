package metricbaker;

import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONObjectAs;
import  org.json.JSONObject;


public class IngredientConverterTest {

  private IngredientConverter converter;

  @Before
  public void setUp(){
    converter = new IngredientConverter();
  }

  @Test
  public void shouldConvertSugarFromCupToGram(){
    int expectedWeight = 201;
    // Ingredient sugar = Ingredient.sugar(1f, UnitOfVolume.cup);
    Ingredient sugar = Ingredient.sugar(new Quantity(1f, UnitOfVolume.cup));
    assertEquals(expectedWeight, sugar.getWeight());
  }

  @Test
  public void shouldConvertFlourFromCupToGram(){
    int expectedWeight = 137;
    Ingredient breadFlour = Ingredient.breadFlour(new Quantity(1f, UnitOfVolume.cup));

    assertEquals(expectedWeight, breadFlour.getWeight());
  }

  @Test
  public void shouldConvertButterFromPoundsToGrams(){
    int expectedWeight = 113;
    Ingredient butter = Ingredient.butter(new Quantity(0.25f, UnitOfMass.pound));
    assertEquals(expectedWeight, butter.getWeight());
  }

  @Test
  public void shouldConvertButterFromKiloToGram(){
    int expectedWeight = 1250;
    Ingredient ingredient = Ingredient.butter(new Quantity(1.25f, UnitOfMass.kilogram));
    assertEquals(expectedWeight, ingredient.getWeight());
  }
  
  @Test
  public void shouldConvertCountableToGram(){
    int expectedWeight = 120;
    Ingredient ingredient = CountableIngredient.largeEgg(2);
	  
	  assertEquals(expectedWeight, ingredient.getWeight());
  }

  @Test
  @Ignore
  public void shouldConvertMultipleIngredients(){
    JSONObject expectedResult = getMulitpleIngredientsExpectedResult();
    JSONObject actualResult = converter.convert(getMulitpleIngredients());
    assertThat(expectedResult , sameJSONObjectAs(actualResult));
  }

  private JSONObject getMulitpleIngredients(){
	  String ingredients = "{\r\n\t\"ingredients\":\r\n\t[\r\n\t\t{\r\n\t\t\t\"ingredient\":\"sugar\",\r\n\t\t\t\"amount\":\"0.5\",\r\n\t\t\t\"unit\":\"cup\"\r\n\t\t},\r\n\t\t{\r\n\t\t\t\"ingredient\":\"salt\",\r\n\t\t\t\"amount\":\"2.25\",\r\n\t\t\t\"unit\":\"teaspoon\"\r\n\t\t}\r\n\t]\r\n}";
	  
    return new JSONObject(ingredients);
  }
  
  private JSONObject getMulitpleIngredientsExpectedResult(){
	  String ingredients = "{\r\n\t\"ingredients\":\r\n\t[\r\n\t\t{\r\n\t\t\t\"ingredient\":\"sugar\",\r\n\t\t\t\"amount\":\"100\",\r\n\t\t\t\"unit\":\"gram\"\r\n\t\t},\r\n\t\t{\r\n\t\t\t\"ingredient\":\"salt\",\r\n\t\t\t\"amount\":\"14\",\r\n\t\t\t\"unit\":\"gram\"\r\n\t\t}\r\n\t]\r\n}";

    return new JSONObject(ingredients);
  }
  
}
