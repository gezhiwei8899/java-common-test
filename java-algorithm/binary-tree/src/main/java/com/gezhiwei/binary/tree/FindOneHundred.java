package com.gezhiwei.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class FindOneHundred {

    int sum = 0;
    int TARGET = 100;
    private List<Node> path;

    private List<List<Node>> results;

    public static void main(String[] args) {
        FindOneHundred findOneHundred = new FindOneHundred();

        Node root = new Node();
        findOneHundred.findOneH(root);
    }

    public List<Node> findOneH(Node root) {
        path = new ArrayList<>();
        results = new ArrayList<>();
        if (root.val == TARGET) {
            path.add(root);
        } else {
            doFind(root, path);
        }
        return path;
    }

    public void doFind(Node node, List<Node> path) {
        // 终止条件
        if (null == node || sum == TARGET) {
            results.add(path);
            path = new ArrayList<>();
            return;
        }
        int val = node.val;
        // 这条链路走不通
        if((sum + val) > TARGET){
            return;
        }
        sum = sum + val;
        path.add(node);
        // 递归
        doFind(node.left, path);
        doFind(node.right, path);
    }
}