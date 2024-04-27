package ui;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;

import constant.Types;
import dao.ThongKeServer;
import entity.ThongKe;
import raven.chart.ModelChart;

public class GD_ThongKeDoanhThu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.chart.CurveLineChart chart;
    private raven.panel.PanelShadow panelShadow1;
    private String URL = Types.URL;
    private ThongKeServer tk_dao;
    // End of variables declaration//GEN-END:variables
	
	/**
     * Creates new form Test
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
     */
    public GD_ThongKeDoanhThu(int nam, int thang, int ngay) throws RemoteException, MalformedURLException, NotBoundException {
		setVisible(true);
        initComponents();
        chart.setTitle("THỐNG KÊ DOANH THU");
        chart.addLegend("TỔNG THU", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.addLegend("TỔNG CHI", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("LỢI NHUẬN", Color.decode("#0099F7"), Color.decode("#F11712"));
        test(nam, thang, ngay);
        this.setVisible(true);
    }


    private void test(int nam, int tuThang, int denThang) throws RemoteException, MalformedURLException, NotBoundException{
    	
    	tk_dao = (ThongKeServer) Naming.lookup(URL + ThongKeServer.class.getSimpleName());
        chart.clear();
        for (ThongKe tk : tk_dao.lay_TongThu_TongChi_LoiNhuan_TrongNam(nam, tuThang, denThang)) {
        	System.out.println(tk);
        	chart.addData(new ModelChart("Ngày " + tk.getThang(), new double[]{tk.getTongThu(), tk.getTongChi(), tk.getLoiNhuan()}));
		}
        chart.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new raven.panel.PanelShadow();
        chart = new raven.chart.CurveLineChart();

        panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setColorGradient(new java.awt.Color(17, 38, 47));

        chart.setForeground(new java.awt.Color(237, 237, 237));
        chart.setFillColor(true);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
}
