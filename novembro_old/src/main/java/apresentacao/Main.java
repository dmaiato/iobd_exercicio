/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package apresentacao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import negocio.Veiculo;
import persistencia.VeiculoDAO;

public class Main {
    
    public static void main(String[] args) throws SQLException {

        Scanner in = new Scanner(System.in);
        int option;
        VeiculoDAO vdao = new VeiculoDAO();

        do {
            System.out.println("\n======== Menu ========");
            System.out.println("1 - Listar veiculos");
            System.out.println("2 - Adicionar veiculo");
            System.out.println("3 - Deletar veiculo");
            System.out.println("4 - Atualizar veiculo");
            System.out.println("5 - Sair");
            System.out.print("opcao: ");
            option = Integer.parseInt(in.nextLine());
            System.out.println();

            switch (option) {
                case 1 -> {
                    ArrayList<Veiculo> veiculos = vdao.listar();
                    
                    for (int i = 0; i < veiculos.size(); i++) {
                        System.out.println(veiculos.get(i));
                    }
                
                    break;

                }

                case 2 -> {
                    System.out.print("Placa: ");
                    String placa = in.nextLine();
                    System.out.print("Ano: ");
                    int ano = Integer.parseInt(in.nextLine());

                    Veiculo veiculo = new Veiculo();
                    veiculo.setPlaca(placa);
                    veiculo.setAno(ano);

                    vdao.inserir(veiculo);

                    break;
                }

                case 3 -> {
                    System.out.print("Id veiculo: ");
                    int id;

                    try {
                        id = Integer.parseInt(in.nextLine());
                    } catch (Exception e) {
                        System.out.println("id invalido.");
                        break;
                    }

                    Veiculo veiculo = vdao.obter(id);

                    if (veiculo.getId() == 0) {
                        System.out.println("id invalido.");
                        break;
                    }
                    
                    vdao.deletar(id);
                    break;
                }

                case 4 -> {
                    String opcao;
                    System.out.print("Id veiculo: ");
                    int id;

                    try {
                        id = Integer.parseInt(in.nextLine());
                    } catch (Exception e) {
                        System.out.println("id invalido.");
                        break;
                    }

                    Veiculo veiculo = vdao.obter(id);

                    if (veiculo.getId() == 0) {
                        System.out.println("id invalido.");
                        break;
                    }

                    System.out.println(veiculo);

                    System.out.print("Deseja atualizar placa? (s/n): ");
                    opcao = in.nextLine();

                    if (opcao.equals("s")) {
                        System.out.print("Placa nova: ");
                        String placa = in.nextLine();
                        veiculo.setPlaca(placa);
                    }

                    System.out.print("Deseja atualizar ano? (s/n): ");
                    opcao = in.nextLine();

                    if (opcao.equals("s")) {
                        System.out.print("Ano novo: ");
                        int ano = Integer.parseInt(in.nextLine());
                        veiculo.setAno(ano);
                    }

                    vdao.atualizar(veiculo);

                    break;

                }

                default -> {
                    break;
                }
            }
        } while (option != 5);
        in.close();
    }
    
}
