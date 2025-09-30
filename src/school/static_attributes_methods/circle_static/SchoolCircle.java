package school.static_attributes_methods.circle_static;

public class SchoolCircle {
    private static double PI = 3.14159;
    private double radius;

    SchoolCircle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return PI * radius * radius;
    }
}
