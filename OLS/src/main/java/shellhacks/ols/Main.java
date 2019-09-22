package ols;

import java.io.IOException;
import java.io.FileReader;

import ols.ast.Program;
import ols.syntax.*;

/**
 * Main class for OLS compiler
 * 	The main method displays the abstract syntax tree (AST)
 *  of the input with proper indentations.
 * 
 * @author ShutoAraki
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		if (args.length != 1) {
			System.out.println("Type in the file name as a command line argument.");
		} else {
			String filename = args[0];
			
			Scanner scanner = new Scanner(new FileReader(System.getProperty("user.dir") + "/" + filename));
			Parser parser = new Parser(scanner);
			// This Program object is the root of the AST
			Program program = parser.parseProgram();
			program.interpret();
		}
		
	}
}
