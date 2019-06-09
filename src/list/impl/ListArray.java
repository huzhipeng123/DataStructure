package list.impl;

import exception.OutOfBoundaryException;
import list.List;
import strategy.Strategy;
import strategy.impl.DefaultStrategy;

/**
 * ���Ա������ʵ��
 * 
 * @author hzp
 *
 */
public class ListArray implements List {

	/**
	 * �����Ĭ�ϴ�С
	 */
	private final int LEN = 8;

	/**
	 * ����Ԫ�رȽϲ���
	 */
	private Strategy strategy;

	/**
	 * ���Ա�������Ԫ�صĸ���
	 */
	private int size;

	/**
	 * ����Ԫ������
	 */
	private Object[] elements;
	
	

	public ListArray() {
		this(new DefaultStrategy());
	}

	public ListArray(Strategy strategy) {
		this.strategy = strategy;
		size = 0;
		elements = new Object[LEN];
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Object[] getElements() {
		return elements;
	}

	public void setElements(Object[] elements) {
		this.elements = elements;
	}

	public int getLEN() {
		return LEN;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object e) {
		for(int i = 0; i < size; i++) {
			if(strategy.equal(e, elements[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(Object e) {
		for(int i = 0; i < size; i++) {
			if(strategy.equal(e, elements[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void insert(int i, Object e) throws OutOfBoundaryException {
		if(i < 0 || i > size) {
			throw new OutOfBoundaryException("����ָ���Ĳ������Խ�磡");
		}
		if(size >= elements.length) {
			expandSpace();
		}
		for(int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
		size++;
		return;
	}

	private void expandSpace() {
		Object[] a = new Object [elements.length * 2];
		for(int i = 0; i < elements.length; i++) {
			a[i] = elements[i];
		}
		elements = a;
	}

	@Override
	public boolean insertBefore(Object obj, Object e) {
		int i = indexOf(obj);
		if(i < 0) {
			return false;
		}else {
			insert(i, e);
			return true;
		}
	}

	@Override
	public boolean insertAfter(Object obj, Object e) {
		int i = indexOf(obj);
		if(i < 0) {
			return false;
		}else {
			insert(i + 1, e);
			return true;
		}
	}

	@Override
	public Object remove(int i) throws OutOfBoundaryException {
		if(i < 0 || i >= size) {
			throw new OutOfBoundaryException("����ָ����ɾ�����Խ�硣");
		}
		Object obj = elements[i];
		for(int j = i; j < size - 1; j++) {
			elements[j] = elements[j+1];
		}
		elements[--size] = null;
		return obj;
	}

	@Override
	public boolean remove(Object e) {
		int i = indexOf(e);
		if(i < 0) {
			return false;
		}
		remove(i);
		return true;
	}

	@Override
	public Object replace(int i, Object e) throws OutOfBoundaryException {
		if(i < 0 || i >= size) {
			throw new OutOfBoundaryException("����ָ�������Խ�硣");
		}
		Object obj = elements[i];
		elements[i] = e;
		return obj;
	}

	@Override
	public Object get(int i) throws OutOfBoundaryException {
		if(i < 0 || i >= size) {
			throw new OutOfBoundaryException("����ָ�������Խ�硣");
		}
		return elements[i];
	}

}
