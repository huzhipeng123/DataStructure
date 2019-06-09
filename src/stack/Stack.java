package stack;

import exception.StackEmptyException;

/**
 * ��ջ�ӿ�
 * @author hzp
 *
 */
public interface Stack {
	/**
	 * ���ض�ջ�Ĵ�С
	 * @return
	 */
	public int getSize();
	
	/**
	 * �ж϶�ջ�Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * ����Ԫ��e��ջ
	 * @param e
	 */
	public void push(Object e);
	
	/**
	 * ջ��Ԫ�س�ջ
	 * @return
	 * @throws StackEmptyException
	 */
	public Object pop() throws StackEmptyException;
	
	/**
	 * ȡջ��Ԫ��
	 * @return
	 * @throws StackEmptyException
	 */
	public Object peek() throws StackEmptyException;
	
}
