package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillerController {
	public KillerController() {
		super();
	}

//	1)
	private String os() {

		String so = System.getProperty("os.name");
//		String aq = System.getProperty("os.arch");
//		String vr = System.getProperty("os.version");

		return so;
	}

//	2)
	public void listaProcessos() {
		String SO = os();
		if (SO.contains("Windows")) {
			lP_Windows();
		} else {
			lP_Linux();
		}
	}

	private void lP_Linux() {
		try {
			Process sproc = Runtime.getRuntime().exec("ps -ef");
			InputStream fluxo = sproc.getInputStream();
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

	private void lP_Windows() {
		try {
			Process sproc = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
			InputStream fluxo = sproc.getInputStream();
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

//	3)
	public void mataPid(int pid) {
		String SO = os();
		if (SO.contains("Windows")) {
			mP_Windows(pid);
		} else {
			mP_Linux(pid);
		}
	}

	private void mP_Linux(int pid) {
		try {
			Process sproc = Runtime.getRuntime().exec("kill -9 " + pid);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void mP_Windows(int pid) {
		try {
			Process sproc = Runtime.getRuntime().exec("TASKKILL /PID " + pid);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	4)
	public void mataNome(String nome) {
		String SO = os();
		if (SO.contains("Windows")) {
			mN_Windows(nome);
		} else {
			mN_Linux(nome);
		}
	}

	private void mN_Linux(String nome) {
		try {
			Process sproc = Runtime.getRuntime().exec("pkill -f " + nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void mN_Windows(String nome) {
		try {
			Process sproc = Runtime.getRuntime().exec("TASKKILL /IM " + nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
