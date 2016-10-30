package example2;

/**
 * @author Colin Chartier [t6charti]
 */
public class SuperParent implements SuperParentInterface {
    public int instanceVariable;
    public static int staticInstanceVariable;

    public void voidMethod() {
        Thread.dumpStack();
    }

    public void voidMethod(int someArgument) {
        Thread.dumpStack();
    }

    public static void staticVoidMethod() {
        Thread.dumpStack();
    }
}
