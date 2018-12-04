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

 

	// 1. �����͸� ��� ���� ������

	// 2. �����͸� ��� ���� ������

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

 

	public void streamSetting() {

		// ������ ��ǲ, �ƿ�ǲ ��Ʈ���� ���� ��Ʈ���� ����

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