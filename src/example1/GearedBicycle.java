package example1;

/**
 * @author Colin Chartier [t6charti]
 */
public class GearedBicycle extends Bicycle {
    //counter here shadows Bicycle.counter, any references to just 'counter'
    //in this class will point here instead of our parent's 'counter' variable.
    private int counter = 1; //goes up or down as we switch gears
    private int gears = 0;

    public GearedBicycle(int drag, int gears) {
        super(drag);
        this.gears = gears;
    }

    public void pumpPedals() {
        speed += counter; //we've pumped, bike is going faster
    }

    public void gearUp() {
        counter += 1;
        if(counter > gears) {
            counter = gears;
        }
    }

    public void gearDown() {
        counter -= 1;
        if(counter < 0) {
            counter = 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [gear " + counter + "]";
    }
}
