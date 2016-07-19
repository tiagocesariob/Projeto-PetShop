package pdm.ifpb.edu.br.petshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ListarActivity extends AppCompatActivity {
    private ListView listView;
    private AnimalDAO pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);


        this.defineListeners();
        this.pd = new AnimalDAO(this);
        this.instanciaComponentesInterface();

        AnimalAdapter adapter = new AnimalAdapter(this.pd.get(), this);
        this.listView.setAdapter(adapter);

        this.atualizaAdapter();
    }
    private void atualizaAdapter(){
        this.listView.setAdapter(new AnimalAdapter(this.pd.get(), this));
    }

    private void instanciaComponentesInterface(){

        this.listView = (ListView) findViewById(R.id.lvPessoas);
    }

    private void defineListeners(){
        //this.listView.setOnClickListener(new OnClickBotao());
        this.listView.setOnItemLongClickListener(new OnLongClickList());

    }

    private class OnLongClickList implements AdapterView.OnItemLongClickListener{

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Animal p = (Animal) parent.getAdapter().getItem(position);
            ListarActivity.this.pd.remover(p);
            ListarActivity.this.atualizaAdapter();
            return true;
        }
    }

   /* private class OnClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            ListarActivity.this.atualizaAdapter();

        }
    }*/

}
