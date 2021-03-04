package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ControleProcessos {

	public String IdentificadorSO() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void listarProcessos(String os) {
		String x[] = os.split(" ");
		String procW = "cmd /c TASKLIST /FO TABLE";
		String procL = "ps -ef";

		for (int y = 0; y < x.length; y++) {
			if (x[y].equals("Windows")) {
				try {
					Process p = Runtime.getRuntime().exec(procW);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while (linha != null) {
						System.out.println(linha);
						linha = buffer.readLine();
					}
					buffer.close();
					leitor.close();
					fluxo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (x[y].equals("Linux")) {
				try {
					Process p = Runtime.getRuntime().exec(procL);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					while (linha != null) {
						System.out.println(linha);
						linha = buffer.readLine();
					}
					buffer.close();
					leitor.close();
					fluxo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void killProcessPID(String os, int pid) {
		String x[] = os.split(" ");
		for (int y = 0; y < x.length; y++) {
			if (x[y].equals("Windows")) {
				String cmdPid = "cmd /c TASKKILL /PID";
				try {
					Runtime.getRuntime().exec(cmdPid + " " + pid);
				} catch (Exception e) {
					String erro = e.getMessage();
					System.err.println(erro);
				}
			} else if (x[y].equals("Linux")) {
				String cmdPid = "kill -9";
				try {
					Runtime.getRuntime().exec(cmdPid + " " + pid);
				} catch (Exception e) {
					String erro = e.getMessage();
					System.err.println(erro);
				}
			}
		}
	}

	public void killProcessName(String os, String name) {
		String x[] = os.split(" ");
		for (int y = 0; y < x.length; y++) {
			if (x[y].equals("Windows")) {
				String cmdname = "cmd /c TASKKILL /IM";
				try {
					Runtime.getRuntime().exec(cmdname + " " + name);
				} catch (Exception e) {
					String erro = e.getMessage();
					System.err.println(erro);
				}
			}
			else if (x[y].equals("Linux")) {
				String cmdname = "pkill -f";
				try {
					Runtime.getRuntime().exec(cmdname + " " + name);
				} catch (Exception e) {
					String erro = e.getMessage();
					System.err.println(erro);
				}
			}
		}
	}
}
