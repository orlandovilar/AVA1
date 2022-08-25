package com.example.ava1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

public class AVA1Activity extends Activity {

    EditText editTextA1;
    EditText editTextA2;
    EditText editTextA3;
    EditText editTextNotaFinal;
    EditText editTextSituacao;
    EditText editTextMotivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ava1);
        editTextA1 = (EditText) findViewById(R.id.A1);
        editTextA2 = (EditText) findViewById(R.id.A2);
        editTextA3 = (EditText) findViewById(R.id.A3);
        editTextNotaFinal = (EditText) findViewById(R.id.notaFinal);
        editTextSituacao = (EditText) findViewById(R.id.situacao);
        editTextMotivo = (EditText) findViewById(R.id.motivo);
    }

    public void calcular(View V) {
        double a1 = 0, a2 = 0, a3 = 0, nota1 = 0, nota2 = 0, notaFinal = 0;
        String situacao = "";
        String motivo = "";

        if(editTextA1.getText().toString().isEmpty()) {
            a1 = 0.0;
        } else {
            a1 = Double.parseDouble(editTextA1.getText().toString());
        }

        if(editTextA2.getText().toString().isEmpty()) {
            a2 = 0.0;
        } else {
            a2 = Double.parseDouble(editTextA2.getText().toString());
        }

        if(editTextA3.getText().toString().isEmpty()) {
            a3 = 0.0;
        } else {
            a3 = Double.parseDouble(editTextA3.getText().toString());
        }

        nota1 = a1;
        nota2 = a2;

        if(a2 < a3) {
            nota2 = a3;
        }

        if(a1 == 0.0 || (a2 < 5.0 && a3 < 5.0)) {
            situacao = "Aluno Reprovado";
            notaFinal = (nota1 * 0.4) + (nota2 * 0.6) / 2;
            if(a1 == 0.0) {
                motivo = "Nota A1 igual a 0.0";
            } else if(a2 < 5.0 && a3 < 5.0) {
                motivo = "Notas A2 e A3 menores que 5.0";
            }
        } else {
            notaFinal = (nota1 * 0.4) + (nota2 * 0.6);
            if(notaFinal >= 6.0) {
                situacao = "Aluno Aprovado";
                motivo = "Nota Final acima da média!";
            } else if(notaFinal < 6.0) {
                situacao = "Aluno Reprovado";
                motivo = "Nota Final abaixo da média!";
            }
        }

        editTextNotaFinal.setText(String.format("%.2f", notaFinal));
        editTextSituacao.setText(situacao);
        editTextMotivo.setText(motivo);
    }
}