package com.edubridge.desktop.service;

import java.util.List;

import com.edubridge.desktop.model.Desktop;

public interface DesktopServiceI {
	void addDesktop(Desktop desktop);
	List<Desktop> getAllDesktops();	
	Desktop getDesktopById(Integer id);
	void updateDesktop(Desktop desktop);
	void deleteDesktop(Integer id);
	void deleteAllDesktops();
}