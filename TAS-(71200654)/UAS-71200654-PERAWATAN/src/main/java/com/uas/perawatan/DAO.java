package com.uas.perawatan;

import java.sql.*;

public class DAO {
    private Perawat getPerawatByID(int id) {
        String sql = "SELECT * FROM Pendaftar WHERE idPerawat";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:rumahsakit.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            rs.getInt("idPerawat");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return null;
        }

    }
    private Pemeriksa getPemeriksaByID (int id){

        return null;
    }
    public void inputDaftar(Daftar daftar) {

    }
    public void inputPengunjung(Pengunjung pengunjung) {

    }
    private Pendaftaran getPendaftaranByID( int id){

        return null;
    }
    public static void getPengunjungSembuh() {

    }


}