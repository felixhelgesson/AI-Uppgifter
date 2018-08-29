package pacman.controllers.examples.Assignment;

public class Selector extends BTNode {
	
	RETURNVALUE tempRet, tempRet2;

	public Selector()
	{
		
	}
	
	public RETURNVALUE GoThroughChildren()
	{
		for(int i =0; i < children.size(); i++)
		{
			//tempRet = children.get(i).process();
			if(tempRet == RETURNVALUE.SUCCESS)
			{
				return RETURNVALUE.SUCCESS;
			}
			
			if(tempRet == RETURNVALUE.RUNNING)
			{
				this.current_node = children.get(i).current_node;
				return RETURNVALUE.RUNNING;
			}
			
					
		}
				
		return RETURNVALUE.FAILURE;
	}
	
	@Override 
	public BTNode process()
	{
		return null;
		
	}
	
	@Override
	public RETURNVALUE nodeState()
	{
		return null;
	}
	
	

}
