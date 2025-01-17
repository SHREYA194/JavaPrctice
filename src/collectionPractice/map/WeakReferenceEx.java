package collectionPractice.map;

import java.lang.ref.WeakReference;

/**
 * weak reference used n garbage collection
 */

public class WeakReferenceEx {
    public static void main(String[] args) {
        WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Samsung", "S 24"));
        System.out.println(phoneWeakReference.get());
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {

        }
        System.out.println(phoneWeakReference.get());
    }
}

class Phone {
    String brand;
    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
