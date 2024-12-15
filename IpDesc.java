import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IpDesc {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Descrubimiento de dominios a direcciones IP y comprobaciones de respuesta en host mediante conexión TCP a direcciones IP o a dominios");
        JButton boton_apartado_desc_ip = new JButton("Descrubimiento de direcciones IP");
        JButton boton_apartado_conect_ip = new JButton("Comprobaciones de respuesta en dominios o direcciones IP");
        frame.requestFocusInWindow();
        frame.setVisible(true);
        frame.setSize(660, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().setBackground(Color.YELLOW);
        frame.add(boton_apartado_desc_ip);
        frame.add(boton_apartado_conect_ip);
        boton_apartado_desc_ip.setSize(123, 80);
        boton_apartado_conect_ip.setSize(123, 80);
        boton_apartado_desc_ip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Descrubimiento de dominios a direcciones IP");
                JLabel label = new JLabel("Introduce el dominio para descubrir la IP:");
                JTextField entrada_ip_para_desc = new JTextField();
                JButton boton_descubrir_ip = new JButton("Descubrir IP");
                frame2.requestFocusInWindow();
                frame2.setVisible(true);
                frame2.setSize(660, 550);
                frame2.setResizable(false);
                frame2.setLayout(new FlowLayout());
                frame2.getContentPane().setBackground(Color.YELLOW);
                frame2.add(label);
                frame2.add(entrada_ip_para_desc);
                frame2.add(boton_descubrir_ip);
                label.setPreferredSize(new Dimension(200, 80));
                entrada_ip_para_desc.setPreferredSize(new Dimension(123, 80));
                boton_descubrir_ip.setPreferredSize(new Dimension(123, 80));
                boton_descubrir_ip.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String texto_conseguido_dominio = entrada_ip_para_desc.getText();
                        entrada_ip_para_desc.setText("");
                        try {

                            InetAddress ip = InetAddress.getByName(texto_conseguido_dominio);
                            JOptionPane.showMessageDialog(null, "Dirección IP del dominio "+ texto_conseguido_dominio+ ": "+ ip.getHostAddress());


                        } catch(IOException e1) {
                            JOptionPane.showMessageDialog(null, "Hubo un error al conseguir la IP del dominio: "+ e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
        });
        boton_apartado_conect_ip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new JFrame("Comprobaciones de respuesta en host mediante conexión TCP a direcciones IP o a dominios");
                JLabel label2 = new JLabel("Introduce la dirección IP o dominio que quieras comprobar que responda:");
                JTextField entrada_ip_o_dominio_para_comprobar = new JTextField();
                JLabel label3 = new JLabel("Introduce el puerto:");
                JTextField puerto = new JTextField();
                JButton boton_enviar_comp = new JButton("Comprobar dominio o dirección IP");
                frame3.requestFocusInWindow();
                frame3.setVisible(true);
                frame3.setSize(660, 550);
                frame3.setResizable(false);
                frame3.getContentPane().setBackground(Color.YELLOW);
                frame3.setLayout(new FlowLayout());
                frame3.add(label2);
                frame3.add(entrada_ip_o_dominio_para_comprobar);
                frame3.add(label3);
                frame3.add(puerto);
                frame3.add(boton_enviar_comp);
                label2.setPreferredSize(new Dimension(123, 80));
                label3.setPreferredSize(new Dimension(123, 80));
                puerto.setPreferredSize(new Dimension(123, 80));
                entrada_ip_o_dominio_para_comprobar.setPreferredSize(new Dimension(123, 80));
                boton_enviar_comp.setPreferredSize(new Dimension(123, 80));
                boton_enviar_comp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String texto_ip_o_dominio = entrada_ip_o_dominio_para_comprobar.getText();
                        int texto_puerto = Integer.parseInt(puerto.getText());

                        try {

                            Socket conexion = new Socket(texto_ip_o_dominio, texto_puerto);
                            JOptionPane.showMessageDialog(null, "La dirección IP o el dominio responde correctamente.");
                            conexion.close();

                        } catch(IOException e2) {
                            JOptionPane.showMessageDialog(null, "Hubo un error al comprobar el dominio o dirección IP: "+ e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
        });
    }
}