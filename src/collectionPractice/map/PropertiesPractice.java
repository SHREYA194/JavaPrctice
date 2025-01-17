package collectionPractice.map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * with db.properties
 * load property
 * get property
 * set property
 * get all properties
 * get all system property
 * create property file
 */

public class PropertiesPractice {
    public static void main(String[] args) throws IOException {
        loadGetSetGetAllEx();
        getAllSystemEx();
        setCreateEx();
    }

    private static void setCreateEx() throws IOException {
        System.out.println("\n\n create properties file example. ");
        Properties p = new Properties();
        p.setProperty("prop1", "Property 1");
        p.setProperty("prop2", "Property 2");
        p.setProperty("prop3", "Property 3");
        p.setProperty("prop4", "Property 4");
        p.store(new FileWriter("D:\\PREPARATION\\java\\practices\\JavaPrctice\\src\\collectionPractice\\map\\info.properties"), "Java Properties File example");
    }

    private static void getAllSystemEx() {
        System.out.println("\n\n get all system properties :- ");
        Properties properties = System.getProperties();
        Iterator iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    private static void loadGetSetGetAllEx() throws IOException {
        FileReader fileReader = new FileReader("D:\\PREPARATION\\java\\practices\\JavaPrctice\\src\\collectionPractice\\map\\db.properties");
        Properties p = new Properties();
        p.load(fileReader);
        System.out.println(p.getProperty("user"));
        System.out.println(p.getProperty("password"));
        p.setProperty("setPropertyEx", "true");

        System.out.println("\n get all properties :- ");
        Iterator iterator = p.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " :-" + entry.getValue());
        }
    }
}
