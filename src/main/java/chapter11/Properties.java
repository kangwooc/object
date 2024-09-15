package chapter11;

import java.util.Hashtable;

public class Properties {
    private Hashtable<String, String> properties = new Hashtable<>();

    public void setProperties(Hashtable<String, String> properties) {
        this.properties = properties;
    }

    public Hashtable<String, String> getProperties() {
        return properties;
    }
}
