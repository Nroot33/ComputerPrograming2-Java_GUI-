import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.net.Socket;

import java.net.UnknownHostException;

import java.util.Scanner;

 

public class Client {

	private Socket clientSocket;

	private DataInputStream dataInputStream;

	private DataOutputStream dataOutputStream;

 

	// 1. 데이터를 계속 전송 쓰레드

	// 2. 데이터를 계속 수신 쓰레드

	public void connect() {

		try {

			clientSocket = new Socket("127.0.0.1", 8080);

		} catch (UnknownHostException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

 

	public void dataRecv() {

 

		// 스레드를 만들고 while문을 통해 계속해서 클라이언트가 보내는 문자열을 출력함, "/quit"란 문자열이 오면

		// while문을 빠져나가게 만든다.

		new Thread(() -> {

			boolean flag = true;

			while (flag) {

				String str;

				try {

					str = this.dataInputStream.readUTF();

					if (str.equals("/quit")) {

						flag = false;

					} else {

						System.out.println("상대방: " + str);

					}

 

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		}).start();

	}

 

	public void dataSend() {

		// 스레드를 만들고 while문을 통해 계속해서 클라이언트에게 문자열을 전송한다. "/quit"란 문자열을 입력하면

		// while문을 빠져나가게 만든다.

		new Thread(() -> {

			boolean flag = true;

			Scanner sc = new Scanner(System.in);

			String str;

			while (flag) {

				try {

					str = sc.nextLine();

					this.dataOutputStream.writeUTF(str);

					if (str.equals("/quit")) {

						flag = false;

					} else {

						System.out.println("나: " + str);

					}

 

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		}).start();

	}

 

	public void streamSetting() {

		// 데이터 인풋, 아웃풋 스트림을 소켓 스트림과 연결

		try {

			this.dataInputStream = new DataInputStream(this.clientSocket.getInputStream());

			this.dataOutputStream = new DataOutputStream(this.clientSocket.getOutputStream());

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

 

	public Client() {

		connect();

		streamSetting();

		dataSend();

		dataRecv();

	}

 

	public static void main(String[] args) {

		new Client();

	}

 

}