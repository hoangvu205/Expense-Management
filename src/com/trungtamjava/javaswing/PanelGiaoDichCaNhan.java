
package com.trungtamjava.javaswing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFrame;

public class PanelGiaoDichCaNhan extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PanelGiaoDichCaNhan.class.getName());
    ArrayList<giaoDich> data;
    String name;
    java.sql.Connection conn;
    java.sql.Statement stt;
    Home root;
    public PanelGiaoDichCaNhan(Home a,String name) {
        this.name=name;
        data=a.dataGiaoDichCaNhan;
        root=a;
//        data.forEach(i->{
//            System.out.println(i);
//        });
        initComponents();
        try{
            conn=DatabaseConnection.getConnection();
            stt=conn.createStatement();
        }catch(Exception e){}
        capNhatAllbang();
        // Tô màu nền ô "Loại" dựa theo giá trị cột "Số tiền"
    jTable1.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
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

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }
    ThemChiTieu a;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnXuaGiaoDich = new javax.swing.JButton();
        btnXoaGiaoDich = new javax.swing.JButton();
        btnThemGiaoDich = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem4.setText("jMenuItem4");

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("giao dịch cá nhân");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        btnXuaGiaoDich.setText("Sửa giao dịch");
        btnXuaGiaoDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuaGiaoDichActionPerformed(evt);
            }
        });

        btnXoaGiaoDich.setText("Xoá giao dịch");
        btnXoaGiaoDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGiaoDichActionPerformed(evt);
            }
        });

        btnThemGiaoDich.setText("Thêm giao dịch");
        btnThemGiaoDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGiaoDichActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Lưu");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(btnThemGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuaGiaoDich)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaGiaoDich)
                .addGap(45, 241, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnQuayLai)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnXoaGiaoDich, btnXuaGiaoDich});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnQuayLai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuaGiaoDich)
                    .addComponent(btnXoaGiaoDich)
                    .addComponent(btnThemGiaoDich))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnXoaGiaoDich, btnXuaGiaoDich});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaGiaoDichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGiaoDichActionPerformed
        xoaDongDangChon();
    }//GEN-LAST:event_btnXoaGiaoDichActionPerformed

    private void btnXuaGiaoDichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuaGiaoDichActionPerformed
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một giao dịch để sửa!");
            return;
        }

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        String loai = (String) model.getValueAt(row, 0);
        String moTa = (String) model.getValueAt(row, 1);
        double soTien = (double) model.getValueAt(row, 2);
        String ngay = (String) model.getValueAt(row, 3);
        String ghiChu = (String) model.getValueAt(row, 4);
//        System.out.println(ngay);

        // Mở form sửa có dữ liệu sẵn
        ThemChiTieu formSua = new ThemChiTieu(this, loai, moTa, soTien, ngay, ghiChu, row);
        formSua.setVisible(true);
    }//GEN-LAST:event_btnXuaGiaoDichActionPerformed

    private void btnThemGiaoDichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGiaoDichActionPerformed
        new ThemChiTieu(this).setVisible(true);
    }//GEN-LAST:event_btnThemGiaoDichActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        capNhatSql();
        dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        capNhatSql();
        root.capNhanBangDGGanday();
        dispose();
    }//GEN-LAST:event_formWindowClosing
    public void capNhatSql(){
        String sql1=String.format("delete from giao_dich\n"
        + "where userName='%s' and duAn is null;\n",name);
        String sql2=String.format("insert into giao_dich(userName,loai,moTa,ngay,soTien,ghiChu)\n"
        + "values\n",name);
        for(int j=0;j<data.size();j++){
            giaoDich i=data.get(j);
            sql2+=String.format("('%s','%s','%s','%s',%f,'%s')",
            name,
            i.getLoai(),
            i.getMoTa(),
            i.getNgay(),
            i.getSoTien(),
            i.getGhiChu());
            if(j<data.size()-1) sql2+=",\n";
            else sql2+=";\n";
        }
        try(java.sql.Connection conn=DatabaseConnection.getConnection()){
            java.sql.Statement stt=conn.createStatement();
            stt.executeUpdate(sql1);
            stt.executeUpdate(sql2);

        }catch(Exception e){System.out.println("loi save");}
    }
    
    public void capNhatDong(int row, String loai, String moTa, double soTien, String ngay, String ghiChu) {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.setValueAt(loai, row, 0);
        model.setValueAt(moTa, row, 1);
        model.setValueAt(soTien, row, 2);
        model.setValueAt(ngay, row, 3);
        model.setValueAt(ghiChu, row, 4);
        // cập nhật lại trong danh sách Home
//        if (home != null && row < home.dataGiaoDichCaNhan.size()) {
        giaoDich gd = data.get(row);
        gd.setMoTa(moTa);
        gd.setGhiChu(ghiChu);
        gd.setLoai(loai);
        gd.setSoTien(soTien);
        gd.setNgay(LocalDate.parse(ngay,DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//        }
    }
    public void capNhatAllbang(){
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        data.forEach(i->{
            model.addRow(new Object[]{i.getLoai(), i.getMoTa(), i.soTien, i.getNgay().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), i.getGhiChu()});
        });
    }
    public void capNhatBang(String loai, String moTa, double soTien, String ngay, String ghiChu) {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{loai, moTa, soTien, ngay, ghiChu});
        System.out.println(ngay);
        data.add(new giaoDich(moTa, loai,ngay, soTien,ghiChu));
    }
    public void xoaDongDangChon() {
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một giao dịch để xoá!");
            
            return;
        }
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        data.forEach(i->{
            System.out.println(i);
        });
        model.removeRow(row);
        data.remove(row);

    }

//    public static void main(String args[]) {
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
//        java.awt.EventQueue.invokeLater(() -> new PanelGiaoDichCaNhan().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThemGiaoDich;
    private javax.swing.JButton btnXoaGiaoDich;
    private javax.swing.JButton btnXuaGiaoDich;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
