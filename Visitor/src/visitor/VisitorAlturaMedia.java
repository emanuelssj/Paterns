/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class VisitorAlturaMedia implements IVisitor {
    private double alturaAcumulada = 0;
    private int numPessoasVisitadas = 0;
    
    public double getAlturaMedia() {
        return alturaAcumulada / numPessoasVisitadas;
    }

    @Override
    public void visit(IElement element) {
        Method method = null;
        try {
            method = element.getClass().getMethod("visit", element.getClass());
            method.invoke(this, element);
        } catch (NoSuchMethodException ex) {
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(VisitorAlturaMedia.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
    public void visitProfessor(Professor professor) {
        alturaAcumulada += professor.getAltura();
        numPessoasVisitadas++;
    }
    
    public void visitAluno(Aluno aluno) {
        alturaAcumulada += aluno.getAltura();
        numPessoasVisitadas++;
    }
}
