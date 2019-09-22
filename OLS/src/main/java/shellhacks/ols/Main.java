package ols;

import java.io.*;
import ols.ast.Program;
import ols.syntax.*;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

/**
 * Main class for OLS compiler
 * 	The main method displays the abstract syntax tree (AST)
 *  of the input with proper indentations.
 * 
 * @author ShutoAraki
 */
public class Main {
	
	public static void main(String[] args) throws IOException {

		Javalin app = Javalin.create(config -> {
			config.addSinglePageRoot("/", "src/resource/index.html", Location.EXTERNAL);
		}).start(7000);
		
		/*
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use your special stream
		System.setOut(ps);
		// Print some output: goes to your special stream
		String input = 'proceso modulo1; val num1 = 6; val num2 = 7; var respuesta: ent; empezar dejar respuesta = num1 * num2; escribir "La respuesta es", respuesta, "!" fin.';
		Scanner scanner = new Scanner(input);
		Parser parser = new Parser(scanner);
		// This Program object is the root of the AST
		Program program = parser.parseProgram();
		try {
			program.interpret();
			// Put things back
			System.out.flush();
			System.setOut(old);
			// Show what happened
			String output = baos.toString();
			System.out.println("SUCCESS!: " + output);
		} catch(Exception e) {
			String output = "ERROR";
			System.out.println(output);
		}
		*/

		app.post("/run-ols", ctx -> {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			// IMPORTANT: Save the old System.out!
			PrintStream old = System.out;
			// Tell Java to use your special stream
			System.setOut(ps);
			// Print some output: goes to your special stream
			String input = ctx.formParam("input");
			Scanner scanner = new Scanner(input);
			Parser parser = new Parser(scanner);
			// This Program object is the root of the AST
			Program program = parser.parseProgram();
			program.interpret();
			// Put things back
			System.out.flush();
			System.setOut(old);
			// Show what happened
			String output = baos.toString();
			ctx.html(output);
		});
	}
}
