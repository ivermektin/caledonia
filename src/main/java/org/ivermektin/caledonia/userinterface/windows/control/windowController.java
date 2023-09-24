package org.ivermektin.caledonia.userinterface.windows.control;

import com.formdev.flatlaf.FlatLaf;
import org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.subject;
import org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.data;

import java.util.ArrayList;

/**
 * This static class is the windowController.
 * It contains all information about the currently open subject and data object.
 */
public class windowController {
    static subject currentSubject;
    static data data;
    static FlatLaf lookAndFeel;

    static ArrayList<subject> subjects;
    static ArrayList<data> notes;
    static ArrayList<data> reports;

    /**
     * Sets the current subject for the window controller.
     * @param currentSubject the subject to set.
     */
    public static void setCurrentSubject(subject currentSubject) {
        windowController.currentSubject = currentSubject;
    }

    /**
     * Sets the data for the window controller.
     * @param data the data to set.
     */
    public static void setData(org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.data data) {
        windowController.data = data;
    }

    /**
     * Sets the look and feel for the application.
     * @param lookAndFeel the FlatLaf look and feel to set
     */
    public static void setLookAndFeel(FlatLaf lookAndFeel) {
        windowController.lookAndFeel = lookAndFeel;
    }

    /**
     * Retrieves the current subject set in the window controller.
     * @return the current subject.
     */
    public static subject getCurrentSubject() {
        return currentSubject;
    }

    /**
     * Retrieves the data set in the window controller.
     * @return the data.
     */
    public static org.ivermektin.caledonia.interfaces.domesticInterfaces.objects.data getData() {
        return data;
    }

    /**
     * Returns the current FlatLaf look and feel.
     * @return the current FlatLaf look and feel
     */
    public static FlatLaf getLookAndFeel() {
        return lookAndFeel;
    }
}