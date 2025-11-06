/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.trungtamjava.javaswing;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class PanelDuAnKinhDoanh extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PanelDuAnKinhDoanh.class.getName());
    ArrayList<duAn> data;
    Home root;
    public PanelDuAnKinhDoanh(Home a) {
        data=a.dataDuAn;
        this.root=a;
        initComponents();
        capNhanAllBang();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangDuAn = new javax.swing.JTable();
        btnThemDuAn = new javax.swing.JButton();
        btnThemVon = new javax.swing.JButton();
        btnXoaDuAn = new javax.swing.JButton();
        btnSuaDuAn = new javax.swing.JButton();
        btnXemChiTiet = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dự Án Kinh Doanh");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bangDuAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dự án", "Vốn đầu tư", "Chi phí", "Doanh thu", "Lợi nhuận", "Tổng ngân sách", "Tỷ lệ lợi nhuận"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bangDuAn);
        if (bangDuAn.getColumnModel().getColumnCount() > 0) {
            bangDuAn.getColumnModel().getColumn(0).setResizable(false);
            bangDuAn.getColumnModel().getColumn(1).setResizable(false);
            bangDuAn.getColumnModel().getColumn(2).setResizable(false);
            bangDuAn.getColumnModel().getColumn(3).setResizable(false);
            bangDuAn.getColumnModel().getColumn(4).setResizable(false);
            bangDuAn.getColumnModel().getColumn(5).setResizable(false);
            bangDuAn.getColumnModel().getColumn(6).setResizable(false);
        }

        btnThemDuAn.setText("Thêm dự án");
        btnThemDuAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDuAnActionPerformed(evt);
            }
        });

        btnThemVon.setText("Thêm vốn đầu tư");
        btnThemVon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVonActionPerformed(evt);
            }
        });

        btnXoaDuAn.setText("Xoá dự án");
        btnXoaDuAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDuAnActionPerformed(evt);
            }
        });

        btnSuaDuAn.setText("Sửa dự án");

        btnXemChiTiet.setText("Xem chi tiết dự án");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        jButton1.setText("Lưu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(35, 35, 35)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(btnThemDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemVon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaDuAn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaDuAn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXemChiTiet)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSuaDuAn, btnThemDuAn, btnThemVon, btnXemChiTiet, btnXoaDuAn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDuAn)
                    .addComponent(btnThemVon)
                    .addComponent(btnXoaDuAn)
                    .addComponent(btnSuaDuAn)
                    .addComponent(btnXemChiTiet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSuaDuAn, btnThemDuAn, btnThemVon, btnXemChiTiet, btnXoaDuAn});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemDuAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDuAnActionPerformed
        new frameThemDuAn(this).setVisible(true);
    }//GEN-LAST:event_btnThemDuAnActionPerformed

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        int row=bangDuAn.getSelectedRow();
        if(row==-1){
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một dự án!");
            return;
        }
        else{
           new FrameChiTietDuAnKinhDoanh(data.get(row).getDanhSachgiaoDich(),this).setVisible(true);
        }
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void btnXoaDuAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDuAnActionPerformed
        int row = bangDuAn.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Vui lòng chọn một dự án để xoá!");
            return;
        }
        data.remove(row);
        capNhanAllBang();
        javax.swing.JOptionPane.showMessageDialog(null, "Đã xoá dự án thành công!");
    }//GEN-LAST:event_btnXoaDuAnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        root.capNhanBangDGGanday();
    }//GEN-LAST:event_formWindowClosing

    private void btnThemVonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVonActionPerformed
        int row = bangDuAn.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một dự án để thêm vốn!");
            return;
        }
        new themVonDauTu(this, row).setVisible(true);        
    }//GEN-LAST:event_btnThemVonActionPerformed
    
    public void capNhanAllBang(){
        DefaultTableModel model=(DefaultTableModel) bangDuAn.getModel();
        model.setRowCount(0);
        data.forEach(i->{
            double vonDauTu = i.getVonDauTu();
            double loiNhuan = i.tinhLoiNhuan();
            double tongSoSauLaiLo = vonDauTu + loiNhuan;
            double tyLeLoiNhuan = vonDauTu > 0 ? (loiNhuan / vonDauTu) * 100 : 0;
            
            model.addRow(new Object[]{
                    i.getTenDuAn(),
                    (vonDauTu),
                    (Math.abs(i.tinhTongChiPhi())),
                    (i.tinhTongThuNhap()),
                    (loiNhuan),
                    (tongSoSauLaiLo),
                    String.format("%.1f%%", tyLeLoiNhuan)
            });
//            model.addColumn(new Object[]{i.getTenDuAn(),i.getVonDauTu(),i.getMucTieuLoiNhuan(),});
        });
    }
    
//    public void themDuAn(String ten,double von,double chiPhiDuKien,double mucTieuLoiNhuan){
//        data.add(new duAn(ten,von,chiPhiDuKien,mucTieuLoiNhuan));
//    }

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new PanelDuAnKinhDoanh().setVisible(true));
//    }
    public void capNhanBang(int row,String tenDuAn,double vonDauTu,double chiPhi,double doanhThu,double MucTieuloiNhuan,double Lai_Lo,double tiLeLoiNhuan){
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) bangDuAn.getModel();
        model.setValueAt(tenDuAn, row,0);
        model.setValueAt(vonDauTu, row, 1);
        model.setValueAt(chiPhi,row,2);
        model.setValueAt(doanhThu,row,3);
        model.setValueAt(MucTieuloiNhuan,row,4);
        model.setValueAt(Lai_Lo,row,5);
        model.setValueAt(tiLeLoiNhuan+"%",row,6);
        data.add(new duAn(tenDuAn,vonDauTu,chiPhi,MucTieuloiNhuan));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangDuAn;
    private javax.swing.JButton btnSuaDuAn;
    private javax.swing.JButton btnThemDuAn;
    private javax.swing.JButton btnThemVon;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXoaDuAn;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane4;
    // End of variables declaration//GEN-END:variables
}
