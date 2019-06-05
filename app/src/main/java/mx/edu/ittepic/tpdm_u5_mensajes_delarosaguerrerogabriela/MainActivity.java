package mx.edu.ittepic.tpdm_u5_mensajes_delarosaguerrerogabriela;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText telefono,mensaje;
    Button enviar,permisos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        solicitarPermisos();
        telefono=findViewById(R.id.telefono);
        mensaje=findViewById(R.id.mensaje);
        enviar=findViewById(R.id.enviar);
        permisos=findViewById(R.id.permisos);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarSMS(telefono.getText().toString(),mensaje.getText().toString().toUpperCase());
                telefono.setText("");
                mensaje.setText("");
            }
        });
        permisos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verPermisos();
            }
        });
    }


    private void enviarSMS(String numero, String mensaje) {
        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numero,null,mensaje,null,null);
            Toast.makeText(this, "SE ENVIO", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    private void verPermisos() {
        String resultado="";
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                == PackageManager.PERMISSION_GRANTED){
            resultado = "SI PERMISO LECTURA ESTADO TELEFONO";
        } else {
            resultado = "NO HAY PERMISO LECTURA ESTADO TELEFONO";
        }
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED){
            resultado += "\nSI PERMISO ENVIO SMS";
        } else {
            resultado += "\nNO HAY PERMISO ENVIO SMS";
        }
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("ATENCION").setMessage(resultado)
                .setPositiveButton("Aceptar",null).show();
    }

    private void solicitarPermisos() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED){
            //Entra si el permiso esta denegado, ya que serĂ¡ diferente a permiso OTORGADO
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_SMS},3);
        }
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED){
            //Entra si el permiso esta denegado, ya que serĂ¡ diferente a permiso OTORGADO
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.RECEIVE_SMS},4);
        }
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED){
            //Entra si el permiso esta denegado, ya que serĂ¡ diferente a permiso OTORGADO
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.SEND_SMS},2);
        }
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED){
            //Entra si el permiso esta denegado, ya que serĂ¡ diferente a permiso OTORGADO
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_PHONE_STATE},1);
        }




    }
}
