package asrdelivery.com.br.asrdelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityDadosPessoais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pessoais);
    }
    public void irParaStatusPedido(View view) {
        Intent intentStatusPedido = new Intent(getApplicationContext(), ActivityStatusPedido.class);
        startActivity(intentStatusPedido);
    }
}
