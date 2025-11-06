package com.trungtamjava.javaswing;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FrameChiTietDuAnKinhDoanh extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrameChiTietDuAnKinhDoanh.class.getName());
    ArrayList<giaoDich> data;
    PanelDuAnKinhDoanh root;
    public FrameChiTietDuAnKinhDoanh(ArrayList<giaoDich> a,PanelDuAnKinhDoanh root){
        this.data=a;
        this.root=root;
        initComponents();
        // Tô màu nền ô "Loại" dựa theo giá trị cột "Số tiền"
giaoDichTrongDuAn.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
    @Override
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        java.awt.Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Nếu đang chọn dòng thì ưu tiên màu chọn của hệ thống
        if (isSelected) {
            cell.setBackground(table.getSelectionBackground());
            return cell;
        }

        // Mặc định nền trắng
        cell.setBackground(java.awt.Color.WHITE);

        // Chỉ đổi màu nền ở cột "Loại" (cột 0)
        if (column == 0) {
            try {
                double soTien = Double.parseDouble(table.getValueAt(row, 2).toString());
                if (soTien < 0) {
                    cell.setBackground(new java.awt.Color(255, 204, 204)); // đỏ nhạt
                } else if (soTien > 0) {
                    cell.setBackground(new java.awt.Color(204, 255, 204)); // xanh nhạt
                }
            } catch (Exception e) {
                cell.setBackground(java.awt.Color.WHITE);
            }
        }

        return cell;
    }
});

        capNhatAllBang();
        setLocationRelativeTo(null);
    }
    
    public void capNhatAllBang(){
        DefaultTableModel model=(DefaultTableModel)giaoDichTrongDuAn.getModel();
        model.setRowCount(0);
        data.forEach(i->{
            model.addRow(new Object[]{i.getLoai(),i.getMoTa(),i.getSoTien(),i.getNgay(),i.getGhiChu()});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        giaoDichTrongDuAn = new javax.swing.JTable();
        btnThemGiaoDichDuAn = new javax.swing.JButton();
        btnXoaGd = new javax.swing.JButton();
        btnSuaGiaoDich = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButton1.setText("Lưu");

        giaoDichTrongDuAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loại", "Mô tả", "Số tiền", "Ngày", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(giaoDichTrongDuAn);

        btnThemGiaoDichDuAn.setText("Thêm giao dịch");
        btnThemGiaoDichDuAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGiaoDichDuAnActionPerformed(evt);
            }
        });

        btnXoaGd.setText("Xoá giao dịch");
        btnXoaGd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGdActionPerformed(evt);
            }
        });

        btnSuaGiaoDich.setText("Sửa giao dịch");
        btnSuaGiaoDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaGiaoDichActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                        .addComponent(btnThemGiaoDichDuAn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaGd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaGiaoDich))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnThemGiaoDichDuAn)
                    .addComponent(btnXoaGd)
                    .addComponent(btnSuaGiaoDich))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemGiaoDichDuAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGiaoDichDuAnActionPerformed
        new ThemChiTieu(this).setVisible(true);
    }//GEN-LAST:event_btnThemGiaoDichDuAnActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        root.capNhanAllBang();
    }//GEN-LAST:event_formWindowClosed

    private void btnSuaGiaoDichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaGiaoDichActionPerformed
        int row=giaoDichTrongDuAn.getSelectedRow();
        if(row==-1){
            
        }
        else{
            giaoDich a=data.get(row);
            new ThemChiTieu(this,a.getLoai(),a.getMoTa(),a.getSoTien(),a.getNgay().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),a.getGhiChu(),row).setVisible(true);
        }
        
    }//GEN-LAST:event_btnSuaGiaoDichActionPerformed

    private void btnXoaGdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGdActionPerformed
        int row=giaoDichTrongDuAn.getSelectedRow();
        if(row==-1){
            
        }
        else{
            data.remove(row);
            capNhatAllBang();
        }
    }//GEN-LAST:event_btnXoaGdActionPerformed
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
//        java.awt.EventQueue.invokeLater(() -> new FrameChiTietDuAnKinhDoanh().setVisible(true));
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaGiaoDich;
    private javax.swing.JButton btnThemGiaoDichDuAn;
    private javax.swing.JButton btnXoaGd;
    private javax.swing.JTable giaoDichTrongDuAn;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
