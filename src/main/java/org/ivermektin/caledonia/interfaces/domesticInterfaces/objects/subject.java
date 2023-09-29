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

    public subject(String name, String id, ArrayList<data> notes, ArrayList<data> reports){
        this.name = name;
        this.id = id;
        this.notes = notes;
        this.reports = reports;
    }

    public void saveSubject(){
        saveName();
        saveNotes();
        saveReports();
    }

    public void saveName(){
        String nfp = "data/" + id + "/name.txt";
        filesystemInterface.saveString(nfp, name);
    }

    public void saveNotes(){
        Gson jsonParser = new Gson();
        String filepath = "data/" + id + "/notes.json";
        String notesJSON = jsonParser.toJson(new packagedData(notes));
        filesystemInterface.saveString(filepath, notesJSON);
    }

    public void saveReports(){
        Gson jsonParser = new Gson();
        String filepath = "data/" + id + "/reports.json";
        String reportsJSON = jsonParser.toJson(new packagedData(reports));
        filesystemInterface.saveString(filepath, reportsJSON);
    }

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

    public void addNote(String title, String author, String content){
        notes.add(new data(title, author, content));
        saveNotes();
    }

    public void addNote(data data){
        notes.add(data);
        saveNotes();
    }

    public void addReport(String title, String content){
        reports.add(new data(title, "Caledonia", content));
        saveReports();
    }

    public void addReport(data data){
        reports.add(data);
        saveReports();
    }

    public void removeNote(Integer index){
        notes.remove(index);
        saveNotes();
    }

    public void removeNote(data note){
        notes.remove(note);
        saveSubject();
    }

    public void removeReport(Integer index){
        reports.remove(index);
        saveSubject();
    }

    public void removeReport(data report){
        reports.remove(report);
        saveSubject();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<data> getNotes() {
        return new ArrayList<data>(notes);
    }

    public ArrayList<data> getReports() {
        return new ArrayList<data>(reports);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(ArrayList<data> notes) {
        this.notes = notes;
    }

    public void setReports(ArrayList<data> reports) {
        this.reports = reports;
    }
}
