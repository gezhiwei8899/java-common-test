package com.gezhiwei.alt.tree;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gezhiwei.alt.tree.dto.TreeNode;

/**
 * @author gezhiwei
 */
public class PreItor {



    public static void main(String[] args) {
        TreeNode<Integer, Integer> root = getTree();
        System.out.println(JSONObject.toJSONString(root, SerializerFeature.WriteMapNullValue));
        System.out.println("前");
        preOrder(root);
        System.out.println("中");
        inOrder(root);
    }

    private static void inOrder(TreeNode<Integer, Integer> root) {

        if (null == root) {
            return;
        }
        inOrder(root.getLeft());
        System.out.println(root.getValue());
        inOrder(root.getRight());
    }

    private static void preOrder(TreeNode<Integer, Integer> root) {

        if (null == root) {
            return;
        }
        System.out.println(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    private static TreeNode<Integer, Integer> getTree() {
        TreeNode<Integer, Integer> root = new TreeNode<>();
        root.setValue(1);
        root.setLeft(getSecLTree());
        root.setRight(getSecRTree());
        return root;
    }

    private static TreeNode<Integer, Integer> getSecLTree() {
        TreeNode<Integer, Integer> root = new TreeNode<>();
        root.setValue(2);
        root.setLeft(null);
        root.setRight(null);
        return root;
    }

    private static TreeNode<Integer, Integer> getSecRTree() {
        TreeNode<Integer, Integer> root = new TreeNode<>();
        root.setValue(3);
        root.setLeft(null);
        root.setRight(null);
        return root;
    }
}
