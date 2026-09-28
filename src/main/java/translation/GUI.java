package translation;

import javax.swing.*;
import java.awt.event.*;


// TODO Task D: Update the GUI for the program to align with UI shown in the README example.
//            Currently, the program only uses the CanadaTranslator and the user has
//            to manually enter the language code they want to use for the translation.
//            See the examples package for some code snippets that may be useful when updating
//            the GUI.
public class GUI {
    public static void main(String[] args) {
        Translator translator = new JSONTranslator();
        LanguageCodeConverter conv = new LanguageCodeConverter();
        SwingUtilities.invokeLater(() -> {
            JPanel langPanel = new JPanel();
            JComboBox<String> selection = new JComboBox<String>();
            for(String str : translator.getLanguageCodes())
                selection.addItem(conv.fromLanguageCode(str));
            langPanel.add(selection);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(langPanel);

            JFrame frame = new JFrame("JComboBox Demo");
            frame.setContentPane(mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null); // place in centre of screen
            frame.setVisible(true);
        });
    }
}
