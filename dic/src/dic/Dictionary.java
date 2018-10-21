package dic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dictionary {

    static ArrayList<Word> listWord = new ArrayList<>();
    private static final String fileName = "dictionaries.txt";
    private final String className = "com.mysql.jdbc.Driver";
    private Connection connection;
    private final String user = "ductt";
    private final String pass = "03121997";
    private final String url = "jdbc:mysql://localhost:3306/dictionary?user=" + user
            + "&password=" + pass + "&useUnicode=true&characterEncoding=utf8";
    private final String tableName = "my_dic";

    public Dictionary() {
        connectSQL();
        ResultSet rs = null;
        String sql = "SELECT * FROM " + tableName;
        Statement st = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Dictionary.listWord.add(new Word(rs.getString(1), rs.getString(2)));
            }
            connection.close();
            System.out.println("Insert all success from SQL !!!");
        } catch (SQLException ex) {
            System.out.println("Error!");
        }
    }

    private void connectSQL() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url);

            System.out.println("Connect Success!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found!");
        } catch (SQLException ex) {
            System.out.println("Error Connection!");
        }
    }

    public boolean isEmpty() {
        return listWord.isEmpty();
    }

    public boolean isInList(String word_taget) {
        for (Word ele : listWord) {
            if (ele.getWord_taget().equals(word_taget)) {
                return true;
            }
        }
        return false;
    }

    public void insertToList(Word w) {
        listWord.add(new Word(w));
    }

    public void deleteInList(String word_taget) {
        for (int i = 0; i < listWord.size(); i++) {
            if (listWord.get(i).getWord_taget().equals(word_taget)) {
                listWord.remove(i);
                return;
            }
        }
    }

    public void editWordInList(String word_taget, String newWordTaget, String newWordExplain) {
        for (int i = 0; i < listWord.size(); i++) {
            if (listWord.get(i).getWord_taget().equals(word_taget)) {
                listWord.set(i, new Word(newWordTaget, newWordExplain));
                return;
            }
        }
    }

    public void insertToSQL(Word w) {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO my_dic VALUES ('" + w.getWord_taget()
                    + "','" + w.getWord_explain() + "')");
            connection.close();
            System.out.println("Success");
        } catch (SQLException ex) {
            System.out.println("Error!");
        }
    }

    public void deleteInSQL(String word_taget) {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("DELETE FROM my_dic WHERE word_taget = '" + word_taget + "'");
            connection.close();
            System.out.println("Success");
        } catch (SQLException ex) {
            System.out.println("Error!");
        }
    }

    public void editWordInSQL(String word_taget, String newWordTaget, String newWordExplain) {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE my_dic SET word_taget = '" + newWordTaget
                    + "',word_explain = '" + newWordExplain + "' WHERE word_taget = '" + word_taget + "'");
            connection.close();
            System.out.println("Success");
        } catch (SQLException ex) {
            System.out.println("Error!");
        }
    }

    public void dictionaryExportToSQL() {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            if (!listWord.isEmpty()) {
                for (Word ele
                        : listWord) {
                    st.executeUpdate("INSERT INTO my_dic VALUES ('" + ele.getWord_taget()
                            + "','" + ele.getWord_explain() + "')");
                    System.out.println("Success");
                }
            }

            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error!");
        }

    }
}
