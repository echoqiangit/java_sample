package com.sample.controlfilegenerator;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControlFileGeneratorJFrame extends javax.swing.JFrame {

    private List<String> records = new ArrayList<String>();
    private Service service = new Service();
    private AppSwingWorker worker;
    private static Logger logger = LogManager.getLogger(ControlFileGeneratorJFrame.class);

    /**
     * Creates new form ControlFileGeneratorJFrame
     */
    public ControlFileGeneratorJFrame() {
        initComponents();
        inputFolderTextField.setText(Paths.get("").toAbsolutePath().toString() + "\\test-files");
        outputFolderTextField.setText(Paths.get("").toAbsolutePath().toString() + "\\results");
        //setIconImage(Toolkit.getDefaultToolkit().getImage("ipers_logo.png"));
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fileNameStartComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        inputFolderTextField = new javax.swing.JTextField();
        inputFolderButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        outputFolderTextField = new javax.swing.JTextField();
        outputButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        controlFileSizeTextField = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        statusTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        envComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control File Generator");

        jLabel1.setText("Document Type：");

        fileNameStartComboBox.setEditable(true);
        fileNameStartComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cut_Sheet_", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Folder of Input Files (PDF files): ");

        inputFolderTextField.setPreferredSize(new java.awt.Dimension(300, 20));

        inputFolderButton.setText("Browse...");
        inputFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFolderButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Folder to Store Generated Control Files (all old files will be removed):");

        outputFolderTextField.setPreferredSize(new java.awt.Dimension(300, 20));

        outputButton.setText("Browse...");
        outputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Control File Size: ");

        controlFileSizeTextField.setText("500");

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        statusTextArea.setEditable(false);
        statusTextArea.setColumns(20);
        statusTextArea.setLineWrap(true);
        statusTextArea.setRows(5);
        jScrollPane1.setViewportView(statusTextArea);

        jLabel5.setText("Status:");

        jLabel6.setText("DB Environment:");

        envComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PROD", "UAT", "DEV" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(controlFileSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(outputFolderTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outputButton)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inputFolderTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputFolderButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fileNameStartComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(envComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 3, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {inputFolderTextField, outputFolderTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameStartComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(envComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputFolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputFolderButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(controlFileSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputButton)
                    .addComponent(outputFolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(startButton)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFolderButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose Folder of PDF Files");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            inputFolderTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        } else {
            //inputFolderTextField.setText("");
        }
    }//GEN-LAST:event_inputFolderButtonActionPerformed

    private void outputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose Folder To Store Generated Control Files");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            outputFolderTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        } else {
            //inputFolderTextField.setText("");
        }
    }//GEN-LAST:event_outputButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        try {
            if (!validateInput()) {
                return;
            }
            statusTextArea.setText("");
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            startButton.setEnabled(false);
            worker = new AppSwingWorker();
            worker.execute();
        } catch (Throwable e) {
            logger.error("Error:", e);
            JOptionPane.showMessageDialog(this,
                    "Please contact support person for the system error.",
                    "System Error",
                    JOptionPane.ERROR_MESSAGE);

        } finally {
            //this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private boolean validateInput() {
        boolean result = true;
        String fileNameStartsStr = (String) fileNameStartComboBox.getSelectedItem();
        if (fileNameStartsStr == null || fileNameStartsStr.trim().length() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Please select the File Name Start With ComboBox.",
                    "Fild Name Start is required",
                    JOptionPane.ERROR_MESSAGE);
            result = false;
            return result;
        }
        String inputFolderStr = inputFolderTextField.getText().trim();
        if (inputFolderStr == null || inputFolderStr.length() < 3) {
            JOptionPane.showMessageDialog(this,
                    "Please select the folder of PDF files.",
                    "Folder of PDF files is required",
                    JOptionPane.ERROR_MESSAGE);
            result = false;
            return result;
        } else if (!Files.exists(Paths.get(inputFolderStr))) {
            JOptionPane.showMessageDialog(this,
                    "The folder of PDF files doesn't exists.",
                    "Folder of PDF files is required",
                    JOptionPane.ERROR_MESSAGE);
            result = false;
            return result;

        }

        String controlFileSizeStr = controlFileSizeTextField.getText().trim();
        if (controlFileSizeStr == null || controlFileSizeStr.length() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Please enter the size of control file.",
                    "Size of control file is required",
                    JOptionPane.ERROR_MESSAGE);
            result = false;
            return result;

        } else {
            try {
                Integer.parseInt(controlFileSizeStr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Please enter an integer for the size of control file.",
                        "Size of control file is not an integer",
                        JOptionPane.ERROR_MESSAGE);
                result = false;
                return result;

            }
        }

        String outputFolderStr = outputFolderTextField.getText().trim();
        if (outputFolderStr == null || outputFolderStr.length() < 3) {
            JOptionPane.showMessageDialog(this,
                    "Please select the folder to store generated control file.",
                    "Folder of control files is required",
                    JOptionPane.ERROR_MESSAGE);
            result = false;
            return result;
        } else if (!Files.exists(Paths.get(outputFolderStr))) {
            JOptionPane.showMessageDialog(this,
                    "The folder to store output/control files doesn't exists.",
                    "Folder of output files is required",
                    JOptionPane.ERROR_MESSAGE);
            result = false;
            return result;

        }

        return result;
    }

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
                //if ("Nimbus".equals(info.getName())) {
                if ("System".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlFileGeneratorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlFileGeneratorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlFileGeneratorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlFileGeneratorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlFileGeneratorJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField controlFileSizeTextField;
    private javax.swing.JComboBox<String> envComboBox;
    private javax.swing.JComboBox<String> fileNameStartComboBox;
    private javax.swing.JButton inputFolderButton;
    private javax.swing.JTextField inputFolderTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton outputButton;
    private javax.swing.JTextField outputFolderTextField;
    private javax.swing.JButton startButton;
    private javax.swing.JTextArea statusTextArea;
    // End of variables declaration//GEN-END:variables

    class AppSwingWorker extends SwingWorker<Void, String> {

        protected Void doInBackground() throws Exception {
            String fileNameStartsStr = (String) fileNameStartComboBox.getSelectedItem();
            String inputFolderStr = inputFolderTextField.getText().trim();
            int controlFileSize = Integer.parseInt(controlFileSizeTextField.getText().trim());
            String outputFolderStr = outputFolderTextField.getText().trim();

            //step 1 read file names
            long t1 = System.currentTimeMillis();
            String msg0 = "Started generating control files...";
            publish(msg0);
            logger.info(msg0);
            service.clearResultFile(outputFolderStr);
Thread.sleep(5000);            
            String[] all_file_names = new File(inputFolderStr).list();
            ArrayList<ItemType> allItemTypeList = new ArrayList<>();
            Set<String> invalidFileNameSet = new HashSet();
            for (int i = 0; i < all_file_names.length; i++) {
                String fileName = all_file_names[i];
                String memberId = service.getMemberIdFromFileName(fileName, fileNameStartsStr);
                if (fileName != null && memberId != null) {
                    allItemTypeList.add(new ItemType(memberId, fileName));
                } else {
                    invalidFileNameSet.add(fileName);
                }
            }
            if (invalidFileNameSet.size() > 0) {
                service.writeStringSetToFile(outputFolderStr + "\\invalid_file_names.txt", invalidFileNameSet);
            }
            long t2 = System.currentTimeMillis();
            String step1Msg = "1: There are [" + all_file_names.length + "] total and ["+invalidFileNameSet.size()+"] invalid files. "
                    + "It took [" + (t2 - t1) / 1000 + "] seconds.";

            publish(step1Msg);
            logger.info(step1Msg);
Thread.sleep(5000);
            //step 2 filter duplicated numbers
            List<ItemType> duplicatedItemTypeSet = service.getDuplicatedRecords(allItemTypeList);
            service.writeListToFile(outputFolderStr + "\\duplicated_cases.txt", duplicatedItemTypeSet);
            allItemTypeList.removeAll(duplicatedItemTypeSet);
            long t3 = System.currentTimeMillis();
            String step2Msg = "2: Filtered [" + duplicatedItemTypeSet.size() + "] duplicated member ids. "
                    + "It took [" + (t3 - t2) / 1000 + "] seconds. ";
            publish(step2Msg);
            logger.info(step2Msg);
Thread.sleep(5000);

            //step 3 create control files
            int groupNum = service.generateControlFiles(controlFileSize, allItemTypeList, outputFolderStr);
            long t4 = System.currentTimeMillis();
            String step3Msg = "3: [" + groupNum + "] control files are generated. It took [" + (t4 - t3) / 1000 + "] secnonds.";
            publish(step3Msg);
            logger.info(step3Msg);
            return null;
        }

        protected void process(List<String> chunks) {
            for (String chunk : chunks) {
                statusTextArea.append(chunk + "\n");
            }
        }

        protected void done() {
            statusTextArea.append("The whole process is completed successfully.");
            setCursor(Cursor.getDefaultCursor());
            startButton.setEnabled(true);
        }
    }

}
