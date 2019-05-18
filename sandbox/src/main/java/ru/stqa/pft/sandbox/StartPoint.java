package ru.stqa.pft.sandbox;

public class StartPoint {
  public static void main(String[] args) {

    Point p1 = new Point();
    p1.x1 = 2.0;
    p1.y1 = 3.0;
    Point p2 = new Point();
    p2.x2 = 4.0;
    p2.y2 = 7.0;
    System.out.println(Point.distance(p1, p2));

  }
}
