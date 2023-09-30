package org.ivermektin.caledonia.userinterface.windows;

import com.formdev.flatlaf.intellijthemes.*;
import com.google.gson.Gson;
import org.ivermektin.caledonia.services.internalServices.objects.Data;
import org.ivermektin.caledonia.services.internalServices.objects.Subject;
import org.ivermektin.caledonia.services.systemServices.FilesystemService;
import org.ivermektin.caledonia.userinterface.windows.control.windowController;
import org.ivermektin.caledonia.userinterface.windows.dataWindows.newReportWindow;
import org.ivermektin.caledonia.userinterface.windows.subjectWindows.createSubjectWindow;
import org.ivermektin.caledonia.userinterface.windows.subjectWindows.editSubjectWindow;
import org.ivermektin.caledonia.userinterface.windows.dataWindows.newNoteWindow;

import javax.swing.*;
import java.awt.*;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class mainWindow extends javax.swing.JFrame {

    public static void main(String[] args) {
        if(args.length > 1){
            int themeValue = Integer.parseInt(args[0]);
            if(themeValue == 0) FlatArcIJTheme.setup();
            if(themeValue == 1) FlatArcDarkIJTheme.setup();
            if(themeValue == 2) FlatArcOrangeIJTheme.setup();
            if(themeValue == 3) FlatArcDarkOrangeIJTheme.setup();
            if(themeValue == 4) FlatDarkPurpleIJTheme.setup();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainWindow().setVisible(true);
            }
        });
    }
    public mainWindow() {
        this.setTitle("Caledonia 1.0.3");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code.
     */

    // <editor-fold defaultstate="collapsed" desc="User Interface Code">
    private void initComponents() {

        setResizable(false);
        for (File folder: files) {
            String id = folder.getName();
            subjects.add(Subject.loadSubjectFromID(id));
        }

        // Component Making Code

        caledoniaLabel = new javax.swing.JLabel();
        subjectsListScrollPane = new javax.swing.JScrollPane();
        subjectsList = new javax.swing.JList<>();
        subjectsLabel = new javax.swing.JLabel();
        subjectInfoPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        referenceIDLabel = new javax.swing.JLabel();
        editSubjectDataButton = new javax.swing.JButton();
        deleteSubjectButton = new javax.swing.JButton();
        notesLabel = new javax.swing.JLabel();
        reportsListSP = new javax.swing.JScrollPane();
        reportsList = new javax.swing.JList<>();
        noteCreateButton = new javax.swing.JButton();
        noteDeleteButton = new javax.swing.JButton();
        reportCreateButton = new javax.swing.JButton();
        reportDeleteButton = new javax.swing.JButton();
        notesListSP = new javax.swing.JScrollPane();
        notesList = new javax.swing.JList<>();
        reportsLabel = new javax.swing.JLabel();
        viewerPanel = new javax.swing.JPanel();
        entryTitleLabel = new javax.swing.JLabel();
        entryTitleField = new javax.swing.JTextField();
        entryDateLabel = new javax.swing.JLabel();
        entryDateField = new javax.swing.JTextField();
        entryContentLabel = new javax.swing.JLabel();
        ecfSP = new javax.swing.JScrollPane();
        entryContentField = new javax.swing.JEditorPane();
        viewerWindowLabel = new javax.swing.JLabel();
        exportButton = new javax.swing.JButton();
        createSubjectButton = new javax.swing.JButton();
        taskManagerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        caledoniaLabel.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        caledoniaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        caledoniaLabel.setText("caledonia");

        subjectsList.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N

        subjectsList.setName(""); // NOI18N
        subjectsListScrollPane.setViewportView(subjectsList);

        subjectsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DefaultListCellRenderer SL_renderer =  (DefaultListCellRenderer)subjectsList.getCellRenderer();
        SL_renderer.setHorizontalAlignment(JLabel.CENTER);
        subjectsList.setFixedCellWidth(120); // Set the fixed cell height

        subjectsLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        subjectsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subjectsLabel.setText("Subjects");

        subjectInfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        nameLabel.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 18)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("First Name, Last Name");

        referenceIDLabel.setFont(new java.awt.Font("Bahnschrift",
                Font.PLAIN, 12)); // NOI18N
        referenceIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        referenceIDLabel.setText("Reference ID: $ID");

        editSubjectDataButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        editSubjectDataButton.setText("Edit Subject Data");

        deleteSubjectButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        deleteSubjectButton.setText("Delete Subject");


        notesLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        notesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notesLabel.setText("Notes");

        reportsList.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N

        reportsListSP.setViewportView(reportsList);

        reportsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListCellRenderer RL_renderer =  (DefaultListCellRenderer)reportsList.getCellRenderer();
        RL_renderer.setHorizontalAlignment(JLabel.CENTER);

        reportsList.setFixedCellWidth(120); // Set the fixed cell width to wrap the content

        noteCreateButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        noteCreateButton.setText("+");
        noteCreateButton.setToolTipText("Create a new note.");


        noteDeleteButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        noteDeleteButton.setText("-");
        noteDeleteButton.setToolTipText("Remove a note.");

        reportCreateButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        reportCreateButton.setText("+");
        reportCreateButton.setToolTipText("Generate a new report based off notes.");

        reportDeleteButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        reportDeleteButton.setText("-");
        reportDeleteButton.setToolTipText("Remove an old report.");

        notesList.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N

        notesListSP.setViewportView(notesList);



        notesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DefaultListCellRenderer NL_renderer = (DefaultListCellRenderer)notesList.getCellRenderer();
        NL_renderer.setHorizontalAlignment(JLabel.CENTER);
        notesList.setFixedCellWidth(120);


        reportsLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        reportsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reportsLabel.setText("Reports");

        viewerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        entryTitleLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        entryTitleLabel.setText("Title");

        entryTitleField.setEditable(false);
        entryTitleField.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        entryTitleField.setText("");

        entryDateLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        entryDateLabel.setText("Date");

        entryDateField.setEditable(false);
        entryDateField.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        entryDateField.setText("");

        entryContentLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        entryContentLabel.setText("Content");

        entryContentField.setEditable(false);
        entryContentField.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        ecfSP.setViewportView(entryContentField);

        javax.swing.GroupLayout viewerPanelLayout = new javax.swing.GroupLayout(viewerPanel);
        viewerPanel.setLayout(viewerPanelLayout);
        viewerPanelLayout.setHorizontalGroup(
                viewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(viewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ecfSP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(entryTitleField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(entryDateField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, viewerPanelLayout.createSequentialGroup()
                                                .addGroup(viewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(entryTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(entryDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(entryContentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        viewerPanelLayout.setVerticalGroup(
                viewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(entryTitleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entryTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entryDateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entryDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entryContentLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ecfSP, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addContainerGap())
        );

        viewerWindowLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        viewerWindowLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewerWindowLabel.setText("Viewer Window");

        exportButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        exportButton.setText("Export Content");
        exportButton.setToolTipText("");
        exportButton.setEnabled(false);


        javax.swing.GroupLayout subjectInfoPanelLayout = new javax.swing.GroupLayout(subjectInfoPanel);
        subjectInfoPanel.setLayout(subjectInfoPanelLayout);
        subjectInfoPanelLayout.setHorizontalGroup(
                subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectInfoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(referenceIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(subjectInfoPanelLayout.createSequentialGroup()
                                                .addGroup(subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(notesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(notesListSP, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(reportsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(reportsListSP, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(viewerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(viewerWindowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(deleteSubjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(editSubjectDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(subjectInfoPanelLayout.createSequentialGroup()
                                                .addComponent(noteCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(noteDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(reportCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(reportDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        subjectInfoPanelLayout.setVerticalGroup(
                subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectInfoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(referenceIDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(notesLabel)
                                        .addGroup(subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(reportsLabel)
                                                .addComponent(viewerWindowLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(reportsListSP)
                                        .addComponent(viewerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(notesListSP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(subjectInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(reportCreateButton)
                                                .addComponent(reportDeleteButton)
                                                .addComponent(noteDeleteButton)
                                                .addComponent(exportButton))
                                        .addComponent(noteCreateButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(deleteSubjectButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editSubjectDataButton)
                                .addContainerGap())
        );

        createSubjectButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        createSubjectButton.setText("Create Subject");

        taskManagerButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        taskManagerButton.setText("Manage Tasks");
        taskManagerButton.setToolTipText("Coming soon!");
        taskManagerButton.setEnabled(false);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(caledoniaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(subjectsListScrollPane)
                                        .addComponent(subjectsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createSubjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(taskManagerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(subjectInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(subjectInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(caledoniaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(subjectsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(subjectsListScrollPane)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(createSubjectButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(taskManagerButton)))
                                .addContainerGap())
        );

        // <editor-fold defaultstate="collapsed" desc="Listener Declarations">
        // Listener for the subjects list
        subjectsList.addListSelectionListener(update ->{
            Integer index = 0;
            if(subjectsList.getSelectedIndex() != -1) windowController.setCurrentSubject(subjectsList.getSelectedValue());
            updateSubject(windowController.getCurrentSubject());
        });

        // Listener for the notes list
        notesList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Integer index = 0;
                if(notesList.getSelectedIndex() != -1) windowController.setData(notesList.getSelectedValue());
                updateViewer(windowController.getData());

                updateButtons();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // Listener for the reports list
        reportsList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Integer index = 0;
                if(reportsList.getSelectedIndex() != -1) windowController.setData(reportsList.getSelectedValue());
                updateViewer(windowController.getData());

                updateButtons();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // Listener for the reports list selection
        reportsList.addListSelectionListener(update ->{
            Integer index = 0;
            if(reportsList.getSelectedIndex() != -1) windowController.setData(reportsList.getSelectedValue());
            updateViewer(windowController.getData());
        });

        // Listener for note creation button
        noteCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteCreateButtonActionPerformed(evt);
            }
        });

        // Listener for note deletion button
        noteDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteDeleteButtonActionPerformed(evt);
            }
        });

        // Listener for report creation button
        reportCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportCreateButtonActionPerformed(evt);
            }
        });

        // Listener for report deletion button
        reportDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportDeleteButtonActionPerformed(evt);
            }
        });

        // Listener for export button
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    exportButtonActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Listener for Subject deletion button
        deleteSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    deleteSubjectButtonActionPerformed(evt);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Listener for editing Subject Data button
        editSubjectDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSubjectDataButtonActionPerformed(evt);
            }
        });

        // Listener for task manager button
        taskManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskManagerButtonActionPerformed(evt);
            }
        });

        /* Subject Side Listeners */
        // Listener for creating a new Subject button
        createSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSubjectButtonActionPerformed(evt);
            }
        });
        // </editor-fold>
        pack();
        populate();
    } // </editor-fold>w

    // <editor-fold defaultstate="collapsed" desc="Listener Handler Functions">

    /**
     * Event handler for the delete Subject button. Removes the current Subject from the list of subjects,
     * deletes the Subject file and waits until the file is deleted, then sets the first Subject as the current Subject,
     * and updates the GUI.
     *
     * @param evt the ActionEvent object
     * @throws InterruptedException if the thread is interrupted while waiting for file deletion
     */
    private void deleteSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
        subjects.remove(windowController.getCurrentSubject());
        windowController.getCurrentSubject().delete();

        if(!subjects.isEmpty()){
            windowController.setCurrentSubject(subjects.get(0));
        }
        populate();
    }

    /**
     * Handler for the note create button. Opens a new window for creating a note.
     *
     * @param evt the ActionEvent object
     */
    private void noteCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        newNoteWindow.main();
    }

    /**
     * Handler for the task manager button. FIXME not in service.
     *
     * @param evt the ActionEvent object
     */
    private void taskManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // FIXME not in service.
    }

    /**
     * Handler for the create Subject button. Opens a new window for creating a Subject.
     *
     * @param evt the ActionEvent object
     */
    private void createSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {
        createSubjectWindow.main();
    }

    /**
     * Handler for the note delete button. Removes the selected note from the list of notes,
     * removes the note from the current Subject, updates the Subject and viewer, and updates the buttons.
     *
     * @param evt the ActionEvent object
     */
    private void noteDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Data note = notesList.getSelectedValue();
        notes.remove(note);
        windowController.getCurrentSubject().removeNote(note);
        updateSubject(windowController.getCurrentSubject());
        updateViewer(windowController.getData());

        updateButtons();
    }

    /**
     * Handler for the report create button. Opens a new window for creating a report.
     *
     * @param evt the ActionEvent object
     */
    private void reportCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        newReportWindow.main();
    }

    /**
     * Handler for the report delete button. Removes the selected report from the list of reports,
     * removes the report from the current Subject, updates the Subject and viewer, and updates the buttons.
     *
     * @param evt the ActionEvent object
     */
    private void reportDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Data report = reportsList.getSelectedValue();
        reports.remove(report);
        windowController.getCurrentSubject().removeReport(report);
        updateSubject(windowController.getCurrentSubject());
        updateViewer(windowController.getData());

        updateButtons();
    }

    /**
     * Handler for the edit Subject Data button. Opens a new window for editing the current Subject's Data.
     *
     * @param evt the ActionEvent object
     */
    private void editSubjectDataButtonActionPerformed(java.awt.event.ActionEvent evt) {
        editSubjectWindow.main();
    }

    /**
     * Handler for the export button. Allows the user to select a file to export the Data to,
     * and saves the Data to the selected file. If the file is a text file, it opens the file in the default text editor.
     *
     * @param evt the ActionEvent object
     * @throws IOException if an I/O error occurs
     */
    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a file to export to.");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Documents", "TXT"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filepath = fileToSave.getAbsolutePath();
            if(!filepath.endsWith(".txt")) filepath += ".txt";

            FilesystemService.saveFile(filepath, generateArray(windowController.getData()));

            if(Desktop.isDesktopSupported()){
                Desktop.getDesktop().edit(new File(filepath));
            }
        }
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Element Declarations">
    private javax.swing.JButton taskManagerButton;
    private javax.swing.JLabel caledoniaLabel;
    private javax.swing.JButton createSubjectButton;
    private javax.swing.JButton deleteSubjectButton;
    private javax.swing.JScrollPane ecfSP;
    private javax.swing.JButton editSubjectDataButton;
    private javax.swing.JTextField entryDateField;
    private javax.swing.JLabel entryDateLabel;
    private javax.swing.JEditorPane entryContentField;
    private javax.swing.JLabel entryContentLabel;
    private javax.swing.JTextField entryTitleField;
    private javax.swing.JLabel entryTitleLabel;
    private javax.swing.JButton exportButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton noteCreateButton;
    private javax.swing.JButton noteDeleteButton;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JList<Data> notesList;
    private javax.swing.JScrollPane notesListSP;
    private javax.swing.JLabel referenceIDLabel;
    private javax.swing.JButton reportCreateButton;
    private javax.swing.JButton reportDeleteButton;
    private javax.swing.JLabel reportsLabel;
    private javax.swing.JList<Data> reportsList;
    private javax.swing.JScrollPane reportsListSP;
    private javax.swing.JPanel subjectInfoPanel;
    private javax.swing.JLabel subjectsLabel;
    private javax.swing.JList<Subject> subjectsList;
    private javax.swing.JScrollPane subjectsListScrollPane;
    private javax.swing.JPanel viewerPanel;
    private javax.swing.JLabel viewerWindowLabel;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Non-UI Variable Declarations">
    Gson JSONParser = new Gson();
    ArrayList<Subject> subjects = new ArrayList<Subject>();
    ArrayList<Data> notes = new ArrayList<Data>();
    ArrayList<Data> reports = new ArrayList<Data>();
    File[] files = new File("Data/").listFiles();

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Functions">

    /**
     * Generates an ArrayList of strings representing a file containing the Subject's Data.
     *
     * @param data The Subject's Data.
     * @return The ArrayList of strings representing the file.
     */
    public static ArrayList<String> generateArray(Data data){
        ArrayList<String> file = new ArrayList<String>();
        file.add(data.getTitle());
        file.add(data.getAuthor() + " @ " + data.getDate());
        file.add(" ");
        file.add(data.getContent());
        return file;
    }

    /**
     * Populates the user interface with subjects and their information.
     */
    public void populate(){
        if(subjects.isEmpty()){
            subjectInfoPanel.setVisible(false);
            subjectsList.setModel(new javax.swing.AbstractListModel<Subject>() {
                Subject[] subjects = {};
                public int getSize() { return subjects.length; }
                public Subject getElementAt(int i) { return subjects[i]; }
            });

            this.setSize(new Dimension(170, 500));
        } else {
            loadSubjects();
            if(windowController.getCurrentSubject() == null) {
                subjectsList.setSelectedIndex(0);
                windowController.setCurrentSubject(subjects.get(0));
                updateSubject(windowController.getCurrentSubject());
            } else {
                subjectsList.setSelectedIndex(subjects.indexOf(windowController.getCurrentSubject()));
                updateSubject(windowController.getCurrentSubject());
            }
        }
    }

    /**
     * Load the subjects into the subjectsList on the UI.
     * This method retrieves the names of the subjects from the subjects ArrayList
     * and populates a JList with the names as the elements.
     */
    public void loadSubjects(){

        subjectsList.setModel(new javax.swing.AbstractListModel<Subject>() {
            Subject[] data = subjects.toArray(new Subject[0]);
            public int getSize() { return data.length; }
            public Subject getElementAt(int i) { return data[i]; }
        });
    }

    /**
     * Update the enabled state of the buttons on the UI based on the selection status of the notesList and reportsList.
     * This method checks if the notesList and reportsList are not empty,
     * and enables or disables the noteDeleteButton, reportCreateButton, reportDeleteButton, and exportButton accordingly.
     */
    public void updateButtons(){
        noteDeleteButton.setEnabled(!notesList.isSelectionEmpty());
        reportCreateButton.setEnabled(!notes.isEmpty());
        reportDeleteButton.setEnabled(!reportsList.isSelectionEmpty());
        exportButton.setEnabled(!(windowController.getData() == null));
    }


    /**
     * Updates the Subject information displayed in the UI.
     *
     * @param subject The Subject object with updated information.
     */
    public void updateSubject(Subject subject){
        nameLabel.setText(subject.getName());
        referenceIDLabel.setText("Reference ID: " + subject.getId());

        // Load Titles
        notes = subject.getNotes();
        reports = subject.getReports();

        noteDeleteButton.setEnabled(false);
        reportCreateButton.setEnabled(false);
        if(!notes.isEmpty()){
            windowController.setData(notes.get(0));
            notesList.setSelectedIndex(0);
            reportCreateButton.setEnabled(true);
        }

        reportDeleteButton.setEnabled(false);
        if(!reports.isEmpty()){
            windowController.setData(reports.get(0));
            reportsList.setSelectedIndex(0);
        }

        if(notes.isEmpty() && reports.isEmpty()){
            entryTitleField.setText("");
            entryDateField.setText("");
            entryContentField.setText("");
        }


        notesList.setModel(new javax.swing.AbstractListModel<Data>() {
            Data[] data = notes.toArray(new Data[0]);
            public int getSize() { return data.length; }
            public Data getElementAt(int i) { return data[i]; }
        });

        reportsList.setModel(new javax.swing.AbstractListModel<Data>() {
            Data[] data = reports.toArray(new Data[0]);
            public int getSize() { return data.length; }
            public Data getElementAt(int i) { return data[i]; }
        });

    }

    /**
     * Updates the viewer with the given Data.
     *
     * @param data The Data object containing the information to be displayed in the viewer.
     */
    public void updateViewer(Data data){
        entryTitleField.setText(data.getTitle());
        entryDateField.setText(data.getDate());
        entryContentField.setText(data.getContent());
    }

    // </editor-fold>

}
