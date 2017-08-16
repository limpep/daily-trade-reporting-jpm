package co.uk.ergun.polat.service;

import co.uk.ergun.polat.model.Trade;
import java.util.List;

/**
 * Created on 16/08/2017.
 */
public class TestTradeService implements TradeService {

  private TradeFactory factory = new TradeFactory();

  @Override
  public List<Trade> getTades() {
    return factory.getTadesTest();
  }
}
