package week_04_composite;

import java.util.ArrayList;
import java.util.List;

public class SE311_Week04Composite {

    public static void main(String[] args) {

        Widget column = new Column();
        Widget container = new Container();
        Widget text = new Text();

        Widget subColumn = new Column();
        Widget subContainer = new Container();
        Widget subText = new Text();


        column.add(container);
        column.add(text);

        subColumn.add(subContainer);
        subColumn.add(subText);

        column.add(subColumn);

        column.build();

    }
}


/**
 * This is the Component, Transparent version
 */
interface Widget {

    void add(Widget widget);

    void remove(Widget widget);

    Widget getChild(int index);

    void build();
}

/**
 * This is the Composite which can have a leaf or composite
 */
class Column implements Widget {
    List<Widget> widgets = new ArrayList<>();

    @Override
    public void add(Widget widget) {
        widgets.add(widget);
    }

    @Override
    public void remove(Widget widget) {
        widgets.remove(widget);
    }

    @Override
    public Widget getChild(int index) {
        return widgets.get(index);
    }

    @Override
    public void build() {
        System.out.println("----------");
        for (int i = 0; i < widgets.size(); i++) {
            getChild(i).build();
        }
    }
}


class Container implements Widget {

    @Override
    public void add(Widget widget) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Widget widget) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Widget getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void build() {
        System.out.println("Container Build!!");
    }
}


class Text implements Widget {

    @Override
    public void add(Widget widget) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Widget widget) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Widget getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void build() {
        System.out.println("Text Build!!");
    }
}


