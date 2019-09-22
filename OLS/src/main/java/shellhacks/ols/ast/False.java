package ols.ast;

import ols.interp.BoolValue;
import ols.interp.SymbolTable;
import ols.interp.Value;

public class False extends Expr {

	@Override
	public void display(String indentation) {
		System.out.println(indentation + "False");
	}

	@Override
	public Value interpret(SymbolTable t) {
		return new BoolValue(false);
	}
}
