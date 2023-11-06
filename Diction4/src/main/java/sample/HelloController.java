package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;


public class HelloController implements Initializable {
    private static String keyWord;
    public static String[] listWord;

    public static void getListWord() throws SQLException {
        listWord = database_manage.list_word();
    }
    @FXML
    private TextField wordIn;

    private AutoCompletionBinding<String> autoCompletionBinding;
    Set<String> psWord = new HashSet<>();

    @FXML
    private ImageView IgSearch;

    @FXML
    private Label wordsOut;

    @FXML
    private Button sound, add, pin, buttomSearch;

    @FXML
    private WebView webView;

    WebEngine webEngine = null;

    @FXML
    void showWord(MouseEvent event) {
        keyWord = wordIn.getText();
        wordsOut.setText(keyWord);
        try {
            String a = keyWord;
            webEngine.loadContent(database_manage.search(a));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void EnterSearch(KeyEvent event)  {
        if(event.getCode() == KeyCode.ENTER){
            keyWord = wordIn.getText();
            wordsOut.setText(keyWord);
            System.out.println(keyWord);
            try {
                String a = keyWord;
                webEngine.loadContent(database_manage.search(a));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void KeyReturn(KeyEvent event) {

    }

    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {

        webEngine = webView.getEngine();
        try {
            getListWord();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collections.addAll(psWord, listWord);

        autoCompletionBinding = TextFields.bindAutoCompletion(wordIn,psWord);
        wordIn.setOnKeyPressed((KeyEvent e) ->{
            if (e.getCode() == KeyCode.ENTER) {
                learnWord(wordIn.getText());
            }
        });

    }

    private void learnWord(String text) {
        psWord.add(text);
        if(autoCompletionBinding != null){
            autoCompletionBinding.dispose();
        }
        autoCompletionBinding = TextFields.bindAutoCompletion(wordIn, psWord);
    }

}