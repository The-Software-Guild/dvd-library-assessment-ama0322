/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.runner;

import dvdlibrary.controller.*;
import dvdlibrary.dao.*;
import dvdlibrary.ui.*;

/**
 *
 * @author 16265
 */
public class App {
    
    
    
    public static void main(String[] args) throws DvdLibraryDaoException {
        DvdLibraryController controller = new DvdLibraryController(new DvdLibraryView(new UserIOConsoleImpl()), new DvdLibraryDaoImpl());
        controller.run();
    }
    
    
    
    
    
    
}
