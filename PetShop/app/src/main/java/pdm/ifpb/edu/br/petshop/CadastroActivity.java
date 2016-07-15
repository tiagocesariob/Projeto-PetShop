package pdm.ifpb.edu.br.petshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText etnome;
    private Button btsalvar;
    private AnimalDAO ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.loadComponentes();
        this.defineListeners();
        this.ad = new AnimalDAO(this);

    }

    private void loadComponentes(){
        this.btsalvar = (Button) findViewById(R.id.btsalvar);
        this.etnome = (EditText) findViewById(R.id.etnome);
    }

    private void defineListeners(){
        this.btsalvar.setOnClickListener(new OnClickBotao());

    }

    private class OnClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String nome = CadastroActivity.this.etnome.getText().toString();
            CadastroActivity.this.ad.inserir(new Animal(nome));

        }
    }
}
