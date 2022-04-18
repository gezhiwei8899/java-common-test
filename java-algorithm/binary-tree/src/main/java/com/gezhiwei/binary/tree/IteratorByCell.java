package com.gezhiwei.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IteratorByCell {


    public static void main(String[] args) {
        Node root = new Node();

    }

    public void itr(Node root) {


        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.left);
            }

        }


    }
}
