package ols.interp;

public class IntValue extends Value {

	protected int intValue;
	
	public IntValue(int n) {
		intValue = n;
	}
	
	public int intValue() {
		return intValue;
	}

	public boolean boolValue() {
		System.out.println("Cannot get a boolean value from int");
		System.exit(0);
		return false;
	}
}
