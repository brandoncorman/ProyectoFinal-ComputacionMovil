package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ediUser, ediPass, ediNombre, ediApellido;
    Button btnActualizar, btnCancelar;
    int id = 0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        ediUser = (EditText)findViewById(R.id.EdiUser);
        ediPass = (EditText)findViewById(R.id.EdiPass);
        ediNombre = (EditText)findViewById(R.id.EdiNombre);
        ediApellido = (EditText)findViewById(R.id.EdiApellido);
        btnActualizar = (Button)findViewById(R.id.btnEdiActualizar);
        btnCancelar = (Button)findViewById(R.id.btnEdiCancelar);
        btnActualizar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");
        dao = new daoUsuario(this);
        u = dao.getUsuarioById(id);
        ediUser.setText(u.getUsuario());
        ediPass.setText(u.getContrasena());
        ediNombre.setText(u.getNombre());
        ediApellido.setText(u.getApellidos());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEdiActualizar:
                u.setUsuario(ediUser.getText().toString());
                u.setContrasena(ediPass.getText().toString());
                u.setNombre(ediNombre.getText().toString());
                u.setApellidos(ediApellido.getText().toString());
                if (!u.isNull()) {
                    Toast.makeText(this, "ERROR: Campos vacíos", Toast.LENGTH_LONG).show();
                } else if (dao.updateUsuario(u)) {
                    Toast.makeText(this, "¡Actualización exitosa!", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(EditarActivity.this, InicioActivity.class);
                    i2.putExtra("id", u.getId());
                    startActivity(i2);
                    finish();
                } else {
                    Toast.makeText(this, "¡No se puede actualizar!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnEdiCancelar:
                Intent i2 = new Intent(EditarActivity.this, InicioActivity.class);
                i2.putExtra("id", u.getId());
                startActivity(i2);
                finish();
                break;
        }
    }
}