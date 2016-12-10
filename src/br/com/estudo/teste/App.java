package br.com.estudo.teste;

import java.util.Date;
import java.util.List;

import br.com.estudo.dao.PessoaDao;
import br.com.estudo.entity.Pessoa;

public class App {
    
    public static void main(String[] args) {
        //new App().insert();
        //new App().findById(1);
        new App().findAll();
    }
    
    private void findAll(){
        List<Pessoa> pessoas = new PessoaDao().findAll();
        System.out.println(pessoas.toString());
    }
    
    private void insert(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Nelson");
        pessoa.setProfissao("Advogado");
        pessoa.setDataNascimento(new Date());
        new PessoaDao().save(pessoa);
    }
    
    private Pessoa findById(int id){
        Pessoa pessoa =  new PessoaDao().findById(id);
        System.out.println(pessoa.getId());
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getProfissao());
        System.out.println(pessoa.getDataNascimento());
        return pessoa;
    }

}
