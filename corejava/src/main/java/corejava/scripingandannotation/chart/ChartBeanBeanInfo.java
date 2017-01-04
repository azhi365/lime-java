package corejava.scripingandannotation.chart;

import java.beans.PropertyDescriptor;

public class ChartBeanBeanInfo extends java.beans.SimpleBeanInfo {
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor titleDescriptor = new PropertyDescriptor("title", ChartBean.class);
            PropertyDescriptor valuesDescriptor = new PropertyDescriptor("values", ChartBean.class);
            valuesDescriptor.setPropertyEditorClass(DoubleArrayEditor.class);
            PropertyDescriptor inverseDescriptor = new PropertyDescriptor("inverse", ChartBean.class);
            inverseDescriptor.setPropertyEditorClass(InverseEditor.class);
            PropertyDescriptor titlePositionDescriptor = new PropertyDescriptor("titlePosition", ChartBean.class);
            titlePositionDescriptor.setPropertyEditorClass(TitlePositionEditor.class);
            PropertyDescriptor graphColorDescriptor = new PropertyDescriptor("graphColor", ChartBean.class);
            return new PropertyDescriptor[]{titleDescriptor, valuesDescriptor, inverseDescriptor, titlePositionDescriptor, graphColorDescriptor};
        } catch (java.beans.IntrospectionException e) {
            e.printStackTrace();
            return null;
        }
    }
}
