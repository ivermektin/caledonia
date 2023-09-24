package org.ivermektin.caledonia.userinterface.windows.dataWindows;

import org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.subject;
import org.ivermektin.caledonia.userinterface.windows.control.windowController;
import org.ivermektin.caledonia.userinterface.windows.mainWindow;

import java.awt.*;
import java.awt.event.KeyEvent;

public class newNoteWindow extends javax.swing.JDialog {

    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                newNoteWindow dialog = new newNoteWindow(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }
    public newNoteWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Create Note");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. T
     */

    // <editor-fold defaultstate="collapsed" desc="User Interface Code">
    private void initComponents() {
        setResizable(false);

        createNoteLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        contentSP = new javax.swing.JScrollPane();
        contentField = new javax.swing.JEditorPane();
        createNoteButton = new javax.swing.JButton();
        createNoteButton.setEnabled(false);
        checkStatus();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        createNoteLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 24)); // NOI18N
        createNoteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createNoteLabel.setText("Create a Note");

        titleLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Title");

        titleField.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        titleField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titleField.addKeyListener(new java.awt.event.KeyListener() {
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

        contentField.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        contentSP.setViewportView(contentField);
        contentField.addKeyListener(new java.awt.event.KeyListener() {
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

        createNoteButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        createNoteButton.setText("Create Note");
        createNoteButton.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                createNoteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(createNoteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                        .addComponent(contentSP)
                                        .addComponent(createNoteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(titleField)
                                        .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(createNoteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contentSP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createNoteButton)
                                .addContainerGap())
        );

        pack();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Handler Code">
    private void createNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        subject subject = windowController.getCurrentSubject();
        subject.addNote(titleField.getText(), "User", contentField.getText());
        super.dispose();
        String[] args = {""};
        for (Window window: mainWindow.getWindows()){
            window.dispose();
        }
        mainWindow.main(args);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Element Declarations">
    private javax.swing.JEditorPane contentField;
    private javax.swing.JScrollPane contentSP;
    private javax.swing.JButton createNoteButton;
    private javax.swing.JLabel createNoteLabel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Functions">
    private void checkStatus(){
        Boolean isEnabled = !(titleField.getText().isBlank() || contentField.getText().isBlank());
        String message = "";
        if(titleField.getText().isBlank() && contentField.getText().isBlank()){
            message = "You must give your note a title and a body!";
        } else if(titleField.getText().isBlank()){
            message = "You must give your note a title!";
        } else if(contentField.getText().isBlank()){
            message = "You must give your note a body!";
        }
        createNoteButton.setEnabled(isEnabled);
        createNoteButton.setToolTipText(message);
    }
    // </editor-fold>

}
