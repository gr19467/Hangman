import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;

public class Hang extends GCompound {

    public GRect vp, hpl, hps, h;
    public double hplX, hplY, hpsX, hpsY, vpX, vpY, hX, hY;


    public Hang() {
        //set the x, y, width, height, and color of the hpl
        hpl = new GRect(getWidth() / 4, 1);
        hplX = getWidth() / 2;
        hplY = getHeight() / 2;
        hpl.setColor(Color.GRAY);

        //set the x, y, width, height, and color of the vertical pole
        vp = new GRect(1, getHeight() / 4);
        vpX = hplX + hpl.getWidth() / 2;
        vpY = hplY - vp.getHeight();
        vp.setColor(Color.GRAY);

        //set the x, y, width, height, and color of the hps
        hps = new GRect(hpl.getWidth() / 2, 1);
        hpsX = vpX - hps.getWidth();
        hpsY = vpY;
        hps.setColor(Color.GRAY);

        //set the x, y, width, height, and color of the hook
        h = new GRect(1, vp.getHeight() / 3.5);
        hX = hpsX;
        hY = hpsY;
        h.setColor(Color.GRAY);

        //add the hpl, vp, hps, and h
        add(hpl, hplX, hplY);

        add(vp, vpX, vpY);

        add(hps, hpsX, hpsY);

        add(h, hX, hY);
    }
}