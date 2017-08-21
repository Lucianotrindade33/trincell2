package com.example.lucia.trincell;

/**
 * Created by lucia on 28/07/2017.
 */

public class Products {

    //CAMPOS A SEREM PREENCHIDOS LIST VIEW

    private String marca;
    private String modelo;
    private String peca;
    private String preco;
    private String id;

    public Products(String marca, String modelo, String peca, String preco, String id) {
        this.marca = marca;
        this.modelo = modelo;
        this.peca = peca;
        this.preco = preco;
        this.id = id;
    }

    public Products() {

    }

    public String getMarca() { return marca;}

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPeca() {
        return peca;
    }

    public void setPeca(String peca) {
        this.peca = peca;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }






    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {

//       String teste = "";
//        if (peca.equalsIgnoreCase("Combo 4g")){
//           teste = "PREÇO PROMOCIONAL";
       // }

        return

                      //  teste+
                 peca+"   "+
                " R$ " + preco;

    }
}

