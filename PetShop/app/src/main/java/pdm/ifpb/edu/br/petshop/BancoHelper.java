package pdm.ifpb.edu.br.petshop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by tiago on 15/07/2016.
 */
public class BancoHelper extends SQLiteOpenHelper {
    private static final String BANCO = "petshop.db";
    private static final int VERSAO = 1;

    public BancoHelper(Context context) {
        super(context, BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table animal(" +
                "id integer primary key autoincrement not null, " +
                "nome string, endereco string, telefone string);";
        db.execSQL(sql);
        Log.i("PETSHOP", "Tabela animal criada.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}