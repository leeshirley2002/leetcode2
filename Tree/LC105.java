/*Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode build(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn){
        if(startPre>endPre || startIn>endIn){
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPre]);
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == preorder[startPre]){
                root.left = build(preorder, startPre+1, startPre + i-startIn, inorder, startIn, i-1);
                root.right = build(preorder, startPre + i-startIn+1, endPre, inorder, i+1, endIn);
            }
        }
        return root;
    }
}