package stack.apply;
/**
 * 迷宫单元的定义
 * @author hzp
 *
 */
public class Cell {
	/**
	 * 单元所在行
	 */
	int x = 0;
	
	/**
	 * 单元所在列
	 */
	int y = 0;
	
	/**
	 * 是否被访问过
	 */
	boolean visited = false;
	
	/**
	 * 是墙（'1'）、可通路（'0'）或起点到终点的路径（'*'）
	 */
	char c = ' ';

	public Cell(int x, int y, boolean visited, char c) {
		super();
		this.x = x;
		this.y = y;
		this.visited = visited;
		this.c = c;
	}
	
	
}
