/*
 * The MIT License
 *
 * Copyright 2022 chkp.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package gobierno;

/**
 *
 * @author chkp
 */
public class Contrato {
    private int id;
    private int idTrabajador;
    private int idReparticion;
    /* etc */
    
    public Contrato() {
        this.id = -1;
        this.idTrabajador = -1;
        this.idReparticion = -1;
    }

    public Contrato(int id, int idTrabajador, int idReparticion) {
        this.id = id;
        this.idTrabajador = idTrabajador;
        this.idReparticion = idReparticion;
    }

    public int getId() {
        return id;
    }
    
    public int getIdTrabajador() {
        return idTrabajador;
    }
    
    public int getIdReparticion() {
        return idReparticion;
    }
    
    public static String getIconPath() {
        return "icons/contrato.png";
    }
}