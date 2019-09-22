package ols.ast;

import ols.interp.BoolValue;
import ols.interp.SymbolTable;
import ols.interp.Value;

public class IfThenElse extends Stmt {
	
	private Expr expr;
	private Stmt s1;
	private Stmt s2;
	
	public IfThenElse(Expr expr, Stmt s1, Stmt s2) {
		this.expr = expr;
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void display(String indentation) {
		System.out.println(indentation + "IfThenElse");
		expr.display(indentation + "  ");
		s1.display(indentation + "  ");
		s2.display(indentation + "  ");
	}

	@Override
	public Value interpret(SymbolTable t) {
		BoolValue test = (BoolValue) expr.interpret(t);
		if (test.boolValue())
			return s1.interpret(t);
		else
			return s2.interpret(t);
	}

}
