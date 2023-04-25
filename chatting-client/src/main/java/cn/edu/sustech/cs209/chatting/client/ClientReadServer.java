package cn.edu.sustech.cs209.chatting.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class ClientReadServer implements Runnable{
  private Socket socket;
  public ClientReadServer(Socket socket){
    this.socket=socket;
  }
  @Override
  public void run() {
    //1.获取服务器端输入流
    try {
      Scanner scanner=new Scanner(socket.getInputStream());
      while(scanner.hasNext()){
        System.out.println(scanner.next());
      }
      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
