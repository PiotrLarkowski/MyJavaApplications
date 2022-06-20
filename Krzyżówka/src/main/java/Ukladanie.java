import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ukladanie extends Thread implements Runnable {

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
//        Thread Thread1 = new Thread();
            for (int i = 0; ; i++) {
                if (sec < 10) {
                    KrzyzowkaRysowanie.lWIadomosc2.setText("Czas wykonywania: " + hour + ":" + min + ":0" + sec);
                } else {
                    KrzyzowkaRysowanie.lWIadomosc2.setText("Czas wykonywania: " + hour + ":" + min + ":" + sec);
                }
                KrzyzowkaRysowanie.lWIadomosc3.setText("                           Próba numer: " + NumerWykonania);

                try {
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
            for (int i = 0; i < 6; i++) {
                restart = false;
                wordVariable = wordsVariable.fullListOfWords.get(KrzyzowkaRysowanie.mainOrderFindingTheWords[i]);//Numer nastepnego slowa do wyszukiwania
                if (wordVariable.get(0) == 13) { // Sprawdzanie dluygosci poszukwianego slowa musi ono pasowac do listaListSlow posiadajaca posegregowane slowa po dlugosci
                    lengthOfLookingWord = 5;
                } else {
                    lengthOfLookingWord = wordVariable.get(0) - 3;
                }
                myLookingWordLength = lengthOfLookingWord;
                wybraneSlowo = listaListSlow[lengthOfLookingWord].get(rand.nextInt(listaListSlow[lengthOfLookingWord].size()));//Losowanie slowa pasujacego
                for (int j = 0; j < wordVariable.get(1); j++) { // Petla przez ilosc slow pasujacych do naszego slowa
                    if(restart){ // Jezeli nie znaleziono dopasowaia kasujemy wszystkie wybrane slowa i przerywamy
                        for (int k = 0; k < wybraneSlowaDoKrzyzowki.length; k++) {
                            wybraneSlowaDoKrzyzowki[k]=null;
                        }
                        break;
                    }
                    lengthOfLookingWord = j + 2 + (j * 3);//2, 6, 10 dlugosc slow jakie musza pasowac do wybranego slowa
                    int numberOfChoiceWords = wordsVariable.fullListOfWords.get(i).get(lengthOfLookingWord)-1;//Pobieranie numeru slowa jakie musi pasowac do naszego
                    if (wybraneSlowaDoKrzyzowki[numberOfChoiceWords] == null) {// Sprawdzanie czy powyzsze slowo zostalo juz wlosowane
                        wordPassTest = true; // Jezeli nie to wylosowane slowo pasuje do krzyzowki
                    } else {
                        do {//Jezeli tak to sprawdzamy czy rozpatrywane slowo pasuje iterami do juz wylosowanych
                            if (wybraneSlowaDoKrzyzowki[numberOfChoiceWords].charAt(wordsVariable.fullListOfWords.get(i).get(5+(j*4))) == wybraneSlowo.charAt(wordsVariable.fullListOfWords.get(i).get(4+(j*4)))) {
                                wordPassTest = true;// Jezeli pasuje to ustawiamy ze slowo pasuje
                                KrzyzowkaRysowanie.taPoleSlow.setText(KrzyzowkaRysowanie.taPoleSlow.getText() + "Słowo ["+i+"] - " + wybraneSlowo + " znaleziono w " + hour + ":" + min + ":0" + sec + "\n");
                                wybraneSlowaDoKrzyzowki[i]=wybraneSlowo;
                            }else{
                                j=0;
                                listaListSlow[myLookingWordLength].remove(wybraneSlowo);//Jezeli nie pasuje to usuwamy slowo by nie zostalo wylosowane ponownie
                                if(listaListSlow[myLookingWordLength].size()==0){ //Jezeli usunelismy juz wszystkie slowa to oznacza ze nie ma dopasowania
//                                    JOptionPane.showMessageDialog(null,"Nie znaleziono dopasowania!");
                                    KrzyzowkaRysowanie.taPoleSlow.setText("");//Zerujemy ilosc wylosowanych slow
                                    i = -1;
                                    j = 0;
                                    restart = true;
                                    NumerWykonania++;
                                    UzupelnianieDlugosciSLow(listaWszystkichSlow);
                                    KrzyzowkaRysowanie.lWIadomosc3.setText("                           Próba numer: " + NumerWykonania);
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
                    KrzyzowkaRysowanie.taPoleSlow.setText(KrzyzowkaRysowanie.taPoleSlow.getText() + "Słowo ["+i+"] - " + wybraneSlowo + " znaleziono w " + hour + ":" + min + ":0" + sec + "\n");
                    wybraneSlowaDoKrzyzowki[i]=wybraneSlowo;
                }
                isWordAdded = false;
            }
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
        word5.addAll(new ArrayList<>(Arrays.asList(5, 3, 1, 7, 1, 5, 4, 7, 3, 5, 6, 6, 5, 5)));
        fullListOfWords.add(word5);
        ArrayList<Integer> word6 = new ArrayList<>();
        word6.addAll(new ArrayList<>(Arrays.asList(6, 3, 2, 5, 1, 5, 3, 5, 3, 5, 5, 5, 5, 5)));
        fullListOfWords.add(word6);
        // --------------------------------------------------------------
        ArrayList<Integer> word7 = new ArrayList<>();
        fullListOfWords.add(word7);
        ArrayList<Integer> word8 = new ArrayList<>();
        fullListOfWords.add(word8);
        ArrayList<Integer> word9 = new ArrayList<>();
        fullListOfWords.add(word9);
        ArrayList<Integer> word10 = new ArrayList<>();
        fullListOfWords.add(word10);
        // --------------------------------------------------------------
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        // --------------------------------------------------------------
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        // --------------------------------------------------------------
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
        fullListOfWords.add(new ArrayList<Integer>());
    }
}
