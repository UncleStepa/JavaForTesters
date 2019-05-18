package ru.stqa.pft.sandbox;

import static java.lang.Math.sqrt;

public class StartPoint {
  public static void main(String[] args) {

    Point p1 = new Point(2.0, 3.0);
    Point p2 = new Point(4.0, 7.0);

    System.out.println(distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {

    return sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
  }

}
