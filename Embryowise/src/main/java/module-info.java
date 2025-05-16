module PIAEmbryoWise {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;

    exports com.embryowise to javafx.graphics;
    exports com.embryowise.EtapasDeDesarrollo to javafx.graphics;
    exports com.embryowise.Glosario to javafx.graphics;
    exports com.embryowise.Cuestionarios to javafx.graphics;
    exports com.embryowise.EtapasDeDesarrollo.PeriodoPreEmbrionario to javafx.graphics;
    exports com.embryowise.EtapasDeDesarrollo.PeriodoEmbrionario to javafx.graphics;
    exports com.embryowise.EtapasDeDesarrollo.PeriodoFetal to javafx.graphics;
    exports com.embryowise.Main to javafx.graphics;
    exports com.embryowise.InicioSesion to javafx.graphics;
    exports com.embryowise.Registro to javafx.graphics;
    exports com.embryowise.Menu to javafx.graphics;
    exports com.embryowise.PantallaInicio to javafx.graphics;
}