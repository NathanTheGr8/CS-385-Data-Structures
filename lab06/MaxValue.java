package lab06;

import java.util.Scanner;

public class MaxValue {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Scanner input = new Scanner(System.in);
		
		boolean keepGoing = true;
		int command;
		while(keepGoing){
			System.out.print("Command: ");
			command = input.nextInt();
			switch(command){
				case 1:
					Integer elem = input.nextInt();
					System.out.printf("Pushing %d to the stack\n", elem);
					stack.push(elem);
					break;
				case 2:
					Integer topValue = stack.pop();
					System.out.printf("Popping %d off the top of the stack\n", topValue);
					break;
				case 3:
					Integer maxValue = stack.getMaxVal();
					System.out.printf("The maximum element is %d\n", maxValue);
					break;
				default:
					keepGoing = false;
			}
			input.nextLine();
		}
		System.out.println("Exitting...");
		input.close();
	}

}
