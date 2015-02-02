package tsec.codereview.badsmells;

public class UnsuitableNaming
{
    private boolean b = false;

    public int xyz(int x, int y, int z)
    {
        int r = 0;
        r = (x + y) * z / 2;
        return r;
    }

    public boolean isB()
    {
        return b;
    }

    public void setB(boolean b)
    {
        this.b = b;
    }

}
