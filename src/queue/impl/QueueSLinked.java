package queue.impl;

import exception.QueueEmptyException;
import node.impl.SLNode;
import queue.Queue;

public class QueueSLinked implements Queue {
	
	/**
	 * ��ʽ�洢���׽��
	 */
	private SLNode front;
	
	/**
	 * ��ʽ�洢��β���
	 */
	private SLNode rear;
	
	/**
	 * ���д�С
	 */
	private int size;
	

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(Object e) {
		SLNode p = new SLNode(e, null);
		rear.setNext(p);
		rear = p;
		size++;
	}

	@Override
	public Object dequeue() throws QueueEmptyException {
		if(size < 1) {
			throw new QueueEmptyException("���󣺶���Ϊ��");
		}
		SLNode p = front.getNext();
		front.setNext(p.getNext());
		size--;
		if(size < 1) {
			rear = front;
		}
		return p.getData();
	}

	@Override
	public Object peek() throws QueueEmptyException {
		if(size < 1) {
			throw new QueueEmptyException("���󣺶���Ϊ��");
		}
		return front.getNext().getData();
	}

}
