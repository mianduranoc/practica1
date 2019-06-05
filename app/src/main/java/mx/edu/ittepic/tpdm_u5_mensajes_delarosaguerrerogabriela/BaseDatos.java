package mx.edu.ittepic.tpdm_u5_mensajes_delarosaguerrerogabriela;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context,String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PAREJA (ID INTEGER PRIMARY KEY AUTOINCREMENT,DIGITO INTEGER, FRASE VARCHAR(255));");
        db.execSQL("INSERT INTO PAREJA VALUES (NULL,0,'TODO A IDO MUY BIEN EN SU RELACIÓN, PERO UNA PERSONA QUIERE DESTRUIRLOS, PRESTA ATENCION A TU ALREDEDOR :S')");
        db.execSQL("INSERT INTO PAREJA VALUES (NULL,1,'SU RELACION A SIDO LA MEJOR DESDE EL INICIO, TIENEN UNA QUIMICA EXCELENTE, ES SEGURO EL FUTURO JUNTOS')");
        db.execSQL("INSERT INTO PAREJA VALUES (NULL,2,'YA NO SE DAN DETALLES COMO ANTES, PERO NO TEMAS, SOLO ESTÁN EN REVAS ;) DESPUES TODO VOLVERÁ A LA NORMALIDAD')");
        db.execSQL("INSERT INTO PAREJA VALUES (NULL,3,'PARECE QUE EL AMOR SE ESTA ACABANDO, ESA AMIGUITA LO ESTA ARRUINANDO TODO')");
        db.execSQL("INSERT INTO PAREJA VALUES (NULL,4,'QUE BONITA PAREJA HACEN JUNTOS!, NADIE SE EXPLICA COMO PUEDE SER TAN LINDA SU RELACIÓN, VE PREPARANDO LA BODA')");
        db.execSQL("INSERT INTO PAREJA VALUES (NULL,5,'SOLO ESTÁN JUNTOS POR COSTUMBRE, ESTO YA NO FUNCIONA Y LO SABEN, CORTENSE EL PELO Y CIERREN CICLOS')");
        db.execSQL("INSERT INTO PAREJA VALUES (NULL,6,'¿CÓMO, TODAVIA NO SE CASAN?, QUE ESPERAN, LAS BENDICIONES LLOVERÁN')");
        db.execSQL("INSERT INTO PAREJA VALUES (NULL,7,'SE VEN TAN LINDOS JUNTOS DESDE EL INICIO, SON UN AMOR, JUNTOS POR SIEMPRE <3')");
        db.execSQL("INSERT INTO PAREJA VALUES (NULL,8,'LOS DETALLES A SIDO LA LLAMA QUE LOS A MANTENIDO JUNTOS, SON LOS MAS ROMANTICOS DEL CONDADO')");
        db.execSQL("INSERT INTO PAREJA VALUES (NULL,9,'AMIG@ DATE CUENTA, ESTO YA NO ESTÁ FUNCIONANDO')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
