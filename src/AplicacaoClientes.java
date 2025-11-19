import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class AplicacaoClientes {

    private static final String DB_URL = "jdbc:sqlite:clientes.db";
    private Connection conn;

    public AplicacaoClientes() {
        conectarBanco();
        montarGUI();
    }

    private void conectarBanco() {
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Conectado ao banco.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco:\n" + e.getMessage());
        }
    }
    private void montarGUI(){
        JFrame frame = new JFrame("Cadastro de Clientes");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel painelTop = new JPanel();
        frame.add(painelTop);

        painelTop.add(new JLabel("Nome"));
        JTextField tfNome = new JTextField(30);
        painelTop.add(tfNome);

        painelTop.add(new JLabel("Email:"));
        JTextField tfEmail = new JTextField(30);
        painelTop.add(tfEmail);

        painelTop.add(new JLabel("Telefone:"));
        JTextField tfTelefone = new JTextField(15);
        painelTop.add(tfTelefone);

        painelTop.add(new JLabel("Cidade:"));
        JTextField tfCidade = new JTextField(20);
        painelTop.add(tfCidade);

        JButton btnCadastrar = new JButton("Cadastrar");
        painelTop.add(btnCadastrar);

        JButton btnLimparCampos = new JButton("Limpar Campos");
        painelTop.add(btnLimparCampos);

        String[] colunas = {"Nome", "Email", "Telefone", "Cidade"};
        DefaultTableModel tabelaModel = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(tabelaModel);

        JScrollPane scroll = new JScrollPane(tabela);
        frame.add(scroll);

        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(AplicacaoClientes::new);
    }
}


