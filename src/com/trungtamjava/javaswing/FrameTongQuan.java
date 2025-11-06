package com.trungtamjava.javaswing;

import javax.swing.*;
import java.util.*;
import java.sql.*;

public class FrameTongQuan extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrameTongQuan.class.getName());
//    ArrayList<giaoDich> dataCaNhan;
//    Arraylist
    Home root;
    double tong=0.0;
    double chi=0;
    double tile;
    
    public void capnhatTong(String thang, String nam, String name){
        System.out.println(thang+" "+nam+name);
        try(java.sql.Connection conn = DatabaseConnection.getConnection()) {
            
            String sql =String.format("""
                        select sum(soTien) as total  
                        from giao_dich 
                        where month(ngay) = %s AND year(ngay) = %s AND username="%s";
                        """,thang,nam,name);
            System.out.println(sql);
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            if(res.next()){
                tong=res.getDouble("total");
                tongChiTieu.setText(Double.toString(res.getDouble("total"))+" VNĐ");
            }
            else{
                tongChiTieu.setText("0 VNĐ");
            }
            
        } catch (Exception e) {
            System.out.println("hai quay xe");
        }
    }
    
    public void capnhatChi(String thang, String nam, String name){
        try(java.sql.Connection conn = DatabaseConnection.getConnection()) {
            
            String sql =String.format("""
                        select sum(soTien) as total  
                        from giao_dich 
                        where month(ngay) = %s AND year(ngay) = %s AND username="%s" AND soTien<0;
                        """,thang,nam,name);
            System.out.println(sql);
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            if(res.next()){
                //cập nhật tổng chi
                chi=0-res.getDouble("total");
                tongChi.setText(Double.toString(chi)+" VNĐ");
                //cập nhật tổng thu = tổng - tổng chi
                tongThu.setText(Double.toString(tong+chi)+" VNĐ");
                //cập nhật tỉ lệ
                if(chi!=0){
                    tile=(tong+chi)/chi*100;
                    tiLeThuChi.setText(Double.toString(tile)+"%");
                }
                else{
                    tiLeThuChi.setText("Tốt");
                }
            }
            else{
                //cập nhật nếu không có chi gì
                tongChi.setText("0 VNĐ");
                tongThu.setText(Double.toString(tong)+" VNĐ");
                tiLeThuChi.setText("Tốt");
            }
            
        } catch (Exception e) {
            System.out.println("hai quay xe");
        }
    }
    
    public FrameTongQuan(Home a) {
        root=a;
        initComponents();
        capnhatTong("month(curdate())","year(curdate())",a.name);
        capnhatChi("month(curdate())", "year(curdate())", a.name);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        tongChiTieu = new javax.swing.JLabel();
        tongChi = new javax.swing.JLabel();
        tongThu = new javax.swing.JLabel();
        tiLeThuChi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        okBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textMonth = new javax.swing.JTextField();
        textYear = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tongChiTieu1 = new javax.swing.JLabel();
        tongChi1 = new javax.swing.JLabel();
        tongThu1 = new javax.swing.JLabel();
        tiLeThuChi1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenu4.setText("jMenu4");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tongChiTieu.setBackground(new java.awt.Color(0, 255, 204));
        tongChiTieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tongChiTieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tongChiTieu.setText("Tổng");
        tongChiTieu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tongChiTieu.setOpaque(true);

        tongChi.setBackground(new java.awt.Color(255, 0, 0));
        tongChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tongChi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tongChi.setText("Chi");
        tongChi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tongChi.setOpaque(true);

        tongThu.setBackground(new java.awt.Color(0, 204, 0));
        tongThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tongThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tongThu.setText("Thu");
        tongThu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tongThu.setOpaque(true);

        tiLeThuChi.setBackground(new java.awt.Color(255, 51, 102));
        tiLeThuChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tiLeThuChi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiLeThuChi.setText("Tỉ Lệ");
        tiLeThuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tiLeThuChi.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tongChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tongChi, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tongThu, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tiLeThuChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tongChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tongThu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tiLeThuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tongChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tiLeThuChi, tongChi, tongChiTieu, tongThu});

        jPanel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        okBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tháng:");

        textMonth.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textMonth.setText("11");

        textYear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textYear.setText("2025");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Năm:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textYear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textYear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tongChiTieu1.setBackground(new java.awt.Color(102, 255, 102));
        tongChiTieu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tongChiTieu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tongChiTieu1.setText("Tổng");
        tongChiTieu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tongChiTieu1.setOpaque(true);

        tongChi1.setBackground(new java.awt.Color(102, 255, 102));
        tongChi1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tongChi1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tongChi1.setText("Chi");
        tongChi1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tongChi1.setOpaque(true);

        tongThu1.setBackground(new java.awt.Color(102, 255, 102));
        tongThu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tongThu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tongThu1.setText("Thu");
        tongThu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tongThu1.setOpaque(true);

        tiLeThuChi1.setBackground(new java.awt.Color(102, 255, 102));
        tiLeThuChi1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tiLeThuChi1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiLeThuChi1.setText("Tỉ lệ Thu/Chi");
        tiLeThuChi1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tiLeThuChi1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tongChiTieu1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tongChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tongThu1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tiLeThuChi1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tongThu1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(tiLeThuChi1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(tongChi1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addComponent(tongChiTieu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        tiLeThuChi1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        // TODO add your handling code here:
        capnhatTong(textMonth.getText(), textYear.getText(), root.name);
        capnhatChi(textMonth.getText(), textYear.getText(), root.name);
    }//GEN-LAST:event_okBtnActionPerformed

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
//        java.awt.EventQueue.invokeLater(() -> new FrameTongQuan().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton okBtn;
    private javax.swing.JTextField textMonth;
    private javax.swing.JTextField textYear;
    private javax.swing.JLabel tiLeThuChi;
    private javax.swing.JLabel tiLeThuChi1;
    private javax.swing.JLabel tongChi;
    private javax.swing.JLabel tongChi1;
    private javax.swing.JLabel tongChiTieu;
    private javax.swing.JLabel tongChiTieu1;
    private javax.swing.JLabel tongThu;
    private javax.swing.JLabel tongThu1;
    // End of variables declaration//GEN-END:variables
}
