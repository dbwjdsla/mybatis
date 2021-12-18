package com.kh.design.pattern.strategy;

/**
 * Desing Pattern
 * - 문제해결을 위한 코드구조를 정리한 것.
 * 
 * 전략패턴
 * - GoF의 디자인 패턴 중 행위패턴의 한가지
 * 
 * contxt가 전략(변경가능성이 있는 코드)를 사용함에 있어 inerface규격을 통해 제어하는 것
 * - context : stategy를 사용하는 쪽
 * - interface : strate의 규격
 * - stratege(interface구현클래스)
 *
 */

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller(new DService());
		controller.test();
		
	}

}
