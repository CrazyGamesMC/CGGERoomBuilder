package de.cg.rb.ctrl;

import de.cg.utils.data.DataHandler;
import de.cg.utils.files.CGFile;
import de.cg.utils.files.FileContents;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public static void loadConfig() {
        try {
            CGFile cgf = new CGFile("config" + GlobalSettings.fileExtensionSettings);
            File file = cgf.getFile();

            if (!file.exists()) {
                file.createNewFile();
                return;
            }

            cgf.load();

            var contents = cgf.getContents();
            var dh = new DataHandler(contents);

            int len = contents.getArrayList().size();

            for (int i = 0; i<len; i++) {
                var row = dh.getRow(i);
                GameObject obj;

                int width = Integer.parseInt(row[0]);
                int height = Integer.parseInt(row[1]);
                boolean displayAsRect = Boolean.parseBoolean(row[2]);
                boolean include = Boolean.parseBoolean(row[3]);
                String pckg = row[4];
                String name = row[5];
                String imgPath = row[6];

                if (imgPath.equals("NULL")) imgPath = "";

                obj = new GameObject(width, height, displayAsRect, include, pckg, name, imgPath);

                GlobalSettings.initializedObjects.add(obj);
            }

            GlobalSettings.updateElements();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void saveConfig() {
        try {
            var cgf = new CGFile("config" + GlobalSettings.fileExtensionSettings);
            var contents = new FileContents(new ArrayList<String>());

            for (GameObject obj : GlobalSettings.initializedObjects) {
                String toWrite = obj.width + ";" + obj.height + ";" + obj.displayAsRect + ";" + obj.includeWAndHInConstructor + ";" +
                                 obj.pckg + ";" + obj.name + ";" + (obj.imgPath.equals("") ? "NULL" : obj.imgPath);
                contents.append(toWrite);
            }
            contents.print();
            cgf.setContents(contents);
            cgf.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
