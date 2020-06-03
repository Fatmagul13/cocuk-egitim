package com.fatmagulyurtseven.cocukegitim.Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.fatmagulyurtseven.cocukegitim.Model.AnimalsModel;
import com.fatmagulyurtseven.cocukegitim.Model.ColorsModel;
import com.fatmagulyurtseven.cocukegitim.Model.DrinksModel;
import com.fatmagulyurtseven.cocukegitim.Model.FruitsModel;
import com.fatmagulyurtseven.cocukegitim.Model.HarflerModel;
import com.fatmagulyurtseven.cocukegitim.Model.HayvanlarModel;
import com.fatmagulyurtseven.cocukegitim.Model.MatematikModel;
import com.fatmagulyurtseven.cocukegitim.Model.MatematikTestModel;
import com.fatmagulyurtseven.cocukegitim.Model.MesleklerModel;
import com.fatmagulyurtseven.cocukegitim.Model.MevsimlerModel;
import com.fatmagulyurtseven.cocukegitim.Model.MeyvelerModel;
import com.fatmagulyurtseven.cocukegitim.Model.NumbersModel;
import com.fatmagulyurtseven.cocukegitim.Model.ObjectsModel;
import com.fatmagulyurtseven.cocukegitim.Model.RenklerModel;
import com.fatmagulyurtseven.cocukegitim.Model.SayilarModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by Fatmagul on 11.12.2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static String DB_NAME = "egitim.db";
    private static String DB_PATH = "";
    public static int DATABASE_VERSION = 1;
    public SQLiteDatabase sqLiteDatabase;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public DatabaseHelper(Context context) throws IOException {
            super(context, DB_NAME, null, DATABASE_VERSION);
            this.context = context;
            boolean dbExists = checkDatabase();
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";

            if (dbExists) {
                Log.d("DB_LOG", "Database bulundu !");
            } else {
                try {
                    if (createDatabase() == true) {
                        Log.d("DB_LOG", "Database oluşturuldu !");
                    } else {
                        Log.d("DB_LOG", "Database oluşturulamadı !");
                    }
                } catch (Exception e) {
                    Log.d("DB_LOG", "Database oluşturulamadı !");
                }
            }

    }
    public ArrayList<SayilarModel> getSayilar() {
        ArrayList<SayilarModel> sayilar = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu1 = "select * from sayilar";
        Cursor c1 = sqLiteDatabase.rawQuery(sorgu1, null);
        while (c1.moveToNext()) {
            sayilar.add(new SayilarModel(c1.getInt(c1.getColumnIndex("sayiId")), c1.getString(c1.getColumnIndex("sayiAdi")), c1.getInt(c1.getColumnIndex("sayiNo")), c1.getString(c1.getColumnIndex("sayiOkunus"))

            ));

        }
        return sayilar;
    }

    public ArrayList<HarflerModel> getHarfler() {
        ArrayList<HarflerModel> harfler = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu1 = "select * from harfler" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu1, null);
        while (c.moveToNext()) {
            harfler.add(
                    new HarflerModel(
                            c.getInt(c.getColumnIndex("harfId")),
                            c.getString(c.getColumnIndex("harf")),
                            c.getString(c.getColumnIndex("harfResmi")),
                            c.getString(c.getColumnIndex("harfSesi"))
                    )
            );
        }

        return harfler;
    }
    public ArrayList<HayvanlarModel> getHayvanlar() {
        ArrayList<HayvanlarModel> hayvanlar = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from hayvanlar" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            hayvanlar.add(
                    new HayvanlarModel(
                            c.getInt(c.getColumnIndex("hayvanId")),
                            c.getString(c.getColumnIndex("hayvanAdi")),
                            c.getString(c.getColumnIndex("hayvanResim")),
                            c.getString(c.getColumnIndex("hayvanSes"))
                    )
            );
        }

        return hayvanlar;
    }

    public ArrayList<MeyvelerModel> getMeyveler() {
        ArrayList<MeyvelerModel> meyveler = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from meyveler" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            meyveler.add(
                    new MeyvelerModel(
                            c.getInt(c.getColumnIndex("meyveId")),
                            c.getString(c.getColumnIndex("meyveAdi")),
                            c.getString(c.getColumnIndex("meyveResmi")),
                            c.getString(c.getColumnIndex("meyveSes"))
                    )
            );
        }

        return meyveler;
    }
    public ArrayList<MatematikTestModel> getMatematikTest() {
        ArrayList<MatematikTestModel> matTest = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from matematiktest" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            matTest.add(
                    new MatematikTestModel(
                            c.getInt(c.getColumnIndex("matTestId")),
                            c.getString(c.getColumnIndex("sonuc")),
                            c.getString(c.getColumnIndex("matTestResim"))

                    )
            );
        }

        return matTest;
    }
    public ArrayList<MesleklerModel> getMeslekler() {
        ArrayList<MesleklerModel> meslekler = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from meslekler" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            meslekler.add(
                    new MesleklerModel(
                            c.getInt(c.getColumnIndex("meslekId")),
                            c.getString(c.getColumnIndex("meslekAdi")),
                            c.getString(c.getColumnIndex("meslekResmi")),
                            c.getString(c.getColumnIndex("meslekSes"))
                    )
            );
        }

        return meslekler;
    }
    public ArrayList<RenklerModel> getRenkler() {
        ArrayList<RenklerModel> renkler = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu1 = "select * from renkler" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu1, null);
        while (c.moveToNext()) {
            renkler.add(
                    new RenklerModel(
                            c.getInt(c.getColumnIndex("renkId")),
                            c.getString(c.getColumnIndex("renkAdi")),
                            c.getString(c.getColumnIndex("renkResmi")),
                            c.getString(c.getColumnIndex("renkSes"))
                    )
            );
        }

        return renkler;
    }
    public ArrayList<MevsimlerModel> getMevsimler() {
        ArrayList<MevsimlerModel> mevsimler = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from mevsimler" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            mevsimler.add(
                    new MevsimlerModel(
                            c.getInt(c.getColumnIndex("mevsimId")),
                            c.getString(c.getColumnIndex("mevsimAdi")),
                            c.getString(c.getColumnIndex("mevsimResim")),
                            c.getString(c.getColumnIndex("mevsimSes"))
                    )
            );
        }

        return mevsimler;
    }

    public ArrayList<MatematikModel> getMatematik() {
        ArrayList<MatematikModel> matematik = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from matematik" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            matematik.add(
                    new MatematikModel(
                            c.getInt(c.getColumnIndex("matId")),
                            c.getString(c.getColumnIndex("islem")),
                            c.getString(c.getColumnIndex("islemResmi")),
                            c.getString(c.getColumnIndex("islemSes"))
                    )
            );
        }

        return matematik;
    }
    public ArrayList<NumbersModel> getNumbers() {
        ArrayList<NumbersModel> numbers = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from numbers" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            numbers.add(
                    new NumbersModel(
                            c.getInt(c.getColumnIndex("numberId")),
                            c.getInt(c.getColumnIndex("number")),
                            c.getString(c.getColumnIndex("numberName")),
                            c.getString(c.getColumnIndex("numberSound"))
                    )
            );
        }

        return numbers;
    }
    public ArrayList<AnimalsModel> getAnimals() {
        ArrayList<AnimalsModel> animals = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from animals" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            animals.add(
                    new AnimalsModel(
                            c.getInt(c.getColumnIndex("animalId")),
                            c.getString(c.getColumnIndex("animalName")),
                            c.getString(c.getColumnIndex("animalImage")),
                            c.getString(c.getColumnIndex("animalSound"))
                    )
            );
        }

        return animals;
    }
    public ArrayList<FruitsModel> getFruits() {
        ArrayList<FruitsModel> fruits = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from fruits" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            fruits.add(
                    new FruitsModel(
                            c.getInt(c.getColumnIndex("fruitId")),
                            c.getString(c.getColumnIndex("fruitName")),
                            c.getString(c.getColumnIndex("fruitImage")),
                            c.getString(c.getColumnIndex("fruitSound"))
                    )
            );
        }

        return fruits;
    }
    public ArrayList<DrinksModel> getDrinks() {
        ArrayList<DrinksModel> drinks = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from drinks" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            drinks.add(
                    new DrinksModel(
                            c.getInt(c.getColumnIndex("drinkId")),
                            c.getString(c.getColumnIndex("drinkName")),
                            c.getString(c.getColumnIndex("drinkImage")),
                            c.getString(c.getColumnIndex("drinkSound"))
                    )
            );
        }

        return drinks;
    }
    public ArrayList<ColorsModel> getColors() {
        ArrayList<ColorsModel> colors = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from colors" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            colors.add(
                    new ColorsModel(
                            c.getInt(c.getColumnIndex("colorId")),
                            c.getString(c.getColumnIndex("colorName")),
                            c.getString(c.getColumnIndex("colorImage")),
                            c.getString(c.getColumnIndex("colorSound"))
                    )
            );
        }

        return colors;
    }
    public ArrayList<ObjectsModel> getObjects() {
        ArrayList<ObjectsModel> objects = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        String sorgu = "select * from objects" ;
        Cursor c = sqLiteDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            objects.add(
                    new ObjectsModel(
                            c.getInt(c.getColumnIndex("objectId")),
                            c.getString(c.getColumnIndex("objectName")),
                            c.getString(c.getColumnIndex("objectImage")),
                            c.getString(c.getColumnIndex("objectSound"))
                    )
            );
        }

        return objects;
    }

    public String getSayiAdi(int id) {
        String str = "";
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery("select sayiAdi from sayilar where sayiNo=" + id, null);
            while (c.moveToNext()) {
                str = c.getString(1);
            }
        } catch (Exception e) {
        }
        return str;
    }
    public boolean createDatabase() throws IOException {
        boolean dbExists = checkDatabase();
        // checkDatabase metodu ile database varmı/yokmu kontrolü yap
        if (dbExists) { //database varsa
            return true;
        } else { // database yoksa
            this.getReadableDatabase();
            try {
                this.close();
                copyDatabase();
            } catch (IOException e) {
                throw new Error("Database kopyalanma hatası");
            }
            return false;
        }
    }
    public boolean checkDatabase() {
        boolean checkdb = false;

        try {
            String dosyaKonumu = DB_PATH + DB_NAME;
            File dbFile = new File(dosyaKonumu);
            checkdb = dbFile.exists();
        } catch (SQLiteException e) {
            Log.d("DB_LOG", "Database bulunamadı");
        }

        return checkdb;
    }
    private void copyDatabase() throws IOException {
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        InputStream myInput = context.getAssets().open(DB_NAME);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myInput.close();
        myOutput.flush();
        myOutput.close();
    }

    public void openDatabase() {
        String myPath = DB_PATH + DB_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    public synchronized void close() {
        if (sqLiteDatabase != null) {
            sqLiteDatabase.close();
        }
        super.close();
    }
    public SQLiteDatabase getDatabase(){

        return  sqLiteDatabase;
    }

    public String getThat(){


        return null;
    }

}
