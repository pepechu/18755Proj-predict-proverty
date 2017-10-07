package cmu.ece;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadImage {
	
	public static final String urlpref = "https://maps.googleapis.com/maps/api/staticmap?center=";
	public static final String urlsuf ="&zoom=15&size=400x400&maptype=satellite&key=";
	public static final String key = "";
	public static final String pathpref = "";
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(DownloadImage.class.getResourceAsStream("candidate_download_locs.txt"),StandardCharsets.UTF_8));
		String line;
		int i = 1;
		while ((line = br.readLine()) != null) {
			String[] tmp = line.split("\\s+");
			String latitude = tmp[0];
			String longitude = tmp[1];
			String url = urlpref + latitude + "," + longitude + urlsuf;
			String path = pathpref + i + ".png";
			System.out.println(url);
			InputStream in = new URL(url).openStream();
			Files.copy(in, Paths.get(path));
			i++;
		}
	}

}
