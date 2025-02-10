//shapeArray.java - our driver class
public class ShapeArray {
    private Shape[] shapeArray;

    public ShapeArray() {
        shapeArray = new Shape[]{
            new Triangle(3, 4, 5),  // right triangle
            new Circle(7),          // circle with radius 7
            new Rectangle(5, 5)     // square (special case of a rectangle)
        };
    }

    public void printShapes() {
        for (Shape shape : shapeArray) {
            System.out.println(shape);
        }
    }

    public static void main(String[] args) {
        ShapeArray app = new ShapeArray();
        app.printShapes();
    }
}
