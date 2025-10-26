
package javaqlkd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelBieuDo extends JPanel {
    private String tieuDe;

    public PanelBieuDo(String tieuDe) {
        this.tieuDe = tieuDe;
        setBorder(BorderFactory.createTitledBorder(tieuDe));
        setPreferredSize(new Dimension(400, 300));
    }

    public void capNhatDuLieu(List<?> duLieu) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Biểu đồ: " + tieuDe, 50, 50);
        g.drawString("(Chức năng vẽ biểu đồ sẽ được triển khai chi tiết)", 50, 80);
    }
}
