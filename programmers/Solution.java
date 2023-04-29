package programmers;

import java.lang.reflect.Array;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 1;
        int[] answer = new int[2];

        int sum = sequence[left];
        while(left <= right) {
            if (sum < k) {
                if (right >= sequence.length) {
                    break;
                }
                sum += sequence[right];
                right++;
            }
            else if (sum > k) {
                sum -= sequence[left];
                left++;

                if (left >= sequence.length) {
                    break;
                }
            }
            else {
                answer[0] = left;
                answer[1] = right;
                return answer;
            }
        }

        return answer;
    }
}
