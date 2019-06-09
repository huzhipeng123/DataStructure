package strategy;
/**
 * ʹ��Strategy�ӿڿ���ʵ�ָ��ֲ�ͬ����Ԫ���໥֮������ıȽϲ���
 * @author hzp
 *
 */
public interface Strategy {
	
	/**
	 * �ж���������Ԫ���Ƿ����
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public boolean equal(Object obj1, Object obj2);
	
	/**
	 * �Ƚ���������Ԫ�صĴ�С
	 * ���obj1 < obj2, ����-1
	 * ���obj2 = obj2, ����0
	 * ���obj1 > obj2, ����1
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public int compare(Object obj1, Object obj2);
	
}
