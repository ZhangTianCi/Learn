package com.stariches;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("测试用jar");

		//String path = System.getProperty("JobInstanceMapper");
		Date startTime = new Date();
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "-" + new Date());
			Thread.sleep(1000);
		}
		if (startTime.compareTo(new Date()) < 0) return;
		String line = null;
		PrintWriter printWriter = null;
		BufferedReader output = null;
		BufferedReader error = null;
		try {
			String commond = " > log.log 2>&1 &";
			System.out.println(commond);
			Process process = Runtime.getRuntime().exec("/bin/sh ");
			output = new BufferedReader(new InputStreamReader(process.getInputStream()));
			error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			DataOutputStream os = new DataOutputStream(process.getOutputStream());
			os.writeBytes("java -jar /web/runner-0.0.1-SNAPSHOT.jar >log8.log 2>&1 &\n");
			os.writeBytes("ps -ef |grep service-0.0.1-SNAPSHOT.jar\n");
			os.writeBytes("exit\n");
			os.flush();
			while (true) {
				String outputLine = output.readLine();
				if (outputLine == null) break;
				String[] info = outputLine.split("\\s{1,}");
				System.out.print(info[1] + "-> ");
				for (int i = 7; i < info.length; i++) {
					System.out.print(info[i]);
					if (i + 1 < info.length) System.out.print(" ");
				}
				System.out.println("");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (error != null) error.close();
			if (output != null) output.close();
			if (output != null) output.close();
		}
	}
}
