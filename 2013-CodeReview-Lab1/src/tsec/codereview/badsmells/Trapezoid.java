package tsec.codereview.badsmells;

public class Trapezoid
{
    private boolean isosceles = false;

    public int calculateArea(int top, int bottom, int height)
    {
        int area = 0;
        area = (top + bottom) * height / 2;
        return area;
    }

    public boolean isIsosceles()
    {
        return isosceles;
    }

    public void setIsosceles(boolean isosceles)
    {
        this.isosceles = isosceles;
    }
}
