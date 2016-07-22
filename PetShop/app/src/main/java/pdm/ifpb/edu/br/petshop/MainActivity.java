package pdm.ifpb.edu.br.petshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btcadastro, btlistar;
    // private Context context;
   // private Button btligar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.loadComponentes();
        this.defineListeners();

       // btligar.setAutoLinkMask(Linkify.PHONE_NUMBERS);

    }

    private void loadComponentes() {
        this.btcadastro = (Button) findViewById(R.id.btcadastro);
        this.btlistar = (Button) findViewById(R.id.btlistar);

       // this.btligar = (Button) findViewById(R.id.btligar);
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

                Intent it = new Intent(MainActivity.this, ListarActivity.class);
                startActivity(it);
            }
        }
    }

    /*public void ligar(View view){
    LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    view = li.inflate(R.layout.animal_layout, null);
}*/


}