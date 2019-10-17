import static org.junit.Assert.*;

import org.junit.Test;

public class CS3012test {

	@Test
	public void testOne() {
		CS3012 tree = new CS3012();
		tree.root = new Node(4); 
        tree.root.left = new Node(6); 
        tree.root.right = new Node(7);  
        /*							4
         * 						   / \
         * 						  6   7
         */
        assertEquals(tree.findLCA(6,7), 4); 
        assertEquals(tree.findLCA(6,4), 4);
	} 
	
	@Test
	public void testTwo() { 
		CS3012 tree = new CS3012();
		tree.root = new Node(4); 
		
        tree.root.left = new Node(6); 
        tree.root.right = new Node(7); 
       
        tree.root.left.left = new Node(8); 
        tree.root.left.right = new Node(9); 
        
        tree.root.right.left = new Node(3);  
        tree.root.right.right = new Node(2); 
        /*							4
         * 						/		\
         * 					6				7
         * 				/		\		/		\
         * 				8		9		3		2
         */
        assertEquals(tree.findLCA(3,2), 7); 
        assertEquals(tree.findLCA(8,9), 6);
        assertEquals(tree.findLCA(8,2), 4);
        assertEquals(tree.findLCA(7,2), 7);
        assertEquals(tree.findLCA(8,6), 6);
        assertEquals(tree.findLCA(6,7), 4);
	}
	@Test
	public void testThree() {
		CS3012 tree = new CS3012();
 		tree.root = new Node(4); 
		
        tree.root.left = new Node(6);  
        tree.root.right = new Node(7); 
       
        tree.root.left.left = new Node(8); 
        tree.root.left.right = new Node(9);  
        
        tree.root.right.left = new Node(3);  
        tree.root.right.right = new Node(2); 
        
        tree.root.left.left.left = new Node(1);  
        tree.root.left.left.right = new Node(5);
        
        tree.root.left.right.left = new Node(11); 
        tree.root.left.right.right = new Node(14);

        tree.root.right.left.left = new Node(13); 
        tree.root.right.left.right = new Node(10);
        
        tree.root.right.right.left = new Node(12); 
        tree.root.right.right.right = new Node(15);
     
        /*							4
         * 					/				\
         * 				6						7
         * 			/		\				/		\
         * 		8			9				3			2
         * 	/		\	/		\		/		\	/		\
         * 1		5	11		14		13		10	12		15
         */
        
        assertEquals(tree.findLCA(1,5), 8);
        assertEquals(tree.findLCA(11,14), 9);
        assertEquals(tree.findLCA(13,10), 3);
        assertEquals(tree.findLCA(12,15), 2);
        assertEquals(tree.findLCA(5,8), 8);
        assertEquals(tree.findLCA(11,9), 9);
        assertEquals(tree.findLCA(13,2), 7);
        assertEquals(tree.findLCA(12,2), 2);
        assertEquals(tree.findLCA(7,5), 4);
        assertEquals(tree.findLCA(12,4), 4);
     
	}
	@Test
	public void testNeg() { 
		CS3012 tree = new CS3012();
		tree.root = new Node(-4); 
		
        tree.root.left = new Node(-6); 
        tree.root.right = new Node(-7); 
       
        tree.root.left.left = new Node(-8); 
        tree.root.left.right = new Node(-9); 
        
        tree.root.right.left = new Node(-3);  
        tree.root.right.right = new Node(-2);  
        /*							-4
         * 						/		\
         * 					-6				-7
         * 				/		\		/		\
         * 				-8		-9		-3		-2
         */
        assertEquals(tree.findLCA(-3,-2), -7); 
        assertEquals(tree.findLCA(-8,-9), -6);
        assertEquals(tree.findLCA(-8,-2), -4);
        assertEquals(tree.findLCA(-7,-2), -7);
        assertEquals(tree.findLCA(-8,-6), -6);
        assertEquals(tree.findLCA(-6,-7), -4);
	}
	@Test
	public void testNull() { 
		CS3012 tree = new CS3012();
		tree.root = null; 
		assertEquals(tree.findLCA(null, null), -1);  
	} 

	
	@Test 
    public void rootDAGTest() { 
        CS3012.DagNode root = new CS3012.DagNode(1);
        CS3012.DagNode node2 = new CS3012.DagNode(2); 
        CS3012.DagNode node3 = new CS3012.DagNode(3);
        CS3012.DagNode node4 = new CS3012.DagNode(4); 
        CS3012.DagNode node5 = new CS3012.DagNode(5);
        root.edges.add(node2);
        root.edges.add(node3);
        root.edges.add(node3);
        root.edges.add(node4);
        root.edges.add(node5);
        //only root is connected so root will be the answer for all tests
        assertEquals(CS3012.findLCADAG(root, node2, node3), root);
        assertEquals(CS3012.findLCADAG(root, node2, node5), root);
        assertEquals(CS3012.findLCADAG(root, node4, node3), root);
    }
	
