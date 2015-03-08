import org.jfugue.*;
import java.io.*;
import java.util.*;

class sampleJava {
	
	static double bassFrequency[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
	static String pentatonicNotes[] = {"C3", "E3", "F3", "G3", "B3", "C4", "E4", "F4", "G4", "B4", "C5", "E5", "F5", "G5", "B5", "C6"};
	//static double stocks[] = {32.5, 24, 40, 34, 20, 20, 15.4, 16.5, 37.6, 19.8, 20.0, 30, 21.4};
	// static double stocks1[] = new double[1000];
	// static double stocks2[] = new double[1000];
	// static double stocks3[] = new double[1000];
	// static double stocks4[] = new double[1000];
	static double stocks[] = new double[1000];
	//static int count = 0;
	static int length = 0;
	static int numberOfBars = 0;
	static double max = 0;
	static double min = 0;
	static int posMax = 0;
	static int posMin = 0;

	// double getExactFrequency(double input) {
	// 	double[]
	// }

	static void getExtremes() {
		max = stocks[0];
		min = stocks[0];
		posMax = 0;
		posMin = 0;
		for(int i = 1; i < length; i++) {
			if(max < stocks[i]) {
				max = stocks[i];
				posMax = i;
			}
			if(min > stocks[i]) {
				min = stocks[i];
				posMin = 0;
			}
		}
	}
	// void getStocks(String mainLine) {
			
	// 		for(int i = 0; i < len; i++) {

	// 		}
	// }
	static void divideIntoBars() {
		numberOfBars = 128;
	}
	static int findPos(double tick) {
		return Arrays.asList(stocks).indexOf(tick);
	}
	static boolean nearTheHighs(double val) {
		int tempPos = findPos(val);
		if(tempPos < posMax && (posMax - tempPos == 8)) {
			return true;
		}
		return false;
	}
	static boolean nearTheLows(double val) {
		int tempPos = findPos(val);
		if(tempPos < posMin && (posMin - tempPos == 8)) {
			return true;
		}
		return false;
	}

	static int getNote(double val) {
		int i = (int)val;
		// for(i = 0; i < bassFrequency.length - 1; i++) {
		// 	if(stocks[i] == val) {
		// 		// cout++;
		// 		// System.out.println(cout);
		// 		return i;
		// 	}
		// 	else if(stocks[i] < val && stocks[i+1] > val) {
		// 		// cout++;
		// 		// System.out.println(cout);
		// 		double diff1 = val - stocks[i];
		// 		double diff2 = stocks[i] - val;
		// 		if(diff1 < diff2) {
		// 			//System.out.println(i);
		// 			return i;
		// 		}
		// 		else {
		// 			//System.out.println(i + 1);
		// 			return i+1;
		// 		}

		// 	}
		// }
		//System.out.println(i + "....");
		return i;
	}
	static String getPianoNotes() {																	//Main function to get the piano notes
		String p = "C";
		double averageNote = findAverage();
		// for(int i = 0; i < 500; i++) {
		// 	stocks[i] = Math.random() * 10;
		// }
		getExtremes();
		System.out.println(min +" " + max);
		for(int i = 0; i < length; i++) {
			double temp = map(stocks[i], min, max, bassFrequency[0], bassFrequency[bassFrequency.length - 1]);
			System.out.println(temp);
			int notePosition = getNote(temp);
			//System.out.println(notePosition);
			if(i % 2 == 0) {
				p = p + " ";
			}
			else {
			 	p = p + "+";
			}
			p = p + pentatonicNotes[notePosition] + "i";
			//p = p + " " + pentatonicNotes[notePosition] + "i";
			//System.out.println(p);
		}
		return p;
	}

	static double map(double x, double in_min, double in_max, double out_min, double out_max) {		//maps the values into a specific range
		return (x - in_min+10) * (out_max - out_min) / (in_max - in_min) * out_min;
	}

	static double findAverage() {
		double sum = 0;
		int i = 0;
		for(i = 0; i < length; i++) {
			sum = stocks[i];
		}
		return sum/(i-1);
	}

	// static void parser("input.txt") {
	// 	JSONObject obj = new JSONObject("input.txt");

	// 	JSONArray arr = obj.getJSONArray("data");


	// 	for(int i = 0; i < arr.length(); i++) {
	// 		String px_last = arr.getJSONObject(i).getString("PX_LAST");
	// 	}
	// }

	// static void companyParser("marketdata.rtf") {
	// 	StringTokenizer st = new StringTokenizer("input.txt",",");
	// 	StringTokenizer st1;
	// 	while(st.nextToken() != NULL) {
	// 		st1 = new StringTokenizer(st);
	// 		System.out.println(st1);
	// 	}

	// }
	public static void main(String args[])throws IOException {
		//System.out.println("HII");
		//System.out.println("C");
		// for(int i = 0; i < 16; i++) {

		// }
		//  FileReader fin = new FileReader("marketdata.txt");
		//  Scanner src = new Scanner(fin);

		//  int lineCount = 0;
		// while(src.hasNext())
		// {
		// 	lineCount++;
		// }
		// System.out.println(lineCount);
		//StringTokenizer st1;
		// while(line != null) {
		// 	st1 = new StringTokenizer(line);
		// BufferedReader br = new BufferedReader(new FileReader("marketdata.rtf"));
		// // 	//String a = br1.readLine();
		// String t = br.readLine();
		// int l = t.length();
		// 	while(t.length() != 0) {
		// 		if(t.length() > 16 && t.substring(1,8).equals("PX_LAST")) {
		// 			stocks[count++] = Double.parseDouble(t.substring(10, 16));
		// 			System.out.println(count);
		// 		}
		// 		t = br.readLine();
		// 	}
				//System.out.println(t);
			//}
		// 	//br1.close();
		// 	//System.out.println(st1.nextToken());
		// 	//st.nextToken();
		// 	//line = br.readLine();
		// }
		// int i = 0;
		// while((i = t.indexof("PX_LAST")) >= 0) {
		// 	stocks[count++] = t.substring(i+9, i+15);
		// 	System.out.println(count);
		// }
		//System.out.println(count);
		// Rhythm rhythm = new Rhythm();
		// rhythm.setLayer(1, "O..oO...O..oOO..");
		// rhythm.setLayer(2, "..*...*...*...*.");
		// rhythm.setLayer(3, "^^^^^^^^^^^^^^^^");
		// rhythm.setLayer(4, "...............!");
		// rhythm.addSubstitution('O', "[BASS_DRUM]i");
		// rhythm.addSubstitution('o', "Rs [BASS_DRUM]s");
		// rhythm.addSubstitution('*', "[ACOUSTIC_SNARE]i");
		// rhythm.addSubstitution('^', "[PEDAL_HI_HAT]s Rs");
		// rhythm.addSubstitution('!', "[CRASH_CYMBAL_1]s Rs");
		// rhythm.addSubstitution('.', "Ri");
		// Pattern drum = rhythm.getPattern();
		// drum.repeat(4);

		
		BufferedReader br = new BufferedReader(new FileReader("pxLastData.txt"));
		String line = br.readLine();
		// StringTokenizer st = new StringTokenizer(line);
		// int n = st.countTokens();
		// System.out.println(n);
		while(line != null && line.length() != 0) {
			stocks[length] = Double.parseDouble(line) * 10;
			length++;
			line = br.readLine();
		}
		for(int i = 0; i < length; i++) {
			System.out.println(stocks[i]);
		}
		String temp = getPianoNotes();
		System.out.println(temp);
		temp = "I109 " + temp + "d30";
		Pattern lead = new Pattern(temp);
		//Pattern song = new Pattern();
		//song.add(drum);
		//song.add(lead);
		//System.out.println(temp + "d30");
		Player player = new Player();
		//player.play("C3 E3 F3 G3 A3 B3 C3");
		//Pattern pattern = new Pattern(temp);
		player.play(lead);
		//br.close();
		//System.out.println("C");
	}

}