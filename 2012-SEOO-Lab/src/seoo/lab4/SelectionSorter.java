package seoo.lab4;

/** SelectionSorter.java created on 2011/9/22
 * 
 * This file is a part of OOP Design Pattern Lab. materials.
 *
 * @author Pin-Ying Tu
 * @author Chun-Feng Liao revised in 2012.12.1
 * @version 2.0
 */
public class SelectionSorter extends Sorter
{

    public SelectionSorter()
    {
        super("SelectionSort");
    }

    @Override
    public void sort(SortableIntArray values)
    {
        resetCounts();
        int size = values.getSize();
        for (int i = 0; i < size - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < size; j++)
            {
                if (compare(values, minIndex, j))
                {
                    minIndex = j;
                }
            }
            exchange(values, i, minIndex);
        }
    }
}
