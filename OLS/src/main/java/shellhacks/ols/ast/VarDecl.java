package ols.ast;

import ols.interp.BoolCell;
import ols.interp.IntCell;
import ols.interp.SymbolTable;

public class VarDecl {

	private String id;
	private Type type;

	public VarDecl(String id, Type type) {
		this.id = id;
		this.type = type;
	}
	
	public void display(String indentation) {
		System.out.println(indentation + "Var " + id + " : " + type);
	}

	public void interpret(SymbolTable t) {
		if (type == Type.Int)
			t.bind(id, new IntCell(0));
		else if (type == Type.Bool)
			t.bind(id,  new BoolCell(false));
	}
}
