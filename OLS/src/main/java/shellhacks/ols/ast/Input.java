package ols.ast;

import java.util.Scanner;

import ols.interp.SymbolTable;
import ols.interp.Value;
import ols.interp.VoidValue;

public class Input extends Stmt {
	
	private String msg;

	public Input(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void display(String indentation) {
		System.out.println(indentation + "Input \"" + msg + "\"");
	}

	@Override
	public Value interpret(SymbolTable t) {
		Scanner sc = SymbolTable.sc;
		System.out.print(msg);
		
		sc.nextLine();
		
		return new VoidValue();
	}
}
