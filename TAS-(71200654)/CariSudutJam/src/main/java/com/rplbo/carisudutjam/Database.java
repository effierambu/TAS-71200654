package com.rplbo.carisudutjam;

import java.sql.*;

import static java.lang.Math.abs;

public class Database {
    private String urlDB;

    public Database() {
        this.urlDB = "jdbc:sqlite:waktu.db";
    }

    public void createDB() {
        try (Connection con = DriverManager.getConnection(this.urlDB)) {
            if(con != null) {
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("Nama: " + meta.getDriverName());
                System.out.println("Database berhasil dibuat");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection connect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(urlDB);
            System.out.println("Koneksi berhasil.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(con != null) {
                    con.close();
                }
            } catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        }
        return con;
    }

    public void createTable() {
        String sql1 = "CREATE TABLE IF NOT EXISTS waktu (\n" + " nomor integer NOT NULL\n constraint waktu_pk\n PRIMARY KEY autoincrement,\n" + " waktu text NOT NULL,\n" + " sudut real\n" + ");";
        String sql2 = "INSERT INTO waktu (waktu) values" + "('15:00'),('07:30'),('08:05'),('17:35'),('11:01');";
        try (Connection con = DriverManager.getConnection(urlDB);
             Statement sm = con.createStatement()) {
            sm.execute(sql1);
            System.out.println("Tabel berhasil dibuat!");
            sm.execute(sql2);
            System.out.println("Tabel berhasil diisi!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAll() {
        String sql = "SELECT nomor,waktu FROM waktu";
        try (Connection con = DriverManager.getConnection(urlDB);
             Statement sm = con.createStatement();
             ResultSet rs = sm.executeQuery(sql)){
            while (rs.next()) {
                String[] hehe = rs.getString("waktu").split(":");
                Algo algo = new Algo(Integer.parseInt(hehe[0]),Integer.parseInt(hehe[1]));
                String sql1 = "UPDATE waktu SET sudut = ? " + "WHERE nomor = ?";
                try (PreparedStatement ps = con.prepareStatement(sql1)) {
                    ps.setDouble(1, algo.getAngle());
                    ps.setInt(2, rs.getInt("nomor"));
                    ps.executeUpdate();
                    System.out.println("Sudut: " + algo.getAngle() + " sudah diupdate!");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeln(){
        String sql = "SELECT nomor,waktu,sudut FROM waktu";
        System.out.println("Nomor Waktu Sudut");
        try (Connection con = DriverManager.getConnection(urlDB);
             Statement sm = con.createStatement();
             ResultSet rs = sm.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(rs.getInt("nomor") + "\t  " + rs.getString("waktu") + "\t" + rs.getDouble("sudut"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAll() {
        String sql = "DROP TABLE waktu;";
        try (Connection con = DriverManager.getConnection(urlDB);
             Statement sm = con.createStatement()) {
            sm.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
