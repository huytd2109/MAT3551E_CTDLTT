import java.util.*;
public class NPuzzle{
    
    
    public Iterable<int[][]> neighbors(int[][] m) {
    List<int[][]> neighbors = new ArrayList<>();
    int n = m.length; 
    
    int emptyRow = -1, emptyCol = -1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (m[i][j] == 0) {
                emptyRow = i;
                emptyCol = j;
                break;
            }
        }
        if (emptyRow != -1) break;
    }
    
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    for (int[] dir : directions) {
        int newRow = emptyRow + dir[0];
        int newCol = emptyCol + dir[1];
        
        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
            int[][] neighbor = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    neighbor[i][j] = m[i][j];
                }
            }
            
            neighbor[emptyRow][emptyCol] = neighbor[newRow][newCol];
            neighbor[newRow][newCol] = 0;
            
            neighbors.add(neighbor);
        }
    }
    
    return neighbors;
}
    
}
