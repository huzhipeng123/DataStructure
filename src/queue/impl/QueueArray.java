package queue.impl;

import exception.QueueEmptyException;
import queue.Queue;
/**
 * Queue��˳��洢ʵ��
 * @author hzp
 *
 */
public class QueueArray implements Queue {
	
	/**
	 * ����Ĭ�ϴ�С
	 */
	private static final int CAP = 7;
	
	/**
	 * ����Ԫ������
	 */
	private Object[] elements;
	
	/**
	 * ����Ĵ�С��elements.length
	 */
	private int capacity;
	
	/**
	 * ����ָ�룬ָ�����
	 */
	private int front;
	
	/**
	 * ��βָ�룬ָ���β��һ��λ��
	 */
	private int rear;
	
	

	public QueueArray() {
		this(CAP);
	}
	
	

	public QueueArray(int cap) {
		capacity = cap + 1;
		elements = new Object[capacity];
		front = rear = 0;
	}


	@Override
	public int getSize() {
		return (rear - front + capacity) % capacity;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public void enqueue(Object e) {
		if(getSize() == capacity - 1) {
			expandSpace();
		}
		elements[rear] = e;
		rear = (rear + 1) % capacity;
	}

	/**
	 * ���е�����
	 */
	private void expandSpace() {
		Object[] a = new Object[elements.length * 2];
		int i = front;
		int j = 0;
		//����front��ʼ��rearǰһ���洢��Ԫ��Ԫ�ظ��Ƶ�������
		while(i != rear) {
			a[j++] = elements[i];
			i = (i+1) % capacity;
		}
		elements = a;
		capacity = elements.length;
		//�����µĶ��ס���βָ��
		front = 0;
		rear = j;
	}



	@Override
	public Object dequeue() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException("���󣺶���Ϊ�ա�");
		}
		Object obj = elements[front];
		elements[front] = null;
		front = (front + 1) % capacity;
		return obj;
	}

	@Override
	public Object peek() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException("���󣺶���Ϊ�ա�");
		}
		return elements[front];
	}

}
