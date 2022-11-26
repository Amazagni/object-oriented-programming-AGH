package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    TreeMap<Vector2d, AbstractWorldMapElement> xElements = new TreeMap<>(new MapBoundaryComparator(true));
    TreeMap<Vector2d, AbstractWorldMapElement> yElements = new TreeMap<>(new MapBoundaryComparator(false));



    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

        AbstractWorldMapElement e = xElements.get(oldPosition);
        xElements.put(newPosition,e);
        yElements.put(newPosition,e);
        xElements.remove(oldPosition);
        xElements.remove(oldPosition);

    }
    public void addElement(AbstractWorldMapElement e){
        xElements.put(e.getPosition(),e);
        yElements.put(e.getPosition(),e);
    }
    public Vector2d getLowerLeft(){
        return new Vector2d(xElements.firstKey().x, yElements.firstKey().y);
    }
    public Vector2d getUpperRight(){
        return new Vector2d(xElements.lastKey().x, yElements.lastKey().y);
    }
}
