import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class DictionaryManagement {
    private Scanner sc;
    private static final String fileName = "dictionaries.txt";
    private final String className = "com.mysql.jdbc.Driver";
    private Connection connection;
    private final String user = "ductt";
    private final String pass = "03121997";
    private final String url = "jdbc:mysql://localhost:3306/dictionary?user=" + user +
                                "&password=" + pass + "&useUnicode=true&characterEncoding=utf8";
    private final String tableName = "my_dic";

    public void insertFromCommandline() {
        sc = new Scanner(System.in);
        System.out.println("---------Add Word To List---------");
        System.out.print("Enter number of word: ");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.print("Enter English Word: ");
            String spel = sc.nextLine();
            System.out.print("Enter Vietnamese Explain: ");
            String expl = sc.nextLine();

            Dictionary.listWord.add(new Word(spel, expl));
        }
        System.out.println("Insert success " + num + " word!");
    }

    public void insertFromFile() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String line = br.readLine();;

            while(line != null) {

                if(line.indexOf("\t") == -1) {
                    System.out.println("Format File Wrong!");
                    return;
                }
                Word w = new Word(line);
                Dictionary.listWord.add(w);
                line = br.readLine();
            }

            br.close();
        }
        catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

    public void dictionaryLookup() {
        sc = new Scanner(System.in);
        System.out.println("-----------LOOK UP------------");
        System.out.print("Enter word: ");
        String wordLookup = sc.nextLine();
        for (Word ele:
             Dictionary.listWord) {
            if (ele.getWord_taget().equals(wordLookup)) {
                System.out.println("Lookup Success!");
                System.out.print("Your word is: ");
                ele.printWord();
                return;
            }
        }
        System.out.println("Word Not Found!");
    }

    public void dictionaryExportToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (Word ele : Dictionary.listWord) {
                bw.write(ele.getWord_taget() + "\t" + ele.getWord_explain());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                System.out.println("Error " + ex);
        } catch (IOException ex) {
                System.out.println("Error " + ex);
        }
    }

    public void connectSQL() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url);

            System.out.println("Connect Success!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found!");
        }
        catch (SQLException ex) {
            System.out.println("Error Connection!");
        }
    }

    public void insertFromSQL() {
        connectSQL();
        ResultSet rs = null;
        String sql = "SELECT * FROM " + tableName;
        Statement st = null;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                Dictionary.listWord.add(new Word(rs.getString(1),rs.getString(2)));
            }
            connection.close();
            System.out.println("Insert success from SQL !!!");
        } catch (SQLException ex) {
            System.out.println("Error!");
        }
    }

    public void dictionaryExportToSQL() {
        connectSQL();
        try {
            Statement st = connection.createStatement();
            if (!Dictionary.listWord.isEmpty()) {
                for (Word ele :
                        Dictionary.listWord) {
                    st.executeUpdate("INSERT INTO my_dic VALUES ('" + ele.getWord_taget() +
                                        "','" + ele.getWord_explain() + "')");
                    System.out.println("Success");
                }
            }

            connection.close();
        }
        catch (SQLException ex) {
            System.out.println("Error!");
        }
    }
}
