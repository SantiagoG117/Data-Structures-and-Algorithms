package Linear;

public class Array {
    //Attributes
    private int count;
    private int[] items;

    //Constructor
    public Array(int length) {
        items = new int[length];
    }
    
    //Public methods
    /**
    * @param item to insert
    * */
    public void insert(int item) {
        var arrayIsFull = items.length == count;

        if (arrayIsFull) {
            var newArray = new int[items.length + 1];
            System.arraycopy(items, 0, newArray, 0, items.length);
            newArray[newArray.length - 1] = item;
            items = newArray;
        }
        else
            items[count++] = item;
    }

    /**
     * @param index where we wish to insert the item
     * @param item we wish to insert
    * */
    public void insertAt(int index, int item) {
        //Index is a negative value
        if (index < 0)
            throw new IllegalArgumentException("Index is negative");

        //The user wishes to insert the item at the end of the array
        if (index >= count )
            insert(item);
        // Insert the item within the index
        else {
            //Iterate over the array starting from the end and shift the items to the right
            for (int i = items.length - 1; i > index; i--)
                items[i] = items[i - 1];

            //Insert the item at the desired index
            items[index] = item;
            count++;
        }
    }

    /**
     * @param index holding the value we wish to remove
     * Take an index and remove the value under that index
     * The array should automatically shrink with each new value that is being added
     *  */
    public void removeAt(int index) {
        var indexDoesNotExist = index > (count) || index < 0;
        var newArrayIndex = 0;

        if (indexDoesNotExist)
            throw new IllegalArgumentException("Index out of bounds");

        var newArray = new int[items.length - 1];
        
        //Move the values to the new array
        for (int i = 0; i < items.length; i++) {

            /*
            * If the current index is equal to the index passed as parameter,
            * continue to the next iteration and do not increase the value of
            * newArrayIndex by 1. This will prevent the algorithm from storing
            * the value we wish to remove.
            * */
            if(i == index)
                continue;

            newArray[newArrayIndex++] = items[i];
        }
        items = newArray;
        count--;
    }

    /**
     * @param value of the index we wish to return
     * @return the index holding the first appearance of the given value or -1 if the value does not exist
     * */
    public int indexOf(int value) {
       for (int i = 0; i < items.length; i++)
           if(items[i] == value)
               return i;

       return -1;
    }

    /**
    * prints the values stored in the array
    * */
    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    /**
     * @return the largest number in the items array
    * */
    public int max(){
        var max = 0;

        for (int item : items) {
            max = Math.max(max, item);
        }

        return max;
    }

    /**
     * @param other Array object
     * @return an array holding the common items between the items array and the arrayB
    * */
    public Array intersect(Array other) {
        var intersection = new Array(count);

        for (int item : items)
            //Verify if the other aray holds the current item and if the current item is already stored in the intersection array
            if (other.indexOf(item) >= 0 && intersection.indexOf(item) == -1)
                intersection.insert(item);

        return intersection;
    }


}
