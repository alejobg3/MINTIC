package utp.misiontic2022.c2.p21.reto4.vista;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

// import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import utp.misiontic2022.c2.p21.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_2;

public class VentanaRequemimiento3 extends JFrame{
    
    private JTable tabla;
    private ControladorRequerimientos controlador;

    public VentanaRequemimiento3(){
        controlador = new ControladorRequerimientos();
        initUI();
        // initUI2();
        setLocationRelativeTo(null);
    }

    public void initUI(){
        setTitle("Interfaz Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        var tbd = new JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);

        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tbd.addTab("Consulta Requerimiento", panel);

        var panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Requerimiento Label"));
        
        var btnConsulta = new JButton("Consulta Requerimiento 1");
        btnConsulta.addActionListener(e -> cargarTablaConsulta());
        
        panelEntrada.add(btnConsulta);
        panel.add(panelEntrada, BorderLayout.PAGE_START);
        
        //Tabla
        tabla = new JTable();
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

    }

    public void initUI2(){
        setTitle("Interfaz Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        var tbd = new JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);
        
        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tbd.addTab("Consulta Requerimiento", panel);

        var panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Requerimiento Label"));
        
        var btnConsulta = new JButton("Consulta Requerimiento 2");
        btnConsulta.addActionListener(e -> cargarTablaConsulta2());
        
        panelEntrada.add(btnConsulta);
        panel.add(panelEntrada, BorderLayout.PAGE_START);
        
        //Tabla
        tabla = new JTable();
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

    }




    private void cargarTablaConsulta() {
        try {
            var lista = controlador.consultarRequerimiento1();
            var tableModel = new Requerimiento1TabModel();
            tableModel.setData(lista);
            tabla.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class Requerimiento1TabModel extends AbstractTableModel{
        private ArrayList<Requerimiento_1> data;
        
        public void setData(ArrayList<Requerimiento_1> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Nombre Material";
                case 1:
                    return "Precio Unidad";
            }
                return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
                return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return registro.getNombreMaterial();
                case 1:
                    return registro.getPrecioUnidad();
            }

            return null;
        }
         
    }

    private void cargarTablaConsulta2() {
        try {
            var lista = controlador.consultarRequerimiento2();
            var tableModel = new Requerimiento1TabMode2();
            tableModel.setData(lista);
            tabla.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class Requerimiento1TabMode2 extends AbstractTableModel{
        private ArrayList<Requerimiento_2> data;
        
        public void setData(ArrayList<Requerimiento_2> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Constructora";
                case 1:
                    return "Ciudad";
            }
                return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
                return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return registro.getConstructora();
                case 1:
                    return registro.getCiudad();
            }

            return null;
        }
         
    }

}
