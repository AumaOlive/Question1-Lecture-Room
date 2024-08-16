/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package auma.marketplazalectureroomcontroller;

import java.util.Scanner;

class LectureRoom {
    private final int maxCapacity;
    private int numStudents;
    private boolean[] lights;

    public LectureRoom(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.numStudents = 0;
        this.lights = new boolean[3];
    }

    public void addStudents(int numToAdd) {
        numStudents = Math.min(numStudents + numToAdd, maxCapacity);
    }

    public void removeStudents(int numToRemove) {
        numStudents = Math.max(numStudents - numToRemove, 0);
    }

    public void turnOnLight(int lightNumber) {
        if (lightNumber >= 1 && lightNumber <= 3) {
            lights[lightNumber - 1] = true;
        }
    }

    public void turnOffLight(int lightNumber) {
        if (lightNumber >= 1 && lightNumber <= 3) {
            lights[lightNumber - 1] = false;
        }
    }

    public void displayStatus() {
        System.out.println("Number of students: " + numStudents + "/" + maxCapacity);
        System.out.println("Lights status:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Light " + (i + 1) + ": " + (lights[i] ? "On" : "Off"));
        }
    }
}

class EasyReader {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine(); // Clear the invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }
}
public class MarketPlazaLectureRoomController {

    public static void main(String[] args) {
        LectureRoom lectureRoom = new LectureRoom(100);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("W. Add students");
            System.out.println("X. Remove students");
            System.out.println("Y. Turn on a light");
            System.out.println("Z. Turn off a light");
            System.out.println("Q. Quit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "W":
                    int numStudentsToAdd = EasyReader.getInteger("Enter the number of students to add: ");
                    lectureRoom.addStudents(numStudentsToAdd);
                    lectureRoom.displayStatus();
                    break;
                case "X":
                    int numStudentsToRemove = EasyReader.getInteger("Enter the number of students to remove: ");
                    lectureRoom.removeStudents(numStudentsToRemove);
                    lectureRoom.displayStatus();
                    break;
                case "Y":
                    int lightNumberToTurnOn = EasyReader.getInteger("Enter the light number (1-3) to turn on: ");
                    lectureRoom.turnOnLight(lightNumberToTurnOn);
                    lectureRoom.displayStatus();
                    break;
                case "Z":
                    int lightNumberToTurnOff = EasyReader.getInteger("Enter the light number (1-3) to turn off: ");
                    lectureRoom.turnOffLight(lightNumberToTurnOff);
                    lectureRoom.displayStatus();
                    break;
                case "Q":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

