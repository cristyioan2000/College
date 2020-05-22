import jade.core.Agent;


import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class GeneratorAgent extends Agent {
	public int paths[][];
	@Override
	// Generate Path and sync the other agents 
	protected void setup() {
		addBehaviour(new CyclicBehaviour() {		
			@Override
			public void action() {
				container container_object = new container();
				container_object.run_env();
				paths = container_object.get_env();
				// Sync Messages
				ACLMessage msg_1 = new ACLMessage(ACLMessage.INFORM);              
				ACLMessage msg_2 = new ACLMessage(ACLMessage.INFORM);
				ACLMessage msg_3 = new ACLMessage(ACLMessage.INFORM);

				// Agent 1
				String  content =  Arrays.toString(paths[0]);
				msg_1.setContent(content);
				msg_1.addReceiver(new AID("first",AID.ISLOCALNAME));
				send(msg_1);


				
				// Agent 2
				String  content_2 =  Arrays.toString(paths[1]);
				msg_2.setContent(content_2);
				msg_2.addReceiver(new AID("second",AID.ISLOCALNAME));
				send(msg_2);

				// Agent 3
				String  content_3 =  Arrays.toString(paths[2]);
				msg_3.addReceiver(new AID("third",AID.ISLOCALNAME));
				msg_3.setContent(content_3);
				send(msg_3);
				done();
				block();
				

			}
		});
	}
	public int [][] get_path(){
		return paths;
	}
}

