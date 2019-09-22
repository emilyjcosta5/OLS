package ols.ast;

import ols.interp.IntValue;
import ols.interp.SymbolTable;
import ols.interp.Value;

public class Num extends Expr {

	private int value;
	
	public Num(int value) {
		this.value = value;
	}
	
	@Override
	public void display(String indentation) {
		System.out.println(indentation + "Num " + value);
	}

	@Override
	public Value interpret(SymbolTable t) {
		return new IntValue(value);
	}
}
