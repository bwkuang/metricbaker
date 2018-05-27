import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class IngredientConverterTest {

  private IngredientConverter converter;

  @Before
  public void setUp(){
    converter = new IngredientConverter();
  }

  @Test
  public void shouldConvertFlourFromCupToGram(){
    int expectedWeight = 137;
    int actualWeight = converter.convert("flour", 1f, "cup");

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
  public void shouldConvertButterFromPoundToGram(){
    int expectedWeight = 113;
    int actualWeight = converter.convert("butter", 0.25f, "pound");
    assertEquals(expectedWeight, actualWeight);
  }
}
