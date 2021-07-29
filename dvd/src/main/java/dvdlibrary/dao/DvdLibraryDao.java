/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.Dvd;
import java.util.*;

/**
 *
 * @author 16265
 */
public interface DvdLibraryDao {

    
    
    /** USE CASE 1
     * Add the given dvd to the collection. Is associated with the given title.
     *
     * @param title title of dvd
     * @param dvd dvd object to be added to collection
     * @return null
     */
    void addDvd(String title, Dvd dvd);

    /** USE CASE 2
     * Removes from the collection the dvd associated with the given title. Returns
     * the dvd object if it is found and removed. If not in the collection, return null
     *
     * @param title title of dvd to be removed
     * @return Dvd object that was removed or null if no such dvd with that title in the collection
     */
    Dvd removeDvd(String title);
    
     /** USE CASE 3
     * Modify dvd. Replace in the collection the dvd associated with the given title 
     * with the given dvd
     *
     * @param title title of dvd to be replaced with
     * @param dvd the dvd to replace with
     * @return 
     */
    void editDvd(String title, Dvd dvd);  
    
    /// USE CASE 3: Check if title is in collections
    boolean dvdInCollection(String title);
    
    /**
     * Returns a List of all dvds in the collection
     *
     * @return List containing all dvds in the roster.
     */
    List<Dvd> getAllDvds();

    /**
     * Get dvd object associated withthe given title
     *
     * @param title - title of the dvd to retreive
     * @return the Dvd object associated with the title. 
     * null if no such dvd exists
     */
    Dvd getDvd(String title);


    
    
    
    
    
    
}
