import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
  }

  public static String splitTextIntoWords(String text) {
    StringBuilder builder = new StringBuilder();
    Pattern pattern = Pattern.compile("[a-zA-Z’]+");
    Matcher matcher = pattern.matcher(text);
    while(matcher.find()){
      builder.append(matcher.group());
      builder.append("\n");
    }
    return builder.toString().trim();
  }

}