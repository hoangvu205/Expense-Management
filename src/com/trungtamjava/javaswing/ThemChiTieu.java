
package com.trungtamjava.javaswing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ThemChiTieu extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ThemChiTieu.class.getName());
    String moTa,Loai,ghiChu;
    double soTien;
    private int rowPick;
    LocalDate ngay;
    int check;
    private FrameChiTietDuAnKinhDoanh root;
    private java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private PanelGiaoDichCaNhan parent;
    LocalDate today = LocalDate.now();
    private ArrayList<giaoDich> data;
    public ThemChiTieu(PanelGiaoDichCaNhan parent) {
        initComponents();
        getRootPane().setDefaultButton(btnOK);
        setLocationRelativeTo(null);
        this.parent=parent;
        this.data=parent.data;
        check=1;
        ngaytxt.setText(today.format(fmt));
        moTa="";Loai="";ghiChu="";
    }
    //sua giao dich
    public ThemChiTieu(PanelGiaoDichCaNhan parent, String loai, String moTa, double soTien, String ngay, String ghiChu, int rowIndex) {
        //sửa giaoo dịch
        initComponents();
        getRootPane().setDefaultButton(btnOK);
        this.data = parent.data;
        this.parent=parent;
        setLocationRelativeTo(null);
        check = 2;
        rowPick=rowIndex;

        // Set dữ liệu sẵn vào các ô nhập
        loaitxt.setSelectedItem(loai);
        moTatxt.setText(moTa);
        soTientxt.setText(String.valueOf(soTien));
        ngaytxt.setText(ngay);
        ghiChutxt.setText(ghiChu);
    }
    public ThemChiTieu(FrameChiTietDuAnKinhDoanh parent, String loai, String moTa, double soTien, String ngay, String ghiChu, int rowIndex) {
        //sửa giaoo dịch dự án
        initComponents();
        getRootPane().setDefaultButton(btnOK);
        this.data = parent.data;
        this.root=parent;
        setLocationRelativeTo(null);
        check = 4;
        rowPick=rowIndex;

        // Set dữ liệu sẵn vào các ô nhập
        loaitxt.setSelectedItem(loai);
        moTatxt.setText(moTa);
        soTientxt.setText(String.valueOf(soTien));
        ngaytxt.setText(ngay);
        ghiChutxt.setText(ghiChu);
    }
    private FrameChiTietDuAnKinhDoanh parent_duAn;
    //them chi tieu du an
    public ThemChiTieu(FrameChiTietDuAnKinhDoanh parent){
        parent_duAn=parent;
        initComponents();
        this.data=parent.data;
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnOK);
        check=3;
        ngaytxt.setText(today.format(fmt));
    }
    //lấy dữ liệu từ text field
    public void capNhatData(){
        moTa=moTatxt.getText();
        Loai=loaitxt.getSelectedItem().toString();
        ghiChu=ghiChutxt.getText();
        soTien=Double.parseDouble(soTientxt.getText());
        if(thuChi.getSelectedItem().toString().equals("Chi Tiêu")) soTien=0-soTien;
        ngay=LocalDate.parse(ngaytxt.getText(),fmt);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jFrame1 = new javax.swing.JFrame();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jFileChooser1 = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        moTatxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        soTientxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ngaytxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        loaitxt = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ghiChutxt = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        thuChi = new javax.swing.JComboBox<>();

        jMenuItem1.setText("jMenuItem1");

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mô tả ");

        jLabel2.setText("Số tiền");

        soTientxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soTientxtActionPerformed(evt);
            }
        });

        jLabel3.setText("Ngày");

        jLabel4.setText("Loại");

        loaitxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lương", "Thưởng", "Khác" }));

        jLabel5.setText("Ghi chú");

        btnCancel.setText("cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        thuChi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thu Nhập", "Chi Tiêu", " ", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loaitxt, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moTatxt)
                    .addComponent(soTientxt)
                    .addComponent(ngaytxt)
                    .addComponent(ghiChutxt)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 73, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moTatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soTientxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ngaytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loaitxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ghiChutxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thuChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOK))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void soTientxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soTientxtActionPerformed
        btnOK.doClick();
    }//GEN-LAST:event_soTientxtActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if(check==1){   //thêm giao dịch cá nhân
            try{
                capNhatData();
                parent.capNhatBang(Loai, moTa, soTien, ngay.format(fmt), ghiChu);
            }catch(Exception e){
               javax.swing.JOptionPane.showMessageDialog(this, "dữ liệu không hợp lệ");
            }
        }
        else if(check==2){  //sửa giao dịch cá nhân
            try {
                capNhatData();
                parent.capNhatDong(rowPick, Loai, moTa, soTien, ngay.format(fmt), ghiChu);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
            }
        }
        else if(check==3){  //thêm giao dịch dự án
            try{
                capNhatData();
                data.add(new giaoDich(moTa,Loai,ngay.format(fmt),soTien,ghiChu));
                parent_duAn.capNhatAllBang();
            }catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
            }
        }
        else if(check==4){
            capNhatData();
            giaoDich gd=root.data.get(rowPick);
            gd.setLoai(Loai);
            gd.setGhiChu(ghiChu);
            gd.setMoTa(moTa);
            gd.setNgay(ngay);
            gd.setSoTien(soTien);
            root.capNhatAllBang();
        }
        dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
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
//        java.awt.EventQueue.invokeLater(() -> new ThemChiTieu().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField ghiChutxt;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JComboBox<String> loaitxt;
    private javax.swing.JTextField moTatxt;
    private javax.swing.JTextField ngaytxt;
    private javax.swing.JTextField soTientxt;
    private javax.swing.JComboBox<String> thuChi;
    // End of variables declaration//GEN-END:variables
}
