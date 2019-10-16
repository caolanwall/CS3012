import static org.junit.Assert.*;

import org.junit.Test;

public class CS3012test {

	@Test
	public void testOne() {
		CS3012 tree = new CS3012();
		tree.root = new Node(4); 
        tree.root.left = new Node(6); 
        tree.root.right = new Node(7); 
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
        
        
        assertEquals(tree.findLCA(3,2), 7); 
        assertEquals(tree.findLCA(8,9), 6);
        assertEquals(tree.findLCA(8,2), 4);
        assertEquals(tree.findLCA(7,2), 7);
        assertEquals(tree.findLCA(8,6), 6);
        assertEquals(tree.findLCA(6,7), 4);
	}
    
}
