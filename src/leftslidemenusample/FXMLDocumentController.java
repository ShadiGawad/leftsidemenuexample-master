/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leftslidemenusample;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.glyphfont.FontAwesome;


/**
 *
 * @author felipe
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private AnchorPane navList;
    @FXML
    private AnchorPane mainContent;
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
    @FXML
    private Label label;
    @FXML
    private JFXHamburger ham;
    @FXML
    private JFXTextField nameSearch;
    @FXML
    private JFXTextField typeSearch;
    @FXML
    private JFXTextField subSearch;
    @FXML
    private JFXTextField Zugangskappa;
    @FXML
    private JFXTreeTableView <Storage> table;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accordion.lookupAll(".title").forEach(node -> node.setCursor(Cursor.CLOSED_HAND));

        createTables ();




        //<editor-fold desc="Auto Completion for Text Fields">
        TextFields.bindAutoCompletion(nameSearch,"BERMEN","SUPERMARKET","STD");
        TextFields.bindAutoCompletion(typeSearch,"STD","PRIO","BURN");
        TextFields.bindAutoCompletion(subSearch,"SPEC");
        TextFields.bindAutoCompletion(Zugangskappa,"BERMEN","SUPERMARKET","STD");
        //</editor-fold>

        prepareSlideMenuAnimation();
    }


      //Navigation Drawer
    private void prepareSlideMenuAnimation() {
        TranslateTransition openNav=new TranslateTransition(new Duration(350), navList);
        openNav.setToX(0);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), navList);
        /*menu.setOnAction((ActionEvent evt)->{
            if(navList.getTranslateX()!=0){
                navList.toFront();
                openNav.play();
            }else{
                closeNav.setToX(-(navList.getWidth()));
                closeNav.play();
            }
        });*/
        HamburgerBasicCloseTransition transition = new HamburgerBasicCloseTransition(ham);
        transition.setRate(-1);
        ham.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            if(navList.getTranslateX()!=0){
                navList.toFront();
                openNav.play();
            }else{
                closeNav.setToX(-(navList.getWidth()));
                closeNav.play();
            }
        });

    }

    //Tables
    private void createTables () {

        JFXTreeTableColumn<Storage,String> col = new JFXTreeTableColumn <> ("SCHLEUSEN_NAME");
        col.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Storage, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Storage, String> param) {
                return param.getValue().getValue().SCHLEUSEN_NAME;
            }
        });

        JFXTreeTableColumn <Storage,String> col2 = new JFXTreeTableColumn <> ("SCHLEUSEN_TYPE");
        col2.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Storage, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Storage, String> param) {
                return param.getValue().getValue().SCHLEUSEN_TYPE;
            }
        });

        JFXTreeTableColumn <Storage,String> col3 = new JFXTreeTableColumn <> ("SCHLEUSEN_SUB");
        col3.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Storage, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Storage, String> param) {
                return param.getValue().getValue().SCHLEUSEN_SUB;
            }
        });

        JFXTreeTableColumn <Storage,String> col4 = new JFXTreeTableColumn <> ("ZUGANGSKAPPA");
        col3.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Storage, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Storage, String> param) {
                return param.getValue().getValue().ZUGANGSKAPPA;
            }
        });

        final ObservableList<Storage> data =
                FXCollections.observableArrayList(
                        new Storage("BREMEN", "STD", "","55"),
                        new Storage("BREMEN", "PRIO", "SPEC","40"),
                        new Storage("SUPERMARKET", "BURN", "SPEC","80"),
                        new Storage("STD", "PRIO", "SPEC","90"),
                        new Storage("BREMEN", "STD", "","455")
                );


        final TreeItem<Storage> root = new RecursiveTreeItem<Storage>(data, RecursiveTreeObject::getChildren);
        table.getColumns().setAll(col, col2, col3,col4);
        table.setRoot(root);
        table.setShowRoot(false);

    }

}
