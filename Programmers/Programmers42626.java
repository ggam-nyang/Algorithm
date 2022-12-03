package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Programmers42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

        while (pq.size() > 1) {
            if (pq.peek() >= K) return scoville.length - pq.size();

            pq.add(pq.poll() + pq.poll() * 2);
        }

        if (pq.peek() < K) return -1;

        return scoville.length - pq.size();
    }
}