package juegoCraps;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    //atributos
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private Header titulo;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Escucha escucha;

    //metodos
    public GUI() {
        initGUI();

        //Configuracion base de la ventana
        this.setTitle("Mi Presentacion");
        this.setSize(600, 540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha = new Escucha();
        //Configurar JComponent
        titulo = new Header("Hola soy Fabian, oprime los botones para conocerme", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi...",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Calibri", Font.PLAIN, 20), Color.BLACK));

        this.add(panelDatos, BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addActionListener(escucha);
        miHobby = new JButton("Este es mi Hobby");
        miHobby.addActionListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addActionListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(10,  12);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI miGUIPresentacion = new GUI();
            }
        });
    }

    private class Escucha implements ActionListener {
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "Oprimiste boton");
            panelDatos.removeAll();
            if (e.getSource() == miFoto) {
                image = new ImageIcon(getClass().getResource("/recursos/Yo.png"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            } else {
                if (e.getSource() == miHobby) {
                    image = new ImageIcon(getClass().getResource("/recursos/Tocar guitarra.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);


                }else{
                    textoExpectativas.setText("Quiero aprender como funciona la programacion orientadada a objetos\n" +
                            "Quiero aprender mas de Java\n" +
                            "Quiero que mis conocimientos en la programacion sean mas amplios");
                    textoExpectativas.setBackground(Color.darkGray);
                    textoExpectativas.setForeground(Color.WHITE);
                    textoExpectativas.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 17));
                    panelDatos.add(textoExpectativas);

                }
            }
            revalidate();
            repaint();
        }
    }
}
