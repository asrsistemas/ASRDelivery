package asrdelivery.com.br.asrdelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityResumo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);
    }
    public void irParaTelaMontagemPedido(View view) {
        Intent intentMontagemPedido = new Intent(getApplicationContext(), TelaMontagemPedido.class);
        startActivity(intentMontagemPedido);
    }
    public void irParaDadosPessoais(View view) {
        Intent intentDadosPessoais = new Intent(getApplicationContext(), ActivityDadosPessoais.class);
        startActivity(intentDadosPessoais);
    }

}
