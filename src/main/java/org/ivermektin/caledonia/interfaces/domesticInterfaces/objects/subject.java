package org.ivermektin.caledonia.interfaces.domesticInterfaces.objects;

import com.google.gson.Gson;
import org.ivermektin.caledonia.interfaces.systemInterfaces.filesystemInterface;
import org.ivermektin.caledonia.userinterface.launcher.launcherWindow;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * This object class is subject.
 * A subject is identified by a unique ID and has a name.
 * It can have multiple notes and reports associated with it.
 */

public class subject {
    String name;
    String id;
    ArrayList<data> notes;
    ArrayList<data> reports;


    /**
     * Constructs a subject object with the given name, ID, notes, and reports.
     * @param name      the name of the subject
     * @param id        the ID of the subject
     * @param notes     the list of notes associated with the subject
     * @param reports   the list of reports associated with the subject
     */
    public subject(String name, String id, ArrayList<data> notes, ArrayList<data> reports){
        this.name = name;
        this.id = id;
        this.notes = notes;
        this.reports = reports;
    }

    /**
     * Saves the subject and its associated data to the filesystem.
     * The subject is saved as a directory with the ID as the name.
     * The subject's name is saved in a text file, and the notes and reports are saved as JSON files.
     */
    public void saveSubject(){
        Gson JSONParser = new Gson();

        String filepath = "data/" + id;
        String nfp = filepath + "/name.txt";
        String ntfp = filepath + "/notes.json";
        String rpfp = filepath + "/reports.json";

        String notesJSON = JSONParser.toJson(new packagedData(notes));
        String reportsJSON = JSONParser.toJson(new packagedData(reports));

        filesystemInterface.saveString(nfp, name);
        filesystemInterface.saveString(ntfp, notesJSON);
        filesystemInterface.saveString(rpfp, reportsJSON);
    }

    /**
     * Loads a subject object from the filesystem using its ID.
     * @param id    the ID of the subject to load
     * @return      the loaded subject object
     */
    public static subject loadSubjectFromID(String id){
        Gson JSONParser = new Gson();

        String filepath = "data/" + id;
        String nfp = filepath + "/name.txt";
        String ntfp = filepath + "/notes.json";
        String rpfp = filepath + "/reports.json";

        String name = filesystemInterface.readFile(nfp).get(0);
        String notesJSON = filesystemInterface.readFile(ntfp).get(0);
        String reportsJSON = filesystemInterface.readFile(rpfp).get(0);

        packagedData notes = JSONParser.fromJson(notesJSON, packagedData.class);
        packagedData reports = JSONParser.fromJson(reportsJSON, packagedData.class);

        return new subject(name, id, notes.data, reports.data);
    }

    /**
     * Deletes the subject and its associated data from the filesystem.
     */
    public void delete(){
        String filepath = "data/" + id;
        String nfp = filepath + "/name.txt";
        String ntfp = filepath + "/notes.json";
        String rpfp = filepath + "/reports.json";

        new File(nfp).delete();
        new File(ntfp).delete();
        new File(rpfp).delete();
        new File(filepath).delete();
    }

    /**
     * Adds a new note with the given title, author, and content to the subject.
     * @param title     the title of the note
     * @param author    the author of the note
     * @param content   the content of the note
     */
    public void addNote(String title, String author, String content){
        notes.add(new data(title, author, content));
        saveSubject();
    }

    /**
     * Adds a new note to the subject.
     * @param data  the note to add
     */
    public void addNote(data data){
        notes.add(data);
        saveSubject();
    }

    /**
     * Adds a new report with the given title and content to the subject.
     * The report is assigned a default author of "Caledonia".
     * @param title     the title of the report
     * @param content   the content of the report
     */
    public void addReport(String title, String content){
        reports.add(new data(title, "Caledonia", content));
        saveSubject();
    }

    /**
     * Adds a new report to the subject.
     * @param data  the report to add
     */
    public void addReport(data data){
        reports.add(data);
        saveSubject();
    }

    /**
     * Removes the note at the specified index from the subject.
     * @param index the index of the note to remove
     */
    public void removeNote(Integer index){
        notes.remove(index);
        saveSubject();
    }

    /**
     * Removes the specified note from the subject.
     * @param note  the note to remove
     */
    public void removeNote(data note){
        notes.remove(note);
        saveSubject();
    }

    /**
     * Removes the report at the specified index from the subject.
     * @param index the index of the report to remove
     */
    public void removeReport(Integer index){
        reports.remove(index);
        saveSubject();
    }

    /**
     * Removes the specified report from the subject.
     * @param report    the report to remove
     */
    public void removeReport(data report){
        reports.remove(report);
        saveSubject();
    }

    /**
     * Returns the ID of the subject.
     * @return the ID of the subject
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the subject.
     * @return the name of the subject
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of notes associated with the subject.
     * @return the list of notes associated with the subject
     */
    public ArrayList<data> getNotes() {
        return notes;
    }

    /**
     * Returns the list of reports associated with the subject.
     * @return the list of reports associated with the subject
     */
    public ArrayList<data> getReports() {
        return reports;
    }

    /**
     * Sets the ID of the subject.
     * @param id the ID of the subject
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the name of the subject.
     * @param name the name of the subject
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the list of notes associated with the subject.
     * @param notes the list of notes associated with the subject
     */
    public void setNotes(ArrayList<data> notes) {
        this.notes = notes;
    }

    /**
     * Sets the list of reports associated with the subject.
     * @param reports the list of reports associated with the subject
     */
    public void setReports(ArrayList<data> reports) {
        this.reports = reports;
    }
}