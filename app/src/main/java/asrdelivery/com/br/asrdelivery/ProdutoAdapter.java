package asrdelivery.com.br.asrdelivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    private final Context context;
    private final ArrayList<Produto> elementos;

    public ProdutoAdapter(Context context, ArrayList<Produto> elementos){
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView produto = (TextView) rowView.findViewById(R.id.txtProduto);
        //TextView ingredientes = (TextView) rowView.findViewById(R.id.txtIngredientes);
        TextView preco = (TextView) rowView.findViewById(R.id.txtPreco);

        produto.setText(elementos.get(position).getDescricao());
        //ingredientes.setText(elementos.get(position).getIngredientes());
        preco.setText(Integer.toString(elementos.get(position).getPreco()));

        return rowView;
    }
}
