package fLab;

import java.io.Serializable;
import java.util.ArrayList;

// 1352
class ProductOfNumbers {
    private final ArrayList<Integer> stream = new ArrayList<>();

    public void add(int num) {
        if (num == 0) {
            stream.clear();
            return;
        }

        if (stream.isEmpty()) stream.add(num);
        else {
            stream.add(stream.get(stream.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (k > stream.size()) return 0;

        if (k == stream.size()) return stream.get(stream.size() - 1);
        return stream.get(stream.size() - 1) / stream.get(stream.size() - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */