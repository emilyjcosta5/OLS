package ols.ast;

import java.util.List;

import ols.interp.SymbolTable;
import ols.interp.Value;

public class Block extends ASTNode {
	
	private List<ValDecl> valDecls;
	private List<VarDecl> varDecls;
	private List<FunDecl> funDecls; 
	private Stmt stmt;
	
	public Block(List<ValDecl> valDecls, List<VarDecl> varDecls, List<FunDecl> funDecls, Stmt stmt) {
		this.valDecls = valDecls;
		this.varDecls = varDecls;
		this.funDecls = funDecls;
		this.stmt = stmt;
	}
	
	public void display(String indentation) {
        System.out.println(indentation + "Block");
        
        for (ValDecl val : valDecls)
        		val.display(indentation + "  ");
        for (VarDecl var : varDecls)
        		var.display(indentation + "  ");
        for (FunDecl fun : funDecls)
        		fun.display(indentation + "  ");
        
        stmt.display(indentation + "  ");
    }
	
	public Value interpret(SymbolTable t) {
				
		for (ValDecl d : valDecls) {
			d.interpret(t);
		}
		for (VarDecl d : varDecls) {
			d.interpret(t);
		}
		for (FunDecl d : funDecls) {
			d.interpret(t);
		}
		
		return stmt.interpret(t);
	}
}
