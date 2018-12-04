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

		// ���������� ��Ʈ 8080���� �����

		// Ŭ���̾�Ʈ ������ ����� ������ ���

		try {

			System.out.println("���� ������...");

			this.serverSocket = new ServerSocket(8080);

			System.out.println("���� �����...");

			this.clientSocket = this.serverSocket.accept();

			System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�!");

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

		// ������ ��ǲ, �ƿ�ǲ ��Ʈ���� ���� ��Ʈ���� ����

		try {

			this.dataInputStream = new DataInputStream(this.clientSocket.getInputStream());

			this.dataOutputStream = new DataOutputStream(this.clientSocket.getOutputStream());

		} catch (IOException e) {

			e.printStackTrace();

		}

 

	}

 

	public void dataRecv() {

 

		// �����带 ����� while���� ���� ����ؼ� Ŭ���̾�Ʈ�� ������ ���ڿ��� �����, "/quit"�� ���ڿ��� ����

		// while���� ���������� �����.

		new Thread(() -> {

			boolean flag = true;

			while (flag) {

				String str;

				try {

					str = this.dataInputStream.readUTF();

					if (str.equals("/quit")) {

						flag = false;

					} else {

						System.out.println("����: " + str);

					}

 

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		}).start();

	}

 

	public void dataSend() {

		// �����带 ����� while���� ���� ����ؼ� Ŭ���̾�Ʈ���� ���ڿ��� �����Ѵ�. "/quit"�� ���ڿ��� �Է��ϸ�

		// while���� ���������� �����.

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

						System.out.println("��: " + str);

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