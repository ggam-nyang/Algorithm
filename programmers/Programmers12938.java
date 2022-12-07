package programmers;

class Programmers12938 {
        public int[] solution(int n, int s) {
            int avg = s / n;
            int namugi = s % n;
            if (avg == 0) return new int[]{-1};

            int[] list = new int[n];

            for (int i = 0; i < n; i++) {
                if (i < n - namugi) {
                    list[i] = avg;
                } else {
                    list[i] = avg + 1;
                }
            }

            return list;
        }
    }