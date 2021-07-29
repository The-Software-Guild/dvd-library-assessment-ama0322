/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.Dvd;
import java.io.*;
import java.util.*;

/**
 *
 * @author 16265
 */
public class DvdLibraryDaoImpl implements DvdLibraryDao {

    // Constants
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    // Instance variable to store dvd collection
    private Map<String, Dvd> dvdCollection = new HashMap<>();

    /**
     * UCE CASE 1 Add the given dvd to the collection. Is associated with the
     * given title.
     *
     * @param title title of dvd
     * @param dvd dvd object to be added to collection
     * @return null
     */
    public void addDvd(String title, Dvd dvd) {
        dvdCollection.put(title, dvd);
    }

    /**
     * USE CASE 2 Removes from the collection the dvd associated with the given
     * title. Returns the dvd object if it is found and removed. If not in the
     * collection, return null
     *
     * @param title title of dvd to be removed
     * @return Dvd object that was removed or null if no such dvd with that
     * title in the collection
     */
    public Dvd removeDvd(String title) {
        Dvd removedDvd = dvdCollection.remove(title);
        return removedDvd;
    }

    /**
     * UCSE CASE 3 Modify dvd. Replace in the collection the dvd associated with
     * the given title with the given dvd
     *
     * @param title title of dvd to be replaced with
     * @param dvd the dvd to replace with
     * @return
     */
    public void editDvd(String title, Dvd dvd) {
        dvdCollection.put(title, dvd);
    }

    // USE CASE 3: Check if title is in collections
    public boolean dvdInCollection(String title) {
        return dvdCollection.keySet().contains(title);
    }

    /**
     * USE CASE 4 Returns a List of all dvds in the collection
     *
     * @return List containing all dvds in the roster.
     */
    public List<Dvd> getAllDvds() {
        return new ArrayList<Dvd>(dvdCollection.values());
    }

    /**
     * USE CASE 5 Get dvd object associated withthe given title
     *
     * @param title - title of the dvd to retreive
     * @return the Dvd object associated with the title. null if no such dvd
     * exists
     */
    public Dvd getDvd(String title) {
        return dvdCollection.get(title);
    }

    // Create student object from a line from loaded file
    public Dvd unmarshallDvd(String dvdAsText) {
        // dvdAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // 1234::Ada::Lovelace::Java-September1842
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in studentTokens.
        // Which should look like this:
        // ______________________________________
        // |    |   |        |                  |
        // |1234|Ada|Lovelace|Java-September1842|
        // |    |   |        |                  |
        // --------------------------------------
        //  [0]  [1]    [2]         [3]
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        // Which we can then use to create a new Student object to satisfy
        // the requirements of the Student constructor.
        Dvd dvdFromFile = new Dvd(dvdTokens[0], dvdTokens[1], dvdTokens[2], dvdTokens[3], dvdTokens[4], dvdTokens[5]);

        // We have now created a student! Return it!
        return dvdFromFile;
    }

    // Load dvdCollection from file
    public void loadRoster() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDvd holds the most recent dvd unmarshalled
        Dvd currentDvd;
        // Go through ROSTER_FILE line by line, decoding each line into a Dvd object
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentDvd = unmarshallDvd(currentLine);

            //Put in dvd collection
            dvdCollection.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    // Turn student object into text
    public String marshallStudent(Dvd dvd) {

        // Turn dvd into string
        String dvdAsText = dvd.getTitle() + DELIMITER;
        dvdAsText += dvd.getReleaseDate() + DELIMITER;
        dvdAsText += dvd.getMpaa() + DELIMITER;
        dvdAsText += dvd.getDirector() + DELIMITER;
        dvdAsText += dvd.getStudio() + DELIMITER;
        dvdAsText += dvd.getUserNote();

        // We have now turned a student to text! Return it!
        return dvdAsText;
    }

    /**
     * Writes student objects into file
     * @throws DvdLibraryDaoException if an error occurs writing to the file
     */
    public void writeRoster() throws DvdLibraryDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            // turn a Dvd into a String
            dvdAsText = marshallStudent(currentDvd);
            // write the Dvd object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

} // End of class
