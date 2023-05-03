package programmers;

import java.util.Arrays;

// Fail...
class Programmers152996 {
    int[] checkList = {1, 2, 3, 4};

    public long solution(int[] weights) {
        long answer = 0;

        for (int i = 0; i < weights.length; i++) {
            for (int j = i + 1; j < weights.length; j++) {
                int light = Math.min(weights[i], weights[j]);
                int heavy = Math.max(weights[i], weights[j]);

                if (checkCouple(light, heavy)) answer++;
            }
        }

        return answer;
    }

    private boolean checkCouple(int light, int heavy) {
        if (Arrays.asList(checkList).contains(heavy / light)) return true;
        if (light * 3 == heavy * 2) return true;
        if (light * 4 == heavy * 3) return true;

        System.out.println(heavy / light);
        return false;
    }
}
