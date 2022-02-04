import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private static EmailList emailList = new EmailList();
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            parsingCommand(input);
        }
    }

    public static void parsingCommand(String input){
        String command = input;
        String email = "";
        if(input.contains(" ")){
            command = input.substring(0, input.indexOf(' '));
            email = input.substring(input.indexOf(' ') + 1);
        }

        switch (command){
            case "ADD":
                emailList.add(email);
                break;
            case "LIST":
                System.out.println(emailList.toString());
                break;
            default:
                System.out.println("Команда не найдена");
        }

    }
}
