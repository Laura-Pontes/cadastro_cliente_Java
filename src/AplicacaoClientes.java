import javax.swing.*;
import java.awt.*;
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
        String sqlCreate = "CREATE TABLE IF NOT EXISTS clientes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT," +
                "telefone TEXT," +
                "cidade TEXT" +
                ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void montarGUI(){
        JFrame frame = new JFrame("Cadastro de Clientes");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel painelTop = new JPanel(new GridLayout(2, 4, 5, 5));
        frame.add(painelTop, BorderLayout.NORTH);

        painelTop.add(new JLabel("Nome"));
        JTextField tfNome = new JTextField();
        painelTop.add(tfNome);

        painelTop.add(new JLabel("Telefone:"));
        JTextField tfTelefone = new JTextField();
        painelTop.add(tfTelefone);

        painelTop.add(new JLabel("Cidade:"));
        JTextField tfCidade = new JTextField();
        painelTop.add(tfCidade);

        String[] colunas = {"Nome", "Telefone", "Cidade"};
        DefaultTableModel tabelaModel = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(tabelaModel);

        carregarClientes(tabelaModel);

        tabela.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                int row = tabela.getSelectedRow();
                if(row !=1){
                    tfNome.setText(tabelaModel.getValueAt(row, 0).toString());
                    tfTelefone.setText(tabelaModel.getValueAt(row, 1).toString());
                    tfCidade.setText(tabelaModel.getValueAt(row, 2).toString());
                }
            }
        });

        JButton btnCadastrar = new JButton("Cadastrar");
        painelTop.add(btnCadastrar);

        btnCadastrar.addActionListener(e ->{
            String nome = tfNome.getText();
            String telefone = tfTelefone.getText();
            String cidade = tfCidade.getText();

            if (nome.isEmpty() || telefone.isEmpty() || cidade.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Preencha todos os campos!");
                return;
            }

            try{
                String sql = "INSERT INTO clientes (nome, telefone, cidade) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2, telefone);
                ps.setString(3, cidade);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Cliente cadastrado!");

                carregarClientes(tabelaModel);

                tfNome.setText("");
                tfTelefone.setText("");
                tfCidade.setText("");
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao cadastrar:\n" + ex.getMessage());
            }
        });

        JButton btnLimparCampos = new JButton("Limpar Campos");
        painelTop.add(btnLimparCampos);

        btnLimparCampos.addActionListener(e ->{
            tfNome.setText("");
            tfTelefone.setText("");
            tfCidade.setText("");
        });

        carregarClientes(tabelaModel);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setPreferredSize(new Dimension(780, 350));
        frame.add(scroll, BorderLayout.CENTER);

        JPanel painelBottom = new JPanel();
        frame.add(painelBottom, java.awt.BorderLayout.SOUTH);

        JButton btnExcluir = new JButton("Excluir selecionado");
        painelBottom.add(btnExcluir);

        btnExcluir.addActionListener(e ->{
            int row = tabela.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(frame, "Selecione para excluir!");
                return;
            }

            String nomeSelecionado = tabelaModel.getValueAt(row, 0).toString();

            try{
                String sql = "DELETE FROM clientes WHERE nome = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nomeSelecionado);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Cliente removido!");

                carregarClientes(tabelaModel);
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(frame, "Erro ao excluir:\n" + ex.getMessage());
            }
        });

        JButton btnEditar = new JButton(("Editar"));
        painelBottom.add(btnEditar);

        btnEditar.addActionListener((e ->{
            int row = tabela.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(frame, "Selecione para editar!");
                return;
            }

            String nomeOriginal = tabelaModel.getValueAt(row, 0).toString();
            String novoNome = tfNome.getText();
            String novoTelefone = tfTelefone.getText();
            String novaCidade = tfCidade.getText();

            try{
                String sql = "UPDATE clientes SET nome=?, telefone=?, cidade=? WHERE nome=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, novoNome);
                ps.setString(2, novoTelefone);
                ps.setString(3, novaCidade);
                ps.setString(4, nomeOriginal);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Atualizado!");
                carregarClientes(tabelaModel);
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(frame, "Erro ao editar:\n" + ex.getMessage());
            }
        }));

        JButton btnLimparTela = new JButton("Limpar tabela");
        painelBottom.add(btnLimparTela);

        btnLimparTela.addActionListener(e ->{
            try{
                PreparedStatement ps = conn.prepareStatement("DELETE FROM clientes");
                ps.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Todos os cadastros foram apagados!");
                carregarClientes(tabelaModel);
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(frame, "Erro ao limpar:\n" + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }

    private void carregarClientes(DefaultTableModel tableModel){
        tableModel.setRowCount(0);

        try{
            String sql = "SELECT nome, telefone, cidade FROM clientes";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String cidade = rs.getString("cidade");
                tableModel.addRow(new Object[]{nome, telefone, cidade});
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao carregar:\n" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AplicacaoClientes::new);
    }
}


