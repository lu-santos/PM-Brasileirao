/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao;

import java.lang.reflect.Method;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucianna
 */
public class ObjectTableModel extends DefaultTableModel {
    private Class<?> classe;
    private List<?> lista;

   public ObjectTableModel(List<?> linhas) {
      this.setLinhas(linhas);
      if (linhas != null)
        this.classe = linhas.get(0).getClass();
   }

    @Override
   public int getRowCount() {
      if (lista != null) {
         return lista.size();
      } else {
         return 0;
      }
   }

    @Override
   public int getColumnCount() {
       int colunas = 0;
       for(Method m : classe.getDeclaredMethods()){
           if(m.isAnnotationPresent(ColunaTabela.class)){
               colunas++;
           }
       }
      return colunas;
   }

   @Override
   public boolean isCellEditable(int row, int col) {
      return false;
    }

    @Override
    public Class getColumnClass(int c) {
      return getValueAt(0, c).getClass();
    }

    public void setLinhas(List<?> linhas) {
      this.lista = linhas;
      fireTableDataChanged();
   }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            Object objeto = lista.get(rowIndex);
            for(Method m : classe.getDeclaredMethods()){
                ColunaTabela c = m.getAnnotation(ColunaTabela.class);
                if(c != null && c.indice() == columnIndex){
                    if (m.invoke(objeto) == null) {
                        return "";
                    }
                    else {
                        return String.format(c.formato(), m.invoke(objeto));
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }
    @Override
    public String getColumnName(int coluna){
        for(Method m : classe.getDeclaredMethods()){
            ColunaTabela c = m.getAnnotation(ColunaTabela.class);
            if(c != null && c.indice() == coluna ){
                return c.nome();
            }
        }
        return "";
    }
}
