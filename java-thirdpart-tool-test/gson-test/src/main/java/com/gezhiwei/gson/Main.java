package com.gezhiwei.gson;
import com.google.gson.Gson;

import java.util.Date;

/**
 * @author gezhiwei
 */
public class Main {

    static Gson gson = new Gson();


    public static void main(String[] args) {
        TwithoutS twithoutS = new TwithoutS();
        twithoutS.setI(0);
        twithoutS.setT(new Date());
        gson.toJson(twithoutS);

        TwithS twithS = new TwithS();
        twithS.setI(0);
        twithS.setT(new Date());
        gson.toJson(twithS);
    }
}
