package seoo.lab4;

/** QuickSorter.java created on 2011/9/22
 * 
 * This file is a part of OOP Design Pattern Lab. materials.
 *
 * @author Pin-Ying Tu
 * @author Chun-Feng Liao revised in 2012.12.1
 * @version 2.0
 */
public class QuickSorter extends Sorter
{

    public QuickSorter()
    {
        super("QuickSort");
    }

    @Override
    public void sort(SortableIntArray values)
    {
        resetCounts();
        quicksort(0, values.getSize() - 1, values);
    }

    private void quicksort(int lower, int upper, SortableIntArray values)
    {
        if (upper > lower)
        {
            int pivot = split(lower, upper, values);
            quicksort(lower, pivot - 1, values);
            quicksort(pivot + 1, upper, values);
        }
    }

    private int split(int lower, int upper, SortableIntArray values)
    {
        // Take the middle element as the pivot
        int middle = (lower + upper) / 2;
        exchange(values, lower, middle);

        // Perform partition
        int p = lower + 1;
        int q = upper;
        while (q > p)
        {
            while (compare(values, lower, p))
            {
                p++;
            }
            while (compare(values, q, lower))
            {
                q--;
            }
            if (q > p)
            {
                exchange(values, p, q);
            }
        }
        exchange(values, lower, q);
        return q;
    }
}
