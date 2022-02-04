public class Main {
    private static String pathMovementsCsv = "src\\test\\resources\\movementList.csv";
    public static void main(String[] args) {

        Movements movements = new Movements(pathMovementsCsv);
        System.out.println("Сумма расходов:");
        System.out.println(movements.getExpenseSum());
        System.out.println("Сумма прихода:");
        System.out.println(movements.getIncomeSum());
        System.out.println("Суммы расходов по организациям:");
        movements.getExpensesDivided().entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " руб.");
        });
    }


}
