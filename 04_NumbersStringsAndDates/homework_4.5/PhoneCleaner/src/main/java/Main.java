import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      Pattern pattern = Pattern.compile("(\\+7|8)?[-\\s(]*(\\d{3})[-)\\s]*(\\d{3})[-\\s]?(\\d{2})[-\\s]?(\\d{2})$");
      Matcher matcher = pattern.matcher(input);

      if(!matcher.matches()){
        System.out.println("Неверный формат номера");
      } else {
        System.out.println(matcher.replaceAll("7$2$3$4$5"));
      }
    }
  }

}
