package ols.ast;

import ols.interp.SymbolTable;
import ols.interp.Value;
import ols.interp.BoolValue;
import ols.interp.IntValue;

public class UnOp extends Expr {
	
	private Op1 op;
	private Expr expr;
	
	public UnOp(Op1 op, Expr expr) {
		this.op = op;
		this.expr = expr;
	}

	@Override
	public void display(String indentation) {
		System.out.println(indentation + "UnOp " + op);
		expr.display(indentation + "  ");
	}

	@Override
	public Value interpret(SymbolTable t) {
		Value value = expr.interpret(t);
		switch(op) {
		case Neg:
			return new IntValue(- value.intValue());
		case Not:
			return new BoolValue(! value.boolValue());
		default:
			return null; // unreachable
		}
	}

}
