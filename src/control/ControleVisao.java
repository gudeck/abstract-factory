/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import vision.*;

/**
 *
 * @author gudeck
 */
public class ControleVisao {
    
    private ControleDominio dominioCtlr;
    private JFRPrincipal janelaPrincipal;
    
    public ControleVisao(){
        dominioCtlr = new ControleDominio();
    }
    
    public ControleDominio getControleDominio(){
        return dominioCtlr;
    }
    
    public void janelaPrincipal(){
        janelaPrincipal = new JFRPrincipal(this);
        janelaPrincipal.setVisible(true);
    }
    
    public void cadastroCliente(){
        JDGCadastroCliente cadastroCliente = new JDGCadastroCliente(janelaPrincipal, true, this);
        cadastroCliente.setVisible(true);
    }
    
    public static void main (String args[]){
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFRPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        ControleVisao visaoCtrl = new ControleVisao();
        visaoCtrl.janelaPrincipal();
        
    }
    
}
