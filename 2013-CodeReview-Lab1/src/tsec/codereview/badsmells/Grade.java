package tsec.codereview.badsmells;

public class Grade
{

    private int grade1;

    private int grade2;

    private int grade3;

    public Grade()
    {
        grade1 = 100;
        grade2 = 90;
        grade3 = 80;
    }

    public int getGrade1()
    {
        return grade1;
    }

    public void setGrade1(int grade1)
    {
        this.grade1 = grade1;
    }

    public int getGrade2()
    {
        return grade2;
    }

    public void setGrade2(int grade2)
    {
        this.grade2 = grade2;
    }

    public int getGrade3()
    {
        return grade3;
    }

    public void setGrade3(int grade3)
    {
        this.grade3 = grade3;
    }

}
