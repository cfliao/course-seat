package tsec.codereview.badsmells;

import java.util.ArrayList;
import java.util.List;

public class BadSmell
{

    public static void main(String[] args)
    {
        //unresolvedWarning();
        //        leak();
        //        longMethod();
        //        featureEnvy();
        // casting();
        loopTerm();
        //        compareFloat();
        //        noDefaultSwitch();
        //        overflow();
        //		System.out.println(divide(3,7));
        //		System.out.println(add(32767,32768));
    }

    public static void unresolvedWarning()
    {
        int size = 3;
        String target = null;
        for (int i = 0; i < size; i++)
        {
            System.out.println("i=" + i);
        }
        System.out.println(target.toString());

    }

    public static void leak()
    {
        final int size = 1000000000;
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

    }

    public static void longMethod()
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

    public static void featureEnvy()
    {
        // this method is tightly coupled with the Grade class
        // we should more the sumGrade method to the Grade class

        Grade grade = new Grade();

        int[] grades = { grade.getGrade1(), grade.getGrade2(), grade.getGrade3() };

        int sum = sumGrade(grades);

        System.out.println(sum);

    }

    private static int sumGrade(int[] grades)
    {

        int result = 0;
        for (int g = 0; g < grades.length; g++)
        {
            result += grades[g];
        }
        return result;
    }

    public static void casting()
    {
        int x = 65535;
        System.out.println(x);
        short y;
        y = (short) x;
        System.out.println(y);

    }

    static int i = 10;

    public static void loopTerm()
    {
        while (i > 0)
        {
            i -= 1;
            someBadProc();
        }
        System.out.println("terminated.");

    }

    private static void someBadProc()
    {
        i += 1;
    }

    public static void compareFloat()
    {
        double x = 20.0;
        double y = 0.000000000000001;
        double z = x - y;
        if (z == 20D)
        {
            System.out.println("20-0.000000000000001 == 20");
        }

    }

    public static void overflow()
    {

        System.out.println(add(1, 1));
    }

    //public final double PI = 3.14;

    public static double noLiteralConstant(double radius)
    {
        // correct: return 2 * PI * radius;
        return 2 * 3.14 * radius;
    }

    public static void noDefaultSwitch()
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

    /**
     * Count the profile of a company based on tax rate
     * @param rate
     */
    public static void countProfit(int amount, double rate)
    {
        //do something 

    }

    public static int divide(int divisor, int dividend)
    {
        if (divisor == 0)
        {
            throw new IllegalArgumentException("divided by zero");
        }

        return dividend / divisor;
    }

    public static int add(int x, int y)
    {
        int value = 0;

        if (x > Short.MAX_VALUE || y > Short.MAX_VALUE)
        {
            throw new IllegalArgumentException("param too large!");
        }

        return x + y;

    }

    public static void tooManyIf(String x)
    {
        if (x.charAt(0) == 'A')
        {
            if (x.charAt(1) == 'B')
            {
                if (x.charAt(2) == 'C')
                {
                    System.out.println(x);
                } else if (x.charAt(2) == 'D')
                {
                    System.out.println(x);
                }
            }
        }

    }

}
