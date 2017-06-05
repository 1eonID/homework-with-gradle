package firm.stuff;

import static firm.PaymentPeriod.BIWEEKLY;
import static firm.PaymentPeriod.MONTHLY;
import static firm.PaymentPeriod.WEEKLY;

import firm.Employee;
import firm.PaymentPeriod;

public class FixedRateEmployee extends Employee {
  private String name;
  private float dayRate;
  private float workDays;
  private PaymentPeriod period;

  public FixedRateEmployee(String name, float dayRate, PaymentPeriod period) {
    this.name = name;
    this.dayRate = dayRate;
    this.period = period;
  }

  public float calculatePayment() {
    return (workDays * dayRate);
  }

  public void setWorkingHours(int workingHours) {
    float koefWeekly = (float)Math.floor(workingHours / (5.00f * WORKING_HOURS_PER_DAY));
    float koefBiweekly = (float)Math.floor(workingHours / (10.00f * WORKING_HOURS_PER_DAY));
    float koefMonthly = (float)Math.floor(workingHours / (20.00f * WORKING_HOURS_PER_DAY));

    if (period == WEEKLY) {
      workDays = koefWeekly * 5.00f;
    } else if (period == BIWEEKLY) {
      workDays = koefBiweekly * 10.00f;
    } else if (period == MONTHLY) {
      workDays = koefMonthly * 20.00f;
    }
  }
}
