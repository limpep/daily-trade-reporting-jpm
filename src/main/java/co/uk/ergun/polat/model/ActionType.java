package co.uk.ergun.polat.model;

/**
 * Created on 16/08/2017.
 */
public enum ActionType {
  BUY("B"), SELL("S");

  private String actionType;

  ActionType(String actionType) {
    this.actionType = actionType;
  }

  public String getActionType() {
    return actionType;
  }
}
