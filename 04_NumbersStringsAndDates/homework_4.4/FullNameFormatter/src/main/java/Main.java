import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int spaceCount = 0;
    boolean notLetters = false;

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      for(int i = 0; i < input.length(); i++){
        if(input.charAt(i) == ' '){
          spaceCount++;
        }
        if(((int)input.charAt(i) < 1040 && (int)input.charAt(i) != 45 && (int)input.charAt(i) != 32) ||
                (int)input.charAt(i) > 1103){
          notLetters = true;
        }
      }

      if(spaceCount != 2 || notLetters){
        System.out.println("Введенная строка не является ФИО");
      } else{
        System.out.println("Фамилия: " + input.substring(0, input.indexOf(' ')));
        System.out.println("Имя: " + input.substring(input.indexOf(' ') + 1, input.lastIndexOf(' ')));
        System.out.println("Отчество: " + input.substring(input.lastIndexOf(' ') + 1));
      }
    }
  }
}