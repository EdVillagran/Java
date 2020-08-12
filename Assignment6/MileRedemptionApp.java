

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/****************************************************************
 *                                                              *
 *  CSCI 470-1/502-1       Assignment 6        Summer 2020      *
 *                                                              *
 *  Class Name:  MileRedemptionApp                              *
 *  Programmer: Edgar Villagran Z1861047                        *
 *                                                              *
 *  Purpose: Houses main, only it launches the GUI.             *
 *                                                              *
 ****************************************************************/
public class MileRedemptionApp extends Application {

    /************************************************************
     *                                                          *
     *  Methods: start                                          *
     *                                                          *
     *  Purpose:  sets the stage to launch the GUI.             *
     *                                                          *
     ************************************************************/
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Load fxml into Parent
        Parent root = FXMLLoader.load(getClass().getResource("MileRedemptionGUI.fxml"));
        primaryStage.setTitle("Mileage Redemption App");

        //Window size
        primaryStage.setScene(new Scene(root, 645, 475));

        //Display
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
