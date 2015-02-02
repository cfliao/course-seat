package edu.fcps.karel2;

import edu.fcps.karel2.xml.Attributes;

public class AddBeeperStackStrategy implements AddObjectStrategy
{
    private WorldManager worldBackend;

    public void perform(Attributes a)
    {
        int x = Integer.parseInt(a.get("x"));
        int y = Integer.parseInt(a.get("y"));
        String num = a.get("num");

        if (num.equalsIgnoreCase("infinite"))
            worldBackend.putBeepers(x, y, Display.INFINITY);
        else
            worldBackend.putBeepers(x, y, Integer.parseInt(num));
    }

    public AddBeeperStackStrategy(WorldManager worldBackend)
    {
        this.worldBackend = worldBackend;
    }

}
