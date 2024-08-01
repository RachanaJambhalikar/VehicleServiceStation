package com.sunbeam.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.sunbeam.entities.ServiceStation;
import com.sunbeam.entities.SparePart;

public class SparePartService implements Serializable{

    public static void addPart(Scanner sc) {
        ServiceStation.servicestation.persistParts();

        System.out.println("Select a part to add to the list:");
        ArrayList<SparePart> partList = ServiceStation.servicestation.getPartList();

        for (int i = 0; i < partList.size(); i++) {
            System.out.println((i + 1) + " " + partList.get(i));
        }

        System.out.print("Enter the number of the part you want to add: ");
        int partIndex = sc.nextInt() - 1; // Convert to zero-based index

        if (partIndex >= 0 && partIndex < partList.size()) {
            SparePart selectedPart = partList.get(partIndex);
            System.out.println("Part added: " + selectedPart);
        } else {
            System.out.println("Invalid selection.");
        }

        ServiceStation.servicestation.storePartDetails();
        System.out.println("New part added successfully.");
    }

    public static void displayAllParts() {
        ServiceStation.servicestation.loadPartDetails();
        ArrayList<SparePart> partList = ServiceStation.servicestation.getPartList();

        if (partList.isEmpty()) {
            System.out.println("No parts available.");
        } else {
            System.out.println("List of all spare parts:");
            for (SparePart part : partList) {
                System.out.println(part);
            }
        }
    }

    public static void editPartPrice(Scanner sc) {
        ServiceStation.servicestation.loadPartDetails();
        ArrayList<SparePart> partList = ServiceStation.servicestation.getPartList();

        System.out.println("Select a part to edit its price:");
        for (int i = 0; i < partList.size(); i++) {
            System.out.println((i + 1) + " " + partList.get(i));
        }

        System.out.print("Enter the part number to edit: ");
        int partIndex = sc.nextInt() - 1;
        if (partIndex >= 0 && partIndex < partList.size()) {
            SparePart part = partList.get(partIndex);
            System.out.print("Enter the new price: ");
            double newPrice = sc.nextDouble();
            part.setRate(newPrice);
            System.out.println("Price updated successfully.");
        } else {
            System.out.println("Invalid selection.");
        }

        ServiceStation.servicestation.storePartDetails();
    }

    public static void deletePart(Scanner sc) {
        ServiceStation.servicestation.loadPartDetails();
        ArrayList<SparePart> partList = ServiceStation.servicestation.getPartList();

        System.out.println("Select a part to delete:");
        for (int i = 0; i < partList.size(); i++) {
            System.out.println((i + 1) + " " + partList.get(i));
        }

        System.out.print("Enter the part number to delete: ");
        int partIndex = sc.nextInt() - 1;
        if (partIndex >= 0 && partIndex < partList.size()) {
            partList.remove(partIndex);
            System.out.println("Part deleted successfully.");
        } else {
            System.out.println("Invalid selection.");
        }

        ServiceStation.servicestation.storePartDetails();
    }
}
