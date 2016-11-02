/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package FlightData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaxiSort {

	public static void main(String[] args) throws IOException{
		
		String pathname = "part-r-00001";
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
//		System.out.println("Before Sort:");
//		for(int i = 0 ; i < row ; i ++){
//			System.out.println(sort[i][0]+" "+sort[i][1]);
//		}
//		
		Sort(sort);
//		System.out.println("After Sort:");
//		for(int i = 0 ; i < row ; i ++){
//			System.out.println(sort[i][0]+" "+sort[i][1]);
//		}
		
		System.out.println("The highest probability for being on schedule:");
		for(int i = sort.length - 1 ; i > sort.length - 4 ; i--){
			System.out.println(sort[i][0]+ "\t" + sort[i][1]);
		}
		System.out.println("The lowest probability for being on schedule:");
		for(int i = 0 ; i < 3; i++){
			System.out.println(sort[i][0]+ "\t" + sort[i][1]);
		}
		
		String outfile = "TaxiTime.txt";
		System.out.println("Generate File: "+outfile);
		File file = new File(outfile);
		FileWriter out = new FileWriter(file);
		out.write("The longest average taxi time per flight:\n");
		for(int i = sort.length - 1 ; i > sort.length - 4 ; i--){
			out.write(sort[i][0]+ "\t" + sort[i][1]+"\n");
		}
		out.write("The shortest average taxi time per flight:\n");
		for(int i = 0 ; i < 3; i++){
			out.write(sort[i][0]+ "\t" + sort[i][1]+"\n");
		}
		
		out.flush();
        out.close();
	}
	
	private static String[][] Sort(String[][] array){
		
		
		for(int i = 0 ; i < array.length ; i++){
			for(int j = i + 1 ; j < array.length ; j++){
				if(Double.parseDouble(array[i][1]) > Double.parseDouble(array[j][1])){
					String tmp[][] = new String[1][2];
					tmp[0][0] = array[i][0];
					tmp[0][1] = array[i][1];
					array[i][0] = array[j][0];
					array[i][1] = array[j][1];
					array[j][0] = tmp[0][0];
					array[j][1] = tmp[0][1];
				}
			}
		}
		
		
		
		return array;
		
	}
	
}
