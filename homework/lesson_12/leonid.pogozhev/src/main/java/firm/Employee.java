package firm;

public abstract class Employee implements Payable {
  protected String name;
  protected float dayRate;
  protected float workDays;
  protected PaymentPeriod period;

  public void setWorkingHours(int workingHours) {
    float per = (float)period.getDaysNumber();

    workDays = ((float)Math.floor(workingHours / (per * WORKING_HOURS_PER_DAY))) * per;
  }
}