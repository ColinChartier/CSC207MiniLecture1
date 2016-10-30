package example1;

/**
 * @author Colin Chartier [t6charti]
 */
public class Bicycle {
    /** In Bicycle, we define 'counter' to be the number of Bicycles that exist.*/
    public int counter = 0;

    /** Drag is how much we slow down between pedal pumps.*/
    protected final int drag;
    protected int speed = 0;
    /** We define distance to be how far we've gone in our bicycle race.*/
    private int distance = 0;

    public Bicycle(int drag) {
        //We haven't 'qualified' this variable, which means that
        //Java will first look for a local variable or parameter called counter
        //[which doesn't exist here]
        //and then either instance or static variables called 'bicycle'
        //[oh look! a 'public static int counter!']
        counter++;

        //We qualify 'this.drag' as being an instance variable, which means that
        //Java will look in the class of the object defined as "this",
        //and then all of its parent classes for an instance variable
        //called 'drag' without looking for a local variable or parameter first.

        //We don't qualify 'drag', so java immediately finds a local variable or parameter,
        //specifically the one in Bicycle(int drag),
        //and sets this.drag to be that value.
        this.drag = drag;
    }

    public void pumpPedals() {
        speed += 5; //we've pumped, bike is going faster
    }

    public void coast() {
        speed = speed - drag; //we slow down because of friction
        if(speed < 0) {
            speed = 0; //we can't go backwards on our bike
        }
        distance += speed;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Bicycle [speed=" + speed + ", drag=" + drag + ", distance=" + distance + ". There are " + counter + " bikes in total.]";
    }
}
