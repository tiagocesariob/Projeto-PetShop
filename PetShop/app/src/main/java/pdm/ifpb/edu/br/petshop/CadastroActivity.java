package pdm.ifpb.edu.br.petshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.EditText;
import android.widget.ImageButton;

public class CadastroActivity extends AppCompatActivity {

    private EditText etnome;
    private EditText etendereco;
    private EditText ettelefone;
    private ImageButton btsalvar;
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
        this.btsalvar = (ImageButton) findViewById(R.id.btsalvar);
        this.etnome = (EditText) findViewById(R.id.etnome);
        this.etendereco = (EditText) findViewById(R.id.etendereco);
        this.ettelefone = (EditText) findViewById(R.id.ettelefone);
    }

    private void defineListeners(){
        this.btsalvar.setOnClickListener(new OnClickBotao());

    }

    private class OnClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String nome = CadastroActivity.this.etnome.getText().toString();
            String endereco = CadastroActivity.this.etendereco.getText().toString();
            String telefone = CadastroActivity.this.ettelefone.getText().toString();
            CadastroActivity.this.ad.inserir(new Animal(nome,endereco,telefone));
            Intent it = new Intent(CadastroActivity.this, ListarActivity.class);
            startActivity(it);
        }
    }
}
