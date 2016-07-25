package pdm.ifpb.edu.br.petshop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;




public class AnimalAdapter extends BaseAdapter {

    private List<Animal> lista;
    private Context context;

    public AnimalAdapter(List<Animal> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View view;
        Animal p = this.lista.get(position);


        if (convertView == null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.animal_layout, null);

        }else view = convertView;

        TextView tv = (TextView) view.findViewById(R.id.tvNomeAnimalLayout);
        tv.setText(p.getNome());

        //acrescentei endereco
        TextView tv1 = (TextView) view.findViewById(R.id.tvEnderecoAnimalLayout);
        tv1.setText(p.getEndereco());

        //acrescentei telefone
        TextView tv2 = (TextView) view.findViewById(R.id.tvTelefoneAnimalLayout);
        tv2.setText(p.getTelefone());


        ImageButton deletarBt = (ImageButton) view.findViewById(R.id.deletar);
        deletarBt.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                AnimalDAO bd = new AnimalDAO(context);
                bd.remover(lista.get(position));
                view.setVisibility(View.GONE);

            }
        });

        ImageButton editarBt = (ImageButton) view.findViewById(R.id.editar);
        editarBt.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                AnimalDAO bd = new AnimalDAO(context);
                bd.remover(lista.get(position));
                Intent intent = new Intent(context, CadastroActivity.class);
                intent.putExtra("id", lista.get(position).getId());
                intent.putExtra("nome", lista.get(position).getNome());
                intent.putExtra("endereco", lista.get(position).getEndereco());
                intent.putExtra("telefone", lista.get(position).getTelefone());
                context.startActivity(intent);
            }
        });

        ImageButton telefonarBT = (ImageButton) view.findViewById(R.id.telefonar);
        telefonarBT.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                        String num= lista.get(position).getTelefone();
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:"+ num));
                        context.startActivity(callIntent);

            }
        });



        return view;
    }


}