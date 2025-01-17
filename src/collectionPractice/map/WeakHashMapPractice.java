package collectionPractice.map;

import java.util.WeakHashMap;

/**
 * garbage collection in case of no use of map
 */

public class WeakHashMapPractice {
    public static void main(String[] args) {
        WeakHashMap<String,Image> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(new String("img1"), new Image("first image"));
        weakHashMap.put(new String("img2"), new Image("second image"));
        System.out.println(weakHashMap);

        System.gc();
        methodsToExecute();

        System.out.println(weakHashMap);

    }

    private static void methodsToExecute() {
        try {
            System.out.println("internal method...");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Image {
    String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                '}';
    }
}
