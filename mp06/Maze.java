package mp06;

import java.util.Stack;

public class Maze {

	/**
	 * Two dimensional array to represent a maze
	 */
	private char[][] maze;

	/**
	 * Constructor initializing the maze array
	 * 
	 * @param maze
	 */
	public Maze(char[][] maze) {
		this.maze = maze;
	}

	/**
	 * You need to implement this method
	 * 
	 * @param start:
	 *            The start Position in the maze
	 * @param goal:
	 *            The goal Position in the maze
	 * @return An array of Position which stores a solution to the maze. If a
	 *         solution is not found a null value should be returned.
	 */
	public Position[] traverse(Position start, Position goal) {
		//Check that goal and start are valid
		//check that maze != null
		if(validPosition(start) && validPosition(goal) && maze != null){
			Stack<Position> haveBeen = new Stack<Position>();
			haveBeen = traverse(start, goal, haveBeen);
			if (haveBeen != null) {
				return toArray(haveBeen);
			} else {
				return null;
			}
		}
		else {
			System.out.println("Invaid input");
			return null;
		}
	}

	private Stack<Position> traverse(Position curr, Position goal, Stack<Position> haveBeen) {
		do {
			if (curr.equals(goal)) {
				return haveBeen;
			}
			int row = curr.getRow();
			int col = curr.getColumn();
			maze[row][col] = 'x';
			if (col - 1 >= 0 && maze[row][col - 1] == ' ') {// left clear
				haveBeen.push(curr);
				curr = new Position(row, col - 1);
			} else if (col + 1 < maze[row].length && maze[row][col + 1] == ' ') {// right
				haveBeen.push(curr);
				curr = new Position(row, col + 1);
			} else if (row - 1 >= 0 && maze[row - 1][col] == ' ') {// top clear
				haveBeen.push(curr);
				curr = new Position(row - 1, col);
			} else if (row + 1 < maze.length && maze[row + 1][col] == ' ') {// bottom
				haveBeen.push(curr);
				curr = new Position(row + 1, col);
			} else {// backtrack
				maze[row][col] = 'b';
				if (haveBeen.empty()) {
					return null;
				}
				curr = haveBeen.pop();
			}
			// try{
			// Thread.sleep(500);
			// for(int i = 0; i < 50; i++){
			// System.out.println();
			// }
			// printMaze();
			// } catch(InterruptedException e){
			// System.out.print(e);
			// }
		} while (!haveBeen.isEmpty());
		return null;

	}

	private void printMaze() {
		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[r].length; c++) {
				System.out.print(maze[r][c]);
			}
			System.out.println();
		}
	}
	
	private boolean validPosition(Position p){
		if(p.getRow() >= maze.length || p.getRow() < 0 || p.getColumn() >= maze[p.getRow()].length  || p.getColumn() < 0){
			return false;
		}
		else{
			return true;
		}
	}

	public Position[] toArray(Stack<Position> stack) {
		Position[] arr = new Position[stack.size()];
		int i = stack.size() - 1;
		while (!stack.empty()) {
			arr[i] = stack.pop();
			i--;
		}
		return arr;
	}

}