/*
 * Copyright 2020 Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.entities;

import java.text.DecimalFormat;
import org.japo.java.interfaces.IArticulo;

/**
 *
 * @author Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es
 */
public class Articulo implements IArticulo {

    public static final double DEF_PRECIO = 0.0;

    public static final double MIN_PRECIO = 0.0;

    private double precio;

    public Articulo() {
        precio = DEF_PRECIO;
    }

    public Articulo(double precio) {
        if (validar(precio)) {
            this.precio = precio;

        } else {
            this.precio = DEF_PRECIO;
        }

    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (validar(precio)) {
            this.precio = precio;

        }
    }

    @Override
    public final boolean equals(Object o) {
        boolean testOK;
        if (o == null) {
            testOK = false;
        } else if (!(o instanceof Articulo)) {
            testOK = false;
        } else {
            testOK = precio == ((Articulo) o).getPrecio();
        }
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.precio)
                ^ (Double.doubleToLongBits(this.precio) >>> 32));
        return hash;
    }

    //Se establece con %.2g el formato para no permitir mas 
    //de 2 decimales significativos
    @Override
    public String toString() {
        return String.format("%s - Valor final del producto: %.2g",
                 getClass().getSimpleName(), precio);
    }

    private boolean validar(double precio) {


        return precio >= MIN_PRECIO;
    }

    @Override
    public void mostrarPrecio() {
        System.out.println(toString());
    }

}
