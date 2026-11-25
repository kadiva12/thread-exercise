# thread-exercise

A desktop application built with Java Swing for the DNE DEVS operations team.
It displays a catalog of website packages, calculates the total cost instantly (including the hosting add-on), and shows an order confirmation.

## Features

1. Service Catalog: DNE DEVS logo, title, two package cards (Company Profile and E-Commerce), and an "Pesan Sekarang" (Order Now) button.
2. Order Details: the Professional Website package (Rp1,049,000) with an optional 1-Year Hosting add-on (+Rp100,000) via a `JCheckBox`.
   - Hitung Total (Calculate Total): Rp1,049,000 without hosting, Rp1,149,000 with hosting checked.
   - Kembali (Back): returns to the catalog.
   - Simpan (Save): shows an "Order Sukses" dialog, resets the form, then returns to the catalog.

  ## Thread

  Click Simpan                                   
 ├─ 1. Button is disabled, text becomes
 │     "Memproses..."                          
 ├─ 2. A new Thread starts the slow work       
 │     └─ simulated by Thread.sleep(1500)             
 └─ 3. SwingUtilities.invokeLater(...)         
       └─ selesaiSimpan():
          • show "Order Sukses" dialog
          • restore button text and enable it
          • resetPesanan() and go back to the catalog
```

So the order is: process first (on the worker thread) → then show "Order Sukses". The success dialog only appears after the processing is finished.

## Code

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
    JOptionPane.showMessageDialog(this, "Order Sukses", "DNE DEVS",
            JOptionPane.PLAIN_MESSAGE, iconSukses);
    tombolSimpan.setText("Simpan");
    tombolSimpan.setEnabled(true);
    resetPesanan();
    frame.bukaKatalog();
}

## Screenshot

<img width="1006" height="676" alt="Screenshot 2026-11-25 203356" src="https://github.com/user-attachments/assets/0a610a2a-f6ad-4138-bf90-cd0970af557f" />

<img width="1006" height="680" alt="Screenshot 2026-11-25 203409" src="https://github.com/user-attachments/assets/3d63582f-4e42-4edf-a91f-cde24a87caa0" />

<img width="1000" height="678" alt="Screenshot 2026-11-25 203420" src="https://github.com/user-attachments/assets/e01b494f-b7c7-4f71-93a2-61640ba556d3" />


