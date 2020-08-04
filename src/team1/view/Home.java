package team1.view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import keeptoo.KButton;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import team1.controller.KasirController;
import team1.controller.UserController;
import team1.model.Koneksi;
import team1.model.dao.DetTransDao;
import team1.model.dao.GetFreeDao;
import team1.model.dao.ProductDao;
import team1.model.dao.ProfitDao;
import team1.model.dao.PromoDao;
import team1.model.dao.UserDao;
import team1.resources.ConfigApp;

public class Home extends javax.swing.JFrame {
    KasirController kasirController;
    
    private String nama, user, level;
    UserController uc;
    ConfigApp cf;
    Connection con;
    
    String upOrAd = "";
    int diskon=0;
    int diskonx=0;
    int bnyk =0;
    int maxDis=0;
    int subtotal=0;
    int totModal=0;
    int kbalian=0;
    int total=0;
    int lots=0;
    String idPromox="";
    String tipePromo="";
    String nmPromo="";
    String idTrans="";
    public int freelots=0;
    
    /** Creates new form LoginScreen */
    CardLayout cardLayout;
    public Home() {
        initComponents();
        getContentPane().setBackground(Color.BLACK);
        Component [] components = this.getContentPane().getComponents();
        for(Component component : components){
            if(component instanceof KButton){
                ((KButton)component).setUI(new BasicButtonUI());
                ((KButton)component).setFocusPainted(false); 
            }
        }
        cardLayout = (CardLayout)(cardLay.getLayout());
        kasirController = new KasirController(this);
        cf = new ConfigApp();
        cf.readConfig();
        user=cf.getUnameAkun();
        nama=cf.getNameAkun();
        level=cf.getLevelAkun();
        staring();
        jRadioButton2.setSelected(true);
        showHideFree();
        loadDesign();
    }
    
    
    public JTable getTblDash() {
        return tblDash;
    }

    public JLabel getLbl2WidDash1() {
        return lbl2WidDash1;
    }

    public JTable getTblGetFree() {
        return tblGetFree;
    }

    public void setTblGetFree(JTable tblGetFree) {
        this.tblGetFree = tblGetFree;
    }

    public JTable getTblGetTrans() {
        return tblGetTrans;
    }

    public void setTblGetTrans(JTable tblGetTrans) {
        this.tblGetTrans = tblGetTrans;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JButton getjButton1() {
        return jButton1;
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHideUname = new javax.swing.JLabel();
        bGTpPromo = new javax.swing.ButtonGroup();
        bgLvl = new javax.swing.ButtonGroup();
        bgJk = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jPanel2 = new javax.swing.JPanel();
        jFotoPeg = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        kButton11 = new keeptoo.KButton();
        btnSideDash = new keeptoo.KButton();
        btnSideTrans = new keeptoo.KButton();
        btnSideRiwayat = new keeptoo.KButton();
        btnSideDBarang = new keeptoo.KButton();
        btnSideDPromo = new keeptoo.KButton();
        btnSideLap = new keeptoo.KButton();
        btnSidePeg = new keeptoo.KButton();
        btnSideSettings = new keeptoo.KButton();
        btnSideExit = new keeptoo.KButton();
        cardLay = new javax.swing.JPanel();
        j_dashboard = new javax.swing.JPanel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNmTokoDash = new javax.swing.JLabel();
        lblAdrrTokoDash = new javax.swing.JLabel();
        btnUbahToko = new keeptoo.KButton();
        pnlWidDash1 = new keeptoo.KGradientPanel();
        lbl1WidDash1 = new javax.swing.JLabel();
        lbl2WidDash1 = new javax.swing.JLabel();
        pnlWidDash2 = new keeptoo.KGradientPanel();
        lbl1WidDash2 = new javax.swing.JLabel();
        lbl2WidDash2 = new javax.swing.JLabel();
        pnlWidDash3 = new keeptoo.KGradientPanel();
        lbl1WidDash3 = new javax.swing.JLabel();
        lbl2WidDash3 = new javax.swing.JLabel();
        lblTblDash = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDash = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        j_transaksi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSrSptPTrans = new javax.swing.JTextField();
        btnSrSptPTrans1 = new keeptoo.KButton();
        btnSrSptPTrans = new keeptoo.KButton();
        jPanel4 = new javax.swing.JPanel();
        lblSptTrans = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtJmltrns = new javax.swing.JTextField();
        kButton6 = new keeptoo.KButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSptTrans = new javax.swing.JTable();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jLabel15 = new javax.swing.JLabel();
        kButton4 = new keeptoo.KButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBeli = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lSubTOtal = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblDiskon = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblGetTrans = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        kembalian = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        kButton7 = new keeptoo.KButton();
        kButton8 = new keeptoo.KButton();
        jPanel12 = new javax.swing.JPanel();
        j_riwayat = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        kButton1 = new keeptoo.KButton();
        j_databarang = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        btn_transaksi2 = new keeptoo.KButton();
        btn_transaksi3 = new keeptoo.KButton();
        jTextField2 = new javax.swing.JTextField();
        btn_transaksi4 = new keeptoo.KButton();
        kButton12 = new keeptoo.KButton();
        j_dataPromo = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblPromoMng = new javax.swing.JTable();
        btn_transaksi5 = new keeptoo.KButton();
        btn_transaksi6 = new keeptoo.KButton();
        jTextField3 = new javax.swing.JTextField();
        btn_transaksi7 = new keeptoo.KButton();
        kButton13 = new keeptoo.KButton();
        j_dataPegawai = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        btn_transaksi8 = new keeptoo.KButton();
        btn_transaksi9 = new keeptoo.KButton();
        jTextField4 = new javax.swing.JTextField();
        btn_transaksi10 = new keeptoo.KButton();
        kButton14 = new keeptoo.KButton();
        btn_transaksi12 = new keeptoo.KButton();
        j_adSepatu = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtIDSepatu = new javax.swing.JTextField();
        txtUname1 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtUname2 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtUname3 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtUname4 = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtUname5 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtUname6 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        txtUname7 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        btnSideTrans2 = new keeptoo.KButton();
        btnSideTrans3 = new keeptoo.KButton();
        j_adPromo = new javax.swing.JPanel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jdlAdPromo = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtField1 = new javax.swing.JTextField();
        txtField2 = new javax.swing.JTextField();
        jSeparator27 = new javax.swing.JSeparator();
        txtField4 = new javax.swing.JTextField();
        jSeparator29 = new javax.swing.JSeparator();
        txtField5 = new javax.swing.JTextField();
        jSeparator30 = new javax.swing.JSeparator();
        txtField6 = new javax.swing.JTextField();
        jSeparator31 = new javax.swing.JSeparator();
        txtField7 = new javax.swing.JTextField();
        jSeparator33 = new javax.swing.JSeparator();
        txtField8 = new javax.swing.JTextField();
        jSeparator34 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        btnSideTrans6 = new keeptoo.KButton();
        btnSideTrans7 = new keeptoo.KButton();
        jPanel13 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGetFree = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        j_adPegawai = new javax.swing.JPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        rbKasir = new javax.swing.JRadioButton();
        rbInvenori = new javax.swing.JRadioButton();
        txtIDSepatu1 = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        txtUname16 = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        btnSideTrans4 = new keeptoo.KButton();
        btnSideTrans5 = new keeptoo.KButton();
        jLabel56 = new javax.swing.JLabel();
        rbPerempuan = new javax.swing.JRadioButton();
        rbLaki = new javax.swing.JRadioButton();
        j_Settings = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtUname8 = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        txtUname9 = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        txtUname10 = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        txtUname11 = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        txtUname12 = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        txtUname13 = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        txtUname14 = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jPanel15 = new javax.swing.JPanel();
        btnSideTrans8 = new keeptoo.KButton();
        j_Laporan = new javax.swing.JPanel();
        kGradientPanel10 = new keeptoo.KGradientPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        btnSideTrans11 = new keeptoo.KButton();
        btnSideTrans12 = new keeptoo.KButton();
        btnSideTrans13 = new keeptoo.KButton();
        btnSideTrans14 = new keeptoo.KButton();
        panelMyChart = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        lblHideUname.setText("backup id");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SHOES CASHIER");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1300, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jSplitPane1.setBackground(new java.awt.Color(0, 0, 0));
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1300, 700));

        jPanel1.setBackground(new java.awt.Color(106, 106, 106));
        jPanel1.setPreferredSize(new java.awt.Dimension(233, 700));

        kGradientPanel5.setBackground(new java.awt.Color(33, 152, 92));
        kGradientPanel5.setkBorderRadius(0);
        kGradientPanel5.setkEndColor(new java.awt.Color(33, 152, 92));
        kGradientPanel5.setkStartColor(new java.awt.Color(33, 152, 92));
        kGradientPanel5.setPreferredSize(new java.awt.Dimension(230, 700));

        jPanel2.setBackground(new java.awt.Color(48, 204, 126));

