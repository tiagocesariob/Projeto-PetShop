package pdm.ifpb.edu.br.petshop;

import java.util.List;

/**
 * Created by tiago on 15/07/2016.
 */
public interface DAO <T> {
    public void inserir(T novo);

    public void atualizar(T obj);

    public void remover(int id);

    public void remover(T obj);

    public T get(int id);

    public List<T> get();
}
