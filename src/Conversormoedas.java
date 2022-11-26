import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Conversormoedas {

    public static void inicia() {
        Object[] moedas = {"Dolar", "Euro", "Real", "Bitcoin"};
        ImageIcon icon = new ImageIcon("C:\\Users\\Marcos\\Pictures\\Saved Pictures\\criptomoeda.png");
        JFrame frame = new JFrame("JOptionPane teste");
        //Menu Principal
        JOptionPane.showMessageDialog(frame, "Seja bem vindo, ao conversor de moedas", null, JOptionPane.INFORMATION_MESSAGE, icon);
        moedas teste = new moedas();
        //Input da Moeda
        String in = (String) JOptionPane.showInputDialog(frame, "Escolha o tipo de moeda que voce vai inserir",
                "Opcao", JOptionPane.INFORMATION_MESSAGE, icon, moedas, null);


        System.out.println("StringIn: " + in);
        try {
            //Input do Valor
            String n_string = JOptionPane.showInputDialog("Digite o valor para ser convertido:");
            double n = Double.parseDouble(n_string);
            //Imput da Moeda
            String out = (String) JOptionPane.showInputDialog(frame, "Escolha o tipo de moeda que o valor vai se coverter",
                    "Opcao", JOptionPane.INFORMATION_MESSAGE, icon, moedas, null);
            System.out.println("StringOut: " + out);


            double conversao = teste.last(teste.getSigla(in), teste.getSigla(out));
            double n_out = n * conversao;
            System.out.println("conversao " + conversao);
            //Resultado
            JOptionPane.showMessageDialog(frame, "O valor convertido eh de " + teste.getSigla(out) + String.format("%.2f", n_out), null, JOptionPane.INFORMATION_MESSAGE, icon);

            //Deseja continuar?
            int i = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja continuar?"
            );
            if (i == JOptionPane.YES_OPTION) {
                System.out.println("Clicou em Sim");
                inicia();

            } else if (i == JOptionPane.NO_OPTION) {
                System.out.println("Clicou em Não");
                JOptionPane.showMessageDialog(frame, "Programa finalizado", null, JOptionPane.INFORMATION_MESSAGE, icon);
                System.exit(1);
            } else if (i == JOptionPane.CANCEL_OPTION) {
                System.out.println("Clicou em Cancel");
                JOptionPane.showMessageDialog(frame, "Programa Concluído", null, JOptionPane.INFORMATION_MESSAGE, icon);
                System.exit(1);
            }


        //Tratamento
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "O valor não é válido", null, JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }


    public static void main(String[] args) {
    inicia();

    }
}
