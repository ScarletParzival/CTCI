package Chapter_4;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/16/13
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class BSTWithMinimalHeightGivenAnAscendingArray {

    public static BinaryTreeNode makeBSTWithArray(int[] array){
        return makeBSTWithArray(array, 0, array.length-1);
    }

    public static BinaryTreeNode makeBSTWithArray(int[] array, int start, int end){
        //Base condition
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        BinaryTreeNode root = new BinaryTreeNode("Holder",array[mid]);
        root.leftChild = makeBSTWithArray(array, start, mid-1);
        root.rightChild = makeBSTWithArray(array, mid+1, end);
        return root;
    }

    public static void main(String[] args){

       BinaryTree tree = new BinaryTree();
       int[] array = {1,2,3,4,5,6,7}; //,8,9,10,11,12,13,14,15,16};
       tree.root = makeBSTWithArray(array);
       tree.postOrderTraversal(tree.root);
    }

}