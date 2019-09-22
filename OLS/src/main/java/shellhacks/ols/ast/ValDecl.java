package ols.ast;

import ols.interp.IntValue;
import ols.interp.SymbolTable;

public class ValDecl extends ASTNode {

	private String id;
	private int num;

	public ValDecl(String id, int num) {
		this.id = id;
		this.num = num;
	}
	
	public void display(String indentation) {
		System.out.println(indentation + "Val " + id + " = " + num);
	}

	public void interpret(SymbolTable t) {
		t.bind(id, new IntValue(num));
	}
}
