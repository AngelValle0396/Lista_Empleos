package com.example.lista_empleos.Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Empleo {

    private String ofertaLaboral;
    private String empresa;
    private String cargo;
    private String correo;
    private String descripcion;
    private String imagen;

    public Empleo() {
    }

    public Empleo(String ofertaLaboral, String empresa, String cargo, String correo, String descripcion, String imagen) {
        super();
        this.ofertaLaboral = ofertaLaboral;
        this.empresa = empresa;
        this.cargo = cargo;
        this.correo = correo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getOfertaLaboral() {
        return ofertaLaboral;
    }

    public void setOfertaLaboral(String ofertaLaboral) {
        this.ofertaLaboral = ofertaLaboral;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Empleo(JSONObject item) throws JSONException {
        ofertaLaboral= item.getString("OfertaLaboral");
        empresa= item.getString("Empresa");
        cargo= item.getString("Cargo");
        correo= item.getString("Correo");
        descripcion= item.getString("Descripcion");
        imagen= item.getString("Imagen");


    }
    public static ArrayList<Empleo> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Empleo> empleos = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            empleos.add(new Empleo(datos.getJSONObject(i)));
        }
        return empleos;
    }

}
