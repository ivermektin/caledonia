package org.ivermektin.caledonia.services.internalServices.objects;

import com.google.gson.Gson;
import org.ivermektin.caledonia.services.systemServices.filesystemInterface;

import java.io.File;
import java.util.ArrayList;

public class Subject {
    private String name;
    private String id;
    private ArrayList<Data> notes;
    private ArrayList<Data> reports;

    private String directoryFP;
    private String notesFP;
    private String nameFP;
    private String reportsFP;

    private static Gson jsonParser = new Gson();



    public Subject(String name, String id, ArrayList<Data> notes, ArrayList<Data> reports){
        this.name = name;
        this.id = id;
        this.notes = notes;
        this.reports = reports;
        this.directoryFP = "Data/" + id + "/";
        this.notesFP = directoryFP + "notes.json";
        this.nameFP = directoryFP + "name.txt";
        this.reportsFP = directoryFP + "reports.json";
    }

    public void saveSubject(){
        saveName();
        saveNotes();
        saveReports();
    }

    public void saveName(){
        filesystemInterface.saveString(nameFP, name);
    }

    public void saveNotes(){
        String notesJSON = jsonParser.toJson(new PackagedData(notes));
        filesystemInterface.saveString(notesFP, notesJSON);
    }

    public void saveReports(){
        String reportsJSON = jsonParser.toJson(new PackagedData(reports));
        filesystemInterface.saveString(reportsFP, reportsJSON);
    }

    public static Subject loadSubjectFromID(String id){
        String root = "Data/" + id;

        String name = filesystemInterface.readFile(root + "/name.txt").get(0);
        String notesJSON = filesystemInterface.readFile(root + "/notes.json").get(0);
        String reportsJSON = filesystemInterface.readFile(root + "/reports.json").get(0);

        PackagedData notes = jsonParser.fromJson(notesJSON, PackagedData.class);
        PackagedData reports = jsonParser.fromJson(reportsJSON, PackagedData.class);

        return new Subject(name, id, notes.data, reports.data);
    }

    public void delete(){
        new File(nameFP).delete();
        new File(notesFP).delete();
        new File(reportsFP).delete();
        new File(directoryFP).delete();
    }

    public void addNote(String title, String author, String content){
        notes.add(new Data(title, author, content));
        saveNotes();
    }

    public void addNote(Data data){
        notes.add(data);
        saveNotes();
    }

    public void addReport(String title, String content){
        reports.add(new Data(title, "Caledonia", content));
        saveReports();
    }

    public void addReport(Data data){
        reports.add(data);
        saveReports();
    }

    public void removeNote(Integer index){
        notes.remove(index);
        saveNotes();
    }

    public void removeNote(Data note){
        notes.remove(note);
        saveNotes();
    }

    public void removeReport(Integer index){
        reports.remove(index);
        saveReports();
    }

    public void removeReport(Data report){
        reports.remove(report);
        saveReports();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Data> getNotes() {
        return new ArrayList<Data>(notes);
    }

    public ArrayList<Data> getReports() {
        return new ArrayList<Data>(reports);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(ArrayList<Data> notes) {
        this.notes = new ArrayList<Data>(notes);
    }

    public void setReports(ArrayList<Data> reports) {
        this.reports = new ArrayList<>(reports);
    }

    @Override
    public String toString(){
        return getName();
    }
}
