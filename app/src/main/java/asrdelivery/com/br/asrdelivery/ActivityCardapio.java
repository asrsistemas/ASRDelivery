package asrdelivery.com.br.asrdelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityCardapio extends AppCompatActivity {

    private BDSQLiteHelper bd;
    private ArrayList<Produto> listaProduto = new ArrayList<Produto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bd = new BDSQLiteHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);
    }
    @Override
    protected void onStart(){
        Toast.makeText(getBaseContext(), "Produto inserido com sucesso", Toast.LENGTH_LONG).show();
        super.onStart();
        ListView lista = (ListView) findViewById(R.id.lvProdutos);
        listaProduto = bd.getAllProdutos();
        ProdutoAdapter adapter = new ProdutoAdapter(this, listaProduto);
        lista.setAdapter(adapter);
    }
}
