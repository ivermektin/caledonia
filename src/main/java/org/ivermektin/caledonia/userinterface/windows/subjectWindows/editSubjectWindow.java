package org.ivermektin.caledonia.userinterface.windows.subjectWindows;

import org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.subject;
import org.ivermektin.caledonia.userinterface.windows.mainWindow;
import org.ivermektin.caledonia.userinterface.windows.control.windowController;

import java.awt.*;
import java.awt.event.KeyEvent;

public class editSubjectWindow extends javax.swing.JDialog {
    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                editSubjectWindow dialog = new editSubjectWindow(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }
    public editSubjectWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Edit Subject");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code.
     */

    // <editor-fold defaultstate="collapsed" desc="User Interface Code">
    private void initComponents() {
        setResizable(false);

        editSubjectLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        editSubjectLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 24)); // NOI18N
        editSubjectLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editSubjectLabel.setText("Edit Subject ");

        nameLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Name:");

        nameField.setText(windowController.getCurrentSubject().getName());
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

        editButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        editButton.setText("Edit");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed();
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
                                        .addComponent(editSubjectLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(editButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(editSubjectLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Handler Functions">
    private void editButtonActionPerformed() {
        subject subject = windowController.getCurrentSubject();
        subject.setName(nameField.getText());
        subject.saveSubject();
        super.dispose();
        String[] args = {""};
        for (Window window: mainWindow.getWindows()){
            window.dispose();
        }
        mainWindow.main(args);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Element Declarations">
    private javax.swing.JButton editButton;
    private javax.swing.JLabel editSubjectLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Functions">
    private void checkStatus() {
        if(nameField.getText().isBlank()){
            editButton.setToolTipText("You must give your subject a name!");
            editButton.setEnabled(false);
        }
        else editButton.setEnabled(true);
    }
    // </editor-fold>

}
