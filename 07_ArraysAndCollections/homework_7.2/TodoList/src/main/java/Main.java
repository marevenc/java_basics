import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while(true){
            input = scanner.nextLine();
            parsingCommand(input);
        }
    }

    public static void parsingCommand(String input){
        String command = input;
        if(input.contains(" ")){
            command = input.substring(0, input.indexOf(' '));
        }
        String task = input.substring(input.indexOf(" ") + 1);
        boolean hasDigit = task.matches("^(\\d).*");

        int index = -1;
        if(hasDigit){
            if(task.contains(" ")){
                index = Integer.parseInt(task.substring(0, task.indexOf(" ")));
            } else {
                index = Integer.parseInt(task);
            }

        }

        switch (command){
            case "ADD":
                if(hasDigit){
                    todoList.add(index, task.substring(task.indexOf(" ") + 1));
                } else {
                    todoList.add(task);
                }
                break;
            case "LIST":
                System.out.println(todoList.toString());
                break;
            case "EDIT":
                todoList.edit(task.substring(task.indexOf(" ") + 1), index);
                break;
            case "DELETE":
                todoList.delete(index);
                break;
            default:
                System.out.println("Команда не найдена");
        }
    }
}
