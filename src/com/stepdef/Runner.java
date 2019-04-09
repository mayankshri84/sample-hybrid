package com.stepdef;

public class Runner {
	public static void main(String[] args) throws Throwable {
	    String[] arguments = {"mvn", "clean"};
	    cucumber.api.cli.Main.main(arguments);
	}

}
