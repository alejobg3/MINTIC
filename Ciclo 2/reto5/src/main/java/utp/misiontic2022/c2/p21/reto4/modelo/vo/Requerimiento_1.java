package utp.misiontic2022.c2.p21.reto4.modelo.vo;

public class Requerimiento_1 {
    //Atributos
    private String nombreMatrerial;
    private Integer precioUnidad;

    //Set and get
    public String getNombreMaterial(){
        return nombreMatrerial;
    }
    public void setNombreMaterial(String nombreMatrerial) {
        this.nombreMatrerial = nombreMatrerial;
    }
    public Integer getPrecioUnidad (){
        return precioUnidad;
    }
    public void setPrecioUnidad(Integer precioUnidad){
        this.precioUnidad = precioUnidad;
    }

}
