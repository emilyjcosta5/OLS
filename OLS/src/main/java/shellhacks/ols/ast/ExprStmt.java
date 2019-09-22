package ols.ast;

import ols.interp.SymbolTable;
import ols.interp.Value;

public class ExprStmt extends Stmt {

	private Expr expr;

	public ExprStmt(Expr expr) {
		this.expr = expr;
	}
	
	@Override
	public void display(String indentation) {
		System.out.println(indentation + "ExprStmt");
		expr.display(indentation + "  ");
	}

	@Override
	public Value interpret(SymbolTable t) {
		return expr.interpret(t);
	}

}
