package com.example.demo.jackson.json.demo.main;

public class Test {

	static class A{

	}

	public static void main(String[] args) {
		int tab1[][]= new int[3][]; tab1[0]= new int[2];

		System.out.println(null instanceof A);

		Test test = new Test();
		B b = new B();
		System.out.println("INSTANCE:"+ Test.class.isInstance(b));
		System.out.println("INSTANCE:" + (b instanceof Test));
		System.out.println("ASSIGNAMBE"+ B.class.isAssignableFrom(Test.class));
		System.out.println("ASSIGNAMBE"+ Test.class.isAssignableFrom(B.class));




	}

}

class B extends Test{

	public B(){

		System.out.println("B CONSTRUCTOR");
	}

}
