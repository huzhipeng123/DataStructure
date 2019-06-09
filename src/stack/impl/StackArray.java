package stack.impl;

import exception.StackEmptyException;
import stack.Stack;

/**
 * Stack��˳��洢ʵ��
 * 
 * @author hzp
 *
 */
public class StackArray implements Stack {

	/**
	 * �����Ĭ�ϴ�С
	 */
	private final int LEN = 8;

	/**
	 * ����Ԫ������
	 */
	private Object[] elements;

	/**
	 * ջ��ָ��
	 */
	private int top;

	public StackArray() {
		top = -1;
		elements = new Object[LEN];
	}

	@Override
	public int getSize() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		return top < 0;
	}

	@Override
	public void push(Object e) {
		if (getSize() >= elements.length) {
			expandSpace();
		}
		elements[++top] = e;
	}

	/**
	 * ��չ�ռ�
	 */
	private void expandSpace() {
		Object[] a = new Object[elements.length * 2];
		for (int i = 0; i < elements.length; i++) {
			a[i] = elements[i];
		}
		elements = a;
	}

	@Override
	public Object pop() throws StackEmptyException {
		if (getSize() < 1) {
			throw new StackEmptyException("���󣬶�ջΪ�ա�");
		}
		Object obj = elements[top];
		elements[top--] = null;
		return obj;
	}

	@Override
	public Object peek() throws StackEmptyException {
		if (getSize() < 1) {
			throw new StackEmptyException("���󣬶�ջΪ�ա�");
		}
		return elements[top];
	}

}
