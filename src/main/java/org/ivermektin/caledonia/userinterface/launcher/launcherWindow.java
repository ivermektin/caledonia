package org.ivermektin.caledonia.userinterface.launcher;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import okhttp3.Response;
import org.ivermektin.caledonia.interfaces.systemInterfaces.filesystemInterface;
import org.ivermektin.caledonia.interfaces.webInterfaces.aiInterface;
import org.ivermektin.caledonia.interfaces.webInterfaces.blurbInterface;
import org.ivermektin.caledonia.interfaces.webInterfaces.updateInterface;
import org.ivermektin.caledonia.userinterface.windows.mainWindow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

public class launcherWindow extends javax.swing.JFrame {

    public static void main(String args[]) {
        FlatArcIJTheme.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new launcherWindow().setVisible(true);
                } catch (IOException | URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public launcherWindow() throws IOException, URISyntaxException {
        this.setTitle("Caledonia 1.0.0 Launcher");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code.
     */

    // <editor-fold defaultstate="collapsed" desc="User Interface Code">
    private void initComponents() throws IOException, URISyntaxException {
        setResizable(false);

        CaledoniaLabel = new javax.swing.JLabel();
        websiteLabel = new javax.swing.JLabel();
        warningErrorWidgetLabel = new javax.swing.JLabel();
        noticeListSP = new javax.swing.JScrollPane();
        noticeList = new javax.swing.JList<>();
        updateCaledoniaButton = new javax.swing.JButton();
        launchCaledoniaButton = new javax.swing.JButton();
        themeSelectLabel = new javax.swing.JLabel();
        themeListSP = new javax.swing.JScrollPane();
        themeList = new javax.swing.JList<>();
        feedbackMenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CaledoniaLabel.setFont(new java.awt.Font("Bahnschrift", Font.BOLD, 24)); // NOI18N
        CaledoniaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CaledoniaLabel.setText("Caledonia Launcher");

        websiteLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        websiteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        websiteLabel.setText(blurbInterface.getBlurb());

        warningErrorWidgetLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        warningErrorWidgetLabel.setText("Notices");

        noticeList.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        noticeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        noticeList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    updateNoticeList();
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
                updateButtons();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    updateNoticeList();
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
                updateButtons();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    updateNoticeList();
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
                updateButtons();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        noticeList.addListSelectionListener(updateTooltip ->{
            noticeList.setToolTipText(noticeList.getSelectedValue());
        });

        noticeList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = findErrors();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        noticeListSP.setViewportView(noticeList);

        String updateTooltip = "Your version of Caledonia is already up to date!";
        if(!isRecent) updateTooltip = ("Update to " + updateInterface.getLatestUpdateVersion() + " - " + updateInterface.getLatestUpdateDescription());

        updateCaledoniaButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        updateCaledoniaButton.setText("Update Caledonia");
        updateCaledoniaButton.setToolTipText(updateTooltip);
        updateCaledoniaButton.setEnabled(!isRecent);
        updateCaledoniaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    updateCaledoniaButtonActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        launchCaledoniaButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        launchCaledoniaButton.setText("Launch Caledonia");
        launchCaledoniaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchCaledoniaButtonActionPerformed(evt);
            }
        });

        updateButtons();

        themeSelectLabel.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        themeSelectLabel.setText("Theme Select");

        themeList.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        themeList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Light", "Dark", "Light Orange", "Dark Orange", "Purple" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        themeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        themeList.setSelectedIndex(0);
        themeList.setToolTipText("");
        themeListSP.setViewportView(themeList);

