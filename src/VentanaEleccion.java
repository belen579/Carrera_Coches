import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;



public class VentanaEleccion extends JDialog  implements ActionListener {


    JPanel[] panels = new JPanel[4];

    private ButtonGroup buttonGroup;

    int corredor = 0;


    boolean corredorescambiados = false;

    String[] rutas = new String[]{
            new File("src\\resources\\coche.png").getAbsolutePath(),
            new File("src\\resources\\moto.png").getAbsolutePath(),
            new File("src\\resources\\mario.jpg").getAbsolutePath(),
            new File("src\\resources\\camion.png").getAbsolutePath(),
    };


    ImageIcon[] imageIcons = new ImageIcon[4];

    JLabel[] labels = new JLabel[4];

    JButton añadir;

    JRadioButton cocheRadioButton;
    JRadioButton motoRadioButton;
    JRadioButton camionRadioButton;
    JRadioButton Cocheaveriado;


    int variableopcion;
    int random;


    Coche cocheseleccionado;





    VentanaEleccion ventanaEleccion;

    AppCoche appCoche;

    public VentanaEleccion() {
    }

    public VentanaEleccion(AppCoche appCoche) throws MalformedURLException {


        this.appCoche = appCoche;
        this.ventanaEleccion = this;

        buttonGroup = new ButtonGroup();

        cocheRadioButton = new JRadioButton("Coche");
        motoRadioButton = new JRadioButton("Moto");
        camionRadioButton = new JRadioButton("Super Mario");
        Cocheaveriado = new JRadioButton("Coche averiado");

        buttonGroup.add(cocheRadioButton);
        buttonGroup.add(motoRadioButton);
        buttonGroup.add(camionRadioButton);
        buttonGroup.add(Cocheaveriado);


        setLayout(new GridLayout(5, 1));

        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            panels[i].setLayout(new GridLayout(1, 2));
            imageIcons[i] = new ImageIcon();
            imageIcons[i].setImage(new ImageIcon(rutas[i]).getImage().getScaledInstance(140, 100, Image.SCALE_DEFAULT));


            labels[i] = new JLabel(imageIcons[i]);

            panels[i].add(labels[i]);


            add(panels[i]);


        }

        panels[0].add(cocheRadioButton);
        panels[1].add(motoRadioButton);
        panels[2].add(camionRadioButton);
        panels[3].add(Cocheaveriado);


        añadir = new JButton("Añadir al corredor");
        añadir.setPreferredSize(new Dimension(100, 100));
        añadir.addActionListener(this);


        add(añadir);


    }


    @Override
    public void actionPerformed(ActionEvent e) {





        if (e.getSource() == añadir) {

            System.out.println("Entro en añadir");

            if (ventanaEleccion.cocheRadioButton.isSelected()) {
                System.out.println("coche  " + 1 + rutas[0]);
                appCoche.coche[corredor].setImageUrl(rutas[0]);
                appCoche.coche[corredor].repaint();
            } else if (ventanaEleccion.motoRadioButton.isSelected()) {
                appCoche.coche[corredor].setImageUrl(rutas[1]);
                appCoche.coche[corredor].repaint();
            } else if (ventanaEleccion.camionRadioButton.isSelected()) {
                appCoche.coche[corredor].setImageUrl(rutas[2]);
                appCoche.coche[corredor].repaint();
            } else if (ventanaEleccion.Cocheaveriado.isSelected()) {
                appCoche.coche[corredor].setImageUrl(rutas[3]);
                appCoche.coche[corredor].repaint();
            } else {
                appCoche.coche[corredor].setImageUrl(rutas[4]);
                appCoche.coche[corredor].repaint();
            }

            corredor++;

            if(corredor==3){
                corredorescambiados= true;
                ventanaEleccion.dispose();
            }


        }

    }
}




