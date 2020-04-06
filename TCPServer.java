/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements Runnable {

    private final static int serverPort = 9876;
    private final static String fileInput = "file.txt";

    public static void main(String args[]) throws IOException{
        ServerSocket servsock = new ServerSocket(serverPort);
        File myFile = new File(fileInput);
        while (true) {
          Socket sock = servsock.accept();
          byte[] mybytearray = new byte[(int) myFile.length()];
          BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
          bis.read(mybytearray, 0, mybytearray.length);
          OutputStream os = sock.getOutputStream();
          os.write(mybytearray, 0, mybytearray.length);
          os.flush();
          sock.close();
        }
    }

   
    @Override
    public void run() {

    }
}