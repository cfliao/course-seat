package seoo.lab4;

/** created on 2011/9/22
 * 
 * This file is a part of OOP Design Pattern Lab. materials.
 *
 * @author Pin-Ying Tu
 * @author Chun-Feng Liao revised in 2012.12.1
 * @version 2.0
 */
public class Main
{

    public static void main(String[] args)
    {
        SelectionSorter selectionSorter = new SelectionSorter();
        QuickSorter quickSorter = new QuickSorter();
        BubbleSorter bubbleSorter = new BubbleSorter();
        
        // Check the correctness
        SortableIntArray values = new SortableIntArray();
        sort(values, bubbleSorter);
        sort(values, selectionSorter);
        sort(values, quickSorter);
    }

    private static void sort(SortableIntArray values, Sorter sorter)
    {
        values.initialize(10);
        values.printItems();
        values.setSorter(sorter);
        values.sort();
        values.printItems();
        System.out.println("The " + sorter.getName() + " is " + (values.isInIncreasingOrder() ? "correct." : "incorrect."));
        values.cleanUp();
    }
}
