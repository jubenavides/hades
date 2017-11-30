using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class FrmInicio : Form
    {
        public FrmInicio()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            var frmFact = new FrmFact();
            frmFact.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            var frmReporte = new FrmReporte();
            frmReporte.Show();
        }
    }
}
