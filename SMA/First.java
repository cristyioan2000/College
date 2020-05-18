import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;



public class First extends Agent{
	
	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			int a[] = {0,1,2,3};
			@Override
			public void action() {
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.setContent(a);
				msg.addReceiver(new AID("second",AID.ISLOCALNAME));
				send(msg);
			}
		});
	}
	


}
