package Clases;

import com.sun.awt.AWTUtilities;
import javax.swing.JFrame;

public class Trasparencia {

    public void TransCompFrame(JFrame frm) {
        frm.setUndecorated(true);
        AWTUtilities.setWindowOpaque(frm, false);
    }
}
