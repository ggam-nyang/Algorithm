package programmers;

import java.util.ArrayList;
import java.util.Arrays;

class Programmer87946 {
    ArrayList<int[][]> permuDgs = new ArrayList<>();


    public int solution(int k, int[][] dungeons) {
        ArrayList<Integer> answers = new ArrayList<>();
        int temp = 0;
        int tempK = k;

        permutation(dungeons, 0, dungeons.length, dungeons.length);

        for (int[][] permuDg : permuDgs) {
            temp = 0;
            tempK = k;

            for (int[] dungeon : permuDg) {
                if (tempK >= dungeon[0]) {
                    temp++;
                    tempK -= dungeon[1];
                }
            }
            answers.add(temp);
        }

        return answers.stream().max(Integer::compareTo).get();
    }

    void permutation(int[][] arr, int depth, int n, int r) {
        if (depth == r) {
            permuDgs.add(Arrays.copyOf(arr, arr.length));
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    void swap(int[][] arr, int depth, int i) {
        int[] temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
