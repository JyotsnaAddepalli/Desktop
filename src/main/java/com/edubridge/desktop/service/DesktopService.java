package com.edubridge.desktop.service;

import java.util.List;

import com.edubridge.desktop.dao.DesktopDao;
import com.edubridge.desktop.model.Desktop;

public class DesktopService implements DesktopServiceI {
    private DesktopDao dao;

    public DesktopService() {
        dao = new DesktopDao();
    }

    @Override
    public void addDesktop(Desktop desktop) {
        dao.addDesktop(desktop);
    }

    @Override
    public List<Desktop> getAllDesktops() {
        return dao.getAllDesktops();
    }

    @Override
    public Desktop getDesktopById(Integer id) {
        return dao.getDesktopById(id);
    }

    @Override
    public void updateDesktop(Desktop desktop) {
        dao.updateDesktop(desktop);
    }

    @Override
    public void deleteDesktop(Integer id) {
        dao.deleteDesktop(id);
    }

    @Override
    public void deleteAllDesktops() {
        dao.deleteAllDesktops();
    }
}
