package co.uk.ergun.polat.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * Created on 16/08/2017.
 *
 */
public class TradeTypeTest {

  @Test
  public void testBuyTrade() { assertEquals("B", TradeType.BUY.getTradeType()); }

  @Test
  public void testSellTrade() { assertEquals("S", TradeType.SELL.getTradeType()); }

}
