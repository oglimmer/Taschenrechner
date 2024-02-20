import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        openUI();
    }


    public static void openUI() {
        // Aufbau und Eigenschaften des Hauptfensters
        JFrame frame = new JFrame("Mein Taschenrechner");
        frame.setSize(360, 500);
        frame.setLocation(500, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        // Displayfeld initialisieren und zum Frame hinzufügen
        JTextField ausgabe = new JTextField();
        frame.add(ausgabe);


        // Farben für die Buttons
        Color buttonColor = Color.BLACK;
        Color buttonSColor = Color.WHITE;


        // Namen der Buttin, gespeichert im Array
        String[] buttonLabels = {"U", "P", "W", "DEL", "7", "8", "9", "(", ")", "4", "5", "6", "*", "/", "1", "2", "3", "+", "-", ".", "0", "+/-", "="};


        // ArrayList für die Buttons
        ArrayList<JButton> buttons = new ArrayList<>();
        Font font = new Font("Arial",Font.PLAIN, 28);


        // Eigenschaften der Buttons, Button werden auch aufgerufen
        int index = 0;
        for (String label : buttonLabels) {
            JButton button = new JButton();
            button.setBackground(buttonColor);
            button.setForeground(buttonSColor);
            button.setFocusable(true);
            button.setFont(font);
            button.setText(label);
            buttons.add(button); // Button zur Liste hinzufügen
            frame.add(button);
            button.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        button.doClick();
                    }
                }
            });

            buttons.get(0).setBounds(5,60,60,60);

            for(JButton btn: buttons){
                System.out.println(button.getText());
            }

            //Eigenschaften des Textfeldes
            ausgabe.setBounds(5,5,335,50);
            frame.add(ausgabe);
            ausgabe.setFont(font);


        }



        frame.setVisible(true);
    }
}
