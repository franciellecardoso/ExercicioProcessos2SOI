package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	// Retorne o S.O que está em execução na máquina
	public String os() {
		String os = System.getProperty("os.name");

		return os;

	}

	// Lista processos
	public void ListaProcesso(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
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

	// mata processo por PID
	public void mataPID(String param) {
		String os = System.getProperty("os.name");
		String cmdPid = "";
		if (os.contains("Windows")) {
			cmdPid = "TASKKILL /PID";
		}
		if (os.contains("Linux")) {
			cmdPid = "kill -9";
		}
		int pid = 0;
		StringBuffer buffer = new StringBuffer();

		// TASKKILL /PID XXXX
		pid = Integer.parseInt(param);
		buffer.append(cmdPid);
		buffer.append(" ");
		buffer.append(pid);

		ListaProcesso(buffer.toString());

	}

	// mata processo por nome
	public void mataNome(String opc) {
		String os = System.getProperty("os.name");
		String cmdNome = "";
		if (os.contains("Windows")) {
			cmdNome = "TASKKILL /IM";
		}
		if (os.contains("Linux")) {
			cmdNome = "pkill -f";
		}

		StringBuffer buffer = new StringBuffer();

		// TASKKILL /IM nomedoprocesso.exe
		buffer.append(cmdNome);
		buffer.append(" ");
		buffer.append(opc);

		ListaProcesso(buffer.toString());

	}

}
