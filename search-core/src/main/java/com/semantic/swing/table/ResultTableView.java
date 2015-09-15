/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ResultTableView.java
 *
 * Created on 29.09.2011, 10:20:11
 */
package com.semantic.swing.table;

import com.semantic.util.lazy.LazyList;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import org.apache.lucene.document.Document;

/**
 *
 * @author cplonka
 */
public class ResultTableView extends javax.swing.JPanel {
    
    /** Creates new form ResultTableView */
    public ResultTableView() {
        initComponents();
        initOwnComponents();
    }
    
    private void initOwnComponents(){
        resultTable.setDefaultRenderer(ImageIcon.class, new ImageIconTableCellRenderer());        
        resultTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public JTable getResultTable() {
        return resultTable;
    }    
    
    public void setLazyList(LazyList<Document> lazyList) {
        resultTable.setModel(new LazyDocumentsTableModel(lazyList));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(resultTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultTable;
    // End of variables declaration//GEN-END:variables
}