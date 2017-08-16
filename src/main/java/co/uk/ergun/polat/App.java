package co.uk.ergun.polat;

import co.uk.ergun.polat.service.TradeService;
import co.uk.ergun.polat.service.impl.FakeTradeServiceImpl;
import co.uk.ergun.polat.service.impl.RunTrade;

/**
 * Created on 16/08/2017.
 */
public class App {

  public static void main(String[] args) {

    TradeService tradeService = new FakeTradeServiceImpl();
    RunTrade runTrade =new RunTrade(tradeService);
    runTrade.executeTrade();
    runTrade.generateReport();
  }
}
