package co.uk.ergun.polat.model;

/**
 * Created on 16/08/2017.
 */
public enum Currency {
  SGP(true), AED(false), SAR(false);

  private boolean workWeekStartsMondayEndsFriday;

  Currency(boolean workWeekStartsMondayEndsFriday) {
    this.workWeekStartsMondayEndsFriday = workWeekStartsMondayEndsFriday;
  }

  public boolean isWorkWeekStartsMondayEndsFriday() {
    return workWeekStartsMondayEndsFriday;
  }
}