	@Test
    public void simpleDAGTest() { 
        CS3012.DagNode root = new CS3012.DagNode(1);
        CS3012.DagNode node2 = new CS3012.DagNode(2); 
        CS3012.DagNode node3 = new CS3012.DagNode(3);
        CS3012.DagNode node4 = new CS3012.DagNode(4); 
        CS3012.DagNode node5 = new CS3012.DagNode(5);
        
        root.edges.add(node2);
        root.edges.add(node3);
        node2.edges.add(node3);
        node2.edges.add(node4);
        node3.edges.add(node5);   
        /*
         * 			1
         * 			|		
         * 			2
         * 		   / \
         *		  3   4
         *		  |
         *		  5 
         *
         */
        assertEquals(CS3012.findLCADAG(root, node2, node3), node2);
        assertEquals(CS3012.findLCADAG(root, node2, node5), node2); 
        assertEquals(CS3012.findLCADAG(root, node4, node3), node2); 
    }


	@Test
    public void largeDAGTest() { 
        CS3012.DagNode root = new CS3012.DagNode(1);
        CS3012.DagNode node2 = new CS3012.DagNode(2); 
        CS3012.DagNode node3 = new CS3012.DagNode(3);
        CS3012.DagNode node4 = new CS3012.DagNode(4); 
        CS3012.DagNode node5 = new CS3012.DagNode(5);
        CS3012.DagNode node6 = new CS3012.DagNode(6);
        CS3012.DagNode node7 = new CS3012.DagNode(7);
        CS3012.DagNode node8 = new CS3012.DagNode(8);
        CS3012.DagNode node9 = new CS3012.DagNode(9);
        CS3012.DagNode node10 = new CS3012.DagNode(10);
        
        root.edges.add(node2);
        root.edges.add(node4);
        node2.edges.add(node3);
        node3.edges.add(node5);
        node3.edges.add(node6);
        node4.edges.add(node7);
        node7.edges.add(node8); 
        node7.edges.add(node9); 
        node8.edges.add(node10); 
        node9.edges.add(node10); 
        
        assertEquals(CS3012.findLCADAG(root, node2, node4), root);  
        assertEquals(CS3012.findLCADAG(root, node8, node7), node7);  
        assertEquals(CS3012.findLCADAG(root, node3, node8), root);
        assertEquals(CS3012.findLCADAG(root, node3, node6), node3);
        assertEquals(CS3012.findLCADAG(root, node5, node6), node3);
        assertEquals(CS3012.findLCADAG(root, node7, node4), node4);
        assertEquals(CS3012.findLCADAG(root, node10, node9), node9); 
        assertEquals(CS3012.findLCADAG(root, node8, node9), node7);
	}
	
	@Test
    public void slidesDAGTest() { 
        CS3012.DagNode node1 = new CS3012.DagNode(1);
        CS3012.DagNode node2 = new CS3012.DagNode(2); 
        CS3012.DagNode node3 = new CS3012.DagNode(3);
        CS3012.DagNode node4 = new CS3012.DagNode(4); 
        CS3012.DagNode node5 = new CS3012.DagNode(5);
        CS3012.DagNode node6 = new CS3012.DagNode(6);
        CS3012.DagNode node7 = new CS3012.DagNode(7);
        
        node7.edges.add(node4);
        node7.edges.add(node6);
        node4.edges.add(node3);
        node3.edges.add(node2);
        node2.edges.add(node1);
        node6.edges.add(node5);
        node5.edges.add(node2);
        
        assertEquals(CS3012.findLCADAG(node7, node2, node5), node5);
        assertEquals(CS3012.findLCADAG(node7, node4, node5), node7);  
        assertEquals(CS3012.findLCADAG(node7, node4, node4), node4); 
        
	}
	 

}









