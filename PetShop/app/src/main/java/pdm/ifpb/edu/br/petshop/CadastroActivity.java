package pdm.ifpb.edu.br.petshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CadastroActivity extends AppCompatActivity {

    private EditText etnome;
    private EditText etendereco;
    private EditText ettelefone;
    private ImageButton btsalvar;
    private AnimalDAO ad;
    private Button btFoto;
    private ImageView imageView;
    private static final int FOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.loadComponentes();
        this.defineListeners();
        this.btListener();
        this.ad = new AnimalDAO(this);


    }

    private void loadComponentes(){
        this.btsalvar = (ImageButton) findViewById(R.id.btsalvar);
        this.etnome = (EditText) findViewById(R.id.etnome);
        this.etendereco = (EditText) findViewById(R.id.etendereco);
        this.ettelefone = (EditText) findViewById(R.id.ettelefone);
        this.btFoto = (Button) findViewById(R.id.btFoto);
        this.imageView = (ImageView) findViewById(R.id.imageView);
    }

    private void defineListeners(){
        this.btsalvar.setOnClickListener(new OnClickBotao());

    }

    private void btListener(){
        this.btFoto.setOnClickListener(new OnClick());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == FOTO){
                CadastroActivity.this.imageView.setImageBitmap((Bitmap) data.getParcelableExtra("data"));
            }
        }
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CadastroActivity.this.FOTO);
        }
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
