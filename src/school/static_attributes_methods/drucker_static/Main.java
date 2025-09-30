package school.static_attributes_methods.drucker_static;

public class Main {
    public static void main(String[] args) {
        System.out.println(Drucker.getServiceAddress());    // OK, direct call of static method
     // System.out.println(Drucker.getDotsPerInch());       // ERROR: No object present

       Drucker opsenBubblejet = new Drucker();
       System.out.println(opsenBubblejet.getDotsPerInch()); // now it's OK

    }
}
