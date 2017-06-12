package firm.stuff;

import firm.PaymentPeriod;

public class Manager extends FixedRateEmployee {

  private float bonus;

  public Manager(String name, float dayRate, PaymentPeriod period) {
    super(name, dayRate, period);
  }

  public float calculatePayment() {
    return (workDays * dayRate) + bonus;
  }

  public void setBonus(float inBonus) {
    bonus = inBonus;
  }
}
