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

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
      *//*  View view;
        Animal p = this.lista.get(position);


       tem que implementar esta incompleto



        return view;*//*

return null; //null so para nao ficar com error
    }*/

    /*@Override
    public View getView(int position, View arg1, ViewGroup arg2) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.animal, null);

        TextView tv = (TextView) layout.findViewById(R.id.nome);
        tv.setText(lista.get(position).getNome());


        Button editarBt = (Button) layout.findViewById(R.id.editar);
        editarBt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, CadastroActivity.class);
                intent.putExtra("nome", lista.get(auxPosition).getNome());
               // intent.putExtra("email", lista.get(auxPosition).getEmail());
                intent.putExtra("id", lista.get(auxPosition).getId());
                context.startActivity(intent);
            }
        });

        Button deletarBt = (Button) layout.findViewById(R.id.deletar);
        deletarBt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                AnimalDAO bd = new AnimalDAO(context);
                bd.remover(lista.get(auxPosition));

                layout.setVisibility(View.GONE);
            }
        });

        return layout;
    }*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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
        //tv2.setAutoLinkMask(Linkify.PHONE_NUMBERS);


        return view;
    }


}