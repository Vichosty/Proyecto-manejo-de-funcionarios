/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofuncionarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author chkp
 */
public class ProyectoFuncionarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        gobierno.Reparticiones reparticiones = gobierno.Reparticiones.get();
        // gobierno.Trabajadores trabajadores = gobierno.Trabajadores.get();
        // gobierno.Contratos contratos = gobierno.Contratos.get();

        // <editor-fold defaultstate="collapsed" desc="Cargar los datos de la BD">
        /*
         * try { String conURL = "jdbc:mysql://localhost:3306/chk_test"; String
         * conUser = "chkP"; String conPass = "8heeArhoqm3G";
         *
         * Connection connection = DriverManager.getConnection(conURL, conUser,
         * conPass);
         *
         * // bd -> trabajadores Statement statement =
         * connection.createStatement(); ResultSet results =
         * statement.executeQuery("select * from trabajadores"); while
         * (results.next()) { int id = results.getInt("id"); String nombre =
         * results.getString("nombre"); String apellido =
         * results.getString("apellido"); Date fechaDeNacimiento =
         * results.getTimestamp("fechaDeNacimiento");
         *
         * gobierno.addTrabajador(new gobierno.Trabajador(id, nombre, apellido,
         * fechaDeNacimiento)); } statement.close();
         *
         * // bd -> reparticiones statement = connection.createStatement();
         * results = statement.executeQuery("select * from reparticiones");
         * while (results.next()) { int id = results.getInt("id"); String nombre
         * = results.getString("nombre"); String estado =
         * results.getString("estado");
         *
         * gobierno.addReparticion(new gobierno.Reparticion(id, nombre,
         * estado)); } statement.close();
         *
         * // TODO: falta una tabla que contenga todas las relaciones //
         * trabajador -> reparticion, para poder deducir a que //
         * reparticion(es) pertenece cada trabajador. (util para cuando un //
         * trabajador pertenezca a multiples reparticiones) connection.close();
         * } catch (Exception ex) {
         * Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
         * }
         */
        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Agregar algunas reparticiones de prueba">
        // Agregar algunas reparticiones de prueba
        String[] reparticionNames = {
            "Deportes", "Economia", "Construccion", "Politica"
        };

        for (int index = 0; index < reparticionNames.length; ++index) {
            reparticiones.add(new gobierno.Reparticion(
                    reparticiones.getMayorId() + 1,
                    reparticionNames[index],
                    gobierno.EstadoReparticion.Normal
            ));
        }
        //</editor-fold>

        // Crear varios trabajadores random
        debugCrearDatosRandom();

        // <editor-fold defaultstate="collapsed" desc="Look and Feel">
        try {
            // Si FlatLaf esta instalado, agregalos a la lista y usa FlatLightLaf por defecto.
            javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");

            UIManager.installLookAndFeel("FlatLightLaf", "com.formdev.flatlaf.FlatLightLaf");
            UIManager.installLookAndFeel("FlatDarkLaf", "com.formdev.flatlaf.FlatDarkLaf");
            UIManager.installLookAndFeel("FlatDarculaLaf", "com.formdev.flatlaf.FlatDarculaLaf");
        } catch (javax.swing.UnsupportedLookAndFeelException | 
                ClassNotFoundException | 
                InstantiationException | 
                IllegalAccessException ex) {
            System.out.println("FlatLaf no esta instalado.");
            try {
                // FlatLaf not found, intenta el de sistema.
                javax.swing.UIManager.setLookAndFeel(
                        javax.swing.UIManager.getSystemLookAndFeelClassName()
                );
            } catch (ClassNotFoundException | 
                    InstantiationException | 
                    IllegalAccessException | 
                    UnsupportedLookAndFeelException ex1) {
                Logger.getLogger(ProyectoFuncionarios.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        // </editor-fold>

        chk.forms.MainWindow mainWindow = new chk.forms.MainWindow();
        mainWindow.setVisible(true);
    }

    public static void debugCrearDatosRandom() {
        gobierno.Trabajadores trabajadores = gobierno.Trabajadores.get();
        gobierno.Reparticiones reparticiones = gobierno.Reparticiones.get();
        gobierno.Contratos contratos = gobierno.Contratos.get();

        String[] commonNames = {
            "James", "Robert", "John", "Michael", "William",
            "David", "Richard", "Joseph", "Thomas", "Charles",
            "Kenneth", "Kevin", "Brian", "George", "Edward",
            "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan",
            "Mary", "Patricia", "Jennifer", "Linda", "Elizabeth",
            "Barbara", "Susan", "Jessica", "Sarah", "Karen",
            "Michelle", "Dorothy", "Carol", "Amanda", "Melissa",
            "Deborah", "Stephanie", "Rebecca", "Sharon", "Laura"
        };
        String[] commonSurnames = {
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson",
            "Thomas", "Taylor", "Moore", "Jackson", "Martin",
            "Lee", "Perez", "Thompson", "White", "Harris",
            "Sanchez", "Clark", "Hall", "Allen", "Young"
        };
        
        ThreadLocalRandom random = ThreadLocalRandom.current();

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = df.parse("1980-01-01");
            Date endDate = df.parse("2005-01-01");
            long startMilis = startDate.getTime();
            long endMilis = endDate.getTime();
            for (int i = 1; i <= 50; ++i) {
                int randomIndex = random.nextInt(commonNames.length);
                String randomName = commonNames[randomIndex];
                randomIndex = random.nextInt(commonSurnames.length);
                String randomSurname = commonSurnames[randomIndex];

                long randomMilis = random.nextLong(startMilis, endMilis);
                Date randomDate = new Date(randomMilis);
                trabajadores.add(new gobierno.Trabajador(
                        i, randomName, randomSurname, randomDate)
                );
            }
        } catch (ParseException ex) {
            Logger.getLogger(ProyectoFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Crea contratos aleatorios entre los trabajadores y una reparticion al azar
        ArrayList<Integer> reparticionesIds = reparticiones.getIDs();
        int added = 0;
        if (!reparticionesIds.isEmpty()) {
            for (int trabajadorId : trabajadores.getIDs()) {
                gobierno.Trabajador t = trabajadores.get(trabajadorId);

                int randomId = reparticionesIds.get(
                        random.nextInt(reparticionesIds.size())
                );

                gobierno.Reparticion r = reparticiones.get(randomId);
                contratos.add(new gobierno.Contrato(
                        contratos.getMayorId() + 1, t.getId(), r.getId())
                );
                ++added;
            }
            if (added == 0) {
                System.out.println("No hay trabajadores!");
            }
        } else {
            System.out.println("No hay reparticiones!");
        }
    }
}
