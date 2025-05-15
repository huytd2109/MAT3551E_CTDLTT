import java.util.*;

public class Graph {
    public int[] djikstra(int[][] a, int x, int y) {
        int n = a.length - 1; 
        
        int[] dist = new int[n + 1];
        int[] prev = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x - 1] = 0;
        
        prev[x - 1] = -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(dist[v1], dist[v2]));
        pq.add(x - 1);
        
        while (!pq.isEmpty()) {
            int u = pq.poll();
            
            if (visited[u]) {
                continue; 
            }
            
            visited[u] = true;
            
            for (int v = 1; v <= n; v++) {
                if (a[u][v] > 0) { 
                    int newDist = dist[u] + a[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        prev[v] = u;
                        pq.add(v);
                    }
                }
            }
        }
        
        if (dist[y - 1] == Integer.MAX_VALUE) {
            return new int[] {};
        }
        
        List<Integer> path = new ArrayList<>();
        for (int at = y - 1; at != 0; at = prev[at]) {
            path.add(at);
        }
        
        Collections.reverse(path);
        
        return path.stream().mapToInt(i -> i).toArray();
    }
}
