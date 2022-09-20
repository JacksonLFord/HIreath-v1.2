package Main;

import java.sql.*;
import java.util.ArrayList;

public class Generic {
    public static Connection getConn() {
        String dbURL = "jdbc:sqlserver://localhost;integratedSecurity=true;";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;

    }    public static int getLevel(int level){

        int index = 1;
        double exp = 10;
        double addition = 10;
        while(index<level){
            addition = exp / 2;
            exp = Math.round((exp + addition)/10) * 10;
            index++;
        }
        return (int)exp;
    }

    public static String convertToString(String str){

        String newStr = "";
        int index0 = 0;
        while(index0<(str.length())){
            char Char = str.charAt(index0);

            if(Char==('0')){
                newStr = newStr + "a";
            }else if(Char==('1')){
                newStr = newStr + "b";
            }else if(Char==('2')){
                newStr = newStr + "c";
            }else if(Char==('3')){
                newStr = newStr + "d";
            }else if(Char==('4')){
                newStr = newStr + "e";
            }else if(Char==('5')){
                newStr = newStr + "f";
            }else if(Char==('6')){
                newStr = newStr + "g";
            }else if(Char==('7')){
                newStr = newStr + "h";
            }else if(Char==('8')){
                newStr = newStr + "i";
            }else if(Char==('9')){
                newStr = newStr + "j";
            }
            index0++;
        }
        return newStr;



    }public static String convertToLong(String Long){

        String newStr = "";
        int index0 = 0;
        while(index0<(Long.length())){
            char Char = Long.charAt(index0);

            if(Char==('a')){
                newStr = newStr + "0";
            }else if(Char==('b')){
                newStr = newStr + "1";
            }else if(Char==('c')){
                newStr = newStr + "2";
            }else if(Char==('d')){
                newStr = newStr + "3";
            }else if(Char==('e')){
                newStr = newStr + "4";
            }else if(Char==('f')){
                newStr = newStr + "5";
            }else if(Char==('g')){
                newStr = newStr + "6";
            }else if(Char==('h')){
                newStr = newStr + "7";
            }else if(Char==('i')){
                newStr = newStr + "8";
            }else if(Char==('j')){
                newStr = newStr + "9";
            }
            index0++;
        }

        return newStr;

    }public static String pad(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(' ');
        }
        StringBuilder sd = new StringBuilder();
        sd.append(inputString);
        sd.append(sb.toString());

        return sd.toString();
    }public static ArrayList<String> COMMANDS = new ArrayList<String>();
    public static ArrayList<String> getItems(Long id) throws SQLException {
        ArrayList<String> li = new ArrayList<String>();
        Statement stmt;

        stmt = getConn().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM GameMaster.dbo."+convertToString(id+""));

        while (rs.next()) {
            li.add(rs.getString("ItemInfo"));

        }


        return li;
    }
}
