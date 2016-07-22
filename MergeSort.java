
import java.util.ArrayList;

/**@Author Grant Tinkham
 *
 * This class implements the merge sort algorithm on generic comparable objects.
 */
public class MergeSort<T>
{
    /**
     * Utilizes recursion to sort through generic ArrayLists.  Driver method for the recursive step.
     *
     * @param list
     * 			-- ArrayList of generic objects.
     */
    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list)
    {
        if(list.size() <= 0 || list == null)
        {
            return;
        }
        ArrayList<T> tempL = new ArrayList();
        //placeholder array
        for(T t: list)
        {
            tempL.add(null);
        }
        int startLeft = 0;
        int startRight = list.size() - 1 ;


        split(list, startLeft, startRight, tempL);
    }

    /**
     * Recursively splits the list between the bounds start and end.
     *
     * @param list
     * 			-- Generic ArrayList to be sorted.
     * @param start
     * 			-- Desired position to begin splitting the list.
     * @param end
     * 			-- Desired end position of the split
     * @param tempL
     * 			-- Placeholder Arraylist to sort back into the original list.
     */
    private static <T extends Comparable<? super T>> void split(ArrayList<T> list, int start, int end, ArrayList<T> tempL)
    {
        int middle;
        if(start < end)
        {
            middle = start + (end - start) / 2;
            split(list, start, middle, tempL);
            split(list, middle + 1, end, tempL);

            merge(list, start, middle,   end, tempL);
        }
    }

    /**
     * This is the final step in the mergeSort.
     * One term at a time the list will be sorted.
     *
     * @param list
     * 			-- Generic ArrayList to be sorted.
     * @param lowerBound
     * 			-- Desired position to begin sorting the ArrayList.
     * @param middleBound
     * 			-- The mid point of the merge, used as a pointer.
     * @param upperBound
     * 			-- Desired endpoint to sort between.
     * @param tempL
     * 			-- Placeholder Arraylist to sort back into the original list.
     *
     */

    private static <T extends Comparable<? super T>>  void merge(ArrayList<T> list, int lowerBound, int middleBound, int upperBound, ArrayList<T> tempL)
    {
        int middle = middleBound;
        int compareValue;
        int i = lowerBound;
        int j = (middle +1);
        int counter = i;

        while( i <= middle && j <= upperBound)//should switch this to a while loop
        {
            compareValue = ((T) list.get(i)).compareTo((T) list.get(j));
            if(compareValue <= 0)
            {
                //Right is larger
                //left is placed
                tempL.set(counter , (list.get(i)));
                i++;
            }
            else
            {
                //left is larger
                //right is placed
                tempL.set(counter, (list.get(j)));
                j++;
            }
            counter++;
        }
        while (i <= middle)
        {
            tempL.set(counter, (list.get(i)));
            i++;
            counter++;
        }
        while(j<=upperBound)
        {
            tempL.set(counter, (list.get(j)));
            j++;
            counter++;
        }

        for(counter = lowerBound; counter <= upperBound; counter++)
        {
            list.set(counter, tempL.get(counter));
        }
    }
}
