package stack.apply;
/**
 * �Թ���Ԫ�Ķ���
 * @author hzp
 *
 */
public class Cell {
	/**
	 * ��Ԫ������
	 */
	int x = 0;
	
	/**
	 * ��Ԫ������
	 */
	int y = 0;
	
	/**
	 * �Ƿ񱻷��ʹ�
	 */
	boolean visited = false;
	
	/**
	 * ��ǽ��'1'������ͨ·��'0'������㵽�յ��·����'*'��
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
