package pdm.ifpb.edu.br.petshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiago on 15/07/2016.
 */
    public class AnimalDAO implements DAO <Animal> {
    private BancoHelper banco;
    private static final String TABELA = "animal";

    public AnimalDAO(Context context) {
        this.banco = new BancoHelper(context);
    }

    @Override
    public void inserir(Animal novo) {
        ContentValues cv = new ContentValues();
        cv.put("nome", novo.getNome());
        this.banco.getWritableDatabase().insert(TABELA, null, cv);
    }


    @Override
    public void atualizar(Animal obj) {
        ContentValues cv = new ContentValues();
        cv.put("nome", obj.getNome());
        this.banco.getWritableDatabase().update(TABELA, cv,"id = ?", new String[]{""+obj.getId()});
    }

    @Override
    public void remover(int id) {
        String[] where = {Integer.toString(id)};
        this.banco.getWritableDatabase().delete(TABELA, "id = ?", where);
    }

    @Override
    public void remover(Animal obj) {
        this.remover(obj.getId());
    }

    @Override
    public Animal get(int id) {
        return null;
    }


    //so ta buscando um atributo o  nome depois tem que colocar mais
    @Override
    public List<Animal> get() {
        String[] colunas = {"id", "nome"};
        List<Animal> lista = new ArrayList<Animal>();

        Cursor c = this.banco.getReadableDatabase().query(TABELA, colunas, null, null, null, null, "nome");
        if (c.getCount() > 0){
            c.moveToFirst();
            do{
                Animal a = new Animal();
                a.setId(c.getInt(c.getColumnIndex(colunas[0])));
                a.setNome(c.getString(1));
                lista.add(a);
            }while (c.moveToNext());
        }

        return lista;
    }
}

