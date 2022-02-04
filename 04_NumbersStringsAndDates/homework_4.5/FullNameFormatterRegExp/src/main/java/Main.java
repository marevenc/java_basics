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
      String regex = "([А-Яа-я-]+)\\s+([А-Яа-я-]+)\\s+([А-Яа-я-]+)";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);

      if(!matcher.matches()){
        System.out.println("Введенная строка не является ФИО");
      } else{
        System.out.println("Фамилия: " + matcher.group(1));
        System.out.println("Имя: " + matcher.group(2));
        System.out.println("Отчество: " + matcher.group(3));
      }
    }
  }

}