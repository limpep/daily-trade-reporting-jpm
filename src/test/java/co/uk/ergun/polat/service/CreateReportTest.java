package co.uk.ergun.polat.service;

import co.uk.ergun.polat.service.impl.RunTrade;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created on 16/08/2017.
 */
public class CreateReportTest {

  private RunTrade runTrade;

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
    // Usually would use a Mock object here
    runTrade = new RunTrade(new TestTradeService());
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
  }


  @Test
  public void simpleTrade(){
    runTrade.executeTrade();
    runTrade.generateReport();
    assertEquals(expectedOutput(), outContent.toString());
  }

  private String expectedOutput(){
    return "Incoming" + System.lineSeparator() + "2017-06-05 : 120.00"
        + System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
        +"Outgoing" + System.lineSeparator() + "2017-07-28 : 40.00"
        + System.lineSeparator() + "2017-07-03 : 80.00" +
         System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
        + "Incoming" + System.lineSeparator()
        + "Trade{entity='bar'amount='120.00'}"
        + System.lineSeparator() + System.lineSeparator() + System.lineSeparator()
        + "Outgoing" + System.lineSeparator()
        + "Trade{entity='foo'amount='80.00'}"
        + System.lineSeparator() + System.lineSeparator() + System.lineSeparator();

  }
}
