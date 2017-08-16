package co.uk.ergun.polat.service;

import co.uk.ergun.polat.model.Currency;
import co.uk.ergun.polat.model.Trade;
import co.uk.ergun.polat.model.TradeType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16/08/2017.
 */
public class TradeFactory {

  public Trade createTrade (String entity, TradeType tradeType,
      Currency currency, BigDecimal pricePerUnit, BigDecimal agreedFx,
      Long units, LocalDate settlementDate){

    Trade trade = new Trade();

    trade.setEntity(entity);
    trade.setTradeType(tradeType);
    trade.setCurrency(currency);
    trade.setPricePerUnit(pricePerUnit);
    trade.setAgreedFx(agreedFx);
    trade.setUnits(units);
    trade.setSettlementDate(settlementDate);

    return trade;
  }


  public List<Trade> getTadesTest() {
    List<Trade> trades = new ArrayList<>();

    trades.add(createTrade("foo", TradeType.BUY, Currency.SGP,
        BigDecimal.valueOf(10.0), BigDecimal.valueOf(2.0),
        2l, LocalDate.of(2017, 7, 28)));

    trades.add(createTrade("bar", TradeType.SELL, Currency.SGP,
        BigDecimal.valueOf(30.0), BigDecimal.valueOf(2.0),
        2l, LocalDate.of(2017, 6, 3)));

    trades.add(createTrade("foo", TradeType.BUY, Currency.AED,
        BigDecimal.valueOf(20.0), BigDecimal.valueOf(2.0),
        2l, LocalDate.of(2017, 7, 3)));

    return trades;
  }
}