        feedbackMenuButton.setFont(new java.awt.Font("Bahnschrift", Font.PLAIN, 12)); // NOI18N
        feedbackMenuButton.setText("Open Feedback Menu");
        feedbackMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(feedbackMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CaledoniaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(websiteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(warningErrorWidgetLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(updateCaledoniaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                                        .addComponent(noticeListSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(launchCaledoniaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                                        .addComponent(themeListSP)
                                                        .addComponent(themeSelectLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CaledoniaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(websiteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(warningErrorWidgetLabel)
                                        .addComponent(themeSelectLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(noticeListSP)
                                        .addComponent(themeListSP, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(updateCaledoniaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(launchCaledoniaButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(feedbackMenuButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Handler Functions">
    private void updateCaledoniaButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        String url = "https://github.com/ivermektin/caledonia/releases/tag/v" + updateInterface.getLatestUpdateVersion();
        Desktop.getDesktop().browse(URI.create(url));
    }

    private void launchCaledoniaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String[] args = {String.valueOf(themeList.getSelectedIndex()), ":3"};
        mainWindow.main(args);
        super.dispose();
    }
    private void feedbackMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {
        feedbackWindow.main();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UI Element Declarations">
    private javax.swing.JLabel CaledoniaLabel;
    private javax.swing.JLabel themeSelectLabel;
    private javax.swing.JButton feedbackMenuButton;
    private javax.swing.JButton launchCaledoniaButton;
    private static javax.swing.JList<String> noticeList;
    private javax.swing.JScrollPane noticeListSP;
    private javax.swing.JList<String> themeList;
    private javax.swing.JScrollPane themeListSP;
    private javax.swing.JButton updateCaledoniaButton;
    private javax.swing.JLabel warningErrorWidgetLabel;
    private javax.swing.JLabel websiteLabel;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Non-UI Variable Delcarations">
    Boolean updateOverride = updateInterface.updateRequired("1.0.0");
    Boolean isRecent = updateInterface.isRecent("1.0.0");
    static ArrayList<String> APIErrors;

    static {
        try {
            APIErrors = checkApi();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Functions">
    public void updateButtons(){
        Boolean fatal = false;
        Boolean critical = false;

        for (int i = 0; i < noticeList.getModel().getSize(); i++) {
            if(noticeList.getModel().getElementAt(i).startsWith("[FATAL]")) fatal = true;
            if(noticeList.getModel().getElementAt(i).startsWith("[CRITICAL]")) critical = true;
        }

        launchCaledoniaButton.setEnabled(true);
        if(fatal){
            launchCaledoniaButton.setEnabled(false);
            launchCaledoniaButton.setToolTipText("You must address all [FATAL] notices before proceeding!");
        } else if(critical){
            launchCaledoniaButton.setToolTipText("Proceed with [CRITICAL] notice.");
        }

        if(updateOverride){
            launchCaledoniaButton.setEnabled(false);
            launchCaledoniaButton.setToolTipText("You must download a required update for Caledonia before proceeding.");
        }
    }

    public static String[] findErrors() throws IOException, URISyntaxException {
        ArrayList<String> errors = new ArrayList<String>();

        File data = new File("data/");
        if (data.exists()) {
            File[] filesInDirectory = data.listFiles();
            for (File element : filesInDirectory) {
                if (!element.isDirectory()) {
                    errors.add("[FATAL] Unknown file " + element.getName() + " in data/. Remove file.");
                } else {
                    if(!Arrays.stream(element.list()).anyMatch("name.txt"::equals)) errors.add("[FATAL] Missing name.txt file in " + element.getPath() + ". Restore name.txt or remove course.");
                    if(!Arrays.stream(element.list()).anyMatch("notes.json"::equals)) errors.add("[FATAL] Missing notes.json file in " + element.getPath() + ". Restore notes.json or remove course.");
                    if(!Arrays.stream(element.list()).anyMatch("reports.json"::equals)) errors.add("[FATAL] Missing reports.json file in " + element.getPath() + ". Restore reports.json or remove course.");
                    for (String filename: element.list()) {
                        if(!(filename.equals("name.txt") || filename.equals("notes.json") || filename.equals("reports.json"))) errors.add("[WARN] Unknown file " + filename + " in " + element.getPath() + ". This will not affect function.");
                    }
                }
            }
        } else {
            errors.add("[FATAL] Missing data/ directory. Create data/ directory.");
        }

        errors.addAll(APIErrors);

        if (errors.isEmpty()) errors.add("No problems found.");
        return errors.toArray(new String[0]);
    }
    public static ArrayList<String> checkApi() throws IOException {
        ArrayList<String> errors = new ArrayList<String>();
        File apiKey = new File("apikey.txt");
        if(apiKey.exists()){
            String apikey = filesystemInterface.readFile(apiKey.getPath()).get(0);
            Response response = aiInterface.makeRequest("N/A", "N/A");
            if(!response.isSuccessful()){
                Integer code = response.code();
                String responseMessage = response.message();
                errors.add("[WARN] OpenAI returned error code " + code + ". This will be displayed when a report is made if not addressed.");
            }
        } else errors.add("[CRITICAL] Missing file apikey.txt. Program will crash when a request to generate a report is made.");
        return errors;
    }

    public static void updateNoticeList() throws IOException, URISyntaxException {
        noticeList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = findErrors();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

    }
    // </editor-fold>
}
