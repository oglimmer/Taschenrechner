
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import de.oglimmer.math.*;
import de.oglimmer.math.astnode.Expression;

public class Main {
    static String test = "";
    static ArrayList<String> gedrehteliste = new ArrayList<>();

    public static void main(String[] args) {
        openUI();
    }


    public static void openUI() {
        // Aufbau und Eigenschaften des Hauptfensters
        JFrame frame = new JFrame("Mein Taschenrechner");
        frame.setSize(350, 440);
        frame.setLocation(500, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Displayfeld initialisieren und zum Frame hinzufügen
        JTextField ausgabe = new JTextField();
        frame.add(ausgabe);
        ausgabe.setFocusable(false); //Display wird nicht antippbar

        // Farben für die Buttons
        Color buttonColor = Color.BLACK;
        Color buttonSColor = Color.WHITE;

        // Namen der Button, gespeichert im Array. Aufruf anhand des Index (ausnahme ist 3 und 22)
        String[] buttonLabels = {"U", "P", "W", "DEL", "7", "8", "9", "(", ")", "4", "5", "6", "*", "/", "1", "2", "3", "+", "-", ".", "0"};

        // ArrayList für die Buttons
        ArrayList<JButton> buttons = new ArrayList<>();
        Font font = new Font("Arial", Font.PLAIN, 28);

        // Eigenschaften der Buttons, Button werden auch aufgerufen
        for (String label : buttonLabels) {
            JButton button = new JButton();
            button.setBackground(buttonColor);
            button.setForeground(buttonSColor);
            button.setFocusable(true);
            button.setFont(font);
            button.setText(label);
            buttons.add(button); // Button zur Liste hinzufügen
            frame.add(button);
            button.addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                String buttonText = clickedButton.getText();
                ausgabe.setText(ausgabe.getText() + buttonText);
            });
            button.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        button.doClick();
                    }
                }
            });
        }// ende der forschleife


        //Button die nicht über die vorschleife abgedeckt werden und ander Funktionen haben
        JButton delete = new JButton("DEL");
        delete.setBackground(buttonColor);
        delete.setForeground(buttonSColor);
        delete.setFont(font);
        frame.add(delete);
        delete.setFocusable(true);

        JButton ergebnis = new JButton("=");
        ergebnis.setBackground(buttonColor);
        ergebnis.setForeground(buttonSColor);
        ergebnis.setFont(font);
        frame.add(ergebnis);
        ergebnis.setFocusable(true);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe.setText("");
            }
        });


        ergebnis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ausgabespeicher = ausgabe.getText();
                    if (ausgabespeicher.contains("U")) {
                        String[] zwischenspeicher = ausgabespeicher.split("U");
                        String teil_eins = zwischenspeicher[0];
                        String teil_zwei = zwischenspeicher[1];
                        int dezimalzahl = Integer.parseInt(teil_eins);
                        int basis = Integer.parseInt(teil_zwei);
                        dezimalzahl_zu_anderer_basis(dezimalzahl, basis);
                        ausgabe.setText(test);
                    } else if (ausgabespeicher.contains("P")) {
                        String[] zwischenspeicher = ausgabespeicher.split("P");
                        String teil_eins = zwischenspeicher[0];
                        String teil_zwei = zwischenspeicher[1];
                        int dezimalzahl = Integer.parseInt(teil_eins);
                        int potenz = Integer.parseInt(teil_zwei);
                        double ergebnis = Math.pow(dezimalzahl, potenz);
                        ausgabe.setText(String.valueOf(ergebnis));
                    } else if (ausgabespeicher.contains("W")) {
                        String[] zwischenspeicher = ausgabespeicher.split("W");
                        String teil_eins = zwischenspeicher[0];
                        int dezimalzahl = Integer.parseInt(teil_eins);
                        double ergebnis = Math.sqrt(dezimalzahl);
                        ausgabe.setText(String.valueOf(ergebnis));
                    } else {
                        FunctionParser functionParser = new FunctionParser();
                        Expression exp = functionParser.parse(ausgabespeicher);
                        double endergebnis = exp.resolve(new HashMap<>());
                        ausgabe.setText(String.valueOf(endergebnis));
                    }
                } catch (Exception ex) {
                    ausgabe.setText("Error");
                }
            }
        });


        //Eigenschaften des Textfeldes
        ausgabe.setBounds(5, 5, 335, 50);
        frame.add(ausgabe);
        ausgabe.setFont(font);

        //positionierung der Button
        //Zeile 2
        buttons.get(0).setBounds(5, 60, 65, 65);
        buttons.get(1).setBounds(70, 60, 65, 65);
        buttons.get(2).setBounds(135, 60, 65, 65);
        delete.setBounds(200, 60, 130, 65);

        //Zeile 3
        buttons.get(4).setBounds(5, 125, 65, 65);
        buttons.get(5).setBounds(70, 125, 65, 65);
        buttons.get(6).setBounds(135, 125, 65, 65);
        buttons.get(7).setBounds(200, 125, 65, 65);
        buttons.get(8).setBounds(265, 125, 65, 65);

        //Zeile 4
        buttons.get(9).setBounds(5, 190, 65, 65);
        buttons.get(10).setBounds(70, 190, 65, 65);
        buttons.get(11).setBounds(135, 190, 65, 65);
        buttons.get(12).setBounds(200, 190, 65, 65);
        buttons.get(13).setBounds(265, 190, 65, 65);

        //Zeile 5
        buttons.get(14).setBounds(5, 255, 65, 65);
        buttons.get(15).setBounds(70, 255, 65, 65);
        buttons.get(16).setBounds(135, 255, 65, 65);
        buttons.get(17).setBounds(200, 255, 65, 65);
        buttons.get(18).setBounds(265, 255, 65, 65);

        //Zeile 6
        buttons.get(19).setBounds(5, 320, 65, 65);
        buttons.get(20).setBounds(70, 320, 65, 65);
        ergebnis.setBounds(135, 320, 195, 65);

        frame.setVisible(true);
    }


    //Funktion zum Umrechnen
    public static ArrayList<String> dezimalzahl_zu_anderer_basis(int dezimalzahl, int basis) {
        ArrayList<String> ascii = new ArrayList<>();
        while (dezimalzahl > 0) { //ursprüngliche Formel aus Python
            int rechnung = (int) (((dezimalzahl / (float) basis) - (int) (dezimalzahl / basis)) * basis);
            //Umwandeln des Ergebnis in Ascii wenn das Ergebnis höher 10
            if (rechnung > 10) {
                // Ergebnis wird +55 gerechnet und als String in die Liste eingetragen
                // +55 wird verwendet um einen Buchstaben aus der Ascii Liste zu nutzen
                ascii.add(Character.toString((char) (rechnung + 55)));
            } else {
                ascii.add(Integer.toString(rechnung));
            }
            //übertrag des Restes der durch die Schleife muss
            dezimalzahl = (int) (dezimalzahl / basis);
            // zum drehen der Liste
        }
        for (int i = ascii.size() - 1; i >= 0; i--) {
            gedrehteliste.add(ascii.get(i));
        }
        //test = gedrehteliste.toString();
        test = gedrehteliste.toString().replaceAll("[\\[\\],]", "");
        return gedrehteliste;
    }
}

