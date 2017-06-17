package firm.stuff;

import firm.Employee;

public class Volunteer extends Employee {
  private String name;

  public Volunteer(String name) {
    this.name = name;
  }

  public float calculatePayment() {
    return 0.00f;
  }

  public void setWorkingHours(int workingHours) {

  }
}
