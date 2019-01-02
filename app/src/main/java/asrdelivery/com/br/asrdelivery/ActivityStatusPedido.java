package asrdelivery.com.br.asrdelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityStatusPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_pedido);
    }
    public void sair(View view) {
        Intent intentSair = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intentSair);
    }
}
