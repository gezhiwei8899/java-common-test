package com.gezhiwei.binary.tree;

import java.io.Serializable;

public class TreeNode implements Serializable {

    private static final long serialVersionUID = 7112640022442342963L;

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
