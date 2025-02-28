package Linear.Queues;

public class PriorityQueue {

    private int[] items;
    private int count = 0;
    private int back;
    private int front;


    public PriorityQueue(int capacity) {
        items = new int[capacity];
        back = -1;
        front = 0;
    }

    /*
    *   enqueue should insert items in ascending order
    *       To find the right position and shifting items forward:
    *           1. Iterate the array from the back
    *           2. Verify if the current item is greater than the item we wish to insert
    *               If it is copy the item to its right index
    *               Move to the next item
    *           4. If the current item is not greater than the item we wish to insert, add the new item to the right
    *               index of the current item.
    * */

    public void enqueue(int item){

        if (isFull())
            throw new IllegalStateException("Queue is full");


        if(isEmpty()){
            items[count++] = item;
            return;
        }

        if(items[back] <= item)
            items[moveCircular(back)] = item;

        else {
            //? Iterate the array from the back pointer
            for(var i = back; i >= 0; i--) {
                if (items[i] > item) {
                    //?Shift the current item to the right
                    items[i + 1] = items[i];
                    //?Insert the current item
                    items[i] = item;
                }
            }
        }

        back = moveCircular(back);
        count++;
    }

    public void add(int item){
        if (isFull())
            throw new IllegalStateException("Queue is full");

        var rightPosition = shiftItemsToInsert(item);

        items[rightPosition] = item;

        back = moveCircular(back);
        count++;
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        var result = items[front];

        front = moveCircular(front);
        count--;

        return result;
    }

    public boolean isFull(){
        return items.length == count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int shiftItemsToInsert(int item){
        int index;

        for(index = back; index >=0; index--){
            if(items[index] > item)
                items[moveCircular(index)] = items[index];
            else
                break;
        }

        return moveCircular(index);
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
    private int moveCircular(int pointer){
        return (pointer + 1) % items.length;
    }


}
