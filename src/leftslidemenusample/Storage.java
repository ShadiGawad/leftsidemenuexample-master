package leftslidemenusample;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;

public class Storage extends RecursiveTreeObject<Storage> {

    public final SimpleStringProperty SCHLEUSEN_NAME;
    public final SimpleStringProperty SCHLEUSEN_TYPE;
    public final SimpleStringProperty SCHLEUSEN_SUB;
    public final SimpleStringProperty ZUGANGSKAPPA;



    public Storage(String NAME, String TYPE, String SUB, String ZUGANGSKAPPA_COL) {
        this.SCHLEUSEN_NAME = new SimpleStringProperty(NAME);
        this.SCHLEUSEN_TYPE = new SimpleStringProperty(TYPE);
        this.SCHLEUSEN_SUB = new SimpleStringProperty(SUB);
        this.ZUGANGSKAPPA= new SimpleStringProperty(ZUGANGSKAPPA_COL);
    }
}