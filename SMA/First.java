import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;


public class First extends Agent{
	

	protected void setup() {
		
		GeneratorAgent env = new GeneratorAgent();
//		int paths [][] = env.paths;
		
		addBehaviour(new CyclicBehaviour(this) {

			@Override
			public void action() {
					
				// Sync Messages
						ACLMessage msg = receive();
						if(msg!=null) {
							System.out.println("Agent_1 Path:");
							System.out.println(msg.getContent());
//							for(int step = 0;step<18;step++) {
//								System.out.println("==================");
//								System.out.println("I'm agent 1 and this is my path:");
//								System.out.println(env.paths[0][step]);
//							}
						
						block();
						}
						else {block();}
				
			}
		});
	}
	


}
