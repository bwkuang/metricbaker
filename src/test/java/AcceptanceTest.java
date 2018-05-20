import org.junit.Test;
import org.junit.Before;
import org.junit.After;
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
  public void AcceptanceConvertFlourTest(){

    BreadIngredientsConverter.main(new String[] {"Flour", "2", "cup"});

    assertEquals("274",this.baos.toString());
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


}
