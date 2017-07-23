/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leftslidemenusample;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


/**
 *
 * @author felipe
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button menu;
    @FXML
    private AnchorPane navList;
    @FXML
    private Accordion accordion;
    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private TitledPane t1;
    @FXML
    private TitledPane t2;
    @FXML
    private TitledPane t3;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        navList.setItems(FXCollections.observableArrayList("Red","Yellow","Blue"));
        prepareSlideMenuAnimation();
    }



    private void prepareSlideMenuAnimation() {
        TranslateTransition openNav=new TranslateTransition(new Duration(350), navList);
        openNav.setToX(0);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), navList);
        menu.setOnAction((ActionEvent evt)->{
            if(navList.getTranslateX()!=0){
                navList.toFront();
                openNav.play();
            }else{
                closeNav.setToX(-(navList.getWidth()));
                closeNav.play();
            }
        });
    }
    
}
