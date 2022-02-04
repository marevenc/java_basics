import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path;
        long size = 0;
        for (;;){
            System.out.println("Введите путь до папки:");
            path = scanner.nextLine();
            try {
                size = FileUtils.calculateFolderSize(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Размер папки " + path + " cоставляет " + convertFolderSize(size));
        }
    }

    public static String convertFolderSize(long size){
        Double currentSize;
        DecimalFormat format = new DecimalFormat("0.00");
        StringBuilder convertedSize = new StringBuilder();
        if(size < 1000){
            convertedSize.append(size).append(" Б");
        } else if(size / 1000 < 1000){
            currentSize = size / 1000.;
            convertedSize.append(format.format(currentSize)).append(" Кб");
        } else if(size / 1_000_000 < 1000){
            currentSize = size / 1000000.;
            convertedSize.append(format.format(currentSize)).append(" Мб");
        } else if(size / 1_000_000_000 < 1000){
            currentSize = size / 1000000000.;
            convertedSize.append(format.format(currentSize)).append(" Гб");
        }
        return convertedSize.toString();
    }
}
