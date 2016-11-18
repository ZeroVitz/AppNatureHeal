package com.example.greciaguzmn.natureheal;

/*
 * Created by Mauricio on 18/11/2016.
 */

public class TblNatureHeal {
    public static final String TABLE_NAME ="Alergias";
    public static final String FIELD_ID="_id";
    public static final String FIELD_ALERGIA="alergia";

    public static String CREATE_DB_TABLE= "create table"+TABLE_NAME+"("+
            FIELD_ID+" integer primary key autoincrement"+
            FIELD_ALERGIA+"text"+")";

    private int id;
    private String alergia;

    public TblNatureHeal(String alergia) {
        this.alergia = alergia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
}
