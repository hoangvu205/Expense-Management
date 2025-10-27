package javaqlkd;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

// Lớp chính của ứng dụng
public class App extends JFrame {
    private JTabbedPane tabbedPane;

    // Dữ liệu
    private List<GiaoDich> danhSachGiaoDichCaNhan;
    private List<DuAnKinhDoanh> danhSachDuAnKinhDoanh;
    private double vonDauTuTong;

    // Các thành phần giao diện
    private JTable bangGiaoDichCaNhan;
    private DefaultTableModel modelBangGiaoDichCaNhan;
    private JTable bangDuAnKinhDoanh;
    private DefaultTableModel modelBangDuAnKinhDoanh;

    // Biểu đồ
    private PanelBieuDo panelBieuDoChiPhi;
    private PanelBieuDo panelBieuDoLoiNhuan;

    // Formatters
    private DecimalFormat dinhDangTienTe;
    private SimpleDateFormat dinhDangNgay;
    private SimpleDateFormat fm=new SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT'XXX yyyy", java.util.Locale.ENGLISH);

    public App() {
        super("Quản lý Chi tiêu Cá nhân & Kinh doanh");

        // Khởi tạo
        khoiTaoDuLieu();
        khoiTaoGiaoDien();
        caiDatSuKien();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dongApp();
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void dongApp(){
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                PrintWriter pw = null;
                try {
//                    Scanner fr=new Scanner(new File("data/dataCaNhan/data.txt"));
                    pw = new PrintWriter(new FileWriter("data/dataCaNhan/dataCaNhan.txt"));
                    for(GiaoDich i:danhSachGiaoDichCaNhan){
//                        System.out.println(i);
                        pw.println(i);
                    }
                } catch (IOException ex) {
                    
                } finally {
                    pw.close();
                }
            }
        });
    }
    
    private void khoiTaoDuLieu() {
        danhSachGiaoDichCaNhan = new ArrayList<>();
        danhSachDuAnKinhDoanh = new ArrayList<>();
        vonDauTuTong = 0;
        dinhDangTienTe = new DecimalFormat("#,###.##");
        dinhDangNgay = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Scanner cinf=new Scanner(new File("data/dataCaNhan/dataCaNhan.txt"));
            while(cinf.hasNextLine()){
                String moTa=cinf.nextLine();
                double tien=cinf.nextDouble();cinf.nextLine();
                String ngayStr=cinf.nextLine();
                String danhMuc=cinf.nextLine();
                String ghiChu=cinf.nextLine();
                Date newNgay=fm.parse(ngayStr);
                danhSachGiaoDichCaNhan.add(new GiaoDich(moTa,tien,newNgay,danhMuc,ghiChu));
            }

        } catch (FileNotFoundException ex) {
            System.getLogger(App.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        catch (ParseException ex) {
            System.getLogger(App.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    private void khoiTaoGiaoDien() {
        // Tạo tabbed pane
        tabbedPane = new JTabbedPane();
        // Thêm các tab
        tabbedPane.addTab("Tổng quan", taoPanelTongQuan());
        tabbedPane.addTab("Chi tiêu cá nhân", taoPanelChiTieuCaNhan());
        tabbedPane.addTab("Dự án kinh doanh", taoPanelDuAnKinhDoanh());
        tabbedPane.addTab("Biểu đồ", taoPanelBieuDo());
        tabbedPane.addTab("Cảnh báo", taoPanelCanhBao());

        add(tabbedPane);
    }

    private JPanel taoPanelTongQuan() {
        JPanel panel = new JPanel(new BorderLayout());

        // Thống kê tổng quan
        JPanel panelThongKe = new JPanel(new GridLayout(2, 4, 10, 10));
        panelThongKe.setBorder(BorderFactory.createTitledBorder("Thống kê tổng quan"));

        double tongThuNhap = tinhTongThuNhap();
        double tongChiTieu = tinhTongChiTieu();
        double loiNhuanTong = tinhLoiNhuanTong();
        double soDuKhaDung = tongThuNhap + tongChiTieu - vonDauTuTong;
        double tyLeChiTieu = tongThuNhap > 0 ? (Math.abs(tongChiTieu) / tongThuNhap) * 100 : 0;
        double tyLeLoiNhuan = vonDauTuTong > 0 ? (loiNhuanTong / vonDauTuTong) * 100 : 0;

        panelThongKe.add(taoTheThongKe("Tổng thu nhập", tongThuNhap, new Color(34, 139, 34))); // Xanh lá
        panelThongKe.add(taoTheThongKe("Tổng chi tiêu", Math.abs(tongChiTieu), new Color(178, 34, 34))); // Đỏ
        panelThongKe.add(taoTheThongKe("Tổng vốn đầu tư", vonDauTuTong, new Color(70, 130, 180))); // Xanh dương
        panelThongKe.add(taoTheThongKe("Tổng lãi/lỗ", loiNhuanTong,
                loiNhuanTong >= 0 ? Color.ORANGE : Color.RED));
        panelThongKe.add(taoTheThongKe("Số dư khả dụng", soDuKhaDung,
                soDuKhaDung >= 0 ? new Color(50, 205, 50) : Color.RED));
        panelThongKe.add(taoTheThongKe("Tỷ lệ chi/tiêu", tyLeChiTieu,
                tyLeChiTieu <= 80 ? Color.ORANGE : Color.RED, "%"));
        panelThongKe.add(taoTheThongKe("Tỷ lệ lợi nhuận", tyLeLoiNhuan,
                tyLeLoiNhuan >= 0 ? new Color(0, 100, 0) : Color.RED, "%"));
        panelThongKe.add(taoTheThongKe("Số dự án", (double)danhSachDuAnKinhDoanh.size(), new Color(128, 0, 128))); // Tím

        panel.add(panelThongKe, BorderLayout.NORTH);

        // Danh sách giao dịch gần đây
        panel.add(taoPanelGiaoDichGanDay(), BorderLayout.CENTER);

        return panel;
    }

    private JPanel taoPanelChiTieuCaNhan() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel chức năng
        JPanel panelChucNang = new JPanel(new FlowLayout());
        JButton btnThemThuNhap = new JButton("Thêm thu nhập");
        JButton btnThemChiTieu = new JButton("Thêm chi tiêu");
        JButton btnSuaGiaoDich = new JButton("Sửa giao dịch");
        JButton btnXoaGiaoDich = new JButton("Xóa giao dịch");
        JButton btnLocTheoThang = new JButton("Lọc theo tháng");

        // Đặt màu cho các nút
        btnThemThuNhap.setBackground(new Color(34, 139, 34)); // Xanh lá
        btnThemThuNhap.setForeground(Color.WHITE);
        btnThemChiTieu.setBackground(new Color(178, 34, 34)); // Đỏ
        btnThemChiTieu.setForeground(Color.WHITE);

        panelChucNang.add(btnThemThuNhap);
        panelChucNang.add(btnThemChiTieu);
        panelChucNang.add(btnSuaGiaoDich);
        panelChucNang.add(btnXoaGiaoDich);
        panelChucNang.add(btnLocTheoThang);

        // Bảng giao dịch
        String[] cotGiaoDich = {"STT", "Loại", "Mô tả", "Số tiền", "Ngày", "Danh mục", "Ghi chú"};
        modelBangGiaoDichCaNhan = new DefaultTableModel(cotGiaoDich, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bangGiaoDichCaNhan = new JTable(modelBangGiaoDichCaNhan);

        // Đặt renderer để hiển thị màu cho cột loại
        bangGiaoDichCaNhan.getColumnModel().getColumn(1).setCellRenderer(new LoaiGiaoDichRenderer());

        capNhatBangGiaoDichCaNhan();

        JScrollPane scrollPane = new JScrollPane(bangGiaoDichCaNhan);

        panel.add(panelChucNang, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Renderer để hiển thị màu cho cột loại giao dịch
    class LoaiGiaoDichRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (value != null && !isSelected) {
                String loai = value.toString();
                if ("Thu nhập".equals(loai)) {
                    c.setBackground(new Color(144, 238, 144)); // Xanh lá nhạt
                    c.setForeground(Color.BLACK);
                } else if ("Chi tiêu".equals(loai)) {
                    c.setBackground(new Color(255, 182, 193)); // Hồng nhạt
                    c.setForeground(Color.BLACK);
                } else if ("Đầu tư".equals(loai)) {
                    c.setBackground(new Color(173, 216, 230)); // Xanh dương nhạt
                    c.setForeground(Color.BLACK);
                }
            }

            if (isSelected) {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
            }

            return c;
        }
    }

    private JPanel taoPanelDuAnKinhDoanh() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel chức năng
        JPanel panelChucNang = new JPanel(new FlowLayout());
        JButton btnThemDuAn = new JButton("Thêm dự án");
        JButton btnThemVonDauTu = new JButton("Thêm vốn đầu tư");
        JButton btnThemGiaoDichDuAn = new JButton("Thêm giao dịch dự án");
        JButton btnXemChiTiet = new JButton("Xem chi tiết dự án");
        JButton btnXoaDuAn = new JButton("Xóa dự án");

        btnThemVonDauTu.setBackground(new Color(70, 130, 180)); // Xanh dương
        btnThemVonDauTu.setForeground(Color.WHITE);

        panelChucNang.add(btnThemDuAn);
        panelChucNang.add(btnThemVonDauTu);
        panelChucNang.add(btnThemGiaoDichDuAn);
        panelChucNang.add(btnXemChiTiet);
        panelChucNang.add(btnXoaDuAn);

        // Bảng dự án
        String[] cotDuAn = {"Tên dự án", "Vốn đầu tư", "Chi phí", "Doanh thu", "Lợi nhuận", "Tổng sau lãi/lỗ", "Tỷ lệ lợi nhuận"};
        modelBangDuAnKinhDoanh = new DefaultTableModel(cotDuAn, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bangDuAnKinhDoanh = new JTable(modelBangDuAnKinhDoanh);

        // Đặt renderer để hiển thị màu cho cột lợi nhuận
        bangDuAnKinhDoanh.getColumnModel().getColumn(4).setCellRenderer(new LoiNhuanRenderer());
        bangDuAnKinhDoanh.getColumnModel().getColumn(5).setCellRenderer(new TongSoRenderer());

        capNhatBangDuAnKinhDoanh();

        JScrollPane scrollPane = new JScrollPane(bangDuAnKinhDoanh);

        panel.add(panelChucNang, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Renderer để hiển thị màu cho cột lợi nhuận
    class LoiNhuanRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (value != null && !isSelected) {
                try {
                    String text = value.toString().replace(" VNĐ", "").replace(",", "");
                    double loiNhuan = Double.parseDouble(text);
                    if (loiNhuan > 0) {
                        c.setBackground(new Color(144, 238, 144)); // Xanh lá nhạt - Lãi
                    } else if (loiNhuan < 0) {
                        c.setBackground(new Color(255, 182, 193)); // Hồng nhạt - Lỗ
                    }
                } catch (NumberFormatException e) {
                    // Không làm gì nếu không parse được số
                }
            }

            if (isSelected) {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
            }

            return c;
        }
    }

    // Renderer để hiển thị màu cho cột tổng số
    class TongSoRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (value != null && !isSelected) {
                try {
                    String text = value.toString().replace(" VNĐ", "").replace(",", "");
                    double tongSo = Double.parseDouble(text);
                    if (tongSo > 0) {
                        c.setBackground(new Color(173, 216, 230)); // Xanh dương nhạt - Dương
                    } else if (tongSo < 0) {
                        c.setBackground(new Color(255, 215, 0)); // Vàng - Âm
                    }
                } catch (NumberFormatException e) {
                    // Không làm gì nếu không parse được số
                }
            }

            if (isSelected) {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
            }

            return c;
        }
    }

    private JPanel taoPanelBieuDo() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        panelBieuDoChiPhi = new PanelBieuDo("Biểu đồ Thu nhập & Chi tiêu");
        panelBieuDoLoiNhuan = new PanelBieuDo("Biểu đồ Lợi nhuận dự án");

        capNhatBieuDo();

        panel.add(panelBieuDoChiPhi);
        panel.add(panelBieuDoLoiNhuan);

        return panel;
    }

    private JPanel taoPanelCanhBao() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textAreaCanhBao = new JTextArea();
        textAreaCanhBao.setEditable(false);

        capNhatCanhBao(textAreaCanhBao);

        JScrollPane scrollPane = new JScrollPane(textAreaCanhBao);
        panel.add(new JLabel("Danh sách cảnh báo:"), BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel taoPanelGiaoDichGanDay() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Giao dịch gần đây"));

        String[] cot = {"Loại", "Mô tả", "Số tiền", "Ngày", "Danh mục"};
        DefaultTableModel model = new DefaultTableModel(cot, 0);
        JTable table = new JTable(model);

        // Sắp xếp giao dịch theo ngày mới nhất
        List<GiaoDich> giaoDichSapXep = new ArrayList<>(danhSachGiaoDichCaNhan);
        giaoDichSapXep.sort((g1, g2) -> g2.getNgay().compareTo(g1.getNgay()));

        // Thêm 5 giao dịch gần nhất
        List<GiaoDich> giaoDichGanDay = giaoDichSapXep.subList(
                0, Math.min(5, giaoDichSapXep.size()));

        for (GiaoDich gd : giaoDichGanDay) {
            String loai = gd.getLoai();
            String danhMuc = gd.getDanhMuc();
            model.addRow(new Object[]{
                    loai,
                    gd.getMoTa(),
                    dinhDangTienTe.format(Math.abs(gd.getSoTien())) + " VNĐ",
                    dinhDangNgay.format(gd.getNgay()),
                    danhMuc
            });
        }

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel taoTheThongKe(String tieuDe, double giaTri, Color mau) {
        return taoTheThongKe(tieuDe, giaTri, mau, " VNĐ");
    }

    private JPanel taoTheThongKe(String tieuDe, double giaTri, Color mau, String donVi) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(mau.brighter());
        panel.setBorder(BorderFactory.createLineBorder(mau.darker(), 2));

        JLabel lblTieuDe = new JLabel(tieuDe, SwingConstants.CENTER);
        String hienThiGiaTri = donVi.equals("%") ?
                String.format("%.1f%s", giaTri, donVi) :
                dinhDangTienTe.format(giaTri) + donVi;
        JLabel lblGiaTri = new JLabel(hienThiGiaTri, SwingConstants.CENTER);

        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 12));
        lblGiaTri.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(lblTieuDe, BorderLayout.NORTH);
        panel.add(lblGiaTri, BorderLayout.CENTER);

        return panel;
    }

    // Các phương thức tính toán
    private double tinhTongThuNhap() {
        return danhSachGiaoDichCaNhan.stream()
                .filter(gd -> gd.getSoTien() > 0 && !"Đầu tư".equals(gd.getDanhMuc()))
                .mapToDouble(GiaoDich::getSoTien)
                .sum();
    }

    private double tinhTongChiTieu() {
        return danhSachGiaoDichCaNhan.stream()
                .filter(gd -> gd.getSoTien() < 0 && !"Đầu tư".equals(gd.getDanhMuc()))
                .mapToDouble(GiaoDich::getSoTien)
                .sum();
    }

    private double tinhTongVonDauTu() {
        return danhSachGiaoDichCaNhan.stream()
                .filter(gd -> "Đầu tư".equals(gd.getDanhMuc()))
                .mapToDouble(gd -> Math.abs(gd.getSoTien()))
                .sum();
    }

    private double tinhLoiNhuanTong() {
        return danhSachDuAnKinhDoanh.stream()
                .mapToDouble(DuAnKinhDoanh::tinhLoiNhuan)
                .sum();
    }

    private void capNhatBangGiaoDichCaNhan() {
        modelBangGiaoDichCaNhan.setRowCount(0);

        int stt = 1;
        for (GiaoDich gd : danhSachGiaoDichCaNhan) {
            String loai = gd.getLoai();
            modelBangGiaoDichCaNhan.addRow(new Object[]{
                    stt++,
                    loai,
                    gd.getMoTa(),
                    dinhDangTienTe.format(Math.abs(gd.getSoTien())) + " VNĐ",
                    dinhDangNgay.format(gd.getNgay()),
                    gd.getDanhMuc(),
                    gd.getGhiChu()
            });
        }
    }

    private void capNhatBangDuAnKinhDoanh() {
        modelBangDuAnKinhDoanh.setRowCount(0);

        for (DuAnKinhDoanh duAn : danhSachDuAnKinhDoanh) {
            double vonDauTu = duAn.getVonDauTu();
            double loiNhuan = duAn.tinhLoiNhuan();
            double tongSoSauLaiLo = vonDauTu + loiNhuan;
            double tyLeLoiNhuan = vonDauTu > 0 ? (loiNhuan / vonDauTu) * 100 : 0;

            modelBangDuAnKinhDoanh.addRow(new Object[]{
                    duAn.getTenDuAn(),
                    dinhDangTienTe.format(vonDauTu) + " VNĐ",
                    dinhDangTienTe.format(Math.abs(duAn.tinhTongChiPhi())) + " VNĐ",
                    dinhDangTienTe.format(duAn.tinhTongThuNhap()) + " VNĐ",
                    dinhDangTienTe.format(loiNhuan) + " VNĐ",
                    dinhDangTienTe.format(tongSoSauLaiLo) + " VNĐ",
                    String.format("%.1f%%", tyLeLoiNhuan)
            });
        }
    }

    private void capNhatBieuDo() {
        panelBieuDoChiPhi.capNhatDuLieu(danhSachGiaoDichCaNhan);
        panelBieuDoLoiNhuan.capNhatDuLieu(danhSachDuAnKinhDoanh);
    }

    private void capNhatCanhBao(JTextArea textArea) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CẢNH BÁO HỆ THỐNG ===\n\n");

        kiemTraChiTieuVuotMuc(sb);
        kiemTraDuAnLo(sb);
        kiemTraDuAnKhongGiaoDich(sb);
        kiemTraSoDuAm(sb);

        if (sb.toString().equals("=== CẢNH BÁO HỆ THỐNG ===\n\n")) {
            sb.append("✅ Không có cảnh báo nào. Mọi thứ đều ổn!\n");
        }

        textArea.setText(sb.toString());
    }

    private void kiemTraChiTieuVuotMuc(StringBuilder sb) {
        double tongChi = Math.abs(tinhTongChiTieu());
        double tongThu = tinhTongThuNhap();

        if (tongThu > 0) {
            double tyLe = (tongChi / tongThu) * 100;
            if (tyLe > 80) {
                sb.append("⚠️ CẢNH BÁO: Chi tiêu đang vượt quá 80% thu nhập!\n");
                sb.append("   - Tổng thu: ").append(dinhDangTienTe.format(tongThu)).append(" VNĐ\n");
                sb.append("   - Tổng chi: ").append(dinhDangTienTe.format(tongChi)).append(" VNĐ\n");
                sb.append("   - Tỷ lệ: ").append(String.format("%.1f", tyLe)).append("%\n\n");
            }
        }
    }

    private void kiemTraDuAnLo(StringBuilder sb) {
        for (DuAnKinhDoanh duAn : danhSachDuAnKinhDoanh) {
            if (duAn.tinhLoiNhuan() < 0) {
                sb.append("⚠️ Dự án '").append(duAn.getTenDuAn()).append("' đang bị lỗ: ")
                        .append(dinhDangTienTe.format(Math.abs(duAn.tinhLoiNhuan()))).append(" VNĐ\n");
            }
        }
        if (danhSachDuAnKinhDoanh.size() > 0) sb.append("\n");
    }

    private void kiemTraDuAnKhongGiaoDich(StringBuilder sb) {
        for (DuAnKinhDoanh duAn : danhSachDuAnKinhDoanh) {
            if (duAn.tongSoGiaoDich() == 0) {
                sb.append("ℹ️ Dự án '").append(duAn.getTenDuAn())
                        .append("' chưa có giao dịch nào\n");
            }
        }
    }

    private void kiemTraSoDuAm(StringBuilder sb) {
        double tongThuNhap = tinhTongThuNhap();
        double tongChiTieu = tinhTongChiTieu();
        double soDuKhaDung = tongThuNhap + tongChiTieu - vonDauTuTong;

        if (soDuKhaDung < 0) {
            sb.append("🚨 CẢNH BÁO NGUY HIỂM: Số dư khả dụng đang âm!\n");
            sb.append("   - Số dư hiện tại: ").append(dinhDangTienTe.format(soDuKhaDung)).append(" VNĐ\n");
            sb.append("   - Cần bổ sung thu nhập hoặc giảm chi tiêu ngay!\n\n");
        }
    }

    private void caiDatSuKien() {
        // Lấy các component từ tab Chi tiêu cá nhân
        JPanel panelChiTieu = (JPanel) tabbedPane.getComponentAt(1);
        JPanel panelChucNang = (JPanel) panelChiTieu.getComponent(0);
        JButton btnThemThuNhap = (JButton) panelChucNang.getComponent(0);
        JButton btnThemChiTieu = (JButton) panelChucNang.getComponent(1);
        JButton btnSuaGiaoDich = (JButton) panelChucNang.getComponent(2);
        JButton btnXoaGiaoDich = (JButton) panelChucNang.getComponent(3);

        // Lấy các component từ tab Dự án kinh doanh
        JPanel panelDuAn = (JPanel) tabbedPane.getComponentAt(2);
        JPanel panelChucNangDuAn = (JPanel) panelDuAn.getComponent(0);
        JButton btnThemDuAn = (JButton) panelChucNangDuAn.getComponent(0);
        JButton btnThemVonDauTu = (JButton) panelChucNangDuAn.getComponent(1);
        JButton btnThemGiaoDichDuAn = (JButton) panelChucNangDuAn.getComponent(2);
        JButton btnXoaDuAn = (JButton) panelChucNangDuAn.getComponent(4);

        // Sự kiện thêm thu nhập
        btnThemThuNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themThuNhapMoi();
            }
        });

        // Sự kiện thêm chi tiêu
        btnThemChiTieu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themChiTieuMoi();
            }
        });

        // Sự kiện sửa giao dịch cá nhân
        btnSuaGiaoDich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suaGiaoDichCaNhan();
            }
        });

        // Sự kiện xóa giao dịch cá nhân
        btnXoaGiaoDich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaGiaoDichCaNhan();
            }
        });

        // Sự kiện thêm dự án
        btnThemDuAn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themDuAnMoi();
            }
        });

        // Sự kiện thêm vốn đầu tư
        btnThemVonDauTu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themVonDauTuMoi();
            }
        });

        // Sự kiện thêm giao dịch dự án
        btnThemGiaoDichDuAn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themGiaoDichDuAn();
            }
        });

        // Sự kiện xóa dự án
        btnXoaDuAn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaDuAn();
            }
        });

        // Sự kiện khi chuyển tab
        tabbedPane.addChangeListener(e -> {
            capNhatToanBoGiaoDien();
        });
    }

    private void themThuNhapMoi() {
        boolean nhapLieuThanhCong = false;

        while (!nhapLieuThanhCong) {
            JTextField txtMoTa = new JTextField();
            JTextField txtSoTien = new JTextField();
            JTextField txtNgay = new JTextField(dinhDangNgay.format(new Date()));
            JComboBox<String> cbDanhMuc = new JComboBox<>(new String[]{
                    "Lương", "Thưởng", "Đầu tư", "Kinh doanh", "Quà tặng", "Khác"
            });
            JTextField txtGhiChu = new JTextField();

            Object[] message = {
                    "Mô tả thu nhập:", txtMoTa,
                    "Số tiền (VNĐ):", txtSoTien,
                    "Ngày (dd/MM/yyyy):", txtNgay,
                    "Danh mục:", cbDanhMuc,
                    "Ghi chú:", txtGhiChu
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Thêm thu nhập mới",
                    JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                try {
                    String moTa = txtMoTa.getText().trim();
//                    if (moTa.isEmpty()) {
//                        JOptionPane.showMessageDialog(this, "Vui lòng nhập mô tả cho thu nhập!",
//                                "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
//                        continue;
//                    }

                    double soTien = Math.abs(Double.parseDouble(txtSoTien.getText())); // Luôn dương
                    Date ngay = dinhDangNgay.parse(txtNgay.getText());
                    String danhMuc = (String) cbDanhMuc.getSelectedItem();
                    String ghiChu = txtGhiChu.getText();

                    GiaoDich giaoDich = new GiaoDich(moTa, soTien, ngay, danhMuc, ghiChu);
                    danhSachGiaoDichCaNhan.add(giaoDich);

                    capNhatToanBoGiaoDien();
                    JOptionPane.showMessageDialog(this, "Thêm thu nhập thành công!");
                    nhapLieuThanhCong = true;

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ! Vui lòng nhập số.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Ngày không hợp lệ! Vui lòng nhập theo định dạng dd/MM/yyyy.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                nhapLieuThanhCong = true;
            }
        }
    }

    private void themChiTieuMoi() {
        boolean nhapLieuThanhCong = false;

        while (!nhapLieuThanhCong) {
            JTextField txtMoTa = new JTextField();
            JTextField txtSoTien = new JTextField();
            JTextField txtNgay = new JTextField(dinhDangNgay.format(new Date()));
            JComboBox<String> cbDanhMuc = new JComboBox<>(new String[]{
                    "Ăn uống", "Di chuyển", "Nhà ở", "Giải trí", "Mua sắm",
                    "Y tế", "Giáo dục", "Hóa đơn", "Khác"
            });
            JTextField txtGhiChu = new JTextField();

            Object[] message = {
                    "Mô tả chi tiêu:", txtMoTa,
                    "Số tiền (VNĐ):", txtSoTien,
                    "Ngày (dd/MM/yyyy):", txtNgay,
                    "Danh mục:", cbDanhMuc,
                    "Ghi chú:", txtGhiChu
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Thêm chi tiêu mới",
                    JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                try {
                    String moTa = txtMoTa.getText().trim();
                    if (moTa.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập mô tả cho chi tiêu!",
                                "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    double soTien = -Math.abs(Double.parseDouble(txtSoTien.getText())); // Luôn âm
                    Date ngay = dinhDangNgay.parse(txtNgay.getText());
                    String danhMuc = (String) cbDanhMuc.getSelectedItem();
                    String ghiChu = txtGhiChu.getText();

                    GiaoDich giaoDich = new GiaoDich(moTa, soTien, ngay, danhMuc, ghiChu);
                    danhSachGiaoDichCaNhan.add(giaoDich);

                    capNhatToanBoGiaoDien();
                    JOptionPane.showMessageDialog(this, "Thêm chi tiêu thành công!");
                    nhapLieuThanhCong = true;

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ! Vui lòng nhập số.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Ngày không hợp lệ! Vui lòng nhập theo định dạng dd/MM/yyyy.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                nhapLieuThanhCong = true;
            }
        }
    }

    private void themVonDauTuMoi() {
        boolean nhapLieuThanhCong = false;

        while (!nhapLieuThanhCong) {
            JTextField txtMoTa = new JTextField();
            JTextField txtSoTien = new JTextField();
            JTextField txtNgay = new JTextField(dinhDangNgay.format(new Date()));
            JComboBox<String> cbDuAn = new JComboBox<>();
            for (DuAnKinhDoanh duAn : danhSachDuAnKinhDoanh) {
                cbDuAn.addItem(duAn.getTenDuAn());
            }
            JTextField txtGhiChu = new JTextField();

            Object[] message = {
                    "Mô tả vốn đầu tư:", txtMoTa,
                    "Số tiền đầu tư (VNĐ):", txtSoTien,
                    "Ngày đầu tư (dd/MM/yyyy):", txtNgay,
                    "Dự án đầu tư:", cbDuAn,
                    "Ghi chú:", txtGhiChu
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Thêm vốn đầu tư mới",
                    JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                try {
                    String moTa = txtMoTa.getText().trim();
                    if (moTa.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập mô tả cho vốn đầu tư!",
                                "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    if (danhSachDuAnKinhDoanh.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Chưa có dự án nào! Vui lòng thêm dự án trước.",
                                "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    double soTien = -Math.abs(Double.parseDouble(txtSoTien.getText())); // Âm vì là chi ra
                    Date ngay = dinhDangNgay.parse(txtNgay.getText());
                    String tenDuAn = (String) cbDuAn.getSelectedItem();
                    String ghiChu = txtGhiChu.getText();

                    // Tìm dự án và cập nhật vốn đầu tư
                    for (DuAnKinhDoanh duAn : danhSachDuAnKinhDoanh) {
                        if (duAn.getTenDuAn().equals(tenDuAn)) {
                            duAn.setVonDauTu(duAn.getVonDauTu() + Math.abs(soTien));
                            break;
                        }
                    }

                    // Thêm giao dịch đầu tư
                    GiaoDich giaoDich = new GiaoDich(moTa, soTien, ngay, "Đầu tư", ghiChu);
                    danhSachGiaoDichCaNhan.add(giaoDich);

                    // Cập nhật tổng vốn đầu tư
                    vonDauTuTong = tinhTongVonDauTu();

                    capNhatToanBoGiaoDien();
                    JOptionPane.showMessageDialog(this, "Thêm vốn đầu tư thành công!");
                    nhapLieuThanhCong = true;

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ! Vui lòng nhập số.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Ngày không hợp lệ! Vui lòng nhập theo định dạng dd/MM/yyyy.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                nhapLieuThanhCong = true;
            }
        }
    }

    private void suaGiaoDichCaNhan() {
        int selectedRow = bangGiaoDichCaNhan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giao dịch cần sửa!");
            return;
        }

        GiaoDich giaoDichCanSua = danhSachGiaoDichCaNhan.get(selectedRow);
        boolean laThuNhap = giaoDichCanSua.getSoTien() > 0;
        boolean laDauTu = "Đầu tư".equals(giaoDichCanSua.getDanhMuc());

        boolean nhapLieuThanhCong = false;

        while (!nhapLieuThanhCong) {
            JTextField txtMoTa = new JTextField(giaoDichCanSua.getMoTa());
            JTextField txtSoTien = new JTextField(String.valueOf(Math.abs(giaoDichCanSua.getSoTien())));
            JTextField txtNgay = new JTextField(dinhDangNgay.format(giaoDichCanSua.getNgay()));

            JComboBox<String> cbDanhMuc;
            if (laDauTu) {
                cbDanhMuc = new JComboBox<>(new String[]{"Đầu tư"});
            } else if (laThuNhap) {
                cbDanhMuc = new JComboBox<>(new String[]{
                        "Lương", "Thưởng", "Đầu tư", "Kinh doanh", "Quà tặng", "Khác"
                });
            } else {
                cbDanhMuc = new JComboBox<>(new String[]{
                        "Ăn uống", "Di chuyển", "Nhà ở", "Giải trí", "Mua sắm",
                        "Y tế", "Giáo dục", "Hóa đơn", "Khác"
                });
            }
            cbDanhMuc.setSelectedItem(giaoDichCanSua.getDanhMuc());

            JTextField txtGhiChu = new JTextField(giaoDichCanSua.getGhiChu());

            String tieuDe = laDauTu ? "Sửa vốn đầu tư" : (laThuNhap ? "Sửa thu nhập" : "Sửa chi tiêu");

            Object[] message = {
                    "Mô tả:", txtMoTa,
                    "Số tiền (VNĐ):", txtSoTien,
                    "Ngày (dd/MM/yyyy):", txtNgay,
                    "Danh mục:", cbDanhMuc,
                    "Ghi chú:", txtGhiChu
            };

            int option = JOptionPane.showConfirmDialog(this, message, tieuDe,
                    JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                try {
                    String moTa = txtMoTa.getText().trim();
                    if (moTa.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập mô tả!",
                                "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    double soTien = Double.parseDouble(txtSoTien.getText());
                    if (laDauTu || !laThuNhap) {
                        soTien = -soTien; // Chuyển thành số âm cho đầu tư và chi tiêu
                    }

                    Date ngay = dinhDangNgay.parse(txtNgay.getText());
                    String danhMuc = (String) cbDanhMuc.getSelectedItem();
                    String ghiChu = txtGhiChu.getText();

                    // Cập nhật thông tin giao dịch
                    double soTienCu = giaoDichCanSua.getSoTien();
                    giaoDichCanSua.setMoTa(moTa);
                    giaoDichCanSua.setSoTien(soTien);
                    giaoDichCanSua.setNgay(ngay);
                    giaoDichCanSua.setDanhMuc(danhMuc);
                    giaoDichCanSua.setGhiChu(ghiChu);

                    // Nếu là giao dịch đầu tư, cập nhật tổng vốn
                    if ("Đầu tư".equals(danhMuc)) {
                        vonDauTuTong = tinhTongVonDauTu();
                    }

                    capNhatToanBoGiaoDien();
                    JOptionPane.showMessageDialog(this, "Sửa giao dịch thành công!");
                    nhapLieuThanhCong = true;

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ! Vui lòng nhập số.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Ngày không hợp lệ! Vui lòng nhập theo định dạng dd/MM/yyyy.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                nhapLieuThanhCong = true;
            }
        }
    }

    private void xoaGiaoDichCaNhan() {
        int selectedRow = bangGiaoDichCaNhan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giao dịch cần xóa!");
            return;
        }

        GiaoDich giaoDichCanXoa = danhSachGiaoDichCaNhan.get(selectedRow);
        boolean laDauTu = "Đầu tư".equals(giaoDichCanXoa.getDanhMuc());

        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn xóa giao dịch này?", "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Nếu là giao dịch đầu tư, cần xử lý đặc biệt
            if (laDauTu) {
                // Tìm và cập nhật vốn đầu tư của dự án liên quan
                // (Trong thực tế cần có cơ chế mapping giữa giao dịch đầu tư và dự án)
                JOptionPane.showMessageDialog(this,
                        "Giao dịch đầu tư đã được xóa. Lưu ý: Vốn đầu tư của dự án cần được điều chỉnh thủ công.",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

            danhSachGiaoDichCaNhan.remove(selectedRow);
            vonDauTuTong = tinhTongVonDauTu();
            capNhatToanBoGiaoDien();
            JOptionPane.showMessageDialog(this, "Xóa giao dịch thành công!");
        }
    }

    // Các phương thức khác giữ nguyên
    private void themDuAnMoi() {
        boolean nhapLieuThanhCong = false;

        while (!nhapLieuThanhCong) {
            JTextField txtTenDuAn = new JTextField();
            JTextField txtVonDauTu = new JTextField("0");
            JTextField txtChiPhiDuKien = new JTextField("0");
            JTextField txtMucTieuLoiNhuan = new JTextField("0");

            Object[] message = {
                    "Tên dự án:", txtTenDuAn,
                    "Vốn đầu tư ban đầu (VNĐ):", txtVonDauTu,
                    "Chi phí dự kiến (VNĐ):", txtChiPhiDuKien,
                    "Mục tiêu lợi nhuận (VNĐ):", txtMucTieuLoiNhuan
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Thêm dự án mới",
                    JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                try {
                    String tenDuAn = txtTenDuAn.getText().trim();
                    if (tenDuAn.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập tên dự án!",
                                "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    double vonDauTu = Double.parseDouble(txtVonDauTu.getText());
                    double chiPhiDuKien = Double.parseDouble(txtChiPhiDuKien.getText());
                    double mucTieuLoiNhuan = Double.parseDouble(txtMucTieuLoiNhuan.getText());

                    DuAnKinhDoanh duAn = new DuAnKinhDoanh(tenDuAn, vonDauTu, chiPhiDuKien, mucTieuLoiNhuan);
                    danhSachDuAnKinhDoanh.add(duAn);

                    capNhatToanBoGiaoDien();
                    JOptionPane.showMessageDialog(this, "Thêm dự án thành công!");
                    nhapLieuThanhCong = true;

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Dữ liệu nhập không hợp lệ! Vui lòng kiểm tra lại.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                nhapLieuThanhCong = true;
            }
        }
    }

    private void themGiaoDichDuAn() {
        if (danhSachDuAnKinhDoanh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa có dự án nào! Vui lòng thêm dự án trước.");
            return;
        }

        boolean nhapLieuThanhCong = false;

        while (!nhapLieuThanhCong) {
            // Chọn dự án
            String[] tenDuAn = danhSachDuAnKinhDoanh.stream()
                    .map(DuAnKinhDoanh::getTenDuAn)
                    .toArray(String[]::new);

            JComboBox<String> cbDuAn = new JComboBox<>(tenDuAn);
            JTextField txtMoTa = new JTextField();
            JTextField txtSoTien = new JTextField();
            JTextField txtNgay = new JTextField(dinhDangNgay.format(new Date()));
            JComboBox<String> cbLoai = new JComboBox<>(new String[]{"Thu nhập", "Chi phí"});
            JTextField txtGhiChu = new JTextField();

            Object[] message = {
                    "Chọn dự án:", cbDuAn,
                    "Mô tả:", txtMoTa,
                    "Số tiền (VNĐ):", txtSoTien,
                    "Ngày (dd/MM/yyyy):", txtNgay,
                    "Loại giao dịch:", cbLoai,
                    "Ghi chú:", txtGhiChu
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Thêm giao dịch dự án",
                    JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                try {
                    int selectedIndex = cbDuAn.getSelectedIndex();
                    DuAnKinhDoanh duAn = danhSachDuAnKinhDoanh.get(selectedIndex);

                    String moTa = txtMoTa.getText().trim();
                    if (moTa.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập mô tả cho giao dịch!",
                                "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    double soTien = Double.parseDouble(txtSoTien.getText());
                    Date ngay = dinhDangNgay.parse(txtNgay.getText());
                    String loai = (String) cbLoai.getSelectedItem();
                    String ghiChu = txtGhiChu.getText();

                    // Điều chỉnh số tiền theo loại
                    if ("Chi phí".equals(loai)) {
                        soTien = -Math.abs(soTien);
                    }

                    duAn.themGiaoDich(moTa, soTien, ngay, ghiChu);

                    capNhatToanBoGiaoDien();
                    JOptionPane.showMessageDialog(this, "Thêm giao dịch dự án thành công!");
                    nhapLieuThanhCong = true;

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ! Vui lòng nhập số.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Dữ liệu nhập không hợp lệ! Vui lòng kiểm tra lại.",
                            "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                nhapLieuThanhCong = true;
            }
        }
    }

    private void xoaDuAn() {
        int selectedRow = bangDuAnKinhDoanh.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dự án cần xóa!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn xóa dự án này? Tất cả giao dịch liên quan sẽ bị xóa!",
                "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            danhSachDuAnKinhDoanh.remove(selectedRow);
            capNhatToanBoGiaoDien();
            JOptionPane.showMessageDialog(this, "Xóa dự án thành công!");
        }
    }

    private void capNhatToanBoGiaoDien() {
        capNhatBangGiaoDichCaNhan();
        capNhatBangDuAnKinhDoanh();
        capNhatBieuDo();

        // Cập nhật tab cảnh báo
        JPanel panelCanhBao = (JPanel) tabbedPane.getComponentAt(4);
        JScrollPane scrollPane = (JScrollPane) panelCanhBao.getComponent(1);
        JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
        capNhatCanhBao(textArea);

        // Cập nhật tab tổng quan
        tabbedPane.setComponentAt(0, taoPanelTongQuan());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App();
        });
    }
}



// Lớp Dự án Kinh doanh

// Lớp Panel Biểu đồ
