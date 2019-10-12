package com.stariches;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws Exception {
		int port = 110110;
		new HelloServer(port).run();
	}
}
