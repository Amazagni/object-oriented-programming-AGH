package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {
    AbstractWorldMap map;
    @Override
    public void init() {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionsParser().parse(args);
            this.map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(3, 5), new Vector2d(4, 5) //, new Vector2d(3,3)
            };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map);

    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = createGridPane();
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private GridPane createGridPane(){
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        gridPane.getColumnConstraints().add(new ColumnConstraints(28));
        gridPane.getRowConstraints().add(new RowConstraints(28));

        Vector2d lowerLeft = this.map.getLowerLeft();
        Vector2d upperRight = this.map.getUpperRight();

        Label label = new Label("y\\x");
        gridPane.add(label, 0, 0, 1, 1);
        GridPane.setHalignment(label, HPos.CENTER);

        //BORDER
        for (int i = lowerLeft.x; i <= upperRight.x; i++){
            label = new Label(Integer.toString(i));
            gridPane.getColumnConstraints().add(new ColumnConstraints(28));
            gridPane.add(label, i + 1 - lowerLeft.x, 0, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (int i = upperRight.y; i >= lowerLeft.y; i--){
            label = new Label(Integer.toString(i));
            gridPane.getRowConstraints().add(new RowConstraints(28));
            gridPane.add(label, 0, -i + 1 + upperRight.y, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        //INSIDE
        for(int i = lowerLeft.x; i <= upperRight.x; i++){
            for(int j = upperRight.y; j >= lowerLeft.y; j--){
                Vector2d tmp = new Vector2d(i,j);
                if(this.map.objectAt(tmp) == null){
                    label = new Label();
                }
                else{
                    if(this.map.objectAt(tmp)instanceof Animal){

                    }
                    else{

                    }
                    label = new Label(map.objectAt(tmp).toString());
                }
                gridPane.add(label,i + 1 - lowerLeft.x, -j + 1 + upperRight.y, 1, 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }


        return gridPane;
    }
}
