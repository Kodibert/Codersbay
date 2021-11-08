public class QueueToSmallException extends Exception {

    public QueueToSmallException() {
        System.out.println("Queue is empty");
    }
}
