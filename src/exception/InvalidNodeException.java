package exception;
/**
 * 	作为参数的结点不合法抛出的异常
 * 	结点p在以下情况下可以认为是不合法的
 * 1.p==null
 * 2.p在链表中不存在
 * 3.在调用方法getPre(p)时，p已经是第一个存有数据的结点
 * 4.在调用方法getNext(p)时，p已经是最后一个存有数据的结点
 * @author hzp
 *
 */
public class InvalidNodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 697968004612169864L;
	
	/**
	 * 作为参数的结点不合法时抛出的异常
	 * @param err
	 */
	public InvalidNodeException(String err) {
		super(err);
	}
	
}
