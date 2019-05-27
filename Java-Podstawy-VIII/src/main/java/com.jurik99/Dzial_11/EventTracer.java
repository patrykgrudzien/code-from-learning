package Dzial_11;

import java.awt.*;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EventTracer
{
    private InvocationHandler handler;

    public EventTracer()
    {
        // handler wszystkich obiektów proxy zdarzeń
        handler = new InvocationHandler()
        {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
            {
                System.out.println(method +":"+ args[0]);
                return null;
            }
        };
    }


    /**
     * Dodawanie obiektów śledzących zdarzenia dla wszystkich zdarzeń, których ten komponent
     * i jego potomkowie mogą nasłuchiwać
     *
     * @param c komponent
     */
    public void add(Component c)
    {
        try
        {
            // Pobranie wszystkich zdarzeń, których ten komponent może nasłuchiwać
            BeanInfo info = Introspector.getBeanInfo(c.getClass());

            EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
            for (EventSetDescriptor eventSet:eventSets)
                addListener(c, eventSet);
        }
        catch (IntrospectionException e)
        {
            e.printStackTrace();
        }

        // W razie wystąpienia wyjątku nie dodawać słchaczy
        if (c instanceof Container)
        {
            // Pobranie wszystkich potomków i rekursywne wywołanie metody add
            for (Component comp : ((Container) c).getComponents())
                add(comp);
        }
    }

    /**
     * Dodanie słuchacza do danego zbioru zdarzeń
     * @param c komponent
     * @param eventSet deskryptor interfejsu nasłuchującego
     */
    public void addListener(Component c, EventSetDescriptor eventSet)
    {
        // Utworzenie obiektu pośredniego dla tego typu słuchaczy i przekazanie wszystkich wywołań do handlera
        Object proxy = Proxy.newProxyInstance(null, new Class[] {eventSet.getListenerType()}, handler);

        // Dodanie obiektu pośredniego jako słuchacza komponentu
        Method addListenerMethod = eventSet.getAddListenerMethod();
        try
        {
            addListenerMethod.invoke(c, proxy);
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }
}
