package asrdelivery.com.br.asrdelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddProdutoActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produto);

        bd = new BDSQLiteHelper(this);

        final EditText nome = (EditText) findViewById(R.id.edtProduto);
        final EditText ingredientes = (EditText) findViewById(R.id.edtIngredientes);
        final EditText preco = (EditText) findViewById(R.id.edtPreco);
        Button adicionar = (Button) findViewById(R.id.btnAddProduto);
        adicionar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Produto produto = new Produto();
                produto.setDescricao(nome.getText().toString());
                produto.setIngredientes(ingredientes.getText().toString());
                produto.setPreco(Integer.parseInt(preco.getText().toString()));
                bd.addProduto(produto);

                Toast.makeText(getBaseContext(), "Produto inserido com sucesso", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void irParaCardapio(View view){
        Toast.makeText(getBaseContext(), "EXIBIÇÃO DO CARDAPIO", Toast.LENGTH_LONG).show();
        Intent intentCardapio = new Intent(getApplicationContext(),ActivityCardapio.class);
        startActivity(intentCardapio);
    }

}
