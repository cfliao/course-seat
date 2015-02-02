package seoo.lab4;

/** Sorter.java created on 2011/9/22
 * 
 * This file is a part of OOP Design Pattern Lab. materials.
 *
 * @author Pin-Ying Tu
 * @author Chun-Feng Liao revised in 2012.12.1
 * @version 2.0
 */
public abstract class Sorter
{

    protected String _name;

    private int _compareCount;

    private int _exchangeCount;

    protected Sorter(String name)
    {
        _name = name;
        resetCounts();
    }

    public String getName()
    {
        return _name;
    }

    public boolean compare(SortableIntArray values, int xIndex, int yIndex)
    {
        _compareCount++;
        return values.getItem(xIndex) > values.getItem(yIndex);
    }

    public void exchange(SortableIntArray values, int xIndex, int yIndex)
    {
        _exchangeCount++;
        int x = values.getItem(xIndex);
        values.setItem(xIndex, values.getItem(yIndex));
        values.setItem(yIndex, x);
    }

    public void resetCounts()
    {
        _compareCount = 0;
        _exchangeCount = 0;
    }

    public void report()
    {
        System.out.print(String.format("%1$10s%2$10s", _compareCount, _exchangeCount));
    }

    public abstract void sort(SortableIntArray values);
}
