package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height){
        super(height,width,0,0);
    }
    public Vector2d getLowerLeft(){
        return lowerLeft;
    }
    public Vector2d getUpperRight(){
        return upperRight;
    }

}
