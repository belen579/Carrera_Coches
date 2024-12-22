import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

public class AppCoche extends JFrame implements ActionListener {


    Coche[] coche = new Coche[3];

    JPanel panelcentral;




    String[] rutas = new String[]{
            new File("src\\resources\\coche.png").getAbsolutePath(),
            new File("src\\resources\\coche.png").getAbsolutePath(),
            new File("src\\resources\\coche.png").getAbsolutePath()
    };

    ImageIcon icono = new ImageIcon("src\\resources\\copa.jpg");



    JButton start;

   Coche coches;

    int opcion;
    JButton eleccion;
    JPanel panel3;
    JPanel panel4;

    int x = 0;

    JButton stop;

    JButton reiniciar;

    boolean   finalcarrera= false;


    JButton comprobarganador;
    int random;
    int random2;
    int random3;





    VentanaEleccion ventanaEleccion;

    AppCoche(VentanaEleccion ventanaEleccion) throws MalformedURLException {
        this.ventanaEleccion = new VentanaEleccion(this);

        setLayout(new GridLayout(4, 1));

        ImageIcon iconoBandera = new ImageIcon("bandera.png");
        ImageIcon backgroundImage = new ImageIcon(new File("src\\resources\\marcas.jpg").getAbsolutePath());

        ImageIcon backgroundImage2 = new ImageIcon(new File("src\\resources\\ilustracion.jpeg").getAbsolutePath());


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 7));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setPreferredSize(new Dimension(50, 50));
        start = new JButton("Start Racing ", iconoBandera);
        JLabel backgroundLabel2 = new JLabel(backgroundImage2);
        backgroundLabel2.setPreferredSize(new Dimension(50, 50));
        eleccion = new JButton("Choose Racer");
        eleccion.setFont(new Font("Arial", Font.BOLD, 26));

        comprobarganador = new JButton("Ver Ganador");




        comprobarganador.setFont(new Font("Arial", Font.BOLD, 26));
        buttonPanel.add(comprobarganador);
        buttonPanel.add(eleccion);
        buttonPanel.add(backgroundLabel2);
        eleccion.addActionListener(this);
        start.setEnabled(false);
        stop = new JButton("Stop");
        buttonPanel.add(stop);
        stop.setFont(new Font("Arial", Font.BOLD, 36));
        stop.setEnabled(false);
        reiniciar = new JButton("Reiniciar");
        reiniciar.setFont(new Font("Arial", Font.BOLD, 36));




        Color colorOriginal = start.getBackground();
        start.setFont(new Font("Arial", Font.BOLD, 36));
        buttonPanel.add(backgroundLabel, BorderLayout.CENTER);
        start.setPreferredSize(new Dimension(300, 30));
        buttonPanel.add(start);
        stop.addActionListener(this);

        buttonPanel.add(reiniciar);
        reiniciar.addActionListener(this);
        reiniciar.setEnabled(false);


        start.addActionListener(this);
        comprobarganador.addActionListener(this);


        // Agregar el botón al panel

        add(buttonPanel); // Agregar el panel al contenedor principal


        panelcentral = new JPanel();

        panelcentral.setLayout(new GridLayout(1, 1));

        ImageIcon cocheIcon = new ImageIcon(new File("src\\resources\\banderas2.jpg").getAbsolutePath());
        Image cocheImage = cocheIcon.getImage();

         random = (int) (Math.random() * 9) + 1;
         random2 = (int) (Math.random() * 9) + 1;
         random3 = (int) (Math.random() * 9) + 1;


        coche[0] = new Coche(rutas[0], 1, 200, 200, random, 1, false);


        panelcentral.setBackground(Color.white);

        panelcentral.add(coche[0]);


        add(panelcentral);

        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 1));
        ImageIcon cocheIcon2 = new ImageIcon(new File("src\\resources\\banderas2.jpg").getAbsolutePath());
        Image cocheImage2 = cocheIcon2.getImage();


        coche[1] = new Coche(rutas[1], 1, 200, 200, random2, 2, false);

        panel3.add(coche[1]);
        add(panel3);


        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 1));
        ImageIcon cocheIcon3 = new ImageIcon(new File("src\\resources\\banderas2.jpg").getAbsolutePath());
        Image cocheImage3 = cocheIcon3.getImage();


        coche[2] = new Coche(rutas[2], 1, 200, 200, random3, 3, false);

        agregarListeners();
        panel4.add(coche[2]);


        add(panel4);


    }


    public void paint(Graphics g) {
        super.paint(g);

    }

    public void agregarListeners() {
        for (int i = 0; i < coche.length; i++) {
            coche[i].addPropertyChangeListener(new CochePropertyChangeListener(coche[i]));
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {


        if (eleccion == e.getSource()) {


            ventanaEleccion.setSize(400, 600);
            ventanaEleccion.setVisible(true);
            ventanaEleccion.setLocationRelativeTo(this);

            start.setEnabled(true);
            stop.setEnabled(true);
            reiniciar.setEnabled(true);


            System.out.println("Entro en el boton start");


        }

        if (start == e.getSource()) {

            random =(int) (Math.random() * 9) + 1;
            random2=(int) (Math.random() * 9) + 1;
            random3=(int) (Math.random() * 9) + 1;

            for (Coche c : coche) {
                c.x = 0;


                repaint();

            }


            start.setBackground(Color.yellow);
            String seleccion = JOptionPane.showInputDialog(null, "¿Quien cree que ganará, Escriba 1 ,2 ,3 en función del corredor ");


            opcion = Integer.parseInt(seleccion);


            if (opcion == 1) {
                JOptionPane.showMessageDialog(null, "Has elegido al corredor uno. ¡Buena suerte!");
            } else if (opcion == 2) {
                JOptionPane.showMessageDialog(null, "Has elegido al corredor dos. ¡Buena suerte!");
            } else if (opcion == 3) {
                JOptionPane.showMessageDialog(null, "Has elegido al corredor tres. ¡Buena suerte!");
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elige 1, 2 o 3.");
            }


            for (Coche c : coche) {
                c.setPuedecorrer(true);


            }


        }









        if(stop== e.getSource()){
            for (Coche c: coche){
                c.parar();
            }
        }


        if(reiniciar== e.getSource()){
            coche[0].setVelocidad(random);
            coche[1].setVelocidad(random2);
            coche[2].setVelocidad(random3);
            for (Coche c: coche){

                c.arrancar();

            }
        }

        if(comprobarganador== e.getSource()){
            comprobarganador();
        }


    }

    public void comprobarganador(){


            int velocidadmaxima = 0;
            int ganador = -1;
            for (int i = 0; i < coche.length; i++) {
                if (coche[i].getVelocidad() > velocidadmaxima) {
                    velocidadmaxima = coche[i].getVelocidad();

                    ganador = i + 1;


                }
            }


            if (ganador == opcion) {
                JOptionPane.showMessageDialog(null, "Enhorabuena. El corredor " + ganador + " ha ganado.");
            } else {
                JOptionPane.showMessageDialog(null, "Lo siento. El corredor " + ganador + " ha ganado. Vuelva a intentarlo");
            }


    }
}













            


























