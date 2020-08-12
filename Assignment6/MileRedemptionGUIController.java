
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/****************************************************************
 *                                                              *
 *  CSCI 470-1/502-1       Assignment 6        Summer 2020      *
 *                                                              *
 *  Class Name:  MileRedemptionGUIController                    *
 *  Programmer: Edgar Villagran Z1861047                        *
 *                                                              *
 *  Purpose: The Controller to the fxml file. Uses the fx:id    *
 *      to manipulate various variables in the GUI. The fxml    *
 *      file was built using SceneBuilder.                      *
 *      The GUI works first by having the client type in file   *
 *      with info. Then they can view the city names and other  *
 *      info with it. The client types in miles they have and   *
 *      month travelling then submits to get travel options.    *
 *      If they have a new file they can hit 'reset' and re-type*
 *                                                              *
 ****************************************************************/

public class MileRedemptionGUIController {

    //Create instance to hold file information
    private MileRedeemer mr= new MileRedeemer();

    @FXML
    private TextField fileName; //holds file name client typed in
    @FXML
    private ListView<String>listCities; //cities to be listed
    @FXML
    private TextField normalMiles;  //normal miles for each city
    @FXML
    private TextField superSaverMiles;//super saver miles for each city
    @FXML
    private TextField upgradeCost; // upgrade cost for each city
    @FXML
    private TextField superSaverDates; // available months
    @FXML
    private TextField clientMiles;//How many miles client has
    @FXML
    private ChoiceBox clientMonth;// Month client chooses to travel
    @FXML
    private TextField remainingMiles; //clients remaining miles after travelling
    @FXML
    private TextFlow outputText;  // programs result output

    /************************************************************
     *                                                          *
     *  Methods: calculatedOutput                               *
     *                                                          *
     *  Purpose: Provide desired program output. Gives an       *
     *    optimal listing of what to do with client miles.      *
     *                                                          *
     ************************************************************/
    @FXML
    public void calculatedOutput(ActionEvent event){

        //Create a list of months from choice box
        ObservableList<String> months=clientMonth.getItems();

        //Use to store month as number since redeemMiles function takes month as number  not string
        int countMonth=0;

        //Go through each until month clicked found
        for (String x: months){

            //raise counter every time since months in order
            countMonth++;

            //If selected month matched
            if(x==clientMonth.getValue()) {

                //Call redeemMiles to get best use of miles
                String[] rMiles = mr.redeemMiles(Integer.parseInt(clientMiles.getText()), countMonth);

                //If at least 1 destination then display
                if (rMiles.length > 0) {

                    //Text FLow class can only store text objects so each string will be set up as so
                    Text text1=new Text("\nYour client's Frequent Flyer Miles can be used to redeem the following tickets:\n");

                    //Will hold output of rmiles as string
                    String temp="";

                    for (String y : rMiles)
                        temp+=y+"\n";

                    //Add temp into a Text object
                    Text text3=new Text(temp);

                    //Add all text objects into output text
                    outputText.getChildren().addAll(text1,text3);

                    //add remaining miles into remainingMiles variable
                    remainingMiles.setText(""+mr.getRemainingMiles());

                }
                //Else nothing available to display
                else {
                    Text text5=new Text("\n*** Your client has not accumulated enough Frequent Flyer Miles ***");
                    outputText.getChildren().add(text5);
                }
            }
        }
    }

    /************************************************************
     *                                                          *
     *  Methods: openFile                                       *
     *                                                          *
     *  Purpose: Uses the typed in file name to open file and   *
     *     store it into the MileRedemption Instance            *
     *                                                          *
     ************************************************************/
    @FXML
    public void openFile(ActionEvent event) throws IOException {

        //Get typed in file name
        String file = fileName.getText();

        //create Scanner object for file
        Scanner filesc = new Scanner(new File(file));

        //Call readDestinations pass in file scanner object
        mr.readDestinations(filesc);

        //Call and store cityNames to be listed in GUI
        String[] cityNames = mr.getCityNames();
        listCities.getItems().addAll(cityNames);

    }

    /************************************************************
     *                                                          *
     *  Methods: resetALL                                       *
     *                                                          *
     *  Purpose: Used if the client has another file to use.    *
     *      It will wipe all data displayed and used by the GUI *
     *      called when reset button clicked.                   *
     *                                                          *
     ************************************************************/
    @FXML
    public void resetAll(ActionEvent event){

        //Create new empty MileRedeemer instance and equal to class instance variable
        MileRedeemer mr2= new MileRedeemer();
        mr=mr2;

        //Remove cities listed from GUI list
        listCities.getItems().clear();

        //Remove Stats posted
        normalMiles.setText("");
        superSaverMiles.setText("");
        upgradeCost.setText("");
        superSaverDates.setText("");
        outputText.getChildren().clear();
        remainingMiles.setText("");
        clientMiles.setText("");

    }

    /************************************************************
     *                                                          *
     *  Methods: coutputcity                                    *
     *                                                          *
     *  Purpose: Used when city listed is clicked. It will      *
     *   display all the info for each city.                    *
     *                                                          *
     ************************************************************/
    @FXML
    public void outputcity(MouseEvent event){

        //Matching the picked city to the Destination Array Holding it
        for (Destination x: mr.getDestinationArray()){
            if (listCities.getSelectionModel().getSelectedItem()==x.getDestinationCity())
            {
                //Easiest way to convert ints to text in order to store into TextField objects
                //Updates each of the variables displaying info in the GUI to the info for each city
                normalMiles.setText(""+x.getNormalMiles());
                superSaverMiles.setText(""+x.getOffSeasonMiles());
                upgradeCost.setText(""+x.getAddMilesforUp());
                superSaverDates.setText("Months: "+x.getStarMonthFF()+" - "+x.getEndMonthFF());
            }
        }
    }

}