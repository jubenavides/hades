using System;
using System.Text;
using System.Windows.Forms;
using System.Net;
using System.Net.Sockets;

namespace WindowsFormsApp1
{
    public partial class FrmReporte : Form
    {
        public FrmReporte()
        {
            InitializeComponent();
        }

        private void btnReporte_Click(object sender, EventArgs e)
        {
            byte[] bytes = new byte[Parameters.bufferSize];
            String str = null;
            Socket socket = null;
            try
            {
                IPAddress ipAddress = IPAddress.Parse(Parameters.IP);
                IPEndPoint remoteEP = new IPEndPoint(ipAddress, Parameters.port);
                socket = new Socket(ipAddress.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
                try
                {
                    socket.Connect(remoteEP);
                    Console.WriteLine("Socket connected to {0}", socket.RemoteEndPoint.ToString());
                    byte[] msg = Encoding.ASCII.GetBytes("REQUEST<EOF>");
                    int bytesSent = socket.Send(msg);
                    int bytesRec = socket.Receive(bytes);
                    str = Encoding.ASCII.GetString(bytes, 0, bytesRec);
                    Console.WriteLine("Data received = {0}", str);
                    socket.Shutdown(SocketShutdown.Both);
                    socket.Close();
                }
                catch (ArgumentNullException ane) { Console.WriteLine("ArgumentNullException : {0}", ane.ToString()); }
                catch (SocketException se) { Console.WriteLine("SocketException : {0}", se.ToString()); }
                catch (Exception ex) { Console.WriteLine("Unexpected exception : {0}", ex.ToString()); }
            }
            catch (Exception ex) { Console.WriteLine(ex.ToString()); }
            //textBoxReporte.Text = str.Substring(Parameters.headerSize);
            String resultado = str.Substring(Parameters.headerSize, 3);
            if (resultado.Equals("OKK"))
            {
                String totalConsumos = str.Substring(Parameters.headerSize + 3, 1024);
                String nombreTour = str.Substring(Parameters.headerSize + 3 + 8, 200);
                textBoxReporte.AppendText("Tour:");
                textBoxReporte.AppendText(Environment.NewLine);
                textBoxReporte.AppendText(nombreTour);
                textBoxReporte.AppendText(Environment.NewLine);
                textBoxReporte.AppendText("Total consumos:");
                textBoxReporte.AppendText(Environment.NewLine);
                textBoxReporte.AppendText(totalConsumos);
            }
        }
    }
}
