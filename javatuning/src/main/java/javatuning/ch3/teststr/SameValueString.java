package javatuning.ch3.teststr;

public class SameValueString {
	public static void main(String args[]){
		String str1="abc";
		String str2="abc";
		String str3=new String("abc");
		System.out.println(str1==str2);//返回true
		System.out.println(str1==str3);//返回false
		System.out.println(str1==str3.intern());//返回true
	}
}
