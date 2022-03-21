package com.gezhiwei.stringgroupbylength;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringGroupByLengthTest {


    @Test
    public void test() {

        String[] strings = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};

//        Map<Integer, List<String>> collect = Arrays.stream(strings).collect(Collectors.groupingBy(String::length));

        // 存放等长字符的容器
        Map<Integer, List<List<String>>> map = new HashMap<>();
        for (String string : strings) {
            int length = string.length();
            // 取出等长字符的链表
            List<List<String>> lists = map.get(length);
            if (lists == null) {
                lists = new ArrayList<>();
                List<String> container = new ArrayList<>();
                container.add(string);
                lists.add(container);
                map.put(length, lists);
                continue;
            }
            boolean fit = false;
            for (List<String> container : lists) {
                if(!container.isEmpty()){
                    if (isFit(container.get(0), string, length)) {
                        container.add(string);
                        fit = true;
                        break;
                    }
                }
            }
            if (!fit) {
                List<String> arrayStrs = new ArrayList<>();
                arrayStrs.add(string);
                lists.add(arrayStrs);
            }
            map.put(length, lists);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<List<String>>> entry : map.entrySet()) {
            result.addAll(entry.getValue());
        }
        System.out.println(result);
    }

    public boolean isFit(String a, String b, int length) {
        int key = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            char A = a.charAt(i);
            char B = b.charAt(i);
            int v = abs(A , B);
            if (key == Integer.MIN_VALUE) {
                key = v;
            } else {
                if (key != v) {
                    return false;
                }
            }
        }
        return true;
    }

    private int abs(char a, char b) {
        int v = a - b;
        if (v < 0) {
            return v + 26;
        }
        return v;
    }
}
