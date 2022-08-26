import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        int check;
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("localhost", 6969);
        System.out.println(" Client connected to Server");
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        do {
            System.out.println("1. Enter new player name");
            System.out.println("2. Calculate player salary");
            System.out.println("3. Out");
            System.out.print("Moi chon: ");
            check = sc.nextInt();
            String data;
            if (check == 1) {
                data = 1 + "";
                out.writeUTF(data);
                out.flush();
                System.out.println(in.readUTF());
                cauThu ct = new cauThu();
                sc.nextLine();
                System.out.print("Enter player code: ");
                ct.setMaCauThu(sc.nextLine());
                System.out.print("Enter player name: ");
                ct.setTen(sc.nextLine());
                System.out.print("Enter the player's year of birth : ");
                ct.setNamSinh(sc.nextInt());
                System.out.println("Enter player position: ");
                System.out.println("1. Tien dao");
                System.out.println("2. Tien ve");
                System.out.println("3. Hau ve");
                System.out.println("4. Thu mon");
                System.out.print("Moi chon: ");
                int c = sc.nextInt();
                if (c == 1)
                    ct.setViTri("Tien dao");
                else if (c == 2)
                    ct.setViTri("Tien ve");
                else if (c == 3)
                    ct.setViTri("Hau ve");
                else
                    ct.setViTri("Thu mon");
                System.out.print("Enter basic salary : ");
                ct.setLuongCoBan(sc.nextFloat());
                sc.nextLine();
                data = ct.toString();
                out.writeUTF(data);
                out.flush();
                System.out.println(in.readUTF());

            } else if (check == 2) {
                data = 2 + "";
                out.writeUTF(data);
                out.flush();
                String[] data1 = in.readUTF().split("\\$");
                data = "";
                for (int i = 1; i < data1.length; i++) {
                    if (i != (data1.length - 1)) {
                        data += (data1[i] + ",");
                    } else {
                        data += data1[i];
                    }
                }
                if (data1[0].equalsIgnoreCase("0")) {
                    System.out.println("Khong co cau thu nao");
                } else {
                    System.out.print("Can tinh luong cau thu nao: ");
                    System.out.println(data);
                    System.out.print("Name player: ");
                    sc.nextLine();
                    data = sc.nextLine();
                    out.writeUTF(data);
                    out.flush();
                    System.out.println(in.readUTF());
                    data = sc.nextInt() + "";
                    out.writeUTF(data);
                    out.flush();
                    System.out.println(in.readUTF());

                }
            } else if (check == 3) {
                data = 3 + "";
                out.writeUTF(data);
                out.flush();
                in.close();
                out.close();
                socket.close();
            }
        } while (check != 3);
    }
}
