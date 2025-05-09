package org.example;


import model.Alergeno;
import model.AlergenoDao;

import java.util.ArrayList;

public class Main {

        public static void main(String args[]){
            AlergenoDao aler = new AlergenoDao();
            ArrayList<Alergeno> alergenos=new ArrayList<>();
            alergenos=aler.FindAll(null);//busca todo
            alergenos=aler.FindAll(new Alergeno(1,""));
            alergenos.toString();
        }
    }
