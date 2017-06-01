package exersice;

import exersice.logger.InitOrderLogger;

public class GrandParentClass {
  private InitOrderLogger l1 = InitOrderLogger.logAndGetInstance(13);
  private static InitOrderLogger l2 = InitOrderLogger.logAndGetInstance(1);

  {
    InitOrderLogger.logAndGetInstance(10);
  }

  static {
    InitOrderLogger.logAndGetInstance(2);
  }

  public GrandParentClass() {
    InitOrderLogger.logAndGetInstance(7);
  }
}
