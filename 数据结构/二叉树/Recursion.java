import java.util.Stack;

// 递归实现 二叉树的三序遍历
class Recursion {

    static class TreeNode<T> {
        T val;
        TreeNode<Integer> left;
        TreeNode<Integer> right;

        public TreeNode(T val) {
            this.val = val;
        }
    }

    // 中 -> 左 -> 右
    // 前序 - 递归实现
    public static void preOrder(TreeNode<Integer> head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    // 前序 - 非递归实现
    public static void preOrder2(TreeNode<Integer> head) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode<Integer> top = stack.pop();
            System.out.print(top.val + " ");
            // 必须是先压右, 再压左
            // 这样左先出栈打印, 中 -> 左
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }

    }

    // 左 -> 中 -> 右
    // 中序 - 递归实现
    public static void inOrder(TreeNode<Integer> head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.val + " ");
        inOrder(head.right);
    }
    // 中序 - 非递归实现
    public static void inOrder2(TreeNode<Integer> head) {
       Stack<TreeNode<Integer>> stack = new Stack<>();
       while (head != null || !stack.isEmpty()) {
           if (head != null) {
               stack.push(head);
               head = head.left;
           }else {
               TreeNode<Integer> top = stack.pop();
               System.out.print(top.val + " ");
               head = top.right;
           }
       }
    }

    // 左 -> 右 -> 中
    // 后序 - 递归实现
    public static void postOrder(TreeNode<Integer> head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val + " ");
    }
    // 后序 - 非递归实现 - 两个栈实现
    public static void postOrderTwoStacks(TreeNode<Integer> head) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        Stack<TreeNode<Integer>> collect = new Stack<>();
        stack.push(head);

        // 按, 中 -> 右 -> 左 顺序入collect栈
        while (!stack.isEmpty()) {
            TreeNode<Integer> top = stack.pop();
            collect.push(top);
            // 先压左, 再压右
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
        }
        // 出栈就是: 左 -> 右 -> 中
        while (!collect.isEmpty()) {
            System.out.print(collect.pop().val + " ");
        }
    }
    // 后序 - 非递归实现 - 一个个栈实现
    public static void postOrderOneStacks(TreeNode<Integer> head) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode<Integer> cur = stack.peek();
            if (cur.left != null && cur.left != head && cur.right != head) {
                // 左树不为空 && 左树没处理过进来
                // cur.right != head 这个条件是必要的, 如果head == cur.right
                // 说明右树已经处理过了, 如果右树处理了, 左树一定也已经处理过了
                stack.push(cur.left);
            }else if (cur.right != null && cur.right != head) {
                stack.push(cur.right);
            }else {
                // 左右为空, 或者, 左右都处理过了
                // 就可以打印这个节点了
                head = stack.pop();
                System.out.print(head.val + " ");

            }
        }
    }

    public static void main(String[] args) {

        // 自己构造一颗二叉树出来
        TreeNode<Integer> head = new TreeNode<>(1);
        head.left = new TreeNode<>(3);
        head.left.right = new TreeNode<>(4);
        head.right = new TreeNode<>(5);
        head.right.left = new TreeNode<>(7);
        head.right.right = new TreeNode<>(9);
        head.right.left.right = new TreeNode<>(8);

        // 测试 - 前序遍历
        /*Recursion.preOrder(head);
        System.out.println();
        Recursion.preOrder2(head);*/

        // 测试 - 中序遍历
        /*Recursion.inOrder(head);
        System.out.println();
        Recursion.inOrder2(head);*/

        // 测试 - 后序遍历
        postOrder(head);
        System.out.println();
        postOrderTwoStacks(head);
        System.out.println();
        postOrderOneStacks(head);
    }


}