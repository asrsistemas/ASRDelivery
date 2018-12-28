package asrdelivery.com.br.asrdelivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irParaTelaMontagemPedido(View view){
        Intent intentMontagemPedido = new Intent(getApplicationContext(),TelaMontagemPedido.class);
        startActivity(intentMontagemPedido);

    }
}
