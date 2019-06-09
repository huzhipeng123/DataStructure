package stack.apply;

import org.junit.jupiter.api.Test;

import stack.Stack;
import stack.impl.StackSLinked;

class BracketMatch {

	@Test
	void test() {
		bracketMatch("{(){}}");
	}
	
	public boolean bracketMatch(String str) {
		Stack s = new StackSLinked();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case '{':
			case '[':
			case '(':
				s.push(c);
				break;
			case '}':
				if(!s.isEmpty() && s.pop().equals('{')) {
					break;
				}else {
					return false;
				}
			case ']':
				if(!s.isEmpty() && s.pop().equals('[')) {
					break;
				}else {
					return false;
				}
			case ')':
				if(!s.isEmpty() && s.pop().equals('(')) {
					break;
				}else {
					return false;
				}
			default:
				break;
			}
		}
		if(s.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

}
