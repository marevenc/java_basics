import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> toDoList = new ArrayList<>();

    public void add(String todo) {
        toDoList.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void add(int index, String todo) {
        if(index >= 0 && index <= toDoList.size()){
            toDoList.add(index, todo);
        } else {
            toDoList.add(todo);
        }
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void edit(String todo, int index) {
        if(index >= 0 && index <= toDoList.size()){
            System.out.println("Дело \"" + toDoList.get(index) + "\" заменено на \"" + todo + "\"");
            toDoList.set(index, todo);
        }
    }

    public void delete(int index) {
        if(index >= 0 && index < toDoList.size()){
            System.out.println("Дело \"" + toDoList.get(index) + "\" удалено");
            toDoList.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        return toDoList;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < toDoList.size(); i++){
            builder.append(i).append(" - ").append(toDoList.get(i)).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

}