package iterator.impl;

import exception.OutOfBoundaryException;
import iterator.Iterator;
import list.linkedList.LinkedList;
import node.Node;

/**
 * 基于LinkedList聚集对象的迭代器实现
 * 
 * @author hzp
 *
 */
public class LinkedListIterator implements Iterator {

	/**
	 * 链接表
	 */
	private LinkedList list;

	/**
	 * 当前结点
	 */
	private Node current;

	/**
	 * 构造方法
	 * 
	 * @param list
	 */
	public LinkedListIterator(LinkedList list) {
		this.list = list;
		// 若列表为空，则当前元素置空
		if (list.isEmpty()) {
			current = null;
		} else {
			// 否则从第一个元素开始
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
			throw new OutOfBoundaryException("错误：已经没有元素。");
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
			throw new OutOfBoundaryException("错误：已经没有元素。");
		}
		return current.getData();
	}

}
