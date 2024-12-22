import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException {

        VentanaEleccion ventanaEleccion = new VentanaEleccion();

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Obtener el tamaño de la pantalla
        Dimension screenSize = toolkit.getScreenSize();

        // Obtener el ancho de la pantalla
        int screenWidth = screenSize.width;
        int screenheigth = screenSize.height;

        AppCoche frame = new AppCoche(ventanaEleccion);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenWidth, screenheigth);
        frame.setVisible(true);

        }
    }



