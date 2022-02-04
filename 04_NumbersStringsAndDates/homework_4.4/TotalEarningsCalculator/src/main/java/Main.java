public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    int spaceIndex = 0;
    int previousSpaceIndex;
    int sum = 0;
    int spaceCount = 0;

    for(int i = 0; i < text.length(); i++){
      if(text.charAt(i) == ' '){
        spaceCount++;
      }
    }

    for(int i = 0; i < spaceCount; i++){
      previousSpaceIndex = spaceIndex;
      spaceIndex = text.indexOf(' ', spaceIndex + 1);
      try{
        sum += Integer.parseInt(text.substring(previousSpaceIndex, spaceIndex).trim());
      } catch (NumberFormatException ignored){
      }
    }

    try{
      sum += Integer.parseInt(text.substring(text.lastIndexOf(' ') + 1));
    } catch (NumberFormatException ignored){
    }
    System.out.println(sum);
  }
}