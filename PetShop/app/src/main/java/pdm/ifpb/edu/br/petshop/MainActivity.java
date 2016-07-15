package pdm.ifpb.edu.br.petshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private Button btcadastro, btlistar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.loadComponentes();
        this.defineListeners();
    }

    private void loadComponentes() {
        this.btcadastro = (Button) findViewById(R.id.btcadastro);
        this.btlistar = (Button) findViewById(R.id.btlistar);
    }

    private void defineListeners() {
        this.btcadastro.setOnClickListener(new Onclick());
        this.btlistar.setOnClickListener(new Onclick());

    }

    private class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.equals(MainActivity.this.btcadastro)){
                Intent it = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(it);
            }else{
                Intent it = new Intent(MainActivity.this, ListAnimalActivity.class);
                startActivity(it);
            }
        }
    }
}