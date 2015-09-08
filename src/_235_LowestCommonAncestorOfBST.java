import util.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by feng on 2015/9/7.
 */
public class _235_LowestCommonAncestorOfBST {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
    }

    public TreeUtil.TreeNode lowestCommonAncestor(TreeUtil.TreeNode root, TreeUtil.TreeNode p, TreeUtil.TreeNode q) {
        if (root==null||p==null||q==null)
            return null;

        if (max(p.val,q.val) < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if (min(p.val, q.val) > root.val){
            return lowestCommonAncestor(root.right,p, q);
        }else {
            return root;
        }

    }

    private static int max(int a,int b){
        return a>b?a:b;
    }
    private static int min(int a,int b){
        return a<b?a:b;
    }

}
