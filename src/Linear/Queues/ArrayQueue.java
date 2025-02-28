package Linear.Queues;

/**
 * This class aims to simulate the behavior of an ArrayDeque using a basic Array
 * */
public class ArrayQueue {

    int[] array;
    int front = 0;
    int back = 0;
    int count = 0;

    public ArrayQueue(int capacity) {
        array = new int[capacity];
    }

    public void enqueue(int item) {
        if(isFull())
            throw new ArrayIndexOutOfBoundsException("The queue is full");

        array[back] = item;
        back = moveCircular(back);

        count++;
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        var result = array[front];
        array[front] = 0;


        front = moveCircular(front);

        count--;
        return result;
    }


    public boolean isFull(){
        return array.length == count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int peek(){
        return array[front];
    }


    /**
     * Circular Array:
     *   When reaching the final index of the array, instead of extending an array by allocating more space in memory and
     *   mapping the items of the old array into a new one we can use a circular array. Pointers allows us to do this.
     *   Technically all the items in the array are stored sequentially but the pointers allows us to create a circular
     *   behavior.
     *
     *   To implement a circular array we can follow this formula:
     *       (pointer + 1) % array.length
     *   ! We use the modulus operator to return the remainder of the division.
     * */
    private int moveCircular(int pointer) {
        return (pointer + 1) % array.length;
    }
}
