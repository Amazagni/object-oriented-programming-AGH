package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.List;

public class App extends Application implements IAppObserver{
    private AbstractWorldMap map;
    private GridPane gridPane = new GridPane();
    private int moveDelay = 600;
    private SimulationEngine engine;
    @Override
    public void init() {
            //String[] args = getParameters().getRaw().toArray(new String[0]);
            //MoveDirection[] directions = new OptionsParser().parse(args);
            this.map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(3, 5), new Vector2d(4, 5) //, new Vector2d(3,3)
            };
            this.engine = new SimulationEngine(map, positions);
            this.engine.setDelay(this.moveDelay);
            this.engine.addObserver(this);

            //engine.run();
            //System.out.println(map);

    }

    @Override
    public void start(Stage primaryStage) {

        TextField moves = new TextField();
        Button start = new Button("Start");
        VBox top = new VBox(moves,start);
        VBox screen = new VBox(top,this.gridPane);
        HBox body = new HBox(screen);




        start.setOnAction(click ->{
            String[] args = moves.getText().split(" ");
            MoveDirection[] directions = new OptionsParser().parse(args);
            this.engine.setDirections(directions);
            Thread engineThread = new Thread(engine);
            engineThread.start();

        });

        createGridPane();
        Scene scene = new Scene(body, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private void createGridPane()  {

        //lines won't be visible on whole map
        this.gridPane.setGridLinesVisible(false);
        this.gridPane.getColumnConstraints().clear();
        this.gridPane.getRowConstraints().clear();


        this.gridPane.setGridLinesVisible(true);
        this.gridPane.getColumnConstraints().add(new ColumnConstraints(40));
        this.gridPane.getRowConstraints().add(new RowConstraints(40));

        Vector2d lowerLeft = this.map.getLowerLeft();
        Vector2d upperRight = this.map.getUpperRight();

        Label label = new Label("y\\x");
        this.gridPane.add(label, 0, 0, 1, 1);
        GridPane.setHalignment(label, HPos.CENTER);

        //BORDER
        for (int i = lowerLeft.x; i <= upperRight.x; i++){
            label = new Label(Integer.toString(i));
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(40));
            this.gridPane.add(label, i + 1 - lowerLeft.x, 0, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (int i = upperRight.y; i >= lowerLeft.y; i--){
            label = new Label(Integer.toString(i));
            this.gridPane.getRowConstraints().add(new RowConstraints(40));
            this.gridPane.add(label, 0, -i + 1 + upperRight.y, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        //INSIDE
        for(int i = lowerLeft.x; i <= upperRight.x; i++){
            for(int j = upperRight.y; j >= lowerLeft.y; j--){
                Vector2d tmp = new Vector2d(i,j);
                if(this.map.objectAt(tmp) == null){
                    label = new Label();
                    this.gridPane.add(label,i + 1 - lowerLeft.x, -j + 1 + upperRight.y, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
                else{
                    GuiElementBox elementBox = new GuiElementBox((IMapElement) this.map.objectAt(tmp));
                    this.gridPane.add(elementBox.getVbox(),i + 1 - lowerLeft.x, -j + 1 + upperRight.y, 1, 1);
                }

            }
        }

    }

    @Override
    public void positionChanged() {
        Platform.runLater(()->{
            this.gridPane.getChildren().clear();
            createGridPane();

        });
    }
}
