package core.two.lesson5.practice1;

public class Rectangle {

    private final Point leftTop;

    private final Point rightBottom;


    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Point getLeftTop() {
        return leftTop;
    }

    public Point getRightBottom() {
        return rightBottom;
    }

    public double square() {
        return getSideA() * getSideB();
    }

    public double diagonal() {
        return rightBottom.distance(leftTop);
    }

    private double getSideA() {
        return rightBottom.getX() - leftTop.getX();
    }

    private double getSideB() {
        return leftTop.getY() - rightBottom.getY();
    }
}
