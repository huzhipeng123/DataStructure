package queue;

import exception.QueueEmptyException;

/**
 * Queue�ӿ�
 * @author hzp
 *
 */
public interface Queue {
	/**
	 * ���ض��д�С
	 * @return
	 */
	public int getSize();
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * ����Ԫ��e���
	 * @param e
	 */
	public void enqueue(Object e);
	
	/**
	 * ����Ԫ�س���
	 * @return
	 * @throws QueueEmptyException
	 */
	public Object dequeue() throws QueueEmptyException;
	
	/**
	 * ȡ����Ԫ��
	 * @return
	 * @throws QueueEmptyException
	 */
	public Object peek() throws QueueEmptyException;
	
}
