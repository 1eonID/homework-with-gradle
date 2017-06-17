package firm.stuff;

import static firm.PaymentPeriod.BIWEEKLY;
import static firm.PaymentPeriod.MONTHLY;
import static firm.PaymentPeriod.WEEKLY;

import firm.Employee;
import firm.PaymentPeriod;

public class Manager extends Employee {
  private float bonus;
  private String name;
  private float gainPerDay;
  private float amountOfWorkingDays;
  private PaymentPeriod paymentPeriod;

  public Manager(String name, float gainPerDay, PaymentPeriod paymentPeriod) {
    this.name = name;
    this.gainPerDay = gainPerDay;
    this.paymentPeriod = paymentPeriod;
  }

  public void setBonus(float bonus) {
    this.bonus = bonus;
  }

  public float calculatePayment() {
    return amountOfWorkingDays * gainPerDay + bonus;
  }

  public void setWorkingHours(int workingHours) {
    float weeklyKoef = (float)Math.floor(workingHours / (5.00f * WORKING_HOURS_PER_DAY));
    float biweeklyKoef = (float)Math.floor(workingHours / (10.00f * WORKING_HOURS_PER_DAY));
    float monthlyKoef = (float)Math.floor(workingHours / (20.00f * WORKING_HOURS_PER_DAY));

    if (paymentPeriod == WEEKLY) {
      amountOfWorkingDays = weeklyKoef * 5.00f;
    } else if (paymentPeriod == BIWEEKLY) {
      amountOfWorkingDays = biweeklyKoef * 10.00f;
    } else if (paymentPeriod == MONTHLY) {
      amountOfWorkingDays = monthlyKoef * 20.00f;
    }
  }


}
