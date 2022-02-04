import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        StringBuilder builder = new StringBuilder();
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        GregorianCalendar currentDate = (GregorianCalendar) GregorianCalendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEE", Locale.ENGLISH);

        for(int i = calendar.get(Calendar.YEAR); i < currentDate.get(Calendar.YEAR); i++){
            calendar.set(Calendar.YEAR, i);
            builder.append((i - year) + " - " + dateFormat.format(calendar.getTime()));
            builder.append(System.lineSeparator());

        }

        calendar.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));

        if(currentDate.compareTo(calendar) >= 0){
            builder.append((currentDate.get(Calendar.YEAR) - year) + " - " + dateFormat.format(calendar.getTime()));
        }
        return builder.toString();
    }
}
