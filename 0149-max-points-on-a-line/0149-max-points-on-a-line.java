class Solution {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            Map<String, Integer> map = new HashMap<>();
            int same = 0;
            int localMax = 0;
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    same++;
                    continue;
                }
                String slope = getSlope(p1, p2);
                map.put(slope, map.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }
            max = Math.max(max, localMax + same + 1);
        }
        return max;
    }
    private String getSlope(int[] p1, int[] p2) {
    int dx = p1[0] - p2[0];
    int dy = p1[1] - p2[1];
    if (dx == 0) return "INF";
    if (dy == 0) return "0";
    int gcd = gcd(dx, dy);
    return (dx / gcd) + "/" + (dy / gcd);
  }
  private int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }
}
