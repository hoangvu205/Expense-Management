/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.trungtamjava.javaswing;

/**
 *
 * @author ACER
 */
public class themVonDauTu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(themVonDauTu.class.getName());
    private PanelDuAnKinhDoanh parent;
    private int rowPick;

    public themVonDauTu(PanelDuAnKinhDoanh parent, int rowPick) {
        initComponents();
        setLocationRelativeTo(null);
        this.parent = parent;
        this.rowPick = rowPick;

        btnOK.addActionListener(e -> themVon());
        btnCancel.addActionListener(e -> dispose());
    }

    private void themVon() {
        try {
            double soTienThem = Double.parseDouble(txtVonThem.getText());
            if (soTienThem <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Số tiền phải lớn hơn 0!");
                return;
            }

            // cập nhật vốn đầu tư
            duAn duAnChon = parent.data.get(rowPick);
            duAnChon.setVonDauTu(duAnChon.getVonDauTu() + soTienThem);

            javax.swing.JOptionPane.showMessageDialog(this, "Đã thêm " + soTienThem + " vào dự án!");
            parent.capNhanAllBang(); // làm mới bảng
            dispose();
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, null, e);
            javax.swing.JOptionPane.showMessageDialog(this, "Lỗi khi thêm vốn!");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtVonThem = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nhập số tiền thêm");

        btnOK.setText("OK");

        btnCancel.setText("cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVonThem)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVonThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnCancel))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtVonThem;
    // End of variables declaration//GEN-END:variables
}
