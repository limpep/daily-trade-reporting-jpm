package co.uk.ergun.polat.model;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * Created on 16/08/2017.
 */
public class Trade implements Comparable<Trade> {

  private String entity;

  private TradeType tradeType;

  private BigDecimal agreedFx;

  private Currency currency;

  private LocalDate instructionDate;

  private LocalDate settlementDate;

  private Long units;

  private BigDecimal pricePerUnit;

  public Trade() {
  }

  public Trade(Trade trade) {
    this.entity = trade.entity;
    this.tradeType = trade.tradeType;
    this.agreedFx = trade.agreedFx;
    this.currency = trade.currency;
    this.instructionDate = trade.instructionDate;
    this.settlementDate = trade.settlementDate;
    this.units = trade.units;
    this.pricePerUnit = trade.pricePerUnit;
  }

  public String getEntity() {
    return entity;
  }

  public void setEntity(String entity) {
    this.entity = entity;
  }

  public TradeType getTradeType() {
    return tradeType;
  }

  public void setTradeType(TradeType tradeType) {
    this.tradeType = tradeType;
  }

  public BigDecimal getAgreedFx() {
    return agreedFx;
  }

  public void setAgreedFx(BigDecimal agreedFx) {
    this.agreedFx = agreedFx;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public LocalDate getInstructionDate() {
    return instructionDate;
  }

  public void setInstructionDate(LocalDate instructionDate) {
    this.instructionDate = instructionDate;
  }

  public LocalDate getSettlementDate() {
    return settlementDate;
  }

  public void setSettlementDate(LocalDate settlementDate) {
    this.settlementDate = settlementDate;
  }

  public Long getUnits() {
    return units;
  }

  public void setUnits(Long units) {
    this.units = units;
  }

  public BigDecimal getPricePerUnit() {
    return pricePerUnit;
  }

  public void setPricePerUnit(BigDecimal pricePerUnit) {
    this.pricePerUnit = pricePerUnit;
  }

  @Override
  public int compareTo(Trade o) {
    return o.currencyUSDAmount().compareTo(this.currencyUSDAmount());
  }

  @Override
  public String toString() {
    return "Trade{" +
        "entity='" + entity + '\'' +
        "entity='" + entity + '\'' +
        '}';
  }

  public BigDecimal currencyUSDAmount() {
    BigDecimal result = new BigDecimal(units);
    return result.multiply(pricePerUnit).multiply(agreedFx);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Trade trade = (Trade) o;

    return entity != null ? entity.equals(trade.entity) : trade.entity == null;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((entity == null) ? 0 : entity.hashCode());
    return result;
  }
}
