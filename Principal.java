package mapa02;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {

        Hospede hospede = new Hospede();
        Hospedagem hospedagem = new Hospedagem();
        SistemaReseva reseva = new SistemaReseva();
        
        Object escolha = JOptionPane.showInputDialog(null, "Escolha o tipo de reserva", "Opçao", 
        JOptionPane.INFORMATION_MESSAGE, null,
        hospedagem.tipo , hospedagem.tipo [0]);
        
        StringBuilder mensagem = new StringBuilder();
        
        if(escolha == "Simples"){
            String iQtdDiarias = JOptionPane.showInputDialog("Quantidade de diarias");
            reseva.qtdDiaria = Integer.parseInt(iQtdDiarias);
            
            String iQtdPessoas = JOptionPane.showInputDialog("Quantidade de Pessoas");
            reseva.qtdPessoas = Integer.parseInt(iQtdPessoas);
            
            if(reseva.qtdPessoas > hospedagem.capacidadeSimples){
                mensagem.append("A capacidade maxima de pessoas para uma suite simples é ").append(hospedagem.capacidadeSimples)
                .append(" Tente novamente com um valor aceitavel");
                JOptionPane.showMessageDialog(null, mensagem);
                System.exit(1);
            }else{
                
                JOptionPane.showInputDialog(null, "Escolha uma Suite", "Opçao", 
                JOptionPane.INFORMATION_MESSAGE, null,
                hospedagem.numHospSimples , hospedagem.numHospSimples [0]);
                hospedagem.FHospSimples[0] = Integer.parseInt(hospedagem.numHospSimples[0]);
                hospedagem.FHospSimples[1] = Integer.parseInt(hospedagem.numHospSimples[1]);
                hospedagem.FHospSimples[2] = Integer.parseInt(hospedagem.numHospSimples[2]);
                
                reseva.HospResponsavel = JOptionPane.showInputDialog("Nome do responsavel");
                
                System.out.println("== Reserva ==");
                System.out.println("Nome do responsavel: " + reseva.HospResponsavel);
                System.out.println("Quantidade de reserva: " + reseva.qtdDiaria);
                System.out.println("Quantidade de pessoas: " + reseva.qtdPessoas);
                System.out.println("== Hospedes ==");
                
                int contagem = reseva.qtdPessoas;
                
                for(int i = 0; i < contagem; i++){
                    hospede.nome = JOptionPane.showInputDialog("Nome do hospede " + (i + 1));
                    hospede.endereco = JOptionPane.showInputDialog("Endereço do hospede " + (i + 1));
                    String iIdade = JOptionPane.showInputDialog("Idade do hospede " + (i + 1));
                    hospede.idade = Integer.parseInt(iIdade);
                    if(hospede.idade <= 2){
                    reseva.qtdPessoas += - 1;
                    }
                    System.out.println((i + 1) + " - Hospede: " + hospede.nome);
                    System.out.println("Endereço: " + hospede.endereco);
                    System.out.println("Idade: " + hospede.idade);
                }
                
                int pessoas = contagem;
                double total = reseva.qtdDiaria * pessoas;
                total *= hospedagem.precoSimples;
                if(reseva.qtdDiaria > 7){
                    total = total - (total * 0.10) ;
                }

                mensagem.append("O preço da reserva ficou ").append(total)
                .append("$ para ").append(reseva.qtdDiaria).append(" dias, com ").append(reseva.qtdPessoas).append(" Pessoas");
                JOptionPane.showMessageDialog(null, mensagem);
            }
        }else if(escolha == "Luxo"){
            String iQtdDiarias = JOptionPane.showInputDialog("Quantidade de diarias");
            reseva.qtdDiaria = Integer.parseInt(iQtdDiarias);

            String iQtdPessoas = JOptionPane.showInputDialog("Quantidade de Pessoas");
            reseva.qtdPessoas = Integer.parseInt(iQtdPessoas);

            if(reseva.qtdPessoas > hospedagem.capacidadeLuxo){
                mensagem.append("A capacidade maxima de pessoas para uma suite Luxo é ").append(hospedagem.capacidadeLuxo)
                .append(" Tente novamente com um valor aceitavel");
                JOptionPane.showMessageDialog(null, mensagem);
                System.exit(1);
            }else{

                JOptionPane.showInputDialog(null, "Escolha uma Suite", "Opçao", 
                JOptionPane.INFORMATION_MESSAGE, null,
                hospedagem.numHospLuxo , hospedagem.numHospLuxo [0]);
                hospedagem.FHospLuxo[0] = Integer.parseInt(hospedagem.numHospLuxo[0]);
                hospedagem.FHospLuxo[1] = Integer.parseInt(hospedagem.numHospLuxo[1]);
                hospedagem.FHospLuxo[2] = Integer.parseInt(hospedagem.numHospLuxo[2]);
    
                reseva.HospResponsavel = JOptionPane.showInputDialog("Nome do responsavel");

                int contagem = reseva.qtdPessoas;

                for(int i = 0; i < contagem; i++){
                    hospede.nome = JOptionPane.showInputDialog("Nome do hospede " + (i + 1));
                    hospede.endereco = JOptionPane.showInputDialog("Endereço do hospede " + (i + 1));
                    String iIdade = JOptionPane.showInputDialog("Idade do hospede " + (i + 1));
                    hospede.idade = Integer.parseInt(iIdade);
                    if(hospede.idade <= 2){
                    reseva.qtdPessoas += - 1;
                    }
                }
                
                int pessoas = contagem;
                double total = reseva.qtdDiaria * pessoas;
                total *= hospedagem.precoLuxo;
                if(reseva.qtdDiaria > 7){
                    total = total - (total * 0.10) ;
                }

                mensagem.append("O preço da reserva ficou ").append(total)
                .append("$ para ").append(reseva.qtdDiaria).append(" dias, com ").append(reseva.qtdPessoas).append(" Pessoas");
                JOptionPane.showMessageDialog(null, mensagem);
            }
        }
    }
}