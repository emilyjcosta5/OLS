package ols.ast;

import ols.interp.BoolCell;
import ols.interp.IntCell;
import ols.interp.SymbolTable;
import ols.interp.Value;

public class Assign extends Stmt {

	private String id;
	private Expr expr;
	
	public Assign(String id, Expr expr) {
		this.id = id;
		this.expr = expr;
	}
	
	public void display(String indentation) {
		System.out.println(indentation + "Assign " + id);
		expr.display(indentation + "  ");
	}

	@Override
	public Value interpret(SymbolTable t) {
		
		Value lhs = t.lookup(id);
		Value rhs = expr.interpret(t);
		
		if (lhs instanceof IntCell)
			((IntCell) lhs).set(rhs.intValue());
		else 
			((BoolCell) lhs).set(rhs.boolValue());
		
		return rhs;
	}
}
