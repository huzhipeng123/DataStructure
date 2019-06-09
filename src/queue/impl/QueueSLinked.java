package queue.impl;

import exception.QueueEmptyException;
import node.impl.SLNode;
import queue.Queue;

public class QueueSLinked implements Queue {
	
	/**
	 * 链式存储队首结点
	 */
	private SLNode front;
	
	/**
	 * 链式存储队尾结点
	 */
	private SLNode rear;
	
	/**
	 * 队列大小
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
			throw new QueueEmptyException("错误：队列为空");
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
			throw new QueueEmptyException("错误：队列为空");
		}
		return front.getNext().getData();
	}

}
