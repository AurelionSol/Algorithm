import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) {
        BFS bfs = new BFS();
        System.out.println(bfs.numSquares(13));
    }

    public int numSquares(int n) {
        int[] dist = new int[n + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(dist[0]);
        while (!queue.isEmpty()) {
            int t = queue.poll();
            if (t == n) return dist[t];
            for (int i = 0; i * i + t <= n; i++) {
                int j = i * i + t;
                if (dist[j] > dist[t] + 1) {
                    dist[j] = dist[t] + 1;
                    queue.offer(j);
                }
            }
        }
        return -1;
    }
}
