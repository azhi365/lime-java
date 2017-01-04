package corejava.swing;

import javax.swing.*;
import java.awt.*;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Cay Horstmann
 * @version 1.13 2007-06-12
 */
public class EventTracerTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new EventTracerFrame();
                frame.setTitle("EventTracerTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }


    static class EventTracerFrame extends JFrame {
        public EventTracerFrame() {
            // add a slider and a button
            add(new JSlider(), BorderLayout.NORTH);
            add(new JButton("Test"), BorderLayout.SOUTH);

            // trap all events of components inside the frame
            EventTracer tracer = new EventTracer();
            tracer.add(this);
            pack();
        }
    }


    /**
     * @author Cay Horstmann
     * @version 1.31 2004-05-10
     */
    public static class EventTracer {
        private InvocationHandler handler;

        public EventTracer() {
            // the handler for all event proxies
            handler = new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) {
                    System.out.println(method + ":" + args[0]);
                    return null;
                }
            };
        }

        /**
         * Adds event tracers for all events to which this component and its children can listen
         *
         * @param c a component
         */
        public void add(Component c) {
            try {
                // get all events to which this component can listen
                BeanInfo info = Introspector.getBeanInfo(c.getClass());

                EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
                for (EventSetDescriptor eventSet : eventSets)
                    addListener(c, eventSet);
            } catch (IntrospectionException e) {
            }
            // ok not to add listeners if exception is thrown

            if (c instanceof Container) {
                // get all children and call add recursively
                for (Component comp : ((Container) c).getComponents())
                    add(comp);
            }
        }

        /**
         * Add a listener to the given event set
         *
         * @param c        a component
         * @param eventSet a descriptor of a listener interface
         */
        public void addListener(Component c, EventSetDescriptor eventSet) {
            // make e9_proxy object for this listener type and route all calls to the handler
            Object proxy = Proxy.newProxyInstance(null, new Class[]{eventSet.getListenerType()}, handler);

            // add the e9_proxy as a listener to the component
            Method addListenerMethod = eventSet.getAddListenerMethod();
            try {
                addListenerMethod.invoke(c, proxy);
            } catch (ReflectiveOperationException e) {
            }
            // ok not to add listener if exception is thrown
        }
    }
}

