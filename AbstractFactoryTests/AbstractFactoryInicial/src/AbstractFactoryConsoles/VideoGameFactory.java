/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactoryConsoles;

/**
 *
 * @author Emanuel
 */
public abstract class VideoGameFactory {
    
    public abstract Console montarConsole();
    public abstract Controle montarControle();
    
}