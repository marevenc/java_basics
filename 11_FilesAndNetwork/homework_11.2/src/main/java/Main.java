import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sourceDirectory, destinationDirectory;
        long size = 0;
        for (;;){
            System.out.println("Введите путь откуда копировать:");
            sourceDirectory = scanner.nextLine();
            System.out.println("Введите путь куда копировать:");
            destinationDirectory = scanner.nextLine();
            FileUtils.copyFolder(sourceDirectory, destinationDirectory);
        }
    }
}
