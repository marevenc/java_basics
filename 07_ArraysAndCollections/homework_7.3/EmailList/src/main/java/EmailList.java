import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    Set<String> emails = new TreeSet<>();

    public void add(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()){
            emails.add(email.toLowerCase());
        } else {
            System.out.println("Неверный формат email");
        }
    }

    public List<String> getSortedEmails() {
        return new ArrayList<String>(emails);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(String email : emails){
            builder.append(email).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

}
