/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

    private final static String serverIP = "localhost";
    private final static int serverPort = 9876;
    private final static String fileOutput = "TCPOut.txt";

    public static void main(String args[]) throws UnknownHostException, IOException {
        Socket sock = new Socket(serverIP, serverPort);
        byte[] mybytearray = new byte[1024];
        InputStream is = sock.getInputStream();
        FileOutputStream fos = new FileOutputStream(fileOutput);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int bytesRead = is.read(mybytearray, 0, mybytearray.length);
        bos.write(mybytearray, 0, bytesRead);
        bos.close();
        sock.close();
    }
}