package mx.edu.ittepic.tpdm_u5_mensajes_delarosaguerrerogabriela;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class Pareja {
    BaseDatos base;
    int id, digito;
    String frase;
    public Pareja(Context activity){
        base=new BaseDatos(activity,"pareja",null,1);
    }
    public Pareja(int i,int digito,String frase){
        id=i;
        this.digito=digito;
        this.frase=frase;
    }
    public Pareja[] consultar(){
        try{
            SQLiteDatabase db=base.getReadableDatabase();
            Cursor c=db.rawQuery("SELECT * FROM PAREJA",null);
            if (c.moveToFirst()) {
                Pareja[] parejas = new Pareja[c.getCount()];
                int pos = 0;
                do {
                    parejas[pos] = new Pareja(c.getInt(0), c.getInt(1), c.getString(2));
                    pos++;
                } while (c.moveToNext());
                return parejas;
            }
        }catch(SQLiteException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public Pareja consultarDigito(int digito){
        try{
            SQLiteDatabase db=base.getReadableDatabase();
            String []datos={digito+""};
            Pareja parejas;
            Cursor c=db.rawQuery("SELECT * FROM PAREJA WHERE DIGITO=?",datos);
            if (c.moveToFirst()) {
                parejas= new Pareja(c.getInt(0), c.getInt(1), c.getString(2));
                return parejas;
            }
        }catch(SQLiteException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
