package cheran;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class runner {
	float[] memory;
	runner(int size) {
		memory = new float[size];
	}
	
	public void run(String path) {
		try {
			File f = new File(path);
			Scanner reader = new Scanner(f);
			
			String data = "";
			while (reader.hasNextLine()) {
				data += "\n"+reader.nextLine();
			}
			
			boolean running = true;
			int current_line = 0;
			int current_file = 0;
			int[] lines = new int[0];
			float[] memory = new float[1024];
			String[] operations;
			String[] operation;
			String[] chars = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", " "};
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
						p = Integer.valueOf(operation[1]);
						current_line = (int) (memory[p]-1);
						break;
					case "SKP":
						p = Integer.valueOf(operation[1]);
						q = Integer.valueOf(operation[2]);
						if (memory[p] > 0) {
							current_line += q;
						}
						break;
					case "PRN":
						p = Integer.valueOf(operation[1]);
						System.out.print(memory[p]);
						break;
					case "PRL":
						p = Integer.valueOf(operation[1]);
						System.out.println(memory[p]);
						break;
					case "PRNC":
						p = Integer.valueOf(operation[1]);
						System.out.print(chars[(int) memory[p]]);
						break;
					case "PRLC":
						p = Integer.valueOf(operation[1]);
						System.out.println(chars[(int) memory[p]]);
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
					case "MOD":
						p = Integer.valueOf(operation[1]);
						q = Integer.valueOf(operation[2]);
						u = Integer.valueOf(operation[3]);
						memory[u] = memory[p] % memory[q];
						
					case "RND":
						p = Integer.valueOf(operation[1]);
						memory[p] = Math.round(memory[p]);
						break;
					case "SYSTEM":
						String next_path = operation[1];
						this.run(next_path);
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
}
