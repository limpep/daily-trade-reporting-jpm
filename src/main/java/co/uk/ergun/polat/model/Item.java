package co.uk.ergun.polat.model;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * Created on 16/08/2017.
 */
public class Item implements Comparable<Item> {

  private String entity;

  private ActionType actionType;

  private BigDecimal agreedFx;

  private String currency;

  private LocalDate instructionDate;

  private LocalDate settlementDate;

  private Long units;

  private BigDecimal pricePerUnit;

  public Item() {
  }

  public Item(String entity, ActionType actionType, BigDecimal agreedFx, String currency,
      LocalDate instructionDate, LocalDate settlementDate, Long units, BigDecimal pricePerUnit) {
    this.entity = entity;
    this.actionType = actionType;
    this.agreedFx = agreedFx;
    this.currency = currency;
    this.instructionDate = instructionDate;
    this.settlementDate = settlementDate;
    this.units = units;
    this.pricePerUnit = pricePerUnit;
  }

  public String getEntity() {
    return entity;
  }

  public void setEntity(String entity) {
    this.entity = entity;
  }

  public ActionType getActionType() {
    return actionType;
  }

  public void setActionType(ActionType actionType) {
    this.actionType = actionType;
  }

  public BigDecimal getAgreedFx() {
    return agreedFx;
  }

  public void setAgreedFx(BigDecimal agreedFx) {
    this.agreedFx = agreedFx;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
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
  public int compareTo(Item o) {
    return o.currencyUSDAmount().compareTo(this.currencyUSDAmount());
  }

  @Override
  public String toString() {
    return "Item{" +
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

    Item item = (Item) o;

    return entity != null ? entity.equals(item.entity) : item.entity == null;
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
