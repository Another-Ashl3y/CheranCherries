package cheran;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		try {
			File f = new File("C:/Users/chris/Documents/cheran/cheran/cheran/src/cheran/test.cherry");
			Scanner reader = new Scanner(f);
			
			String data = "";
			while (reader.hasNextLine()) {
				data += "\n"+reader.nextLine();
			}
			
			boolean running = true;
			int current_line = 0;
			float[] memory = new float[1024];
			String[] operations;
			String[] operation;
			String operator;
			int p;
			int q;
			int u;
			int v;
			
			operations = data.split("\n");

			while (running) {
				operation = operations[current_line].split(" ");
				operator = operation[0];
				switch(operator) {
					case "END":
						running = false;
						break;
					case "GOTO":
						current_line = Integer.valueOf(operation[1])-1;
						break;
					case "SKP":
						p = Integer.valueOf(operation[1]);
						if (memory[p] > 0) {
							current_line += 1;
						}
						break;
					case "OUT":
						p = Integer.valueOf(operation[1]);
						System.out.println(memory[p]);
						break;
					case "STO":
						p = Integer.valueOf(operation[1]);
						v = Integer.valueOf(operation[2]);
						memory[p] = v;
						break;
					case "INC":
						p = Integer.valueOf(operation[1]);
						memory[p] = memory[p] + 1;
						break;
					case "DEC":
						p = Integer.valueOf(operation[1]);
						memory[p] = memory[p] - 1;
						break;
					case "ADD":
						p = Integer.valueOf(operation[1]);
						q = Integer.valueOf(operation[2]);
						u = Integer.valueOf(operation[3]);
						memory[u] = memory[p] + memory[q];
						break;
					case "SUB":
						p = Integer.valueOf(operation[1]);
						q = Integer.valueOf(operation[2]);
						u = Integer.valueOf(operation[3]);
						memory[u] = memory[p] - memory[q];
						break;
					case "MUL":
						p = Integer.valueOf(operation[1]);
						q = Integer.valueOf(operation[2]);
						u = Integer.valueOf(operation[3]);
						memory[u] = memory[p] * memory[q];
						break;
					case "DIV":
						p = Integer.valueOf(operation[1]);
						q = Integer.valueOf(operation[2]);
						u = Integer.valueOf(operation[3]);
						memory[u] = memory[p] / memory[q];
						break;
					case "BIG":
						p = Integer.valueOf(operation[1]);
						q = Integer.valueOf(operation[2]);
						u = Integer.valueOf(operation[3]);
						if (memory[p] > memory[q]) {
							memory[u] = 1;
						} else {
							memory[u] = 0;
						}
						break;
					case "SMA":
						p = Integer.valueOf(operation[1]);
						q = Integer.valueOf(operation[2]);
						u = Integer.valueOf(operation[3]);
						if (memory[p] < memory[q]) {
							memory[u] = 1;
						} else {
							memory[u] = 0;
						}
						break;
					case "EQU":
						p = Integer.valueOf(operation[1]);
						q = Integer.valueOf(operation[2]);
						u = Integer.valueOf(operation[3]);
						if (memory[p] == memory[q]) {
							memory[u] = 1;
						} else {
							memory[u] = 0;
						}
						break;
					case "NOT":
						p = Integer.valueOf(operation[1]);
						q = Integer.valueOf(operation[2]);
						if (memory[p] == 0) {
							memory[q] = 1;
						} else {
							memory[q] = 0;
						}
						break;
					case "RND":
						p = Integer.valueOf(operation[1]);
						memory[p] = Math.round(memory[p]);
						break;
						
				}
				current_line += 1;
				
				
				
			}
			
			
			
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		    e.printStackTrace();
		}

	}
	
	public static int[] append_int(int[] old, int x) {
		int[] new_list = new int[old.length+1];
		for (int i = 0; i < old.length; i++) {
			new_list[i] = old[i];
		}
		new_list[old.length+1] = x;
		return new_list;
	}

}
