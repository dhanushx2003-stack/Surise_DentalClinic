/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.BillController;
import dao.AppointmentDAO;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.Chunk;
import com.lowagie.text.pdf.BaseFont;

/**
 *
 * @author DELL
 */
public class BillForm extends javax.swing.JFrame {

    /**
     * Creates new form BillForm
     */
    public BillForm() {
        initComponents();

        setLocation(470, 150);

        Font font = new Font("Times New Roman", Font.PLAIN, 14);

        jTextField1.setFont(font);
        jTextField2.setFont(font);
        jTextField3.setFont(font);
        jTextField4.setFont(font);
        jTextField5.setFont(font);
        jTextField6.setFont(new Font("Times New Roman", Font.BOLD, 14));
        jTextField7.setFont(font);
    }

    private void PrintBill() {

        if (jTextField1.getText().trim().isEmpty() || jTextField2.getText().trim().isEmpty() || jTextField6.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Appointment Number", "Print Bill", JOptionPane.WARNING_MESSAGE);

            return;
        }

        String PatientName = jTextField2.getText().trim();

        String FilePath = System.getProperty("user.home") + "\\Desktop\\Sunrise_DentalClinic Bill_" + PatientName + ".pdf";

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(FilePath));

            document.open();
            BaseFont timesRoman = BaseFont.createFont("C:\\Windows\\Fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            com.lowagie.text.Font headerFont = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 20, com.lowagie.text.Font.BOLD);
            com.lowagie.text.Font normalFont = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 18, com.lowagie.text.Font.NORMAL);
            com.lowagie.text.Font totalFont = new com.lowagie.text.Font(com.lowagie.text.Font.TIMES_ROMAN, 18, com.lowagie.text.Font.BOLD);

            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidths(new float[]{80, 250});

            headerTable.setTotalWidth(330);
            headerTable.setLockedWidth(true);

            headerTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);

            Image logo = Image.getInstance(getClass().getResource("/Images/tooth.png"));
            logo.scaleToFit(100, 100);

          


            Paragraph header = new Paragraph();
            header.setAlignment(Paragraph.ALIGN_CENTER);


            Chunk logoChunk = new Chunk(logo, 0, -40);


            header.add(logoChunk);
            header.add(new Chunk("   SUNRISE DENTAL CLINIC", headerFont));


            document.add(header);

            document.add(new Paragraph(" "));

            document.add(new Paragraph("Appointment Number: " + jTextField1.getText(), normalFont));
            document.add(new Paragraph("Patient Name: " + jTextField2.getText(), normalFont));
            document.add(new Paragraph("Dentist Name: " + jTextField3.getText(), normalFont));
            document.add(new Paragraph("Treatment Type: " + jTextField4.getText(), normalFont));
            document.add(new Paragraph("Treatment Cost: " + jTextField5.getText(), normalFont));
            document.add(new Paragraph("Consultation Fee: " + jTextField7.getText(), normalFont));
            document.add(new Paragraph("-------------------------------------------", normalFont));
            document.add(new Paragraph("Total Cost: " + jTextField6.getText(), normalFont));

            document.close();

            File pdfFile = new File(FilePath);

            String[] chromePaths = {
                "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
                System.getProperty("user.home") + "\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"
            };

            boolean chromeOpened = false;

            for (String chromePath : chromePaths) {
                File chrome = new File(chromePath);

                if (chrome.exists()) {
                    new ProcessBuilder(chromePath, pdfFile.getAbsolutePath()).start();

                    chromeOpened = true;

                    break;
                }
            }

            if (!chromeOpened) {
                JOptionPane.showMessageDialog(
                        this,
                        "PDF Saved: " + FilePath + "\nGoogle Chrome not opening.",
                        "Bill Saved",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(this, "Error:\n" + e.getMessage(), "PDF Error", JOptionPane.ERROR_MESSAGE);

            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Billbtn1 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        Searchbtn = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        Billbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Patient Name");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        Billbtn1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Billbtn1.setText("Print Bill");
        Billbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Billbtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Billbtn1MouseExited(evt);
            }
        });
        Billbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Billbtn1ActionPerformed(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Treatment Cost");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Total Cost");

        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Treatment Type");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Patient Treatment Bill");

        jTextField7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Consultation Fee");

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        Searchbtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Searchbtn.setText("Search");
        Searchbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchbtnMouseExited(evt);
            }
        });
        Searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchbtnActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        Billbtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Billbtn.setText("Back");
        Billbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BillbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BillbtnMouseExited(evt);
            }
        });
        Billbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillbtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Patient Name");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Dentist Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(132, 132, 132))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(Searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(151, 151, 151)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField7)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Billbtn1)
                        .addGap(64, 64, 64)
                        .addComponent(Billbtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Searchbtn)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Billbtn)
                    .addComponent(Billbtn1))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Billbtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Billbtn1MouseEntered
        // TODO add your handling code here:
        Billbtn1.setBackground(Color.GREEN);
    }//GEN-LAST:event_Billbtn1MouseEntered

    private void Billbtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Billbtn1MouseExited
        // TODO add your handling code here:
        Billbtn1.setBackground(Color.WHITE);
    }//GEN-LAST:event_Billbtn1MouseExited

    private void Billbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Billbtn1ActionPerformed
        // TODO add your handling code here:

        PrintBill();
    }//GEN-LAST:event_Billbtn1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void SearchbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbtnMouseEntered
        // TODO add your handling code here:
        Searchbtn.setBackground(Color.green);
    }//GEN-LAST:event_SearchbtnMouseEntered

    private void SearchbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchbtnMouseExited
        // TODO add your handling code here:
        Searchbtn.setBackground(Color.white);
    }//GEN-LAST:event_SearchbtnMouseExited

    private void SearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbtnActionPerformed
        // TODO add your handling code here:
        String Appointmentumber = jTextField1.getText();
        BillController controller = new BillController();
        String Validation = controller.ValidateAppointmentNumber(Appointmentumber);

        if (!Validation.equals("Valid Appointment Number")) {
            JOptionPane.showMessageDialog(this, Validation);
            return;
        }

        int AppointmentNo = Integer.parseInt(jTextField1.getText());
        AppointmentDAO dao = new AppointmentDAO();
        ResultSet rs = dao.searchAppointment(AppointmentNo);

        try {
            if (rs.next()) {
                jTextField2.setText(rs.getString("PatientName"));
                String DentistName = rs.getString("DentistName");
                jTextField3.setText(DentistName);
                String Treatment = rs.getString("TreatmentType");
                jTextField4.setText(Treatment);
                double TreatmentCost = 0;

                switch (Treatment) {
                    case "Root Canal":
                        TreatmentCost = 1000;
                        break;

                    case "Whitening":
                        TreatmentCost = 2000;
                        break;

                    case "Cleaning":
                        TreatmentCost = 3000;
                        break;

                    case "Dental Implants":
                        TreatmentCost = 4000;
                        break;

                    case "Tooth Extraction":
                        TreatmentCost = 5000;
                        break;
                }

                double ConsultationFee = 0;

                switch (DentistName) {
                    case "Dr. Ranjan":
                        ConsultationFee = 500;
                        break;

                    case "Dr. Marian":
                        ConsultationFee = 600;
                        break;

                    case "Dr. Wilson":
                        ConsultationFee = 700;
                        break;

                    case "Dr. Joseph":
                        ConsultationFee = 800;
                        break;

                    case "Dr. Christine":
                        ConsultationFee = 900;
                        break;
                }

                double TotalCost = TreatmentCost + ConsultationFee;
                jTextField5.setText(String.valueOf(TreatmentCost));
                jTextField7.setText(String.valueOf(ConsultationFee));
                jTextField6.setText(String.valueOf(TotalCost));

            } else {
                JOptionPane.showMessageDialog(this, "Patient Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SearchbtnActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void BillbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillbtnMouseEntered
        // TODO add your handling code here:
        Billbtn.setBackground(Color.green);
    }//GEN-LAST:event_BillbtnMouseEntered

    private void BillbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillbtnMouseExited
        // TODO add your handling code here:
        Billbtn.setBackground(Color.white);
    }//GEN-LAST:event_BillbtnMouseExited

    private void BillbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillbtnActionPerformed
        new StaffForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_BillbtnActionPerformed

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
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Billbtn;
    private javax.swing.JButton Billbtn1;
    private javax.swing.JButton Searchbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

}
