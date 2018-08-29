package pacman.controllers.examples.Assignment;

import java.util.ArrayList;

public class BTNode implements GenericBTNode{
	
	public ArrayList<BTNode> children = new ArrayList<BTNode>();
	public BTNode current_node;
        public RETURNVALUE node_state;
	public BTNode parent;
	DataContext data;
	
	@Override
	public BTNode process() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public RETURNVALUE nodeState()
	{
		return null;
	}
	
	public void Reset()
	{
		this.current_node = null;
	}

	public void addParent(BTNode current_node) {
		// TODO Auto-generated method stub
		this.parent = current_node;
	}

	public void addChild(BTNode child) {
		// TODO Auto-generated method stub
		children.add(child);
		child.addParent(this);
	}
	
	
}
