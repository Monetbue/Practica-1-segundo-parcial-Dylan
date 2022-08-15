package com.example.primerapracticasegundoparcial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button boton1;
    Button boton2;
    Button boton3;
    Button boton4;

    private Boolean personalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = (Button) findViewById(R.id.boton1);
        boton2 = (Button) findViewById(R.id.boton2);
        boton3 = (Button) findViewById(R.id.boton3);
        boton4 = (Button) findViewById(R.id.boton4);



        personalizado = false;
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!personalizado)
                    verT();
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verTP();
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verD();
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verDP();
            }
        });

    }

    private void verT() {
        Toast.makeText(getApplicationContext(), "Xenoblade 3 es el mejor juego del año", Toast.LENGTH_LONG).show();
    }
    private void verTP() {
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,50);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toastpersonalizado,null);
        toast.setView(view);
        toast.show();
    }
    private void verD() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Mejor xenoblade ");

        alert.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Opcion guardada", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Opcion Cancelada", Toast.LENGTH_SHORT).show();
            }
        });
        String[] opc = {"Xenoblade 1", "Xenoblade 2", "Xenoblade 3"};
        alert.setSingleChoiceItems(opc, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(getApplicationContext(), "Opcion " + i + " seleccionada", Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:
                        personalizado = false;
                        break;
                    case 1:
                        break;
                    case 2:
                        personalizado = true;
                        break;
                }
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
    private void verDP() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        final View customlayout = getLayoutInflater().inflate(R.layout.dialogpersonalizado, null);
        alert.setView(customlayout);
        alert.setCancelable(false);
        EditText Nombre = customlayout.findViewById(R.id.name);

        alert.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                String name = Nombre.getText().toString();

            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();

    }

}