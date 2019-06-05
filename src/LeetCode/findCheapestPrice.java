package LeetCode;

public class findCheapestPrice {
    int minCost = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // write your code here
        int[][] graph = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            int[] flight = flights[i];
            graph[flight[0]][flight[1]] = flight[2];
        }
        boolean[] visited = new boolean[n];
        dfs(graph, src, dst, K, visited, 0);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    public void dfs(int[][] graph, int src, int dst, int K, boolean[] visited, int cost) {
        if (src == dst) {
            minCost = Math.min(minCost, cost);
        }
        if (K >= 0 && cost < minCost) {
            for (int i = 0; i < graph.length; ++i) {
                if (graph[src][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    dfs(graph, i, dst, K - 1,
                            visited, cost + graph[src][i]);
                    visited[i] = false;
                }
            }

        }
    }
}
