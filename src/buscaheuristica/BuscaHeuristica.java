/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaheuristica;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Miquéias Fernandes
 */
public class BuscaHeuristica {

    ArrayList<String> mps = new ArrayList();

    static MainView mainView;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mainView = new MainView(new String[]{mapa1, mapa2, mapa3});
        mainView.setVisible(true);
        mainView.atualizaMapa();
    }

    static void limpamapa() {
        String[] mapa = getmapa(mapa1);
        for (int x = 0; x < mapa[0].length(); x++) {
            for (int y = 0; y < mapa.length; y++) {
                try {
                    pinta(x, y, 5);
                } catch (Exception e) {

                }
            }
        }
    }

    static void preparaMapa(String mapa) {
        pintamapa(mapa);
        mainView.colorePonto(getEntrada(getmapa(mapa)), 2);
        mainView.colorePonto(getSaida(getmapa(mapa)), 3);
    }

    static void pintamapa(String map) {
        String[] mapa = getmapa(map);
        for (int x = 0; x < mapa[0].length(); x++) {
            for (int y = 0; y < mapa.length; y++) {
                try {
                    pinta(x, y, Integer.parseInt("" + mapa[y].charAt(x)));
                } catch (Exception e) {

                }
            }
        }
    }

    static void pinta(int x, int y, int cor) {
        try {
            mainView.colorePonto(new Ponto(x, y), cor);
        } catch (Exception e) {

        }
    }

    static void pinta(Ponto p, int cor) {
        try {
            mainView.colorePonto(p, cor);
        } catch (Exception e) {

        }
    }

    public static int c1 = 0;
    public static int c2 = 0;
    public static int c3 = 0;

    public static boolean pause = false;
    public static boolean sair = false;

    //////////////////////////////////////HEURISTICA ONDAS NAGUA /////////////////////////
    static Ponto heuristica1(String[] mapa, Ponto partida, TreeSet<Ponto> passados, int cor) {
        System.out.println(">chamada H1 " + ++c1);

        if (sair) {
            return null;
        }

        while (pause) {
            if (sair) {
                return null;
            }
        }

        Ponto p;
        TreeSet<Ponto> opcoesAoRedor = getopcoesAoRedor(partida, mapa);

        pinta(partida, cor);
        for (Ponto ponto : opcoesAoRedor) {
            if (sair) {
                return null;
            }
            if (passados.contains(ponto)) {
                continue;
            }

            if (endgame(ponto, mapa)) {
                pinta(ponto, cor);
                return ponto;
            }

            passados.add(ponto);

            pinta(ponto, cor);

            try {
                Thread.sleep(mainView.getTime());
            } catch (InterruptedException ex) {

            }

            if ((p = heuristica1(mapa, ponto, passados, cor)) != null) {
                return p;
            }
        }
        return null;
    }

    static TreeSet<Ponto> getopcoesAoRedor(Ponto p, String[] mapa) {
        TreeSet<Ponto> ps = new TreeSet<>();
        int limX = mapa[0].length();
        int limY = mapa.length;
        int cont = 0;
        for (int i = p.x - 1; i <= p.x + 1; i++) {
            for (int j = p.y - 1; j <= p.y + 1; j++) {
                cont++;
                if (cont % 2 > 0) {
                    continue;
                }
                if (i >= 0 && j >= 0 && i < limX && j < limY && (mapa[j].charAt(i) == '1' || mapa[j].charAt(i) == 'X')) {
                    ps.add(new Ponto(i, j));
                }
            }
        }
        return ps;
    }

    /////////////////////////////////////HEURISTICA HORIZONTAL//////////////////////////////
    static Ponto heuristica2(String[] mapa, Ponto partida, TreeSet<Ponto> passados, int cor) {
        System.out.println(">chamada H2 " + ++c2);

        if (sair) {
            return null;
        }

        while (pause) {
            if (sair) {
                return null;
            }
        }

        if (partida == null) {
            return null;
        }

        if (passados.contains(partida)) {
            return null;
        }

        pinta(partida, cor);

        passados.add(partida);

        if (endgame(partida, mapa)) {
            return partida;
        }

        try {
            Thread.sleep(mainView.getTime());
        } catch (InterruptedException ex) {
        }

        Ponto p;

        TreeSet<Ponto> dcs = dolado(partida, mapa);

        for (Ponto dc : dcs) {
            if (sair) {
                return null;
            }
            pinta(dc, cor);
            passados.add(dc);
            try {
                Thread.sleep(mainView.getTime());
            } catch (InterruptedException ex) {
            }
            if (endgame(dc, mapa)) {
                return dc;
            }
        }

        for (Ponto dc : dcs) {
            if (sair) {
                return null;
            }
            if ((p = heuristica2(mapa, decima(dc, mapa), passados, cor)) != null) {
                return p;
            }
        }

        for (Ponto dc : dcs) {
            if (sair) {
                return null;
            }
            if ((p = heuristica2(mapa, debaixo(dc, mapa), passados, cor)) != null) {
                return p;
            }
        }
        return null;
    }

    static Ponto decima(Ponto p, String[] mapa) {
        if (p.y - 1 < 0) {
            return null;
        }

        if (mapa[p.y - 1].charAt(p.x) == '0') {
            return null;
        }

        return new Ponto(p.x, p.y - 1);
    }

    static Ponto debaixo(Ponto p, String[] mapa) {
        if (p.y + 1 >= mapa.length) {
            return null;
        }
        if (mapa[p.y + 1].charAt(p.x) == '0') {
            return null;
        }
        return new Ponto(p.x, p.y + 1);
    }

    static TreeSet<Ponto> dolado(Ponto p, String[] mapa) {
        TreeSet<Ponto> pontos = new TreeSet<>();

        for (int x = p.x; x < mapa[0].length(); x++) {
            if (mapa[p.y].charAt(x) == '0') {
                break;
            }
            pontos.add(new Ponto(x, p.y));
        }
        for (int x = p.x; x >= 0; x--) {
            if (mapa[p.y].charAt(x) == '0') {
                break;
            }
            pontos.add(new Ponto(x, p.y));
        }
        return pontos;
    }

    /////////////////////////////////////HEURISTICA VERTICAL //////////////////////////////
    static Ponto heuristica3(String[] mapa, Ponto partida, TreeSet<Ponto> passados, int cor) {
        System.out.println(">chamada H3 " + ++c3);

        if (sair) {
            return null;
        }

        while (pause) {
            if (sair) {
                return null;
            }
        }

        if (partida == null) {
            return null;
        }

        if (passados.contains(partida)) {
            return null;
        }

        pinta(partida, cor);

        passados.add(partida);

        if (endgame(partida, mapa)) {
            return partida;
        }

        try {
            Thread.sleep(mainView.getTime());
        } catch (InterruptedException ex) {
        }

        Ponto p;

        TreeSet<Ponto> dcs = aoLado(partida, mapa);

        for (Ponto dc : dcs) {
            if (sair) {
                return null;
            }
            pinta(dc, cor);
            passados.add(dc);
            try {
                Thread.sleep(mainView.getTime());
            } catch (InterruptedException ex) {
            }
            if (endgame(dc, mapa)) {
                return dc;
            }
        }

        for (Ponto dc : dcs) {
            if (sair) {
                return null;
            }
            if ((p = heuristica3(mapa, esquerdo(dc, mapa), passados, cor)) != null) {
                return p;
            }
        }

        for (Ponto dc : dcs) {
            if (sair) {
                return null;
            }
            if ((p = heuristica3(mapa, direito(dc, mapa), passados, cor)) != null) {
                return p;
            }
        }
        return null;
    }

    static Ponto esquerdo(Ponto p, String[] mapa) {
        if (p.x - 1 < 0) {
            return null;
        }

        if (mapa[p.y].charAt(p.x - 1) == '0') {
            return null;
        }

        return new Ponto(p.x - 1, p.y);
    }

    static Ponto direito(Ponto p, String[] mapa) {
        if (p.x + 1 < 0) {
            return null;
        }

        if (mapa[p.y].charAt(p.x + 1) == '0') {
            return null;
        }

        return new Ponto(p.x + 1, p.y);
    }

    static TreeSet<Ponto> aoLado(Ponto p, String[] mapa) {
        TreeSet<Ponto> pontos = new TreeSet<>();

        for (int y = p.y; y < mapa.length; y++) {
            if (mapa[y].charAt(p.x) == '0') {
                break;
            }
            pontos.add(new Ponto(p.x, y));
        }
        for (int y = p.y; y >= 0; y--) {
            if (mapa[y].charAt(p.x) == '0') {
                break;
            }
            pontos.add(new Ponto(p.x, y));
        }
        return pontos;
    }

    static boolean endgame(Ponto p, String[] mapa) {

        if (p == null) {
            return false;
        }

        if (p.x >= mapa[0].length() || p.y > mapa.length) {
            return false;
        }
        return mapa[p.y].charAt(p.x) == 'X';
    }

    static String[] getmapa(String mapa) {
        return mapa.split("\n");
    }

    static Ponto getEntrada(String[] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            if (mapa[i].contains("E")) {
                return new Ponto(mapa[i].indexOf("E"), i);
            }
        }
        return null;
    }

    static Ponto getSaida(String[] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            if (mapa[i].contains("X")) {
                return new Ponto(mapa[i].indexOf("X"), i);
            }
        }
        return null;
    }

    static String mapa1
            = "0000000000000000000000000000\n"
            + "0111000000000000000001110000\n"
            + "0111000000001110000001110000\n"
            + "0010000111111X10000001110000\n"
            + "0010000100001110000000100000\n"
            + "0011111100000000000000100000\n"
            + "0010000000000000000000100000\n"
            + "0010000000000000000111111100\n"
            + "0010000000011111000111111100\n"
            + "0011111100011111000111111100\n"
            + "0001000100011111000111111100\n"
            + "0001000100000100000000100000\n"
            + "0011100100000100000000100000\n"
            + "0011100100000100000011111000\n"
            + "0011100100000100000010001000\n"
            + "0000000111111111111110001000\n"
            + "0000000100000000000010001000\n"
            + "0000000100000000000010001000\n"
            + "0011100100111000001111001000\n"
            + "0011111111111000001111001000\n"
            + "0011100100111000001111001000\n"
            + "0000000100000000000000001000\n"
            + "0000000100000001111111111000\n"
            + "0000001111000001000000000000\n"
            + "0000001111000001000000000000\n"
            + "0000001111000111110000000000\n"
            + "000000000000011E110000000000\n"
            + "0000000000000000000000000000\n",
            mapa2
            = "0000000000000000000000000000\n"
            + "0011111000001110000000000000\n"
            + "0011111111001X10001111000000\n"
            + "0011111001001110000001000000\n"
            + "0000100001000100000001011110\n"
            + "0000100001111111111001111110\n"
            + "0000100000000100001000011110\n"
            + "0011111000000000001000011110\n"
            + "0011111111111111111000000100\n"
            + "0011111000000000000000000100\n"
            + "0000100000000011111111000100\n"
            + "0000100000000011111111000100\n"
            + "0000100111110011111111000100\n"
            + "0011111111111110001000000100\n"
            + "0000000111110000001000000100\n"
            + "0000100001000000111110000100\n"
            + "0000100001000000111111111100\n"
            + "0000100001111100111110000100\n"
            + "0011110001000100001000000100\n"
            + "0010010001000100001000000100\n"
            + "0010010011111111111111111100\n"
            + "0010000000000000001000010000\n"
            + "0011111100111111111111010000\n"
            + "0010011100100100001000010000\n"
            + "0010011100100100001001111100\n"
            + "0010011111101E10001111111100\n"
            + "0000000000001110000000000000\n"
            + "0000000000000000000000000000\n",
            mapa3
            = "0000000000000000000000000000\n"
            + "0000000000000000000000000000\n"
            + "0000000000000000000000000000\n"
            + "0001111111111111111111111000\n"
            + "0001000000000001000000001000\n"
            + "0001000000000001000000001000\n"
            + "0001001110111011101110001000\n"
            + "0001001111111011101110001000\n"
            + "0001001110111011101110001000\n"
            + "0001000000010001000100001000\n"
            + "0001001110010001000101101000\n"
            + "0001111111111111111111101000\n"
            + "0001001110010001000101101000\n"
            + "0001000100010001000100001000\n"
            + "0001001110111011101110001000\n"
            + "0001001110111111101110001000\n"
            + "0001001110111011101110001000\n"
            + "0001000100000001000000001000\n"
            + "0001001110000111110011101000\n"
            + "000100111000011X110011101000\n"
            + "0001000000000000000001001000\n"
            + "0001111111111111111111111000\n"
            + "0000001000000010000001000000\n"
            + "0000001000000010000001000000\n"
            + "0000111110001111100111110000\n"
            + "00001111100011E1100111110000\n"
            + "0000111110001111100111110000\n"
            + "0000000000000000000000000000";

}
