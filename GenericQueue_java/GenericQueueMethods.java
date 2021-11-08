/**
 * Implementiere einen IntQueue! Eine Queue ist eine Schlange, wie eine Warteschlange,
 * in der immer Elemente in der Reihenfolge abgearbeitet werden wie sie aufgenommen werden - dem First in first out Prinzip.
 * Die Klasse Queue sollte folgende Methoden haben:
 *
 * @@void enqueue(int newElement):
 * fügt ein neues Element hinten in die Schlange ein
 * @@int size()
 * gibt die Anzahl der Elemente in der Queue zurück
 * @@int dequeue()
 * gibt das erste Elemente der Schlange zurück und entfernt dieses daraus
 * @@int[] dequeue(int n)
 * gibt die ersten n Elemente der Schlange zurück und entfernt diese daraus
 * Wird auf eine leere Queue dequeue() aufgerufen sollte eine QueueTooSmallException geworfen werden.
 * <p>
 * Leg in der Main Methode eine Queue an und schreib ein paar Beispiel-Verwendungen.
 */

import java.util.*;

public class GenericQueueMethods<T> {

    private ArrayList<T> queue;

    public GenericQueueMethods() {

        this.queue = new ArrayList<T>();

    }

    public ArrayList<T> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<T> queue) {
        this.queue = queue;
    }

    // Method isEmpty
    boolean isEmpty() {
        return (this.queue.size() == 0);
    }

    // Method enqueue
    public void enqueue(T value) {
        this.queue.add(0, value);
    }

    T dequeue() throws QueueToSmallException {
        if (this.isEmpty()) {
            throw new QueueToSmallException();
        }
        T temp = getQueue().get(queue.size() - 1);
        getQueue().remove(temp);
        return temp;
    }


    T dequeueNt(int n) throws QueueToSmallException {
        if (this.isEmpty()) {
            throw new QueueToSmallException();
        }
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(dequeue());
            return result.get(i);
        }
    return null;}
}




