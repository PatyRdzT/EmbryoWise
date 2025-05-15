module PIAEmbryoWise {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;

    exports com.embryowise;
    exports com.embryowise.Pantalla to javafx.graphics;
    exports com.embryowise.Pantalla.EtapasDeDesarrollo to javafx.graphics;
    exports com.embryowise.Pantalla.Glosario to javafx.graphics;
    exports com.embryowise.Pantalla.Cuestionarios to javafx.graphics;
    exports com.embryowise.Pantalla.EtapasDeDesarrollo.PeriodoPreEmbrionario to javafx.graphics;
    exports com.embryowise.Pantalla.EtapasDeDesarrollo.PeriodoEmbrionario to javafx.graphics;
    exports com.embryowise.Pantalla.EtapasDeDesarrollo.PeriodoFetal to javafx.graphics;
}