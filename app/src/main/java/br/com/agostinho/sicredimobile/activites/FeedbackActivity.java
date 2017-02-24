package br.com.agostinho.sicredimobile.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.util.BaseActivity;

public class FeedbackActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        setUpToolbar();
        setTitleToolbar("Feedback");

        Intent intent = getIntent();
        String operacao = intent.getStringExtra("OPERACAO");
        String conta = intent.getStringExtra("CONTA");
        String valor = intent.getStringExtra("VALOR");

        //configura os labels
        ((TextView)findViewById(R.id.lbl_feedback_operacao)).setText(operacao);
        ((TextView)findViewById(R.id.lbl_feedback_conta)).setText(conta);
        ((TextView)findViewById(R.id.lbl_feedback_valor)).setText(valor);

        //configura os eventos
        findViewById(R.id.btn_feedback_fechar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedbackActivity.this, PrincipalActivity.class));
            }
        });
    }
}
