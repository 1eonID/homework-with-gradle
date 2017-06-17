package firm.stuff;

import firm.Employee;

public class HourlyRateEmployee extends Employee {
  private String name;
  private float gainPerHour;
  private float amountOfWorkingHours;

  public HourlyRateEmployee(String name, float gainPerHour) {
    this.name = name;
    this.gainPerHour = gainPerHour;
  }

  public float calculatePayment() {
    return (amountOfWorkingHours * gainPerHour);
  }

  public void setWorkingHours(int workingHours) {
    amountOfWorkingHours = (float)workingHours;
  }
}
