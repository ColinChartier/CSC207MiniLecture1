package example2;

/**
 * @author Colin Chartier [t6charti]
 */
public class Parent extends SuperParent {
    public void voidMethod(Object object) {
        Thread.dumpStack();
    }

    public static void staticVoidMethod() {
        Thread.dumpStack();
    }
}
