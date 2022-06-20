package com.rplbo.carisudutjam;

public class App {
    public static void main( String[] args ) {
        Database db = new Database();
        db.createDB();
        db.connect();
        db.createTable();
        System.out.println();
//        db.deleteAll(); for truncate
        db.updateAll();
        System.out.println();
        db.writeln();
    }
}
