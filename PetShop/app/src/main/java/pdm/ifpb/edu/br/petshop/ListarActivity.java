package pdm.ifpb.edu.br.petshop;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListarActivity extends AppCompatActivity {
    private ListView listView;
    private AnimalDAO pd;
    private Button call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        this.pd = new AnimalDAO(this);
        this.instanciaComponentesInterface();

        this.atualizaAdapter();

        call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);

                startActivity(callIntent);
            }
        });
        


    }
    private void atualizaAdapter(){
        this.listView.setAdapter(new AnimalAdapter(this.pd.get(), this));
    }

    private void instanciaComponentesInterface(){

        this.listView = (ListView) findViewById(R.id.lvAnimais);
        this.call = (Button) findViewById(R.id.call);

    }



}
