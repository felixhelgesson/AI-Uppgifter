package pacman.controllers.examples.Assignment;

public class Sequence extends BTNode {
	
	RETURNVALUE tempReturn1, tempReturn2;
	public Sequence()
	{
		
	}
	
	public BTNode GoThroughChildren()
	{
		for(int i =0; i < children.size(); i++)
		{
			current_node = children.get(i).process();
			if(current_node.nodeState() == RETURNVALUE.FAILURE)
			{
		             return current_node;
			}
			
			if(current_node.nodeState() == RETURNVALUE.RUNNING)
			{
		             return current_node;
						
			}
															
		}
                
                
		return current_node;
	}
	
	@Override
	public BTNode process()
	{
                
           return GoThroughChildren();
		
	}
	
	@Override
	public RETURNVALUE nodeState()
	{
		return this.current_node.nodeState();
	}
	
	
	

	
}
