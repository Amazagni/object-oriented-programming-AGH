package agh.ics.oop;
// AbstractWorldMapElement pozwala na implementację metod które wykorzystane są w animal i grass
public class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;
    public AbstractWorldMapElement(Vector2d position)
    {
        this.position = position;
    }
    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String getPath() {
        return null;
    }
}
