import java.util.concurrent.Callable;

public class Loader
{
    public static void main(String[] args)
    {
        Cat sara = new Cat();
        Cat tom = new Cat();
        Cat sam = new Cat();
        Cat kate = new Cat();
        Cat fred = new Cat();
        Cat harry = new Cat();

        //System.out.println(cat.getStatus());
        System.out.println("Sara weight: " + sara.getWeight()
                + ",\nTom weight: " + tom.getWeight()
                + ",\nSam weight: " + sam.getWeight()
                + ",\nKate weight: " + kate.getWeight()
                + ",\nFred weight: " + fred.getWeight()
                + ",\nHarry weight: " + harry.getWeight());

        System.out.println("Total cats number is: " + Cat.getCount());
        sara.feed(150.00);
        sara.pee();
        sara.feed(100.00);
        sara.pee();
        System.out.println("Sara weight: " + sara.getWeight());
        System.out.println("Total feed amount for Sara: " + sara.getSumFeed());

        tom.feed(400.00);
        System.out.println("Tom weight: " + tom.getWeight());

        fred.feed(fred.getMaxWeight() - fred.getWeight() + 10);
        System.out.println("Fred is now: " + fred.getStatus());

        while(harry.getWeight() >= harry.getMinWeight()){
            harry.meow();
        }
        System.out.println("Harry is now: " + harry.getStatus());

        System.out.println("Total cats number is: " + Cat.getCount());

        Cat kitty = getKitten();
        Cat lizzy = getKitten();
        Cat johnny = getKitten();
        System.out.println("Total cats number is: " + Cat.getCount());
    }

    private static Cat getKitten(){
        return new Cat(1100.00);
    }
}