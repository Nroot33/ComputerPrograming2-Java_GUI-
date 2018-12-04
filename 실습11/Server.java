import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;

import java.util.Scanner;

 

public class Server {

	private ServerSocket serverSocket;

	private Socket clientSocket;

	private DataInputStream dataInputStream;

	private DataOutputStream dataOutputStream;

 

	public void serverSetting() {

		// 서버소켓을 포트 8080으로 만들고

		// 클라이언트 소켓이 연결될 때까지 대기

		try {

			System.out.println("서버 생성중...");

			this.serverSocket = new ServerSocket(8080);

			System.out.println("서버 대기중...");

			this.clientSocket = this.serverSocket.accept();

			System.out.println("클라이언트 접속 완료!");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

 

	public void closeAll() {

		try {

			serverSocket.close();

			clientSocket.close();

			dataInputStream.close();

			dataOutputStream.close();

		} catch (Exception e) {

		}

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

 

	public Server() {

		serverSetting();

		streamSetting();

		dataRecv();

		dataSend();

	}

 

	public static void main(String[] args) {

		new Server();

	}

}