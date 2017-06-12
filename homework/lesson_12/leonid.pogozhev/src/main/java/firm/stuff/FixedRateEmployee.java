package firm.stuff;

import firm.Employee;
import firm.PaymentPeriod;

public class FixedRateEmployee extends Employee {

  public FixedRateEmployee(String name, float dayRate, PaymentPeriod period) {
    this.name = name;
    this.dayRate = dayRate;
    this.period = period;
  }

  public float calculatePayment() {
    return (workDays * dayRate);
  }
}
