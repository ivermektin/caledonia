package org.ivermektin.caledonia.userinterface.windows.subjectWindows;

import org.ivermektin.caledonia.interfaces.domesticInterfaces.idInterface;
import org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.data;
import org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.subject;
import org.ivermektin.caledonia.userinterface.windows.control.windowController;
import org.ivermektin.caledonia.userinterface.windows.mainWindow;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

public class createSubjectWindow extends javax.swing.JDialog {
    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createSubjectWindow dialog = new createSubjectWindow(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }
    public createSubjectWindow(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Create Subject");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code.
     */

    // <editor-fold defaultstate="collapsed" desc="User Interface Code">
    private void initComponents() {
        setResizable(false);

        createNewSubjectLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        createNewSubjectLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 24)); // NOI18N
        createNewSubjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createNewSubjectLabel.setText("Create New Subject");

        nameLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Name:");

        nameField.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameField.addKeyListener(new java.awt.event.KeyListener() {
            public void keyTyped(java.awt.event.KeyEvent evt){
                checkStatus();
            }

            public void keyPressed(java.awt.event.KeyEvent evt){
                checkStatus();
            }

            public void keyReleased(KeyEvent evt) {
                checkStatus();
            }
        });

        createButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        createButton.setText("Create");
        createButton.setEnabled(false);
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createNewSubjectLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(createButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(createNewSubjectLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(createButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Handler Functions">
    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {
        subject subject = new subject(nameField.getText(), idInterface.generateRandomString(), new ArrayList<data>(), new ArrayList<data>());
        new File("data/" + subject.getId()).mkdirs();
        subject.saveSubject();
        super.dispose();
        windowController.setCurrentSubject(subject);
        String[] args = {""};
        for (Window window: mainWindow.getWindows()){
            window.dispose();
        }
        mainWindow.main(args);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Element Declarations">
    private javax.swing.JButton createButton;
    private javax.swing.JLabel createNewSubjectLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Functions">
    private void checkStatus() {
        if(nameField.getText().isBlank()){
            createButton.setEnabled(false);
            createButton.setToolTipText("You must give your subject a name!");
        } else createButton.setEnabled(true);
    }
    // </editor-fold>

}
