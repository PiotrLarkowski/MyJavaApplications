import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class MenuKrzyzowka extends JFrame implements ActionListener {

    public static KrzyzowkaRysowanie okienko = null;
    public static String[] Słówka = new String[100];

    public JButton bWyjście, bNowaKrzyzowka, bUzupelnianieKrzyzowki;
    public JLabel lWiadomosc;

    private ImageIcon tlo;
    private JLabel lTlo;

    public MenuKrzyzowka() {


        setSize(480, 370);
        setTitle("Okno główne programu");
        setLayout(null);

//        try {
//            DbCreator dbCreator = new DbCreator();
//            dbCreator.createAndLoadData();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        bUzupelnianieKrzyzowki = new JButton("Uzupelnianie Krzyzowki");
        bUzupelnianieKrzyzowki.setBounds(150, 80, 200, 50);
        add(bUzupelnianieKrzyzowki);

        bNowaKrzyzowka = new JButton("Słownik");
        bNowaKrzyzowka.setBounds(150, 150, 200, 50);
        add(bNowaKrzyzowka);
        bNowaKrzyzowka.addActionListener(this);

        bWyjście = new JButton("Wyjscie");
        bWyjście.setBounds(150, 220, 200, 50);
        add(bWyjście);
        bWyjście.addActionListener(this);
        bUzupelnianieKrzyzowki.addActionListener(this);

        tlo = new ImageIcon(this.getClass().getResource("/fame.png"));
        lTlo = new JLabel(tlo);
        lTlo.setSize(490,370);
        lTlo.setFocusable(false);
        add(lTlo);

        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {

        }
    }

    public static void main(String[] args) {
        CzarneTlo tlo = new CzarneTlo();
        tlo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tlo.setLocationRelativeTo(null);
        tlo.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tlo.setUndecorated(true);
        tlo.getContentPane().setBackground(Color.DARK_GRAY);
        tlo.setFocusableWindowState(false);
        tlo.setVisible(true);

        MenuKrzyzowka okienkoMenu = new MenuKrzyzowka();
        okienkoMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okienkoMenu.setLocationRelativeTo(null);
        okienkoMenu.setUndecorated(true);
        okienkoMenu.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        Object źródło = e.getSource();
        if (źródło == bUzupelnianieKrzyzowki) {
            okienko = new KrzyzowkaRysowanie(Słówka, 0, false);
            okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okienko.setLocationRelativeTo(null);
            okienko.setUndecorated(true);
            okienko.setVisible(true);
            this.dispose();
        } else if (źródło == bNowaKrzyzowka) {
            System.exit(1);
        } else if (źródło == bWyjście) {

            System.exit(1);
        }
    }
}
