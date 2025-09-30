package school.static_attributes_methods.drucker_static;

public class Drucker {
    private static String serviceAddress = "http://www.druckerService.de";
    private int dotsPerInch = 300;

    static String getServiceAddress() {
        return serviceAddress;      // OK, access to class attribute possible
    }

    int getDotsPerInch() {
        return dotsPerInch;         // OK, method call only via object
    }

    static void DruckerInfo() {

        System.out.println(serviceAddress); // OK
    //  System.out.println(dotsPerInch);    // ERROR: no access,
                                            // there is not object present
    }
}