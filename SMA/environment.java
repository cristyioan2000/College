import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.Random;

public class environment {
	// 	Main Environment Class	 
	
	public int[][] create_paths(int num_paths,int keys_doors,int path_len,boolean display) {
		Random random = new Random();

		// Create a given number of paths with a given number of steps
		// [ path_1,path_2,path_3]
		// [0 ,0, 0, 0, 0, 0, 1] - steps
		int[][] paths = new int[num_paths][path_len];
		
		// Doors and keys buffer
		int[] doors = new int[keys_doors];
		int[] keys = new int[keys_doors];
		
		// Generate keys and Assign doors to each agent
		// Door == 1
		// Key == -1
		for (int i = 1; i < keys_doors+1; i++) {
			doors[i-1] = i;
			keys[i-1] = -i;
		 }

		// Fill the paths with the step value 0
		for (int i = 0; i < num_paths; i++) {
			Arrays.fill(paths[i], 0);
			 }
		
		// Current Key index
		int key_index = 0;
		
		
		// For the first part assign a door for the first path and the key for that door to the second path
		for(int key = 0; key<keys_doors/num_paths;key++) {
			int random_position = random.nextInt(path_len);
			paths[0][random_position] = doors[key_index];
			paths[1][random_position] = keys[key_index];
			key_index++;
		}
		
		int stop_condition = 0;
		// For the second phase, each step of a path
		for(int step = 0; step<path_len;step++) {
				// If on the same position of both paths the step value is 0
				if (paths[0][step] == 0  && paths[1][step] == 0) {
					// Place Key/door
					paths[0][step] = keys[key_index];
					paths[1][step] = doors[key_index];
					key_index++;
					stop_condition++;
				} 
				if(stop_condition == keys_doors/num_paths) {
					break;
				}
		}
		int last_stop_condition = 0;
		// For the second phase, each step of a path
		for(int step = 0; step<path_len;step++) {
				// If on the same position of both paths the step value is 0
				if (paths[2][step] == 0  && paths[1][step] == 0) {
					// Place Key/door
					paths[1][step] = keys[key_index];
					paths[2][step] = doors[key_index];
					key_index++;
					last_stop_condition++;
				} 
				if(last_stop_condition == keys_doors/num_paths) {
					break;
				}
		}


		if (display) {
			for(int agent = 0;agent<num_paths;agent++) {
				System.out.println("----PATH "+ agent + "----");
				for(int a = 0;a<path_len;a++) {
						System.out.println(paths[agent][a]);
				}
			}
		}
		return paths;	
		

	}
	public int[][] gen_env(int num_paths,int keys_doors,int path_len,boolean display) {
		/*
			Generates the whole envirnoment 
			Arguments:
			 - (int) num_paths_to_generate -> the number of num_paths_to_generate roads (must be equal with the number of agents)
			 - (int) key_doors_pairs -> the number of keys and doors that will be set in the path_list, Ex key_doors_pairs = 6 -> 6 keys and 6 doors 
			 - (int) path_length -> the length of each path, the path is measured in steps, this arguments sets the step numbers of a path 
			 - (boolean) display -> Display the paths 
		*/

		// Creating Paths
		int[][] paths = create_paths(num_paths,keys_doors,path_len,display);
		
		
		return paths;
	}
}
