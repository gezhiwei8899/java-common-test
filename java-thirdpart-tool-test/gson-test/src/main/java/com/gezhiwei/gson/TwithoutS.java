package com.gezhiwei.gson;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gezhiwei
 */
public class TwithoutS {

    private transient final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Integer i;

    private Date t;

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Date getT() {
        return t;
    }

    public void setT(Date t) {
        this.t = t;
    }
}
