/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.controller;

import dvdlibrary.ui.*;
import dvdlibrary.dao.*;
import dvdlibrary.dto.*;
import java.util.*;


/**
 *
 * @author 16265
 */
public class DvdLibraryController {
    
    private DvdLibraryView view;
    private DvdLibraryDao dao;
    
    public DvdLibraryController(DvdLibraryView view, DvdLibraryDaoImpl dao){
        this.view = view;
        this.dao = dao;
    }
    
    
    public void run() throws DvdLibraryDaoException{
        
        // Load the dvds from the save file
        dao.loadRoster();
        
        // Go through loop of processing user input
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                
                // Use case 1, add dvd
                case 1:
                    createDvd();
                    break;
                    
                // Use case 2, remove a dvd by title
                case 2:
                    removeDvd();
                    break;
                
                // Use case 3, edit a dvd
                case 3:
                    editDvd();
                    break;
                
                // Use case 4, list all dvds
                case 4:
                    listDvds();
                    break;
                
                // Use case 5, display a dvd's info
                case 5:
                    viewDvd();
                    break;
                    
                // USE CASE 6, Save and quit    
                case 6:
                    keepGoing = false;
                    break;
                    
                default:
                    unknownCommand();
            }

        }
        
        
        saveAndExit();
    }
    
    // Use case 1: Create DVD
    private void createDvd() {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }
    
    // USE CASE 2: Remove a DVD
    private void removeDvd() {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }
    
    // USE CASE 3: Edit a DVD
    private void editDvd(){
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        
        // If title is in collection, then edit.
        if (dao.dvdInCollection(title)){
            Dvd newDvd = view.getEditedDvdInfo(title);
            view.displayEditSuccessBanner();
        }
        // Else, print out no such DVD found
        else{
            view.displayNoDvdFound();
        }
    }
    
    // Use case 4: List all Dvds
    private void listDvds() {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }
    
    // USE CASE5: View dvd info
    private void viewDvd() {
        view.displayDisplayDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }
    
    // Default case
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    // USE CASE: 6, SAVE and exit
    private void saveAndExit() throws DvdLibraryDaoException {
        
        dao.writeRoster();
        view.displayExitBanner();
    }
    
    
    
    
    
    
    
    
    
    
}
