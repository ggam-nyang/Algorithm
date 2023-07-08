package programmers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int X;
    int Y;

    boolean[][][] visited;
    int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Map<String, Integer> dMap;

    public int[] solution(String[] grid) {
        X = grid.length;
        Y = grid[0].length();
        visited = new boolean[X][Y][4];

        dMap = new HashMap<>();

        for (int x = 0; x <X; x++) {
            for (int y = 0; y < Y; y++) {
                for (int d = 0; d < 4; d++) {
                    if (visited[x][y][d]) continue;

                    shootLight(x, y, d);
                }
            }
        }

        int[] answer = {};
        return answer;
    }

    private void shootLight(int x, int y, int d) {
        // TODO document why this method is empty
    }
}