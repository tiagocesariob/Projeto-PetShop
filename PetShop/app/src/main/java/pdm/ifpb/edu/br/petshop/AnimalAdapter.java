package pdm.ifpb.edu.br.petshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tiago on 15/07/2016.
 */
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
    public View getView(int position, View convertView, ViewGroup parent) {
      /*  View view;
        Animal p = this.lista.get(position);


       tem que implementar esta incompleto



        return view;*/

return null; //null so para nao ficar com error
    }
}