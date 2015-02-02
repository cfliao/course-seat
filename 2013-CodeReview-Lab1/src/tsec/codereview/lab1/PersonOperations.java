package tsec.codereview.lab1;

import java.util.ArrayList;
import java.util.List;

public class PersonOperations
{

    public static void main(String[] args)
    {
//        operation1();
//       operation2();
//        operation3();
//        operation4();
//        operation5();
//        operation6();
//        operation7();
//        System.out.println(operation8(0, 5));
    }

    // UnresolvedWarning
    @SuppressWarnings("UnresolvedWarning")
    public static void operation1()
    {
        int size = 3;
        String target = null;
        for (int i = 0; i < size; i++)
        {
            System.out.println("i=" + i);
        }
        System.out.println(target.toString());
    }

    // improper use of memory
    public static void operation2()
    {
        final int size = Integer.MAX_VALUE;
        int result = 0;
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++)
        {
            intArray[i] = i;
        }

        for (int i = 0; i < size; i++)
        {
            result += intArray[i];
        }
        System.out.println(result);
        // can detect max memory by Runtime.totalMemory();
    }

    public static void operation3()
    {
        Person person1 = new Person();
        person1.setName("tom");
        person1.setAge(20);
        person1.setTel("1234567");
        person1.setAddress("abcabcabc abcabcabc");
        Person person2 = new Person();
        person2.setName("mary");
        person2.setAge(30);
        person2.setTel("7654321");
        person2.setAddress("abcabcabc abcabcabc");
        List<Person> personList = new ArrayList<Person>();
        personList.add(person1);
        personList.add(person2);
        for (Person person : personList)
        {
            System.out.println(person.getName());
        }

    }

    public static void operation4()
    {
        int x = 65535;
        short y;
        y = (short) x;
        System.out.println(y);
    }

    public static void operation5()
    {
        int i = 10;
        while (i >0)
        {
            i -= 1;
            someBadProc(i);
        }
        System.out.println("terminated.");
    }

    private static void someBadProc(int i)
    {
        i += 1;
    }

    public static void operation6()
    {
        int weekday = 7;
        switch (weekday)
        {
        case 1:
            System.out.println("Mon");
            break;
        case 2:
            System.out.println("Tue");
            break;
        case 3:
            System.out.println("Wed");
            break;
        }
    }

    public static void operation7()
    {
        double x = 20.0;
        double y = 0.000000000000001;
        double z = x - y;
        if (z == 20D)
        {
            System.out.println("20-0.000000000000001 == 20");
        }
    }

    public static int operation8(int a, int b)
    {
        return a / b;
    }
}
