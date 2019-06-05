package mx.edu.ittepic.tpdm_u5_mensajes_delarosaguerrerogabriela;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Bundle extras=intent.getExtras();
        Object pdus[]=(Object[])extras.get("pdus");
        SmsMessage mensaje=SmsMessage.createFromPdu((byte[])pdus[0]);
        //Toast.makeText(context, "TELEFONO ORIGEN: "+mensaje.getOriginatingAddress()+" CONTENIDO: "+mensaje.getMessageBody(), Toast.LENGTH_LONG).show();
        String texto=mensaje.getMessageBody();
        texto=texto.toUpperCase();
        if (texto.startsWith("PAREJA")){
            String []partes=texto.split("-");
            String digito=partes[1].substring(1);
            int dig=Integer.parseInt(digito);
            if (partes.length==3){
                Pareja pareja=new Pareja(context);
                Pareja obtener=pareja.consultarDigito(dig);
                String message="A "+partes[2]+" y a ti les envio lo siguiente: "+obtener.frase;
                if (obtener!=null){
                    Toast.makeText(context, message+" "+dig+" "+mensaje.getOriginatingAddress(), Toast.LENGTH_SHORT).show();
                    Log.e("err",message+" "+dig+" "+mensaje.getOriginatingAddress());
                    enviarSMS(mensaje.getOriginatingAddress(),message,context);
                }
                //else enviarSMS(mensaje.getOriginatingAddress(),"NO SE ENCONTRO EL AUTOMOVIL",context);
            }
            /*else{
                enviarSMS(mensaje.getOriginatingAddress(),"FORMATO INCORRECTO",context);
            }*/
        }
       /* else{
            enviarSMS(mensaje.getOriginatingAddress(),"EL MENSAJE NO TIENE EL FORMATO CORRECTO",context);
        }*/
    }
    private void enviarSMS(String numero, String mensaje, Context context) {
        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numero,null,mensaje,null,null);
            Toast.makeText(context, "SE ENVIO RESPUESTA", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
