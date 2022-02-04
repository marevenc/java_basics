package main.java;

public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;

    int sum = sumDigits(7843);

    System.out.println(sum);
  }


//  public static int sumDigits(Integer number) {
//    if(number == null) return -1;
//    String strNumber = number.toString();
//    int sum = 0;
//    for(int i = 0; i < strNumber.length(); i++){
//      sum += Integer.parseInt(String.valueOf(strNumber.charAt(i)));
//    }
//    return sum;
//  }

  public static int sumDigits(Integer number){
    if(number == null) return -1;
    String strNumber = number.toString();
    int sum = 0;
    for(int i = 0; i < strNumber.length(); i++){
      sum += Character.getNumericValue(strNumber.charAt(i));
    }
    return sum;
  }
}
