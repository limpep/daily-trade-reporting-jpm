package co.uk.ergun.polat.model;

/**
 * Created on 16/08/2017.
 */
public enum TradeType {
  BUY("B"), SELL("S");

  private String tradeType;

  TradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  public String getTradeType() {
    return tradeType;
  }
}
