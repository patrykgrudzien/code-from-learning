package Dzial_10;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;

public class AppletFrame extends JFrame implements AppletStub, AppletContext
{
    private Applet applet;

    public AppletFrame(Applet anApplet)
    {
        applet = anApplet;
        add(applet);
        applet.setStub(this);
    }

    public void setVisible(boolean b)
    {
        if (b)
        {
            applet.init();
            super.setVisible(true);
            applet.start();
        }
        else
        {
            applet.stop();
            super.setVisible(false);
            applet.destroy();
        }
    }

    // Metody interfejsu AppletStub
    @Override
    public URL getDocumentBase()
    {
        return null;
    }

    @Override
    public URL getCodeBase()
    {
        return null;
    }

    @Override
    public String getParameter(String name)
    {
        return null;
    }

    @Override
    public AppletContext getAppletContext()
    {
        return null;
    }

    @Override
    public void appletResize(int width, int height)
    {

    }


    // Metody interfejsu AppletContext
    @Override
    public AudioClip getAudioClip(URL url)
    {
        return null;
    }

    @Override
    public Image getImage(URL url)
    {
        return null;
    }

    @Override
    public Applet getApplet(String name)
    {
        return null;
    }

    @Override
    public Enumeration<Applet> getApplets()
    {
        return null;
    }

    @Override
    public void showDocument(URL url)
    {

    }

    @Override
    public void showDocument(URL url, String target)
    {

    }

    @Override
    public void showStatus(String status)
    {

    }

    @Override
    public void setStream(String key, InputStream stream) throws IOException
    {

    }

    @Override
    public InputStream getStream(String key)
    {
        return null;
    }

    @Override
    public Iterator<String> getStreamKeys()
    {
        return null;
    }

}
