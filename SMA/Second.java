import jade.core.Agent;


import javax.swing.JOptionPane;

import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class Second extends Agent {
	
	@Override
	protected void setup() {
		addBehaviour(new CyclicBehaviour() {		
			@Override
			public void action() {
				ACLMessage msg = receive();
				if(msg!=null) {
					JOptionPane.showMessageDialog(null,msg.getContent());
				}
				else block();
				
			}
		});
	}
}
