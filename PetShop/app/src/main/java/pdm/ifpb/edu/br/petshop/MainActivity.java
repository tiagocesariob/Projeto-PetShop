package pdm.ifpb.edu.br.petshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btcadastro, btlistar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.loadComponentes();
    }

    private void loadComponentes(){
        this.btcadastro = (Button) findViewById(R.id.btcadastro);
        this.btlistar = (Button) findViewById(R.id.btlistar);
    }
}
