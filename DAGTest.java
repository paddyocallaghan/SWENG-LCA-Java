import org.junit.Test;
import static org.junit.Assert.*;

public class DAGTest
{

	@Test
	public void Test(){


		DAG graph = new DAG();
		graph.root = new Nodes(1);

		Nodes one,two,three,four,five,six,seven;
		one = graph.root;
		two = new Nodes(2);
		three = new Nodes(3);
		four = new Nodes(4);
		five = new Nodes(5);
		six = new Nodes(6);
		seven = new Nodes(7);


		Nodes[] nodeOneChildren = {two,three};

		Nodes[] node2Children = {four};
		Nodes[] node2Parent = {one};

		Nodes[] node3Children = {four,seven};
		Nodes[] node3Parent = {one};

		Nodes[] node4Children = {five};
		Nodes[] node4Parent = {two,three};

		Nodes[] node5Children = {six,seven};
		Nodes[] node5Parent = {four};

		Nodes[] node6Parent = {five};
		Nodes[] node7Parent = {three,five};

		//add children nodes
		graph.addChild(one, nodeOneChildren);
		graph.addChild(two, node2Children);
		graph.addChild(three, node3Children);
		graph.addChild(four, node4Children);
		graph.addChild(five, node5Children);

		//add parent nodes
		graph.addParent(two, node2Parent);
		graph.addParent(three, node3Parent);
		graph.addParent(four, node4Parent);
		graph.addParent(five, node5Parent);
		graph.addParent(six, node6Parent);
		graph.addParent(seven, node7Parent);


		assertEquals("", 1, graph.dagLCA(one, two));
		assertEquals("", 3, graph.dagLCA(four,seven));
		assertEquals("", 5, graph.dagLCA(six,seven));
		assertEquals("", 2, graph.dagLCA(five,two));
		assertEquals("", 4, graph.dagLCA(six,four));
		assertEquals("", 5, graph.dagLCA(five,five));

	}

}