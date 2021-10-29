import java.util.*;

class Nodes
{

	int value;
	Nodes[] parent;
	Nodes[] child;

	//initialise node
	public Nodes(int data)
	{
		value = data;
		parent = null;
		child = null;
	}

}

public class DAG
{
	//initialise root node
	Nodes root;

	void addParent(Nodes node, Nodes[] parent)
	{
		node.parent = parent;
	}
	
	void addChild(Nodes node, Nodes[] child)
	{
		node.child = child;
	}
	

	public int LCA(Nodes node1, Nodes node2)
	{
		return LCA(root, node1, node2);
	}

	public int LCA(Nodes root, Nodes node1, Nodes node2)
	{
		//check if root is null
		if(root == null)
		{
			return -1;
		}

		if((root.value == node1.value) || (root.value == node2.value))
		{
			return root.value;
		}
		if(node1.value == node2.value)
		{
			return node1.value;
		}
		
		ArrayList<Integer> lowestCommonAncestor = new ArrayList<Integer>();
		int i = 0;
		while(i<node1.parent.length)
		{
			int j= 0;
			while(j<node2.parent.length)
			{
				if(node1.parent[i].value == node2.parent[j].value)
				{
					lowestCommonAncestor.add(node1.parent[i].value);
					
					j++;
				}
				else
				{
					j++;
				}
			}
			i++;
		}
		if(lowestCommonAncestor.size()==0){
			if(node1.value > node2.value){
				lowestCommonAncestor.add(LCA(root, node1.parent[0], node2));
			}
			else{
				lowestCommonAncestor.add(LCA(root, node1, node2.parent[0]));
			}
		}

		return Collections.max(lowestCommonAncestor);
	}
}