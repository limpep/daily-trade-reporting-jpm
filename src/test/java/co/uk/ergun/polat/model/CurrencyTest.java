package co.uk.ergun.polat.model;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Created on 16/08/2017.
 */
public class CurrencyTest {

  @Test
  public void workingDayOnFridayTest(){
    assertFalse(Currency.AED.isWorkWeekStartsMondayEndsFriday());
    assertFalse(Currency.SAR.isWorkWeekStartsMondayEndsFriday());
    assertTrue(Currency.SGP.isWorkWeekStartsMondayEndsFriday());
  }

}
