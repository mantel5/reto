package org.example.example;


import model.Carrito;
import model.CarritoDao;
import model.Producto;
import model.ProductoDao;

import java.util.ArrayList;

public class Main {

        public static void main(String args[]){
            ProductoDao pro = new ProductoDao();
            ArrayList<Producto> productos = pro.FindAll(null);
            if (productos.isEmpty()) {
                System.out.println("no hay productos en la base de datos");

            }else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        }
    }
