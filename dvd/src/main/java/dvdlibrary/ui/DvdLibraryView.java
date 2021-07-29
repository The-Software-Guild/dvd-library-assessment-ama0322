/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.ui;

import dvdlibrary.dto.Dvd;
import java.util.*;


/**
 *
 * @author 16265
 */
public class DvdLibraryView {
    
    
    private UserIO io;
    
    public DvdLibraryView(UserIO io){
        this.io = io;
    }
    
    
    // Print Menu
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add a DVD to the collection");
        io.print("2. Remove a DVD from the collection");
        io.print("3. Edit a DVD's info");
        io.print("4. List the DVD's in the collection");
        io.print("5. Display a DVD's information");
        io.print("6. Save and quit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }    

    // For Use case 1: Create new DVD
    public Dvd getNewDvdInfo() {
        
        // Get information to create a new dvd
        String title = io.readString("Please enter the title");
        String releaseDate = io.readString("Please enter the release date");
        String mpaa = io.readString("Please enter the MPAA rating");
        String director = io.readString("Please enter the director's name");
        String studio = io.readString("Please enter the studio");
        String note = io.readString("Please enter any notes you want for this DVD");
        
        Dvd currentDvd = new Dvd(title, releaseDate, mpaa, director, studio, note);
        return currentDvd;
    }
    
    // Use case 1 display 
    public void displayCreateDvdBanner() {
    io.print("=== Create DVD ===");
    }
    
    // Use case 1 display 
    public void displayCreateSuccessBanner() {
    io.readString(
            "DVD successfully created.  Please hit enter to continue");
    }
    
    // USE CASE 2 display
    public void displayRemoveDvdBanner () {
    io.print("=== Remove Dvd ===");
    }
    /// USE CASE 2 display result of remove
    public void displayRemoveResult(Dvd dvd) {
        if(dvd != null){
        io.print("DVD successfully removed.");
        }else{
        io.print("No such DVD with that title.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    // USE CASE 3 banner
    public void displayEditDvdBanner () {
        io.print("=== Edit Dvd ===");
    }
    
    // USE CASE 3, no dvd with that title found
    public void displayNoDvdFound(){
        io.print("No DVD with that title found");
        io.readString("Please hit enter to continue.");
    }
    
    // USE CASE 3: Get info to edit DVD info
    public Dvd getEditedDvdInfo(String title) {
        
        // Get information to create a new dvd
        String releaseDate = io.readString("Please enter the new release date");
        String mpaa = io.readString("Please enter the new MPAA rating");
        String director = io.readString("Please enter the new director's name");
        String studio = io.readString("Please enter the new studio");
        String note = io.readString("Please enter any notes you want for this DVD");
        
        Dvd currentDvd = new Dvd(title, releaseDate, mpaa, director, studio, note);
        return currentDvd;
    }
    
    // USE CASE 3: Edit successful
    public void displayEditSuccessBanner() {
        io.readString("DVD successfully edited.  Please hit enter to continue");
    }
    
    // Use case 4: Display all Dvd's
    public void displayDvdList(List<Dvd> dvdList) {
    for (Dvd currentDvd : dvdList) {
        String dvdInfo = String.format("%s", currentDvd.getTitle());
        io.print(dvdInfo);
    }
    io.readString("Please hit enter to continue.");
}
    // Use case 4: Banner
    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===");
    }
    
    
    // USE CASE 5: Banner
    public void displayDisplayDvdBanner () {
        io.print("=== Display DVD ===");
    }

    // USE CASE 2, 3, 5: Get DVD title
    public String getDvdTitleChoice() {
        return io.readString("Please enter the name of the DVD");
    }

    // USE CASE 5: Display the DVD
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaa());
            io.print(dvd.getDirector());
            io.print(dvd.getStudio());
            io.print(dvd.getUserNote());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    
    // Exit
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    // Unknown command
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    
    
    
    
    
    
    
    
    
    
}
