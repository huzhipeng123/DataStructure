package exception;
/**
 * ����Ϊ�ջ�ȡ����Ԫ���׳����쳣
 * @author hzp
 *
 */
public class QueueEmptyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1941057031637121503L;
	
	public QueueEmptyException(String err) {
		super(err);
	}
}
