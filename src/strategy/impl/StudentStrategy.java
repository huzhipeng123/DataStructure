package strategy.impl;

import demo.Student;
import strategy.Strategy;
/**
 * 学生比较策略
 * @author hzp
 *
 */
public class StudentStrategy implements Strategy {

	@Override
	public boolean equal(Object obj1, Object obj2) {
		if(obj1 instanceof Student && obj2 instanceof Student) {
			Student s1 = (Student) obj1;
			Student s2 = (Student) obj2;
			return s1.getsId().equals(s2.getsId());
		}else {
			return false;			
		}
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		if(obj1 instanceof Student && obj2 instanceof Student) {
			Student s1 = (Student) obj1;
			Student s2 = (Student) obj2;
			return s1.getsId().compareTo(s2.getsId());
		}else {
			return obj1.toString().compareTo(obj2.toString());
		}
	}

}
