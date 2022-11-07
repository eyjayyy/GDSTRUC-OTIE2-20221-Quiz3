package com.gdstruc.module4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int turn = 1;
        int playerCount;
        int successfulGameCount = 0;

        ArrayQueue playerQueue = new ArrayQueue(5);

        while (successfulGameCount < 10) {
            System.out.println("=====> TURN " + turn + " <=====");

            Random rand = new Random();
            playerCount = rand.nextInt(7) + 1; //Randomizes number of players to enqueue for matchmaking
            System.out.println("Enqueued - " + playerCount + " Player/s");

            //Enqueues x players
            for (int i = 0; i < playerCount; i++) {
                playerQueue.enqueue(new Player(rand.nextInt(999) + 1)); //Creates players with random IDs ranging from 1-999
            }

            System.out.println("Current No. in Queue - " + playerQueue.size() + " Player/s");

            //Dequeues if there are atleast 5 players queued
            if (playerQueue.size() >= 5) {
                System.out.println("\nGame Start! Dequeuing First 5 Players!");

                for (int i = 0; i < 5; i++) {
                    playerQueue.dequeue();
                }

                System.out.println("Current No. in Queue - " + playerQueue.size() + " Player/s");
                successfulGameCount++;
                entCont();
            }

            else {
                System.out.println("\nGame Cannot Be Started!");
                entCont();
            }

            turn++;
        }

        System.out.println("10 successful games are made!");
    }

    private static void entCont() {
        System.out.println("\nPress Enter to End Turn...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
