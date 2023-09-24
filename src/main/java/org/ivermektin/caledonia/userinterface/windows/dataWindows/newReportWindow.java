package org.ivermektin.caledonia.userinterface.windows.dataWindows;

import org.ivermektin.caledonia.interfaces.webInterfaces.aiInterface;
import org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.data;
import org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.subject;
import org.ivermektin.caledonia.userinterface.windows.control.windowController;
import org.ivermektin.caledonia.userinterface.windows.mainWindow;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

public class newReportWindow extends javax.swing.JDialog {
    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                newReportWindow dialog = new newReportWindow(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }
    public newReportWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Create Report");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code.
     */

    // <editor-fold defaultstate="collapsed" desc="User Interface Code">
    private void initComponents() {
        setResizable(false);

        createReportLabel = new javax.swing.JLabel();
        notesListSP = new javax.swing.JScrollPane();
        notesList = new javax.swing.JList<>();
        notesListLabel = new javax.swing.JLabel();
        promptField = new javax.swing.JTextField();
        createReportButton = new javax.swing.JButton();
        promptLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        createReportLabel.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        createReportLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createReportLabel.setText("Create a Report");

        ArrayList<data> notes = windowController.getCurrentSubject().getNotes();
        ArrayList<String> noteNames = new ArrayList<String>();
        for(data data: notes){
            noteNames.add(data.getTitle());
        }

        notesList.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        notesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = noteNames.toArray(new String[0]);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        notesListSP.setViewportView(notesList);

        notesListLabel.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        notesListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notesListLabel.setText("Select Notes to Include");

        notesList.addListSelectionListener(update ->{
            checkStatus();
        });

        promptField.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        promptField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        promptField.addKeyListener(new java.awt.event.KeyListener() {
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

        createReportButton.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        createReportButton.setEnabled(false);
        createReportButton.setText("Create Report");
        createReportButton.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                try {
                    createReportButtonActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        checkStatus();

        promptLabel.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        promptLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        promptLabel.setText("Prompt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(notesListSP)
                                        .addComponent(notesListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(promptField)
                                        .addComponent(createReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createReportLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                        .addComponent(promptLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(createReportLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(promptLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(promptField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(notesListLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(notesListSP, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createReportButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Handler Code">
    private void createReportButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        createReportButton.setText("Loading...");
        ArrayList<data> dataToSend = new ArrayList<data>();
        for (Integer indice: notesList.getSelectedIndices()) {
            dataToSend.add(windowController.getCurrentSubject().getNotes().get(indice));
        }
        subject subject = windowController.getCurrentSubject();
        subject.addReport(aiInterface.generateReport(promptField.getText(),dataToSend, windowController.getCurrentSubject().getName()));
        super.dispose();
        String[] args = {""};
        for (Window window: mainWindow.getWindows()){
            window.dispose();
        }
        mainWindow.main(args);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Element Declarations">
    private javax.swing.JButton createReportButton;
    private javax.swing.JLabel createReportLabel;
    private javax.swing.JList<String> notesList;
    private javax.swing.JLabel notesListLabel;
    private javax.swing.JScrollPane notesListSP;
    private javax.swing.JTextField promptField;
    private javax.swing.JLabel promptLabel;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Functions">
    private void checkStatus() {
        Boolean isEnabled = !(promptField.getText().isBlank() || notesList.isSelectionEmpty());
        String message = "";
        if(promptField.getText().isBlank() && notesList.isSelectionEmpty()){
            message = "You must give Caledonia a prompt and select one or more notes!";
        } else if(promptField.getText().isBlank()){
            message = "You must give Caledonia a prompt!";
        } else if(notesList.isSelectionEmpty()){
            message = "You must select one or more notes!";
        }

        ArrayList<data> dataToSend = new ArrayList<data>();
        for (Integer indice: notesList.getSelectedIndices()) {
            dataToSend.add(windowController.getCurrentSubject().getNotes().get(indice));
        }

        boolean igtw = isGoodTokenwise(promptField.getText(), dataToSend);
        isEnabled = igtw;
        if(!igtw){
            message = "The sum of your content has reached the token limit (1700). Shorten your prompt or remove notes to proceed.";
        }
        createReportButton.setEnabled(isEnabled);
        createReportButton.setToolTipText(message);
    }

    public static boolean isGoodTokenwise(String prompt, ArrayList<data> notes){
        String str = prompt;
        for (data note: notes) {
            str += note.getTitle() + note.getContent();
        }
        return str.length() < 6400;
    }
    // </editor-fold>

}
