package com.fishpan;

public class Main {

	public static void main(String[] args) {
		System.out.println("get value = " + getValue2());
	}
	
	/**
	 * 在try中返回值，在finally中修改变量的值，不会影响返回结果
	 * 在return语句中先执行语句，不返回结果，执行完finally后再返回结果
	 * @return
	 */
	public static int getValue(){
		int a = 1;
		try {
			System.out.println("try -> " + a);
			return ++a;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			a ++;
			System.out.println("finally -> " + a);
		}
		return a;
	}
	
	/**
	 * 当try和finally中都有返回值时，finally的返回值会覆盖try中的返回值
	 * @return
	 */
	public static int getValue1(){
		int a = 0;
		try {
			System.out.println("try -> " + a);
			return ++a;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally -> " + a);
			return ++a;
		}
	}
	
	/**
	 * 这种情况和上的getValue1类似，finally总会执行，并会覆盖catch中的返回值
	 * @return
	 */
	public static int getValue2(){
		int a = 1;
		try {
			System.out.println("try -> " + a);
			int b = Integer.parseInt("a");
			return ++a;
		} catch (Exception e) {
			System.out.println("catch -> " + a);
			return ++a;
		} finally {
			++a;
			System.out.println("finally -> " + a);
		}
	}
	
	/**
	 * 这种情况和上的getValue1类似，finally总会执行，并会覆盖catch中的返回值
	 * @return
	 */
	public static int getValue3(){
		int a = 1;
		try {
			System.out.println("try -> " + a);
			int b = Integer.parseInt("a");
			return ++a;
		} catch (Exception e) {
			System.out.println("catch -> " + a);
			return ++a;
		} finally {
			System.out.println("finally -> " + a);
			return ++a;
		}
	}
}
