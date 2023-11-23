package programmers.kotlin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

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
        int answer = -1;

        X = maps.length;
        Y = maps[0].length;
        visited = new boolean[X][Y];
        graph = maps;

        visited[0][0] = true;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1));

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            for (int i = 0; i < 4; i++) {
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];

                if (0 <= newX && newX < X && 0 <= newY && newY < Y && !visited[newX][newY]) {
                    if (maps[newX][newY] == 1) {
                        if (newX == X - 1 && newY == Y - 1) {
                            return node.level + 1;
                        }
                        visited[newX][newY] = true;
                        queue.add(new Node(newX, newY, node.level + 1));
                    }
                }
            }
        }

        return answer;
    }

    static class Node {
        int x;
        int y;
        int level;

        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}