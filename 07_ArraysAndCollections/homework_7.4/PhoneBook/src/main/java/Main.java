import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            parsingCommand(input);
        }
    }

    public static void parsingCommand(String input){
        Scanner scanner = new Scanner(System.in);
        String name, phone;
        Pattern patternName = Pattern.compile("[A-Za-zА-Яа-я]+");
        Pattern patternPhone  = Pattern.compile("\\d+");
        Matcher matcherName = patternName.matcher(input);
        Matcher matcherPhone = patternPhone.matcher(input);

        if(input.equals("LIST")){
            System.out.println(phoneBook.getAllContacts());
        } else if(matcherName.find()){
            name = input;
            if(phoneBook.containsName(name)){
                System.out.println(phoneBook.getPhonesByName(name));
            } else {
                System.out.println("Такого имени в телефонной книге нет.");
                System.out.println("Введите номер телефона для абонента \"" + name + "\":");
                phone = scanner.nextLine();
                if(patternPhone.matcher(phone).find()){
                    phoneBook.addContact(phone, name);
                    System.out.println("Контакт сохранен!");
                }
            }
        } else if(matcherPhone.find()){
            phone = input;
            if(phoneBook.containsPhone(phone)){
                System.out.println(phoneBook.getNameByPhone(phone));
            } else {
                System.out.println("Такого номера в телефонной книге нет.");
                System.out.println("Введите имя абонента для номера \"" + phone + "\":");
                name = scanner.nextLine();
                if(patternName.matcher(name).find()){
                    phoneBook.addContact(phone, name);
                    System.out.println("Контакт сохранен!");
                }
            }
        } else {
            System.out.println("Неверный формат ввода");
        }
    }
}
