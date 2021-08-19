package utp.misiontic2022.c2.p21.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p21.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p21.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {

        var response = new ArrayList<Requerimiento_3>();
        String consulta = "SELECT C.PROVEEDOR , MC.NOMBRE_MATERIAL, MC.IMPORTADO, MC.PRECIO_UNIDAD, SUM(C.CANTIDAD) AS Cantidad FROM COMPRA C, MATERIALCONSTRUCCION MC WHERE MC.ID_MATERIALCONSTRUCCION = C.ID_MATERIALCONSTRUCCION AND MC.IMPORTADO = 'Si' AND C.PROVEEDOR = 'Homecenter' GROUP BY MC.NOMBRE_MATERIAL HAVING SUM(Cantidad) > 100 ORDER BY MC.NOMBRE_MATERIAL, C.PROVEEDOR;";

        try(var connection = JDBCUtilities.getConnection();
            var statement  = connection.prepareStatement(consulta);
            var rset = statement.executeQuery();)
        {
            while (rset.next()) {
                var requerimiento_3VO = new Requerimiento_3();
                requerimiento_3VO.setProveedor(rset.getString("Proveedor"));
                requerimiento_3VO.setNombreMaterial(rset.getString("Nombre_Material"));
                requerimiento_3VO.setImportado(rset.getString("Importado"));
                requerimiento_3VO.setPrecioUnidad(rset.getInt("Precio_Unidad"));
                requerimiento_3VO.setCantidad(rset.getInt("Cantidad"));

                response.add(requerimiento_3VO);
            }
        }
        return response;
    }
}