        jFotoPeg.setForeground(new java.awt.Color(255, 255, 255));
        jFotoPeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconBrandStore.png"))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Raja Sepatu");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Jl.Jendral Sudirman No.9");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("admin ");

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("kasir");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        kButton11.setText("Ganti Password");
        kButton11.setAlignmentY(0.0F);
        kButton11.setHideActionText(true);
        kButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kButton11.setIconTextGap(25);
        kButton11.setkBorderRadius(0);
        kButton11.setkEndColor(new java.awt.Color(42, 133, 88));
        kButton11.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        kButton11.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton11.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        kButton11.setkIndicatorThickness(0);
        kButton11.setkPressedColor(new java.awt.Color(204, 204, 204));
        kButton11.setkSelectedColor(new java.awt.Color(0, 102, 51));
        kButton11.setkStartColor(new java.awt.Color(42, 133, 88));
        kButton11.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kButton11.setMaximumSize(new java.awt.Dimension(67, 37));
        kButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jFotoPeg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFotoPeg)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)))
                .addGap(2, 2, 2)
                .addComponent(kButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addContainerGap())
        );

        btnSideDash.setBackground(new java.awt.Color(33, 152, 92));
        btnSideDash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconHome.png"))); // NOI18N
        btnSideDash.setText("     Dashboard          ");
        btnSideDash.setToolTipText("");
        btnSideDash.setAlignmentY(0.0F);
        btnSideDash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideDash.setHideActionText(true);
        btnSideDash.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideDash.setIconTextGap(25);
        btnSideDash.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideDash.setkBorderRadius(0);
        btnSideDash.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideDash.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideDash.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideDash.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideDash.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideDash.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideDash.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideDash.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideDash.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideDash.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideDash.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideDash.setSelected(true);
        btnSideDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideDashActionPerformed(evt);
            }
        });

        btnSideTrans.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconTrans.png"))); // NOI18N
        btnSideTrans.setText("      Transaksi              ");
        btnSideTrans.setToolTipText("");
        btnSideTrans.setAlignmentY(0.0F);
        btnSideTrans.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans.setHideActionText(true);
        btnSideTrans.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans.setIconTextGap(25);
        btnSideTrans.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans.setkBorderRadius(0);
        btnSideTrans.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTransActionPerformed(evt);
            }
        });

        btnSideRiwayat.setBackground(new java.awt.Color(33, 152, 92));
        btnSideRiwayat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconPayment.png"))); // NOI18N
        btnSideRiwayat.setText("       Riwayat Transaksi");
        btnSideRiwayat.setToolTipText("");
        btnSideRiwayat.setAlignmentY(0.0F);
        btnSideRiwayat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideRiwayat.setHideActionText(true);
        btnSideRiwayat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideRiwayat.setIconTextGap(25);
        btnSideRiwayat.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideRiwayat.setkBorderRadius(0);
        btnSideRiwayat.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideRiwayat.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideRiwayat.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideRiwayat.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideRiwayat.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideRiwayat.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideRiwayat.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideRiwayat.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideRiwayat.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideRiwayat.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideRiwayat.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideRiwayatActionPerformed(evt);
            }
        });

        btnSideDBarang.setBackground(new java.awt.Color(33, 152, 92));
        btnSideDBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconWarehouse.png"))); // NOI18N
        btnSideDBarang.setText("Data Barang  ");
        btnSideDBarang.setToolTipText("");
        btnSideDBarang.setAlignmentY(0.0F);
        btnSideDBarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideDBarang.setHideActionText(true);
        btnSideDBarang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideDBarang.setIconTextGap(25);
        btnSideDBarang.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideDBarang.setkBorderRadius(0);
        btnSideDBarang.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideDBarang.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideDBarang.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideDBarang.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideDBarang.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideDBarang.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideDBarang.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideDBarang.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideDBarang.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideDBarang.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideDBarang.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideDBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideDBarangActionPerformed(evt);
            }
        });

        btnSideDPromo.setBackground(new java.awt.Color(33, 152, 92));
        btnSideDPromo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconPromo.png"))); // NOI18N
        btnSideDPromo.setText("Data Promo  ");
        btnSideDPromo.setToolTipText("");
        btnSideDPromo.setAlignmentY(0.0F);
        btnSideDPromo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideDPromo.setHideActionText(true);
        btnSideDPromo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideDPromo.setIconTextGap(25);
        btnSideDPromo.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideDPromo.setkBorderRadius(0);
        btnSideDPromo.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideDPromo.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideDPromo.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideDPromo.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideDPromo.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideDPromo.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideDPromo.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideDPromo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideDPromo.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideDPromo.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideDPromo.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideDPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideDPromoActionPerformed(evt);
            }
        });

        btnSideLap.setBackground(new java.awt.Color(33, 152, 92));
        btnSideLap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconReport.png"))); // NOI18N
        btnSideLap.setText("        Laporan Penjualan");
        btnSideLap.setToolTipText("");
        btnSideLap.setAlignmentY(0.0F);
        btnSideLap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideLap.setHideActionText(true);
        btnSideLap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideLap.setIconTextGap(25);
        btnSideLap.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideLap.setkBorderRadius(0);
        btnSideLap.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideLap.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideLap.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideLap.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideLap.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideLap.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideLap.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideLap.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideLap.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideLap.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideLap.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideLapActionPerformed(evt);
            }
        });

        btnSidePeg.setBackground(new java.awt.Color(33, 152, 92));
        btnSidePeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconUsers.png"))); // NOI18N
        btnSidePeg.setText("Data Pegawai");
        btnSidePeg.setToolTipText("");
        btnSidePeg.setAlignmentY(0.0F);
        btnSidePeg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSidePeg.setHideActionText(true);
        btnSidePeg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSidePeg.setIconTextGap(25);
        btnSidePeg.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSidePeg.setkBorderRadius(0);
        btnSidePeg.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSidePeg.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSidePeg.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSidePeg.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSidePeg.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSidePeg.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSidePeg.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSidePeg.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSidePeg.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSidePeg.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSidePeg.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSidePeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSidePegActionPerformed(evt);
            }
        });

        btnSideSettings.setBackground(new java.awt.Color(33, 152, 92));
        btnSideSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconSetting.png"))); // NOI18N
        btnSideSettings.setText("  Settings           ");
        btnSideSettings.setToolTipText("");
        btnSideSettings.setAlignmentY(0.0F);
        btnSideSettings.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideSettings.setHideActionText(true);
        btnSideSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideSettings.setIconTextGap(25);
        btnSideSettings.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideSettings.setkBorderRadius(0);
        btnSideSettings.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideSettings.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideSettings.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideSettings.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideSettings.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideSettings.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideSettings.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideSettings.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideSettings.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideSettings.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideSettings.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideSettingsActionPerformed(evt);
            }
        });

        btnSideExit.setBackground(new java.awt.Color(33, 152, 92));
        btnSideExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconLogout.png"))); // NOI18N
        btnSideExit.setText("Keluar           ");
        btnSideExit.setToolTipText("");
        btnSideExit.setAlignmentY(0.0F);
        btnSideExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideExit.setHideActionText(true);
        btnSideExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideExit.setIconTextGap(25);
        btnSideExit.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideExit.setkBorderRadius(0);
        btnSideExit.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideExit.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideExit.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideExit.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideExit.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideExit.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideExit.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideExit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideExit.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideExit.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideExit.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSideDash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideTrans, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideDBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideLap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideDPromo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideSettings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideRiwayat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSidePeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnSideDash, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSideTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSideRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSideDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSideDPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSideLap, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSidePeg, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSideSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSideExit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        cardLay.setBackground(new java.awt.Color(81, 81, 81));
        cardLay.setPreferredSize(new java.awt.Dimension(900, 700));
        cardLay.setLayout(new java.awt.CardLayout());

        j_dashboard.setBackground(new java.awt.Color(37, 37, 37));
        j_dashboard.setPreferredSize(new java.awt.Dimension(900, 700));

        kGradientPanel7.setBackground(new java.awt.Color(37, 37, 37));
        kGradientPanel7.setkBorderRadius(15);
        kGradientPanel7.setkEndColor(new java.awt.Color(153, 255, 255));
        kGradientPanel7.setkFillBackground(false);
        kGradientPanel7.setkGradientFocus(300);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconBrandStore.png"))); // NOI18N

        lblNmTokoDash.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNmTokoDash.setForeground(new java.awt.Color(255, 255, 255));
        lblNmTokoDash.setText("Raja Sepatu");

        lblAdrrTokoDash.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAdrrTokoDash.setForeground(new java.awt.Color(255, 255, 255));
        lblAdrrTokoDash.setText("Jl.Jendral Sudirman No.9");

        btnUbahToko.setText("Refresh");
        btnUbahToko.setkBackGroundColor(new java.awt.Color(0, 172, 172));
        btnUbahToko.setkEndColor(new java.awt.Color(0, 172, 172));
        btnUbahToko.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btnUbahToko.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnUbahToko.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btnUbahToko.setkPressedColor(new java.awt.Color(0, 172, 172));
        btnUbahToko.setkSelectedColor(new java.awt.Color(0, 172, 172));
        btnUbahToko.setkStartColor(new java.awt.Color(0, 172, 172));
        btnUbahToko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahTokoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel7Layout = new javax.swing.GroupLayout(kGradientPanel7);
        kGradientPanel7.setLayout(kGradientPanel7Layout);
        kGradientPanel7Layout.setHorizontalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdrrTokoDash, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(lblNmTokoDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(252, 252, 252)
                .addComponent(btnUbahToko, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        kGradientPanel7Layout.setVerticalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUbahToko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                                .addComponent(lblNmTokoDash)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAdrrTokoDash))))
                    .addGroup(kGradientPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlWidDash1.setBackground(new java.awt.Color(37, 37, 37));
        pnlWidDash1.setkBorderRadius(20);
        pnlWidDash1.setkEndColor(new java.awt.Color(128, 242, 252));
        pnlWidDash1.setkGradientFocus(300);
        pnlWidDash1.setkStartColor(new java.awt.Color(25, 151, 162));

        lbl1WidDash1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl1WidDash1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1WidDash1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1WidDash1.setText("PENJUALAN HARI INI");

        lbl2WidDash1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl2WidDash1.setForeground(new java.awt.Color(255, 255, 255));
        lbl2WidDash1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2WidDash1.setText("12");

        javax.swing.GroupLayout pnlWidDash1Layout = new javax.swing.GroupLayout(pnlWidDash1);
        pnlWidDash1.setLayout(pnlWidDash1Layout);
        pnlWidDash1Layout.setHorizontalGroup(
            pnlWidDash1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl1WidDash1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            .addComponent(lbl2WidDash1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlWidDash1Layout.setVerticalGroup(
            pnlWidDash1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWidDash1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl1WidDash1)
                .addGap(18, 18, 18)
                .addComponent(lbl2WidDash1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnlWidDash2.setBackground(new java.awt.Color(37, 37, 37));
        pnlWidDash2.setkBorderRadius(20);
        pnlWidDash2.setkEndColor(new java.awt.Color(246, 233, 64));
        pnlWidDash2.setkGradientFocus(300);
        pnlWidDash2.setkStartColor(new java.awt.Color(208, 199, 53));

        lbl1WidDash2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl1WidDash2.setForeground(new java.awt.Color(255, 255, 255));
        lbl1WidDash2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1WidDash2.setText("UANG MASUK HARI INI");

        lbl2WidDash2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl2WidDash2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2WidDash2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2WidDash2.setText("Rp.33.750.000,00");

        javax.swing.GroupLayout pnlWidDash2Layout = new javax.swing.GroupLayout(pnlWidDash2);
        pnlWidDash2.setLayout(pnlWidDash2Layout);
        pnlWidDash2Layout.setHorizontalGroup(
            pnlWidDash2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl1WidDash2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            .addComponent(lbl2WidDash2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlWidDash2Layout.setVerticalGroup(
            pnlWidDash2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWidDash2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl1WidDash2)
                .addGap(18, 18, 18)
                .addComponent(lbl2WidDash2)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pnlWidDash3.setBackground(new java.awt.Color(37, 37, 37));
        pnlWidDash3.setkBorderRadius(20);
        pnlWidDash3.setkEndColor(new java.awt.Color(251, 190, 111));
        pnlWidDash3.setkGradientFocus(300);
        pnlWidDash3.setkStartColor(new java.awt.Color(255, 51, 51));

        lbl1WidDash3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl1WidDash3.setForeground(new java.awt.Color(255, 255, 255));
        lbl1WidDash3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1WidDash3.setText("BARANG HABIS");

        lbl2WidDash3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl2WidDash3.setForeground(new java.awt.Color(255, 255, 255));
        lbl2WidDash3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2WidDash3.setText("2");

        javax.swing.GroupLayout pnlWidDash3Layout = new javax.swing.GroupLayout(pnlWidDash3);
        pnlWidDash3.setLayout(pnlWidDash3Layout);
        pnlWidDash3Layout.setHorizontalGroup(
            pnlWidDash3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl1WidDash3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            .addComponent(lbl2WidDash3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlWidDash3Layout.setVerticalGroup(
            pnlWidDash3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlWidDash3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl1WidDash3)
                .addGap(18, 18, 18)
                .addComponent(lbl2WidDash3)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        lblTblDash.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTblDash.setForeground(new java.awt.Color(255, 255, 255));
        lblTblDash.setText("Transaksi Terakhir");

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Semua Transaksi");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconNext.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        kGradientPanel4.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        kGradientPanel4.setkBorderRadius(0);
        kGradientPanel4.setkFillBackground(false);

        tblDash = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblDash.setAutoCreateRowSorter(true);
        tblDash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblDash.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MERK", "TYPE", "HARGA", "WAKTU"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDash.setToolTipText("");
        tblDash.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblDash.setGridColor(new java.awt.Color(255, 255, 255));
        tblDash.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblDash.setOpaque(false);
        tblDash.setRowHeight(25);
        tblDash.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tblDash.setShowHorizontalLines(false);
        tblDash.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tblDash);
        if (tblDash.getColumnModel().getColumnCount() > 0) {
            tblDash.getColumnModel().getColumn(2).setResizable(false);
            tblDash.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(37, 37, 37));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout j_dashboardLayout = new javax.swing.GroupLayout(j_dashboard);
        j_dashboard.setLayout(j_dashboardLayout);
        j_dashboardLayout.setHorizontalGroup(
            j_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_dashboardLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(j_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addGroup(j_dashboardLayout.createSequentialGroup()
                        .addComponent(pnlWidDash1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(pnlWidDash2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(pnlWidDash3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addGroup(j_dashboardLayout.createSequentialGroup()
                        .addComponent(lblTblDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)))
                .addGap(25, 25, 25))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        j_dashboardLayout.setVerticalGroup(
            j_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_dashboardLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(kGradientPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(j_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlWidDash3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlWidDash2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlWidDash1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(j_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTblDash)
                    .addComponent(jLabel14)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardLay.add(j_dashboard, "cardDashBoard");

        j_transaksi.setBackground(new java.awt.Color(37, 37, 37));
        j_transaksi.setPreferredSize(new java.awt.Dimension(776, 700));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pembelian");

        txtSrSptPTrans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSrSptPTransKeyReleased(evt);
            }
        });

        btnSrSptPTrans1.setText("Cari");
        btnSrSptPTrans1.setAlignmentY(0.0F);
        btnSrSptPTrans1.setHideActionText(true);
        btnSrSptPTrans1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSrSptPTrans1.setIconTextGap(25);
        btnSrSptPTrans1.setkBorderRadius(0);
        btnSrSptPTrans1.setkEndColor(new java.awt.Color(0, 153, 51));
        btnSrSptPTrans1.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btnSrSptPTrans1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSrSptPTrans1.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btnSrSptPTrans1.setkIndicatorThickness(0);
        btnSrSptPTrans1.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSrSptPTrans1.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btnSrSptPTrans1.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSrSptPTrans1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSrSptPTrans1.setMaximumSize(new java.awt.Dimension(67, 37));
        btnSrSptPTrans1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSrSptPTrans1ActionPerformed(evt);
            }
        });

        btnSrSptPTrans.setText("Refresh");
        btnSrSptPTrans.setAlignmentY(0.0F);
        btnSrSptPTrans.setHideActionText(true);
        btnSrSptPTrans.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSrSptPTrans.setIconTextGap(25);
        btnSrSptPTrans.setkBorderRadius(0);
        btnSrSptPTrans.setkEndColor(new java.awt.Color(0, 153, 51));
        btnSrSptPTrans.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btnSrSptPTrans.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSrSptPTrans.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btnSrSptPTrans.setkIndicatorThickness(0);
        btnSrSptPTrans.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSrSptPTrans.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btnSrSptPTrans.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSrSptPTrans.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSrSptPTrans.setMaximumSize(new java.awt.Dimension(67, 37));
        btnSrSptPTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSrSptPTransActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(37, 37, 37));

        lblSptTrans.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSptTrans.setForeground(new java.awt.Color(255, 255, 255));
        lblSptTrans.setText("Nama");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Jumlah :");

        txtJmltrns.setText("1");

        kButton6.setText("Beli");
        kButton6.setAlignmentY(0.0F);
        kButton6.setHideActionText(true);
        kButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kButton6.setIconTextGap(25);
        kButton6.setkBorderRadius(0);
        kButton6.setkEndColor(new java.awt.Color(0, 153, 51));
        kButton6.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        kButton6.setkIndicatorThickness(0);
        kButton6.setkPressedColor(new java.awt.Color(204, 204, 204));
        kButton6.setkSelectedColor(new java.awt.Color(0, 102, 51));
        kButton6.setkStartColor(new java.awt.Color(33, 152, 92));
        kButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kButton6.setMaximumSize(new java.awt.Dimension(67, 37));
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblSptTrans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJmltrns, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(95, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSptTrans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtJmltrns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        tblSptTrans = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblSptTrans.setAutoCreateRowSorter(true);
        tblSptTrans.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblSptTrans.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblSptTrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MERK", "TYPE", "HARGA", "MODAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSptTrans.setToolTipText("");
        tblSptTrans.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblSptTrans.setGridColor(new java.awt.Color(255, 255, 255));
        tblSptTrans.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblSptTrans.setOpaque(false);
        tblSptTrans.setRowHeight(25);
        tblSptTrans.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tblSptTrans.setShowHorizontalLines(false);
        tblSptTrans.setShowVerticalLines(false);
        tblSptTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSptTransMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSptTrans);

        kGradientPanel8.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel8.setkBorderRadius(0);
        kGradientPanel8.setkFillBackground(false);
        kGradientPanel8.setkStartColor(new java.awt.Color(255, 153, 0));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Daftar Belanja");

        kButton4.setText("Cetak Struk");
        kButton4.setAlignmentY(0.0F);
        kButton4.setHideActionText(true);
        kButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kButton4.setIconTextGap(25);
        kButton4.setkBorderRadius(8);
        kButton4.setkEndColor(new java.awt.Color(0, 153, 51));
        kButton4.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        kButton4.setkIndicatorThickness(0);
        kButton4.setkPressedColor(new java.awt.Color(204, 204, 204));
        kButton4.setkSelectedColor(new java.awt.Color(0, 102, 51));
        kButton4.setkStartColor(new java.awt.Color(33, 152, 92));
        kButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kButton4.setMaximumSize(new java.awt.Dimension(67, 37));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        tblBeli.setAutoCreateRowSorter(true);
        tblBeli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblBeli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblBeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode", "Merek", "Jumlah", "Harga", "Total", "Modal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBeli.setToolTipText("");
        tblBeli.setGridColor(new java.awt.Color(255, 255, 255));
        tblBeli.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblBeli.setRowHeight(25);
        tblBeli.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tblBeli.setShowHorizontalLines(false);
        tblBeli.setShowVerticalLines(false);
        jScrollPane4.setViewportView(tblBeli);

        jLabel16.setText("Tanggal : 20-05-2020");

        jLabel17.setText("Sub Total :   Rp.");

        lSubTOtal.setText("Rp.");

        jLabel19.setText("Diskon     :    Rp.");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Total      : Rp.");

        lblDiskon.setText("Rp.");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotal.setText("Rp.");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Promo"));

        jLabel9.setText("Pilih Promo");

        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblGetTrans.setAutoCreateRowSorter(true);
        tblGetTrans.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblGetTrans.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tblGetTrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Merek", "Ukuran"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGetTrans.setToolTipText("");
        tblGetTrans.setGridColor(new java.awt.Color(255, 255, 255));
        tblGetTrans.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblGetTrans.setRowHeight(25);
        tblGetTrans.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tblGetTrans.setShowHorizontalLines(false);
        tblGetTrans.setShowVerticalLines(false);
        jScrollPane8.setViewportView(tblGetTrans);

        jButton1.setText("Pilih Sepatu GetFree");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Promo untuk GetFree", "Promo untuk Discount" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel1.setText("Sisa");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Bayar      :");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Kembalian    :");

        kembalian.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kembalian.setText("Rp.");

        txtBayar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBayarKeyReleased(evt);
            }
        });

        kButton7.setText("Hapus");
        kButton7.setAlignmentY(0.0F);
        kButton7.setHideActionText(true);
        kButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kButton7.setIconTextGap(25);
        kButton7.setkBorderRadius(0);
        kButton7.setkEndColor(new java.awt.Color(0, 153, 51));
        kButton7.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        kButton7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton7.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        kButton7.setkIndicatorThickness(0);
        kButton7.setkPressedColor(new java.awt.Color(204, 204, 204));
        kButton7.setkSelectedColor(new java.awt.Color(0, 102, 51));
        kButton7.setkStartColor(new java.awt.Color(33, 152, 92));
        kButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kButton7.setMaximumSize(new java.awt.Dimension(67, 37));
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        kButton8.setText("Reset");
        kButton8.setAlignmentY(0.0F);
        kButton8.setHideActionText(true);
        kButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kButton8.setIconTextGap(25);
        kButton8.setkBorderRadius(0);
        kButton8.setkEndColor(new java.awt.Color(0, 153, 51));
        kButton8.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        kButton8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        kButton8.setkIndicatorThickness(0);
        kButton8.setkPressedColor(new java.awt.Color(204, 204, 204));
        kButton8.setkSelectedColor(new java.awt.Color(0, 102, 51));
        kButton8.setkStartColor(new java.awt.Color(33, 152, 92));
        kButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kButton8.setMaximumSize(new java.awt.Dimension(67, 37));
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel8Layout = new javax.swing.GroupLayout(kGradientPanel8);
        kGradientPanel8.setLayout(kGradientPanel8Layout);
        kGradientPanel8Layout.setHorizontalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel8Layout.createSequentialGroup()
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel8Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(kGradientPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(3, 3, 3)
                        .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel8Layout.createSequentialGroup()
                        .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel8Layout.createSequentialGroup()
                                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDiskon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(kGradientPanel8Layout.createSequentialGroup()
                                        .addComponent(txtBayar)
                                        .addGap(3, 3, 3))
                                    .addComponent(lSubTOtal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
        );
        kGradientPanel8Layout.setVerticalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lSubTOtal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiskon)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kembalian)
                    .addComponent(jLabel25))
                .addGap(10, 10, 10)
                .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel12.setBackground(new java.awt.Color(37, 37, 37));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout j_transaksiLayout = new javax.swing.GroupLayout(j_transaksi);
        j_transaksi.setLayout(j_transaksiLayout);
        j_transaksiLayout.setHorizontalGroup(
            j_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_transaksiLayout.createSequentialGroup()
                .addGroup(j_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_transaksiLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(j_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(j_transaksiLayout.createSequentialGroup()
                                .addComponent(txtSrSptPTrans)
                                .addGap(0, 0, 0)
                                .addComponent(btnSrSptPTrans1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSrSptPTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(j_transaksiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(j_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(j_transaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        j_transaksiLayout.setVerticalGroup(
            j_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_transaksiLayout.createSequentialGroup()
                .addGroup(j_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_transaksiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addGroup(j_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(j_transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSrSptPTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btnSrSptPTrans1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(txtSrSptPTrans, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3)
                        .addGap(23, 23, 23))
                    .addComponent(kGradientPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        cardLay.add(j_transaksi, "cardTransaksi");

        j_riwayat.setBackground(new java.awt.Color(37, 37, 37));
        j_riwayat.setPreferredSize(new java.awt.Dimension(776, 655));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Riwayat Transaksi");

        jTable5 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTable5.setAutoCreateRowSorter(true);
        jTable5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Barang", "Jumlah", "Harga", "Total", "Waktu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setToolTipText("");
        jTable5.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable5.setGridColor(new java.awt.Color(255, 255, 255));
        jTable5.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable5.setOpaque(false);
        jTable5.setRowHeight(25);
        jTable5.setSelectionBackground(new java.awt.Color(0, 102, 51));
        jTable5.setShowHorizontalLines(false);
        jTable5.setShowVerticalLines(false);
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(3).setResizable(false);
        }

        kButton1.setText("Refresh");
        kButton1.setkBackGroundColor(new java.awt.Color(0, 175, 115));
        kButton1.setkBorderRadius(0);
        kButton1.setkEndColor(new java.awt.Color(0, 175, 115));
        kButton1.setkHoverEndColor(new java.awt.Color(1, 142, 94));
        kButton1.setkHoverForeGround(new java.awt.Color(1, 142, 94));
        kButton1.setkHoverStartColor(new java.awt.Color(1, 142, 94));
        kButton1.setkSelectedColor(new java.awt.Color(1, 142, 94));
        kButton1.setkStartColor(new java.awt.Color(0, 175, 115));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout j_riwayatLayout = new javax.swing.GroupLayout(j_riwayat);
        j_riwayat.setLayout(j_riwayatLayout);
        j_riwayatLayout.setHorizontalGroup(
            j_riwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_riwayatLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(j_riwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_riwayatLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        j_riwayatLayout.setVerticalGroup(
            j_riwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_riwayatLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(j_riwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        cardLay.add(j_riwayat, "cardRiwayat");

        j_databarang.setBackground(new java.awt.Color(37, 37, 37));
        j_databarang.setPreferredSize(new java.awt.Dimension(776, 655));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Data Barang");

        jTable6  = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTable6.setAutoCreateRowSorter(true);
        jTable6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Barang", "Jumlah", "Harga", "Total", "Waktu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setToolTipText("");
        jTable6.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable6.setGridColor(new java.awt.Color(255, 255, 255));
        jTable6.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable6.setOpaque(false);
        jTable6.setRowHeight(25);
        jTable6.setSelectionBackground(new java.awt.Color(0, 102, 51));
        jTable6.setShowHorizontalLines(false);
        jTable6.setShowVerticalLines(false);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(3).setResizable(false);
        }

        btn_transaksi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconEdit.png"))); // NOI18N
        btn_transaksi2.setText("Ubah Data Barang");
        btn_transaksi2.setAlignmentY(0.0F);
        btn_transaksi2.setHideActionText(true);
        btn_transaksi2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi2.setIconTextGap(25);
        btn_transaksi2.setkBorderRadius(0);
        btn_transaksi2.setkEndColor(new java.awt.Color(81, 150, 176));
        btn_transaksi2.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btn_transaksi2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_transaksi2.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btn_transaksi2.setkIndicatorThickness(0);
        btn_transaksi2.setkPressedColor(new java.awt.Color(204, 204, 204));
        btn_transaksi2.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btn_transaksi2.setkStartColor(new java.awt.Color(28, 110, 130));
        btn_transaksi2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_transaksi2.setMaximumSize(new java.awt.Dimension(67, 37));
        btn_transaksi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi2ActionPerformed(evt);
            }
        });

        btn_transaksi3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconDel.png"))); // NOI18N
        btn_transaksi3.setText("Hapus Data Barang");
        btn_transaksi3.setAlignmentY(0.0F);
        btn_transaksi3.setHideActionText(true);
        btn_transaksi3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi3.setIconTextGap(25);
        btn_transaksi3.setkBorderRadius(0);
        btn_transaksi3.setkEndColor(new java.awt.Color(217, 93, 93));
        btn_transaksi3.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btn_transaksi3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_transaksi3.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btn_transaksi3.setkIndicatorThickness(0);
        btn_transaksi3.setkPressedColor(new java.awt.Color(204, 204, 204));
        btn_transaksi3.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btn_transaksi3.setkStartColor(new java.awt.Color(212, 74, 74));
        btn_transaksi3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_transaksi3.setMaximumSize(new java.awt.Dimension(67, 37));
        btn_transaksi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi3ActionPerformed(evt);
            }
        });

        jTextField2.setText("Pencarian");
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        btn_transaksi4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconAdd.png"))); // NOI18N
        btn_transaksi4.setText("Input Barang");
        btn_transaksi4.setAlignmentY(0.0F);
        btn_transaksi4.setHideActionText(true);
        btn_transaksi4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi4.setIconTextGap(25);
        btn_transaksi4.setkBorderRadius(0);
        btn_transaksi4.setkEndColor(new java.awt.Color(73, 182, 109));
        btn_transaksi4.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btn_transaksi4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_transaksi4.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btn_transaksi4.setkIndicatorThickness(0);
        btn_transaksi4.setkPressedColor(new java.awt.Color(204, 204, 204));
        btn_transaksi4.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btn_transaksi4.setkStartColor(new java.awt.Color(53, 145, 81));
        btn_transaksi4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_transaksi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi4ActionPerformed(evt);
            }
        });

        kButton12.setText("Refresh");
        kButton12.setAlignmentY(0.0F);
        kButton12.setHideActionText(true);
        kButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kButton12.setIconTextGap(25);
        kButton12.setkBorderRadius(0);
        kButton12.setkEndColor(new java.awt.Color(71, 176, 106));
        kButton12.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        kButton12.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton12.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        kButton12.setkIndicatorThickness(0);
        kButton12.setkPressedColor(new java.awt.Color(204, 204, 204));
        kButton12.setkSelectedColor(new java.awt.Color(0, 102, 51));
        kButton12.setkStartColor(new java.awt.Color(71, 176, 106));
        kButton12.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kButton12.setMaximumSize(new java.awt.Dimension(67, 37));
        kButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout j_databarangLayout = new javax.swing.GroupLayout(j_databarang);
        j_databarang.setLayout(j_databarangLayout);
        j_databarangLayout.setHorizontalGroup(
            j_databarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_databarangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(j_databarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(j_databarangLayout.createSequentialGroup()
                        .addGroup(j_databarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(j_databarangLayout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(kButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(j_databarangLayout.createSequentialGroup()
                                .addComponent(btn_transaksi4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(btn_transaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btn_transaksi3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel24))
                        .addGap(11, 11, 11)))
                .addGap(23, 23, 23))
        );
        j_databarangLayout.setVerticalGroup(
            j_databarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_databarangLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(j_databarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_databarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_transaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_transaksi3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_transaksi4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(j_databarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardLay.add(j_databarang, "cardDtBarang");

        j_dataPromo.setBackground(new java.awt.Color(37, 37, 37));
        j_dataPromo.setPreferredSize(new java.awt.Dimension(776, 655));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Data Promo");

        tblPromoMng = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblPromoMng.setAutoCreateRowSorter(true);
        tblPromoMng.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblPromoMng.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPromoMng.setToolTipText("");
        tblPromoMng.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblPromoMng.setGridColor(new java.awt.Color(255, 255, 255));
        tblPromoMng.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblPromoMng.setOpaque(false);
        tblPromoMng.setRowHeight(25);
        tblPromoMng.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tblPromoMng.setShowHorizontalLines(false);
        tblPromoMng.setShowVerticalLines(false);
        tblPromoMng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPromoMngMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblPromoMng);
        if (tblPromoMng.getColumnModel().getColumnCount() > 0) {
            tblPromoMng.getColumnModel().getColumn(3).setResizable(false);
        }

        btn_transaksi5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconEdit.png"))); // NOI18N
        btn_transaksi5.setText("Ubah Data Promo");
        btn_transaksi5.setAlignmentY(0.0F);
        btn_transaksi5.setHideActionText(true);
        btn_transaksi5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi5.setIconTextGap(25);
        btn_transaksi5.setkBorderRadius(0);
        btn_transaksi5.setkEndColor(new java.awt.Color(81, 150, 176));
        btn_transaksi5.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btn_transaksi5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_transaksi5.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btn_transaksi5.setkIndicatorThickness(0);
        btn_transaksi5.setkPressedColor(new java.awt.Color(204, 204, 204));
        btn_transaksi5.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btn_transaksi5.setkStartColor(new java.awt.Color(28, 110, 130));
        btn_transaksi5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_transaksi5.setMaximumSize(new java.awt.Dimension(67, 37));
        btn_transaksi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi5ActionPerformed(evt);
            }
        });

        btn_transaksi6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconDel.png"))); // NOI18N
        btn_transaksi6.setText("Hapus Data Promo");
        btn_transaksi6.setAlignmentY(0.0F);
        btn_transaksi6.setHideActionText(true);
        btn_transaksi6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi6.setIconTextGap(25);
        btn_transaksi6.setkBorderRadius(0);
        btn_transaksi6.setkEndColor(new java.awt.Color(217, 93, 93));
        btn_transaksi6.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btn_transaksi6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_transaksi6.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btn_transaksi6.setkIndicatorThickness(0);
        btn_transaksi6.setkPressedColor(new java.awt.Color(204, 204, 204));
        btn_transaksi6.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btn_transaksi6.setkStartColor(new java.awt.Color(212, 74, 74));
        btn_transaksi6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_transaksi6.setMaximumSize(new java.awt.Dimension(67, 37));
        btn_transaksi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi6ActionPerformed(evt);
            }
        });

        jTextField3.setText("Pencarian");

        btn_transaksi7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconAdd.png"))); // NOI18N
        btn_transaksi7.setText("Input Promo");
        btn_transaksi7.setAlignmentY(0.0F);
        btn_transaksi7.setHideActionText(true);
        btn_transaksi7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi7.setIconTextGap(25);
        btn_transaksi7.setkBorderRadius(0);
        btn_transaksi7.setkEndColor(new java.awt.Color(73, 182, 109));
        btn_transaksi7.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btn_transaksi7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_transaksi7.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btn_transaksi7.setkIndicatorThickness(0);
        btn_transaksi7.setkPressedColor(new java.awt.Color(204, 204, 204));
        btn_transaksi7.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btn_transaksi7.setkStartColor(new java.awt.Color(53, 145, 81));
        btn_transaksi7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_transaksi7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi7ActionPerformed(evt);
            }
        });

        kButton13.setText("Refresh");
        kButton13.setAlignmentY(0.0F);
        kButton13.setHideActionText(true);
        kButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kButton13.setIconTextGap(25);
        kButton13.setkBorderRadius(0);
        kButton13.setkEndColor(new java.awt.Color(71, 176, 106));
        kButton13.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        kButton13.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton13.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        kButton13.setkIndicatorThickness(0);
        kButton13.setkPressedColor(new java.awt.Color(204, 204, 204));
        kButton13.setkSelectedColor(new java.awt.Color(0, 102, 51));
        kButton13.setkStartColor(new java.awt.Color(71, 176, 106));
        kButton13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kButton13.setMaximumSize(new java.awt.Dimension(67, 37));
        kButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout j_dataPromoLayout = new javax.swing.GroupLayout(j_dataPromo);
        j_dataPromo.setLayout(j_dataPromoLayout);
        j_dataPromoLayout.setHorizontalGroup(
            j_dataPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_dataPromoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(j_dataPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(j_dataPromoLayout.createSequentialGroup()
                        .addGroup(j_dataPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, j_dataPromoLayout.createSequentialGroup()
                                .addComponent(jTextField3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(296, 296, 296))
                            .addGroup(j_dataPromoLayout.createSequentialGroup()
                                .addComponent(btn_transaksi7, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(btn_transaksi5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btn_transaksi6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel40))
                        .addGap(11, 11, 11)))
                .addGap(23, 23, 23))
        );
        j_dataPromoLayout.setVerticalGroup(
            j_dataPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_dataPromoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addGroup(j_dataPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_dataPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_transaksi5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_transaksi6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_transaksi7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(j_dataPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardLay.add(j_dataPromo, "cardDtPromo");

        j_dataPegawai.setBackground(new java.awt.Color(37, 37, 37));
        j_dataPegawai.setPreferredSize(new java.awt.Dimension(776, 655));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Data Pegawai");

        jTable8 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTable8.setAutoCreateRowSorter(true);
        jTable8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Barang", "Jumlah", "Harga", "Total", "Waktu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable8.setToolTipText("");
        jTable8.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable8.setGridColor(new java.awt.Color(255, 255, 255));
        jTable8.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable8.setOpaque(false);
        jTable8.setRowHeight(25);
        jTable8.setSelectionBackground(new java.awt.Color(0, 102, 51));
        jTable8.setShowHorizontalLines(false);
        jTable8.setShowVerticalLines(false);
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable8);
        if (jTable8.getColumnModel().getColumnCount() > 0) {
            jTable8.getColumnModel().getColumn(3).setResizable(false);
        }

        btn_transaksi8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconUserEdit.png"))); // NOI18N
        btn_transaksi8.setText("            Ubah Data");
        btn_transaksi8.setAlignmentY(0.0F);
        btn_transaksi8.setHideActionText(true);
        btn_transaksi8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi8.setIconTextGap(25);
        btn_transaksi8.setkBorderRadius(0);
        btn_transaksi8.setkEndColor(new java.awt.Color(81, 150, 176));
        btn_transaksi8.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btn_transaksi8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_transaksi8.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btn_transaksi8.setkIndicatorThickness(0);
        btn_transaksi8.setkPressedColor(new java.awt.Color(204, 204, 204));
        btn_transaksi8.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btn_transaksi8.setkStartColor(new java.awt.Color(28, 110, 130));
        btn_transaksi8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_transaksi8.setMaximumSize(new java.awt.Dimension(67, 37));
        btn_transaksi8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi8ActionPerformed(evt);
            }
        });

        btn_transaksi9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconUserRemove.png"))); // NOI18N
        btn_transaksi9.setText("            Pecat");
        btn_transaksi9.setAlignmentY(0.0F);
        btn_transaksi9.setHideActionText(true);
        btn_transaksi9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi9.setIconTextGap(25);
        btn_transaksi9.setkBorderRadius(0);
        btn_transaksi9.setkEndColor(new java.awt.Color(217, 93, 93));
        btn_transaksi9.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btn_transaksi9.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_transaksi9.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btn_transaksi9.setkIndicatorThickness(0);
        btn_transaksi9.setkPressedColor(new java.awt.Color(204, 204, 204));
        btn_transaksi9.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btn_transaksi9.setkStartColor(new java.awt.Color(212, 74, 74));
        btn_transaksi9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_transaksi9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi9ActionPerformed(evt);
            }
        });

        jTextField4.setText("Pencarian");
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        btn_transaksi10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconUserAdd.png"))); // NOI18N
        btn_transaksi10.setText("                  Tambah");
        btn_transaksi10.setAlignmentY(0.0F);
        btn_transaksi10.setHideActionText(true);
        btn_transaksi10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi10.setIconTextGap(25);
        btn_transaksi10.setkBorderRadius(0);
        btn_transaksi10.setkEndColor(new java.awt.Color(73, 182, 109));
        btn_transaksi10.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btn_transaksi10.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_transaksi10.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btn_transaksi10.setkIndicatorThickness(0);
        btn_transaksi10.setkPressedColor(new java.awt.Color(204, 204, 204));
        btn_transaksi10.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btn_transaksi10.setkStartColor(new java.awt.Color(53, 145, 81));
        btn_transaksi10.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_transaksi10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi10ActionPerformed(evt);
            }
        });

        kButton14.setText("Refresh");
        kButton14.setAlignmentY(0.0F);
        kButton14.setHideActionText(true);
        kButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kButton14.setIconTextGap(25);
        kButton14.setkBorderRadius(0);
        kButton14.setkEndColor(new java.awt.Color(71, 176, 106));
        kButton14.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        kButton14.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton14.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        kButton14.setkIndicatorThickness(0);
        kButton14.setkPressedColor(new java.awt.Color(204, 204, 204));
        kButton14.setkSelectedColor(new java.awt.Color(0, 102, 51));
        kButton14.setkStartColor(new java.awt.Color(71, 176, 106));
        kButton14.setMargin(new java.awt.Insets(0, 0, 0, 0));
        kButton14.setMaximumSize(new java.awt.Dimension(67, 37));
        kButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton14ActionPerformed(evt);
            }
        });

        btn_transaksi12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconUserPass.png"))); // NOI18N
        btn_transaksi12.setText("               Reset Pass");
        btn_transaksi12.setAlignmentY(0.0F);
        btn_transaksi12.setHideActionText(true);
        btn_transaksi12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transaksi12.setIconTextGap(25);
        btn_transaksi12.setkBorderRadius(0);
        btn_transaksi12.setkEndColor(new java.awt.Color(212, 161, 74));
        btn_transaksi12.setkHoverEndColor(new java.awt.Color(0, 102, 51));
        btn_transaksi12.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_transaksi12.setkHoverStartColor(new java.awt.Color(0, 102, 51));
        btn_transaksi12.setkIndicatorThickness(0);
        btn_transaksi12.setkPressedColor(new java.awt.Color(204, 204, 204));
        btn_transaksi12.setkSelectedColor(new java.awt.Color(0, 102, 51));
        btn_transaksi12.setkStartColor(new java.awt.Color(212, 161, 74));
        btn_transaksi12.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_transaksi12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout j_dataPegawaiLayout = new javax.swing.GroupLayout(j_dataPegawai);
        j_dataPegawai.setLayout(j_dataPegawaiLayout);
        j_dataPegawaiLayout.setHorizontalGroup(
            j_dataPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_dataPegawaiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(j_dataPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addGroup(j_dataPegawaiLayout.createSequentialGroup()
                        .addGroup(j_dataPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, j_dataPegawaiLayout.createSequentialGroup()
                                .addComponent(jTextField4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(296, 296, 296))
                            .addGroup(j_dataPegawaiLayout.createSequentialGroup()
                                .addComponent(btn_transaksi10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btn_transaksi8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btn_transaksi12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btn_transaksi9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel41))
                        .addGap(11, 11, 11)))
                .addGap(23, 23, 23))
        );
        j_dataPegawaiLayout.setVerticalGroup(
            j_dataPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j_dataPegawaiLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addGroup(j_dataPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j_dataPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_transaksi8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_transaksi9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_transaksi12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_transaksi10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(j_dataPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardLay.add(j_dataPegawai, "cardDtPegawai");

        kGradientPanel1.setBackground(new java.awt.Color(37, 37, 37));
        kGradientPanel1.setkEndColor(new java.awt.Color(83, 83, 83));
        kGradientPanel1.setkGradientFocus(700);
        kGradientPanel1.setkStartColor(new java.awt.Color(37, 37, 37));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconBack.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(5, 5, 5))
        );

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Tambah Sepatu");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID             ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Brand         ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipe           ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Deskripsi     ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ukuran");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Harga Modal");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Harga Jual");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Stok");

        txtIDSepatu.setEditable(false);
        txtIDSepatu.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        txtIDSepatu.setForeground(new java.awt.Color(227, 227, 227));
        txtIDSepatu.setText("Id Otomatis");
        txtIDSepatu.setBorder(null);
        txtIDSepatu.setOpaque(false);
        txtIDSepatu.setBackground(new Color(0,0,0,0));

        txtUname1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname1.setForeground(new java.awt.Color(227, 227, 227));
        txtUname1.setBorder(null);
        txtUname1.setOpaque(false);
        txtUname1.setBackground(new Color(0,0,0,0));

        jSeparator3.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        txtUname2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname2.setForeground(new java.awt.Color(227, 227, 227));
        txtUname2.setBorder(null);
        txtUname2.setOpaque(false);
        txtUname2.setBackground(new Color(0,0,0,0));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));

        txtUname3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname3.setForeground(new java.awt.Color(227, 227, 227));
        txtUname3.setBorder(null);
        txtUname3.setOpaque(false);
        txtUname3.setBackground(new Color(0,0,0,0));

        jSeparator5.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        txtUname4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname4.setForeground(new java.awt.Color(227, 227, 227));
        txtUname4.setBorder(null);
        txtUname4.setOpaque(false);
        txtUname4.setBackground(new Color(0,0,0,0));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));

        txtUname5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname5.setForeground(new java.awt.Color(227, 227, 227));
        txtUname5.setBorder(null);
        txtUname5.setOpaque(false);
        txtUname5.setBackground(new Color(0,0,0,0));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));

        txtUname6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname6.setForeground(new java.awt.Color(227, 227, 227));
        txtUname6.setBorder(null);
        txtUname6.setOpaque(false);
        txtUname6.setBackground(new Color(0,0,0,0));

        jSeparator8.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator8.setForeground(new java.awt.Color(204, 204, 204));

        txtUname7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname7.setForeground(new java.awt.Color(227, 227, 227));
        txtUname7.setBorder(null);
        txtUname7.setOpaque(false);
        txtUname7.setBackground(new Color(0,0,0,0));

        jSeparator9.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator9.setForeground(new java.awt.Color(204, 204, 204));

        jPanel7.setBackground(new java.awt.Color(37, 37, 37));
        jPanel7.setBackground(new Color(0,0,0,0));

        btnSideTrans2.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans2.setText("Save");
        btnSideTrans2.setToolTipText("");
        btnSideTrans2.setAlignmentY(0.0F);
        btnSideTrans2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans2.setHideActionText(true);
        btnSideTrans2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans2.setIconTextGap(25);
        btnSideTrans2.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans2.setkBorderRadius(0);
        btnSideTrans2.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans2.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans2.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans2.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans2.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans2.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans2.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans2.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans2.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans2ActionPerformed(evt);
            }
        });

        btnSideTrans3.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans3.setText("Clear");
        btnSideTrans3.setToolTipText("");
        btnSideTrans3.setAlignmentY(0.0F);
        btnSideTrans3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans3.setHideActionText(true);
        btnSideTrans3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans3.setIconTextGap(25);
        btnSideTrans3.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans3.setkBorderRadius(0);
        btnSideTrans3.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans3.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans3.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans3.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans3.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans3.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans3.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans3.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans3.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(btnSideTrans2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSideTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 128, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSideTrans2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideTrans3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDSepatu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 470, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtIDSepatu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtUname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtUname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUname3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUname4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUname5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtUname6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUname7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout j_adSepatuLayout = new javax.swing.GroupLayout(j_adSepatu);
        j_adSepatu.setLayout(j_adSepatuLayout);
        j_adSepatuLayout.setHorizontalGroup(
            j_adSepatuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        j_adSepatuLayout.setVerticalGroup(
            j_adSepatuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        cardLay.add(j_adSepatu, "cardAdUpBarang");

        kGradientPanel6.setBackground(new java.awt.Color(37, 37, 37));
        kGradientPanel6.setkEndColor(new java.awt.Color(83, 83, 83));
        kGradientPanel6.setkGradientFocus(700);
        kGradientPanel6.setkStartColor(new java.awt.Color(37, 37, 37));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconBack.png"))); // NOI18N
        jLabel60.setText("jLabel3");
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel60)
                .addGap(5, 5, 5))
        );

        jdlAdPromo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jdlAdPromo.setForeground(new java.awt.Color(255, 255, 255));
        jdlAdPromo.setText("Tambah Promo");

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("ID Promo");

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Nama Promo");

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Tipe           ");

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Diskon (%)");

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Maks Diskon");

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Min Pembelian");

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Min Item");

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Banyak Free");

        txtField1.setEditable(false);
        txtField1.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        txtField1.setForeground(new java.awt.Color(227, 227, 227));
        txtField1.setText("ID Otomatis");
        txtField1.setBorder(null);
        txtField1.setOpaque(false);
        txtIDSepatu.setBackground(new Color(0,0,0,0));

        txtField2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtField2.setForeground(new java.awt.Color(227, 227, 227));
        txtField2.setBorder(null);
        txtField2.setOpaque(false);
        txtUname1.setBackground(new Color(0,0,0,0));

        jSeparator27.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator27.setForeground(new java.awt.Color(204, 204, 204));

        txtField4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtField4.setForeground(new java.awt.Color(227, 227, 227));
        txtField4.setBorder(null);
        txtField4.setOpaque(false);
        txtUname3.setBackground(new Color(0,0,0,0));

        jSeparator29.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator29.setForeground(new java.awt.Color(204, 204, 204));

        txtField5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtField5.setForeground(new java.awt.Color(227, 227, 227));
        txtField5.setBorder(null);
        txtField5.setOpaque(false);
        txtUname4.setBackground(new Color(0,0,0,0));

        jSeparator30.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator30.setForeground(new java.awt.Color(204, 204, 204));

        txtField6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtField6.setForeground(new java.awt.Color(227, 227, 227));
        txtField6.setBorder(null);
        txtField6.setOpaque(false);
        txtUname5.setBackground(new Color(0,0,0,0));

        jSeparator31.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator31.setForeground(new java.awt.Color(204, 204, 204));

        txtField7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtField7.setForeground(new java.awt.Color(227, 227, 227));
        txtField7.setBorder(null);
        txtField7.setOpaque(false);
        txtUname5.setBackground(new Color(0,0,0,0));

        jSeparator33.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator33.setForeground(new java.awt.Color(204, 204, 204));

        txtField8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtField8.setForeground(new java.awt.Color(227, 227, 227));
        txtField8.setBorder(null);
        txtField8.setOpaque(false);
        txtUname6.setBackground(new Color(0,0,0,0));

        jSeparator34.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator34.setForeground(new java.awt.Color(204, 204, 204));

        jPanel11.setBackground(new java.awt.Color(37, 37, 37));
        jPanel7.setBackground(new Color(0,0,0,0));

        btnSideTrans6.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans6.setText("Save");
        btnSideTrans6.setToolTipText("");
        btnSideTrans6.setAlignmentY(0.0F);
        btnSideTrans6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans6.setHideActionText(true);
        btnSideTrans6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans6.setIconTextGap(25);
        btnSideTrans6.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans6.setkBorderRadius(0);
        btnSideTrans6.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans6.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans6.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans6.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans6.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans6.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans6.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans6.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans6.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans6ActionPerformed(evt);
            }
        });

        btnSideTrans7.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans7.setText("Clear");
        btnSideTrans7.setToolTipText("");
        btnSideTrans7.setAlignmentY(0.0F);
        btnSideTrans7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans7.setHideActionText(true);
        btnSideTrans7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans7.setIconTextGap(25);
        btnSideTrans7.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans7.setkBorderRadius(0);
        btnSideTrans7.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans7.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans7.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans7.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans7.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans7.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans7.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans7.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans7.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(btnSideTrans6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSideTrans7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 128, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSideTrans6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideTrans7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel13.setBackground(new java.awt.Color(102, 102, 102));

        jButton3.setText("Tambah");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tblGetFree = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblGetFree.setAutoCreateRowSorter(true);
        tblGetFree.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblGetFree.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblGetFree.setOpaque(false);
        jScrollPane1.setViewportView(tblGetFree);

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Sepatu untuk Free");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addContainerGap())))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jRadioButton1.setBackground(new java.awt.Color(37, 37, 37));
        bGTpPromo.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Diskon");
        jRadioButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton1StateChanged(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(37, 37, 37));
        bGTpPromo.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Get Free");
        jRadioButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton2StateChanged(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtField8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtField4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtField1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtField2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtField5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtField6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2))
                            .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtField7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addComponent(jdlAdPromo, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdlAdPromo)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62)
                            .addComponent(txtField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addComponent(txtField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(6, 6, 6)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68)
                            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(txtField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(364, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout j_adPromoLayout = new javax.swing.GroupLayout(j_adPromo);
        j_adPromo.setLayout(j_adPromoLayout);
        j_adPromoLayout.setHorizontalGroup(
            j_adPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        j_adPromoLayout.setVerticalGroup(
            j_adPromoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        cardLay.add(j_adPromo, "cardAdUpPromo");

        kGradientPanel3.setBackground(new java.awt.Color(37, 37, 37));
        kGradientPanel3.setkEndColor(new java.awt.Color(83, 83, 83));
        kGradientPanel3.setkGradientFocus(700);
        kGradientPanel3.setkStartColor(new java.awt.Color(37, 37, 37));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team1/image/iconBack.png"))); // NOI18N
        jLabel50.setText("jLabel3");
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel50)
                .addGap(5, 5, 5))
        );

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Tambah Pegawai");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Username");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Nama");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Level");

        bgLvl.add(rbKasir);
        rbKasir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbKasir.setForeground(new java.awt.Color(255, 255, 255));
        rbKasir.setText("Kasir");

        bgLvl.add(rbInvenori);
        rbInvenori.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbInvenori.setForeground(new java.awt.Color(255, 255, 255));
        rbInvenori.setText("Inventori");

        txtIDSepatu1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtIDSepatu1.setForeground(new java.awt.Color(227, 227, 227));
        txtIDSepatu1.setBorder(null);
        txtIDSepatu1.setOpaque(false);
        txtIDSepatu.setBackground(new Color(0,0,0,0));

        jSeparator18.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator18.setForeground(new java.awt.Color(204, 204, 204));

        txtUname16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname16.setForeground(new java.awt.Color(227, 227, 227));
        txtUname16.setBorder(null);
        txtUname16.setOpaque(false);
        txtUname1.setBackground(new Color(0,0,0,0));

        jSeparator19.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator19.setForeground(new java.awt.Color(204, 204, 204));

        jPanel9.setBackground(new java.awt.Color(37, 37, 37));
        jPanel7.setBackground(new Color(0,0,0,0));

        btnSideTrans4.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans4.setText("Save");
        btnSideTrans4.setToolTipText("");
        btnSideTrans4.setAlignmentY(0.0F);
        btnSideTrans4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans4.setHideActionText(true);
        btnSideTrans4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans4.setIconTextGap(25);
        btnSideTrans4.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans4.setkBorderRadius(0);
        btnSideTrans4.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans4.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans4.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans4.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans4.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans4.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans4.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans4.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans4.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans4ActionPerformed(evt);
            }
        });

        btnSideTrans5.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans5.setText("Clear");
        btnSideTrans5.setToolTipText("");
        btnSideTrans5.setAlignmentY(0.0F);
        btnSideTrans5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans5.setHideActionText(true);
        btnSideTrans5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans5.setIconTextGap(25);
        btnSideTrans5.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans5.setkBorderRadius(0);
        btnSideTrans5.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans5.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans5.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans5.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans5.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans5.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans5.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans5.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans5.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btnSideTrans4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSideTrans5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 128, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSideTrans4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideTrans5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("J.Kelamain");

        bgJk.add(rbPerempuan);
        rbPerempuan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbPerempuan.setForeground(new java.awt.Color(255, 255, 255));
        rbPerempuan.setText("Perempuan");

        bgJk.add(rbLaki);
        rbLaki.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbLaki.setForeground(new java.awt.Color(255, 255, 255));
        rbLaki.setText("Laki-Laki");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                        .addComponent(rbPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbLaki))
                                    .addComponent(txtIDSepatu1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname16, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                        .addComponent(rbKasir)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbInvenori))))))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 477, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(txtIDSepatu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(txtUname16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(rbKasir)
                    .addComponent(rbInvenori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(rbPerempuan)
                    .addComponent(rbLaki))
                .addGap(20, 20, 20)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(484, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout j_adPegawaiLayout = new javax.swing.GroupLayout(j_adPegawai);
        j_adPegawai.setLayout(j_adPegawaiLayout);
        j_adPegawaiLayout.setHorizontalGroup(
            j_adPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        j_adPegawaiLayout.setVerticalGroup(
            j_adPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        cardLay.add(j_adPegawai, "cardAdUpPegawai");

        kGradientPanel2.setBackground(new java.awt.Color(37, 37, 37));
        kGradientPanel2.setkEndColor(new java.awt.Color(83, 83, 83));
        kGradientPanel2.setkGradientFocus(700);
        kGradientPanel2.setkStartColor(new java.awt.Color(37, 37, 37));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Pengaturan Aplikasi");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Nama Toko");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Alamat");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Berdiri");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Server");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("User Server");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Password Server");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Database");

        txtUname8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname8.setForeground(new java.awt.Color(227, 227, 227));
        txtUname8.setBorder(null);
        txtUname8.setOpaque(false);
        txtUname1.setBackground(new Color(0,0,0,0));

        jSeparator10.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator10.setForeground(new java.awt.Color(204, 204, 204));

        txtUname9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname9.setForeground(new java.awt.Color(227, 227, 227));
        txtUname9.setBorder(null);
        txtUname9.setOpaque(false);
        txtUname2.setBackground(new Color(0,0,0,0));

        jSeparator11.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator11.setForeground(new java.awt.Color(204, 204, 204));

        txtUname10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname10.setForeground(new java.awt.Color(227, 227, 227));
        txtUname10.setBorder(null);
        txtUname10.setOpaque(false);
        txtUname3.setBackground(new Color(0,0,0,0));

        jSeparator12.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator12.setForeground(new java.awt.Color(204, 204, 204));

        txtUname11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname11.setForeground(new java.awt.Color(227, 227, 227));
        txtUname11.setBorder(null);
        txtUname11.setOpaque(false);
        txtUname4.setBackground(new Color(0,0,0,0));

        jSeparator13.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator13.setForeground(new java.awt.Color(204, 204, 204));

        txtUname12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname12.setForeground(new java.awt.Color(227, 227, 227));
        txtUname12.setBorder(null);
        txtUname12.setOpaque(false);
        txtUname5.setBackground(new Color(0,0,0,0));

        jSeparator14.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator14.setForeground(new java.awt.Color(204, 204, 204));

        txtUname13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname13.setForeground(new java.awt.Color(227, 227, 227));
        txtUname13.setBorder(null);
        txtUname13.setOpaque(false);
        txtUname6.setBackground(new Color(0,0,0,0));

        jSeparator15.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator15.setForeground(new java.awt.Color(204, 204, 204));

        txtUname14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtUname14.setForeground(new java.awt.Color(227, 227, 227));
        txtUname14.setBorder(null);
        txtUname14.setOpaque(false);
        txtUname7.setBackground(new Color(0,0,0,0));

        jSeparator16.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator16.setForeground(new java.awt.Color(204, 204, 204));

        jPanel15.setBackground(new java.awt.Color(37, 37, 37));
        jPanel7.setBackground(new Color(0,0,0,0));

        btnSideTrans8.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans8.setText("Save");
        btnSideTrans8.setToolTipText("");
        btnSideTrans8.setAlignmentY(0.0F);
        btnSideTrans8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans8.setHideActionText(true);
        btnSideTrans8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans8.setIconTextGap(25);
        btnSideTrans8.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans8.setkBorderRadius(0);
        btnSideTrans8.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans8.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans8.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans8.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans8.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans8.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans8.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans8.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans8.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(btnSideTrans8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 243, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(btnSideTrans8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUname8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname9, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname10, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname11, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname13, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname14, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 441, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel34)
                .addGap(50, 50, 50)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(txtUname8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(txtUname9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUname10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUname11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUname12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(txtUname13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUname14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel46))
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout j_SettingsLayout = new javax.swing.GroupLayout(j_Settings);
        j_Settings.setLayout(j_SettingsLayout);
        j_SettingsLayout.setHorizontalGroup(
            j_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        j_SettingsLayout.setVerticalGroup(
            j_SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        cardLay.add(j_Settings, "cardSettings");

        kGradientPanel10.setBackground(new java.awt.Color(37, 37, 37));
        kGradientPanel10.setkEndColor(new java.awt.Color(83, 83, 83));
        kGradientPanel10.setkGradientFocus(700);
        kGradientPanel10.setkStartColor(new java.awt.Color(37, 37, 37));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Pelaporan");

        jPanel18.setBackground(new java.awt.Color(37, 37, 37));
        jPanel7.setBackground(new Color(0,0,0,0));

        btnSideTrans11.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans11.setText("Load Chart");
        btnSideTrans11.setToolTipText("");
        btnSideTrans11.setAlignmentY(0.0F);
        btnSideTrans11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans11.setHideActionText(true);
        btnSideTrans11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans11.setIconTextGap(25);
        btnSideTrans11.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans11.setkBorderRadius(0);
        btnSideTrans11.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans11.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans11.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans11.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans11.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans11.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans11.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans11.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans11.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans11.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans11.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans11ActionPerformed(evt);
            }
        });

        btnSideTrans12.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans12.setText("Cetak Harian");
        btnSideTrans12.setToolTipText("");
        btnSideTrans12.setAlignmentY(0.0F);
        btnSideTrans12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans12.setHideActionText(true);
        btnSideTrans12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans12.setIconTextGap(25);
        btnSideTrans12.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans12.setkBorderRadius(0);
        btnSideTrans12.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans12.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans12.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans12.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans12.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans12.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans12.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans12.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans12.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans12.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans12.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans12ActionPerformed(evt);
            }
        });

        btnSideTrans13.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans13.setText("Refresh");
        btnSideTrans13.setToolTipText("");
        btnSideTrans13.setAlignmentY(0.0F);
        btnSideTrans13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans13.setHideActionText(true);
        btnSideTrans13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans13.setIconTextGap(25);
        btnSideTrans13.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans13.setkBorderRadius(0);
        btnSideTrans13.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans13.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans13.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans13.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans13.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans13.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans13.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans13.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans13.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans13.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans13ActionPerformed(evt);
            }
        });

        btnSideTrans14.setBackground(new java.awt.Color(33, 152, 92));
        btnSideTrans14.setText("Cetak Bulanan");
        btnSideTrans14.setToolTipText("");
        btnSideTrans14.setAlignmentY(0.0F);
        btnSideTrans14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSideTrans14.setHideActionText(true);
        btnSideTrans14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSideTrans14.setIconTextGap(25);
        btnSideTrans14.setkBackGroundColor(new java.awt.Color(33, 152, 92));
        btnSideTrans14.setkBorderRadius(0);
        btnSideTrans14.setkEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans14.setkHoverEndColor(new java.awt.Color(33, 152, 92));
        btnSideTrans14.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSideTrans14.setkHoverStartColor(new java.awt.Color(0, 175, 115));
        btnSideTrans14.setkPressedColor(new java.awt.Color(204, 204, 204));
        btnSideTrans14.setkSelectedColor(new java.awt.Color(0, 175, 115));
        btnSideTrans14.setkStartColor(new java.awt.Color(33, 152, 92));
        btnSideTrans14.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSideTrans14.setMaximumSize(new java.awt.Dimension(230, 50));
        btnSideTrans14.setMinimumSize(new java.awt.Dimension(230, 50));
        btnSideTrans14.setPreferredSize(new java.awt.Dimension(230, 50));
        btnSideTrans14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSideTrans14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(btnSideTrans11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnSideTrans13, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSideTrans12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSideTrans14, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSideTrans11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideTrans12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideTrans13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSideTrans14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        panelMyChart.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(jTable1);

        javax.swing.GroupLayout kGradientPanel10Layout = new javax.swing.GroupLayout(kGradientPanel10);
        kGradientPanel10.setLayout(kGradientPanel10Layout);
        kGradientPanel10Layout.setHorizontalGroup(
            kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMyChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(kGradientPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kGradientPanel10Layout.setVerticalGroup(
            kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel71)
                .addGap(10, 10, 10)
                .addComponent(panelMyChart, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout j_LaporanLayout = new javax.swing.GroupLayout(j_Laporan);
        j_Laporan.setLayout(j_LaporanLayout);
        j_LaporanLayout.setHorizontalGroup(
            j_LaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        j_LaporanLayout.setVerticalGroup(
            j_LaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cardLay.add(j_Laporan, "cardLaporan");

        jSplitPane1.setRightComponent(cardLay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(1106, 791));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSideTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTransActionPerformed
        mngTransOpen();
    }//GEN-LAST:event_btnSideTransActionPerformed

    private void btnSideDBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideDBarangActionPerformed
        mngBarangOpen();
        
    }//GEN-LAST:event_btnSideDBarangActionPerformed

    private void btnSideLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideLapActionPerformed
        mngLaporanOpen();
    }//GEN-LAST:event_btnSideLapActionPerformed

    private void btnSideDPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideDPromoActionPerformed
        mngPromoOpen();
    }//GEN-LAST:event_btnSideDPromoActionPerformed

    private void btnSideSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideSettingsActionPerformed
        cardLayout.show(cardLay, "cardSettings");   
        btnSideDash.setSelected(false);
        btnSideTrans.setSelected(false);
        btnSideRiwayat.setSelected(false);
        btnSideDBarang.setSelected(false);
        btnSideDPromo.setSelected(false);
        btnSideLap.setSelected(false);
        btnSidePeg.setSelected(false);
        btnSideSettings.setSelected(true);
        
        ConfigApp c = new ConfigApp();
        c.readConfig();
        txtUname8.setText(c.getStoreName());
        txtUname9.setText(c.getStoreAddress());
        txtUname10.setText(c.getSince());
        txtUname11.setText(c.getDbHost());
        txtUname12.setText(c.getDbUname());
        txtUname13.setText(c.getDbPass());
        txtUname14.setText(c.getDbName());
        
        
    }//GEN-LAST:event_btnSideSettingsActionPerformed

    private void btnSrSptPTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSrSptPTransActionPerformed
        refreshSepatu();
    }//GEN-LAST:event_btnSrSptPTransActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        saveTransSql();
        printTxt();
        JOptionPane.showMessageDialog(rootPane, "Berhasil Transaksi");
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("C:\\Windows\\System32\\notepad.exe C:\\Users\\Public\\Documents\\printshoescash.txt");
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButton4ActionPerformed

    private void btnSideDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideDashActionPerformed
        cardLayout.show(cardLay, "cardDashBoard");   
        btnSideDash.setSelected(true);
        btnSideTrans.setSelected(false);
        btnSideRiwayat.setSelected(false);
        btnSideDBarang.setSelected(false);
        btnSideDPromo.setSelected(false);
        btnSideLap.setSelected(false);
        btnSidePeg.setSelected(false);
        btnSideSettings.setSelected(false);
    }//GEN-LAST:event_btnSideDashActionPerformed

    private void btn_transaksi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi3ActionPerformed
        if (jTable6.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan pilih salah satu data untuk diedit");
        } else {
            try {
                con = (new Koneksi().getConnection());
                String sql = "delete from products where id_product = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, jTable6.getValueAt(jTable6.getSelectedRow(), 0).toString());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus");
                mngBarangOpen();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showConfirmDialog(rootPane, ex);
            }
        }
    }//GEN-LAST:event_btn_transaksi3ActionPerformed

    private void btn_transaksi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi2ActionPerformed
        if (jTable6.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan pilih salah satu data untuk diedit");
        } else {
            upOrAd="upsepatu";
            btnSideTrans3.setVisible(false);
            jLabel33.setText("Update Sepatu");
            cardLayout.show(cardLay, "cardAdUpBarang");
        }
    }//GEN-LAST:event_btn_transaksi2ActionPerformed

    private void btn_transaksi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi4ActionPerformed
        upOrAd = "addsepatu";
        jLabel33.setText("Tambah Sepatu");
        cardLayout.show(cardLay, "cardAdUpBarang");   
        txtIDSepatu.setText("ID Otomatis");
        txtUname1.setText("");
        txtUname2.setText("");
        txtUname3.setText("");
        txtUname4.setText("");
        txtUname5.setText("");
        txtUname6.setText("");
        txtUname7.setText("");
    }//GEN-LAST:event_btn_transaksi4ActionPerformed

    private void btnSideRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideRiwayatActionPerformed
        cardLayout.show(cardLay, "cardRiwayat");
        btnSideDash.setSelected(false);
        btnSideTrans.setSelected(false);
        btnSideRiwayat.setSelected(true);
        btnSideDBarang.setSelected(false);
        btnSideDPromo.setSelected(false);
        btnSideLap.setSelected(false);
        btnSidePeg.setSelected(false);
        DetTransDao d = new DetTransDao();
        jTable5.setModel(d.selectAllDataToTableModel(false));
        btnSideSettings.setSelected(false);
    }//GEN-LAST:event_btnSideRiwayatActionPerformed

    private void btnSidePegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSidePegActionPerformed
        mngPegawaiOpen();
    }//GEN-LAST:event_btnSidePegActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        JTable table = (JTable) tblSptTrans;
            String a = table.getValueAt(table.getSelectedRow(), 0).toString();
            String b = table.getValueAt(table.getSelectedRow(), 1).toString()+" ("+table.getValueAt(table.getSelectedRow(), 3).toString()+")";
            int c = Integer.parseInt(txtJmltrns.getText());
            int d = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString());
            int stok = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString());
            int modal = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 6).toString());
            int e = c*d;
            int f = c*modal;
            if (c>stok) {
            JOptionPane.showMessageDialog(rootPane, "Stok barang melebihi pembelian");
            } else {
            Object[] data = {a,b,c,d,e,f};
            
            DefaultTableModel model = (DefaultTableModel) tblBeli.getModel();
            model.addRow(data);
            bnyk = tblBeli.getRowCount();
            subtotal=0;
            totModal=0;
                lots=0;
                for (int i = 0; i < bnyk; i++) {
                    subtotal+=Integer.parseInt(tblBeli.getValueAt(i, 4).toString());
                    totModal+=Integer.parseInt(tblBeli.getValueAt(i, 5).toString());
                    lots+=Integer.parseInt(tblBeli.getValueAt(i, 2).toString());
                }
                total = subtotal-diskon;
            lSubTOtal.setText(subtotal+"");
            lblDiskon.setText(diskon+"");
            lblTotal.setText(total+"");
            }
            addPromoCombo();
            hitungKembalian();
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblBeli.getModel();
        if (tblBeli.getSelectedRow() != -1) {
            model.removeRow(tblBeli.getSelectedRow());
            bnyk = tblBeli.getRowCount();
            subtotal=0;
            totModal=0;
                lots=0;
                for (int i = 0; i < bnyk; i++) {
                    subtotal+=Integer.parseInt(tblBeli.getValueAt(i, 4).toString());
                    totModal+=Integer.parseInt(tblBeli.getValueAt(i, 5).toString());
                    lots+=Integer.parseInt(tblBeli.getValueAt(i, 2).toString());
                }
        }
        addPromoCombo();
            getPromoSelected();
            hitungKembalian();
    }//GEN-LAST:event_kButton7ActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        mngTransOpen();
        
    }//GEN-LAST:event_kButton8ActionPerformed

    private void btn_transaksi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi5ActionPerformed
        if (tblPromoMng.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan pilih salah satu data untuk diedit");
        } else {
            upOrAd = "uppromo";
            jdlAdPromo.setText("Update Promo");
            cardLayout.show(cardLay, "cardAdUpPromo");
            btnSideTrans7.setVisible(false);
        }
    }//GEN-LAST:event_btn_transaksi5ActionPerformed

    private void btn_transaksi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi6ActionPerformed
        if (tblPromoMng.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan pilih salah satu data untuk dihapus");
        } else {
            hapusGetFree(tblPromoMng.getValueAt(tblPromoMng.getSelectedRow(), 0).toString());
            hapusPromo(tblPromoMng.getValueAt(tblPromoMng.getSelectedRow(), 0).toString());
            JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus");
            mngPromoOpen();
        }
    }//GEN-LAST:event_btn_transaksi6ActionPerformed

    private void btn_transaksi7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi7ActionPerformed
        upOrAd = "addpromo";
        jdlAdPromo.setText("Tambah Promo");
        cardLayout.show(cardLay, "cardAdUpPromo");
        clearPromoForm();
    }//GEN-LAST:event_btn_transaksi7ActionPerformed

    private void btn_transaksi8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi8ActionPerformed
        if (jTable8.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan pilih salah satu data untuk diedit");
        } else {
            upOrAd="uppegawai";
            btnSideTrans5.setVisible(false);
            jLabel51.setText("Update Pegawai");
            cardLayout.show(cardLay, "cardAdUpPegawai");
        }
    }//GEN-LAST:event_btn_transaksi8ActionPerformed

    private void btn_transaksi9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi9ActionPerformed
        if (jTable8.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan pilih salah satu data untuk diedit");
        } else {
            try {
                con = (new Koneksi().getConnection());
                String sql = "delete from users where uname = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, jTable8.getValueAt(jTable8.getSelectedRow(), 0).toString());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus");
                mngPegawaiOpen();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showConfirmDialog(rootPane, ex);
            }
        }
    }//GEN-LAST:event_btn_transaksi9ActionPerformed

    private void btn_transaksi10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi10ActionPerformed
        upOrAd = "addpegawai";
        cardLayout.show(cardLay, "cardAdUpPegawai");   
        jLabel51.setText("Tambah Pegawai");
        txtIDSepatu1.setText("");
        txtUname16.setText("");
        bgJk.clearSelection();
        bgLvl.clearSelection();
    }//GEN-LAST:event_btn_transaksi10ActionPerformed

    private void kButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton11ActionPerformed
        ChangePassForm cpas = new ChangePassForm(this, rootPaneCheckingEnabled);
        cpas.show();
    }//GEN-LAST:event_kButton11ActionPerformed

    private void jRadioButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton1StateChanged
        showHideFree();
    }//GEN-LAST:event_jRadioButton1StateChanged

    private void jRadioButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton2StateChanged
        showHideFree();
    }//GEN-LAST:event_jRadioButton2StateChanged

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        cardLayout.show(cardLay, "cardRiwayat");   
        btnSideDash.setSelected(false);
        btnSideTrans.setSelected(false);
        btnSideRiwayat.setSelected(true);
        btnSideDBarang.setSelected(false);
        btnSideDPromo.setSelected(false);
        btnSideLap.setSelected(false);
        btnSidePeg.setSelected(false);
        DetTransDao d = new DetTransDao();
        jTable5.setModel(d.selectAllDataToTableModel(false));
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        mngPromoOpen();
    }//GEN-LAST:event_jLabel60MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        mngPegawaiOpen();
    }//GEN-LAST:event_jLabel50MouseClicked

    private void tblSptTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSptTransMouseClicked
        lblSptTrans.setText(tblSptTrans.getValueAt(tblSptTrans.getSelectedRow(), 1).toString());
        txtJmltrns.setText("1");
        JTable table = (JTable) tblSptTrans;
        Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        if (evt.getClickCount()==2 && table.getSelectedRow() != -1) {
            String a = table.getValueAt(table.getSelectedRow(), 0).toString();
            String b = table.getValueAt(table.getSelectedRow(), 1).toString()+" ("+table.getValueAt(table.getSelectedRow(), 3).toString()+")";
            int c = Integer.parseInt(txtJmltrns.getText());
            int d = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString());
            int stok = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString());
            int modal = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 6).toString());
            int e = c*d;
            int f = c*modal;
            if (c>stok) {
            JOptionPane.showMessageDialog(rootPane, "Stok barang melebihi pembelian");
            } else {
            Object[] data = {a,b,c,d,e,f};
            
            DefaultTableModel model = (DefaultTableModel) tblBeli.getModel();
            model.addRow(data);
            bnyk = tblBeli.getRowCount();
            subtotal=0;
            totModal=0;
            lots=0;
                for (int i = 0; i < bnyk; i++) {
                    subtotal+=Integer.parseInt(tblBeli.getValueAt(i, 4).toString());
                    totModal+=Integer.parseInt(tblBeli.getValueAt(i, 5).toString());
                    lots+=Integer.parseInt(tblBeli.getValueAt(i, 2).toString());
                }
            total = subtotal-diskon;
            lSubTOtal.setText(subtotal+"");
            lblDiskon.setText(diskon+"");
            lblTotal.setText(total+"");
            }
            addPromoCombo();
        }
        hitungKembalian();
    }//GEN-LAST:event_tblSptTransMouseClicked

    private void btnUbahTokoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahTokoActionPerformed
        mngDashOpen();
    }//GEN-LAST:event_btnUbahTokoActionPerformed

    private void kButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton12ActionPerformed
        mngBarangOpen();
    }//GEN-LAST:event_kButton12ActionPerformed

    private void kButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton13ActionPerformed
        mngPromoOpen();
    }//GEN-LAST:event_kButton13ActionPerformed

    private void kButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton14ActionPerformed
        mngPegawaiOpen();
    }//GEN-LAST:event_kButton14ActionPerformed

    private void btnSideTrans5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans5ActionPerformed
        txtIDSepatu1.setText("");
        txtUname16.setText("");
        bgLvl.clearSelection();
        bgJk.clearSelection();
    }//GEN-LAST:event_btnSideTrans5ActionPerformed

    private void btnSideTrans3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans3ActionPerformed
        txtIDSepatu.setText("ID Otomatis");
        txtUname1.setText("");
        txtUname2.setText("");
        txtUname3.setText("");
        txtUname4.setText("");
        txtUname5.setText("");
        txtUname6.setText("");
        txtUname7.setText("");
    }//GEN-LAST:event_btnSideTrans3ActionPerformed

    private void btnSideTrans7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans7ActionPerformed
        clearPromoForm();
    }//GEN-LAST:event_btnSideTrans7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TabelPopup tblpop = new TabelPopup(this, rootPaneCheckingEnabled);
        ProductDao pd=new ProductDao();
        tblpop.getjTable1().setModel(pd.showDataToTableModel(true));
        tblpop.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSideTrans2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans2ActionPerformed
    if(upOrAd=="addsepatu"){        
        try {
            String idAuto="SH001";
            con=(new Koneksi().getConnection());
            ResultSet rs = (con.prepareStatement("select id_product from products order by id_product desc limit 1")).executeQuery();
            if(rs.next()){
                int no = 1+(Integer.parseInt(rs.getString(1).substring(2)));
                if (String.valueOf(no).length()==1) {
                    idAuto="SH00"+no;
                } else if (String.valueOf(no).length()==2) {
                    idAuto="SH0"+no;
                } else if (String.valueOf(no).length()==3) {
                    idAuto="SH"+no;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Data telah penuh, tidak cukup ruang\nHapus beberapa sepatu");
                    return;
                }  
            } 
            con = (new Koneksi().getConnection());
            String sql = "INSERT INTO products VALUES(?,?,?,?,?,?,?,?,default)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idAuto);
            ps.setString(2, txtUname1.getText());
            ps.setString(3, txtUname2.getText());
            ps.setString(4, txtUname3.getText());
            ps.setInt(5, Integer.parseInt(txtUname4.getText()));
            ps.setInt(6, Integer.parseInt(txtUname5.getText()));
            ps.setInt(7, Integer.parseInt(txtUname6.getText()));
            ps.setInt(8, Integer.parseInt(txtUname7.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Sepatu Berhasil Ditambahkan");
            txtUname4.setText("");
            txtUname5.setText("");
            txtUname6.setText("");
            txtUname7.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Tergadi kesalahan, silahkan hubungi developer");
        }
    } else if (upOrAd=="upsepatu") {
        try {
            con=(new Koneksi().getConnection());
            String sql = "UPDATE products SET brand=?, type=?, descr=?, size=?, capital=?, price=?, stock=? WHERE id_product=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(8, txtIDSepatu.getText());
            ps.setString(1, txtUname1.getText());
            ps.setString(2, txtUname2.getText());
            ps.setString(3, txtUname3.getText());
            ps.setInt(4, Integer.parseInt(txtUname4.getText()));
            ps.setInt(5, Integer.parseInt(txtUname5.getText()));
            ps.setInt(6, Integer.parseInt(txtUname6.getText()));
            ps.setInt(7, Integer.parseInt(txtUname7.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Sepatu Berhasil Diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        mngBarangOpen();
    }
    }//GEN-LAST:event_btnSideTrans2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        try {
            ProductDao p = new ProductDao();
            jTable6.setModel(p.searchByAllToTable1(jTextField2.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        txtIDSepatu.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 0).toString());
        txtUname1.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 1).toString());
        txtUname2.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 2).toString());
        txtUname3.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 3).toString());
        txtUname4.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 4).toString());
        txtUname5.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 5).toString());
        txtUname6.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 6).toString());
        txtUname7.setText(jTable6.getValueAt(jTable6.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_jTable6MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cf.setNameAkun(" ");
        cf.setUnameAkun(" ");
        cf.setLevelAkun(" ");
        cf.writeConfig();
        Login lg = new Login();
        lg.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btn_transaksi12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi12ActionPerformed
        if (jTable8.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan pilih salah satu data untuk reset password");
        } else {
            try {
                con = (new Koneksi().getConnection());
                String sql = "Update users set paswd=md5('12345') where uname = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, jTable8.getValueAt(jTable8.getSelectedRow(), 0).toString());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Sukses reset password");
                mngPegawaiOpen();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showConfirmDialog(rootPane, ex);
            }
        }
    }//GEN-LAST:event_btn_transaksi12ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        try {
            UserDao p = new UserDao();
            jTable8.setModel(p.searchByAllToTable1(jTextField4.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        lblHideUname.setText(jTable8.getValueAt(jTable8.getSelectedRow(), 0).toString());
        txtIDSepatu1.setText(jTable8.getValueAt(jTable8.getSelectedRow(), 0).toString());
        txtUname16.setText(jTable8.getValueAt(jTable8.getSelectedRow(), 1).toString());
        if (jTable8.getValueAt(jTable8.getSelectedRow(), 2).toString().equals("kasir")) {
            rbKasir.setSelected(true);
        } else if (jTable8.getValueAt(jTable8.getSelectedRow(), 2).toString().equals("inventori")) {
            rbInvenori.setSelected(true);
        }
        if (jTable8.getValueAt(jTable8.getSelectedRow(), 3).toString().equals("p")) {
            rbPerempuan.setSelected(true);
        } else if (jTable8.getValueAt(jTable8.getSelectedRow(), 3).toString().equals("l")) {
            rbLaki.setSelected(true);
        }
    }//GEN-LAST:event_jTable8MouseClicked

    private void btnSideTrans4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans4ActionPerformed
        String lvl="";
        String jk="";
        
        if (rbKasir.isSelected()) {
            lvl="kasir";
        } else if (rbInvenori.isSelected()) {
            lvl="inventori";
        }
        if (rbPerempuan.isSelected()) {
            jk="p";
        } else if (rbLaki.isSelected()) {
            jk="l";
        }
        
        if(upOrAd=="addpegawai"){
        try {
            con = (new Koneksi().getConnection());
            String sql = "INSERT INTO users VALUES(?,md5('12345'),?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, txtIDSepatu1.getText());
            ps.setString(2, txtUname16.getText());
            ps.setString(3, lvl);
            ps.setString(4, jk);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil Ditambahkan");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Tergadi kesalahan, silahkan hubungi developer");
        }
    } else if (upOrAd=="uppegawai") {
        try {
            con=(new Koneksi().getConnection());
            String sql = "UPDATE users SET uname=?, nama=?, lvl=?, jk=? WHERE uname=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, txtIDSepatu1.getText());
            ps.setString(2, txtUname16.getText());
            ps.setString(3, lvl);
            ps.setString(4, jk);
            ps.setString(5, lblHideUname.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil Diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        mngPegawaiOpen();
    }//GEN-LAST:event_btnSideTrans4ActionPerformed

    private void btnSideExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideExitActionPerformed
        (new Login()).show();
        dispose();
    }//GEN-LAST:event_btnSideExitActionPerformed

    private void tblPromoMngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPromoMngMouseClicked
        txtField1.setText(tblPromoMng.getValueAt(tblPromoMng.getSelectedRow(), 0).toString());
        txtField2.setText(tblPromoMng.getValueAt(tblPromoMng.getSelectedRow(), 1).toString());
        if (tblPromoMng.getValueAt(tblPromoMng.getSelectedRow(), 2).toString().equals("discount")) {
            jRadioButton1.setSelected(true);
        } else {
            jRadioButton2.setSelected(true);
            tblGetFree.setModel(getGetFreeList(txtField1.getText()));
        }
        txtField4.setText(tblPromoMng.getValueAt(tblPromoMng.getSelectedRow(), 3).toString());
        txtField5.setText(tblPromoMng.getValueAt(tblPromoMng.getSelectedRow(), 4).toString());
        txtField6.setText(tblPromoMng.getValueAt(tblPromoMng.getSelectedRow(), 5).toString());
        txtField7.setText(tblPromoMng.getValueAt(tblPromoMng.getSelectedRow(), 6).toString());
        txtField8.setText(tblPromoMng.getValueAt(tblPromoMng.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_tblPromoMngMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        resetTableForm();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblGetFree.getModel();
        if (tblGetFree.getSelectedRow() != -1) {
            model.removeRow(tblGetFree.getSelectedRow());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnSideTrans6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans6ActionPerformed
        String tipepromo=jRadioButton1.isSelected()?"discount":"getfree";
        int banyak = tblGetFree.getRowCount();
        if(upOrAd=="addpromo"){
        try {
            con = (new Koneksi().getConnection());
            String idAuto="PR001";
            ResultSet rs = (con.prepareStatement("select id_promo from promo order by id_promo desc limit 1")).executeQuery();
            if(rs.next()){
                int no = 1+(Integer.parseInt(rs.getString(1).substring(2)));
                if (String.valueOf(no).length()==1) {
                    idAuto="PR00"+no;
                } else if (String.valueOf(no).length()==2) {
                    idAuto="PR0"+no;
                } else if (String.valueOf(no).length()==3) {
                    idAuto="PR"+no;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Data telah penuh, tidak cukup ruang\nHapus beberapa sepatu");
                    return;
                }  
            } 
            String sql = "INSERT INTO promo VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idAuto);
            ps.setString(2, txtField2.getText());
            ps.setString(3, tipepromo);
            ps.setString(4, (txtField4.getText().equals(""))?"0":txtField4.getText());
            ps.setString(5, (txtField5.getText().equals(""))?"0":txtField5.getText());
            ps.setString(6, (txtField6.getText().equals(""))?"0":txtField6.getText());
            ps.setString(7, (txtField7.getText().equals(""))?"0":txtField7.getText());
            ps.setString(8, (txtField8.getText().equals(""))?"0":txtField8.getText());
            ps.executeUpdate();
            if (tipepromo=="getfree") {
            if (banyak > 0){
            for (int i = 0; i < banyak; i++) {
                con = (new Koneksi().getConnection());
                String sqlx = "INSERT INTO getfree VALUES(?,?)";
                PreparedStatement psx = con.prepareStatement(sqlx);
                psx.setString(1, idAuto);
                psx.setString(2, tblGetFree.getValueAt(i, 0).toString());
                psx.executeUpdate();
            }                
            } 
            }
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil Ditambahkan");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Tergadi kesalahan, silahkan hubungi developer");
        }
    } else if (upOrAd=="uppromo") {
        String idPromo=txtField1.getText();
        hapusGetFree(idPromo);
try {
            con = (new Koneksi().getConnection());
            String sql = "UPDATE promo SET name = ?, type=?, discount = ?, max_get_discount = ?,"
                    + " min_buy = ?, min_items = ?, free_lots = ? WHERE id_promo = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(8, idPromo);
            pst.setString(1, txtField2.getText());
            pst.setString(2, tipepromo);
            pst.setString(3, (txtField4.getText().equals(""))?"0":txtField4.getText());
            pst.setString(4, (txtField5.getText().equals(""))?"0":txtField5.getText());
            pst.setString(5, (txtField6.getText().equals(""))?"0":txtField6.getText());
            pst.setString(6, (txtField7.getText().equals(""))?"0":txtField7.getText());
            pst.setString(7, (txtField8.getText().equals(""))?"0":txtField8.getText());
            pst.executeUpdate();
            if (tipepromo=="getfree") {
            if (banyak > 0){
            for (int i = 0; i < banyak; i++) {
                con = (new Koneksi().getConnection());
                String sqlx = "INSERT INTO getfree VALUES(?,?)";
                PreparedStatement psx = con.prepareStatement(sqlx);
                psx.setString(1, idPromo);
                psx.setString(2, tblGetFree.getValueAt(i, 0).toString());
                psx.executeUpdate();
            }                
            } 
            }
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil Ditambahkan");
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Tergadi kesalahan, silahkan hubungi developer \n"+ex);
        }
    }
        mngPromoOpen();
    }//GEN-LAST:event_btnSideTrans6ActionPerformed

    private void btnSrSptPTrans1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSrSptPTrans1ActionPerformed
        try {
            ProductDao p = new ProductDao();
            tblSptTrans.setModel(p.searchByAllToTable(txtSrSptPTrans.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSrSptPTrans1ActionPerformed

    private void txtSrSptPTransKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSrSptPTransKeyReleased
        try {
            ProductDao p = new ProductDao();
            tblSptTrans.setModel(p.searchByAllToTable(txtSrSptPTrans.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSrSptPTransKeyReleased

    private void txtBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarKeyReleased
        hitungKembalian();
    }//GEN-LAST:event_txtBayarKeyReleased

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
//            if (!item.isEmpty()) {
                getPromoSelected();
//            }
        } 
        hitungKembalian();
//        <html><body><b>PR001</b>  [DSC] <b>22%</b> <i><u>Open House</u></i></body></html>
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TabelFreeGet tblpop = new TabelFreeGet(this, rootPaneCheckingEnabled);
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Sepatu"); tableModel.addColumn("Deskripsi"); tableModel.addColumn("Size"); tableModel.addColumn("Harga"); tableModel.addColumn("Stok");tableModel.addColumn("Modal");
        try {
              ResultSet rs = con.createStatement().executeQuery("SELECT * FROM v_sepatu,getfree WHERE getfree.id_product=v_sepatu.id_product AND getfree.id_promo='"+idPromox+"'");
          while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                    rs.getString(5), rs.getString(6), rs.getString(7)};
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        tblpop.getjTable1().setModel(tableModel);
        tblpop.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblGetTrans.getModel();
        if (tblGetTrans.getSelectedRow() != -1) {
            model.removeRow(tblGetTrans.getSelectedRow());
                jButton1.setEnabled(true);
                freelots=freelots+1;
                jLabel1.setText("Sisa = "+freelots);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSideTrans8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans8ActionPerformed
        ConfigApp c = new ConfigApp();
        c.readConfig();
        c.setStoreName(txtUname8.getText());
        c.setStoreAddress(txtUname9.getText());
        c.setSince(txtUname10.getText());
        c.setDbHost(txtUname11.getText());
        c.setDbUname(txtUname12.getText());
        c.setDbPass(txtUname13.getText());
        c.setDbName(txtUname14.getText());
        c.writeConfig();
        JOptionPane.showMessageDialog(rootPane, "Sukses SettingsUp \n Silahkan Login Kembali");
        (new Login()).show();
        dispose();
    }//GEN-LAST:event_btnSideTrans8ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        mngBarangOpen();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnSideTrans11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans11ActionPerformed
        loadChartLaporan();
    }//GEN-LAST:event_btnSideTrans11ActionPerformed

    private void btnSideTrans12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans12ActionPerformed
        printLaporanHarian();
    }//GEN-LAST:event_btnSideTrans12ActionPerformed

    private void btnSideTrans13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSideTrans13ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
                DetTransDao d = new DetTransDao();
        jTable5.setModel(d.selectAllDataToTableModel(false));
    }//GEN-LAST:event_kButton1ActionPerformed

    private void btnSideTrans14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSideTrans14ActionPerformed
        printLaporanBulanan();
    }//GEN-LAST:event_btnSideTrans14ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGTpPromo;
    private javax.swing.ButtonGroup bgJk;
    private javax.swing.ButtonGroup bgLvl;
    private keeptoo.KButton btnSideDBarang;
    private keeptoo.KButton btnSideDPromo;
    private keeptoo.KButton btnSideDash;
    private keeptoo.KButton btnSideExit;
    private keeptoo.KButton btnSideLap;
    private keeptoo.KButton btnSidePeg;
    private keeptoo.KButton btnSideRiwayat;
    private keeptoo.KButton btnSideSettings;
    private keeptoo.KButton btnSideTrans;
    private keeptoo.KButton btnSideTrans11;
    private keeptoo.KButton btnSideTrans12;
    private keeptoo.KButton btnSideTrans13;
    private keeptoo.KButton btnSideTrans14;
    private keeptoo.KButton btnSideTrans2;
    private keeptoo.KButton btnSideTrans3;
    private keeptoo.KButton btnSideTrans4;
    private keeptoo.KButton btnSideTrans5;
    private keeptoo.KButton btnSideTrans6;
    private keeptoo.KButton btnSideTrans7;
    private keeptoo.KButton btnSideTrans8;
    private keeptoo.KButton btnSrSptPTrans;
    private keeptoo.KButton btnSrSptPTrans1;
    private keeptoo.KButton btnUbahToko;
    private keeptoo.KButton btn_transaksi10;
    private keeptoo.KButton btn_transaksi12;
    private keeptoo.KButton btn_transaksi2;
    private keeptoo.KButton btn_transaksi3;
    private keeptoo.KButton btn_transaksi4;
    private keeptoo.KButton btn_transaksi5;
    private keeptoo.KButton btn_transaksi6;
    private keeptoo.KButton btn_transaksi7;
    private keeptoo.KButton btn_transaksi8;
    private keeptoo.KButton btn_transaksi9;
    private javax.swing.JPanel cardLay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jFotoPeg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel j_Laporan;
    private javax.swing.JPanel j_Settings;
    private javax.swing.JPanel j_adPegawai;
    private javax.swing.JPanel j_adPromo;
    private javax.swing.JPanel j_adSepatu;
    private javax.swing.JPanel j_dashboard;
    private javax.swing.JPanel j_dataPegawai;
    private javax.swing.JPanel j_dataPromo;
    private javax.swing.JPanel j_databarang;
    private javax.swing.JPanel j_riwayat;
    private javax.swing.JPanel j_transaksi;
    private javax.swing.JLabel jdlAdPromo;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton11;
    private keeptoo.KButton kButton12;
    private keeptoo.KButton kButton13;
    private keeptoo.KButton kButton14;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton kButton6;
    private keeptoo.KButton kButton7;
    private keeptoo.KButton kButton8;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel10;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private javax.swing.JLabel kembalian;
    private javax.swing.JLabel lSubTOtal;
    private javax.swing.JLabel lbl1WidDash1;
    private javax.swing.JLabel lbl1WidDash2;
    private javax.swing.JLabel lbl1WidDash3;
    private javax.swing.JLabel lbl2WidDash1;
    private javax.swing.JLabel lbl2WidDash2;
    private javax.swing.JLabel lbl2WidDash3;
    private javax.swing.JLabel lblAdrrTokoDash;
    private javax.swing.JLabel lblDiskon;
    private javax.swing.JLabel lblHideUname;
    private javax.swing.JLabel lblNmTokoDash;
    private javax.swing.JLabel lblSptTrans;
    private javax.swing.JLabel lblTblDash;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelMyChart;
    private keeptoo.KGradientPanel pnlWidDash1;
    private keeptoo.KGradientPanel pnlWidDash2;
    private keeptoo.KGradientPanel pnlWidDash3;
    private javax.swing.JRadioButton rbInvenori;
    private javax.swing.JRadioButton rbKasir;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTable tblBeli;
    private javax.swing.JTable tblDash;
    private javax.swing.JTable tblGetFree;
    private javax.swing.JTable tblGetTrans;
    private javax.swing.JTable tblPromoMng;
    private javax.swing.JTable tblSptTrans;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtField1;
    private javax.swing.JTextField txtField2;
    private javax.swing.JTextField txtField4;
    private javax.swing.JTextField txtField5;
    private javax.swing.JTextField txtField6;
    private javax.swing.JTextField txtField7;
    private javax.swing.JTextField txtField8;
    private javax.swing.JTextField txtIDSepatu;
    private javax.swing.JTextField txtIDSepatu1;
    private javax.swing.JTextField txtJmltrns;
    private javax.swing.JTextField txtSrSptPTrans;
    private javax.swing.JTextField txtUname1;
    private javax.swing.JTextField txtUname10;
    private javax.swing.JTextField txtUname11;
    private javax.swing.JTextField txtUname12;
    private javax.swing.JTextField txtUname13;
    private javax.swing.JTextField txtUname14;
    private javax.swing.JTextField txtUname16;
    private javax.swing.JTextField txtUname2;
    private javax.swing.JTextField txtUname3;
    private javax.swing.JTextField txtUname4;
    private javax.swing.JTextField txtUname5;
    private javax.swing.JTextField txtUname6;
    private javax.swing.JTextField txtUname7;
    private javax.swing.JTextField txtUname8;
    private javax.swing.JTextField txtUname9;
    // End of variables declaration//GEN-END:variables

    
    public void staring(){
        jLabel28.setText(cf.getStoreName());
        lblNmTokoDash.setText(cf.getStoreName());
        jLabel29.setText(cf.getStoreAddress());
        lblAdrrTokoDash.setText(cf.getStoreAddress());
        jLabel30.setText(cf.getNameAkun());
        jLabel31.setText(cf.getLevelAkun());
        if (cf.getJkAkun().equals("l")) {
            jFotoPeg.setIcon(new ImageIcon(getClass().getResource("/team1/image/imgMale.png")));
        } else {
            jFotoPeg.setIcon(new ImageIcon(getClass().getResource("/team1/image/imgFemale.png")));
        }
        if(cf.getLevelAkun().toString().equals("inventori")){
            btnSideTrans.setVisible(false);
            btnSideRiwayat.setVisible(false);
            btnSideLap.setVisible(false);
            btnSidePeg.setVisible(false);
            btnSideSettings.setVisible(false);
        } else if(cf.getLevelAkun().toString().equals("kasir")){
            btnSideDBarang.setVisible(false);
            btnSideDPromo.setVisible(false);
            btnSideLap.setVisible(false);
            btnSidePeg.setVisible(false);
            btnSideSettings.setVisible(false);
        } else if(cf.getLevelAkun().toString().equals("owner")){
            btnSideTrans.setVisible(false);
            btnSideDBarang.setVisible(false);
            btnSideDPromo.setVisible(false);
        }
    }
    
    public void showHideFree(){
        if (jRadioButton1.isSelected()) {
            jPanel13.setVisible(false);
            DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Sepatu");  tableModel.addColumn("Ukuran"); tableModel.addColumn("Harga Jual");        
        tblGetFree.setModel(tableModel);
        } else if(jRadioButton2.isSelected()){
            jPanel13.setVisible(true);
        }
    }
    
    private void loadDesign(){
        txtIDSepatu.setBackground(new Color(0,0,0,0));
        txtIDSepatu1.setBackground(new Color(0,0,0,0));
        txtField1.setBackground(new Color(0,0,0,0));
        txtUname1.setBackground(new Color(0,0,0,0));
        txtUname1.setBackground(new Color(0,0,0,0));
        txtUname2.setBackground(new Color(0,0,0,0));
        txtUname3.setBackground(new Color(0,0,0,0));
        txtUname4.setBackground(new Color(0,0,0,0));
        txtUname5.setBackground(new Color(0,0,0,0));
        txtUname6.setBackground(new Color(0,0,0,0));
        txtUname7.setBackground(new Color(0,0,0,0));
        txtUname16.setBackground(new Color(0,0,0,0));
        txtField2.setBackground(new Color(0,0,0,0));
        txtField4.setBackground(new Color(0,0,0,0));
        txtField5.setBackground(new Color(0,0,0,0));
        txtField6.setBackground(new Color(0,0,0,0));
        txtField7.setBackground(new Color(0,0,0,0));
        txtField8.setBackground(new Color(0,0,0,0));
        jPanel7.setBackground(new Color(0,0,0,0));
        jPanel9.setBackground(new Color(0,0,0,0));
        jPanel11.setBackground(new Color(0,0,0,0));
        jPanel15.setBackground(new Color(0,0,0,0));
        jPanel18.setBackground(new Color(0,0,0,0));
        
        txtUname8.setBackground(new Color(0,0,0,0));
        txtUname9.setBackground(new Color(0,0,0,0));
        txtUname10.setBackground(new Color(0,0,0,0));
        txtUname11.setBackground(new Color(0,0,0,0));
        txtUname12.setBackground(new Color(0,0,0,0));
        txtUname13.setBackground(new Color(0,0,0,0));
        txtUname14.setBackground(new Color(0,0,0,0));
        
        jLabel14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        ProfitDao pdo = new ProfitDao();
        lbl2WidDash2.setText(pdo.getStatToday());
        
        ProductDao prdo = new ProductDao();
        lbl2WidDash3.setText(prdo.getShoesEmpty());
    }
    
    
    public void mngBarangOpen(){
        btnSideSettings.setSelected(false);
        cardLayout.show(cardLay, "cardDtBarang");
        btnSideDash.setSelected(false);
        btnSideTrans.setSelected(false);
        btnSideRiwayat.setSelected(false);
        btnSideDBarang.setSelected(true);
        btnSideDPromo.setSelected(false);
        btnSideLap.setSelected(false);
        btnSidePeg.setSelected(false);
        ProductDao p = new ProductDao();
        jTable6.setModel(p.selectAllDataToTableModel(true));
        
        btnSideTrans3.setVisible(true);
        jTextField2.setText("Pencarian");
        txtIDSepatu.setText("ID Otomatis");
        txtUname1.setText("");
        txtUname2.setText("");
        txtUname3.setText("");
        txtUname4.setText("");
        txtUname5.setText("");
        txtUname6.setText("");
        txtUname7.setText("");
    }
    
    public void mngPegawaiOpen(){
        cardLayout.show(cardLay, "cardDtPegawai");
        btnSideSettings.setSelected(false);
        btnSideDash.setSelected(false);
        btnSideTrans.setSelected(false);
        btnSideRiwayat.setSelected(false);
        btnSideDBarang.setSelected(false);
        btnSideDPromo.setSelected(false);
        btnSideLap.setSelected(false);
        btnSidePeg.setSelected(true);
        UserDao ud = new UserDao();
        jTable8.setModel(ud.selectAllDataToTableModel(true));
        
        btnSideTrans5.setVisible(true);
        jTextField4.setText("Pencarian");
        txtIDSepatu.setText("");
        txtUname16.setText("");
        bgLvl.clearSelection();
        bgJk.clearSelection();
    }
    
    public void mngPromoOpen(){
        cardLayout.show(cardLay, "cardDtPromo");
        btnSideSettings.setSelected(false);
        btnSideDash.setSelected(false);
        btnSideTrans.setSelected(false);
        btnSideRiwayat.setSelected(false);
        btnSideDBarang.setSelected(false);
        btnSideDPromo.setSelected(true);
        btnSideLap.setSelected(false);
        btnSidePeg.setSelected(false);
        PromoDao pr = new PromoDao();
        tblPromoMng.setModel(pr.selectAllDataToTableModel(true));
        
        btnSideTrans3.setVisible(true);
        clearPromoForm();
    }
    
    private void clearPromoForm(){
        txtField1.setText("ID Otomatis");
        txtField2.setText("");
        txtField4.setText("");
        txtField5.setText("");
        txtField6.setText("");
        txtField7.setText("");
        txtField8.setText("");
        jRadioButton2.setSelected(true);
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Sepatu");  tableModel.addColumn("Ukuran"); tableModel.addColumn("Harga Jual");        
        tblGetFree.setModel(tableModel);
    }
    
    private void resetTableForm(){
        if (upOrAd=="uppromo") {
            GetFreeDao gfd = new GetFreeDao();
            tblGetFree.setModel(gfd.selectAllDataToTableModel(txtField1.getText()));
        } else {
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Sepatu");  tableModel.addColumn("Ukuran"); tableModel.addColumn("Harga Jual");        
        tblGetFree.setModel(tableModel);
        }
    }
    
    private void resetTblBeli(){
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Sepatu");  tableModel.addColumn("Jumlah");
        tableModel.addColumn("Harga");  tableModel.addColumn("Total"); tableModel.addColumn("Modal");
        tblBeli.setModel(tableModel);
        diskon=0;
        diskonx=0;
        bnyk =0;
        maxDis=0;
        subtotal=0;
        totModal=0;
        kbalian=0;
        idPromox="";
        tipePromo="";
        nmPromo="";
        idTrans="";
        freelots=0;
        total = subtotal-diskon;
        lSubTOtal.setText(subtotal+"");
        lblDiskon.setText(diskon+"");
        lblTotal.setText(total+"");
        txtBayar.setText("");
        kembalian.setText("Rp");
    }
    
    public DefaultTableModel getGetFreeList(String id){
        GetFreeDao gfd = new GetFreeDao();
        return gfd.selectAllDataToTableModel(id);
    }
    
    public void hapusGetFree(String id){
            try {
                con = (new Koneksi().getConnection());
                String sql = "delete from getfree where id_promo = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showConfirmDialog(rootPane, ex);
            }    
    }
    public void hapusPromo(String id){
            try {
                con = (new Koneksi().getConnection());
                String sql = "delete from promo where id_promo = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showConfirmDialog(rootPane, ex);
            }
    }
    
    private void mngTransOpen(){
        cardLayout.show(cardLay, "cardTransaksi");
        btnSideDash.setSelected(false);
        btnSideTrans.setSelected(true);
        btnSideRiwayat.setSelected(false);
        btnSideDBarang.setSelected(false);
        btnSideDPromo.setSelected(false);
        btnSideLap.setSelected(false);
        btnSidePeg.setSelected(false);
        btnSideSettings.setSelected(false);
        refreshSepatu();
        resetTblBeli();
        jComboBox1.removeAllItems();
        hidePromo(true);
    }
    
    private void refreshSepatu(){
        ProductDao p = new ProductDao();
        tblSptTrans.setModel(p.showDataToTableModel(true));
        lblSptTrans.setText("Nama");
        txtJmltrns.setText("1");
    }
    
    private void addPromoCombo(){
        jComboBox1.removeAllItems();
    
        try {
            con = (new Koneksi().getConnection());
            ResultSet rst = con.createStatement().executeQuery("SELECT * FROM promo where min_items <= "+lots+" and min_buy <= "+subtotal+" ");
            while (rst.next()) {
                diskonx=rst.getInt(4);
                maxDis=rst.getInt(5);
                idPromox=rst.getString(1);
                tipePromo=((rst.getString(3).equalsIgnoreCase("getfree"))?"GFR":"DSC");
                nmPromo=rst.getString(2);
                freelots=rst.getInt(8);
                String out = "<html>"
                        + "<body>"
                        + "<b>"+idPromox+"</b>  ["+tipePromo+"] <b>"+diskonx+"%</b> <i><u>"+nmPromo+"</u></i>"
                        + "</body>"
                        + "</html>";
                jComboBox1.addItem(out);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void hidePromo(boolean tts){
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("Kode"); tableModel.addColumn("Merek");  tableModel.addColumn("Size");
        tblGetTrans.setModel(tableModel);
        jButton1.setVisible(!tts);
        jButton2.setVisible(!tts);
        jLabel1.setText("Sisa = 0");
        jLabel1.setVisible(!tts);
        jScrollPane8.setVisible(!tts);
    }
    
    private void getPromoSelected(){
        jButton1.setEnabled(true);
        tipePromo = jComboBox1.getSelectedItem().toString().substring(27,30);
        idPromox = jComboBox1.getSelectedItem().toString().substring(15,20);
                if (tipePromo.equals("GFR")) {
                    hidePromo(false);
                } else {
                    hidePromo(true);
                }
        try {
            con = (new Koneksi().getConnection());
            ResultSet rst = con.createStatement().executeQuery("SELECT * FROM promo where id_promo = '"+idPromox+"' ");
            while (rst.next()) {
                diskonx=rst.getInt(4);
                maxDis=rst.getInt(5);
                idPromox=rst.getString(1);
                tipePromo=rst.getString(3);
                nmPromo=rst.getString(2);
                freelots=rst.getInt(8);
                jLabel1.setText("Sisa = "+freelots);
                perhitungan();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    private void perhitungan(){
        diskon = (subtotal*diskonx)/100;
        total = subtotal-diskon;
            lSubTOtal.setText(subtotal+"");
            lblDiskon.setText(diskon+" ("+diskonx+"%)");
            lblTotal.setText(total+"");
    }
    
    private void hitungKembalian(){
        if (!txtBayar.getText().toString().isEmpty()) {
        int tot = Integer.parseInt(lblTotal.getText());
        int byr = Integer.parseInt(txtBayar.getText());
        kbalian = byr-tot;
        kembalian.setText("Rp. "+kbalian);            
        }
    }
    
    private void printTxt(){
        ConfigApp cf = new ConfigApp();
        cf.readConfig();
        File file = new File("C:\\Users\\Public\\Documents\\printshoescash.txt");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");  
        Date date = new Date();  
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write("     "+cf.getStoreName()); bw.newLine();
            bw.write("     "+cf.getStoreAddress());bw.newLine();
            bw.write("     Since : "+cf.getSince()); bw.newLine();
            bw.write("====================================="); bw.newLine();
            bw.write(dateFormat.format(date)); bw.newLine();  bw.newLine();bw.newLine();
            for (int i = 0; i < tblBeli.getRowCount(); i++) {
                bw.write(tblBeli.getValueAt(i, 1).toString()+"\n"+tblBeli.getValueAt(i, 2).toString()
                +"\t\t\t = "+tblBeli.getValueAt(i, 4).toString()); bw.newLine();
            }
            bw.newLine();
            bw.write("--------------- PROMO -----------------");bw.newLine();
            bw.write(nmPromo +" "+tipePromo); bw.newLine();
            for (int i = 0; i < tblGetTrans.getRowCount(); i++) {
                bw.write(tblGetTrans.getValueAt(i, 1).toString()+"\t Free"); bw.newLine();
            }
            bw.newLine();
            bw.write("---------------------------------------"); bw.newLine();bw.newLine();
            bw.write("Sub Total \t: "+lSubTOtal.getText()); bw.newLine();
            bw.write("Diskon \t\t: "+lblDiskon.getText()); bw.newLine();
            bw.write("Total Belanja \t: "+lblTotal.getText()); bw.newLine();bw.newLine();
            bw.write("Bayar \t\t: Rp. "+txtBayar.getText()); bw.newLine();
            bw.write("Kembalian \t: "+kembalian.getText()); bw.newLine();bw.newLine();
            bw.write("\n\n-\n-      ~ TERIMA KASIH ~"); bw.newLine();
            
        }catch(FileNotFoundException ex){
            System.out.println("File "+file.getName()+" Tidak Ditemukan"); 
        }catch(IOException ex){
            System.out.println("File "+file.getName()+" Tidak Dapat DIbaca");
        }
    }
    
    private void saveTransSql(){
        int totSoltx=0;
        for (int i = 0; i < tblBeli.getRowCount(); i++) {
            totSoltx+=Integer.parseInt(tblBeli.getValueAt(i, 2).toString());
        }
        totSoltx+=tblGetTrans.getRowCount();
        try {
            String idAuto="TR001";
            con=(new Koneksi().getConnection());
            ResultSet rs = (con.prepareStatement("select id_trans from transaction order by id_trans desc limit 1")).executeQuery();
            if(rs.next()){
                int no = 1+(Integer.parseInt(rs.getString(1).substring(2)));
                if (String.valueOf(no).length()==1) {
                    idAuto="TR00"+no;
                } else if (String.valueOf(no).length()==2) {
                    idAuto="TR0"+no;
                } else if (String.valueOf(no).length()==3) {
                    idAuto="TR"+no;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Data telah penuh, tidak cukup ruang\nHapus beberapa sepatu");
                    return;
                }  
            } 
            con.close();
            con = (new Koneksi().getConnection());
            String sqltd = "INSERT INTO transaction VALUES(?,NOW(),?,?,?,?,?)";
            PreparedStatement pstd = con.prepareStatement(sqltd);
            pstd.setString(1, ""+idAuto);
            pstd.setInt(2,totSoltx);
            pstd.setString(3, idPromox);
            pstd.setInt(4, diskonx);
            pstd.setInt(5, totModal);
            pstd.setInt(6, total);
            pstd.executeUpdate();
            con.close();
            try{
            for (int i = 0; i < tblBeli.getRowCount(); i++) {
                con = (new Koneksi().getConnection());
                String sqldet = "INSERT INTO trans_detail VALUES(?,?,?,?,?,?)";
                PreparedStatement psd = con.prepareStatement(sqldet);
                psd.setString(1, idAuto);
                psd.setString(2, tblBeli.getValueAt(i, 0).toString());
                psd.setInt(3, Integer.parseInt(tblBeli.getValueAt(i, 2).toString()));
                psd.setInt(4, Integer.parseInt(tblBeli.getValueAt(i, 5).toString()));
                psd.setInt(5, Integer.parseInt(tblBeli.getValueAt(i, 4).toString()));
                psd.setString(6, "0");
                psd.executeUpdate();
                con.close();
            }
            } catch (SQLException e){
                JOptionPane.showMessageDialog(rootPane, "2"+e);
            }
            try{
            for (int i = 0; i < tblGetTrans.getRowCount(); i++) {
                con = (new Koneksi().getConnection());
                ResultSet rst = con.createStatement().executeQuery("SELECT * FROM products where id_product = '"+
                        tblGetTrans.getValueAt(i, 0).toString()+"' ");
                int m=0;
                
            while (rst.next()) {
                m =rst.getInt("capital");
            }
            con.close();
            con = (new Koneksi().getConnection());
                String sqldet1 = "INSERT INTO trans_detail VALUES(?,?,'1',?,'5',?)";
                PreparedStatement psd1 = con.prepareStatement(sqldet1);
                psd1.setString(1, idAuto);
                psd1.setString(2, tblGetTrans.getValueAt(i, 0).toString());
                psd1.setInt(3, m);
                psd1.setString(4, "1");
                psd1.executeUpdate();
                con.close();
            }} catch (SQLException e){
                JOptionPane.showMessageDialog(rootPane, "1"+e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Tergadi kesalahan, silahkan hubungi developer"+ex);
        }
    }
    
    private void mngLaporanOpen(){
        cardLayout.show(cardLay, "cardLaporan");   
        btnSideDash.setSelected(false);
        btnSideTrans.setSelected(false);
        btnSideRiwayat.setSelected(false);
        btnSideDBarang.setSelected(false);
        btnSideDPromo.setSelected(false);
        btnSideLap.setSelected(true);
        btnSidePeg.setSelected(false);
        btnSideSettings.setSelected(false);
        ProfitDao pd = new ProfitDao();
        jTable1.setModel(pd.selectAllDataToTableModel());
        loadChartLaporan();
    }
    
    private void loadChartLaporan(){
        con = (new Koneksi().getConnection());
        try{
            String q= "SELECT date, income_today,admission_fee_today FROM `profit`";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(con, q);
            JFreeChart chart = ChartFactory.createLineChart("Query Chart","Tanggal","Pendapatan", dataset, PlotOrientation.VERTICAL, false, false, false);
            CategoryPlot catPlot = chart.getCategoryPlot();
            ChartPanel chartPanel=new ChartPanel(chart);
            panelMyChart.removeAll();
            panelMyChart.add(chartPanel, BorderLayout.CENTER);
            panelMyChart.validate();
            
            
        } catch (Exception e){
        }
    }
    
    private void printLaporanHarian(){
         try {
            HashMap parameter = new HashMap();
            JasperPrint jasperPrint = null;
//            jasperPrint = JasperFillManager.fillReport("team1/resources/LaporanHarian.jasper", parameter,con);
            jasperPrint = JasperFillManager.fillReport("C:\\Users\\bayug\\Documents\\NetBeansProjects\\Shoes Cash\\src\\team1\\resources\\LaporanHarian.jasper", parameter,con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, "Gagal LoadJasper Report"+ex);
        }
    }
    
     private void printLaporanBulanan(){
         try {
            HashMap parameter = new HashMap();
            JasperPrint jasperPrint = null;
//            jasperPrint = JasperFillManager.fillReport("team1/resources/LaporanHarian.jasper", parameter,con);
            jasperPrint = JasperFillManager.fillReport("C:\\Users\\bayug\\Documents\\NetBeansProjects\\Shoes Cash\\src\\team1\\resources\\LaporanBulanan.jasper", parameter,con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, "Gagal LoadJasper Report"+ex);
        }
    }
    
    private void mngDashOpen(){
        DetTransDao detTransDao = new DetTransDao();
        tblDash.setModel(detTransDao.selectAllDataToTableModel(false));
        lbl2WidDash1.setText(detTransDao.getStatToday());
        ProfitDao pdo = new ProfitDao();
        lbl2WidDash2.setText(pdo.getStatToday());
        
        ProductDao prdo = new ProductDao();
        lbl2WidDash3.setText(prdo.getShoesEmpty());
    }
}

