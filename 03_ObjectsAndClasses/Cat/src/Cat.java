
public class Cat
{
    private double originWeight;
    private double weight;

    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    private double sumFeed;
    private int peeWeight;
    private static int count;
    private final int EYES_NUMBER = 2;
    private Color color;


    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        sumFeed = 0;
        peeWeight = 100;
        count++;
    }

    public Cat(double weight){
        this.weight = weight;
        originWeight = weight;
        sumFeed = 0;
        peeWeight = 100;
        count++;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void meow()
    {
        if(this.isAlive()) {
            weight = weight - 1;
            System.out.println("Meow");
            if(!this.isAlive()) {count--;}
        } else System.out.println("Cat is dead");
    }



    public void feed(Double amount)
    {
        if(this.isAlive()){
            weight = weight + amount;
            sumFeed += amount;
            if(!this.isAlive()) {count--;}
        } else System.out.println("Cat is dead");
    }

    public double getSumFeed(){
        return sumFeed;
    }

    public double getMinWeight(){
        return MIN_WEIGHT;
    }

    public double getMaxWeight(){
        return MAX_WEIGHT;
    }


    public void drink(Double amount)
    {
        if(this.isAlive()){
            weight = weight + amount;
            if(!this.isAlive()) {count--;}
        } else System.out.println("Cat is dead");
    }

    public void pee(){
        if(this.isAlive()){
            weight -= peeWeight;
            System.out.println("Human, clean it!");
            if(!this.isAlive()) {count--;}
        } else System.out.println("Cat is dead");
    }


    public Double getWeight()
    {
        return weight;
    }

    public  static int getCount(){
        return count;
    }

    public static Cat cloneCat(Cat cat){
        Cat cloneCat = new Cat(cat.getWeight());
        cloneCat.sumFeed = cat.sumFeed;
        cloneCat.color = cat.color;
        return cloneCat;
    }

    public boolean isAlive(){
        return !this.getStatus().equals("Dead") && !this.getStatus().equals("Exploded");
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}