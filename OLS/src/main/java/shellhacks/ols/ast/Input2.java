package ols.ast;

import java.util.Scanner;

import ols.interp.SymbolTable;
import ols.interp.Value;
import ols.interp.VoidValue;
import ols.interp.IntCell;

public class Input2 extends Stmt {
	
	private String msg;
	private String id;

	public Input2(String msg, String id) {
		this.msg = msg;
		this.id = id;
	}

	@Override
	public void display(String indentation) {
		System.out.println(indentation + "Input2 \"" + msg + "\", " + id);
	}

	@Override
	public Value interpret(SymbolTable t) {
		IntCell lhs = (IntCell) t.lookup(id);
		System.out.print(msg + " ");
		Scanner sc = SymbolTable.sc;
		String input = sc.nextLine();
		lhs.set(Integer.parseInt(input));
		return new VoidValue();
	}

}
