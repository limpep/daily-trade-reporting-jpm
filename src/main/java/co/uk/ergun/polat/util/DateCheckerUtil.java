package co.uk.ergun.polat.util;

import co.uk.ergun.polat.model.Currency;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created on 16/08/2017.
 */
public class DateCheckerUtil {

  private DateCheckerUtil() {
  }

  public static boolean isWeekend(LocalDate date, Currency currency) {

    DayOfWeek dayOfWeek = date.getDayOfWeek();

    if (currency.isWorkWeekStartsMondayEndsFriday()) {
      return (DayOfWeek.SUNDAY == dayOfWeek || DayOfWeek.SATURDAY == dayOfWeek);
    } else {
      return (DayOfWeek.FRIDAY == dayOfWeek || DayOfWeek.SATURDAY == dayOfWeek);
    }
  }

  public static LocalDate shifted(LocalDate date, Currency currency) {

    while (DateCheckerUtil.isWeekend(date, currency)) {
      date = date.plusDays(1);
    }
    return date;
  }
}
