package com.edubridge.desktop;

import java.util.List;
import java.util.Scanner;

import com.edubridge.desktop.model.Desktop;
import com.edubridge.desktop.service.DesktopService;

public class App {
    public static void main(String[] args) {
        int option = 0;
        Scanner in = new Scanner(System.in);
        DesktopService service = new DesktopService();
        String name, email, mobile;
        name = email = mobile = null;

        do {
            System.out.println("Welcome to Desktop Application");
            System.out.println("===============================");
            System.out.println("1. Add Desktop");
            System.out.println("2. View All Desktops");
            System.out.println("3. Search Desktop");
            System.out.println("4. Update Desktop");
            System.out.println("5. Delete Desktop");
            System.out.println("6. Delete All Desktops");
            System.out.println("0. Exit");
            System.out.println("Please choose option: ");
            option = in.nextInt();

            switch (option) {
            case 1:
                System.out.println("Add New Desktop");
                System.out.println("---------------");
                System.out.println("Enter Desktop Name: ");
                name = in.next();
                System.out.println("Enter Desktop Email: ");
                email = in.next();
                System.out.println("Enter Desktop Mobile: ");
                mobile = in.next();

                Desktop desktop = new Desktop();
                desktop.setName(name);
                desktop.setEmail(email);
                desktop.setMobile(mobile);

                service.addDesktop(desktop);
                break;

            case 2:
                System.out.println("View All Desktops");
                System.out.println("------------------");
                List<Desktop> desktops = service.getAllDesktops();
                if (desktops.size() != 0) {
                    for (Desktop d : desktops) {
                        System.out.println(d.getId() + "\t" + d.getName() + "\t" + d.getEmail() + "\t" + d.getMobile());
                    }
                } else {
                    System.out.println("No desktops found");
                }
                break;

            case 3:
                System.out.println("Search Desktop");
                System.out.println("--------------");
                System.out.println("Please enter desktop id: ");
                int id = in.nextInt();
                Desktop d = service.getDesktopById(id);
                if (d != null) {
                    System.out.println("Desktop Name: " + d.getName());
                    System.out.println("Desktop Email: " + d.getEmail());
                    System.out.println("Desktop Mobile: " + d.getMobile());
                } else {
                    System.out.println("No desktop found with id: " + id);
                }
                break;
                
            case 4:
                System.out.println("Update Desktop Details");
                System.out.println("-----------------------");
                System.out.println("Enter Desktop Id: ");
                int desktopId = in.nextInt();
                System.out.println("Enter Desktop Name: ");
                name = in.next();
                System.out.println("Enter Desktop Email: ");
                email = in.next();
                System.out.println("Enter Desktop Mobile: ");
                mobile = in.next();
                
                Desktop updatedDesktop = new Desktop();
                updatedDesktop.setId(desktopId);
                updatedDesktop.setName(name);
                updatedDesktop.setEmail(email);
                updatedDesktop.setMobile(mobile);
                service.updateDesktop(updatedDesktop);
                break;
                
            case 5:
                System.out.println("Delete Desktop");
                System.out.println("--------------");
                System.out.println("Please enter desktop id: ");
                int desktopIdToDelete = in.nextInt();
                service.deleteDesktop(desktopIdToDelete);                
                break;

            case 6:
                System.out.println("Are you sure you want to delete all desktops? [Y/N]");
                String confirm = in.next();
                if(confirm.equalsIgnoreCase("Y")) {
                    service.deleteAllDesktops();            
                }
                break;
                
            case 0:
                System.out.println("Bye!!!");
                System.exit(0);
                break;
                
            default:
                System.out.println("Please choose a correct option: ");
                break;
            }

        } while (option != 0);
    }
}
