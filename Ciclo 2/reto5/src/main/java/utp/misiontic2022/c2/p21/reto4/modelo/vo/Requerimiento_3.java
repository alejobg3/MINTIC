package utp.misiontic2022.c2.p21.reto4.modelo.vo;

public class Requerimiento_3 {
    //Atributos
    private String proveedor;
    private String nombreMaterial;
    private String importado;
    private Integer precioUnidad;
    private Integer cantidad;

    //Set and Get
    public String getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombreMaterial() {
        return this.nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getImportado() {
        return this.importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public Integer getPrecioUnidad() {
        return this.precioUnidad;
    }

    public void setPrecioUnidad(Integer precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


}
