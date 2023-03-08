/*
RESUMO      : Página principal com os comandos solicitados no exercício 01
PROGRAMADORA: Luiza Felix
DATA        : 02/03/2023
 */

package view;

import javax.swing.JOptionPane;

import controller.KillerController;

public class Main {

	public static void main(String[] args) {
		KillerController killer = new KillerController();
		int opcao = 0;

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma configuração para ser acessada:\n 2) Lista de processos ativos\n 3) Matar um processo via PID\n 4)Matar um processo via NOME \n\n Para SAIR digite 0."));
			switch (opcao) {
			case 2:
				killer.listaProcessos();
				break;
			case 3:
				killer.mataPid(Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do Processo.")));
				break;
			case 4:
				killer.mataNome(JOptionPane.showInputDialog("Digite o NOME do Processo."));
				break;

			case 0:
				System.out.println("Programa finalizado com sucesso! ");
				break;
			default:
				System.out.println("!!! ERRO: Digite uma opção válida!!!");
			}

		} while (opcao != 0);

	}

}
