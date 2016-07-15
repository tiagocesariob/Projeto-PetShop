package pdm.ifpb.edu.br.petshop;

/**
 * Created by tiago on 15/07/2016.
 */
public class Animal {
    private int id;
    private String nome;

    public Animal() {
    }

    public Animal(String nome) { this.nome = nome;  }

    public int getId() {   return id;    }

    public void setId(int id) {  this.id = id;    }

    public String getNome() {  return nome;   }

    public void setNome(String nome) {  this.nome = nome;  }

    @Override
    public String toString() {
        return this.nome;
    }

}
