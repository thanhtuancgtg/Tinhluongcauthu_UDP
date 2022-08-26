
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) throws IOException {
        int check;
        ServerSocket server = new ServerSocket(6969);
        System.out.println("Server lisenting...");
        Socket socket = server.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        List<cauThu> list = new ArrayList<>();

        String data;
        do {
            data = in.readUTF();
            check = Integer.parseInt(data);
            if (check == 1) {
                data = "Please enter player information ";
                out.writeUTF(data);
                out.flush();
                data = in.readUTF();
                String[] data1 = data.split("\\$");
                list.add(new cauThu(data1[0], data1[1], Integer.parseInt(data1[2]), data1[3],
                        Float.parseFloat(data1[4])));
                data = "Add successfully";
                out.writeUTF(data);
                out.flush();

            } else if (check == 2) {
                if (list.size() == 0) {
                    data = 0 + "$";
                    out.writeUTF(data);
                    out.flush();
                } else {
                    data = 1 + "";
                    for (cauThu ct : list) {
                        data += ("$" + ct.getTen());
                    }
                    out.writeUTF(data);
                    out.flush();
                    data = in.readUTF();
                    out.writeUTF("So tran thi dau trong thang: ");
                    out.flush();
                    int soTran = Integer.parseInt(in.readUTF());
                    float tien;
                    float th;
                    for (cauThu ct : list) {
                        if (data.equalsIgnoreCase(ct.getTen())) {
                            if (ct.getViTri().equalsIgnoreCase("Tien dao")) {
                                th = 0.025f * ct.getLuongCoBan();
                            } else if (ct.getViTri().equalsIgnoreCase("Tien ve")
                                    || ct.getViTri().equalsIgnoreCase("Hau ve")) {
                                th = 0.02f * ct.getLuongCoBan();
                            } else {
                                th = 0.015f * ct.getLuongCoBan();
                            }
                            tien = ct.LuongCoBan + soTran * th;
                            out.writeUTF("Salary: " + tien);
                            out.flush();
                            break;
                        }
                    }
                }
            }
            if (check == 3) {
                in.close();
                out.close();
                socket.close();
            }
        } while (check != 3);
    }
}
