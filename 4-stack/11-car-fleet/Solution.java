import java.util.Arrays;

public class Solution {
  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    double[][] cars = new double[n][2];

    for (int i = 0; i < n; i++) {
      cars[i][0] = position[i];
      cars[i][1] = (double) (target - position[i]) / speed[i];
    }

    Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

    int fleets = 0;
    double slowest = 0.0; // time of the leading fleet so far

    for (double[] car : cars) {
      double t = car[1];
      if (t > slowest) { // <- new fleet
        fleets++;
        slowest = t;
      }                 // else merges into current fleet
    }

    return fleets;
  }
}
