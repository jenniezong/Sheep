package jvm;

public class StaticDog {

	static int num;
	
	public static int setNum() {
		++num;
		return num;
	}
	
	public static int setLocalNum(int j) {
		int i = 10;
		i = j;
		return i;
	}
}
