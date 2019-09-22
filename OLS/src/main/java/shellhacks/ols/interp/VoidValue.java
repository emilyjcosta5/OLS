package ols.interp;

public class VoidValue extends Value {

	public int intValue() {
		System.out.println("Void does not contain any information");
		System.exit(0);
		return 0;
	}

	public boolean boolValue() {
		System.out.println("Void does not contain any information");
		System.exit(0);
		return false;
	}

}
