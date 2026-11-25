import javax.swing.*;
import java.awt.*;

public class HalamanKatalog extends JPanel {
  
    private GridLayout layoutUtama;
    private GridLayout layoutAtas;
    private GridLayout layoutKartu;
    private GridLayout layoutCompany;
    private GridLayout layoutEcommerce;
    private FlowLayout layoutBawah;
    private JPanel panelAtas;
    private JPanel panelKartu;
    private JPanel panelBawah;
    private JPanel kartuCompany;
    private JPanel kartuEcommerce;
    private ImageIcon iconLogo;
    private ImageIcon iconCompany;
    private ImageIcon iconEcommerce;
    private JLabel labelLogo;
    private JLabel labelJudul;
    private JLabel gambarCompany;
    private JLabel gambarEcommerce;
    private JLabel namaCompany;
    private JLabel namaEcommerce;
    private JButton tombolPesan;

    private Main frame;

    public HalamanKatalog(Main frame) {
        this.frame = frame;

        // Layout manager
        layoutUtama = new GridLayout(3, 1, 0, 4);
        layoutAtas = new GridLayout(2, 1, 0, 4);
        layoutKartu = new GridLayout(1, 2, 12, 0);
        layoutCompany = new GridLayout(2, 1, 0, 4);
        layoutEcommerce = new GridLayout(2, 1, 0, 4);
        layoutBawah = new FlowLayout(FlowLayout.CENTER, 12, 8);

        // Panel
        panelAtas = new JPanel();
        panelKartu = new JPanel();
        panelBawah = new JPanel();
        kartuCompany = new JPanel();
        kartuEcommerce = new JPanel();

        // Ikon
        iconLogo = new ImageIcon("thread/assets/logo_dne.png");
        iconCompany = new ImageIcon("thread/assets/company.png");
        iconEcommerce = new ImageIcon("thread/assets/ecommerce.png");

        // Label
        labelLogo = new JLabel(iconLogo);
        labelJudul = new JLabel("Katalog Layanan", SwingConstants.CENTER);
        gambarCompany = new JLabel(iconCompany);
        gambarEcommerce = new JLabel(iconEcommerce);
        namaCompany = new JLabel("Company Profile", SwingConstants.CENTER);
        namaEcommerce = new JLabel("E-Commerce", SwingConstants.CENTER);

        // Tombol
        tombolPesan = new JButton("Pesan Sekarang");

        // Pengaturan label dan tombol
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
        gambarCompany.setHorizontalAlignment(SwingConstants.CENTER);
        gambarEcommerce.setHorizontalAlignment(SwingConstants.CENTER);

        labelJudul.setFont(Theme.JUDUL);
        labelJudul.setForeground(Theme.BIRU);
        namaCompany.setFont(Theme.SUBJUDUL);
        namaCompany.setForeground(Theme.HITAM);
        namaEcommerce.setFont(Theme.SUBJUDUL);
        namaEcommerce.setForeground(Theme.HITAM);

        tombolPesan.setFont(Theme.TOMBOL);
        tombolPesan.setBackground(Theme.BIRU);
        tombolPesan.setForeground(Theme.PUTIH);
        tombolPesan.setOpaque(true);
        tombolPesan.setFocusPainted(false);
        tombolPesan.addActionListener(e -> frame.bukaPesanan());

        // Susun panel atas
        panelAtas.setLayout(layoutAtas);
        panelAtas.setBackground(Theme.PUTIH);
        panelAtas.add(labelLogo);
        panelAtas.add(labelJudul);

        // Susun kartu company
        kartuCompany.setLayout(layoutCompany);
        kartuCompany.setBackground(Theme.PUTIH);
        kartuCompany.setBorder(BorderFactory.createLineBorder(Theme.BIRU, 1));
        kartuCompany.add(gambarCompany);
        kartuCompany.add(namaCompany);

        // Susun kartu e-commerce
        kartuEcommerce.setLayout(layoutEcommerce);
        kartuEcommerce.setBackground(Theme.PUTIH);
        kartuEcommerce.setBorder(BorderFactory.createLineBorder(Theme.BIRU, 1));
        kartuEcommerce.add(gambarEcommerce);
        kartuEcommerce.add(namaEcommerce);

        // Susun panel tengah
        panelKartu.setLayout(layoutKartu);
        panelKartu.setBackground(Theme.PUTIH);
        panelKartu.add(kartuCompany);
        panelKartu.add(kartuEcommerce);

        // Susun panel bawah
        panelBawah.setLayout(layoutBawah);
        panelBawah.setBackground(Theme.PUTIH);
        panelBawah.add(tombolPesan);

        // Susun halaman
        setLayout(layoutUtama);
        setBackground(Theme.PUTIH);
        add(panelAtas);
        add(panelKartu);
        add(panelBawah);
    }
    
}