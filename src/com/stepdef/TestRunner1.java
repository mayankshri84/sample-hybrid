package com.stepdef;

import org.apache.maven.shared.invoker.*;

import java.io.*;
import java.util.*;

public class TestRunner1 {
	public static void main(String[] args)  {
		
		try{
			InvocationRequest request = new DefaultInvocationRequest();
			request.setPomFile(new File("pom.xml"));
			Invoker invoker = new DefaultInvoker();
			request.setGoals(Arrays.asList("install"));
			Properties prop = new Properties();
			prop.setProperty("cucumber.options", " --tags @Scenario1");
			//prop.setProperty("data", "myData");
			request.setProperties(prop);
			System.out.println(prop.getProperty("cucumber.options"));
			//System.out.println(System.getenv("MAVEN_HOME"));
			invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));
			InvocationResult result = invoker.execute(request);
			System.out.println(result.getExitCode());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
