package exception;
/**
 * 堆栈为空时出栈或取栈顶元素抛出此异常
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
