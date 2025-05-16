package com.embryowise.Cuestionarios;

import com.embryowise.Menu.MenuBase;
import com.embryowise.Menu.MenuPrincipal;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.List;

public class MenuCuestionarios extends MenuBase {
    /** Es el método para mostrar en sí todo lo que aparecerá en la pantalla de manera ya completa.
     *
     * @param stage Es la ventana en la que se estará mostrando el menú.
     */
    public void mostrar(Stage stage) { // (8)
        // Son los botones para elegir a qué opción entrar a ver su contenido.
        Button botonCuesPreE = new Button("Cuestionario Periodo Pre-Embrionario"); // (4)
        Button botonCuesEmb = new Button(" Cuestionario Periodo Embrionario"); // (4)
        Button botonCuesFetal = new Button("Cuestionario Periodo Fetal"); // (4)
        Button botonRegresar = new Button("Regresar"); // (4)

        // Son las acciones que se realizarán con cada botón.
//        botonCuesPreE.setOnAction(e -> new MenuPeriodoPreEmbrionario().mostrar(stage)); // (13)
//        botonCuesEmb.setOnAction(e -> new MenuPeriodoEmbrionario().mostrar(stage)); // (13)
//        botonCuesFetal.setOnAction(e -> new MenuPeriodoFetal().mostrar(stage)); // (13)
//        botonRegresar.setOnAction(e -> new MenuPrincipal().mostrar(stage)); // (13)

        // Se muestra el menú heredado de la clase abstracta, con los atributos antes creados.
        mostrarMenu(stage, "Menú Cuestionarios", "/Recursos/FondosMenus/FondoMenuEtapasDesarrollo.png",
                List.of(botonCuesPreE, botonCuesEmb, botonCuesFetal), botonRegresar, () -> new MenuPrincipal().mostrar(stage),
                new Insets(400, 0, 0, 0));
    }
}
