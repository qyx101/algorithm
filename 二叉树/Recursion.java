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
        inOrder(head.left);
        inOrder(head.right);
        System.out.print(head.val + " ");
    }
    // 后序 - 非递归实现 - 两个栈实现
    public static void postOrder2(TreeNode<Integer> head) {

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
        Recursion.inOrder(head);
        System.out.println();
        Recursion.inOrder2(head);

        // 测试 - 后序遍历
        //Recursion.postOrder(head);
    }


}