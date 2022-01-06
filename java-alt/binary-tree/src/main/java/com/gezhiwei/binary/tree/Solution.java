package com.gezhiwei.binary.tree;

import java.util.*;

/**
 * @author gezhiwei
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        result.add(Arrays.asList(root.val));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            List<Integer> arr = new ArrayList<>();

            if (node.left != null) {
                queue.offer(node.left);
                arr.add(node.left.val);
            }

            if (node.right != null) {
                queue.offer(node.right);
                arr.add(node.right.val);
            }

            if (!arr.isEmpty()) {
                result.add(arr);
            }

        }

        String a = "b";

        Collections.reverse(result);
        return result;
    }
}
