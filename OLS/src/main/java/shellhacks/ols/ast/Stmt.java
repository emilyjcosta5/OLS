package ols.ast;

import ols.interp.SymbolTable;
import ols.interp.Value;

public abstract class Stmt extends ASTNode {
	public abstract Value interpret(SymbolTable t);
}
