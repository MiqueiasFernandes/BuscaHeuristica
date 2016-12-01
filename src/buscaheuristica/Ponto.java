/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaheuristica;

import javax.swing.JLabel;

/**
 *
 * @author Miquéias Fernandes
 */
public class Ponto implements java.lang.Comparable {

    public int x;
    public int y;
    public JLabel label;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Ponto(int x, int y, JLabel label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    @Override
    public int compareTo(Object o) {
        Ponto a = (Ponto) o;

        int xComp = Integer.compare(a.x, x);
        if (xComp == 0) {
            return Integer.compare(a.y, y);
        } else {
            return xComp;
        }

    }

    @Override
    public String toString() {
        return "Ponto{" + "x=" + x + ", y=" + y + '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

}
