package stack.apply;

import org.junit.jupiter.api.Test;

import stack.Stack;
import stack.impl.StackSLinked;
/*
 * ��ջӦ�ã�ʵ��ʮ���������˽�������ת��
 */
class BaseConversion {

	@Test
	void test() {
		baseConversion(2007);
	}
	
	public void baseConversion(int i) {
		Stack s = new StackSLinked();
		while(i > 0) {
			s.push(i % 8 + "");
			i = i / 8;
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}

}
