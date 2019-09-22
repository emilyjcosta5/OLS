package ols.ast;

import ols.interp.SymbolTable;
import ols.interp.Value;

public class Id extends Expr {

	private String id;
	
	public Id(String id) {
		this.id = id;
	}

	@Override
	public void display(String indentation) {
		System.out.println(indentation + "Id " + id);
	}

	@Override
	public Value interpret(SymbolTable t) {
		return t.lookup(id);
	}
	
}
