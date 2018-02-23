package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import linkedList_implementation.SingleLinkedList;
import queue.QueueLinkedListBased;

/**
 *
 * @author SheifShahin
 *
 */
public class MazeClass implements
		/**
						 *
						 */
		IMazeSolver {
	/**
		 *
		 */
	private final RuntimeException fileExeption = new RuntimeException("An Error Occured on openning the file");
	/**
		 *
		 */
	private final RuntimeException ex = new RuntimeException("ErrorX at Run Time Maze Class");
	/**
		 *
		 */
	private final RuntimeException ex00 = new RuntimeException("Error00 at Run Time Maze Class");
	/**
		 *
		 */
	private final RuntimeException ex0 = new RuntimeException("Error0 at Run Time Maze Class");
	/**
		 *
		 */
	private final RuntimeException ex1 = new RuntimeException("Error1 at Run Time Maze Class");
	/**
		 *
		 */
	private final RuntimeException ex2 = new RuntimeException("Error2 at Run Time Maze Class");
	/**
		 *
		 */
	private final RuntimeException ex3 = new RuntimeException("Error3 at Run Time Maze Class");
	/**
		 *
		 */
	private final RuntimeException ex4 = new RuntimeException("Error4 at Run Time Maze Class");
	/**
		 *
		 */
	private boolean[][] boolArr;
	/**
		 *
		 */
	private final int fiveH = 500;
	/**
	 *
	 */
	private final int[][] visited = new int[fiveH][2];
	/**
		 *
		 */
	private int[][] bfs;
	/**
		 *
		 */
	private int[][] dfs;
	/**
		 *
		 */
	private int count = 0;
	/**
		 *
		 */
	private int xExit = -1, yExit = -1;
	/**
		 *
		 */
	private int xExit2 = -1, yExit2 = -1;
	/**
		 *
		 */
	private boolean fIrIsT = true;
	/**
		 *
		 */
	private boolean source = false;
	/**
		 *
		 */
	private boolean exit = false;
	/**
		 *
		 */
	private int fsCounter;

	/**
	 * Read the maze file, and solve it using Breadth First Search.
	 *
	 * @param maze
	 *            maze file inclusive, or null if no path found. coordinates
	 *            indexes are zero based.
	 */
	
	public int[][] solveBFS(final File maze) {
		fsCounter = 0;
		char[][] mazeArr = null;
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = -1;
			}
		}
		try {
			final FileInputStream f = new FileInputStream(maze);
			final BufferedReader file = new BufferedReader(new InputStreamReader(f));
			String strLine;
			boolean first = true;
			int lines = 0;
			int xSource = 0;
			int ySource = 0;
			if (f.available() == 0) {
				throw ex;
			}
			int counter = 0;
			int raws = -1;
			int cols = -1;
			int lineCounter = 0;
			while ((strLine = file.readLine()) != null) {
				/**
				 * if (first): to determine the raws and columns of the maze
				 * array .
				 */
				if (first) {
					strLine = strLine.trim();
					strLine = strLine + " ";

					boolean firstNum = true;
					boolean secondNum = true;
					String num = "";
					for (int i = 0; i < strLine.length(); i++) {
						if (firstNum) {
							final char currentChar = strLine.charAt(i);
							if (currentChar != ' ' && isInteger(currentChar)) {
								num = num.concat(String.valueOf(currentChar));
								continue;
							}
							raws = Integer.parseInt(num);
							num = "";
							firstNum = false;
						} else if (secondNum && !firstNum) {
							final char currentChar = strLine.charAt(i);
							if (currentChar != ' ' && isInteger(currentChar)) {
								num = num.concat(String.valueOf(currentChar));
								continue;
							}
							cols = Integer.parseInt(num);
							secondNum = false;
						} else {
							counter++;
						}
					}
					if (counter != 0 || raws < 0 || cols < 0) {
						throw ex0;
					}
					mazeArr = new char[raws][cols];
					boolArr = new boolean[raws][cols];
					first = false;
					continue;
				} // EndFirst

				if (strLine.trim().length() != cols) {
					throw ex1;
				}
				lineCounter++;
				strLine = strLine.trim();
				for (int i = 0; i < strLine.length(); i++) {
					if (strLine.charAt(i) != ' ') {
						mazeArr[lines][i] = strLine.charAt(i);
						if (strLine.charAt(i) == 'S') {
							source = true;
							boolArr[lines][i] = true;
							xSource = lines;
							ySource = i;
						} else if (strLine.charAt(i) == 'E') {
							exit = true;
							if (fIrIsT) {
								xExit = lines;
								yExit = i;
								boolArr[lines][i] = true;
								fIrIsT = false;
							} else {
								xExit2 = lines;
								yExit2 = i;
								boolArr[lines][i] = true;
								fIrIsT = false;
							}
						} else if (strLine.charAt(i) == '.') {
							boolArr[lines][i] = true;
						} else {
							boolArr[lines][i] = false;
						}
					}
				}

				lines++;
			} // End While

			if (lineCounter != raws || !exit || !source) {
				throw ex2;
			}
			final QueueLinkedListBased q = new QueueLinkedListBased();
			new SingleLinkedList();
			new SingleLinkedList();

			final Node s = new Node();
			s.parent = null;
			s.xCoor = xSource;
			s.yCoor = ySource;
			q.enqueue(s);
			Node u = new Node();

			while (q != null) {
				if (q.size() == 0) {
					return null;
				}
				u = (Node) q.dequeue();
				if (u.xCoor == xExit && u.yCoor == yExit) {
					break;
				} else if (u.xCoor == xExit2 && u.yCoor == yExit2) {
					break;
				}
				final Node v1 = new Node();
				v1.xCoor = u.xCoor;
				v1.yCoor = u.yCoor + 1;
				if (isValid(v1.xCoor, v1.yCoor)) {
					v1.parent = u;
					q.enqueue(v1);
				}

				final Node v2 = new Node();
				v2.xCoor = u.xCoor + 1;
				v2.yCoor = u.yCoor;
				if (isValid(v2.xCoor, v2.yCoor)) {
					v2.parent = u;
					q.enqueue(v2);
				}

				final Node v3 = new Node();
				v3.xCoor = u.xCoor;
				v3.yCoor = u.yCoor - 1;
				if (isValid(v3.xCoor, v3.yCoor)) {
					v3.parent = u;
					q.enqueue(v3);
				}
				final Node v4 = new Node();
				v4.xCoor = u.xCoor - 1;
				v4.yCoor = u.yCoor;
				if (isValid(v4.xCoor, v4.yCoor)) {
					v4.parent = u;
					q.enqueue(v4);
				}
			}
			Node uCopy = u;
			int siz = 0;
			while (uCopy.parent != null) {
				uCopy = (Node) uCopy.parent;
				siz++;
			}
			bfs = new int[siz + 1][2];
			getBfsPath(s, u);
			file.close();
		} catch (final IOException e1) {
			throw ex3;
		}
		return bfs;
	}

	/**
	 * Read the maze file, and solve it using Depth First Search.
	 *
	 * @param maze
	 *            maze file
	 * @return the coordinates of the found path from point 'S' to point 'E'
	 *         based.
	 */
	
	public int[][] solveDFS(final File maze) {
		fsCounter = 0;
		char[][] mazeArr = null;
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = -1;
			}
		}
		try {
			final FileInputStream f = new FileInputStream(maze);
			final BufferedReader file = new BufferedReader(new InputStreamReader(f));
			String strLine;
			boolean first = true;
			int lines = 0;
			int xSource = 0;
			int ySource = 0;
			if (f.available() == 0) {
				throw ex;
			}
			int counter = 0;
			int raws = -1;
			int cols = -1;
			int lineCounter = 0;
			while ((strLine = file.readLine()) != null) {
				/**
				 * if (first): to determine the raws and columns of the maze
				 * array .
				 */
				if (first) {
					strLine = strLine.trim();
					strLine = strLine + " ";

					boolean firstNum = true;
					boolean secondNum = true;
					String num = "";
					for (int i = 0; i < strLine.length(); i++) {
						if (firstNum) {
							final char currentChar = strLine.charAt(i);
							if (currentChar != ' ' && isInteger(currentChar)) {
								num = num.concat(String.valueOf(currentChar));
								continue;
							}
							raws = Integer.parseInt(num);
							num = "";
							firstNum = false;
						} else if (secondNum && !firstNum) {
							final char currentChar = strLine.charAt(i);
							if (currentChar != ' ' && isInteger(currentChar)) {
								num = num.concat(String.valueOf(currentChar));
								continue;
							}
							cols = Integer.parseInt(num);
							secondNum = false;
						} else {
							counter++;
						}
					}
					if (counter != 0 || raws < 0 || cols < 0) {
						throw ex0;
					}
					mazeArr = new char[raws][cols];
					boolArr = new boolean[raws][cols];
					first = false;
					continue;
				} // EndFirst

				if (strLine.trim().length() != cols) {
					throw ex1;
				}
				lineCounter++;
				strLine = strLine.trim();
				for (int i = 0; i < strLine.length(); i++) {
					if (strLine.charAt(i) != ' ') {
						mazeArr[lines][i] = strLine.charAt(i);
						if (strLine.charAt(i) == 'S') {
							source = true;
							boolArr[lines][i] = true;
							xSource = lines;
							ySource = i;
						} else if (strLine.charAt(i) == 'E') {
							exit = true;
							if (fIrIsT) {
								xExit = lines;
								yExit = i;
								boolArr[lines][i] = true;
								fIrIsT = false;
							} else {
								xExit2 = lines;
								yExit2 = i;
								boolArr[lines][i] = true;
								fIrIsT = false;
							}
						} else if (strLine.charAt(i) == '.') {
							boolArr[lines][i] = true;
						} else {
							boolArr[lines][i] = false;
						}
					}
				}
				lines++;
			} // End While

			if (lineCounter != raws || !exit || !source) {
				throw ex2;
			}

			final Node s = new Node();
			s.parent = null;
			s.xCoor = xSource;
			s.yCoor = ySource;
			Node u = new Node();
			u = s;
			visited[0][0] = s.xCoor;
			visited[0][1] = s.yCoor;
			count++;
			runDfs(u);
			if (flage == 0) {
				return null;
			}
			final int hundred = 100;

			dfs = new int[hundred][2];

			getDfsPath(s, e);
			file.close();
		} catch (final IOException e1) {
			throw ex3;
		}
		int c = 0;
		for (int i = 0; i < dfs.length; i++) {
			if (dfs[i][0] == 0 && dfs[i][1] == 0) {
				continue;
			}
			c++;
		}
		final int[][] newDfs = new int[c][2];
		for (int i = 0; i < c; i++) {
			newDfs[i][0] = dfs[i][0];
			newDfs[i][1] = dfs[i][1];
		}

		return newDfs;
	} // End method of dfs

	/**
		 *
		 */
	private final Node e = new Node();
	/**
		 *
		 */
	private int flage = 0;

	/**
	 *
	 * @param u
	 *            .
	 */
	final void runDfs(final Node u) {
		if (u.xCoor == xExit && u.yCoor == yExit) {
			e.parent = u;
			for (int i = 0; i < boolArr.length; i++) {
				for (int j = 0; j < boolArr[0].length; j++) {
					boolArr[i][j] = false;
				}
			}
			flage = 1;
			return;
		} else if (u.xCoor == xExit2 && u.yCoor == yExit2) {
			e.parent = u;
			for (int i = 0; i < boolArr.length; i++) {
				for (int j = 0; j < boolArr[0].length; j++) {
					boolArr[i][j] = false;
				}
			}
			flage = 1;
			return;
		}
		final Node v1 = new Node();
		v1.xCoor = u.xCoor - 1;
		v1.yCoor = u.yCoor;
		if (isValid(v1.xCoor, v1.yCoor)) {
			v1.parent = u;
			e.parent = u;
			runDfs(v1);
		}

		final Node v2 = new Node();
		v2.xCoor = u.xCoor;
		v2.yCoor = u.yCoor + 1;
		if (isValid(v2.xCoor, v2.yCoor)) {
			v2.parent = u;
			e.parent = u;
			runDfs(v2);
		}

		final Node v3 = new Node();
		v3.xCoor = u.xCoor + 1;
		v3.yCoor = u.yCoor;
		if (isValid(v3.xCoor, v3.yCoor)) {
			v3.parent = u;
			e.parent = u;
			runDfs(v3);
		}
		final Node v4 = new Node();
		v4.xCoor = u.xCoor;
		v4.yCoor = u.yCoor - 1;
		if (isValid(v4.xCoor, v4.yCoor)) {
			v4.parent = u;
			e.parent = u;
			runDfs(v4);
		}
	}

	/**
	 *
	 * @param s
	 *            .
	 * @param v
	 *            .
	 */
	final void getBfsPath(final Node s, final Node v) {
		fsCounter = 0;
		if (s == v) {
			bfs[fsCounter][0] = v.xCoor;
			bfs[fsCounter][1] = v.yCoor;
			fsCounter++;
		} else if (v.parent == null) {
			System.out.println("No path Found");
		} else {
			getBfsPath(s, (Node) v.parent);
			bfs[fsCounter][0] = v.xCoor;
			bfs[fsCounter][1] = v.yCoor;
			fsCounter++;
		}
	}

	/**
	 *
	 * @param s
	 *            .
	 * @param v
	 *            .
	 */
	final void getDfsPath(final Node s, final Node v) {
		fsCounter = 0;
		if (s == v) {
			dfs[fsCounter][0] = v.xCoor;
			dfs[fsCounter][1] = v.yCoor;
			fsCounter++;
		} else if (v.parent == null) {
			System.out.println("No path Found");
			throw ex;
		} else {
			getDfsPath(s, (Node) v.parent);
			dfs[fsCounter][0] = v.xCoor;
			dfs[fsCounter][1] = v.yCoor;
			fsCounter++;
		}
	}

	/**
	 *
	 * @param x
	 *            .
	 * @param y
	 *            .
	 * @return .
	 */
	final boolean isValid(final int x, final int y) {
		if (x < 0 || y < 0 || x >= boolArr.length) {
			return false;
		}
		if (y >= boolArr[0].length || !boolArr[x][y]) {
			return false;
		}

		for (int i = 0; i < visited.length; i++) {
			if (visited[i][0] == x && visited[i][1] == y) {
				return false;
			}
		}
		visited[count][0] = x;
		visited[count][1] = y;
		count++;
		return true;
	}

	/**
	 *
	 * @param c
	 *            .
	 * @return .
	 */
	final boolean isInteger(final char c) {
		final String string = String.valueOf(c);
		try {
			Integer.parseInt(string);
			return true;
		} catch (final NumberFormatException nfe) {
			return false;
		}
	}
}
