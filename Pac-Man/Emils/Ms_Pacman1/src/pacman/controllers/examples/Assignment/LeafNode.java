package pacman.controllers.examples.Assignment;

public class LeafNode extends BTNode {
	
	public BTNode parent;
	BTState bTState; 
	//DataContext data;
	
	
	public LeafNode(BTState bTState)
	{
		this.bTState = bTState;
	}
	

	@Override
	public BTNode process() {
		// TODO Auto-generated method stub
		node_state = nodeState();
		return this;
		
	}

	public void addParent(BTNode current_node) {
		// TODO Auto-generated method stub
		this.parent = current_node;
	}
	
	@Override
	public RETURNVALUE nodeState()
	{
           return bTState.getProcess();	
        }
	
	@Override
	public void Reset()
	{
		this.current_node = null;
	}

}
