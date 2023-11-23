package programmers.kotlin;

import java.util.HashSet;

class SomeProb {
    public boolean solution(String[] phone_book) {
        HashSet<String> hs = new HashSet<>();
        for (String s : phone_book) {
            for (int i = 1; i < s.length(); i++) {
                hs.add(s.substring(0, i));
            }
        }

        for (String s : phone_book) {
            if (hs.contains(s)) return false;
        }

        return true;
    }
}