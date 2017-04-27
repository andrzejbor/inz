package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Andrzej on 21.04.2017.
 */
public class Record {
    private final SimpleStringProperty id;
    private final SimpleIntegerProperty value_0;
    private final SimpleIntegerProperty value_1;
    private final SimpleIntegerProperty value_2;
    private final SimpleIntegerProperty value_3;
    private final SimpleIntegerProperty value_4;

    public Record(String i, int v0, int v1, int v2, int v3,
                  int v4) {
        this.id = new SimpleStringProperty(i);
        this.value_0 = new SimpleIntegerProperty(v0);
        this.value_1 = new SimpleIntegerProperty(v1);
        this.value_2 = new SimpleIntegerProperty(v2);
        this.value_3 = new SimpleIntegerProperty(v3);
        this.value_4 = new SimpleIntegerProperty(v4);
    }


    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public int getValue_0() {
        return value_0.get();
    }

    public void setValue_0(int v) {
        value_0.set(v);
    }

    public int getValue_1() {
        return value_1.get();
    }

    public void setValue_1(int v) {
        value_1.set(v);
    }

    public int getValue_2() {
        return value_2.get();
    }

    public void setValue_2(int v) {
        value_2.set(v);
    }

    public int getValue_3() {
        return value_3.get();
    }

    public void setValue_3(int v) {
        value_3.set(v);
    }

    public int getValue_4() {
        return value_4.get();
    }

    public void setValue_4(int v) {
        value_4.set(v);
    }


}

