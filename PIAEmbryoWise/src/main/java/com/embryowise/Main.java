package com.embryowise;

import com.embryowise.Pantalla.*;
import javafx.application.Application;
import javafx.stage.Stage;

/** Es la clase que controla el inicio de la aplicación y hace que se despliegue la pantalla
 *  de inicio para comenzar la ejecución de funcionalidades a partir de ahí. Está extendiendo
 *  a la clase Application, que es la que hace que todo funcione para JavaFX.
 */
public class Main extends Application {
    /**
     * Método que se ejecuta cuando se inicia la aplicación, y que se le está dando la
     * función de mostrar la pantalla de inicio.
     *
     * @param primaryStage Es la ventana principal de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        // Se crea un objeto de la clase PantallaInicio.
        PantallaInicio pantallaInicio = new PantallaInicio();
        // Se manda a llamar el método de mostrar para la pantallaInicio.
        pantallaInicio.mostrar(primaryStage);
    }

    /**
     * Método main, que controla la ejecución del programa. Manda a llamar al método
     * launch() de JavaFX para iniciar la aplicación.
     *
     * @param args Es el parámetro necesario para launch().
     */
    public static void main(String[] args) {
        launch(args);
    }
}