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
    int actualWeight = converter.convert(1f);

    assertEquals(expectedWeight, actualWeight);
  }

}
