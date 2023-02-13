package Java_Network.Tesk;


public class ShapeDemo {
    public static void main(String[] args) {
        // v1
        System.out.println("사각형 : " + ShapeTest.findShapesByType(Shape.shapes, "사각형"));
        System.out.println("빨간 도형(면적<=12.0) : " + ShapeTest.findShapesByColorNArea(Shape.shapes, "빨간색", 12.0));

        // v2
        System.out.println(ShapeTest.findShapes1(Shape.shapes, "사각형", "빨간색", 12.0));


    }
}
