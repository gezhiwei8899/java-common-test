package com.gezhiwei.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.util.StringUtils;

import java.util.Objects;

public class Json {

    static String json = "{\n" +
            "    \"max\": 100,\n" +
            "    \"min\": 10,\n" +
            "    \"rule\": [\n" +
            "        {\n" +
            "            \"field\": \"name\",\n" +
            "            \"exec\": [\n" +
            "                {\n" +
            "                    \"op\": \"isEmpty\",\n" +
            "                    \"val\": -50,\n" +
            "                    \"order\": 1\n" +
            "                },\n" +
            "                {\n" +
            "                    \"op\": \"lt\",\n" +
            "                    \"opVal\": 4,\n" +
            "                    \"val\": -50,\n" +
            "                    \"order\": 2\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"field\": \"nameandkeyno\",\n" +
            "            \"exec\": [\n" +
            "                {\n" +
            "                    \"op\": \"regx\",\n" +
            "                    \"opVal\": \".*\\\"[a-z0-9]{32}\\\".*\",\n" +
            "                    \"val\": -50,\n" +
            "                    \"order\": 2\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public void test() {
        JSONObject jsonObject = JSONObject.parseObject(json);
        Integer max = jsonObject.getInteger("max");
        Integer min = jsonObject.getInteger("min");

        JSONArray rules = jsonObject.getJSONArray("rule");
        for (Object rule : rules) {
            JSONObject object = (JSONObject) rule;
            System.out.println(object.getString("field") + " execute " + object.getString("op") + " " + object.getString("opVal"));
        }
    }


    public static void main(String[] args) {
        String regx = ".*\"[a-z0-9]{32}\".*";
//        String md = "[{\"KeyNo\":\"pb873c9914ee1dc3943b1ce0ce916ed6\",\"T\":\"21\",\"Org\":2,\"Name\":\"陈宏\"}]";
        String md = "[{\"KeyNo\":\"pb873c9914ee1dc3943b1ce0ce916ed6\",\"T\":\"21\",\"Org\":2,\"Name\":\"陈宏\"}]";
        JSONObject jsonObject = JSONObject.parseObject(json);
        Integer max = jsonObject.getInteger("max");
        Integer min = jsonObject.getInteger("min");

        JSONArray rules = jsonObject.getJSONArray("rule");
        for (Object rule : rules) {
            JSONObject object = (JSONObject) rule;
            String field = object.getString("field");
            if (field.equals("nameandkeyno")) {
                JSONArray execs = object.getJSONArray("exec");
                for (Object exec : execs) {
                    JSONObject jsonExec = (JSONObject) exec;
                    String op = jsonExec.getString("op");
                    if (Objects.equals(op, "regx")) {
                        String opVal = jsonExec.getString("opVal");
                        if (md.matches(opVal)) {
                            System.out.println("matched");
                        }
                    }
                }

            }
        }
    }
}
