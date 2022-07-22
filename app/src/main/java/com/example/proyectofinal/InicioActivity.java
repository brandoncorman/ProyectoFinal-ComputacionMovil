package com.example.proyectofinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnEditar, btnEliminar, btnSalir;
    TextView nombre;
    int id = 0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        nombre = (TextView)findViewById(R.id.nombreUsuario);
        btnEditar=(Button)findViewById(R.id.btnEditar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        btnSalir=(Button)findViewById(R.id.btnSalir);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");
        dao = new daoUsuario(this);
        u = dao.getUsuarioById(id);
        nombre.setText(u.getNombre()+" "+u.getApellidos());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEditar:
                Intent a = new Intent(InicioActivity.this, EditarActivity.class);
                a.putExtra("id", id);
                startActivity(a);
                break;
            case R.id.btnEliminar:
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setMessage("¿Estás seguro de eliminar tu cuenta?");
                b.setCancelable(false);
                b.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(dao.deleteUsuario(id)) {
                            Toast.makeText(InicioActivity.this, "¡Se eliminó correctamente!", Toast.LENGTH_LONG).show();
                            Intent a = new Intent(InicioActivity.this, MainActivity.class);
                            startActivity(a);
                            finish();
                        } else {
                            Toast.makeText(InicioActivity.this, "ERROR: No se eliminó cuenta", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                b.show();
                break;
            case R.id.btnSalir:
                Intent i2 = new Intent(InicioActivity.this, MainActivity.class);
                startActivity(i2);
                finish();
                break;
        }
    }
}