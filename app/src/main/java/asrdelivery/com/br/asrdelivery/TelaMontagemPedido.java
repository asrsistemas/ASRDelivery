package asrdelivery.com.br.asrdelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TelaMontagemPedido extends AppCompatActivity {

    Spinner tipo;
    Spinner exibirSabor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_montagem_pedido);

        tipo = (Spinner) findViewById(R.id.spinTipo);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tipo, android.R.layout.simple_spinner_item);
        tipo.setAdapter(adapter);

        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = tipo.getSelectedItem().toString();

                if(item.equals("2 SABORES")){
                    //fazer exibir o segundo sabor
                    exibirSabor2 = (Spinner) findViewById(R.id.spinSabor2);
                    exibirSabor2.setVisibility(View.VISIBLE);
                }
                if(item.equals("INTEIRA")){
                    exibirSabor2 = (Spinner) findViewById(R.id.spinSabor2);
                    exibirSabor2.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        tipo.setOnItemSelectedListener(escolha);

    }
    public void irParaResumo(View view) {
        Intent intentResumo = new Intent(getApplicationContext(), ActivityResumo.class);
        startActivity(intentResumo);
    }

}
