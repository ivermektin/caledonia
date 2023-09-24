package org.ivermektin.caledonia.userinterface.launcher;

import org.ivermektin.caledonia.interfaces.webInterfaces.feedbackInterface;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class feedbackWindow extends javax.swing.JDialog {

    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                feedbackWindow dialog = new feedbackWindow(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }
    public feedbackWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Submit Feedback");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code.
     */

    // <editor-fold defaultstate="collapsed" desc="User Interface Code">
    private void initComponents() {
        setResizable(false);

        feedbackWindowLabel = new javax.swing.JLabel();
        feedbackTypeDropdown = new javax.swing.JComboBox<>();
        feedbackTypeLabel = new javax.swing.JLabel();
        feedbackFieldSP = new javax.swing.JScrollPane();
        feedbackField = new javax.swing.JEditorPane();
        submitButton = new javax.swing.JButton();

        checkStatus();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        feedbackWindowLabel.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        feedbackWindowLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        feedbackWindowLabel.setText("Caledonia Feedback Menu");

        feedbackTypeDropdown.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        feedbackTypeDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bug Report", "Feature Suggestion", "Review" }));

        feedbackTypeLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        feedbackTypeLabel.setText("Feedback Type");

        feedbackField.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        feedbackField.addKeyListener(new java.awt.event.KeyListener() {
            public void keyTyped(KeyEvent evt){
                checkStatus();
            }

            public void keyPressed(KeyEvent evt){
                checkStatus();
            }

            public void keyReleased(KeyEvent evt) {
                checkStatus();
            }
        });
        feedbackFieldSP.setViewportView(feedbackField);

        submitButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    submitButtonActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(feedbackTypeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(feedbackWindowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                        .addComponent(feedbackTypeDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(feedbackFieldSP)
                                        .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(feedbackWindowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(feedbackTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(feedbackTypeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(feedbackFieldSP, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitButton)
                                .addContainerGap())
        );

        pack();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Handler Functions">
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        feedbackInterface.sendFeedback(feedbackTypeDropdown.getSelectedItem().toString(), feedbackField.getText());
        super.dispose();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Element Declaration">
    private javax.swing.JEditorPane feedbackField;
    private javax.swing.JScrollPane feedbackFieldSP;
    private javax.swing.JLabel feedbackWindowLabel;
    private javax.swing.JComboBox<String> feedbackTypeDropdown;
    private javax.swing.JLabel feedbackTypeLabel;
    private javax.swing.JButton submitButton;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Functions">
    public void checkStatus(){
        if(feedbackField.getText().isBlank()){
            submitButton.setEnabled(false);
            submitButton.setToolTipText("You must give your feedback a body!");
        } else {
            submitButton.setEnabled(true);
            submitButton.setToolTipText("");
        }
    }
    // </editor-fold>
}
