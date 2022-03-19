package com.gezhiwei.pritirty;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author gezhiwei
 */
public class Solution {
//    ["623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"]

    // ["683339452288515879","7846081062003424420","4805719838","4840666580043","83598933472122816064","522940572025909479","615832818268861533","65439878015","499305616484085","97704358112880133","23861207501102","919346676","60618091901581","5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"]
    //3
//            11
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] nums = new String[]{"0", "1", "1"};
//        String[] nums = new String[]{"3","6","7","10"};
//        String[] nums = new String[]{"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"};
        String[] nums = new String[]{"683339452288515879","7846081062003424420","4805719838","4840666580043","83598933472122816064","522940572025909479","615832818268861533","65439878015","499305616484085","97704358112880133","23861207501102","919346676","60618091901581","5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"};
        int k = 3;
        String s = solution.kthLargestNumber(nums, k);
        System.out.println(s);
    }

    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<BigInteger> heap = new PriorityQueue<>(k, new Comparator<BigInteger>() {
            @Override
            public int compare(BigInteger o1, BigInteger o2) {
                BigInteger divide = o2.divide(o1);
                return divide.compareTo(BigInteger.ZERO);
            }
        });


        for (String str : nums) {
            BigInteger num = new BigInteger(str);
            heap.add(num);
        }
        int count = 0;
        while (!heap.isEmpty()) {
            heap.poll();
            count++;
            if (count == k - 1) {
                break;
            }
        }

        return String.valueOf(heap.poll());

    }
}
