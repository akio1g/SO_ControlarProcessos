package view;

import java.util.Scanner;

import controller.ControleProcessos;

public class Principal {

	public static void main(String[] args) {
		ControleProcessos CP = new ControleProcessos();
		Scanner sc = new Scanner(System.in);
		int op = 0;
		do {
			System.out.println("1 - Ver processos || 2 - Matar processo por PID || 3 - Matar processo por nome || 4 - SAIR");
			op = sc.nextInt();
			if (op == 1) {
				System.out.println(CP.IdentificadorSO());
				System.out.println("\n\n\n");
				CP.listarProcessos(CP.IdentificadorSO());
			} else if (op == 2) {
				System.out.println("PID: ");
				int pid = sc.nextInt();
				CP.killProcessPID(CP.IdentificadorSO(), pid);
			} else if (op == 3) {
				System.out.println("Nome do Processo: ");
				String name = sc.next();
				CP.killProcessName(CP.IdentificadorSO(), name);
			}
		} while (op != 4);
		sc.close();
	}

}
