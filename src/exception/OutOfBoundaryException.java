package exception;

/**
 * ���Ա��г������Խ��ʱ�׳����쳣
 * 
 * @author hzp
 *
 */
public class OutOfBoundaryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1363786455855158081L;

	public OutOfBoundaryException(String err) {
		super(err);
	}
}
