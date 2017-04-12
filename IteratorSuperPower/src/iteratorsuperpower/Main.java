/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorsuperpower;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        alunos.add(new Aluno("Leo", 20, 2.0, 'M'));
        alunos.add(new Aluno("Mauricio", 18, 1.7, 'M'));
        alunos.add(new Aluno("Ana", 20, 1.6, 'F'));
        alunos.add(new Aluno("Geovana", 19, 1.8, 'F'));
        Iterator iteratorAluno = new IteratorSuperPower((ArrayList<Object>) (Object) alunos, "sexo" , "!=", "F");
        while(!iteratorAluno.isDone()) {
            Object a = null;
            try {
                a = iteratorAluno.next();
                if(a != null)
                    System.out.println(a.toString());
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }        
    }
}