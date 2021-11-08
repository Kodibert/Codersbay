import java.util.*;

public class QueueMainMethod {
    public static void main(String[] args) throws QueueToSmallException {
        GenericQueueMethods<String> genericQueueMethods = new GenericQueueMethods<>();
        String string = "Hallo";
        String string_1 = "Welt";
        String string_2 = "Untergang";
        genericQueueMethods.enqueue(string);
        genericQueueMethods.enqueue(string_1);
        genericQueueMethods.enqueue(string_2);
        System.out.println(genericQueueMethods.getQueue().size());
        System.out.println(genericQueueMethods.getQueue());


        System.out.println(genericQueueMethods.getQueue());
        System.out.println(genericQueueMethods.getQueue().size());
        GenericQueueMethods<Integer> newGen = new GenericQueueMethods<>();
        int a, b, c;
        a = 10;
        b = 20;
        c = 30;
        newGen.enqueue(a);
        newGen.enqueue(b);
        newGen.enqueue(c);
        System.out.println(newGen.getQueue());
        System.out.println(newGen.getQueue().size());
        System.out.println(newGen.dequeueNt(2));

    }

}
