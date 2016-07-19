package pdm.ifpb.edu.br.petshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ListarActivity extends AppCompatActivity {
    private ListView listView;
    private AnimalDAO pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        this.pd = new AnimalDAO(this);
        this.instanciaComponentesInterface();

        this.atualizaAdapter();
    }
    private void atualizaAdapter(){
        this.listView.setAdapter(new AnimalAdapter(this.pd.get(), this));
    }

    private void instanciaComponentesInterface(){

        this.listView = (ListView) findViewById(R.id.lvAnimais);
    }

}
