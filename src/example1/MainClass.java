package example1;

/**
 * @author Colin Chartier [t6charti]
 */
public class MainClass {
    public static void main(String[] args) {
        //[type] [variable name] [= blah]
        Bicycle simpleBike = new Bicycle(2); //(*)
        Bicycle fancyBike = new GearedBicycle(2, 8); //(**)
        System.out.println(simpleBike);
        System.out.println(fancyBike);

        //At this point, we would lose the bike race
        //as we are in first gear, and the ungeared bike can beat us.

        //we know that we have a gearUp() method, but if we were to do this:
        //fancyBike.gearUp();
        //the compiler would get mad at us, as it would go:
        //hey, Colin is trying to call the gearUp method on an object.
        //I know the type of that object! Its type is defined by (*) as
        //Bicycle!
        //Uh oh, Bicycle doesn't have a gearUp method.  This is bad.

        //we can explicitly tell the complier that we *know* it's a geared bike
        //and it will say "if you say so...":
        ((GearedBicycle)fancyBike).gearUp();
        ((GearedBicycle)fancyBike).gearUp();
        ((GearedBicycle)fancyBike).gearUp();
        ((GearedBicycle)fancyBike).gearUp();
        ((GearedBicycle)fancyBike).gearUp();

        System.out.println(fancyBike.counter);
        System.out.println(simpleBike.counter);

        //Now we're in gear 6 [1+5], and we should be able to win the bike race.
        //let's see how we fare:
        simpleBike.pumpPedals();

        //IMPORTANT BIT: Dynamic Binding
        //The compiler here sees that the Bicycle class has a pumpPedals method
        //so it allows this at compile time.
        //At run time, because pumpPedals is not static, the compiler will go
        //up the chain: GearedBicycle -> Bicycle -> Object
        //and say: "Hey, have a '[unknown return type] pumpPedals()' method?
        //the first one checked, GearedBicycle, would say:
        //Yeah! I have a void pumpPedals()! Pick me!
        fancyBike.pumpPedals();
        //notice that as FancyBike is a Bike, we can reuse
        //its coast method
        simpleBike.coast();

        //This is also dynamic binding:
        //GearedBicycle -> Bicycle -> Object
        //GearedBicycle says "I don't have a coast method."
        //Bicycle says "I have a void coast()! Pick me!"
        //it should be clear that if GearedBicycle defined a method with the
        //signature void coast(int something)
        //it wouldn't be chosen, because you aren't providing an integer here
        //and java realizes that it would be silly to crash your app when there
        //is a perfectly valid method in Bicycle
        fancyBike.coast();
        System.out.println("Their distance: " + simpleBike.getDistance());
        System.out.println("Our distance: " + fancyBike.getDistance());
        //Yeah! We won the race!
        move(fancyBike);
        move(simpleBike);
        fancyBike.toString();
    }

    public static void move(Bicycle bicycle) {
        //at this point, fancyBike is still a
        //GearedBicycle
        bicycle.pumpPedals();
    }
}
