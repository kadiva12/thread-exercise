import javax.swing.*;
import java.awt.*;

public class HalamanPesanan extends JPanel {
    
    private GridLayout layoutUtama;
    private FlowLayout layoutJudul;
    private GridLayout layoutInfo;
    private GridLayout layoutLayanan;
    private GridLayout layoutTotal;
    private FlowLayout layoutTombol;
    private JPanel panelJudul;
    private JPanel panelInformasi;
    private JPanel panelLayanan;
    private JPanel panelTotal;
    private JPanel panelTombol;
    private ImageIcon iconSukses;
    private JLabel labelJudul;
    private JLabel labelLayanan;
    private JLabel labelNamaLayanan;
    private JLabel labelTotalJudul;
    private JLabel labelTotal;
    private JCheckBox checkHosting;
    private JButton tombolKembali;
    private JButton tombolHitung;
    private JButton tombolSimpan;
    private int hargaWebsite;
    private int hargaHosting;

    private Main frame;

    public HalamanPesanan(Main frame) {
        this.frame = frame;

        // Data
        hargaWebsite = 1049000;
        hargaHosting = 100000;

        // Layout manager
        layoutUtama = new GridLayout(3, 1, 0, 4);
        layoutJudul = new FlowLayout(FlowLayout.CENTER, 12, 8);
        layoutInfo = new GridLayout(3, 1, 0, 4);
        layoutLayanan = new GridLayout(1, 2, 8, 0);
        layoutTotal = new GridLayout(1, 2, 8, 0);
        layoutTombol = new FlowLayout(FlowLayout.CENTER, 12, 8);

        // Panel
        panelJudul = new JPanel();
        panelInformasi = new JPanel();
        panelLayanan = new JPanel();
        panelTotal = new JPanel();
        panelTombol = new JPanel();

        // Ikon
        iconSukses = new ImageIcon("oop-module-3-kadiva12/assets/check.png");

        // Label
        labelJudul = new JLabel("Detail Pesanan");
        labelLayanan = new JLabel("Layanan Website:");
        labelNamaLayanan = new JLabel("Website Profesional (Rp1.049.000)");
        labelTotalJudul = new JLabel("Total Harga:");
        labelTotal = new JLabel(formatRupiah(hargaWebsite));

        // Checkbox
        checkHosting = new JCheckBox("Hosting 1 Tahun (+Rp100.000)");

        // Tombol
        tombolKembali = new JButton("Kembali");
        tombolHitung = new JButton("Hitung Total");
        tombolSimpan = new JButton("Simpan");

        // Pengaturan font dan warna
        labelJudul.setFont(Theme.JUDUL);
        labelJudul.setForeground(Theme.BIRU);
        labelLayanan.setFont(Theme.SUBJUDUL);
        labelLayanan.setForeground(Theme.HITAM);
        labelNamaLayanan.setFont(Theme.SUBJUDUL);
        labelNamaLayanan.setForeground(Theme.HITAM);
        labelTotalJudul.setFont(Theme.SUBJUDUL);
        labelTotalJudul.setForeground(Theme.HITAM);
        labelTotal.setFont(Theme.SUBJUDUL);
        labelTotal.setForeground(Theme.BIRU);

        checkHosting.setFont(Theme.SUBJUDUL);
        checkHosting.setForeground(Theme.HITAM);
        checkHosting.setBackground(Theme.PUTIH);
        checkHosting.setFocusPainted(false);

        tombolKembali.setFont(Theme.TOMBOL);
        tombolKembali.setBackground(Theme.PUTIH);
        tombolKembali.setForeground(Theme.BIRU);
        tombolKembali.setOpaque(true);
        tombolKembali.setFocusPainted(false);

        tombolHitung.setFont(Theme.TOMBOL);
        tombolHitung.setBackground(Theme.BIRU);
        tombolHitung.setForeground(Theme.PUTIH);
        tombolHitung.setOpaque(true);
        tombolHitung.setFocusPainted(false);

        tombolSimpan.setFont(Theme.TOMBOL);
        tombolSimpan.setBackground(Theme.KUNING);
        tombolSimpan.setForeground(Theme.BIRU);
        tombolSimpan.setOpaque(true);
        tombolSimpan.setFocusPainted(false);

        // Aksi tombol
        tombolKembali.addActionListener(e -> frame.bukaKatalog());
        tombolHitung.addActionListener(e -> hitungTotal());
        tombolSimpan.addActionListener(e -> simpanPesanan());

        // Susun panel judul
        panelJudul.setLayout(layoutJudul);
        panelJudul.add(labelJudul);

        // Susun panel layanan
        panelLayanan.setLayout(layoutLayanan);
        panelLayanan.setBackground(Theme.PUTIH);
        panelLayanan.add(labelLayanan);
        panelLayanan.add(labelNamaLayanan);

        // Susun panel total
        panelTotal.setLayout(layoutTotal);
        panelTotal.setBackground(Theme.PUTIH);
        panelTotal.add(labelTotalJudul);
        panelTotal.add(labelTotal);

        // Susun panel informasi
        panelInformasi.setLayout(layoutInfo);
        panelInformasi.setBackground(Theme.PUTIH);
        panelInformasi.add(panelLayanan);
        panelInformasi.add(checkHosting);
        panelInformasi.add(panelTotal);

        // Susun panel tombol
        panelTombol.setLayout(layoutTombol);
        panelTombol.setBackground(Theme.PUTIH);
        panelTombol.add(tombolKembali);
        panelTombol.add(tombolHitung);
        panelTombol.add(tombolSimpan);

        // Susun halaman
        setLayout(layoutUtama);
        setBackground(Theme.PUTIH);
        add(panelJudul);
        add(panelInformasi);
        add(panelTombol);
    }

    private String formatRupiah(int nilai) {
        return "Rp" + String.format("%,d", nilai).replace(',', '.');
    }

    public void hitungTotal() {
        int total = hargaWebsite;
        if (checkHosting.isSelected()) {
            total = total + hargaHosting;
        }
        labelTotal.setText(formatRupiah(total));
    }

    public void resetPesanan() {
        checkHosting.setSelected(false);
        labelTotal.setText(formatRupiah(hargaWebsite));
    }

    public void simpanPesanan() {
    tombolSimpan.setEnabled(false);
    tombolSimpan.setText("Memproses...");

    Thread proses = new Thread(() -> prosesSimpan());
    proses.start();
}

private void prosesSimpan() {
    try {
        Thread.sleep(1500);   
    } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
    }
    SwingUtilities.invokeLater(() -> selesaiSimpan());
}

private void selesaiSimpan() {
    JOptionPane.showMessageDialog(this, "Order Sukses", "DNE DEVS", JOptionPane.PLAIN_MESSAGE, iconSukses);
    tombolSimpan.setText("Simpan");
    tombolSimpan.setEnabled(true);
    resetPesanan();
    frame.bukaKatalog();
}
}