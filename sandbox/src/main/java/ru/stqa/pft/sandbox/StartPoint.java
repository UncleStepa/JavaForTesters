package ru.stqa.pft.sandbox;



public class StartPoint {
  public static void main(String[] args) {

    Point p1 = new Point(3.0, 4.0);
    Point p2 = new Point(5.0, 6.0);

    System.out.println(p1.distance(p2));

  }
}
