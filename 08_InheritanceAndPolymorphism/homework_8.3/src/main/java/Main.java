public class Main {
    public static void main(String[] args) {
        Client physicalPerson = new PhysicalPerson();
        Client legalPerson = new LegalPerson();
        Client individualBusinessman = new IndividualBusinessman();

        physicalPerson.put(1000);
        System.out.println("Сумма на счету у физического лица " + physicalPerson.getAmount());
        physicalPerson.take(500);
        System.out.println("Сумма на счету у физического лица " + physicalPerson.getAmount());

        legalPerson.put(5000000);
        System.out.println("Сумма на счету у юридического лица " + legalPerson.getAmount());
        legalPerson.take(200000);
        System.out.println("Сумма на счету у юридического лица " + legalPerson.getAmount());

        individualBusinessman.put(100000);
        System.out.println("Сумма на счету у предпринимателя " + individualBusinessman.getAmount());
        individualBusinessman.put(500);
        System.out.println("Сумма на счету у предпринимателя " + individualBusinessman.getAmount());
        individualBusinessman.take(3000);
        System.out.println("Сумма на счету у предпринимателя " + individualBusinessman.getAmount());
    }
}
