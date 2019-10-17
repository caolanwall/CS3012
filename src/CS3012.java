// Java Program for Lowest Common Ancestor in a Binary Tree 
// A O(n) solution to find LCA of two given values n1 and n2 
import java.util.ArrayList; 
import java.util.List; 
import java.util.LinkedList;
  
// A Binary Tree node 
class Node { 
    int data; 
    Node left, right; 
  
    Node(int value) { 
        data = value; 
        left = right = null; 
    } 
} 
  
public class CS3012  
{ 
  
    Node root; 
    private List<Integer> path1 = new ArrayList<>(); 
    private List<Integer> path2 = new ArrayList<>(); 
  
    // Finds the path from root node to given root of the tree. 
    int findLCA(int n1, int n2) { 
        path1.clear(); 
        path2.clear(); 
        return findLCAInternal(root, n1, n2); 
    } 
  
    private int findLCAInternal(Node root, int n1, int n2) { 
  
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) { 
            return -1; 
        } 
  
        int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++) { 
              
        // System.out.println(path1.get(i) + " " + path2.get(i)); 
            if (!path1.get(i).equals(path2.get(i))) 
                break;   
        } 
  
        return path1.get(i-1); 
    } 
      
    // Finds the path from root node to given root of the tree, Stores the 
    // path in a vector path[], returns true if path exists otherwise false 
    private boolean findPath(Node root, int n, List<Integer> path) 
    { 
        // base case 
        if (root == null) { 
            return false; 
        } 
          
        // Store this node . The node will be removed if 
        // not in path from root to n. 
        path.add(root.data); 
  
        if (root.data == n) { 
            return true; 
        } 
  
        if (root.left != null && findPath(root.left, n, path)) { 
            return true; 
        } 
  
        if (root.right != null && findPath(root.right, n, path)) { 
            return true;  
        } 
  
        // If not present in subtree rooted with root, remove root from 
        // path[] and return false 
        path.remove(path.size()-1); 
  
        return false; 
        
    } 
    
    public static DagNode findLCADAG(DagNode head, DagNode nodeOne, DagNode nodeTwo) {
        DagNode LCA = null;
        ArrayList<DagNode> nodes = new ArrayList<>();
        addNodesToListDAG(nodes, head);
        boolean isAncestor[] = new boolean[nodes.size()];
        for (int i = 0; i < isAncestor.length; i++)
            isAncestor[i] = false;
        for (int i = 0; i < nodes.size(); i++) {
            if (checkIfAncestorDAG(nodes.get(i), nodeOne, nodeTwo)) {
                isAncestor[i] = true;
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            if(isAncestor[i])
                LCA = nodes.get(i);
        }
        return LCA;
    } 
    
    public static boolean checkIfAncestorDAG(DagNode node, DagNode nodeOne) {
        if (node == null)
            return false;
        if (node == nodeOne)
            return true;
        else {
            for (int i = 0; i < node.edges.size(); i++) {
                if (checkIfAncestorDAG(node.edges.get(i), nodeOne)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean checkIfAncestorDAG(DagNode node, DagNode nodeOne, DagNode nodeTwo) {
        if (checkIfAncestorDAG(node, nodeOne) && checkIfAncestorDAG(node, nodeTwo))
            return true;
        return false;
    }
    
    public static void addNodesToListDAG(ArrayList<DagNode> nodes, DagNode root) {
        if (root != null) {
            LinkedList<DagNode> queue = new LinkedList<>();
            queue.add(root);
            DagNode cur;
            while (queue.size() != 0) {
                cur = queue.get(0);
                for (int i = 0; i < cur.edges.size(); i++) {
                    queue.add(cur.edges.get(i));
                }
                nodes.add(cur);
                queue.remove(0);
            }
        }
    }
    
    public static class DagNode {
        int value;
        ArrayList<DagNode> edges;

        DagNode(int value)
        {
            this.value = value;
            edges = new ArrayList<>();
        }


} 
}
// This code is contributed by Sreenivasulu Rayanki. 
