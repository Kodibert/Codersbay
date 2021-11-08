import org.junit.jupiter.api.*;


import java.util.ArrayList;

public class GenericQueueTestMethods {
    GenericQueueMethods genericQueueMethods;
    ArrayList<Integer> test;
    int a, b, c;

    //Constructor
    @BeforeEach
    public void testSetup() {
        genericQueueMethods = new GenericQueueMethods();
        test = new ArrayList<>();
        a = 1;
        b = 2;
        c = 3;

    }

    @Nested
    @DisplayName("New empty Queue")
    class EmptyQueue {

        @Test
        @DisplayName("New Queue is Empty")
        void testQueueIsEmptyMethod() {
            genericQueueMethods.setQueue(null);
            System.out.println(genericQueueMethods.getQueue());

        }

        @Test
        @DisplayName("Exception if empty")
        void exceptionIfEmpty() throws QueueToSmallException {

        }
    }

        @Nested
        @DisplayName("Tests queue operations")
        class QueueOperations {

        }

        @Test
        @DisplayName("Size of queue")
        void whatIsTheSizeOfTheActualQueue() {
            genericQueueMethods.getQueue().add(a);
            genericQueueMethods.getQueue().add(b);
            Assertions.assertEquals(2, genericQueueMethods.getQueue().size());
        }

        //noch offen
        @Test
        @DisplayName("New element stored on last Position")
        void newElementGetInsertOnTail() {
            genericQueueMethods.enqueue(a);
            genericQueueMethods.enqueue(b);
            genericQueueMethods.enqueue(c);
            test.add(0, c);
            test.add(1, b);
            test.add(2, a);
            Assertions.assertTrue(test.equals(genericQueueMethods.getQueue()));
            System.out.println(test);
            System.out.println(genericQueueMethods.getQueue());
        }


    }








