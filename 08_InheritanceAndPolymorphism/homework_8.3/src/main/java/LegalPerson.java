public class LegalPerson extends PhysicalPerson {

    private final double COMMISSION = 1.01;

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake * COMMISSION);
    }
}
