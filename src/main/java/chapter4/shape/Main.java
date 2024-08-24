package chapter4.shape;

public class Main {
    void anyMethod(Rectangle rectangle, int multiple) {
        rectangle.setRight(rectangle.getRight() * multiple);
        rectangle.setLeft(rectangle.getLeft() * multiple);
        rectangle.setTop(rectangle.getTop() * multiple);
        rectangle.setBottom(rectangle.getBottom() * multiple);

    }
}
