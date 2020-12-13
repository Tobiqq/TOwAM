package com.example.basketballmanagerv3.Helpers;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionsClass {
    String ip = "192.168.1.2";
    String ip2 = "192.168.206.33";
    String port = "1433";
    String db = "BasketManager";
    String login = "test";
    String pass = "test";
    String classes = "net.sourceforge.jtds.jdbc.Driver";
    String url = "jdbc:jtds:sqlserver://" + ip + ":" + port + "/" + db;


    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName(classes);
            conn = DriverManager.getConnection(url, login, pass);
        } catch (SQLException se) {
            Log.e("ERROR", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
        return conn;
    }
}
