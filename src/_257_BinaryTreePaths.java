import util.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by feng on 2015/9/6.
 */
public class _257_BinaryTreePaths {
    public static void main(String[] args) {
        TreeUtil.TreeNode root = new TreeUtil.TreeNode(1);
        root.left = new TreeUtil.TreeNode(2);
        List<String> result = new _257_BinaryTreePaths().binaryTreePaths(root);
    }

    public List<String> binaryTreePaths(TreeUtil.TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null){
            return paths;
        }
        StringBuilder path = new StringBuilder();
        path.append(root.val);
        if (root.left==null&&root.right==null){
            System.out.println(path.toString());
            paths.add(path.toString());
        }
        getTreePaths(paths, root.left, path.toString());
        getTreePaths(paths,root.right,path.toString());
        return paths;
    }

    private void getTreePaths(List<String> paths, TreeUtil.TreeNode node, String rootPath) {
        StringBuilder p = new StringBuilder(rootPath);
        if (node!=null){
            p.append("->" + node.val);
            if (node.left!=null){
                getTreePaths(paths, node.left, p.toString());
            }
            if (node.right!=null){
                getTreePaths(paths,node.right,p.toString());
            }
            if (node.left==null&&node.right==null){
                System.out.println(p.toString());
                paths.add(p.toString());
            }
        }
    }
}
