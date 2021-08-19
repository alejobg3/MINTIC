package utp.misiontic2022.c2.p21.reto4.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
import java.awt.*;



import utp.misiontic2022.c2.p21.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_3;

public class VentanaRequemimiento extends JFrame{
    
    private JTable tabla;
    private ControladorRequerimientos controlador;

    public VentanaRequemimiento(){
        controlador = new ControladorRequerimientos();
        ImageIcon imagenFondo;
        String nombreRutaI;
        initUI();
        // initUI2();
        // initUI3();
        setLocationRelativeTo(null);
    }

    // public Paner

    // public void Paint(Graphics g) {
    //     Dimension tamanio = getSize();
    //     // imagenFondo =  new ImageIcon();
    //     g.drawImage(img, x, y, observer)
        
    // }


    public void initUI(){
        
        setTitle("Interfaz Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 370);
        setBackground(Color.BLACK);
        var tbd = new JTabbedPane();
        getContentPane().add(tbd);

        var panel = new JPanel();
        panel.setBackground(new Color(201, 248, 255));
        // panel.set
        panel.setLayout(new BorderLayout());
        
        tbd.addTab("Consultar Requerimientos", panel);

        var panelEntrada = new JPanel();
        panelEntrada.setBackground(new Color(201, 248, 255));
        panelEntrada.add(new JLabel("Requerimientos"));
        
        var btnConsulta = new JButton("Requerimiento 1");
        btnConsulta.addActionListener(e -> cargarTablaConsulta());
        
        var btnConsulta2 = new JButton("Requerimiento 2");
        btnConsulta2.addActionListener(e -> cargarTablaConsulta2());
        
        var btnConsulta3 = new JButton("Requerimiento 3");
        btnConsulta3.addActionListener(e -> cargarTablaConsulta3());
        
        panelEntrada.add(btnConsulta);
        panelEntrada.add(btnConsulta2);
        panelEntrada.add(btnConsulta3);

        panel.add(panelEntrada, BorderLayout.PAGE_START);
        
        //Tabla
        tabla = new JTable();
        tabla.setBackground(new Color(201, 248, 255));
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
            var tableModel = new Requerimiento2TabMode2();
            tableModel.setData(lista);
            tabla.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class Requerimiento2TabMode2 extends AbstractTableModel{
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

    private void cargarTablaConsulta3() {
        try {
            var lista = controlador.consultarRequerimiento3();
            var tableModel = new Requerimiento3TabModel3();
            tableModel.setData(lista);
            tabla.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class Requerimiento3TabModel3 extends AbstractTableModel{
        private ArrayList<Requerimiento_3> data;
        
        public void setData(ArrayList<Requerimiento_3> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Proveedor";
                case 1:
                    return "Nombre Material";
                case 2:
                    return "Importado";
                case 3:
                    return "Precio Unidad";
                case 4:
                    return "Cantidad";
            }
                return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
                return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return registro.getProveedor();
                case 1:
                    return registro.getNombreMaterial();
                case 2:
                    return registro.getImportado();
                case 3:
                    return registro.getPrecioUnidad();
                case 4:
                    return registro.getCantidad();
            }
            return null;
        }
    }
}
