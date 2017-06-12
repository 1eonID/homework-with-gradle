package firm.stuff;

import firm.Employee;

public class HourlyRateEmployee extends Employee {
  // private String name;
  private float hourlyRate;
  private float workHours;

  public HourlyRateEmployee(String name, float hourlyRate) {
    this.name = name;
    this.hourlyRate = hourlyRate;
  }

  public float calculatePayment() {
    return (workHours * hourlyRate);
  }

  public void setWorkingHours(int workingHours) {
    workHours = (float)workingHours;
  }
}
