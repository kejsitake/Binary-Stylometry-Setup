import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

import javax.script.ScriptException;



public class BinaryDisassemble {
	

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InterruptedException, ScriptException {
		   		
		String test_dir ="/mnt/data_bsd/14FilesPerAuthor_2014_NOToptimized_hexraysSCAA2/";
        	
        	

           	List test_file_paths = Util.listCFiles(test_dir);
           	List test_binary_paths = Util.listBinaryFiles(test_dir);
           	List test_dis_paths = Util.listDisFiles(test_dir);
	
           	
           	
        	//delete all disassembled files
/*           	for(int bin=0; bin< test_dis_paths.size(); bin++){
        		System.out.println(test_dis_paths.get(bin).toString());
        			File toDelete = new File(test_dis_paths.get(bin).toString());
        		//	toDelete.delete();
        			}*/
           	
           	
          	//disassemble the binaries from the test folder 
           	for(int bin=0; bin< test_binary_paths.size(); bin++){
        		System.out.println(test_binary_paths.get(bin).toString());
        		if(!(new File(test_binary_paths.get(bin).toString() + ".dis").exists())){
        	//	disassembleBinaries(test_binary_paths.get(bin).toString(), "32");
        		stripBinaries(test_binary_paths.get(bin).toString());	
        		}
        			}
       	
   	}
     
		public static void disassembleBinaries(String filePath, String bits) throws IOException, InterruptedException, ScriptException{
			//should take filename to test each time
			//just needs the name of the directory with the authors and their source files as an input
		
			 Runtime disTime = Runtime.getRuntime();
			 String output_filename = filePath.concat(".dis");
			 String cmd1 = "ndisasm -b " +bits +" " + filePath.toString() + " > " + output_filename;      
		     Process disassemble = disTime.exec((new String[]{"/bin/sh","-c", cmd1}));
		     disassemble.waitFor();
		}

		public static void stripBinaries(String filePath) throws IOException, InterruptedException, ScriptException{
			
			 Runtime disTime = Runtime.getRuntime();
			 String output_filename = filePath;
			 String cmd1 = "strip -s " + filePath.toString() + " > " + output_filename;      
		     Process disassemble = disTime.exec((new String[]{"/bin/sh","-c", cmd1}));
		     disassemble.waitFor();
		}
				
	
}
	











