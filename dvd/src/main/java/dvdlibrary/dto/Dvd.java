/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dto;

/**
 *
 * @author 16265
 */
public class Dvd {
    
    // Dvd information
    private String title = "";
    private String releaseDate = "";
    private String mpaa = "";
    private String director = "";
    private String studio = "";
    private String userNote = "";

    
    // Constructor
    public Dvd(String title, String releaseDate, String mpaa, String director, String studio, String userNote){
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaa = mpaa;
        this.director = director;
        this.studio = studio;
        this.userNote = userNote;
    }
    
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaa() {
        return mpaa;
    }

    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
    
    
    
    
    
}
