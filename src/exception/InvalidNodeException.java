package exception;
/**
 * 	��Ϊ�����Ľ�㲻�Ϸ��׳����쳣
 * 	���p����������¿�����Ϊ�ǲ��Ϸ���
 * 1.p==null
 * 2.p�������в�����
 * 3.�ڵ��÷���getPre(p)ʱ��p�Ѿ��ǵ�һ���������ݵĽ��
 * 4.�ڵ��÷���getNext(p)ʱ��p�Ѿ������һ���������ݵĽ��
 * @author hzp
 *
 */
public class InvalidNodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 697968004612169864L;
	
	/**
	 * ��Ϊ�����Ľ�㲻�Ϸ�ʱ�׳����쳣
	 * @param err
	 */
	public InvalidNodeException(String err) {
		super(err);
	}
	
}
