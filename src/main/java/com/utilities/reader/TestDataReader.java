package com.utilities.reader;

import lombok.Getter;
import org.jetbrains.annotations.Contract;

/**
 * Class to represent reading Test Data at environment level, and global level based on the defined file structure.
 */
public class TestDataReader {

    private static final String delimiter;
    private static final String globaldata;

    static {
        delimiter = "/";
//        envfolder = com.trustarc.themis.utilities.reader.SystemDataReader
//            .getEnvName() == null ? "dev" : com.trustarc.themis.utilities.reader.SystemDataReader.getEnvName();
        globaldata = "data";

    }

    @Getter
    private static final String fileExtension = ".properties";
    PropertyReader reader = new NewPropertyFileReader();

    @Contract(pure = true)
    private String getGlobalDataFolderPath() {
        return this.getClass().getClassLoader().getResource("data/").getPath();
    }

//    private String getEnvLevelTestData(String key, String functionality) {
//        reader.setPropertyFile(getGlobalDataFolderPath() + envdatafolderpath +
//            functionality + fileExtension);
//        String value = reader.getProp(key);
//
//        return (HelperUtils.isUsable(value)) ? value : getFunctionalityLevelTestData(key, functionality);
//    }

    private String getTestData(String key) {
        reader.setPropertyFile(getGlobalDataFolderPath() + globaldata + fileExtension);
        String value = reader.getProp(key);
        try {
            if (value == null) {
                throw new RuntimeException("Add key - " + key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * Method to read other data
     */
    public String readData(String key) {
        return getTestData(key).trim();
    }

}
