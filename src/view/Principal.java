package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Principal {

	public static void main(String[] args) {
		KillController killController = new KillController();

// m�todo 1		
		String os = killController.os();
		System.out.println(os);

		int opcao = 0;
		while (opcao != 4) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					" 1 - Listar os processos ativos \n 2 - Matar o processo ativo por PID \n 3 - Matar o processo ativo por Nome \n 4 - Finaliza "));
			switch (opcao) {
			case 1: // Lista processos
				String process = "TASKLIST /FO TABLE";
				killController.ListaProcesso(process);
				break;
			case 2: // mata processo por PID
				String par = "12756";
				killController.mataPID(par);
				break;
			case 3: // mata processo por nome
				String opc = "notepad.exe";
				killController.mataNome(opc);
			case 4:
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				break;
			}
		}
	}
}

// Professor, sei que algumas coisas faltaram ou n�o ajustei. 
// Preciso revisar alguns comando, m�todos e treinar bastante, 
// ent�o da pr�xima fa�o melhor *-* 
