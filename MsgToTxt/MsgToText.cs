using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using Outlook = Microsoft.Office.Interop.Outlook;

namespace PIM.Outlook
{
    class MsgToText
    {
        private string MAILPATH;
        private string TEXTPATH;

        public MsgToText(string source, string target)
        {
            this.MAILPATH = source;
            this.TEXTPATH = target;
        }

        public void convert()
        {
            Microsoft.Office.Interop.Outlook.Application app = new Microsoft.Office.Interop.Outlook.Application();

            // Iterate files in prod issues
            string[] mailFiles = Directory.GetFiles(MAILPATH);

            foreach (string file in mailFiles)
            {
                Console.WriteLine("Processing file: " + file);

                // Open msg file
                var item = app.Session.OpenSharedItem(file) as Microsoft.Office.Interop.Outlook.MailItem;

                // Read body
                string body = item.Body;

                // Create filename to write
                string txtFilePath = TEXTPATH + Path.GetFileNameWithoutExtension(file);

                // Create new text file + Write body to new text file
                File.AppendAllText(txtFilePath, body);

                Console.WriteLine("Outputting to: " + txtFilePath);

            }
            Console.ReadLine();
        }

        static void Main(string[] args)
        {
            MsgToText msgToText = new MsgToText("C:\\code\\prod_issues\\msg\\", "C:\\code\\prod_issues\\txt\\");
            msgToText.convert();
        }
    }
}
