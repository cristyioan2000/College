
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class container {
	private int[][] paths;
	public void run_env() {
		// TODO Auto-generated method stub
		environment envObject = new environment();
		int num_paths = 3;
		int keys_doors = 18;
		int path_len = 20;
		boolean display = false;
		paths = envObject.gen_env(num_paths,keys_doors,path_len,display);
	};
	public int[][] get_env(){
		return paths;

	}

}
