import jade.core.Agent;


import javax.swing.JOptionPane;

import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class Third extends Agent {
	
	container env = new container();
//	int [][] paths = env.paths;
	
	@Override
	protected void setup() {
		addBehaviour(new CyclicBehaviour() {		
			@Override
			public void action() {
				ACLMessage msg = receive();
				if(msg!=null) {
					System.out.println("Agent_3 Path:");
					System.out.println(msg.getContent());

					block();
				}
				else {
					block();
				}
				
			}
		});
	}
}
