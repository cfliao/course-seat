package seoo.lab4;

/** IntArray.java created on 2011/9/22
 * 
 * This file is a part of OOP Design Pattern Lab. materials.
 *
 * @author Pin-Ying Tu
 * @author Chun-Feng Liao revised in 2012.12.1
 * @version 2.0
 */
public class SortableIntArray
{

    private int size;

    private int[] items;

    private Sorter sorter;

    public SortableIntArray()
    {
        size = 0;
    }

    public void initialize(int size)
    {
        this.size = size;
        items = new int[size];
        for (int i = 0; i < size; ++i)
        {
            items[i] = size - i;
        }
    }

    public void printItems()
    {
        System.out.print("(" + size + ") : (");
        int i = 0;
        for (; i < size - 1; ++i)
        {
            System.out.print(items[i] + ", ");
        }
        System.out.println(items[i] + ")");
    }

    public int getSize()
    {
        return size;
    }

    public void cleanUp()
    {
        // In Java, there is no delete operator. Set the reference
        // to null to decrease the reference counting.
        items = null;
    }

    public int getItem(int index)
    {
        return items[index];
    }

    public void setItem(int index, int value)
    {
        if (index < items.length)
        {
            items[index] = value;
        }
    }

    public void sort()
    {
        sorter.sort(this);
    }

    public void setSorter(Sorter sorter)
    {
        this.sorter = sorter;
    }

    public boolean isInIncreasingOrder()
    {
        for (int i = 0; i < size - 1; ++i)
        {
            if (items[i] > items[i + 1])
            {
                return false;
            }
        }
        return true;
    }
}
