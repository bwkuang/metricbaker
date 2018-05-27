import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class AcceptanceTest{

  private ByteArrayOutputStream baos;
  private PrintStream originalOutputStream;
  private PrintStream newOutputStream;

  @Before
  public void setUp(){
    redirectSystemOut();
  }

  @After
  public void tearDown(){
    resetSystemOut();
  }

  @Test
  public void ConvertFlourTest(){

    BreadIngredientsConverter.main(new String[] {"Flour", "2", "cup"});

    assertEquals("274",getActualResult());
  }


  @Test
  public void ConvertSugarTest(){
    BreadIngredientsConverter.main(new String[] {"sugar", "1", "cup"});

    assertEquals("201", getActualResult());
  }

  @Test
  public void ConvertSaltTest(){
    BreadIngredientsConverter.main(new String[] {"salt", "0.5", "teaspoon"});

    assertEquals("3", getActualResult());
  }

  @Test
  public void ConvertButterTest(){
    BreadIngredientsConverter.main(new String[] {"butter", "0.25", "pound"});

    assertEquals("113", getActualResult());
  }

  private void redirectSystemOut(){
    this.originalOutputStream = System.out;
    this.baos = new ByteArrayOutputStream();
    this.newOutputStream = new PrintStream(baos);
    System.setOut(newOutputStream);
  }

  private void resetSystemOut(){
    System.setOut(originalOutputStream);
  }

  private String getActualResult(){
    return this.baos.toString();
  }


}
