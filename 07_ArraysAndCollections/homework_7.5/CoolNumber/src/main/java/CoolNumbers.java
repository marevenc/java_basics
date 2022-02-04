import java.util.*;

public class CoolNumbers {

    private static final char[] ALLOWED_LETTERS = new char[] {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private static final int MAX_ALLOWED_REGION = 199;
    private static final int MIN_ALLOWED_REGION = 1;
    private static final int MAX_ALLOWED_NUMBER = 9;
    private static final int MIN_ALLOWED_NUMBER = 0;

    public static List<String> generateCoolNumbers() {
        List<String> generatedNumbers = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i <= 2_000_000; i++){
            builder.setLength(0);
            builder.append(ALLOWED_LETTERS[random.nextInt(ALLOWED_LETTERS.length)]);
            builder.append(random.nextInt(MAX_ALLOWED_NUMBER + 1 - MIN_ALLOWED_NUMBER) + MIN_ALLOWED_NUMBER);
            builder.append(random.nextInt(MAX_ALLOWED_NUMBER + 1 - MIN_ALLOWED_NUMBER) + MIN_ALLOWED_NUMBER);
            builder.append(random.nextInt(MAX_ALLOWED_NUMBER + 1 - MIN_ALLOWED_NUMBER) + MIN_ALLOWED_NUMBER);
            builder.append(ALLOWED_LETTERS[random.nextInt(ALLOWED_LETTERS.length)]);
            builder.append(ALLOWED_LETTERS[random.nextInt(ALLOWED_LETTERS.length)]);
            int region = random.nextInt(MAX_ALLOWED_REGION + 1 - MIN_ALLOWED_REGION) + MIN_ALLOWED_REGION;
            if(region % 100 != 0){
                builder.append(region);
            } else if(region % 10 != 0){
                builder.append(0).append(region);
            } else{
                builder.append("00").append(region);
            }
            generatedNumbers.add(builder.toString());
        }
        return generatedNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for(String carNumber : list){
            if(carNumber.equals(number)){
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int high = sortedList.size() - 1;
        int low = 0;
        int mid = (high + low) / 2;

        while (low <= high){
            if(sortedList.get(mid).compareTo(number) < 0){
                low = mid + 1;
            } else if(sortedList.get(mid).compareTo(number) == 0){
                return true;
            } else{
                high = mid - 1;
            }
            mid = (high + low) / 2;
        }
        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
