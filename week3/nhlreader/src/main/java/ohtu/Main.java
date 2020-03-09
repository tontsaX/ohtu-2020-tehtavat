/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.http.client.fluent.Request;

/**
 *
 * @author mluukkai
 */
public class Main {

	public static void main(String[] args) throws IOException {
		String url = "https://nhlstatisticsforohtu.herokuapp.com/players";		
		String json = Request.Get(url).execute().returnContent().asString();

		Gson gson = new Gson();
		Player[] players = gson.fromJson(json, Player[].class);
		
		ArrayList<Player> finPlayers = new ArrayList<>();
		
		for(Player player: players) {
			if(player.getNationality().equalsIgnoreCase("fin")) {
				finPlayers.add(player);
			}
		}
		
		Collections.sort(finPlayers, Player.PlayerPoints);
		for(Player player: finPlayers) {
			System.out.println(player.toString());
		}

	}
}
