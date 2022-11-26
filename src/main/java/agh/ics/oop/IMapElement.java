package agh.ics.oop;
// dodanie interfejsu IMapElement ma sens ponieważ grass i animal korzystają z tej samej metody choć nie sądzę aby było to konieczne
public interface IMapElement {
    Vector2d getPosition();
    String getPath();
}
