package com.gezhiwei.binary.tree;

import java.io.Serializable;

/**
 * @author gezhiwei
 */
public class Node implements Serializable {

    private static final long serialVersionUID = 7112640022442342963L;

    int val;
    Node left;
    Node right;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
