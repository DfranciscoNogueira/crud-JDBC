package br.com.estudo.dao;

import static br.com.estudo.util.BuscarPropriedade.getString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estudo.entity.Pessoa;
import br.com.estudo.util.JDBCConnection;

public class PessoaDao {

    private static final String SQL_INSERT = getString("SQL_INSERT");
    private static final String SQL_FIND_BY_ID = getString("SQL_FIND_BY_ID");
    private static final String SQL_FIND_ALL = getString("SQL_FIND_ALL");
    private static final String SQL_UPDATE = getString("SQL_UPDATE");
    private static final String SQL_DELETE = getString("SQL_DELETE");

    public void save(Pessoa pessoa) {

        Connection connection = JDBCConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getProfissao());
            statement.setDate(3, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.closeConnection(connection, statement, null);
            System.out.println("Dados salvos com sucesso !");
        }
    }

    public void update(Pessoa pessoa) {

        Connection connection = JDBCConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getProfissao());
            statement.setDate(3, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            statement.setInt(4, pessoa.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.closeConnection(connection, statement, null);
            System.out.println("Dados atualizados com sucesso !");
        }
    }

    public void delete(Pessoa pessoa) {

        Connection connection = JDBCConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1, pessoa.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.closeConnection(connection, statement, null);
            System.out.println("Dados deletados com sucesso !");
        }
    }

    public Pessoa findById(int id) {
        Connection connection = JDBCConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Pessoa pessoa = new Pessoa();
        try {
            statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setInt(1, id);
            statement.execute();
            resultSet = statement.getResultSet();

            while (resultSet.next()) {
                pessoa.setId(resultSet.getInt("id"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setProfissao(resultSet.getString("profissao"));
                pessoa.setDataNascimento(resultSet.getDate("dataNascimento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.closeConnection(connection, statement, null);
        }
        return pessoa;
    }

    public List<Pessoa> findAll() {
        Connection connection = JDBCConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            statement = connection.prepareStatement(SQL_FIND_ALL);
            statement.execute();
            resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(resultSet.getInt("id"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setProfissao(resultSet.getString("profissao"));
                pessoa.setDataNascimento(resultSet.getDate("dataNascimento"));
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnection.closeConnection(connection, statement, null);
        }
        return pessoas;
    }

}
