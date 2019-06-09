package exception;

/**
 * 线性表中出现序号越界时抛出该异常
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
