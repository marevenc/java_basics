public class IndividualBusinessman extends PhysicalPerson {

    private final double LIMIT = 1000.0;
    private final double COMMISSION_OVER_LIMIT = 0.995;
    private final double COMMISSION_UNDER_LIMIT = 0.99;

    public void put(double amountToPut) {
        if(amountToPut - LIMIT < 0.0){
            super.put(amountToPut * COMMISSION_UNDER_LIMIT);
        } else {
            super.put(amountToPut * COMMISSION_OVER_LIMIT);
        }
    }
}
