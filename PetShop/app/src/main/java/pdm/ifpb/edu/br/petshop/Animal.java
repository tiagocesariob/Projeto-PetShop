package pdm.ifpb.edu.br.petshop;

/**
 * Created by tiago on 15/07/2016.
 */
public class Animal {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;

    public Animal() {
    }

    public Animal(String nome,String endereco,String telefone) {
        this.nome = nome;
        this.endereco=endereco;
        this.telefone = telefone;
    }

    public int getId() {   return id;    }

    public void setId(int id) {  this.id = id;    }

    public String getNome() {  return nome;   }

    public void setNome(String nome) {  this.nome = nome;  }

    public String getEndereco(){return  endereco;}

    public void setEndereco(String endereco){this.endereco = endereco;}

    public String getTelefone() {return telefone; }

    public void setTelefone(String telefone) {this.telefone = telefone; }

    @Override
    public String toString() {
        return this.nome + ","+ this.endereco + "," + this.telefone;
    }

}
