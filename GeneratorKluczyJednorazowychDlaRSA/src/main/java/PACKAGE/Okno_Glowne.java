package PACKAGE;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Baza.KluczRSA;

public class Okno_Glowne extends JFrame implements ActionListener {
    public JTextArea taPoleWiadomosci;
    public static JMenuBar menuBar;
    public static JMenu menuPlik, menuNarzedzia, menuPomoc;
    public static JMenuItem mOtworz, mZapisz, mWyjscie, mSzyfruj, mDeszyfruj, mOpcje;
    private static String TekstTajny, tekstJawny;
    public static int ID_USER;
    public static KluczRSA klucz;
    public static int Bit = 32;
    public static JLabel lBit;

    private Opcje OknoOpcji;

    public Okno_Glowne() {
        setSize(1370, 730);
        setTitle("Okno g³ówne programu");
        setLayout(null);

        lBit = new JLabel("Wartoœæ bitowa Liczb Pierwszych: " + Bit);
        lBit.setFont(new Font("Tahoma", Font.BOLD, 20));
        lBit.setBounds(200, 50, 2000, 40);
        add(lBit);

        taPoleWiadomosci = new JTextArea("");
        taPoleWiadomosci.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(taPoleWiadomosci);
        sp.setBounds(70, 100, 1050, 500);
        add(sp);

        menuBar = new JMenuBar();
        menuPlik = new JMenu("Plik");

        mOtworz = new JMenuItem("Otwórz");
        mZapisz = new JMenuItem("Zapisz");
        mWyjscie = new JMenuItem("Wyjœcie");

        menuPlik.add(mOtworz);
        menuPlik.add(mZapisz);
        menuPlik.addSeparator();
        menuPlik.add(mWyjscie);

        menuNarzedzia = new JMenu("Narzêdzia");

        mSzyfruj = new JMenuItem("Szyfruj");
        mDeszyfruj = new JMenuItem("Deszyfruj");

        menuNarzedzia.add(mSzyfruj);
        menuNarzedzia.add(mDeszyfruj);

        menuPomoc = new JMenu("Pomoc");

        mOpcje = new JMenuItem("Ustal poziom bitowoœci liczb pierwszych");

        menuPomoc.add(mOpcje);

        setJMenuBar(menuBar);
        menuBar.add(menuPlik);
        menuBar.add(menuNarzedzia);
        menuBar.add(menuPomoc);

        mWyjscie.addActionListener(this);
        mOtworz.addActionListener(this);
        mZapisz.addActionListener(this);
        mSzyfruj.addActionListener(this);
        mDeszyfruj.addActionListener(this);
        mOpcje.addActionListener(this);
    }

    public static void main(String[] args) {
        ID_USER = Integer.valueOf(0);
        Okno_Glowne okienko = new Okno_Glowne();
        okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okienko.setVisible(true);
    }

    public static void setBit(int bitowosc) {
        Bit = bitowosc;
    }

    public void setBitowosc(int bit2) {
        lBit.setText("Wartoœæ bitowa Liczb Pierwszych: " + bit2);
    }

    public void actionPerformed(ActionEvent e) {
        Object z = e.getSource();
        if (z == mWyjscie) {
            dispose();
        } else if (z == mOtworz) {
            taPoleWiadomosci.setText("");
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                try {
                    Scanner input = new Scanner(plik);
                    while (input.hasNext()) {
                        taPoleWiadomosci.append(input.nextLine() + "\n");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } else if (z == mZapisz) {
            TekstTajny = taPoleWiadomosci.getText();
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                try {
                    Scanner input = new Scanner(TekstTajny);
                    PrintWriter pw = new PrintWriter(plik);
                    while (input.hasNext()) {
                        taPoleWiadomosci.setText("");
                        pw.println(input.nextLine() + "\n");
                    }
                    pw.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        } else if (z == mSzyfruj) {
            klucz = GeneratorKluczy.main(Bit, ID_USER);
            TekstTajny = SzyfrowanieKluczem.Szyfrowanie(taPoleWiadomosci.getText(), klucz);
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                try {
                    Scanner input = new Scanner(TekstTajny);
                    PrintWriter pw = new PrintWriter(plik);
                    while (input.hasNext()) {
                        taPoleWiadomosci.setText("");
                        pw.println(input.nextLine() + "\n");
                    }
                    pw.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }

        } else if (z == mDeszyfruj) {
            try {

                tekstJawny = SzyfrowanieKluczem.Deszyfrowanie(taPoleWiadomosci.getText(), null); //main(taPoleWiadomosci.getText(),klucz, 2);
                JFileChooser fc = new JFileChooser();
                if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File plik = fc.getSelectedFile();
                    try {
                        Scanner input = new Scanner(tekstJawny);
                        PrintWriter pw = new PrintWriter(plik);
                        while (input.hasNext()) {
                            taPoleWiadomosci.setText("");
                            pw.println(input.nextLine() + "\n");
                        }
                        pw.close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }

            } catch (Exception p) {
                JOptionPane.showMessageDialog(this, "Nie uda³o siê odszyfrowaæ informacji. Powodem mo¿e byæ z³y klucz lub nieodpowiednia d³ugosæ zaszyfrowanej informacji przy uzyciu wyliczonego klucza.");
            }

        } else if (z == mOpcje) {
            Opcje okienko = new Opcje(this);
            okienko.setVisible(true);
            Bit = Opcje.getBit();
            setBitowosc(Bit);
        }
    }
}


