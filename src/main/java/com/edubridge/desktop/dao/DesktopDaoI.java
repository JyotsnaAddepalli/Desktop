package com.edubridge.desktop.dao;


import java.util.List;

import com.edubridge.desktop.model.Desktop;


public interface DesktopDaoI {
	
	
	void addDesktop(Desktop desktop);
	List<Desktop> getAllDesktops();	
	Desktop getDesktopById(Integer id);
	void updateDesktop(Desktop desktop);
	void deleteDesktop(Integer id);
	void deleteAllDesktops();
}
