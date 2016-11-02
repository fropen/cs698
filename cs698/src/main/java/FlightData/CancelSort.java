package FlightData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CancelSort {

	public static void main(String[] args) throws IOException{
		String pathname = "part-r-00100";
		System.out.println("Open File: "+pathname);
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader(new FileReader(pathname));
		String line;
		String get[][] = new String[10000][2];
		String tmp[];
		int row = 0;
		while((line = in.readLine()) != null){
			tmp = line.split("\t");
			get[row][0] = tmp[0];
			
			get[row][1] = tmp[1];
			row++;
			
		}
		String sort[][] = new String[row][2];
		for(int i = 0 ; i < row ; i ++){
			sort[i][0] = get[i][0];
			sort[i][1] = get[i][1];
		}
		System.out.println("Get File:");
		for(int i = 0 ; i < row ; i ++){
			System.out.println(sort[i][0]+" "+sort[i][1]);
		}
		
		int max = 0;
		int t = 0;
		
		for(int i = 0 ; i < row ; i++){
			if(Integer.parseInt(sort[i][1]) > max){
				max = Integer.parseInt(sort[i][1]);
				t = i;
			}
		}
		System.out.println("Get Max:");
		System.out.println(sort[t][0] + " " +sort[t][1]);
		
		String outfile = "CancelReason.txt";
		System.out.println("Generate File: "+outfile);
		File file = new File(outfile);
		FileWriter out = new FileWriter(file);
		out.write("The most common reason for flight cancellations:\n");
		out.write(sort[t][0] + "\t" +sort[t][1]+"\n");
		out.flush();
        out.close();
	}
	
}
