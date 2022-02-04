package main.java;

import java.util.Scanner;

public class Main {
    static int numberOfContainers = 12;
    static int numberOfBoxes = 27;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        //System.out.println("Введите количество ящиков: ");
        String strBoxes = scanner.nextLine();
        int boxes = Integer.parseInt(strBoxes);
        int neededContainers = boxes / numberOfBoxes;
        if (boxes % numberOfBoxes != 0) neededContainers++;

        int neededTrucks = neededContainers / numberOfContainers;
        if (neededContainers % numberOfContainers != 0) neededTrucks++;

        int currentBox = 1;
        int currentContainer = 1;
        int currentTruck = 1;
        if(boxes != 0){
            System.out.println("Грузовик: " + currentTruck);
            System.out.println("\tКонтейнер: " + currentContainer);
            System.out.println("\t\tЯщик: " + currentBox);
            while(currentBox < boxes){
                currentBox++;
                System.out.println("\t\tЯщик: " + currentBox);
                if(currentContainer < neededContainers && currentBox % numberOfBoxes == 0){
                    if(neededContainers > numberOfContainers && currentContainer % numberOfContainers == 0){
                        currentTruck++;
                        System.out.println("Грузовик: " + currentTruck);
                    }
                    currentContainer++;
                    System.out.println("\tКонтейнер: " + currentContainer);
                }
            }
        }

        System.out.println("Необходимо:" + System.lineSeparator()
                + "грузовиков - " + neededTrucks + " шт." + System.lineSeparator()
                + "контейнеров - " + neededContainers + " шт.");
    }
}
