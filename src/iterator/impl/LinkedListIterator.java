package iterator.impl;

import exception.OutOfBoundaryException;
import iterator.Iterator;
import list.linkedList.LinkedList;
import node.Node;

/**
 * ����LinkedList�ۼ�����ĵ�����ʵ��
 * 
 * @author hzp
 *
 */
public class LinkedListIterator implements Iterator {

	/**
	 * ���ӱ�
	 */
	private LinkedList list;

	/**
	 * ��ǰ���
	 */
	private Node current;

	/**
	 * ���췽��
	 * 
	 * @param list
	 */
	public LinkedListIterator(LinkedList list) {
		this.list = list;
		// ���б�Ϊ�գ���ǰԪ���ÿ�
		if (list.isEmpty()) {
			current = null;
		} else {
			// ����ӵ�һ��Ԫ�ؿ�ʼ
			current = list.first();
		}
	}

	@Override
	public void first() {
		if (list.isEmpty()) {
			current = null;
		} else {
			current = list.first();
		}
	}

	@Override
	public void next() {
		if (isDone()) {
			throw new OutOfBoundaryException("�����Ѿ�û��Ԫ�ء�");
		}
		if (current == list.last()) {
			current = null;
		} else {
			current = list.getNext(current);
		}
	}

	@Override
	public boolean isDone() {
		return current == null;
	}

	@Override
	public Object currentItem() {
		if (isDone()) {
			throw new OutOfBoundaryException("�����Ѿ�û��Ԫ�ء�");
		}
		return current.getData();
	}

}
