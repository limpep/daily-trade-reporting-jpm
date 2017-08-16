package co.uk.ergun.polat.service;

import static org.junit.Assert.assertEquals;

import co.uk.ergun.polat.model.Currency;
import co.uk.ergun.polat.model.Trade;
import co.uk.ergun.polat.model.TradeType;
import co.uk.ergun.polat.service.impl.TradeManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Created on 16/08/2017.
 */
public class TradeManagerTest  {
  private TradeManager tradeManager = new TradeManager();
  private TradeFactory factory = new TradeFactory();


  @Test
  public void rankTradesByIncomingAmount() {
    LocalDate fooDate = LocalDate.of(2017, 5, 3);
    LocalDate barDate = LocalDate.of(2017, 1, 5);
    LocalDate wontUse = LocalDate.of(2017, 2, 7);

    List<Trade> tradeList = new ArrayList<>();
    tradeList.add(factory.createTrade(
        "foo",
        TradeType.SELL,
        Currency.AED,
        BigDecimal.valueOf(10.0),
        BigDecimal.valueOf(1),
        1L
        ,fooDate));

    tradeList.add(factory.createTrade(
        "bar",
        TradeType.SELL,
        Currency.SAR,
        BigDecimal.valueOf(20.0),
        BigDecimal.valueOf(1),
        1L
        ,barDate));

    tradeList.add(factory.createTrade(
        "notCounting",
        TradeType.BUY,
        Currency.SAR,
        BigDecimal.valueOf(10.0),
        BigDecimal.valueOf(1),
        1L
        ,wontUse));

    List<Trade> tradeResult = tradeManager.rankTradesByIncomingAmount(tradeList);
    assertEquals(2, tradeResult.size());
    assertEquals("bar", tradeResult.get(0).getEntity());
    assertEquals("foo", tradeResult.get(1).getEntity());
  }

}
