package co.uk.ergun.polat.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 16/08/2017.
 */
public class TradeDTO {
  private Map<LocalDate, BigDecimal> incomingDaily = new HashMap<>();
  private Map<LocalDate, BigDecimal> outgoingDaily = new HashMap<LocalDate, BigDecimal>();
  private List<Trade> managedTrades = new ArrayList<Trade>();

  public Map<LocalDate, BigDecimal> getIncomingDaily() {
    return incomingDaily;
  }

  public void setIncomingDaily(Map<LocalDate, BigDecimal> incomingDaily) {
    this.incomingDaily = incomingDaily;
  }

  public Map<LocalDate, BigDecimal> getOutgoingDaily() {
    return outgoingDaily;
  }

  public void setOutgoingDaily(Map<LocalDate, BigDecimal> outgoingDaily) {
    this.outgoingDaily = outgoingDaily;
  }

  public List<Trade> getManagedTrades() {
    return managedTrades;
  }

  public void setManagedTrades(List<Trade> managedTrades) {
    this.managedTrades = managedTrades;
  }
}
