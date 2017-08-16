package co.uk.ergun.polat.service.impl;

import co.uk.ergun.polat.model.Trade;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created on 16/08/2017.
 */
public class CreateReport {

  public void printAmountSettled(String type,
      Map<LocalDate, BigDecimal> incoming) {
      System.out.println(type);
      incoming.forEach((key, value) -> System.out.println(key + " : " + value));
      System.out.println(System.lineSeparator());
  }


  public void printRankIncomingTrade(List<Trade> trades) {
    printRanked(trades, "Incoming");
    System.out.println(System.lineSeparator());
  }

  public void printRankOutgoingTrade(List<Trade> trades) {
    printRanked(trades, "Outgoing");
    System.out.println(System.lineSeparator());
  }

  private void printRanked(List<Trade> trades, String type) {
    System.out.println(type);
    trades.forEach(System.out::println);
  }
}
