import org.junit.Test;
import static org.junit.Assert.*;

public class DAGTest
{

	@Test
	public void Test(){

		DAG newGraph = new DAG();
		newGraph.root = new Nodes(1);
		Nodes two = new Nodes(2);
		Nodes three = new Nodes(3);
		Nodes four = new Nodes(4);
		Nodes five = new Nodes(5);
		Nodes six = new Nodes(6);
		Nodes seven = new Nodes(7);


		Nodes[] rootChildren = { two, three, four, five, six, seven};

		Nodes[] node2Children = {four};
		Nodes[] node2Parent = {newGraph.root};

		Nodes[] node3Children = {five};
		Nodes[] node3Parent = {newGraph.root};

		Nodes[] node4Children = {six};
		Nodes[] node4Parent = {newGraph.root, two};

		Nodes[] node5Children = {six};
		Nodes[] node5Parent = {newGraph.root, three};

		Nodes[] node6Children = {seven};
		Nodes[] node6Parent = {two, three, four, five};

		Nodes[] node7Parent = { four, five, six};

		//add children nodes
		newGraph.addChild(newGraph.root, rootChildren);
		newGraph.addChild(two, node2Children);
		newGraph.addChild(three, node3Children);
		newGraph.addChild(four, node4Children);
		newGraph.addChild(five, node5Children);
		newGraph.addChild(six, node6Children);		
		//add parent nodes
		newGraph.addParent(two, node2Parent);
		newGraph.addParent(three, node3Parent);
		newGraph.addParent(four, node4Parent);
		newGraph.addParent(five, node5Parent);
		newGraph.addParent(six, node6Parent);
		newGraph.addParent(seven, node7Parent);

		//Tests
		assertEquals("", 1, newGraph.LCA(newGraph.root, two));
		assertEquals("", 1, newGraph.LCA(two, three));
		assertEquals("", 1, newGraph.LCA(three, four));
		assertEquals("", 1, newGraph.LCA(four, five));
		assertEquals("", 3, newGraph.LCA(five, six));
		assertEquals("", 5, newGraph.LCA(six, seven));

	}

}