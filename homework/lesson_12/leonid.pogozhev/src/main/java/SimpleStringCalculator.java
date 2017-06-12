public class SimpleStringCalculator {
  public int add(String expression) {
    int sum = 0;
    if (expression == null || expression.trim().isEmpty()) {
      return 0;
    }
    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);
      // Строка позволяет работать с числами больше 9
      String operand = "";
      if (Character.isDigit(ch)) {
        // пока текущий элемент строки меньше длины строки и текущий
        // элемент это число, то составляем строку числа из символов
        while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
          operand += expression.charAt(i++);
        }
        --i;
        int numoper = Integer.parseInt(operand);
        // если число меньше или равно 1000, то суммируем
        // если больше 1000, то пропускаем
        if (numoper <= 1000) {
          sum += numoper;
        }
      } else if ((ch == '-') && Character.isDigit(expression.charAt(i + 1))) {
        return -1;
      }
    }
    return sum;
  }
}
