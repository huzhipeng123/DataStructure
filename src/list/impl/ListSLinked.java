package list.impl;

import exception.OutOfBoundaryException;
import list.List;
import node.impl.SLNode;
import strategy.Strategy;
import strategy.impl.DefaultStrategy;

public class ListSLinked implements List {
	
	/**
	 * ����Ԫ�رȽϲ���
	 */
	private Strategy strategy;
	
	/**
	 * �������׽������
	 */
	private SLNode head;
	
	/**
	 * ���Ա�������Ԫ�صĸ���
	 */
	private int size;
	
	

	public ListSLinked() {
		this(new DefaultStrategy());
	}
	

	public ListSLinked(Strategy strategy) {
		this.strategy = strategy;
		this.head = new SLNode();
		size = 0;
	}
	
	/**
	 * ������������ȡ����Ԫ��e���ڽ���ǰ�����
	 * @param e
	 * @return
	 */
	private SLNode getPreNode(Object e) {
		SLNode p = head;
		while(p.getNext() != null) {
			if(strategy.equal(p.getNext().getData(), e)) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * ������������ȡ���Ϊ0 <= i <= size��Ԫ�����ڽ���ǰ�����
	 * @param i
	 * @return
	 */
	private SLNode getPreNode(int i) {
		SLNode p = head;
		for(; i> 0; i--) {
			p = p.getNext();
		}
		return p;
	}
	
	/**
	 * ��ȡ���Ϊ0 <= i < size ��Ԫ�����ڽ��
	 * @param i
	 * @return
	 */
	private SLNode getNode(int i) {
		SLNode p = head;
		for(; i > 0; i--) {
			p = p.getNext();
		}
		return p;
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
		SLNode p = head.getNext();
		while(p != null) {
			if(strategy.equal(p.getData(), e)) {
				return true;
			}else {
				p = p.getNext();
			}
		}
		return false;
	}

	@Override
	public int indexOf(Object e) {
		SLNode p = head.getNext();
		int index = 0;
		while(p != null) {
			if(strategy.equal(p.getData(), e)) {
				return index;
			}else {
				index++;
				p = p.getNext();
			}
		}
		return -1;
	}

	@Override
	public void insert(int i, Object e) throws OutOfBoundaryException {
		if(i < 0 || i > size) {
			throw new OutOfBoundaryException("����ָ���Ĳ������Խ�硣");
		}
		SLNode p = getPreNode(i);
		SLNode q = new SLNode(e, p.getNext());
		p.setNext(q);
		size++;
		return;
	}

	@Override
	public boolean insertBefore(Object obj, Object e) {
		SLNode p = getPreNode(obj);
		if(p != null) {
			SLNode q = new SLNode(e, p.getNext());
			p.setNext(q);
			size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean insertAfter(Object obj, Object e) {
		SLNode p = head.getNext();
		while(p != null) {
			if(strategy.equal(p.getData(), obj)) {
				SLNode q = new SLNode(e, p.getNext());
				p.setNext(q);
				size++;
				return true;
			}else {
				p = p.getNext();
			}
		}
		return false;
	}

	@Override
	public Object remove(int i) throws OutOfBoundaryException {
		if(i < 0 || i > size) {
			throw new OutOfBoundaryException("����ָ����ɾ�����Խ�硣");
		}
		SLNode p = getPreNode(i);
		Object obj = p.getNext().getData();
		p.setNext(p.getNext().getNext());
		size--;
		return obj;
	}

	@Override
	public boolean remove(Object e) {
		SLNode p = getPreNode(e);
		if(p != null) {
			p.setNext(p.getNext().getNext());
			size--;
			return true;
		}
		return false;
	}

	@Override
	public Object replace(int i, Object e) throws OutOfBoundaryException {
		if(i < 0 || i >= size) {
			throw new OutOfBoundaryException("����ָ�������Խ�硣");
		}
		SLNode p = getNode(i);
		Object obj = p.getData();
		p.setData(e);
		return obj;
	}

	@Override
	public Object get(int i) throws OutOfBoundaryException {
		if(i < 0 || i > size) {
			throw new OutOfBoundaryException("����ָ�������Խ�硣");
		}
		SLNode p = getNode(i);
		return p.getData();
	}

}
