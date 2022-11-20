package agh.ics.oop;

import java.util.Comparator;

public class MapBoundaryComparator implements Comparator<Vector2d> {
    private boolean flag;
    public MapBoundaryComparator(boolean flag){
        this.flag = flag;
    }

    @Override
    public int compare(Vector2d vector1, Vector2d vector2) {
        if(this.flag){ //x sorting
            if(vector1.x < vector2.x)return -1;
            else if (vector1.x > vector2.x)return 1;
            else{
                if(vector1.y < vector2.y)return -1;
                else{
                    return 1;
                }
            }

        }
        else{ //y sorting
            if(vector1.y < vector2.y)return -1;
            else if (vector1.y > vector2.y)return 1;
            else{
                if(vector1.x < vector2.x)return -1;
                else{
                    return 1;
                }
            }

        }
    }
}
