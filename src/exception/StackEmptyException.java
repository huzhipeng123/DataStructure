package exception;
/**
 * ��ջΪ��ʱ��ջ��ȡջ��Ԫ���׳����쳣
 * @author hzp
 *
 */
public class StackEmptyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 821694014779249850L;

	public StackEmptyException(String err) {
		super(err);
	}
}
