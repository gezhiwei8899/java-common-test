package com.gezhiwei.arr;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numberOfRounds("00:47", "00:57");
    }

    public int numberOfRounds(String loginTime, String logoutTime) {
        String[] ssplits = loginTime.split(":");
        String[] esplits = logoutTime.split(":");

        int shours = Integer.valueOf(ssplits[0]);
        int ehours = Integer.valueOf(esplits[0]);

        int smin = Integer.valueOf(ssplits[1]);
        int emin = Integer.valueOf(esplits[1]);


        boolean across = false;

        if(ehours < shours){
            across = true;
        }

        if(ehours == shours && emin < smin){
            across = true;
        }


        smin = closedTime(smin, true);
        if(smin == 60){
            shours  = shours + 1;
            smin = 0;
        }



        emin = closedTime(emin, false);
        if(emin == 60){
            ehours  = ehours + 1;
            emin = 0;
        }

        int ans = 0;

        if(!across){
            ans = (ehours - shours) * 4 + (emin - smin) / 15;
            return ans;
        } else {
            ans = (23 - shours ) * 4 + (60 - smin) / 15 + (ehours - 0) * 4 + (emin - 0 ) /15;
            return ans;
        }
    }

    public int closedTime(int min, boolean isStartTime){
        if(min > 0 && min < 15){
            if(isStartTime){
                return 15;
            } else {
                return 0;
            }
        }

        if(min > 15 && min < 30) {
            if(isStartTime){
                return 30;
            } else {
                return 15;
            }
        }

        if(min > 30 && min < 45) {
            if(isStartTime){
                return 45;
            } else {
                return 30;
            }
        }

        if(min > 45 && min < 60) {
            if(isStartTime){
                return 60;
            } else {
                return 45;
            }
        }
        return min;
    }
}