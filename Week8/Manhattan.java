public class Manhattan{
    
    public int manhattan(int[][] m)
    {
        int n = m.length;
        int totalDistance = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int value = m[i][j];
                if (value != 0) {
                    int expectedRow = (value - 1) / n;
                    int expectedCol = (value - 1) % n;
                    int tileDistance = Math.abs(i - expectedRow) + Math.abs(j - expectedCol);
                    totalDistance += tileDistance;
                }
            }
        }
        return totalDistance;
    }
}
