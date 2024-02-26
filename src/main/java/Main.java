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
        frame.setSize(350, 440);
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
        //int index = 0;
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

        }// ende der forschleife


        //Eigenschaften des Textfeldes
        ausgabe.setBounds(5,5,335,50);
        frame.add(ausgabe);
        ausgabe.setFont(font);

        //Posotionen der Buttons
        buttons.get(0).setBounds(5,60,65,65);
        buttons.get(1).setBounds(70,60,65,65);
        buttons.get(2).setBounds(135,60,65,65);
        buttons.get(3).setBounds(200,60,130,65);
        buttons.get(4).setBounds(5,125,65,65);
        buttons.get(5).setBounds(70,125,65,65);
        buttons.get(6).setBounds(135,125,65,65);
        buttons.get(7).setBounds(200,125,65,65);
        buttons.get(8).setBounds(265,125,65,65);
        buttons.get(9).setBounds(5,190,65,65);
        buttons.get(10).setBounds(70,190,65,65);
        buttons.get(11).setBounds(135,190,65,65);
        buttons.get(12).setBounds(200,190,65,65);
        buttons.get(13).setBounds(265,190,65,65);
        buttons.get(14).setBounds(5,255,65,65);
        buttons.get(15).setBounds(70,255,65,65);
        buttons.get(16).setBounds(135,255,65,65);
        buttons.get(17).setBounds(200,255,65,65);
        buttons.get(18).setBounds(265,255,65,65);
        buttons.get(19).setBounds(5,320,65,65);
        buttons.get(20).setBounds(70,320,65,65);
        buttons.get(22).setBounds(135,320,195,65);

        frame.setVisible(true);
    }
}
