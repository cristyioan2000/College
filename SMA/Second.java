import java.util.List;
import java.util.ArrayList;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
//import jade.util.leap.ArrayList;

// First Agent
public class Second extends Agent {
	// The path with all the steps 
	String paths;
	String[] final_path;
	int[] final_list = new int[20];
	
	// Found keys
	String[] found_keys;
	List mylist = new ArrayList();
	
	// Implementing the behaviour of the first agent
	// Recieving the Path from the GeneratorAgent 
	// 
	@Override
	protected void setup() {
		addBehaviour(new CyclicBehaviour() {		
			@Override
			public void action() {
				ACLMessage msg = receive();
				if(msg!=null) {
					paths = msg.getContent();
					System.out.println("Agent_2 Path:"+paths);
					
					// Formating the paths
					System.out.println("Start walking..");
					String aux_path = paths.replace("[", "");
					String final_aux_path = aux_path.replace("]", "");
					final_path = final_aux_path.split(",");
					
					

//					System.out.println(final_path.length);
					done();
				}
				else {
					block();
				}
			}
		});
		
		// Stepping 
		addBehaviour(new CyclicBehaviour() {		
			@Override
			public void action() {
				if(paths!=null) {
					for(int i = 0; i< 20; i++) {
//						final_list[i] = Integer.parseInt(final_path[i]);
						
						// Free
						if(final_path[i].equals(" 0")) {
//							System.out.println("Free setp");
//							System.out.println(final_path[i]);
						}
						// Found Key
						if(final_path[i].contains("-")) {
//							System.out.println("Found key");
							mylist.add(final_path[i]);
//							System.out.println(mylist.contains(final_path[i]));
						}
						// Found Door Ask for key to the other agents
						else {
							// Set content with the name of the needed key
							ACLMessage msg_1 = new ACLMessage(ACLMessage.INFORM);
							String content_1 = final_path[i];
							msg_1.setContent(content_1);
							msg_1.addReceiver(new AID("second",AID.ISLOCALNAME));
							
							ACLMessage msg_2 = new ACLMessage(ACLMessage.INFORM);
							String content_2 = final_path[i];
							msg_2.setContent(content_1);
							msg_2.addReceiver(new AID("third",AID.ISLOCALNAME));
							
							// Send message to Agent_1
							send(msg_1);
							
							// Send message to Agent_2
							send(msg_2);

						}
//						System.out.println(final_path[i]);
					}
//					System.out.println(final_list);
//					System.out.println(lst.get(0));
					block();
				}
			}
		});
		
	}
	
}
