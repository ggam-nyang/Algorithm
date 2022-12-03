package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Programmers12927 {
    public long solution(int n, int[] works) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (int) (b - a));
        pq.addAll(Arrays.stream(works).mapToLong(e -> (long) e).boxed().collect(Collectors.toList()));

        while (n > 0) {
            if (pq.peek() <= 0) return 0;

            pq.add(pq.poll() - 1);
            n--;
        }

        return pq.stream().map(e -> e * e)
                .reduce(0L, Long::sum);
    }
}