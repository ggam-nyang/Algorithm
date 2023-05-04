package programmers;

import java.util.ArrayList;
import java.util.Optional;

// dfs time over
// need bfs
class Programmers1844 {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    boolean[][] visited;
    int X;
    int Y;
    ArrayList<Integer> ans = new ArrayList<>();
    int[][] graph;

    public int solution(int[][] maps) {
        X = maps.length;
        Y = maps[0].length;
        visited = new boolean[X][Y];
        graph = maps;

        visited[0][0] = true;
        dfs(0, 0, 1);

        if (ans.isEmpty()) return -1;
        return ans.stream().min(Integer::compareTo).get();
    }

    private void dfs(int x, int y, int level) {
        System.out.println(x + "  " + y + "  " + level);

        if (x == X - 1 && y == Y - 1) {
            ans.add(level);
            return;
        }

        Optional<Integer> minValue = ans.stream().min(Integer::compareTo);
        if (minValue.isPresent()) {
            if (minValue.get() <= level) return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (0 <= newX && newX < X && 0 <= newY && newY < Y && !visited[newX][newY]) {
                if (graph[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    dfs(newX, newY, level + 1);
                    visited[newX][newY] = false;
                }
            }
        }
    }
}