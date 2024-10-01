//Md Istiaq Ahmed


import java.util.*;

class Solve {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public Node constructBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return constructBST(nums, 0, nums.length - 1);
    }

    private Node constructBST(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        Node root = new Node(nums[mid]);
        root.left = constructBST(nums, start, mid - 1);
        root.right = constructBST(nums, mid + 1, end);
        return root;
    }

    public void printTree(Node root) {
        if (root == null)
            return;
        printTree(root, 0);
    }

    private void printTree(Node root, int level) {
        if (root != null) {
            printTree(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printTree(root.left, level + 1); 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solve sort = new Solve();


        System.out.println("Enter the numbers in sorted order to construct the binary search tree:");
        String[] input = scanner.nextLine().split("\\s+");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        Node root = sort.constructBST(nums);
        System.out.println("Height-Balanced BST:");
        sort.printTree(root);

        scanner.close();
    }
}
