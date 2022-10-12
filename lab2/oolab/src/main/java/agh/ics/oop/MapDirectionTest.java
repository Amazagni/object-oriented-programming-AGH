package agh.ics.oop;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MapDirectionTest {

    @Test
    public void nextTest(){
        MapDirection n = MapDirection.NORTH;
        MapDirection s = MapDirection.SOUTH;
        MapDirection e = MapDirection.EAST;
        MapDirection w = MapDirection.WEST;
        assertEquals(n.next(),e);
        assertEquals(e.next(),s);
        assertEquals(s.next(),w);
        assertEquals(w.next(),n);
    }
    @Test
    public void previousTest(){
        MapDirection n = MapDirection.NORTH;
        MapDirection s = MapDirection.SOUTH;
        MapDirection e = MapDirection.EAST;
        MapDirection w = MapDirection.WEST;
        assertEquals(n.previous(),w);
        assertEquals(e.previous(),n);
        assertEquals(s.previous(),e);
        assertEquals(w.previous(),s);
    }
}
