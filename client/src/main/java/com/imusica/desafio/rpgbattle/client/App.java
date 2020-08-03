package com.imusica.desafio.rpgbattle.client;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        String nickname = "";
        int heroType;
        String[] heros = new String[]{"WARRIOR", "BARBARIAN", "PALADIN"};

        System.out.println("================RPG BATTLE CLIENT================");
        System.out.print("Select a Nickname: ");
        nickname = inputReader.nextLine();
        if (nickname.isEmpty()) {
            System.out.println("Invalid nickname!");
            return;
        }

        System.out.print("Select a Hero[0 - WARRIOR, 1 - BARBARIAN, 2 - PALADIN]: ");
        heroType = inputReader.nextInt();
        if (heroType < 0 || heroType > 2) {
            System.out.println("Invalid hero!");
            return;
        }

        System.out.println("");
        System.out.println("Nickname: " + nickname);
        System.out.println("Hero: " + heros[heroType]);

        System.out.println("");
        System.out.println("STARTING BATTLE.....");

        String result = makeRequest(nickname, heros[heroType]);

        System.out.println("================BATTLE FINISHED================");
        if (!result.isEmpty()) {
            JSONObject json = new JSONObject(result);
            JSONObject jsonWinner = json.getJSONObject("winner");
            JSONObject jsonRanking = json.getJSONObject("ranking");

            System.out.println("RESULT: " + (jsonWinner.get("type").equals("MONSTER") ? "You Lose" : "You WIN!!!"));
            System.out.println("RANKING: " + jsonRanking.toString());

            System.out.println("===============================================");
            System.out.println("");
            System.out.println("BATTLE DETAILS: " + result);
        } else {
            System.out.println("NO RESULTS...");
        }
    }

    private static String makeRequest(String nickname, String heroType) {
        try {
            HttpURLConnection httpClient = (HttpURLConnection) new URL("http://localhost:8080/api/battle")
                    .openConnection();

            httpClient.setRequestMethod("POST");
            httpClient.setRequestProperty("Content-Type", "application/json; utf-8");
            httpClient.setRequestProperty("Accept", "application/json");
            httpClient.setDoOutput(true);

            String json = "{\"nickname\": \"" + nickname + "\", \"herotype\": \"" + heroType + "\"}";

            try (OutputStream os = httpClient.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(httpClient.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;

                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                //System.out.println(response.toString());

                return response.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
