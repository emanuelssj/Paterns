/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorsuperpower;

import com.sun.xml.internal.ws.util.StringUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class IteratorSuperPower implements Iterator {
    private ArrayList<Object> lista;
    private int contador;
    private String operador;
    private String valor;
    private Method method;
    
 
    protected IteratorSuperPower(ArrayList<Object> lista, String method, String operador, String valor) {
        this.lista = lista;
        this.valor = valor;
        this.operador = operador;
        contador = -1;
        try {
            method = "get" + StringUtils.capitalize(method);
            this.method = lista.get(0).getClass().getDeclaredMethod(method);
            this.method.getReturnType();
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(IteratorSuperPower.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @Override
    public void first() {
        contador = 0;
    }
 
    @Override
    public Object next() throws Exception {
        contador++;
        if(!isDone()) {
            if(operador.equals("==")) {
                while(!isDone()) {
                    if(method.invoke(lista.get(contador)).toString().equals(valor)) 
                        return lista.get(contador);
                     else
                        contador++;
                }
            } else if(operador.equals(">")) {
                while(!isDone()) {
                    if((Double.parseDouble(method.invoke(lista.get(contador)).toString())) > Double.parseDouble(valor)) 
                        return lista.get(contador);
                    else
                        contador++;
                }
            } else if(operador.equals("<")) {
                while(!isDone()) {
                    if((Double.parseDouble(method.invoke(lista.get(contador)).toString())) < Double.parseDouble(valor)) 
                        return lista.get(contador);
                     else
                        contador++;
                }
            } else if(operador.equals("!=")) {
                while(!isDone()) {
                    if(!method.invoke(lista.get(contador)).toString().equals(valor)) 
                        return lista.get(contador);
                     else
                        contador++;
                }
            }        
        }
        return null;
    }
 
    @Override
    public boolean isDone() {
        return contador >= lista.size();
    }
}