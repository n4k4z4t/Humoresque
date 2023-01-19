import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Humoresque {

    int suki = 0, kira = 0, kirai = 0;

    public static void main(String[] args){
        Humoresque serika = new Humoresque();

        serika.sukikirai();
        
        System.out.println();
        System.out.println();
        
        try{
            File file = new File("Humoresque_lyric.txt");
            FileReader filereader = new FileReader(file);
            int ch = filereader.read();
            while(ch != -1){
                System.out.print((char)ch);
                ch = filereader.read();
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }

        System.out.println();
        System.out.println();
        System.out.println("すき:" + serika.suki + " きら:" + serika.kira + " きらい:" + serika.kirai);
        System.out.println("total:" + (serika.suki + serika.kira + serika.kirai));

    }

    public void sukikirai(){
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < 10; i++){
            queue.add(rand());
            if(queue.peek() == 0) suki++;
            else if(queue .peek() == 1) kirai++;
            else if(queue.peek() == 2) kira++;
        }

        while(true){
            int num[] = new int[10];

            for(int i = 0; i < 10; i++){
                num[i] = queue.poll();
            }
            for(int i = 0; i < 10; i++){
                queue.add(num[i]);
            }

            if (num[0] == 0 && num[1] == 1 && num[2] == 0 && num[3] == 0 && num[4] == 1 && num[5] == 1 && num[6] == 0 && num[7] == 2 && num[8] == 2 && num[9] == 1){
                break;
            }
            else{
                queue.poll();
                queue.add(rand());
                if(queue.peek() == 0) suki++;
                else if(queue.peek() == 1) kirai++;
                else if(queue.peek() == 2) kira++;
            }
        }
    }


    public int rand(){
        Random rnd = new Random();

        int n = rnd.nextInt(3);
        if(n == 0){
            System.out.print("すき ");
        }
        else if(n == 1){
            System.out.print("きらい ");
        }
        else if(n == 2){
            System.out.print("きら ");
        }
        return n;
    }

    
}