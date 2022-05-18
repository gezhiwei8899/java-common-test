package com.gezhiwei.priority;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityTest2 {

    public static void main(String[] args) {
        PriorityTest2 priorityTest2 = new PriorityTest2();
        int i = priorityTest2.minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6});
        System.out.println(i);
        HashMap<String, Integer> map = new HashMap<>();
        map.merge(String.valueOf(1), 1, Integer::sum);

    }

    public int minimumDeletions(int[] nums) {


        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int mid = n / 2 - 1;
        PriorityQueue<Item> bigRoot = new PriorityQueue<>(1, Comparator.comparing(Item::getValue).reversed());
        PriorityQueue<Item> smallRoot = new PriorityQueue<>(1, Comparator.comparing(Item::getValue).reversed().thenComparing(Item::getValue));

        for (int i = 0; i < nums.length; i++) {
            bigRoot.add(new Item(nums[i], i));
            smallRoot.add(new Item(nums[i], i));
        }

        Item big = bigRoot.poll();
        Item small = smallRoot.poll();

        Integer bigIdx = big.getIndex();
        Integer smallIdx = small.getIndex();

        if (smallIdx > bigIdx) {
            smallIdx = smallIdx ^ bigIdx;
            bigIdx = smallIdx ^ bigIdx;
            smallIdx = smallIdx ^ bigIdx;
        }


        int step = 1;

        if (Math.abs(smallIdx - mid) >= Math.abs(bigIdx - mid)) {
            Nod nod = removeStep(smallIdx, mid, n);
            step = nod.getStep();
            if(nod.front) {
                bigIdx  = bigIdx - step;
            }
            n = n - step;
            mid = n / 2 - 1;
            step = step + removeStep(bigIdx, mid, n).getStep();
        } else {
            Nod nod = removeStep(bigIdx, mid, n);
            step = nod.getStep();
            if(nod.front) {
                smallIdx = smallIdx - step;
            }
            n = n - step;
            mid = n / 2 - 1;
            step = step + removeStep(smallIdx, mid, n).getStep();
        }


        return step;

    }

    public Nod removeStep(int index, int mid, int n) {
        if (index <= mid) {
         return new Nod(index + 1, true);
        } else {
            return new Nod(n - index, false);
        }
    }

    static class Nod {
        private Integer step;

        private boolean front;

        public Nod(Integer step, boolean front) {
            this.step = step;
            this.front = front;
        }

        public Integer getStep() {
            return step;
        }

        public void setStep(Integer step) {
            this.step = step;
        }

        public boolean isFront() {
            return front;
        }

        public void setFront(boolean front) {
            this.front = front;
        }
    }


    static class Item {

        private Integer value;

        private Integer index;

        public Item(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }


        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
    }
}
