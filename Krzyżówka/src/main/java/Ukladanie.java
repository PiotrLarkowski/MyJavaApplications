import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ukladanie extends Thread implements Runnable {

    public static boolean koniec = false;
    Random rand = new Random();
    public static ArrayList<Integer> wordVariable;
    int[] wordsTab = new int[20];
    int numberOfThread;
    int NumerWykonania = 1;
    int hour = 0, min = 0, sec = 00;
    public static String[] wybraneSlowaDoKrzyzowki = new String[37];

    public static List<String> listaWszystkichSlow = new ArrayList<>();

    public static List<String> listaWszystkichSlow3 = new ArrayList<>();
    public static List<String> listaWszystkichSlow4 = new ArrayList<>();
    public static List<String> listaWszystkichSlow5 = new ArrayList<>();
    public static List<String> listaWszystkichSlow6 = new ArrayList<>();
    public static List<String> listaWszystkichSlow7 = new ArrayList<>();
    public static List<String> listaWszystkichSlow13 = new ArrayList<>();

    public static List<String>[] listaListSlow = (ArrayList<String>[]) new ArrayList[6];
//    public static List<String> listaWszystkichSlow = new ArrayList<>();

    public static void UzupelnianieDlugosciSLow(List<String> listaWszystkichSlow) {
        listaWszystkichSlow3 = new ArrayList<>();
        listaWszystkichSlow4 = new ArrayList<>();
        listaWszystkichSlow5 = new ArrayList<>();
        listaWszystkichSlow6 = new ArrayList<>();
        listaWszystkichSlow7 = new ArrayList<>();
        listaWszystkichSlow13 = new ArrayList<>();
        for (int i = 0; i < listaWszystkichSlow.size(); i++) {
            if (listaWszystkichSlow.get(i).length() == 3) {
                listaWszystkichSlow3.add(listaWszystkichSlow.get(i));
            } else if (listaWszystkichSlow.get(i).length() == 4) {
                listaWszystkichSlow4.add(listaWszystkichSlow.get(i));
            } else if (listaWszystkichSlow.get(i).length() == 5) {
                listaWszystkichSlow5.add(listaWszystkichSlow.get(i));
            } else if (listaWszystkichSlow.get(i).length() == 6) {
                listaWszystkichSlow6.add(listaWszystkichSlow.get(i));
            } else if (listaWszystkichSlow.get(i).length() == 7) {
                listaWszystkichSlow7.add(listaWszystkichSlow.get(i));
            } else if (listaWszystkichSlow.get(i).length() == 13) {
                listaWszystkichSlow13.add(listaWszystkichSlow.get(i));
            }
        }
        listaListSlow[0] = (listaWszystkichSlow3);
        listaListSlow[1] = (listaWszystkichSlow4);
        listaListSlow[2] = (listaWszystkichSlow5);
        listaListSlow[3] = (listaWszystkichSlow6);
        listaListSlow[4] = (listaWszystkichSlow7);
        listaListSlow[5] = (listaWszystkichSlow13);
    }

    public Ukladanie(List<String> listaSlow, int numberOfThread) {
        this.numberOfThread = numberOfThread;
        listaWszystkichSlow = listaSlow;
    }

    @Override
    public void run() {
        if (numberOfThread == 1) {
            KrzyzowkaRysowanie.lWIadomosc1.setText("");
        Thread Thread1 = new Thread();
            for (int i = 0; ; i++) {

                if (sec < 10) {
                    KrzyzowkaRysowanie.lWIadomosc2.setText("Czas wykonywania: " + hour + ":" + min + ":0" + sec);
                } else {
                    KrzyzowkaRysowanie.lWIadomosc2.setText("Czas wykonywania: " + hour + ":" + min + ":" + sec);
                }
                KrzyzowkaRysowanie.lWIadomosc3.setText("Rozpoczeto uzupelnianie krzyzowki");

                try {
                    if(koniec){
                        KrzyzowkaRysowanie.stopThread();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (sec == 59) {
                    sec = 00;
                    if (min == 59) {
                        min = 0;
                        hour++;
                    } else {
                        min++;
                    }
                } else {
                    sec++;
                }
            }
        } else if (numberOfThread == 2) {
            for (int i = 0; i < listaWszystkichSlow.size(); i++) {
                wordsTab[listaWszystkichSlow.get(i).length()]++;
            }
            POJOArrayList wordsVariable = new POJOArrayList();
            UzupelnianieDlugosciSLow(listaWszystkichSlow);
            String wybraneSlowo = "";
            int lengthOfLookingWord = 0;
            boolean wordPassTest = true;
            boolean restart;
            boolean isWordAdded = false;
            int myLookingWordLength = 0;
            for (int i = 0; i < 37; i++) {
                restart = false;
                wordVariable = wordsVariable.fullListOfWords.get(KrzyzowkaRysowanie.mainOrderFindingTheWords[i]);//Numer nastepnego slowa do wyszukiwania
                if (wordVariable.get(0) == 13) { // Sprawdzanie dluygosci poszukwianego slowa musi ono pasowac do listaListSlow posiadajaca posegregowane slowa po dlugosci
                    lengthOfLookingWord = 5;
                } else {
                    lengthOfLookingWord = wordVariable.get(0) - 3;
                }
                myLookingWordLength = lengthOfLookingWord;
                wybraneSlowo = listaListSlow[lengthOfLookingWord].get(rand.nextInt(listaListSlow[lengthOfLookingWord].size()));//Losowanie slowa pasujacego
//                if(i==31){
//                    wybraneSlowo = "DIALIZA";
//                }
                for (int j = 0; j < wordVariable.get(1); j++) { // Petla przez ilosc slow pasujacych do naszego slowa
                    if(restart){ // Jezeli nie znaleziono dopasowaia kasujemy wszystkie wybrane slowa i przerywamy
                        for (int k = 0; k < wybraneSlowaDoKrzyzowki.length; k++) {
                            wybraneSlowaDoKrzyzowki[k]=null;
                        }
//                        KrzyzowkaRysowanie.taPoleSlow.setText("");
                        break;
                    }
                    lengthOfLookingWord = j + 2 + (j * 3);//2, 6, 10 dlugosc slow jakie musza pasowac do wybranego slowa
                    int numberOfChoiceWords = wordsVariable.fullListOfWords.get(i).get(lengthOfLookingWord)-1;//Pobieranie numeru slowa jakie musi pasowac do naszego
                    if (wybraneSlowaDoKrzyzowki[numberOfChoiceWords] == null) {// Sprawdzanie czy powyzsze slowo zostalo juz wlosowane
                        wordPassTest = true; // Jezeli nie to wylosowane slowo pasuje do krzyzowki
                    } else {
                        do {//Jezeli tak to sprawdzamy czy rozpatrywane slowo pasuje iterami do juz wylosowanych
                            String word = wybraneSlowaDoKrzyzowki[numberOfChoiceWords];
                            int charat = wordsVariable.fullListOfWords.get(i).get(5+(j*4));
                            char a = word.charAt(charat);
                            char b = wybraneSlowo.charAt(wordsVariable.fullListOfWords.get(i).get(4+(j*4)));
                            if (a == b) {
                                wordPassTest = true;// Jezeli pasuje to ustawiamy ze slowo pasuje
//                                KrzyzowkaRysowanie.taPoleSlow.setText(KrzyzowkaRysowanie.taPoleSlow.getText() + "Słowo ["+i+"] - " + wybraneSlowo + " znaleziono w " + hour + ":" + min + ":0" + sec + "\n");
                                wybraneSlowaDoKrzyzowki[i]=wybraneSlowo;
                            }else{
                                j=-1;
                                listaListSlow[myLookingWordLength].remove(wybraneSlowo);//Jezeli nie pasuje to usuwamy slowo by nie zostalo wylosowane ponownie
                                if(listaListSlow[myLookingWordLength].size()==0){ //Jezeli usunelismy juz wszystkie slowa to oznacza ze nie ma dopasowania
//                                    JOptionPane.showMessageDialog(null,"Nie znaleziono dopasowania!");
//                                    KrzyzowkaRysowanie.taPoleSlow.setText("");//Zerujemy ilosc wylosowanych slow
                                    i = -1;
                                    j = -1;
                                    restart = true;
//                                    NumerWykonania++;
                                    UzupelnianieDlugosciSLow(listaWszystkichSlow);
//                                    KrzyzowkaRysowanie.lWIadomosc3.setText("                           Próba numer: " + NumerWykonania);
                                }
                                if(listaListSlow[myLookingWordLength].size()!=0) {
                                    wybraneSlowo = listaListSlow[myLookingWordLength].get(rand.nextInt(listaListSlow[myLookingWordLength].size()));
                                }
                                wordPassTest = true;
                                isWordAdded=true;
                            }
                        }while(wordPassTest == false);
                    }
                }
                if(wordPassTest && isWordAdded == false){//Wypisujeny w taPoleSlow wszystkie wybrane slowa
//                    KrzyzowkaRysowanie.taPoleSlow.setText(KrzyzowkaRysowanie.taPoleSlow.getText() + "Słowo ["+i+"] - " + wybraneSlowo + " znaleziono w " + hour + ":" + min + ":0" + sec + "\n");
                    wybraneSlowaDoKrzyzowki[i]=wybraneSlowo;
                }
                isWordAdded = false;
            }
            for (int i = 0; i < wybraneSlowaDoKrzyzowki.length; i++) {
                if(wybraneSlowaDoKrzyzowki[i]!=null) {
                    KrzyzowkaRysowanie.Słówka[i]=wybraneSlowaDoKrzyzowki[i];
                    KrzyzowkaRysowanie.taPoleSlow.setText(KrzyzowkaRysowanie.taPoleSlow.getText() + "Słowo [" + (i+1) + "] - " + wybraneSlowaDoKrzyzowki[i] + "\n");
                }
            }
            koniec = true;
        }
    }

}

class POJOArrayList {
    List<ArrayList<Integer>> fullListOfWords = new ArrayList();

    public POJOArrayList() {
        ArrayList<Integer> word1 = new ArrayList<>();

        word1.addAll(new ArrayList<>(Arrays.asList(
                7/*Dlugosc Slowa*/,
                4/*Ilosc słów pasujących*/,
                2/*Numer pierwszego slowa pasujacego*/,
                5/*Dlugosc pierwszego slowa pasujacego*/,
                0/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                0/*Pozycja litery w slowie pasujacym ktore musi pasowac*/,
                3/*Numer drugiego slowa pasujacego*/,
                5/*Dlugosc drugiego slowa pasujacego*/,
                2/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                0/*Pozycja litery w slowie pasujacym ktore musi pasowac*/,
                5/*Numer trzeciego slowa pasujacego*/,
                5/*Dlugosc trzeciego slowa pasujacego*/,
                4/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                0/*Pozycja litery w slowie pasujacym ktore musi pasowac*/,
                7/*Numer czwartego slowa pasujacego*/,
                4/*Dlugosc czwartego slowa pasujacego*/,
                6/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                0/*Pozycja litery w slowie pasujacym ktore musi pasowac*/)));
        fullListOfWords.add(word1);
        ArrayList<Integer> word2 = new ArrayList<>();
        word2.addAll(new ArrayList<>(Arrays.asList(
                5/*Dlugosc Slowa*/,
                3/*Ilosc słów pasujących*/,
                1/*Numer pierwszego slowa pasujacego*/,
                7/*Dlugosc pierwszego slowa pasujacego*/,
                0/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                0/*Pozycja litery w slowie pasujacym ktore musi pasowac*/,
                4/*Numer drugiego slowa pasujacego*/,
                7/*Dlugosc drugiego slowa pasujacego*/,
                2/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                0/*Pozycja litery w slowie pasujacym ktore musi pasowac*/,
                6/*Numer trzeciego slowa pasujacego*/,
                6/*Dlugosc drugiego slowa pasujacego*/,
                4/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                0/*Pozycja litery w slowie pasujacym ktore musi pasowac*/)));
        fullListOfWords.add(word2);
        ArrayList<Integer> word3 = new ArrayList<>();
        word3.addAll(new ArrayList<>(Arrays.asList(
                5/*Dlugosc Slowa*/,
                3/*Ilosc słów pasujących*/,
                1/*Numer pierwszego slowa pasujacego*/,
                7/*Dlugosc pierwszego slowa pasujacego*/,
                0/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                2/*Pozycja litery w slowie pasujacym ktore musi pasowac*/,
                4/*Numer drugiego slowa pasujacego*/,
                7/*Dlugosc drugiego slowa pasujacego*/,
                2/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                2/*Pozycja litery w slowie pasujacym ktore musi pasowac*/,
                6/*Numer trzeciego slowa pasujacego*/,
                6/*Dlugosc drugiego slowa pasujacego*/,
                4/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                2/*Pozycja litery w slowie pasujacym ktore musi pasowac*/)));
        fullListOfWords.add(word3);
        ArrayList<Integer> word4 = new ArrayList<>();
        word4.addAll(new ArrayList<>(Arrays.asList(
                7/*Dlugosc Slowa*/,
                4/*Ilosc słów pasujących*/,
                2/*Numer pierwszego slowa pasujacego*/,
                5/*Dlugosc pierwszego slowa pasujacego*/,
                0/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                2/*Pozycja litery w slowie pasujacym ktore musi pasowac*/,
                3/*Numer drugiego slowa pasujacego*/,
                5/*Dlugosc drugiego slowa pasujacego*/,
                2/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                2/*Pozycja litery w slowie pasujacym ktore musi pasowac*/,
                5/*Numer trzeciego slowa pasujacego*/,
                5/*Dlugosc trzeciego slowa pasujacego*/,
                4/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                2/*Pozycja litery w slowie pasujacym ktore musi pasowac*/,
                7/*Numer czwartego slowa pasujacego*/,
                4/*Dlugosc czwartego slowa pasujacego*/,
                6/*Pozycja litery w naszym slowie ktore musi pasowac*/,
                2/*Pozycja litery w slowie pasujacym ktore musi pasowac*/)));
        fullListOfWords.add(word4);
        ArrayList<Integer> word5 = new ArrayList<>();
        word5.addAll(new ArrayList<>(Arrays.asList(5, 3, 1, 7, 0, 4, 4, 7, 2, 4, 6, 6, 4, 4)));
        fullListOfWords.add(word5);
        ArrayList<Integer> word6 = new ArrayList<>();
        word6.addAll(new ArrayList<>(Arrays.asList(6, 3, 2, 5, 0, 4, 3, 5, 2, 4, 5, 5, 4, 4)));
        fullListOfWords.add(word6);
        // --------------------------------------------------------------
        ArrayList<Integer> word7 = new ArrayList<>();
        word7.addAll(new ArrayList<>(Arrays.asList(4, 4, 1, 7, 0, 6, 8, 5, 1, 0, 4, 7, 2, 6, 9, 5, 3, 0)));
        fullListOfWords.add(word7);
        ArrayList<Integer> word8 = new ArrayList<>();
        word8.addAll(new ArrayList<>(Arrays.asList(5, 3, 7, 4, 0, 1, 10, 4, 2, 1, 11, 13, 4, 1)));
        fullListOfWords.add(word8);
        ArrayList<Integer> word9 = new ArrayList<>();
        word9.addAll(new ArrayList<>(Arrays.asList(5, 4, 7, 4, 0, 3, 21, 7, 1, 0, 10, 4, 2, 3, 11, 13, 4, 3)));
        fullListOfWords.add(word9);
        ArrayList<Integer> word10 = new ArrayList<>();
        word10.addAll(new ArrayList<>(Arrays.asList(4, 2, 8, 5, 1, 2, 9, 5, 3, 2)));
        fullListOfWords.add(word10);
        // --------------------------------------------------------------
        ArrayList<Integer> word11 = new ArrayList<>();
        word11.addAll(new ArrayList<>(Arrays.asList(13, 10, 12, 7, 0, 0, 8, 5, 1, 4, 13, 7, 2, 0, 9, 5, 3, 4, 15, 7, 4, 0, 26, 6, 5, 5, 18, 7, 6, 0, 27, 6, 7, 5, 35, 5, 9, 4, 37, 5, 11, 4)));
        fullListOfWords.add(word11);
        ArrayList<Integer> word12 = new ArrayList<>();
        word12.addAll(new ArrayList<>(Arrays.asList(7, 4, 11, 13, 0, 0, 14, 5, 2, 0, 16, 5, 4, 0, 17, 5, 6, 0)));
        fullListOfWords.add(word12);
        ArrayList<Integer> word13 = new ArrayList<>();
        word13.addAll(new ArrayList<>(Arrays.asList(7, 4, 11, 13, 0, 2, 14, 5, 2, 2, 16, 5, 4, 2, 17, 5, 6, 2)));
        fullListOfWords.add(word13);
        ArrayList<Integer> word14 = new ArrayList<>();
        word14.addAll(new ArrayList<>(Arrays.asList(5, 3, 12, 7, 0, 2, 13, 7, 2, 2, 15, 7, 4, 2)));
        fullListOfWords.add(word14);
        ArrayList<Integer> word15 = new ArrayList<>();
        word15.addAll(new ArrayList<>(Arrays.asList(7, 6, 11, 13, 0, 4, 14, 5, 2, 4, 19, 3, 3, 0, 16, 5, 4, 4, 20, 3, 5, 0, 17, 5, 6, 4)));
        fullListOfWords.add(word15);
        ArrayList<Integer> word16 = new ArrayList<>();
        word16.addAll(new ArrayList<>(Arrays.asList(5, 3, 12, 7, 0, 4, 13, 7, 2, 4, 15, 7, 4, 4)));
        fullListOfWords.add(word16);
        ArrayList<Integer> word17 = new ArrayList<>();
        word17.addAll(new ArrayList<>(Arrays.asList(5, 3, 12, 7, 0, 6, 13, 7, 2, 6, 15, 7, 4, 6)));
        fullListOfWords.add(word17);
        ArrayList<Integer> word18 = new ArrayList<>();
        word18.addAll(new ArrayList<>(Arrays.asList(7, 3, 11, 13, 0, 6, 19, 3, 3, 2, 20, 3, 5, 2)));
        fullListOfWords.add(word18);
        ArrayList<Integer> word19 = new ArrayList<>();
        word19.addAll(new ArrayList<>(Arrays.asList(3, 2, 15, 7, 0, 3, 18, 7, 2, 3)));
        fullListOfWords.add(word19);
        ArrayList<Integer> word20 = new ArrayList<>();
        word20.addAll(new ArrayList<>(Arrays.asList(3, 2, 15, 7, 0, 5, 18, 7, 2, 5)));
        fullListOfWords.add(word20);
        // --------------------------------------------------------------
        ArrayList<Integer> word21 = new ArrayList<>();
        word21.addAll(new ArrayList<>(Arrays.asList(7, 4, 9, 5, 0, 1, 26, 6, 2, 2, 27, 6, 4, 2, 35, 5, 6, 1)));
        fullListOfWords.add(word21);
        ArrayList<Integer> word22 = new ArrayList<>();
        word22.addAll(new ArrayList<>(Arrays.asList(5, 3, 6, 6, 0, 1, 23, 6, 2, 1, 28, 6, 4, 1)));
        fullListOfWords.add(word22);
        ArrayList<Integer> word23 = new ArrayList<>();
        word23.addAll(new ArrayList<>(Arrays.asList(6, 3, 22, 5, 1, 2, 24, 5, 3, 2, 25, 5, 5, 2)));
        fullListOfWords.add(word23);
        ArrayList<Integer> word24 = new ArrayList<>();
        word24.addAll(new ArrayList<>(Arrays.asList(5, 3, 6, 6, 0, 3, 23, 6, 2, 3, 28, 6, 4, 3)));
        fullListOfWords.add(word24);
        ArrayList<Integer> word25 = new ArrayList<>();
        word25.addAll(new ArrayList<>(Arrays.asList(5, 5, 6, 0, 5, 26, 6, 1, 0, 23, 6, 2, 5, 27, 6, 3, 0, 28, 6, 4, 5)));
        fullListOfWords.add(word25);
        ArrayList<Integer> word26 = new ArrayList<>();
        word26.addAll(new ArrayList<>(Arrays.asList(6, 3, 25, 5, 0, 1, 21, 7, 2, 2, 11, 13, 5, 5)));
        fullListOfWords.add(word26);
        ArrayList<Integer> word27 = new ArrayList<>();
        word27.addAll(new ArrayList<>(Arrays.asList(6, 3, 25, 5, 0, 3, 21, 7, 2, 4, 11, 13, 5, 7)));
        fullListOfWords.add(word27);
        ArrayList<Integer> word28 = new ArrayList<>();
        word28.addAll(new ArrayList<>(Arrays.asList(6, 6, 29, 0, 0, 22, 5, 1, 4, 31, 5, 2, 0, 24, 5, 3, 4, 33, 5, 4, 0, 25, 5, 5, 4)));
        fullListOfWords.add(word28);
        ArrayList<Integer> word29 = new ArrayList<>();
        word29.addAll(new ArrayList<>(Arrays.asList(5, 3, 28, 6, 0, 0, 30, 7, 2, 0, 32, 7, 4, 0)));
        fullListOfWords.add(word29);
        // --------------------------------------------------------------
        ArrayList<Integer> word30 = new ArrayList<>();
        word30.addAll(new ArrayList<>(Arrays.asList(7, 4, 29, 5, 0, 2, 31, 5, 2, 2, 33, 5, 4, 2, 34, 4, 6, 1)));
        fullListOfWords.add(word30);
        ArrayList<Integer> word31 = new ArrayList<>();
        word31.addAll(new ArrayList<>(Arrays.asList(5, 3, 28, 6, 0, 2, 30, 7, 2, 2, 32, 7, 4, 2)));
        fullListOfWords.add(word31);
        ArrayList<Integer> word32 = new ArrayList<>();
        word32.addAll(new ArrayList<>(Arrays.asList(7, 4, 28, 5, 0, 4, 31, 5, 2, 4, 33, 5, 4, 4, 34, 4, 6, 3)));
        fullListOfWords.add(word32);
        ArrayList<Integer> word33 = new ArrayList<>();
        word33.addAll(new ArrayList<>(Arrays.asList(5, 3, 28, 6, 0, 4, 30, 7, 2, 4, 32, 7, 4, 4)));
        fullListOfWords.add(word33);
        ArrayList<Integer> word34 = new ArrayList<>();
        word34.addAll(new ArrayList<>(Arrays.asList(4, 4, 35, 5, 0, 0, 30, 7, 1, 6, 37, 5, 2, 0, 32, 7, 3, 6)));
        fullListOfWords.add(word34);
        ArrayList<Integer> word35 = new ArrayList<>();
        word35.addAll(new ArrayList<>(Arrays.asList(5, 4, 34, 4, 0, 0, 21, 7, 1, 6, 36, 4, 2, 0, 11, 13, 4, 9)));
        fullListOfWords.add(word35);
        ArrayList<Integer> word36 = new ArrayList<>();
        word36.addAll(new ArrayList<>(Arrays.asList(4, 2, 35, 5, 0, 2, 37, 5, 2, 2)));
        fullListOfWords.add(word36);
        ArrayList<Integer> word37 = new ArrayList<>();
        word37.addAll(new ArrayList<>(Arrays.asList(5, 3, 34, 4, 0, 2, 36, 4, 2, 2, 11, 13, 4, 11)));
        fullListOfWords.add(word37);
    }
}
