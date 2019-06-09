package stack.apply;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import stack.Stack;
import stack.impl.StackSLinked;
/**
 * 迷宫中从起点到终点路径的求解
 * @author hzp
 *
 */
class MazeExit {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	public void mazeExit(char[][] maze, int sx, int sy, int ex, int ey) {
		//创建迷宫
		Cell[][] cells = createMaze(maze);
		//打印迷宫
		printMaze(cells);
		//构造堆栈
		Stack s = new StackSLinked();
		//起点
		Cell startCell = cells[sx][sy];
		//终点
		Cell endCell = cells[ex][ey];
		//起点入栈
		s.push(startCell);
		//标志起点已被访问
		startCell.visited = true;
		while(!s.isEmpty()) {
			Cell current = (Cell) s.peek();
			//路径找到
			if(current == endCell) {
				while(!s.isEmpty()) {
					//沿路返回将路径上的单元设为*
					Cell cell = (Cell) s.pop();
					cell.c = '*';
					//堆栈中与cell相邻的单元才是路径的组成部分，除此之外，
					//堆栈中还有记录下来但是未继续向下探索的单元
					while(!s.isEmpty() && !isAdjoinCell((Cell) s.peek(), cell)) {
						s.pop();
					}
				}
				System.out.println("找到从起点到终点的路径。");
				printMaze(cells);
				return;
			}else {		//如果当前位置不是终点
				int x = current.x;
				int y = current.y;
				int count = 0;
				//向下
				if(isValidWayCell(cells[x+1][y])) {
					s.push(cells[x+1][y]);
					cells[x+1][y].visited = true;
					count++;
				}
				//向右
				if(isValidWayCell(cells[x][y+1])) {
					s.push(cells[x][y+1]);
					cells[x][y+1].visited = true;
					count++;
				}
				//向上
				if(isValidWayCell(cells[x-1][y])) {
					s.push(cells[x-1][y]);
					cells[x-1][y].visited = true;
					count++;
				}
				//向左
				if(isValidWayCell(cells[x][y-1])) {
					s.push(cells[x][y-1]);
					cells[x][y-1].visited = true;
					count++;
				}
				//如果是死点，出栈
				if(count == 0) {
					s.pop();
				}
			}
		}
		System.out.println("没有从起点到终点的路径。");
	}

	/**
	 * 判断cell是否可以通行
	 * @param cell
	 * @return
	 */
	private boolean isValidWayCell(Cell cell) {
		return cell.c=='0' && !cell.visited;
	}

	/**
	 * 判断cell2是否与cell1相邻
	 * @param cell1
	 * @param cell2
	 * @return
	 */
	private boolean isAdjoinCell(Cell cell1, Cell cell2) {
		if(cell1.x == cell2.x && Math.abs(cell1.y - cell2.y) < 2) {
			return true;
		}
		if(cell1.y == cell2.y && Math.abs(cell1.x - cell2.x) < 2) {
			return true;
		}
		return false;
	}

	/**
	 * 打印迷宫
	 * @param cells
	 */
	private void printMaze(Cell[][] cells) {
		for(int x = 0; x < cells.length; x++) {
			for(int y = 0; y < cells.length; y++) {
				System.out.print(cells[x][y].c);
			}
			System.out.println();
		}
	}

	/**
	 * 创建迷宫
	 * @param maze
	 * @return
	 */
	private Cell[][] createMaze(char[][] maze) {
		Cell[][] cells = new Cell[maze.length][];
		for(int x = 0; x < maze.length; x++) {
			char[] row = maze[x];
			cells[x] = new Cell[row.length];
			for(int y = 0; y < row.length; y++) {
				cells[x][y] = new Cell(x, y, false, maze[x][y]);
			}
		}
		return cells;
	}

}
