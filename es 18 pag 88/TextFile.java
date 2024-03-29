
import java.io.*;

public class TextFile {
    private char mode; 
    private BufferedReader reader;
    private BufferedWriter writer;

    public TextFile(String filename, char mode) throws IOException {
        this.mode = 'R';
        if (mode == 'W' || mode == 'w') {
            this.mode = 'W';
            writer = new BufferedWriter(new FileWriter(filename));
        }
        else {
            reader = new BufferedReader(new FileReader(filename));
        }
   }

   public void toFile(String line) throws FileException, IOException {
        if (this.mode == 'R')
            throw new ReadOnlyFile();
        writer.write(line);
        writer.newLine();
   }

   public String fromFile() throws FileException, IOException {
        String tmp;

       if (this.mode == 'W')
           throw new WriteOnlyFile();
       tmp =  reader.readLine();
       if (tmp == null)
           throw new EndOfFile();
       return tmp;
   }

   public void closeFile() throws IOException {
        if (this.mode == 'W')
            writer.close();
        else
            reader.close();
   }
}
