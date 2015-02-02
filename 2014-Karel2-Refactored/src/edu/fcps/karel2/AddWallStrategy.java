package edu.fcps.karel2;

import edu.fcps.karel2.xml.Attributes;

public class AddWallStrategy implements AddObjectStrategy
{
    private WorldManager worldBackend;

    public void perform(Attributes a)
    {
        int x = Integer.parseInt(a.get("x"));
        int y = Integer.parseInt(a.get("y"));
        int length = Integer.parseInt(a.get("length"));
        int style = a.get("style").equalsIgnoreCase("horizontal") ? Display.HORIZONTAL : Display.VERTICAL;

        worldBackend.addWall(new Wall(x, y, length, style));
    }

    public AddWallStrategy(WorldManager worldBackend)
    {
        this.worldBackend = worldBackend;
    }

}
