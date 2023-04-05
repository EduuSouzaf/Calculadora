import javax.swing.*;
import java.text.DecimalFormat;

public class Calculadora extends javax.swing.JFrame{
    private JPanel painelCalculadora;
    private JButton jbDividir;
    private JButton jbMenos;
    private JButton jbMais;
    private JButton jbVezes;
    private JButton jbClear;
    private JButton jbSete;
    private JButton jbQuatro;
    private JButton jbUm;
    private JButton jbOito;
    private JButton jbNove;
    private JButton jbCinco;
    private JButton jbSeis;
    private JButton jbDois;
    private JButton jbTres;
    private JButton jbZero;
    private JButton jbClearAll;
    private JButton jbHexa;
    private JButton jbOctal;
    private JButton jbDecimal;
    private JButton jbEnter;
    private JButton jbBinario;
    private JTextField jtfVisor;

    //Declaração dos parametros
    public String botao;
    public String operacao;
    public Double primeiroValor;
    public Double segundoValor;
    String formato;

    //Construtor
    public Calculadora() {
        setContentPane(painelCalculadora);
        setTitle("Calculadora");
        //Fecha o visor
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //deixa setado o tamanho do visor
        setSize(350, 270);
        //impede a alteracao no tamanho do visor
        setResizable(false);
        //visor visivel
        setVisible(true);

        //Texto dos visores a direita
        jtfVisor.setHorizontalAlignment(jtfVisor.RIGHT);
        //Nao editar o visor
        jtfVisor.setEditable(false);
        //Visor sem borda
        jtfVisor.setBorder(null);

        //Eventos dos botoes de caracteres
        jbZero.addActionListener(e -> {
            botao = "0";
            SelecionarCaracter(botao);
        });
        jbUm.addActionListener(e -> {
            botao = "1";
            SelecionarCaracter(botao);
        });
        jbDois.addActionListener(e -> {
            botao = "2";
            SelecionarCaracter(botao);
        });
        jbTres.addActionListener(e -> {
            botao = "3";
            SelecionarCaracter(botao);
        });
        jbQuatro.addActionListener(e -> {
            botao = "4";
            SelecionarCaracter(botao);
        });
        jbCinco.addActionListener(e -> {
            botao = "5";
            SelecionarCaracter(botao);
        });
        jbSeis.addActionListener(e -> {
            botao = "6";
            SelecionarCaracter(botao);
        });
        jbSete.addActionListener(e -> {
            botao = "7";
            SelecionarCaracter(botao);
        });
        jbOito.addActionListener(e -> {
            botao = "8";
            SelecionarCaracter(botao);
        });
        jbNove.addActionListener(e -> {
            botao = "9";
            SelecionarCaracter(botao);
        });

        //Evento dos botoes que selecionam alguma operação matemática

        jbMais.addActionListener(e -> {
            try {

                primeiroValor  = Double.parseDouble(jtfVisor.getText());
                jtfVisor.setText("");
                operacao = "Somar";

            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });
        jbMenos.addActionListener(e -> {
            try {

                primeiroValor  = Double.parseDouble(jtfVisor.getText());
                jtfVisor.setText("");
                operacao = "Subtrair";

            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });
        jbVezes.addActionListener(e -> {
            try {

                primeiroValor  = Double.parseDouble(jtfVisor.getText());
                jtfVisor.setText("");
                operacao = "Multiplicar";

            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });
        jbDividir.addActionListener(e -> {
            try {

                primeiroValor = Double.parseDouble(jtfVisor.getText());
                jtfVisor.setText("");
                operacao = "Dividir";

            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }

        });

        //Evento botão enter, realiza as operações

        jbEnter.addActionListener(e -> {
            try {
                Operador operador = new Operador();

                segundoValor = Double.parseDouble(jtfVisor.getText());
                String visor = operador.SelecionarOperacao(operacao, primeiroValor, segundoValor);
                //SE A DIVISÃO FOR POR ZERO
                if (jtfVisor.getText().equals("Infinity")) {
                    jtfVisor.setText("Não é possível dividir por zero");
                }else {
                    jtfVisor.setText(visor);
                }

            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });

        //Eventos de limpeza do visor

        jbClear.addActionListener(e -> {
            try {
                primeiroValor = null;
                segundoValor = null;
                jtfVisor.setText("");
                jtfVisor.setText(jtfVisor.getText() + "");
            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });
        jbClearAll.addActionListener(e -> {
            try {
                primeiroValor = null;
                segundoValor = null;
                jtfVisor.setText("");
                jtfVisor.setText(jtfVisor.getText() + "");
            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });

        //Operações que convertem valores para binarios, decimal...

        jbBinario.addActionListener(e -> {
            try {
                Operador operador = new Operador();

                formato = "Binario";
                String valor = jtfVisor.getText();
                String visor = operador.ConverterValor(formato, valor);
                jtfVisor.setText(visor);
            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });
        jbDecimal.addActionListener(e -> {
            try {
                Operador operador = new Operador();

                formato = "Decimal";
                String valor = jtfVisor.getText();
                String visor = operador.ConverterValor(formato, valor);
                jtfVisor.setText(visor);
            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });
        jbOctal.addActionListener(e -> {
            try {
                Operador operador = new Operador();

                formato = "Octal";
                String valor = jtfVisor.getText();
                String visor = operador.ConverterValor(formato, valor);
                jtfVisor.setText(visor);
            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });
        jbHexa.addActionListener(e -> {
            try {
                Operador operador = new Operador();

                formato = "Hexa";
                String valor = jtfVisor.getText();
                String visor = operador.ConverterValor(formato, valor);
                jtfVisor.setText(visor);
            }catch (Exception ex) {
                // exception ao dar entrada nas informações
                String mensagem = "Erro em realizar a operação. Erro: " + ex.getMessage();
                String titulo = "Erro.";
                JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    //Main
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
    }

    //Seleciona os caracteres'
    public void SelecionarCaracter(String botao){

        if ("0".equals(botao)){
            jtfVisor.setText(jtfVisor.getText() + "0");
        }else if ("1".equals(botao)){
            jtfVisor.setText(jtfVisor.getText() + "1");
        }else if ("2".equals(botao)){
            jtfVisor.setText(jtfVisor.getText() + "2");
        }else if ("3".equals(botao)){
            jtfVisor.setText(jtfVisor.getText() + "3");
        }else if ("4".equals(botao)){
            jtfVisor.setText(jtfVisor.getText() + "4");
        }else if ("5".equals(botao)){
            jtfVisor.setText(jtfVisor.getText() + "5");
        }else if ("6".equals(botao)){
            jtfVisor.setText(jtfVisor.getText() + "6");
        }else if ("7".equals(botao)){
            jtfVisor.setText(jtfVisor.getText() + "7");
        }else if ("8".equals(botao)){
            jtfVisor.setText(jtfVisor.getText() + "8");
        }else if ("9".equals(botao)){
            jtfVisor.setText(jtfVisor.getText() + "9");
        }
    }
}