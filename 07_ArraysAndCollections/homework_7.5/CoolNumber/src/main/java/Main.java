import java.util.*;

public class Main {

    public static String number = "В153УХ123";
    public static boolean isFound;

    public static void main(String[] args) {
        List<String> carNumbers = CoolNumbers.generateCoolNumbers();

        long then = System.nanoTime();
        isFound = CoolNumbers.bruteForceSearchInList(carNumbers, number);
        long now = System.nanoTime();

        if(isFound){
            System.out.println("Поиск перебором: номер найден, поиск занял " + (now - then) + "нс");
        } else {
            System.out.println("Поиск перебором: номер не найден, поиск занял " + (now - then) + "нс");
        }

        Collections.sort(carNumbers);
        then = System.nanoTime();
        isFound = CoolNumbers.binarySearchInList(carNumbers, number);
        now = System.nanoTime();

        if(isFound){
            System.out.println("Бинарный поиск: номер найден, поиск занял " + (now - then) + "нс");
        } else {
            System.out.println("Бинарный поиск: номер не найден, поиск занял " + (now - then) + "нс");
        }

        HashSet<String> hashSetCarNumbers = new HashSet<>(carNumbers);
        then = System.nanoTime();
        isFound = CoolNumbers.searchInHashSet(hashSetCarNumbers, number);
        now = System.nanoTime();

        if(isFound){
            System.out.println("Поиск в HashSet: номер найден, поиск занял " + (now - then) + "нс");
        } else {
            System.out.println("Поиск в HashSet: номер не найден, поиск занял " + (now - then) + "нс");
        }

        TreeSet<String> treeSetCarNumbers = new TreeSet<>(carNumbers);
        then = System.nanoTime();
        isFound = CoolNumbers.searchInTreeSet(treeSetCarNumbers, number);
        now = System.nanoTime();

        if(isFound){
            System.out.println("Поиск в TreeSet: номер найден, поиск занял " + (now - then) + "нс");
        } else {
            System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + (now - then) + "нс");
        }
    }
}
