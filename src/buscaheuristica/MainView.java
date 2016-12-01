/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaheuristica;

import static buscaheuristica.BuscaHeuristica.heuristica1;
import static buscaheuristica.BuscaHeuristica.heuristica2;
import static buscaheuristica.BuscaHeuristica.heuristica3;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Miquéias Fernandes
 */
public class MainView extends javax.swing.JFrame {

    ArrayList<Ponto> pontos = new ArrayList();
    String mapas[];
    String mapa;
    ButtonGroup buttonGroup1;

    /**
     * Creates new form NewJFrame
     */
    public MainView(String[] mapas) {
        initComponents();
        this.mapas = mapas;
        this.mapa = mapas[0];

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup1.add(jRadioButtonMenuItem1);
        buttonGroup1.add(jRadioButtonMenuItem2);
        buttonGroup1.add(jRadioButtonMenuItem3);
        buttonGroup1.add(jRadioButtonMenuItem4);

        jRadioButtonMenuItem1.setMnemonic(0);
        jRadioButtonMenuItem2.setMnemonic(10);
        jRadioButtonMenuItem3.setMnemonic(80);
        jRadioButtonMenuItem4.setMnemonic(250);

        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 28; j++) {

                JLabel lb = new JLabel((i + 1) + "-" + (j + 1));
                lb.setOpaque(true);
                lb.setBackground(Color.white);
                getContentPane().add(lb);
                lb.setFont(new Font("Arial", 0, 8));
                lb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                lb.setBounds(i * 22, j * 22, 22, 22);
                pack();
                pontos.add(new Ponto(i, j, lb));
                lb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.

                        if (mouseDown && jCheckBoxMenuItem1.isSelected()) {

                            if (lb.getBackground() != Color.white) {
                                lb.setBackground(Color.white);
                            } else if (e.isControlDown()) {
                                for (Ponto ponto : pontos) {
                                    if (ponto.getLabel().getBackground() == Color.red) {
                                        ponto.label.setBackground(Color.WHITE);
                                    }
                                }
                                lb.setBackground(Color.red);
                            } else if (e.isShiftDown()) {
                                for (Ponto ponto : pontos) {
                                    if (ponto.getLabel().getBackground() == Color.green) {
                                        ponto.label.setBackground(Color.WHITE);
                                    }
                                }
                                lb.setBackground(Color.green);
                            } else {
                                lb.setBackground(Color.black);
                            }
                        }

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
                        mouseDown = true;
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        super.mouseReleased(e); //To change body of generated methods, choose Tools | Templates.
                        mouseDown = false;
                    }
                });
            }
        }

        setSize(22 * 28 + 16, 22 * 28 + 60);
    }

    boolean mouseDown = false;

    String[] mapaCs;

    void setPonitMapa(int x, int y) {
        //   mapaCs[y].charAt(x) =  mapaCs[y].charAt(x) == '0' ? '1' : '0';
    }

    public int getTime() {
        return buttonGroup1.getSelection().getMnemonic();
    }

    public String getMapa() {
        return mapa;
    }

    public void colorePonto(Ponto p, int tipo) {

        if ((p.compareTo(BuscaHeuristica.getEntrada(BuscaHeuristica.getmapa(mapa))) == 0
                || p.compareTo(BuscaHeuristica.getSaida(BuscaHeuristica.getmapa(mapa))) == 0)
                && tipo > 3) {
            return;
        }

        for (Ponto ponto : pontos) {
            if (ponto.compareTo(p) == 0) {
                JLabel label = ponto.label;

                switch (tipo) {
                    case 0:
                        label.setBackground(Color.gray);
                        break;
                    case 1:
                        label.setBackground(Color.lightGray);
                        break;
                    case 2:
                        label.setBackground(Color.red);
                        break;
                    case 3:
                        label.setBackground(Color.green);
                        break;
                    case 4:
                        label.setBackground(Color.yellow);
                        break;
                    case 5:
                        label.setBackground(Color.white);
                        break;
                    case 6:
                        label.setBackground(Color.blue);
                        break;
                    case 7:
                        label.setBackground(Color.orange);
                        break;
                    case 8:
                        label.setBackground(Color.MAGENTA);
                        break;
                    case 9:
                        label.setBackground(Color.pink);
                        break;
                    case 10:
                        label.setBackground(Color.blue);
                        break;
                    case 11:
                        label.setBackground(Color.cyan);
                        break;
                }
            }
        }
    }

    void atualizaMapa() {
        BuscaHeuristica.limpamapa();
        BuscaHeuristica.preparaMapa(mapa);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem4 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu3.setText("Executar");

        jMenu4.setText("Tempo");

        jRadioButtonMenuItem1.setText("0 ms");
        jMenu4.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem2.setText("10 ms");
        jMenu4.add(jRadioButtonMenuItem2);

        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem3.setText("80 ms");
        jMenu4.add(jRadioButtonMenuItem3);

        jRadioButtonMenuItem4.setText("250 ms");
        jMenu4.add(jRadioButtonMenuItem4);

        jMenu3.add(jMenu4);

        jMenuItem7.setText("Comparar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Pausar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Parar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Limpar mapa");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Heuristicas");

        jMenuItem1.setText("Propagação");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Horizontal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Vertical");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("compare Propagação");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("compare Vertical");
        jMenu1.add(jCheckBoxMenuItem3);

        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("comapare Horizontal");
        jMenu1.add(jCheckBoxMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Mapas");

        jMenuItem4.setText("Mapa 1");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem6.setText("Mapa 2");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem5.setText("Mapa 3");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jCheckBoxMenuItem1.setText("Editar");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // propagação

        rodarH1();


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // mapa1
        mapa = mapas[0];
        atualizaMapa();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        //mapa2
        mapa = mapas[1];
        atualizaMapa();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        //mapa 3
        mapa = mapas[2];
        atualizaMapa();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // comparar

        boolean r = false;

        if (jCheckBoxMenuItem2.isSelected()) {
            rodarH1();
            r = true;
        }
        if (jCheckBoxMenuItem3.isSelected()) {
            rodarH2();
            r = true;
        }
        if (jCheckBoxMenuItem4.isSelected()) {
            rodarH3();
            r = true;
        }

        if (!r) {
            JOptionPane.showMessageDialog(rootPane, "Selecione pelomenos uma opção no menu HEURISTICAS");
        }


    }//GEN-LAST:event_jMenuItem7ActionPerformed

    void rodarH1() {
        if (mapa == null) {
            return;
        }
        BuscaHeuristica.sair = BuscaHeuristica.pause = false;

        long ini = System.currentTimeMillis();

        new Thread(() -> {
            BuscaHeuristica.c1 = 0;
            String mapa2 = mapa;
            Ponto p = heuristica1(BuscaHeuristica.getmapa(mapa2),
                    BuscaHeuristica.getEntrada(BuscaHeuristica.getmapa(mapa2)),
                    new TreeSet<Ponto>(), 7);

            if (p != null && p.compareTo(BuscaHeuristica.getSaida(BuscaHeuristica.getmapa(mapa2))) == 0) {

                mapa2 = mapa2.replace("E", "Y").replace("X", "Z").replace("Y", "X").replace("Z", "E");

                p = heuristica1(BuscaHeuristica.getmapa(mapa2),
                        BuscaHeuristica.getEntrada(BuscaHeuristica.getmapa(mapa2)),
                        new TreeSet<Ponto>(), 4);

                if (p == null || p.compareTo(BuscaHeuristica.getSaida(BuscaHeuristica.getmapa(mapa2))) != 0) {
                    JOptionPane.showMessageDialog(rootPane, "terminou heuristica propagação sem encontrar o destino");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "terminou heuristica propagação com " + BuscaHeuristica.c1
                            + " comparações! em " + (System.currentTimeMillis() - ini) + " ms");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "terminou heuristica propagação sem encontrar o destino");
            }
        }).start();
    }

    void rodarH2() {
        if (mapa == null) {
            return;
        }
        long ini = System.currentTimeMillis();
        BuscaHeuristica.sair = BuscaHeuristica.pause = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                BuscaHeuristica.c2 = 0;
                String mapa2 = mapa;
                Ponto p = heuristica2(BuscaHeuristica.getmapa(mapa2),
                        BuscaHeuristica.getEntrada(BuscaHeuristica.getmapa(mapa2)),
                        new TreeSet<Ponto>(), 8);

                if (p != null && p.compareTo(BuscaHeuristica.getSaida(BuscaHeuristica.getmapa(mapa2))) == 0) {

                    mapa2 = mapa2.replace("E", "Y").replace("X", "Z").replace("Y", "X").replace("Z", "E");

                    p = heuristica2(BuscaHeuristica.getmapa(mapa2),
                            BuscaHeuristica.getEntrada(BuscaHeuristica.getmapa(mapa2)),
                            new TreeSet<Ponto>(), 9);

                    if (p == null || p.compareTo(BuscaHeuristica.getSaida(BuscaHeuristica.getmapa(mapa2))) != 0) {
                        JOptionPane.showMessageDialog(rootPane, "terminou heuristica horizontal sem encontrar o destino");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "terminou heuristica horizontal com " + BuscaHeuristica.c2
                                + " comparações! em " + (System.currentTimeMillis() - ini) + " ms");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "terminou heuristica horizontal sem encontrar o destino");
                }
            }
        }).start();
    }

    void rodarH3() {
        if (mapa == null) {
            return;
        }
        long ini = System.currentTimeMillis();
        BuscaHeuristica.sair = BuscaHeuristica.pause = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                BuscaHeuristica.c3 = 0;
                String mapa2 = mapa;
                Ponto p = heuristica3(BuscaHeuristica.getmapa(mapa2),
                        BuscaHeuristica.getEntrada(BuscaHeuristica.getmapa(mapa2)),
                        new TreeSet<Ponto>(), 10);

                if (p != null && p.compareTo(BuscaHeuristica.getSaida(BuscaHeuristica.getmapa(mapa2))) == 0) {

                    mapa2 = mapa2.replace("E", "Y").replace("X", "Z").replace("Y", "X").replace("Z", "E");

                    p = heuristica3(BuscaHeuristica.getmapa(mapa2),
                            BuscaHeuristica.getEntrada(BuscaHeuristica.getmapa(mapa2)),
                            new TreeSet<Ponto>(), 11);

                    if (p == null || p.compareTo(BuscaHeuristica.getSaida(BuscaHeuristica.getmapa(mapa2))) != 0) {
                        JOptionPane.showMessageDialog(rootPane, "terminou heuristica vertical sem encontrar o destino");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "terminou heuristica vertical com " + BuscaHeuristica.c3
                                + " comparações! em " + (System.currentTimeMillis() - ini) + " ms");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "terminou heuristica vertical sem encontrar o destino");
                }
            }
        }).start();
    }


    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // horizontal
        rodarH2();

    }//GEN-LAST:event_jMenuItem2ActionPerformed


    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // vertical
        rodarH3();

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        //editar
        if (jCheckBoxMenuItem1.isSelected()) {
            BuscaHeuristica.limpamapa();

            JOptionPane.showMessageDialog(rootPane, "Instruções:\n"
                    + "1) desenhhe clicando com o mouse\n"
                    + "2) clique novamente sob um pintado para apagar\n"
                    + "3) segure CTRL para marcar o início\n"
                    + "4) segure SHIFT para marcar o fim\n"
                    + "5) desmarque o checkbox MENU>EDITAR para salvar.");
            mapa = null;
        } else {

            StringBuilder sb = new StringBuilder();

            for (int y = 0; y < 28; y++) {

                for (int x = 0; x < 28; x++) {
                    for (Ponto ponto : pontos) {
                        if (ponto.x == x && ponto.y == y) {
                            if (ponto.getLabel().getBackground() == Color.black) {
                                sb.append("0");
                            }
                            if (ponto.getLabel().getBackground() == Color.white) {
                                sb.append("1");
                            }
                            if (ponto.getLabel().getBackground() == Color.red) {
                                sb.append("E");
                            }
                            if (ponto.getLabel().getBackground() == Color.green) {
                                sb.append("X");
                            }
                        }
                    }
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
            mapa = sb.toString();

            if (!mapa.contains("X") || !mapa.contains("E")) {
                JOptionPane.showMessageDialog(rootPane, "A entrada e OBJETIVO devem ser informados");
                jCheckBoxMenuItem1.setSelected(true);
            } else {
                atualizaMapa();
            }
        }


    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed


    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        BuscaHeuristica.sair = true;
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // pause
        BuscaHeuristica.pause = BuscaHeuristica.pause != true;
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        atualizaMapa();
    }//GEN-LAST:event_jMenuItem10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem4;
    // End of variables declaration//GEN-END:variables
}
