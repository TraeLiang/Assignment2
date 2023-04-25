package cn.edu.sustech.cs209.chatting.client;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class ClientSendServer implements Runnable {
  private Socket socket;

  public ClientSendServer(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      //1.获取服务器端的输出流
      PrintStream printStream = new PrintStream(socket.getOutputStream());
      //2.从键盘中输入信息
      Scanner scanner = new Scanner(System.in);
      while (true) {
        String msg = null;
        if (scanner.hasNext()) {
          msg = scanner.next();
          printStream.println(msg);
        }
        if (msg.equals("exit")) {
          scanner.close();
          printStream.close();
          break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
