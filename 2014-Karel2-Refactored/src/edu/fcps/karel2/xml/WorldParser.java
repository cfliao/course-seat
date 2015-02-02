package edu.fcps.karel2.xml;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import edu.fcps.karel2.AddBeeperStackStrategy;
import edu.fcps.karel2.AddRobotStrategy;
import edu.fcps.karel2.AddObjectStrategy;
import edu.fcps.karel2.AddWallStrategy;
import edu.fcps.karel2.WorldManager;
import edu.fcps.karel2.util.Debug;

/**
 * @author Andy Street, alstreet@vt.edu, 2007
 */

/*
 * Copyright (C) Andy Street 2007
 *
 * This software is licensed under the GNU Public License v3.
 * See attached file LICENSE.TXT or contact the author for more information.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of Version 3 of the GNU General Public License as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * This class is responsible for taking the XML DOM tree created by the parser and using reflections
 * to populate a WorldBackend representing the map.
 */

public class WorldParser
{

    private static Map<String, AddObjectStrategy> strategyTable = new HashMap<>();

    static
    {
        strategyTable.put("robot", new AddRobotStrategy());
        strategyTable.put("beeper", new AddBeeperStackStrategy(WorldManager.getCurrent()));
        strategyTable.put("wall", new AddWallStrategy(WorldManager.getCurrent()));
    }

    private static String propPrepend = "loadProperties_";

    /**
         * Takes in an Element representing the root of the XML DOM tree for a map, then uses
         * reflections to populate a WorldBackend.
         * @param root the root of the XML DOM tree for the map
         */

    public static void initiateMap(Element root)
    {
        WorldManager wb = WorldManager.getCurrent();

        Element properties = root.get("properties");
        Element objects = root.get("objects");

        if (properties != null)
            for (Element e : properties.getElements())
            {
                try
                {
                    Method m = Class.forName("edu.fcps.karel2.WorldBackend").getMethod(propPrepend + e.getName(),
                            new Class[] { Class.forName("edu.fcps.karel2.xml.Attributes") });
                    m.invoke(wb, new Object[] { e.getAttributes() });
                }
                catch (SecurityException e1)
                {
                    e1.printStackTrace();
                    throw e1;
                }
                catch (NoSuchMethodException e1)
                {
                    Debug.printWarning("Could not find method " + propPrepend + e.getName() + " for property " + e.getName() + "!  Ignoring...");
                }
                catch (ClassNotFoundException e1)
                {
                    e1.printStackTrace();
                    System.exit(2);
                }
                catch (IllegalArgumentException e1)
                {
                    e1.printStackTrace();
                    System.exit(3);
                }
                catch (IllegalAccessException e1)
                {
                    e1.printStackTrace();
                    System.exit(4);
                }
                catch (InvocationTargetException e1)
                {
                    e1.printStackTrace();
                    System.exit(5);
                }
            }

        if (objects != null)
            for (Element e : objects.getElements())
            {
                try
                {
                    AddObjectStrategy strategy = strategyTable.get(e.getName());
                    strategy.perform(e.getAttributes());
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

            }
    }

}
