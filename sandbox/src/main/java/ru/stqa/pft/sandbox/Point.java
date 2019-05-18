package ru.stqa.pft.sandbox;

import static java.lang.Math.sqrt;

public class Point {
  double x1;
  double y1;
  double x2;
  double y2;

  public static double distance(Point p1, Point p2) {

    return sqrt((p2.x2 - p1.x1) * (p2.x2 - p1.x1) + (p2.y2 - p1.y1) * (p2.y2 - p1.y1));
  }
}
