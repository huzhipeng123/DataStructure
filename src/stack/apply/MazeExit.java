package stack.apply;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import stack.Stack;
import stack.impl.StackSLinked;
/**
 * �Թ��д���㵽�յ�·�������
 * @author hzp
 *
 */
class MazeExit {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	public void mazeExit(char[][] maze, int sx, int sy, int ex, int ey) {
		//�����Թ�
		Cell[][] cells = createMaze(maze);
		//��ӡ�Թ�
		printMaze(cells);
		//�����ջ
		Stack s = new StackSLinked();
		//���
		Cell startCell = cells[sx][sy];
		//�յ�
		Cell endCell = cells[ex][ey];
		//�����ջ
		s.push(startCell);
		//��־����ѱ�����
		startCell.visited = true;
		while(!s.isEmpty()) {
			Cell current = (Cell) s.peek();
			//·���ҵ�
			if(current == endCell) {
				while(!s.isEmpty()) {
					//��·���ؽ�·���ϵĵ�Ԫ��Ϊ*
					Cell cell = (Cell) s.pop();
					cell.c = '*';
					//��ջ����cell���ڵĵ�Ԫ����·������ɲ��֣�����֮�⣬
					//��ջ�л��м�¼��������δ��������̽���ĵ�Ԫ
					while(!s.isEmpty() && !isAdjoinCell((Cell) s.peek(), cell)) {
						s.pop();
					}
				}
				System.out.println("�ҵ�����㵽�յ��·����");
				printMaze(cells);
				return;
			}else {		//�����ǰλ�ò����յ�
				int x = current.x;
				int y = current.y;
				int count = 0;
				//����
				if(isValidWayCell(cells[x+1][y])) {
					s.push(cells[x+1][y]);
					cells[x+1][y].visited = true;
					count++;
				}
				//����
				if(isValidWayCell(cells[x][y+1])) {
					s.push(cells[x][y+1]);
					cells[x][y+1].visited = true;
					count++;
				}
				//����
				if(isValidWayCell(cells[x-1][y])) {
					s.push(cells[x-1][y]);
					cells[x-1][y].visited = true;
					count++;
				}
				//����
				if(isValidWayCell(cells[x][y-1])) {
					s.push(cells[x][y-1]);
					cells[x][y-1].visited = true;
					count++;
				}
				//��������㣬��ջ
				if(count == 0) {
					s.pop();
				}
			}
		}
		System.out.println("û�д���㵽�յ��·����");
	}

	/**
	 * �ж�cell�Ƿ����ͨ��
	 * @param cell
	 * @return
	 */
	private boolean isValidWayCell(Cell cell) {
		return cell.c=='0' && !cell.visited;
	}

	/**
	 * �ж�cell2�Ƿ���cell1����
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
	 * ��ӡ�Թ�
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
	 * �����Թ�
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
