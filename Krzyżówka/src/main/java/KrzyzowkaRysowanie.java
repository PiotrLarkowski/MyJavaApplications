import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class KrzyzowkaRysowanie extends JFrame implements ActionListener {

    int przesuniecieXY = 25;

    public static List<String> listaWszystkichSlow = new ArrayList<>();
    public static int[] mainOrderFindingTheWords = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
    static Ukladanie ukladanieKrzyzowki = new Ukladanie(listaWszystkichSlow, 1);
   static Ukladanie ukladanieKrzyzowki2 = new Ukladanie(listaWszystkichSlow, 2);

    private ImageIcon tlo;
    private JLabel lTlo;

    public JButton bWyjście, bStart, bWypelnij, bCalosc, bOdswiez;
    public static JLabel lSlowa, lSciezka, lSciezka2, lWIadomosc1, lWIadomosc2, lWIadomosc3;
    public JTextField tfGotowe, Sciezka, tfSlowa;

    public JScrollPane scrollPane;

    public static JLabel literka, literka1, literka2, literka3, literka4, literka5, literka6, literka7, literka8, literka9, literka10, literka11, literka12, literka13, literka14, literka15, literka16, literka17, literka18, literka19, literka20, literka21, literka22, literka23, literka24, literka25, literka26, literka27, literka28, literka29, literka30, literka31, literka32, literka33, literka34, literka35, literka36, literka37, literka38, literka39, literka40, literka41, literka42, literka43, literka44, literka45, literka46, literka47, literka48, literka49, literka50, literka51, literka52, literka53, literka54, literka55, literka56, literka57, literka58, literka59, literka60, literka61, literka62, literka63, literka64, literka65, literka66, literka67, literka68, literka69, literka70, literka71, literka72, literka73, literka74, literka75, literka76, literka77, literka78, literka79, literka80, literka81, literka82, literka83, literka84, literka85, literka86, literka87, literka88, literka89, literka90, literka91, literka92, literka93, literka94, literka95, literka96, literka97, literka98, literka99, literka100, literka101, literka102, literka103, literka104, literka105, literka106, literka107, literka108, literka109, literka110, literka111, literka112, literka113, literka114, literka115, literka116, literka117, literka118, literka119, literka120, literka121, literka122, literka123, literka124, literka125, literka126, literka127, literka128, literka129, literka130, literka131, literka132, literka133, literka134, literka135, literka136, literka137, literka138, literka139, literka140;
    public JLabel lWords1Number,lWords2Number, lWords2Number2,lWords3Number,lWords3Number2,lWords4Number,lWords5Number,
            lWords5Number2, lWords6Number,lWords7Number,lWords7Number2,lWords8Number,lWords9Number,lWords10Number,lWords10Number2,
            lWords11Number,lWords11Number2,lWords12Number,lWords13Number,lWords14Number, lWords14Number2, lWords15Number,
            lWords16Number,lWords16Number2,lWords17Number,lWords17Number2,lWords18Number,lWords19Number,lWords19Number2,lWords20Number,
            lWords20Number2, lWords21Number,lWords21Number2,lWords22Number,lWords22Number2,lWords23Number,lWords24Number,lWords24Number2,
            lWords25Number, lWords25Number2,lWords26Number,lWords27Number,lWords28Number,lWords29Number,lWords29Number2,
            lWords30Number,lWords31Number,lWords31Number2,lWords32Number,lWords33Number,lWords33Number2,lWords34Number,lWords34Number2,
            lWords35Number,lWords36Number,lWords37Number;

    public static String subString1, subString2, subString3, subString4, subString5, subString6, subString7,
            subString8, subString9, subString10, subString11, subString12, subString13;

    boolean widoczne = false;

    public static JScrollPane sp;

    public static JTextArea taPoleSlow;

    public static String[] Słówka = new String[100];

    public static int variabl;

    public static Boolean OK = false;

    public void setWordNumberLabel(){
        lWords1Number.setText("1-");
        lWords2Number.setText("2");
        lWords2Number2.setText("|");
        lWords3Number.setText("3");
        lWords3Number2.setText("|");
        lWords4Number.setText("4-");
        lWords5Number.setText("5");
        lWords5Number2.setText("|");
        lWords6Number.setText("6-");
        lWords7Number.setText("7");
        lWords7Number2.setText("|");
        lWords8Number.setText("8-");
        lWords9Number.setText("9-");
        lWords10Number.setText("10");
        lWords10Number2.setText("|");
        lWords11Number.setText("11");
        lWords11Number2.setText("|");
        lWords12Number.setText("12-");
        lWords13Number.setText("13-");
        lWords14Number.setText("14");
        lWords14Number2.setText("|");
        lWords15Number.setText("15-");
        lWords16Number.setText("16");
        lWords16Number2.setText("|");
        lWords17Number.setText("17");
        lWords17Number2.setText("|");
        lWords18Number.setText("18-");
        lWords19Number.setText("19");
        lWords19Number2.setText("|");
        lWords20Number.setText("20");
        lWords20Number2.setText("|");
        lWords21Number.setText("21");
        lWords21Number2.setText("|");
        lWords22Number.setText("22");
        lWords22Number2.setText("|");
        lWords23Number.setText("23-");
        lWords24Number.setText("24");
        lWords24Number2.setText("|");
        lWords25Number.setText("25");
        lWords25Number2.setText("|");
        lWords26Number.setText("26-");
        lWords27Number.setText("27-");
        lWords28Number.setText("28-");
        lWords29Number.setText("29");
        lWords29Number2.setText("|");
        lWords30Number.setText("30-");
        lWords31Number.setText("31");
        lWords31Number2.setText("|");
        lWords32Number.setText("32-");
        lWords33Number.setText("33");
        lWords33Number2.setText("|");
        lWords34Number.setText("34");
        lWords34Number2.setText("|");
        lWords35Number.setText("35-");
        lWords36Number.setText("36-");
        lWords37Number.setText("37-");
    }

    public KrzyzowkaRysowanie(String[] Słowa, int variable, boolean wszystkie) {

        try {
            loadWords();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Słówka = Słowa;
        for (int r = 0; r < Słówka.length; r++) {
            if (Słówka[r] == null)
                Słówka[r] = "                            ";
        }
        variabl = variable;

        setSize(1150, 655);
        setTitle("Okno główne programu");
        setLayout(null);

        bOdswiez = new JButton("REFRESH");
        bOdswiez.setBounds(820, 20, 100, 20);
        add(bOdswiez);
        bOdswiez.addActionListener(this);

        bCalosc = new JButton(" --- Uzupełnianie Krzyzowki---");
        bCalosc.setBounds(820, 520, 280, 20);
        add(bCalosc);
        bCalosc.addActionListener(this);
        bCalosc.setEnabled(widoczne);

        bWypelnij = new JButton("Spróbuj wypełnić pola");
        bWypelnij.setBounds(820, 70, 320, 20);
        add(bWypelnij);
        bWypelnij.addActionListener(this);
        bWypelnij.setVisible(OK);

        bWyjście = new JButton("Poworót");
        bWyjście.setBounds(820, 480, 100, 20);
        add(bWyjście);
        bWyjście.addActionListener(this);

        bStart = new JButton("Start");
        bStart.setBounds(1000, 480, 100, 20);
        add(bStart);
//		bStart.setEnabled(false);
        bStart.addActionListener(this);

        lWIadomosc1 = new JLabel("Włącz przycisk");
        lWIadomosc1.setBounds(900, 310, 550, 60);
        add(lWIadomosc1);

        lWIadomosc2 = new JLabel("                    Start");
        lWIadomosc2.setBounds(870, 350, 550, 60);
        add(lWIadomosc2);

        lWIadomosc3 = new JLabel("                by wyswietlic krzyżówkę");
        lWIadomosc3.setBounds(830, 390, 550, 60);
        add(lWIadomosc3);

        taPoleSlow = new JTextArea("");
        // create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        // set the border of this component
        taPoleSlow.setBorder(border);

        taPoleSlow.setWrapStyleWord(true);
        taPoleSlow.setBackground(Color.white);
        taPoleSlow.setEnabled(false);
        sp = new JScrollPane(taPoleSlow);
        sp.setBounds(760, 90, 340, 200);
        sp.setBackground(Color.white);
        sp.setVisible(true);
        sp.setEnabled(false);
        add(sp);

        //-----------------------------------Pierwszy Pion

        literka1 = new JLabel(Słówka[1].substring(0, 1));
        literka1.setBounds(55+przesuniecieXY /*+25*/, 95-przesuniecieXY /*-25*/, 15, 30);
        add(literka1);
        literka1.setVisible(true);

        literka2 = new JLabel(Słówka[1].substring(1, 2));
        literka2.setBounds(55+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka2);
        literka2.setVisible(true);

        literka3 = new JLabel(Słówka[1].substring(2, 3));
        literka3.setBounds(55+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka3);
        literka3.setVisible(true);

        literka4 = new JLabel(Słówka[1].substring(3, 4));
        literka4.setBounds(55+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka4);
        literka4.setVisible(true);

        literka5 = new JLabel(Słówka[1].substring(4, 5));
        literka5.setBounds(55+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka5);
        literka5.setVisible(true);

        literka6 = new JLabel((Słówka[29].substring(0, 1)));
        literka6.setBounds(55+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka6);
        literka6.setVisible(true);

        literka7 = new JLabel((Słówka[31].substring(0, 1)));
        literka7.setBounds(55+przesuniecieXY, 415-przesuniecieXY, 15, 30);
        add(literka7);
        literka7.setVisible(true);

        literka8 = new JLabel((Słówka[32].substring(1, 2))); //
        literka8.setBounds(55+przesuniecieXY, 455-przesuniecieXY, 15, 30);
        add(literka8);
        literka8.setVisible(true);

        literka9 = new JLabel((Słówka[32].substring(2, 3))); //
        literka9.setBounds(55+przesuniecieXY, 495-przesuniecieXY, 15, 30);
        add(literka9);
        literka9.setVisible(true);

        literka10 = new JLabel((Słówka[32].substring(3, 4))); //
        literka10.setBounds(55+przesuniecieXY, 535-przesuniecieXY, 15, 30);
        add(literka10);
        literka10.setVisible(true);

        literka11 = new JLabel((Słówka[32].substring(4, 5))); //
        literka11.setBounds(55+przesuniecieXY, 575-przesuniecieXY, 15, 30);
        add(literka11);
        literka11.setVisible(true);

        //------------------Drugi

        literka12 = new JLabel(Słówka[0].substring(1, 2));
        literka12.setBounds(95+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka12);
        literka12.setVisible(true);

        literka13 = new JLabel(Słówka[3].substring(1, 2));
        literka13.setBounds(95+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka13);
        literka13.setVisible(true);

        literka14 = new JLabel(Słówka[4].substring(1, 2));
        literka14.setBounds(95+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka14);
        literka14.setVisible(true);

        literka15 = new JLabel(Słówka[28].substring(1, 2)); //
        literka15.setBounds(95+przesuniecieXY, 295-przesuniecieXY, 15, 30);
        add(literka15);
        literka15.setVisible(true);

        literka16 = new JLabel(Słówka[29].substring(1, 2)); //
        literka16.setBounds(95+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka16);
        literka16.setVisible(true);

        literka17 = new JLabel(Słówka[28].substring(3, 4)); //
        literka17.setBounds(95+przesuniecieXY, 375-przesuniecieXY, 15, 30);
        add(literka17);
        literka17.setVisible(true);

        literka18 = new JLabel(Słówka[28].substring(4, 5)); //
        literka18.setBounds(95+przesuniecieXY, 415-przesuniecieXY, 15, 30);
        add(literka18);
        literka18.setVisible(true);

        literka19 = new JLabel(Słówka[33].substring(1, 2)); //
        literka19.setBounds(95+przesuniecieXY, 495-przesuniecieXY, 15, 30);
        add(literka19);
        literka19.setVisible(true);

        literka20 = new JLabel(Słówka[35].substring(1, 2)); //
        literka20.setBounds(95+przesuniecieXY, 575-przesuniecieXY, 15, 30);
        add(literka20);
        literka20.setVisible(true);

        //---------------------------- Trzeci

        literka21 = new JLabel(Słówka[0].substring(2, 3));
        literka21.setBounds(135+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka21);
        literka21.setVisible(true);

        literka22 = new JLabel(Słówka[3].substring(1, 2));
        literka22.setBounds(135+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka22);
        literka22.setVisible(true);

        literka23 = new JLabel(Słówka[3].substring(2, 3));
        literka23.setBounds(135+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka23);
        literka23.setVisible(true);

        literka24 = new JLabel(Słówka[3].substring(3, 4));
        literka24.setBounds(135+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka24);
        literka24.setVisible(true);

        literka25 = new JLabel(Słówka[3].substring(4, 5));
        literka25.setBounds(135+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka25);
        literka25.setVisible(true);

        literka26 = new JLabel(Słówka[29].substring(2, 3));
        literka26.setBounds(135+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka26);
        literka26.setVisible(true);

        literka27 = new JLabel(Słówka[34].substring(0, 1)); //14
        literka27.setBounds(135+przesuniecieXY, 415-przesuniecieXY, 15, 30);
        add(literka27);
        literka27.setVisible(true);

        literka28 = new JLabel(Słówka[34].substring(1, 2));
        literka28.setBounds(135+przesuniecieXY, 455-przesuniecieXY, 15, 30);
        add(literka28);
        literka28.setVisible(true);

        literka29 = new JLabel(Słówka[34].substring(2, 3));
        literka29.setBounds(135+przesuniecieXY, 495-przesuniecieXY, 15, 30);
        add(literka29);
        literka29.setVisible(true);

        literka30 = new JLabel(Słówka[34].substring(3, 4));
        literka30.setBounds(135+przesuniecieXY, 535-przesuniecieXY, 15, 30);
        add(literka30);
        literka30.setVisible(true);

        literka31 = new JLabel(Słówka[34].substring(4, 5));
        literka31.setBounds(135+przesuniecieXY, 575-przesuniecieXY, 15, 30);
        add(literka31);
        literka31.setVisible(true);

        //-------------------------------------- Czwarty

        literka32 = new JLabel(Słówka[0].substring(3, 4));
        literka32.setBounds(175+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka32);
        literka32.setVisible(true);

        literka33 = new JLabel(Słówka[2].substring(3, 4));
        literka33.setBounds(175+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka33);
        literka33.setVisible(true);

        literka34 = new JLabel(Słówka[4].substring(3, 4));
        literka34.setBounds(175+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka34);
        literka34.setVisible(true);

        literka35 = new JLabel(Słówka[30].substring(1, 2));
        literka35.setBounds(175+przesuniecieXY, 295-przesuniecieXY, 15, 30);
        add(literka35);
        literka35.setVisible(true);

        literka36 = new JLabel(Słówka[29].substring(3, 4));
        literka36.setBounds(175+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka36);
        literka36.setVisible(true);

        literka37 = new JLabel(Słówka[30].substring(3, 4));
        literka37.setBounds(175+przesuniecieXY, 375-przesuniecieXY, 15, 30);
        add(literka37);
        literka37.setVisible(true);

        literka38 = new JLabel(Słówka[31].substring(3, 4));
        literka38.setBounds(175+przesuniecieXY, 415-przesuniecieXY, 15, 30);
        add(literka38);
        literka38.setVisible(true);

        literka39 = new JLabel(Słówka[33].substring(3, 4));
        literka39.setBounds(175+przesuniecieXY, 495-przesuniecieXY, 15, 30);
        add(literka39);
        literka39.setVisible(true);

        literka40 = new JLabel(Słówka[35].substring(3, 4));
        literka40.setBounds(175+przesuniecieXY, 575-przesuniecieXY, 15, 30);
        add(literka40);
        literka40.setVisible(true);

        //-----------------------Piąty

        literka41 = new JLabel(Słówka[0].substring(4, 5));
        literka41.setBounds(215+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka41);
        literka41.setVisible(true);

        literka42 = new JLabel(Słówka[5].substring(1, 2));
        literka42.setBounds(215+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka42);
        literka42.setVisible(true);

        literka43 = new JLabel(Słówka[2].substring(4, 5));
        literka43.setBounds(215+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka43);
        literka43.setVisible(true);

        literka44 = new JLabel(Słówka[5].substring(3, 4));
        literka44.setBounds(215+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka44);
        literka44.setVisible(true);

        literka45 = new JLabel(Słówka[4].substring(4, 5));
        literka45.setBounds(215+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka45);
        literka45.setVisible(true);

        literka46 = new JLabel(Słówka[29].substring(4, 5));
        literka46.setBounds(215+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka46);
        literka46.setVisible(true);

        literka47 = new JLabel(Słówka[31].substring(4, 5));
        literka47.setBounds(215+przesuniecieXY, 415-przesuniecieXY, 15, 30);
        add(literka47);
        literka47.setVisible(true);

        literka48 = new JLabel(Słówka[36].substring(1, 2));
        literka48.setBounds(215+przesuniecieXY, 455-przesuniecieXY, 15, 30);
        add(literka48);
        literka48.setVisible(true);

        literka49 = new JLabel(Słówka[33].substring(4, 5));
        literka49.setBounds(215+przesuniecieXY, 495-przesuniecieXY, 15, 30);
        add(literka49);
        literka49.setVisible(true);

        literka50 = new JLabel(Słówka[36].substring(3, 4));
        literka50.setBounds(215+przesuniecieXY, 535-przesuniecieXY, 15, 30);
        add(literka50);
        literka50.setVisible(true);

        literka51 = new JLabel(Słówka[36].substring(4, 5));
        literka51.setBounds(215+przesuniecieXY, 575-przesuniecieXY, 15, 30);
        add(literka51);
        literka51.setVisible(true);

        //---------------------------Szusty

        literka52 = new JLabel(Słówka[0].substring(5, 6));
        literka52.setBounds(255+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka52);
        literka52.setVisible(true);

        literka53 = new JLabel(Słówka[2].substring(4, 5));
        literka53.setBounds(255+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka53);
        literka53.setVisible(true);

        literka54 = new JLabel(Słówka[20].substring(0, 1));
        literka54.setBounds(255+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka54);
        literka54.setVisible(true);

        literka55 = new JLabel(Słówka[20].substring(1, 2));
        literka55.setBounds(255+przesuniecieXY, 295-przesuniecieXY, 15, 30);
        add(literka55);
        literka55.setVisible(true);

        literka56 = new JLabel(Słówka[20].substring(2, 3));
        literka56.setBounds(255+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka56);
        literka56.setVisible(true);

        literka57 = new JLabel(Słówka[20].substring(3, 4));
        literka57.setBounds(255+przesuniecieXY, 375-przesuniecieXY, 15, 30);
        add(literka57);
        literka57.setVisible(true);

        literka58 = new JLabel(Słówka[20].substring(4, 5));
        literka58.setBounds(255+przesuniecieXY, 415-przesuniecieXY, 15, 30);
        add(literka58);
        literka58.setVisible(true);

        literka59 = new JLabel(Słówka[33].substring(5, 6));
        literka59.setBounds(255+przesuniecieXY, 495-przesuniecieXY, 15, 30);
        add(literka59);
        literka59.setVisible(true);

        literka60 = new JLabel(Słówka[35].substring(5, 6));
        literka60.setBounds(255+przesuniecieXY, 575-przesuniecieXY, 15, 30);
        add(literka60);
        literka60.setVisible(true);
        //----------------------------Siudmy

        literka61 = new JLabel(Słówka[0].substring(6, 7));
        literka61.setBounds(295+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka61);
        literka61.setVisible(true);

        literka62 = new JLabel(Słówka[6].substring(1, 2));
        literka62.setBounds(295+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka62);
        literka62.setVisible(true);

        literka63 = new JLabel(Słówka[2].substring(4, 5));
        literka63.setBounds(295+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka63);
        literka63.setVisible(true);

        literka64 = new JLabel(Słówka[6].substring(3, 4));
        literka64.setBounds(295+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka64);
        literka64.setVisible(true);

        literka65 = new JLabel(Słówka[21].substring(1, 2));
        literka65.setBounds(295+przesuniecieXY, 295-przesuniecieXY, 15, 30);
        add(literka65);
        literka65.setVisible(true);

        literka66 = new JLabel(Słówka[23].substring(1, 2));
        literka66.setBounds(295+przesuniecieXY, 375-przesuniecieXY, 15, 30);
        add(literka66);
        literka66.setVisible(true);

        literka67 = new JLabel(Słówka[24].substring(0, 1));
        literka67.setBounds(295+przesuniecieXY, 455-przesuniecieXY, 15, 30);
        add(literka67);
        literka67.setVisible(true);

        literka68 = new JLabel(Słówka[27].substring(1, 2));
        literka68.setBounds(295+przesuniecieXY, 495-przesuniecieXY, 15, 30);
        add(literka68);
        literka68.setVisible(true);

        literka69 = new JLabel(Słówka[27].substring(2, 3));
        literka69.setBounds(295+przesuniecieXY, 535-przesuniecieXY, 15, 30);
        add(literka69);
        literka69.setVisible(true);

        literka70 = new JLabel(Słówka[27].substring(3, 4));
        literka70.setBounds(295+przesuniecieXY, 575-przesuniecieXY, 15, 30);
        add(literka70);
        literka70.setVisible(true);

        //----------------------------Ósmy

        literka71 = new JLabel(Słówka[7].substring(1, 2));
        literka71.setBounds(335+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka71);
        literka71.setVisible(true);

        literka72 = new JLabel(Słówka[8].substring(1, 2));
        literka72.setBounds(335+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka72);
        literka72.setVisible(true);

        literka73 = new JLabel(Słówka[22].substring(1, 2));
        literka73.setBounds(335+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka73);
        literka73.setVisible(true);

        literka74 = new JLabel(Słówka[21].substring(2, 3));
        literka74.setBounds(335+przesuniecieXY, 295-przesuniecieXY, 15, 30);
        add(literka74);
        literka74.setVisible(true);

        literka75 = new JLabel(Słówka[22].substring(3, 4));
        literka75.setBounds(335+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka75);
        literka75.setVisible(true);

        literka76 = new JLabel(Słówka[22].substring(4, 5));
        literka76.setBounds(335+przesuniecieXY, 375-przesuniecieXY, 15, 30);
        add(literka76);
        literka76.setVisible(true);

        literka77 = new JLabel(Słówka[22].substring(5, 6));
        literka77.setBounds(335+przesuniecieXY, 415-przesuniecieXY, 15, 30);
        add(literka77);
        literka77.setVisible(true);

        literka78 = new JLabel(Słówka[24].substring(1, 2)); //"52"
        literka78.setBounds(335+przesuniecieXY, 455-przesuniecieXY, 15, 30);
        add(literka78);
        literka78.setVisible(true);

        literka79 = new JLabel(Słówka[26].substring(1, 2));//
        literka79.setBounds(335+przesuniecieXY, 535-przesuniecieXY, 15, 30);
        add(literka79);
        literka79.setVisible(true);

        //---------------------------Dziewiąty

        literka80 = new JLabel(Słówka[10].substring(0, 1));
        literka80.setBounds(375+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka80);
        literka80.setVisible(true);

        literka81 = new JLabel(Słówka[10].substring(1, 2));
        literka81.setBounds(375+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka81);
        literka81.setVisible(true);

        literka82 = new JLabel(Słówka[10].substring(2, 3));
        literka82.setBounds(375+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka82);
        literka82.setVisible(true);

        literka83 = new JLabel(Słówka[10].substring(3, 4));
        literka83.setBounds(375+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka83);
        literka83.setVisible(true);

        literka84 = new JLabel(Słówka[21].substring(3, 4));
        literka84.setBounds(375+przesuniecieXY, 295-przesuniecieXY, 15, 30);
        add(literka84);
        literka84.setVisible(true);

        literka85 = new JLabel(Słówka[23].substring(3, 4));
        literka85.setBounds(375+przesuniecieXY, 375-przesuniecieXY, 15, 30);
        add(literka85);
        literka85.setVisible(true);

        literka86 = new JLabel(Słówka[24].substring(2, 3));
        literka86.setBounds(375+przesuniecieXY, 455-przesuniecieXY, 15, 30);
        add(literka86);
        literka86.setVisible(true);

        literka87 = new JLabel(Słówka[25].substring(1, 2));
        literka87.setBounds(375+przesuniecieXY, 495-przesuniecieXY, 15, 30);
        add(literka87);
        literka87.setVisible(true);

        literka88 = new JLabel(Słówka[25].substring(2, 3));
        literka88.setBounds(375+przesuniecieXY, 535-przesuniecieXY, 15, 30);
        add(literka88);
        literka88.setVisible(true);

        literka89 = new JLabel(Słówka[25].substring(3, 4));
        literka89.setBounds(375+przesuniecieXY, 575-przesuniecieXY, 15, 30);
        add(literka89);
        literka89.setVisible(true);

        //---------------------------Dziesiąty

        literka90 = new JLabel(Słówka[7].substring(3, 4));
        literka90.setBounds(415+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka90);
        literka90.setVisible(true);

        literka91 = new JLabel(Słówka[8].substring(3, 4));
        literka91.setBounds(415+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka91);
        literka91.setVisible(true);

        literka92 = new JLabel(Słówka[21].substring(4, 5));
        literka92.setBounds(415+przesuniecieXY, 295-przesuniecieXY, 15, 30);
        add(literka92);
        literka92.setVisible(true);

        literka93 = new JLabel(Słówka[23].substring(4, 5));
        literka93.setBounds(415+przesuniecieXY, 375-przesuniecieXY, 15, 30);
        add(literka93);
        literka93.setVisible(true);

        literka94 = new JLabel(Słówka[24].substring(3, 4));
        literka94.setBounds(415+przesuniecieXY, 455-przesuniecieXY, 15, 30);
        add(literka94);
        literka94.setVisible(true);

        literka95 = new JLabel(Słówka[26].substring(3, 4));
        literka95.setBounds(415+przesuniecieXY, 535-przesuniecieXY, 15, 30);
        add(literka95);
        literka95.setVisible(true);

        //---------------------------Jedynasty

        literka96 = new JLabel(Słówka[9].substring(0, 1));
        literka96.setBounds(455+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka96);
        literka96.setVisible(true);

        literka97 = new JLabel(Słówka[9].substring(1, 2));
        literka97.setBounds(455+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka97);
        literka97.setVisible(true);


        literka98 = new JLabel(Słówka[9].substring(2, 3));
        literka98.setBounds(455+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka98);
        literka98.setVisible(true);

        literka99 = new JLabel(Słówka[9].substring(3, 4));
        literka99.setBounds(455+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka99);
        literka99.setVisible(true);

        literka100 = new JLabel(Słówka[9].substring(4, 5));
        literka100.setBounds(455+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka100);
        literka100.setVisible(true);

        literka101 = new JLabel(Słówka[9].substring(5, 6));
        literka101.setBounds(455+przesuniecieXY, 295-przesuniecieXY, 15, 30);
        add(literka101);
        literka101.setVisible(true);

        literka102 = new JLabel(Słówka[9].substring(6, 7));
        literka102.setBounds(455+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka102);
        literka102.setVisible(true);

        literka135 = new JLabel(Słówka[9].substring(7, 8));
        literka135.setBounds(455+przesuniecieXY, 375-przesuniecieXY, 15, 30);
        add(literka135);
        literka135.setVisible(true);

        literka136 = new JLabel(Słówka[9].substring(8, 9));
        literka136.setBounds(455+przesuniecieXY, 415-przesuniecieXY, 15, 30);
        add(literka136);
        literka136.setVisible(true);

        literka137 = new JLabel(Słówka[9].substring(9, 10));
        literka137.setBounds(455+przesuniecieXY, 455-przesuniecieXY, 15, 30);
        add(literka137);
        literka137.setVisible(true);

        literka138 = new JLabel(Słówka[9].substring(10, 11));
        literka138.setBounds(455+przesuniecieXY, 495-przesuniecieXY, 15, 30);
        add(literka138);
        literka138.setVisible(true);

        literka139 = new JLabel(Słówka[9].substring(11, 12));
        literka139.setBounds(455+przesuniecieXY, 535-przesuniecieXY, 15, 30);
        add(literka139);
        literka139.setVisible(true);

        literka140 = new JLabel(Słówka[9].substring(12, 13));
        literka140.setBounds(455+przesuniecieXY, 575-przesuniecieXY, 15, 30);
        add(literka140);
        literka140.setVisible(true);

        //---------------------------Dwunasty

        literka103 = new JLabel(Słówka[11].substring(1, 2));
        literka103.setBounds(495+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka103);
        literka103.setVisible(true);

        literka104 = new JLabel(Słówka[12].substring(1, 2));
        literka104.setBounds(495+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka104);
        literka104.setVisible(true);

        literka105 = new JLabel(Słówka[16].substring(1, 2));
        literka105.setBounds(495+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka105);
        literka105.setVisible(true);

        literka106 = new JLabel(Słówka[18].substring(1, 2));
        literka106.setBounds(495+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka106);
        literka106.setVisible(true);

        //----------------------------Trzynasty

        literka107 = new JLabel(Słówka[13].substring(0, 1));
        literka107.setBounds(535+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka107);
        literka107.setVisible(true);

        literka108 = new JLabel(Słówka[13].substring(1, 2));
        literka108.setBounds(535+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka108);
        literka108.setVisible(true);

        literka109 = new JLabel(Słówka[13].substring(2, 3));
        literka109.setBounds(535+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka109);
        literka109.setVisible(true);

        literka110 = new JLabel(Słówka[13].substring(3, 4));
        literka110.setBounds(535+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka110);
        literka110.setVisible(true);

        literka111 = new JLabel(Słówka[13].substring(4, 5));
        literka111.setBounds(535+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka111);
        literka111.setVisible(true);

        literka112 = new JLabel(Słówka[18].substring(2, 3));
        literka112.setBounds(535+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka112);
        literka112.setVisible(true);

        //---------------------------Czternasty

        literka113 = new JLabel(Słówka[11].substring(3, 4));
        literka113.setBounds(575+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka113);
        literka113.setVisible(true);

        literka114 = new JLabel(Słówka[12].substring(3, 4));
        literka114.setBounds(575+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka114);
        literka114.setVisible(true);

        literka115 = new JLabel(Słówka[16].substring(3, 4));
        literka115.setBounds(575+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka115);
        literka115.setVisible(true);

        literka116 = new JLabel(Słówka[17].substring(1, 2));
        literka116.setBounds(575+przesuniecieXY, 295-przesuniecieXY, 15, 30);
        add(literka116);
        literka116.setVisible(true);

        literka117 = new JLabel(Słówka[17].substring(2, 3));
        literka117.setBounds(575+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka117);
        literka117.setVisible(true);

        //----------------------------Piętnasty

        literka118 = new JLabel(Słówka[14].substring(0, 1));
        literka118.setBounds(615+przesuniecieXY, 95-przesuniecieXY, 20, 30);
        add(literka118);
        literka118.setVisible(true);

        literka119 = new JLabel(Słówka[14].substring(1, 2));
        literka119.setBounds(615+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka119);
        literka119.setVisible(true);

        literka120 = new JLabel(Słówka[14].substring(2, 3));
        literka120.setBounds(615+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka120);
        literka120.setVisible(true);

        literka121 = new JLabel(Słówka[14].substring(3, 4));
        literka121.setBounds(615+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka121);
        literka121.setVisible(true);

        literka122 = new JLabel(Słówka[14].substring(4, 5));
        literka122.setBounds(615+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka122);
        literka122.setVisible(true);

        literka123 = new JLabel(Słówka[18].substring(4, 5));
        literka123.setBounds(615+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka123);
        literka123.setVisible(true);

        //----------------------------Szesnasty

        literka124 = new JLabel(Słówka[11].substring(5, 6));
        literka124.setBounds(655+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka124);
        literka124.setVisible(true);

        literka125 = new JLabel(Słówka[12].substring(5, 6));
        literka125.setBounds(655+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka125);
        literka125.setVisible(true);

        literka126 = new JLabel(Słówka[16].substring(5, 6));
        literka126.setBounds(655+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka126);
        literka126.setVisible(true);

        literka127 = new JLabel(Słówka[19].substring(1, 2));
        literka127.setBounds(655+przesuniecieXY, 295-przesuniecieXY, 15, 30);
        add(literka127);
        literka127.setVisible(true);

        literka128 = new JLabel(Słówka[19].substring(2, 3));
        literka128.setBounds(655+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka128);
        literka128.setVisible(true);

        //---------------------------Siedemnasty

        literka129 = new JLabel(Słówka[15].substring(0, 1));
        literka129.setBounds(695+przesuniecieXY, 95-przesuniecieXY, 15, 30);
        add(literka129);
        literka129.setVisible(true);

        literka130 = new JLabel(Słówka[15].substring(1, 2));
        literka130.setBounds(695+przesuniecieXY, 135-przesuniecieXY, 15, 30);
        add(literka130);
        literka130.setVisible(true);

        literka131 = new JLabel(Słówka[15].substring(2, 3));
        literka131.setBounds(695+przesuniecieXY, 175-przesuniecieXY, 15, 30);
        add(literka131);
        literka131.setVisible(true);

        literka132 = new JLabel(Słówka[15].substring(3, 4));
        literka132.setBounds(695+przesuniecieXY, 215-przesuniecieXY, 15, 30);
        add(literka132);
        literka132.setVisible(true);

        literka133 = new JLabel(Słówka[15].substring(4, 5));
        literka133.setBounds(695+przesuniecieXY, 255-przesuniecieXY, 15, 30);
        add(literka133);
        literka133.setVisible(true);

        literka134 = new JLabel(Słówka[18].substring(6, 7));
        literka134.setBounds(695+przesuniecieXY, 335-przesuniecieXY, 15, 30);
        add(literka134);
        literka134.setVisible(true);

        //------------------------------------------------------------------------------------------------------------

        lWords1Number = new JLabel("");
        lWords1Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords1Number.setBounds(63, 68, 15, 15);
        add(lWords1Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords2Number = new JLabel("");
        lWords2Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords2Number.setBounds(63, 78, 15, 15);
        add(lWords2Number);

        lWords2Number2 = new JLabel("");
        lWords2Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords2Number2.setBounds(63, 88, 15, 15);
        add(lWords2Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords3Number = new JLabel("");
        lWords3Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords3Number.setBounds(143, 68, 15, 15);
        add(lWords3Number);

        lWords3Number2 = new JLabel("");
        lWords3Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords3Number2.setBounds(143, 78, 15, 15);
        add(lWords3Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords4Number = new JLabel("");
        lWords4Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords4Number.setBounds(63, 148, 15, 15);
        add(lWords4Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords5Number = new JLabel();
        lWords5Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords5Number.setBounds(223, 68, 15, 15);
        add(lWords5Number);

        lWords5Number2 = new JLabel();
        lWords5Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords5Number2.setBounds(223, 78, 15, 15);
        add(lWords5Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords6Number = new JLabel();
        lWords6Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords6Number.setBounds(63, 228, 15, 15);
        add(lWords6Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords7Number = new JLabel();
        lWords7Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords7Number.setBounds(303, 68, 15, 15);
        add(lWords7Number);

        lWords7Number2 = new JLabel();
        lWords7Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords7Number2.setBounds(303, 78, 15, 15);
        add(lWords7Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords8Number = new JLabel();
        lWords8Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords8Number.setBounds(303, 108, 15, 15);
        add(lWords8Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords9Number = new JLabel();
        lWords9Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords9Number.setBounds(303, 188, 15, 15);
        add(lWords9Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords10Number = new JLabel();
        lWords10Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords10Number.setBounds(383, 68, 15, 15);
        add(lWords10Number);

        lWords10Number2 = new JLabel();
        lWords10Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords10Number2.setBounds(383, 78, 15, 15);
        add(lWords10Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords11Number = new JLabel();
        lWords11Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords11Number.setBounds(463, 78, 15, 15);
        add(lWords11Number);

        lWords11Number2 = new JLabel();
        lWords11Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords11Number2.setBounds(463, 88, 15, 15);
        add(lWords11Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords12Number = new JLabel();
        lWords12Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords12Number.setBounds(463, 68, 20, 15);
        add(lWords12Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords13Number = new JLabel();
        lWords13Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords13Number.setBounds(463, 148, 20, 15);
        add(lWords13Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords14Number = new JLabel();
        lWords14Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords14Number.setBounds(543, 68, 15, 15);
        add(lWords14Number);

        lWords14Number2 = new JLabel();
        lWords14Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords14Number2.setBounds(543, 78, 15, 15);
        add(lWords14Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords15Number = new JLabel();
        lWords15Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords15Number.setBounds(463, 228, 20, 15);
        add(lWords15Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords16Number = new JLabel();
        lWords16Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords16Number.setBounds(623, 68, 15, 15);
        add(lWords16Number);

        lWords16Number2 = new JLabel();
        lWords16Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords16Number2.setBounds(623, 78, 15, 15);
        add(lWords16Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords17Number = new JLabel();
        lWords17Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords17Number.setBounds(703, 68, 15, 15);
        add(lWords17Number);

        lWords17Number2 = new JLabel();
        lWords17Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords17Number2.setBounds(703, 78, 15, 15);
        add(lWords17Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords18Number = new JLabel();
        lWords18Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords18Number.setBounds(463, 308, 20, 15);
        add(lWords18Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords19Number = new JLabel();
        lWords19Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords19Number.setBounds(583, 228, 20, 15);
        add(lWords19Number);

        lWords19Number2 = new JLabel();
        lWords19Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords19Number2.setBounds(583, 238, 20, 15);
        add(lWords19Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords20Number = new JLabel();
        lWords20Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords20Number.setBounds(663, 228, 20, 15);
        add(lWords20Number);

        lWords20Number2 = new JLabel();
        lWords20Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords20Number2.setBounds(663, 238, 20, 15);
        add(lWords20Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords21Number = new JLabel();
        lWords21Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords21Number.setBounds(343, 188, 15, 15);
        add(lWords21Number);

        lWords21Number2 = new JLabel();
        lWords21Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords21Number2.setBounds(343, 198, 15, 15);
        add(lWords21Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords22Number = new JLabel();
        lWords22Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords22Number.setBounds(103, 228, 15, 15);
        add(lWords22Number);

        lWords22Number2 = new JLabel();
        lWords22Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords22Number2.setBounds(103, 238, 15, 15);
        add(lWords22Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords23Number = new JLabel();
        lWords23Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords23Number.setBounds(63, 308, 20, 15);
        add(lWords23Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords24Number = new JLabel();
        lWords24Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords24Number.setBounds(183, 228, 15, 15);
        add(lWords24Number);

        lWords24Number2 = new JLabel();
        lWords24Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords24Number2.setBounds(183, 238, 15, 15);
        add(lWords24Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords25Number = new JLabel();
        lWords25Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords25Number.setBounds(263, 228, 15, 15);
        add(lWords25Number);

        lWords25Number2 = new JLabel();
        lWords25Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords25Number2.setBounds(263, 238, 15, 15);
        add(lWords25Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords26Number = new JLabel();
        lWords26Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords26Number.setBounds(263, 268, 20, 15);
        add(lWords26Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords27Number = new JLabel();
        lWords27Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords27Number.setBounds(263, 348, 20, 15);
        add(lWords27Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords28Number = new JLabel();
        lWords28Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords28Number.setBounds(63, 388, 20, 15);
        add(lWords28Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords29Number = new JLabel();
        lWords29Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords29Number.setBounds(63, 398, 20, 15);
        add(lWords29Number);

        lWords29Number2 = new JLabel();
        lWords29Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords29Number2.setBounds(63, 408, 20, 15);
        add(lWords29Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords30Number = new JLabel();
        lWords30Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords30Number.setBounds(63, 468, 20, 15);
        add(lWords30Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords31Number = new JLabel();
        lWords31Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords31Number.setBounds(143, 388, 20, 15);
        add(lWords31Number);

        lWords31Number2 = new JLabel();
        lWords31Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords31Number2.setBounds(143, 398, 20, 15);
        add(lWords31Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords32Number = new JLabel();
        lWords32Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords32Number.setBounds(63, 548, 20, 15);
        add(lWords32Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords33Number = new JLabel();
        lWords33Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords33Number.setBounds(223, 388, 20, 15);
        add(lWords33Number);

        lWords33Number2 = new JLabel();
        lWords33Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords33Number2.setBounds(223, 398, 20, 15);
        add(lWords33Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords34Number = new JLabel();
        lWords34Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords34Number.setBounds(303, 438, 20, 15);
        add(lWords34Number);

        lWords34Number2 = new JLabel();
        lWords34Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords34Number2.setBounds(303, 448, 20, 15);
        add(lWords34Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords35Number = new JLabel();
        lWords35Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords35Number.setBounds(303, 428, 20, 15);
        add(lWords35Number);

        // ---------------------------------------------------------------------------------------------------------

        lWords36Number = new JLabel();
        lWords36Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords36Number.setBounds(383, 428, 20, 15);
        add(lWords36Number);

        lWords34Number2 = new JLabel();
        lWords34Number2.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords34Number2.setBounds(383, 438, 20, 15);
        add(lWords34Number2);

        // ---------------------------------------------------------------------------------------------------------

        lWords37Number = new JLabel();
        lWords37Number.setFont(new Font("Calibri", Font.BOLD, 9));
        lWords37Number.setBounds(303, 508, 20, 15);
        add(lWords37Number);

        // ---------------------------------------------------------------------------------------------------------

        tlo = new ImageIcon(this.getClass().getResource("/fame-big.png"));
        lTlo = new JLabel(tlo);
        lTlo.setSize(1150, 655);
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

        KrzyzowkaRysowanie okienko = new KrzyzowkaRysowanie(Słówka, 0, false);
        okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okienko.setLocationRelativeTo(null);
        okienko.setUndecorated(true);
        okienko.setVisible(true);


    }

    private static void loadWords() throws SQLException {

        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();

        PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM words");
        ResultSet resultSet = preparedStatement2.executeQuery();

        while (resultSet.next()) {
            listaWszystkichSlow.add(resultSet.getString("word_name"));
        }

        preparedStatement2.close();
    }

    public void Rysowanie() {
        int z = 40, zz = 40, ii = 0, poziom = 0, pion = 0, zmiennaTablicowa = 0;
        int[] tablica = {5, 8, 10, 19, 22, 24, 33, 36, 38, 46, 48, 49, 51, 60, 62, 63, 65, 67, 69, 78, 80, 82, 89, 92, 94, 103, 106, 108, 117, 200};
        for (int j = 0; j < 17; j++) {
            for (int i = 0; i < 7; i++) {
                Graphics g = getGraphics();
                Graphics2D g2 = (Graphics2D) g;

                Rectangle2D pros = new Rectangle2D.Double(20 + zz, 25 + z, 40, 40);
                poziom = 10 + zz;
                pion = 80 + z;
                if (ii == tablica[zmiennaTablicowa]) {
                    g2.setBackground(Color.BLACK);
                    g2.fill(pros);
                    zmiennaTablicowa++;
                }
                g2.draw(pros);
                ii++;
                z = z + 40;
            }
            z = 40;
            zz = zz + 40;
        }

        zmiennaTablicowa = 0;
        z = 40;
        zz = 40;
        ii = 0;
        int[] tablica2 = {0, 8, 10, 12, 20, 22, 24, 32, 34, 37, 45, 47, 49, 55, 57, 59, 200};
        for (int j = 0; j < 11; j++) {
            for (int i = 0; i < 6; i++) {
                Graphics g = getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                Rectangle2D pros = new Rectangle2D.Double(20 + zz, 305 + z, 40, 40);
                if (ii == tablica2[zmiennaTablicowa]) {
                    g2.setBackground(Color.BLACK);
                    g2.fill(pros);
                    zmiennaTablicowa++;
                }
                g2.draw(pros);
                ii++;
                z = z + 40;
            }
            z = 40;
            zz = zz + 40;
        }
    }
    public void fillLetters(){
        literka1.setText(Słówka[1].substring(0, 1));
        literka2.setText(Słówka[1].substring(1, 2));
        literka3.setText(Słówka[1].substring(2, 3));
        literka4.setText(Słówka[1].substring(3, 4));
        literka5.setText(Słówka[1].substring(4, 5));
        literka6.setText(Słówka[29].substring(0, 1));
        literka7.setText(Słówka[31].substring(0, 1));
        literka8.setText(Słówka[32].substring(1, 2));
        literka9.setText(Słówka[32].substring(2, 3));
        literka10.setText(Słówka[32].substring(3, 4));
        literka11.setText(Słówka[32].substring(4, 5));
        literka12.setText(Słówka[0].substring(1, 2));
        literka13.setText(Słówka[3].substring(1, 2));
        literka14.setText(Słówka[5].substring(1, 2));
        literka15.setText(Słówka[28].substring(1, 2));
        literka16.setText(Słówka[29].substring(1, 2));
        literka17.setText(Słówka[28].substring(3, 4));
        literka18.setText(Słówka[28].substring(4, 5));
        literka19.setText(Słówka[33].substring(1, 2));
        literka20.setText(Słówka[35].substring(1, 2));
        literka21.setText(Słówka[0].substring(2, 3));
        literka22.setText(Słówka[2].substring(1, 2));
        literka23.setText(Słówka[2].substring(2, 3));
        literka24.setText(Słówka[2].substring(3, 4));
        literka25.setText(Słówka[2].substring(4, 5));
        literka26.setText(Słówka[29].substring(2, 3));
        literka27.setText(Słówka[34].substring(0, 1));
        literka28.setText(Słówka[34].substring(1, 2));
        literka29.setText(Słówka[34].substring(2, 3));
        literka30.setText(Słówka[34].substring(3, 4));
        literka31.setText(Słówka[34].substring(4, 5));
        literka32.setText(Słówka[0].substring(3, 4));
        literka33.setText(Słówka[3].substring(3, 4));
        literka34.setText(Słówka[5].substring(3, 4));
        literka35.setText(Słówka[30].substring(1, 2));
        literka36.setText(Słówka[29].substring(3, 4));
        literka37.setText(Słówka[30].substring(3, 4));
        literka38.setText(Słówka[31].substring(3, 4));
        literka39.setText(Słówka[33].substring(3, 4));
        literka40.setText(Słówka[35].substring(3, 4));
        literka41.setText(Słówka[0].substring(4, 5));
        literka42.setText(Słówka[4].substring(1, 2));
        literka43.setText(Słówka[4].substring(2, 3));
        literka44.setText(Słówka[4].substring(3, 4));
        literka45.setText(Słówka[4].substring(4, 5));
        literka46.setText(Słówka[29].substring(4, 5));
        literka47.setText(Słówka[31].substring(4, 5));
        literka48.setText(Słówka[36].substring(1, 2));
        literka49.setText(Słówka[33].substring(4, 5));
        literka50.setText(Słówka[36].substring(3, 4));
        literka51.setText(Słówka[36].substring(4, 5));
        literka52.setText(Słówka[0].substring(5, 6));
        literka53.setText(Słówka[3].substring(5, 6));
        literka54.setText(Słówka[5].substring(5, 6));
        literka55.setText(Słówka[20].substring(1, 2));
        literka56.setText(Słówka[20].substring(2, 3));
        literka57.setText(Słówka[20].substring(3, 4));
        literka58.setText(Słówka[20].substring(4, 5));
        literka59.setText(Słówka[33].substring(5, 6));
        literka60.setText(Słówka[35].substring(5, 6));
        literka61.setText(Słówka[0].substring(6, 7));
        literka62.setText(Słówka[6].substring(1, 2));
        literka63.setText(Słówka[3].substring(6, 7));
        literka64.setText(Słówka[6].substring(3, 4));
        literka65.setText(Słówka[21].substring(1, 2));
        literka66.setText(Słówka[23].substring(1, 2));
        literka67.setText(Słówka[24].substring(0, 1));
        literka68.setText(Słówka[27].substring(1, 2));
        literka69.setText(Słówka[27].substring(2, 3));
        literka70.setText(Słówka[27].substring(3, 4));
        literka71.setText(Słówka[7].substring(1, 2));
        literka72.setText(Słówka[8].substring(1, 2));
        literka73.setText(Słówka[22].substring(1, 2));
        literka74.setText(Słówka[21].substring(2, 3));
        literka75.setText(Słówka[22].substring(3, 4));
        literka76.setText(Słówka[22].substring(4, 5));
        literka77.setText(Słówka[22].substring(5, 6));
        literka78.setText(Słówka[24].substring(1, 2));
        literka79.setText(Słówka[26].substring(1, 2));
        literka80.setText(Słówka[9].substring(0, 1));
        literka81.setText(Słówka[7].substring(2, 3));
        literka82.setText(Słówka[9].substring(2, 3));
        literka83.setText(Słówka[8].substring(2, 3));
        literka84.setText(Słówka[21].substring(3, 4));
        literka85.setText(Słówka[23].substring(3, 4));
        literka86.setText(Słówka[24].substring(2, 3));
        literka87.setText(Słówka[25].substring(1, 2));
        literka88.setText(Słówka[25].substring(2, 3));
        literka89.setText(Słówka[25].substring(3, 4));
        literka90.setText(Słówka[7].substring(3, 4));
        literka91.setText(Słówka[8].substring(3, 4));
        literka92.setText(Słówka[21].substring(4, 5));
        literka93.setText(Słówka[23].substring(4, 5));
        literka94.setText(Słówka[24].substring(3, 4));
        literka95.setText(Słówka[26].substring(3, 4));
        literka96.setText(Słówka[10].substring(0, 1));
        literka97.setText(Słówka[7].substring(4, 5));
        literka98.setText(Słówka[10].substring(2, 3));
        literka99.setText(Słówka[8].substring(4, 5));
        literka100.setText(Słówka[10].substring(4, 5));
        literka101.setText(Słówka[10].substring(5, 6));
        literka102.setText(Słówka[10].substring(6, 7));
        literka135.setText(Słówka[10].substring(7, 8));
        literka136.setText(Słówka[10].substring(8, 9));
        literka137.setText(Słówka[10].substring(9, 10));
        literka138.setText(Słówka[10].substring(10, 11));
        literka139.setText(Słówka[10].substring(11, 12));
        literka140.setText(Słówka[10].substring(12, 13));
        literka103.setText(Słówka[11].substring(1, 2));
        literka104.setText(Słówka[12].substring(1, 2));
        literka105.setText(Słówka[14].substring(1, 2));
        literka106.setText(Słówka[17].substring(1, 2));
        literka107.setText(Słówka[11].substring(2, 3));
        literka108.setText(Słówka[13].substring(1, 2));
        literka109.setText(Słówka[12].substring(2, 3));
        literka110.setText(Słówka[13].substring(3, 4));
        literka111.setText(Słówka[13].substring(4, 5));
        literka112.setText(Słówka[17].substring(2, 3));
        literka113.setText(Słówka[11].substring(3, 4));
        literka114.setText(Słówka[12].substring(3, 4));
        literka115.setText(Słówka[14].substring(3, 4));
        literka116.setText(Słówka[18].substring(1, 2));
        literka117.setText(Słówka[17].substring(3, 4));
        literka118.setText(Słówka[11].substring(4, 5));
        literka119.setText(Słówka[15].substring(1, 2));
        literka120.setText(Słówka[12].substring(4, 5));
        literka121.setText(Słówka[15].substring(3, 4));
        literka122.setText(Słówka[14].substring(4, 5));
        literka123.setText(Słówka[17].substring(4, 5));
        literka124.setText(Słówka[11].substring(5, 6));
        literka125.setText(Słówka[12].substring(5, 6));
        literka126.setText(Słówka[14].substring(5, 6));
        literka127.setText(Słówka[19].substring(1, 2));
        literka128.setText(Słówka[17].substring(5, 6));
        literka129.setText(Słówka[11].substring(6, 7));
        literka130.setText(Słówka[16].substring(1, 2));
        literka131.setText(Słówka[12].substring(6, 7));
        literka132.setText(Słówka[16].substring(3, 4));
        literka133.setText(Słówka[14].substring(6, 7));
        literka134.setText(Słówka[17].substring(6, 7));
    }
    public void actionPerformed(ActionEvent e) {
        Object źródło = e.getSource();
        if (źródło == bStart) {
            setWordNumberLabel();
            bStart.setEnabled(false);
            Rysowanie();

            lWIadomosc1.setText("Włącz przycisk");
            lWIadomosc2.setText("---Uzupełnianie Krzyzówki ---");
            lWIadomosc3.setText("by program rozpoczął rozwiazywanie Krzyżówki");

            bCalosc.setEnabled(true);
        } else if (źródło == bWyjście) {
            ukladanieKrzyzowki.stop();
            ukladanieKrzyzowki2.stop();
            this.dispose();
            MenuKrzyzowka okienkoMenu = new MenuKrzyzowka();
            okienkoMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okienkoMenu.setLocationRelativeTo(null);
            okienkoMenu.setUndecorated(true);
            okienkoMenu.setVisible(true);
        } else if (źródło == bCalosc) {
//            ukladanieKrzyzowki.start();
            ukladanieKrzyzowki2.start();
        } else if(źródło == bOdswiez) {
            fillLetters();
        }
    }
}

