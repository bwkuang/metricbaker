import org.junit.Test;
import org.junit.Before;
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
  public void shouldConvertFlourFromCupToGram(){
    int expectedWeight = 137;
    int actualWeight = converter.convert("Bread flour", 1f, "cup");

    assertEquals(expectedWeight, actualWeight);
  }

  @Test
  public void shouldConvertSugarFromCupToGram(){
    int expectedWeight = 201;
    int actualWeight = converter.convert("sugar", 1f, "cup");
    assertEquals(expectedWeight, actualWeight);
  }

  @Test
  public void shouldConvertSaltFromTeaspoonToGram(){
    int expectedWeight = 3;
    int actualWeight = converter.convert("salt", 0.5f, "teaspoon");
    assertEquals(expectedWeight, actualWeight);
  }

  @Test
  public void shouldConvertFlourFromCupToGramNew(){
    int expectedWeight = 137;
    Ingredient breadFlour = Ingredient.breadFlour(1f, UnitOfVolume.cup);

    assertEquals(expectedWeight, breadFlour.getWeight());
  }

  @Test
  public void shouldConvertButterFromPoundToGram(){
    int expectedWeight = 113;
    int actualWeight = converter.convert("butter", 0.25f, "pound");
    assertEquals(expectedWeight, actualWeight);
  }

  @Test
  public void shouldConvertButterFromKiloToGram(){
    int expectedWeight = 1250;
    int actualWeight = converter.convert("butter", 1.25f, "kilogram");
    assertEquals(expectedWeight, actualWeight);
  }
  
  @Test
  public void shouldConvertCountableToGram(){
	  int expectedWeight = 120;
	  int actualWeight = converter.convert("large egg", 2, "countable");
	  
	  assertEquals(expectedWeight, actualWeight);
  }

  @Test
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
